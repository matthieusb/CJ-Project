
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/conf/routes
// @DATE:Sun Feb 07 20:32:26 CET 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:26
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseWebJarAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebJarAssets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseFormulaires(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def deconnexion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Formulaires.deconnexion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deconnexion"})
        }
      """
    )
  
    // @LINE:9
    def inscription: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Formulaires.inscription",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "inscription"})
        }
      """
    )
  
    // @LINE:10
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Formulaires.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def getFavArticles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getFavArticles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getFavArticles"})
        }
      """
    )
  
    // @LINE:13
    def removeFavVideo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removeFavVideo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "removeFavVideo"})
        }
      """
    )
  
    // @LINE:16
    def removeFavArticle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removeFavArticle",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "removeFavArticle"})
        }
      """
    )
  
    // @LINE:12
    def ajoutFavVideo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.ajoutFavVideo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajoutFavVideo"})
        }
      """
    )
  
    // @LINE:15
    def ajoutFavArticle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.ajoutFavArticle",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajoutFavArticle"})
        }
      """
    )
  
    // @LINE:19
    def timeline: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.timeline",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "timeline"})
        }
      """
    )
  
    // @LINE:7
    def sources: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sources",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sources"})
        }
      """
    )
  
    // @LINE:18
    def favoris: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.favoris",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "favoris"})
        }
      """
    )
  
    // @LINE:8
    def inscription: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.inscription",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inscription"})
        }
      """
    )
  
    // @LINE:14
    def getFavVideos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getFavVideos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getFavVideos"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseActorsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def searchHome: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ActorsController.searchHome",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchHome"})
        }
      """
    )
  
    // @LINE:22
    def searchRss: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ActorsController.searchRss",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchRss"})
        }
      """
    )
  
  }


}