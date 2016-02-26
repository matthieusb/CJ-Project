
// -----------------------------------
// --------------- Directives
// -----------------------------------
//cette directive modifie pour les videos le bouton ajout/supprimer favori quand on clique dessus et lance la fonction d'ajout/suppr
RESTApp.directive("myWidget", function() {
    return {
        link: function(scope, element, attrs) {
            //var actionAdd = "ajoutFavVideo(video.id.videoId, video.snippet.title, video.snippet.description, video.snippet.publishedAt, video.snippet.thumbnails.medium.url)";
            //var actionRemove = "removeFavVideo(video.id.videoId, video.snippet.title, video.snippet.description, video.snippet.publishedAt, video.snippet.thumbnails.medium.url)";
            //attrs.$set('ng-click',actionAdd + attrs.myWidget);

            ajoutFav = function () {
                if(element.html()=="Supprimer favoris"){

                    element.html("Ajouter favoris");
                    //attrs.$set('ng-click',actionAdd + attrs.myWidget);
                    removeFavVideo(attrs["videoid"],attrs["title"],attrs["description"],attrs["publishedat"],attrs["image"]);
                }else{
                    element.html("Supprimer favoris");
                    //attrs.$set('ng-click',actionRemove + attrs.myWidget);
                    //var toto=JSON.parse(attrs.myWidget);
                    //console.log(toto);
                    ajoutFavVideo(attrs["videoid"],attrs["title"],attrs["description"],attrs["publishedat"],attrs["image"]);
                    console.log(attrs["videoid"]);
                }
            };
            element.on('click', ajoutFav);
        }
    }
});

//directive sur l'onglet favoris effacant la video de l'affichage et lance la fonction de suppression
RESTApp.directive("myFavoris", function() {
    return {
        link: function(scope, element, attrs) {

            supprVideo =function(){
                if (confirm('Voulez-vous vraiment supprimer ce favori')) {
                    var title=element.find("#title").html();
                    var desc=element.find("#description").html();
                    var publishedat=element.find("#publishedat").html();
                    var image=element.find("#image").attr("ng-src");
                    removeFavVideo(attrs["videoid"],title,desc,publishedat,image);
                    element.remove();
                } else {
                    // Do nothing!
                }
            };
            supprArticle =function(){
                if (confirm('Voulez-vous vraiment supprimer ce favori')) {
                    //var title=element.find("#title").html();
                    //var desc=element.find("#description").html();
                    var link=element.find("#link").attr("href");
                    //var date=element.find("#publishedat").html();
                    //var image=element.find("#urlImage").attr("ng-src");
                    removeFavArticle(link);
                    element.remove();
                } else {
                    // Do nothing!
                }
            };
            //$("#supprimer").on('click', suppr);
            element.find("#supprimervideo").on('click', supprVideo);
            element.find("#supprimerarticle").on('click', supprArticle);
        }
    }
});

RESTApp.directive("myArticle", function() {
    return {
        link: function(scope, element, attrs) {
            ajoutFav = function () {
                if(element.html()=="Supprimer favoris"){
                    element.html("Ajouter favoris");
                    removeFavArticle(attrs["link"]);
                }else{
                    element.html("Supprimer favoris");
                    console.log(attrs["urlimage"]);
                    ajoutFavArticle(attrs["title"],attrs["description"],attrs["link"],attrs["date"],attrs["urlimage"],attrs["categories"]);
                }
            };
            element.on('click', ajoutFav);
        }
    }
});
// -----------------------------------
// --------------- Controller REST
// -----------------------------------

// -----------------------------------
// --------------- Controller onglet Favoris
// -----------------------------------
RESTApp.controller("favorisCTRL", ['$scope','$http','$rootScope', function($scope, $http, $rootScope) {
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
    $rootScope.loadFavVideos();
}]);




//--------------------
// GARBAGE CODE de test d'api
// -------------------

