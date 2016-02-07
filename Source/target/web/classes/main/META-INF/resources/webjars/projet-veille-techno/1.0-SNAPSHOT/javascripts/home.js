// -----------------------------------
// --------------- Controller for Home oprations handling
// -----------------------------------
RESTApp.controller("HomeCtrl", ['$scope', function($scope) {


    // ------------
    // ---- Variables
    // ------------
    $scope.beginningRoute="ws://localhost:9000/";
    $scope.routeActorHome=$scope.beginningRoute+"searchHome";

    $scope.words = [];
    $scope.resultsSlideshow = [[],[],[]];
    $scope.resultsArticlesKeyword = [];
    $scope.randomKeyword = "";

    // ------------
    // ---- Functions
    // ------------

    // ------------
    // ---- KEYWORDS CLOUD
    // ------------

    // Creates jso with elements to activate actor for just fetching keywords
    $scope.createMessageKeywords = function() {
        $scope.messageSent = {items : [
            {researchContent : "fetchKeywords"}
        ]};
    };

    //Handles search of keywords
    $scope.rechercheKeywords = function() {
        $scope.createMessageKeywords();
        $scope.socketJsonHome($scope.routeActorHome,$scope.messageSent); //Sending message to ActorRss through websocket
    };

    //Adds the keywords to the jqcloud
    $scope.addKeywordsToJqcloud = function() {
        var nbKeywords = $scope.keywordsCloud.length;

        for (var i = 0 ; i < nbKeywords ; i++) {
            var weightTmp;

            switch (i) {
                case 0 : weightTmp = 13; break;
                case 1 : weightTmp = 10.5; break;
                case 2 : weightTmp = 9.4; break;
                default: weightTmp = Math.floor(Math.random() * 7) + 1
            }

            $scope.words.push(
                {text: $scope.keywordsCloud[i], weight: weightTmp, handlers: {
                    click: function() {
                        $scope.rechercheKeywordClicked($(this).text());
                    }
                }}
            );
        }

        $('#keywordsJqCloud').jQCloud($scope.words, {
            autoResize:true,
            height:1000,
            shape: 'elliptic'
        });
    };

    // ------------
    // ---- KEYWORD CLICKED ARTICLES FETCHING
    // ------------
    $scope.fillResultsKeywords = function(dataReceived) {
        for (var i in dataReceived) {
            $scope.resultsArticlesKeyword.push({
                title : dataReceived[i].title,
                description : dataReceived[i].description,
                link : dataReceived[i].link,
                date : dataReceived[i].date,
                urlImage : dataReceived[i].urlImage
            });
        }
        $("#loadingKeywordsSearch").fadeOut(500);
    };

    //Handles search for keyword click
    $scope.createMessageKeywordSearch = function(toSearch) {
        $scope.messageSent = {items : [
            {researchContent : "fetchKeywordSearch"},
            {keywordSearched : toSearch}
        ]};
    };

    //Handles the search according to the keyword clicked on the cloud
    $scope.rechercheKeywordClicked = function(toSearch) {
        $scope.resultsArticlesKeyword = [];
        $("#loadingKeywordsSearch").fadeIn(200);
        $scope.createMessageKeywordSearch(toSearch);
        $("#notifKeywordSearched").html('<div class="alert alert-info"><strong>Mot clé recherché :</strong> '+toSearch+'</div>');
        $scope.socketJsonHome($scope.routeActorHome,$scope.messageSent); //Sending message to ActorRss through websocket
    };

    // ------------
    // ---- SLIDESHOW ARTICLES FETCHING
    // ------------
    $scope.fillResultsSlideshow = function(dataReceived,j) {
        var nbResults = dataReceived.length;
        var limitRes;

        if (nbResults < 4) {// We only display four results by page of the carousel/slideshow
            limitRes = nbResults;
        } else {
            limitRes = 4;
        }

        for (var i = 0 ; i < limitRes ; i++) {
            $scope.resultsSlideshow[j].push({
                title : dataReceived[i].title,
                description : dataReceived[i].description,
                link : dataReceived[i].link,
                date : dataReceived[i].date,
                urlImage : dataReceived[i].urlImage
            });
        }
    };

    $scope.createMessageSlideshow = function() {
        $scope.messageSent = {items : [
            {researchContent : "fetchSlideshow"}
        ]};
    };

    $scope.fetchArticlesSlideshow = function() {
        $scope.createMessageSlideshow();
        $scope.socketJsonHome($scope.routeActorHome,$scope.messageSent); //Sending message to ActorRss through websocket
    };

    // ------------
    // ---- GENERAL SOCKET HANDLING
    // ------------


    //Handle message returned by the web socket
    $scope.handleSocketMessageHome = function(data, socket) {
        // -------- NOTIFICATIONS RECEIVED
        if (data.notifError) {
            console.log("Erreur -> "+data.error);
        }  else if (data.notifInfo) {
            console.log("Notification received -> "+data.notifInfo);

        // -------- DATA RECEIVED
        } else if (data.dataKeywords) {
            console.log("Keywords retrieved, adding to JQCloud");
            $scope.keywordsCloud = JSON.parse(data.dataKeywords);
            $scope.addKeywordsToJqcloud();

        // -------- DATA RECEIVED FOR SLIDESHOW
        } else if(data.dataInfoQ) {
            $scope.fillResultsSlideshow(JSON.parse(data.dataInfoQ),0);
        } else if(data.dataDvpt) {
            $scope.fillResultsSlideshow(JSON.parse(data.dataDvpt),1);
        } else if (data.dataWikiCfp) {
            $scope.fillResultsSlideshow(JSON.parse(data.dataWikiCfp), 2);

        // -------- DATA RECEIVED FOR KEYWORDS CHOOSING
        } else if (data.dataInfoQKeyword) {
            $scope.fillResultsKeywords(JSON.parse(data.dataInfoQKeyword));
        } else if(data.dataIeeeKeyword) {
            $scope.fillResultsKeywords(JSON.parse(data.dataIeeeKeyword));
        } else if (data.dataDvptKeyword) {
            $scope.fillResultsKeywords(JSON.parse(data.dataDvptKeyword));
        } else if (data.dataWikiCfpKeyword) {
            $scope.fillResultsKeywords(JSON.parse(data.dataWikiCfpKeyword));
        }

        // -------- OTHER CASE
        else {
            console.log("CASE NOT HANDLED, CLOSING SOCKET");
            socket.close();
        }
        $scope.$digest();
    };

    //Opening socket according to route and object as json
    $scope.socketJsonHome = function(route, object) {
        var socket = new WebSocket(route);
        $scope.results = []; //Initializing scope results [tabInfoQ,tabIeee,tabDvptCom,tabWikicfp]

        // OPENING
        socket.onopen = function (event) {
            socket.send(JSON.stringify(object));
        };

        // RECEIVING
        socket.onmessage = function (event) {
            var data = JSON.parse(event.data);
            $scope.handleSocketMessageHome(data,socket);
        }
    };

    // ------------
    // ---- PAGE LOADING ANGULAR
    // ------------

    //Launches random search on keywords already found
    $scope.randomArticleKeywordSearch = function() {
        $scope.rechercheKeywordClicked("Technology");
    };


    $scope.fetchArticlesSlideshow();
    $scope.rechercheKeywords();
    $scope.randomArticleKeywordSearch(); //Needs to be after rechercheKeywords()

    $('.carousel').carousel({
        interval: 6000
    });


    // ------------
    // ---- PAGE LOADING
    // ------------
    // On home page loading
    $(document).ready(function() {
        //Loading keywords cloud

    });
}]);


