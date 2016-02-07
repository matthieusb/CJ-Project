// -----------------------------------
// --------------- Controller Websockets
// -----------------------------------
RESTApp.controller("WebsocketCtrl", ['$scope','$http','$rootScope', function($scope,$http,$rootScope) {
    $scope.currentPage = 1;
    $scope.pageSize = 6;

    // ----- ROUTES VARIABLES
    $scope.beginningRoute="ws://localhost:9000/";
    $scope.routeActorFeeds=$scope.beginningRoute+"searchRss";

    // ----- Class for notification display
    var Notification = function(type, text){
        this.type = type != undefined ? type : "info";
        this.text = text != undefined ? text : "";
    };

    $scope.pushData = function() {
        $scope.messageSent = {items : [
            {researchContent : ""+$("#wordsSearched").val()},
            {id : "infoqCheckboxId", checked : ""+$("#infoqCheckboxId").is(':checked')},
            {id : "ieeCheckboxId", checked : ""+$("#ieeCheckboxId").is(':checked')},
            {id : "dvptcomCheckboxId", checked : ""+$("#dvptcomCheckboxId").is(':checked')},
            {id : "wikicfpCheckboxId", checked : ""+$("#wikicfpCheckboxId").is(':checked')}
        ]};
    };

    $scope.rechercheSelonSources = function() {
        //console.log("Research initiated");
        $scope.rechercher();
        $scope.pushData();//Initialising sources to send for FEEDS
        $scope.socketJson($scope.routeActorFeeds,$scope.messageSent); //Sending message to ActorRss through websocket

        //console.log("Sent to WebSocket -> "+JSON.stringify(messageSentRss));
    };

    // Fill results for a research
    $scope.fillResults = function(dataReceived,j) {
        for (var i in dataReceived) {
            $scope.results[j].push({
                title : dataReceived[i].title,
                description : dataReceived[i].description,
                link : dataReceived[i].link,
                date : dataReceived[i].date,
                urlImage : dataReceived[i].urlImage
            });
        }
    };

    //Handle message returned by the web socket
    $scope.handleSocketMessage = function(data, socket) {

        // -------- NOTIFICATIONS RECEIVED
        if (data.notifError) {
            console.log("Erreur -> "+data.error);
        }  else if (data.notifInfo) {
            console.log("Notification received -> "+data.notifInfo)

            // -------- DATA RECEIVED
        } else if (data.dataIeee) {
            $('#divResultIeee').fadeIn(600);
            $scope.fillResults(JSON.parse(data.dataIeee),1);
        } else if(data.dataInfoQ) {
            $('#divResultInfoQ').fadeIn(600);
            $scope.fillResults(JSON.parse(data.dataInfoQ),0);
        } else if(data.dataDvpt) {
            $('#divResultDvptcom').fadeIn(600);
            $scope.fillResults(JSON.parse(data.dataDvpt),2);
        } else if (data.dataWikiCfp) {
            $('#divResultWikicfp').fadeIn(600);
            $scope.fillResults(JSON.parse(data.dataWikiCfp),3);
        }

        else {
            console.log("CASE NOT HANDLED, CLOSING SOCKET");
            socket.close();
        }
        $scope.$digest();
    };

    //Opening socket according to route and object as json
    $scope.socketJson = function(route, object) {
        var socket = new WebSocket(route);
        $scope.results = [[],[],[],[]]; //Initializing scope results [tabInfoQ,tabIeee,tabDvptCom,tabWikicfp]

        // OPENING
        socket.onopen = function () {
            socket.send(JSON.stringify(object));
        };

        // RECEIVING
        socket.onmessage = function (event) {
            var data = JSON.parse(event.data);
            $scope.handleSocketMessage(data,socket);
        }
    };

    $rootScope.loadFavVideos=function() {
        //parametres pour la requete GET
        var url = "/getFavVideos";
        //resultats de la requete
        $scope.favorisVideos=[];

        $http.get(url).
            success(function (data) {
                //on boucle dans les résultats pour ne garder que ceux qui sont vraiment pertinants
                $scope.favorisVideos=data;
                $scope.favorisVideosID=$scope.favorisVideos.map(function(d){return d.videoId});
                //console.log($scope.favorisID);
            }).
            error(function (data) {
                $scope.favorisVideos = {};
                console.log('An error occured')
            })

    };

    //fonction recuperant les videos youtube
    $scope.rechercher=function() {
        $scope.wordsSearched = $("#wordsSearched").val();
        //parametres pour la requete GET
        var youtubeToken = "AIzaSyDmfeIH4b6yuUbFfNRfDdJTqGf1LmJ9QuY";
        //var publishedAfter = "2015-12-01T00:00:00Z";
        var range=7;
        var publishedAfter=getDateFromRange(range);
        //le critère de recherche est fixe pour l'instant
        //var q = "scala+programming";
        var q = $scope.wordsSearched.replace(/\+/g,"%2B").replace(/ /g,"+")+"+programming";

        var type = "video";
        var part = "snippet";
        var maxResults = 50;
        var url = "https://www.googleapis.com/youtube/v3/search?";
        var param = "part=" + part + "&q=" + q + "&publishedAfter=" + publishedAfter + "&type=" + type + "&maxResults=" + maxResults + "&key=" + youtubeToken;
        var nextPageToken;
        //var search= q.split("+")[0];
        var search=$scope.wordsSearched.toLowerCase().replace(/ /g,"|");
        var sc=search.split("|");
        //var rg=new RegExp("("+search+")");


        //resultats de la requete
        $scope.resultsVid = [];

        //requete sur l'api REST de youtube
        $http.get(url + param).
            success(function (data) {
                //on boucle dans les résultats pour ne garder que ceux qui sont vraiment pertinents
                for (var i in data.items) {
                    /*
                    MATTHIEU !!!!!!!!
                    condition d'intersection à optimiser

                     */
                    //if ($scope.intersect_safe(data.items[i].snippet.title.toLowerCase().split(/ /g),sc).length!=0 || $scope.intersect_safe(data.items[i].snippet.description.toLowerCase().split(/ /g),sc).length!=0) {

                    if (learning(data.items[i].snippet.title) || learning(data.items[i].snippet.description)) {
                        var dateYoutube = new Date(data.items[i].snippet.publishedAt);
                        var dateFormated = $.format.date(dateYoutube,'dd MMMM yyyy');

                        $scope.resultsVid.push(
                            {
                                videoId : data.items[i].id.videoId,
                                title : data.items[i].snippet.title,
                                description : data.items[i].snippet.description,
                                publishedAt : dateFormated.toString(),
                                image : data.items[i].snippet.thumbnails.medium.url
                            }
                        );
                    }
                }
                //recuperation du token dans l'objet JSON pour naviguer à la page de result suivante
                nextPageToken = data.nextPageToken;
                //appel recursif pour lire toutes les pages de res
                $scope.loopToken(nextPageToken, url, param, sc);
                $('#divResultYoutube').fadeIn(600);
                //console.log($scope.results);
            }).
            error(function (data) {
                $scope.resultsVid = {};
                console.log('An error occured, response -> ' + data)
            })
    };

    $scope.intersect_safe=function(a, b){
        var ai=0, bi=0;
        var result = [];

        while( ai < a.length && bi < b.length )
        {
            if (a[ai] < b[bi] ){ ai++; }
            else if (a[ai] > b[bi] ){ bi++; }
            else /* they're equal */
            {
                result.push(a[ai]);
                ai++;
                bi++;
            }
        }

        return result;
    };

    //fonction récursive pour lire toutes les pages de res
    $scope.loopToken=function(nextPageToken,url,param,sc) {
        if(nextPageToken != null) {
            $http.get(url + param + "&pageToken=" + nextPageToken).
                success(function (data) {
                    nextPageToken = data.nextPageToken;
                    //meme boucle que précédemment, a factoriser
                    for(var i in data.items){
                        /*
                         MATTHIEU !!!!!!!!
                         condition d'intersection à optimiser

                         */
                        //if ($scope.intersect_safe(data.items[i].snippet.title.toLowerCase().split(/ /g),sc).length!=0 || $scope.intersect_safe(data.items[i].snippet.description.toLowerCase().split(/ /g),sc).length!=0) {
                        if (learning(data.items[i].snippet.title.toLowerCase()) || learning(data.items[i].snippet.description.toLowerCase())) {
                            var dateYoutube = new Date(data.items[i].snippet.publishedAt);
                            var dateFormated = $.format.date(dateYoutube,'dd MMMM yyyy');

                            $scope.resultsVid.push({
                                videoId : data.items[i].id.videoId,
                                title : data.items[i].snippet.title,
                                description : data.items[i].snippet.description,
                                publishedAt : dateFormated.toString(),
                                image : data.items[i].snippet.thumbnails.medium.url
                            });
                        }
                    }
                    $scope.loopToken(nextPageToken,url,param);
                }).
                error(function (data) {
                    $scope.movies = {};
                    console.log('An error occured, réponse -> ' + data)
                })
        }
    };

    $rootScope.loadFavVideos();

    $scope.loadFavArticles=function() {
                //parametres pour la requete GET
                var url = "/getFavArticles";
                //resultats de la requete
                $scope.favorisArticles=[];


                $http.get(url).
                    success(function (data) {
                            $scope.favorisArticles=data;
                            $scope.favorisArticlesLink=$scope.favorisArticles.map(function(d){return d.link});
                            console.log($scope.favorisArticlesLink);
                        }).
                    error(function (data) {
                            $scope.favorisArticles = {};
                            console.log('An error occured');
                        })

            };

    $scope.loadFavArticles();
}]);

