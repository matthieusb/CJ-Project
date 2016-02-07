//This file contains classic JS functions and the creation of the Angular App
//Creating angular app
var RESTApp= angular.module("appelsRest",['angularUtils.directives.dirPagination','angular-jqcloud', 'angular-timeline', 'ngSanitize']);

// -----------------------------------
// --------------- THUMBNAILS
// -----------------------------------

//This function sets all thumbnails from a group to the sameHeight
function equalHeightThumbnails(group) {
    var tallest = 0;
    group.each(function() {
        var thisHeight = $(this).height();
        if(thisHeight > tallest) {
            tallest = thisHeight;
        }
    });
    group.each(function() { $(this).height(tallest); });
}

//Set all thumbnails of the document to the same height
$(document).ready(function() {
    //equalHeightThumbnails($(".thumbnail"));
});

// -----------------------------------
// --------------- CLASSIC JS
// -----------------------------------

//spinner selection du range pour recherche video
(function ($) {
    $('.spinner .btn:first-of-type').on('click', function() {
        $('.spinner input').val( parseInt($('.spinner input').val(), 10) + 1);
    });
    $('.spinner .btn:last-of-type').on('click', function() {
        if($('.spinner input').val() >1)
            $('.spinner input').val( parseInt($('.spinner input').val(), 10) - 1);
    });
})(jQuery);

//requete ajax de connexion
$(document).ready(function() {
    $("#login-nav").submit(function() {

        $.ajax({
            type: "POST",
            url: "/login",
            data: $(this).serialize(),
            success: function(data) {
                window.location.href="/";
                $("#error-login").toggle(false);
            },
            error: function(data){
                console.log(data);
                $("#error-login").text(data.responseJSON.commentaire);
                $("#error-login").toggle(true);
            }
        })

    })
})
//requete ajax de d'inscription
$(document).ready(function() {
    $("#inscription").submit(function() {

        $.ajax({
            type: "POST",
            url: "/inscription",
            data: $(this).serialize(),
            success: function(data) {
                window.location.href="/";
            },
            error: function(data){
                console.log(data);
                $("#error-inscription").text(data.responseJSON.Error);
                $("#error-inscription").toggle(true);
            }
        })

    })
});
//fonction récupérant la date du range au format demandé par youtube
function getDateFromRange(range){
    //var today = new Date();
    var backintime = new Date();
    backintime.setDate(backintime.getDate() - range);
    var tdd=backintime.getDate();
    var tmm=backintime.getMonth()+1;
    var tyy=backintime.getFullYear();
    if(tdd<10){
        tdd='0'+tdd;
    }
    if(tmm<10){
        tmm='0'+tmm;
    }
    return backintime=tyy+"-"+tmm+"-"+tdd+"T00:00:00Z"

}
//fonction ajout favori video, à sortir du controller
ajoutFavVideo=function(videoId, title, description, publishedAt, image){
    console.log("ajout");
    var video = {
        videoId : videoId,
        title : title,
        description : description,
        publishedAt : publishedAt,
        image : image
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/ajoutFavVideo",
        data: JSON.stringify(video),
        dataType: "json",
        success: function (data) {
        }
    });

    //$( "#"+videoId).find( "button" ).attr( "ng-click", "removeFavVideo(video.id.videoId)").text("Supprimer favori");
    console.log(video);
};
//requete ajax suppression de favori
removeFavVideo=function(videoId, title, description, publishedAt, image){
    var video = {
        videoId : videoId,
        title : title,
        description : description,
        publishedAt : publishedAt,
        image : image
    };
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/removeFavVideo",
        data: JSON.stringify(video),
        dataType: "json",
        success: function (data) {
        }
    });
    console.log("suppression");
    //$( "#"+videoId).find( "button" ).attr( "ng-click", "ajoutFavVideo(video.id.videoId, video.snippet.title, video.snippet.description, video.snippet.publishedAt, video.snippet.thumbnails.medium.url)").text("Supprimer favori");
};

ajoutFavArticle=function(title, description, link, date, image, categories){
    console.log("ajout");
    var article = {
        title : title,
        description : description,
        link: link,
        date : date,
        urlImage : image,
        categories: categories
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/ajoutFavArticle",
        data: JSON.stringify(article),
        dataType: "json",
        success: function (data) {
        }
    });
};

removeFavArticle=function(link){
    var article = {
        link: link
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/removeFavArticle",
        data: JSON.stringify(article),
        dataType: "json",
        success: function (data) {
        }
    });
};

// -----------------------------------
// --------------- SLIDESHOW
// -----------------------------------