//fonction api rest youtube en javascript classique
function loadYoutube(){
	var youtubeToken = "your youtube token here from developper account";
	var publishedAfter = "2015-12-01T00:00:00Z";
	var q="scala+programming";
	var type="video";
	var part="snippet";
	var maxResults=50;
	var url="https://www.googleapis.com/youtube/v3/search";
	var param="part="+part+"&q="+q+"&publishedAfter="+publishedAfter+"&type="+type+"&maxResults="+maxResults+"&key="+youtubeToken;
	var nextPageToken;
	var results = [];
	//var data_parse;
	//GET https://www.googleapis.com/youtube/v3/search?part=snippet&q=scala+programming&key={YOUR_API_KEY}
	    $.ajax({
	  	type: "GET",
		  url: url,
		  data: param,
		  cache: false,
		  global: false,
		  success: function(data){
		     //data_parse=JSON.parse(data);
		     console.log(data);
		     nextPageToken=data.nextPageToken;
		     console.log(nextPageToken);
		     for(var i in data.items){
		     	if(data.items[i].snippet.title.toLowerCase().indexOf("scala") != -1 || data.items[i].snippet.description.toLowerCase().indexOf("scala") != -1){
		     		results.push(data.items[i]);
		     	//console.log(data.items[i].snippet.title.indexOf("Scala"));
		     		$('#resultarea').append("<p>"+i+"     "+data.items[i].snippet.title);
				$('#resultarea').append(data.items[i].snippet.description);
		    		$('#resultarea').append(data.items[i].snippet.publishedAt+"</p><hr/>");
		    	}
		     	 
		     }
		     results = loopToken(nextPageToken,url,param,results);
  		}
		});
		console.log(results);
}

//fonction recursive api rest youtube en javascript classique
function loopToken(nextPageToken,url,param,results){
	if(nextPageToken != null){
		$.ajax({
	  	type: "GET",
		  url: url,
		  data: param+"&pageToken="+nextPageToken,
		  cache: false,
		  success: function(data){
		     console.log(data);
		     nextPageToken=data.nextPageToken;
		     console.log(nextPageToken);
		     for(var i in data.items){
                 if(data.items[i].snippet.title.toLowerCase().indexOf("scala") != -1 || data.items[i].snippet.description.toLowerCase().indexOf("scala") != -1){
                     results.push(data.items[i]);
                     $('#resultarea').append("<p>"+i+"     "+data.items[i].snippet.title);
                     $('#resultarea').append(data.items[i].snippet.description);
                     $('#resultarea').append(data.items[i].snippet.publishedAt+"</p><hr/>");
			    }
		     }
		     results=loopToken(nextPageToken,url,param, results);
  		}
		});
	}
	return results;
}

//foncyion api rest Devoxx
function loadDevoxx(){
	//http://cfp.devoxx.co.uk/api/conferences/   UK, agenda vide pour le moment
	//http://cfp.devoxx.be/api/conferences   belgique done mais 2015
	//http://cfp.devoxx.pl/api/conferences   poland done mais 2015
	//http://cfp.devoxx.fr/api/conferences   france, agenda vide pour le moment
	//http://cfp.devoxx.ma/api/conferences   maroc
	
	
	//var url="http://cfp.devoxx.co.uk/api/conferences/DevoxxUK2016/schedules/";
	//var url="http://cfp.devoxx.be/api/conferences/DV15/schedules/";
	//var url="http://cfp.devoxx.pl/api/conferences/DevoxxPL2015/schedules/";
	//var url="http://cfp.devoxx.fr/api/conferences/DevoxxFR2016/schedules/";
	var url="http://cfp.devoxx.ma/api1/conferences/DevoxxMA2015/schedules/";
	var results = [];
	    $.ajax({
	  	type: "GET",
		  url: url,
		  cache: false,
		  global: false,
		  success: function(data){
		     //data_parse=JSON.parse(data);
		     console.log(data);
		     for(var i in data.links){
		      		//results.push(data.items[i]);
		     		$('#resultarea').append("<p><b>"+i+"     "+data.links[i].href+"</b></p><hr/>"); 
		     		loadSchedule(data.links[i].href, data.links[i].title);    	 
		     }
		    
  		}
		});
		//console.log(results);
}

//fonction api rest devoxx pour chaque jour
function loadSchedule(url, jour){
    var results = [];
    $.ajax({
        type: "GET",
        url: url,
        cache: false,
        global: false,
        success: function(data){
            //data_parse=JSON.parse(data);
            console.log(data);
            for(var i in data.slots){
                if(data.slots[i].talk != null){
                    //results.push(data.items[i]);
                    $('#resultarea').append("<p><i>  "+i+"     "+data.slots[i].talk.title+"</i></p>");
                    $('#resultarea').append("<p>"+jour+" : "+data.slots[i].fromTime+" - "+data.slots[i].toTime+"</p>");
                    $('#resultarea').append(data.slots[i].talk.summaryAsHtml + "<hr/>");
                }
            }
        }
    });
}

//function test(){
//    var jason = {
//        "kind": "youtube#searchListResponse",
//        "etag": "\"3WIcRE7IJ70nCYemJJIi1L7dYAg/o40GfJ0iEDEwkDF4xKn7oq7ad7M\"",
//        "nextPageToken": "CAUQAA",
//        "pageInfo": {
//            "totalResults": 461209,
//            "resultsPerPage": 5
//        },
//        "items": [
//            {
//                "kind": "youtube#searchResult",
//                "etag": "\"3WIcRE7IJ70nCYemJJIi1L7dYAg/KHXyQP-N23jpswNxkVp5J-fem8Y\"",
//                "id": {
//                    "kind": "youtube#video",
//                    "videoId": "ugHsIj60VfQ"
//                },
//                "snippet": {
//                    "publishedAt": "2015-06-08T17:31:10.000Z",
//                    "channelId": "UCdDhYMT2USoLdh4SZIsu_1g",
//                    "title": "Learning Scala? Learn the Fundamentals First!",
//                    "description": "One of the biggest mistakes a Java developer can make when learning Scala is to jump in head-first. By learning the fundamentals of functional programming in ...",
//                    "thumbnails": {
//                        "default": {
//                            "url": "https://i.ytimg.com/vi/ugHsIj60VfQ/default.jpg"
//                        },
//                        "medium": {
//                            "url": "https://i.ytimg.com/vi/ugHsIj60VfQ/mqdefault.jpg"
//                        },
//                        "high": {
//                            "url": "https://i.ytimg.com/vi/ugHsIj60VfQ/hqdefault.jpg"
//                        }
//                    },
//                    "channelTitle": "",
//                    "liveBroadcastContent": "none"
//                }
//            },
//            {
//                "kind": "youtube#searchResult",
//                "etag": "\"3WIcRE7IJ70nCYemJJIi1L7dYAg/fOtLpJMMbqWnw4gWtDstAmjc1Dk\"",
//                "id": {
//                    "kind": "youtube#video",
//                    "videoId": "AHB6aJyhDSQ"
//                },
//                "snippet": {
//                    "publishedAt": "2015-04-01T19:02:18.000Z",
//                    "channelId": "UCkQX1tChV7Z7l1LFF4L9j_g",
//                    "title": "We Won! How Scala Conquered the Big Data World",
//                    "description": "In 2012, Dean Wampler claimed that Hadoop, and Big Data in general, needed Functional Programming and an alternative to Java. Today he says that Scala ...",
//                    "thumbnails": {
//                        "default": {
//                            "url": "https://i.ytimg.com/vi/AHB6aJyhDSQ/default.jpg"
//                        },
//                        "medium": {
//                            "url": "https://i.ytimg.com/vi/AHB6aJyhDSQ/mqdefault.jpg"
//                        },
//                        "high": {
//                            "url": "https://i.ytimg.com/vi/AHB6aJyhDSQ/hqdefault.jpg"
//                        }
//                    },
//                    "channelTitle": "MarakanaTechTV",
//                    "liveBroadcastContent": "none"
//                }
//            },
//            {
//                "kind": "youtube#searchResult",
//                "etag": "\"3WIcRE7IJ70nCYemJJIi1L7dYAg/OGl_0_bKj3pNRY7xb4J6xC0YHMo\"",
//                "id": {
//                    "kind": "youtube#video",
//                    "videoId": "DzFt0YkZo8M"
//                },
//                "snippet": {
//                    "publishedAt": "2015-08-24T23:46:07.000Z",
//                    "channelId": "UCwRXb5dUK4cvsHbx-rGzSgw",
//                    "title": "Scala Tutorial",
//                    "description": "Get the Cheat Sheet Here : http://goo.gl/O1CuGM Best Scala Book : http://amzn.to/1JfA1bV 00:55 Installation 03:03 REPL 04:36 Data Types 07:00 Math 09:57 If ...",
//                    "thumbnails": {
//                        "default": {
//                            "url": "https://i.ytimg.com/vi/DzFt0YkZo8M/default.jpg"
//                        },
//                        "medium": {
//                            "url": "https://i.ytimg.com/vi/DzFt0YkZo8M/mqdefault.jpg"
//                        },
//                        "high": {
//                            "url": "https://i.ytimg.com/vi/DzFt0YkZo8M/hqdefault.jpg"
//                        }
//                    },
//                    "channelTitle": "derekbanas",
//                    "liveBroadcastContent": "none"
//                }
//            },
//            {
//                "kind": "youtube#searchResult",
//                "etag": "\"3WIcRE7IJ70nCYemJJIi1L7dYAg/hD6JBQSBHmEK3Z3n_j8EPpvQfsA\"",
//                "id": {
//                    "kind": "youtube#video",
//                    "videoId": "5GhFld7-7hI"
//                },
//                "snippet": {
//                    "publishedAt": "2014-01-31T18:01:32.000Z",
//                    "channelId": "UC6D58UvAH98IaMVZr80-03g",
//                    "title": "2014-01 Introduction to Scala",
//                    "description": "The main presentation starts at 6:03. Christian Sadilek and Donny Nadolny provide an introduction to the Scala programming language Their talk introduces ...",
//                    "thumbnails": {
//                        "default": {
//                            "url": "https://i.ytimg.com/vi/5GhFld7-7hI/default.jpg"
//                        },
//                        "medium": {
//                            "url": "https://i.ytimg.com/vi/5GhFld7-7hI/mqdefault.jpg"
//                        },
//                        "high": {
//                            "url": "https://i.ytimg.com/vi/5GhFld7-7hI/hqdefault.jpg"
//                        }
//                    },
//                    "channelTitle": "",
//                    "liveBroadcastContent": "none"
//                }
//            },
//            {
//                "kind": "youtube#searchResult",
//                "etag": "\"3WIcRE7IJ70nCYemJJIi1L7dYAg/a8mui5GRq5LSHrP_YxpdFyYteTA\"",
//                "id": {
//                    "kind": "youtube#playlist",
//                    "playlistId": "PL0B0820169DCF0AD2"
//                },
//                "snippet": {
//                    "publishedAt": "2012-02-27T00:44:38.000Z",
//                    "channelId": "UCEvjiWkK2BoIH819T-buioQ",
//                    "title": "Introduction to the Art of Programming Using Scala (Part I)",
//                    "description": "This playlist has all the videos created to accompany the first half of my CS1/CS2 textbook using Scala. http://www.amazon.com/gp/product/1439896666 Book ...",
//                    "thumbnails": {
//                        "default": {
//                            "url": "https://i.ytimg.com/vi/EWV916OCzW8/default.jpg"
//                        },
//                        "medium": {
//                            "url": "https://i.ytimg.com/vi/EWV916OCzW8/mqdefault.jpg"
//                        },
//                        "high": {
//                            "url": "https://i.ytimg.com/vi/EWV916OCzW8/hqdefault.jpg"
//                        }
//                    },
//                    "channelTitle": "DrMarkCLewis",
//                    "liveBroadcastContent": "none"
//                }
//            }
//        ]
//    };
//    console.log(jason);
//    console.log(jason.items[0]);
//}
