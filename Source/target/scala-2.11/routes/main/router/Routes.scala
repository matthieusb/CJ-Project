
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/conf/routes
// @DATE:Sun Feb 07 20:32:26 CET 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_4: controllers.Application,
  // @LINE:9
  Formulaires_1: controllers.Formulaires,
  // @LINE:22
  ActorsController_3: controllers.ActorsController,
  // @LINE:26
  Assets_0: controllers.Assets,
  // @LINE:27
  WebJarAssets_2: controllers.WebJarAssets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_4: controllers.Application,
    // @LINE:9
    Formulaires_1: controllers.Formulaires,
    // @LINE:22
    ActorsController_3: controllers.ActorsController,
    // @LINE:26
    Assets_0: controllers.Assets,
    // @LINE:27
    WebJarAssets_2: controllers.WebJarAssets
  ) = this(errorHandler, Application_4, Formulaires_1, ActorsController_3, Assets_0, WebJarAssets_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_4, Formulaires_1, ActorsController_3, Assets_0, WebJarAssets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sources""", """controllers.Application.sources"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """inscription""", """controllers.Application.inscription"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """inscription""", """controllers.Formulaires.inscription"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Formulaires.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deconnexion""", """controllers.Formulaires.deconnexion"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ajoutFavVideo""", """controllers.Application.ajoutFavVideo"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """removeFavVideo""", """controllers.Application.removeFavVideo"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFavVideos""", """controllers.Application.getFavVideos"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ajoutFavArticle""", """controllers.Application.ajoutFavArticle"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """removeFavArticle""", """controllers.Application.removeFavArticle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFavArticles""", """controllers.Application.getFavArticles"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favoris""", """controllers.Application.favoris"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """timeline""", """controllers.Application.timeline"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchRss""", """controllers.ActorsController.searchRss"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchHome""", """controllers.ActorsController.searchHome"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""", """controllers.WebJarAssets.at(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_4.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_sources1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sources")))
  )
  private[this] lazy val controllers_Application_sources1_invoker = createInvoker(
    Application_4.sources,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sources",
      Nil,
      "GET",
      """""",
      this.prefix + """sources"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_inscription2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("inscription")))
  )
  private[this] lazy val controllers_Application_inscription2_invoker = createInvoker(
    Application_4.inscription,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "inscription",
      Nil,
      "GET",
      """""",
      this.prefix + """inscription"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Formulaires_inscription3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("inscription")))
  )
  private[this] lazy val controllers_Formulaires_inscription3_invoker = createInvoker(
    Formulaires_1.inscription,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Formulaires",
      "inscription",
      Nil,
      "POST",
      """""",
      this.prefix + """inscription"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Formulaires_login4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Formulaires_login4_invoker = createInvoker(
    Formulaires_1.login,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Formulaires",
      "login",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Formulaires_deconnexion5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deconnexion")))
  )
  private[this] lazy val controllers_Formulaires_deconnexion5_invoker = createInvoker(
    Formulaires_1.deconnexion,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Formulaires",
      "deconnexion",
      Nil,
      "POST",
      """""",
      this.prefix + """deconnexion"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_ajoutFavVideo6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ajoutFavVideo")))
  )
  private[this] lazy val controllers_Application_ajoutFavVideo6_invoker = createInvoker(
    Application_4.ajoutFavVideo,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "ajoutFavVideo",
      Nil,
      "POST",
      """""",
      this.prefix + """ajoutFavVideo"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_removeFavVideo7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeFavVideo")))
  )
  private[this] lazy val controllers_Application_removeFavVideo7_invoker = createInvoker(
    Application_4.removeFavVideo,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removeFavVideo",
      Nil,
      "POST",
      """""",
      this.prefix + """removeFavVideo"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_getFavVideos8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFavVideos")))
  )
  private[this] lazy val controllers_Application_getFavVideos8_invoker = createInvoker(
    Application_4.getFavVideos,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getFavVideos",
      Nil,
      "GET",
      """""",
      this.prefix + """getFavVideos"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_ajoutFavArticle9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ajoutFavArticle")))
  )
  private[this] lazy val controllers_Application_ajoutFavArticle9_invoker = createInvoker(
    Application_4.ajoutFavArticle,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "ajoutFavArticle",
      Nil,
      "POST",
      """""",
      this.prefix + """ajoutFavArticle"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Application_removeFavArticle10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeFavArticle")))
  )
  private[this] lazy val controllers_Application_removeFavArticle10_invoker = createInvoker(
    Application_4.removeFavArticle,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removeFavArticle",
      Nil,
      "POST",
      """""",
      this.prefix + """removeFavArticle"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Application_getFavArticles11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFavArticles")))
  )
  private[this] lazy val controllers_Application_getFavArticles11_invoker = createInvoker(
    Application_4.getFavArticles,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getFavArticles",
      Nil,
      "GET",
      """""",
      this.prefix + """getFavArticles"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Application_favoris12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favoris")))
  )
  private[this] lazy val controllers_Application_favoris12_invoker = createInvoker(
    Application_4.favoris,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "favoris",
      Nil,
      "GET",
      """""",
      this.prefix + """favoris"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Application_timeline13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("timeline")))
  )
  private[this] lazy val controllers_Application_timeline13_invoker = createInvoker(
    Application_4.timeline,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "timeline",
      Nil,
      "GET",
      """""",
      this.prefix + """timeline"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ActorsController_searchRss14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchRss")))
  )
  private[this] lazy val controllers_ActorsController_searchRss14_invoker = createInvoker(
    ActorsController_3.searchRss,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActorsController",
      "searchRss",
      Nil,
      "GET",
      """ Actors""",
      this.prefix + """searchRss"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ActorsController_searchHome15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchHome")))
  )
  private[this] lazy val controllers_ActorsController_searchHome15_invoker = createInvoker(
    ActorsController_3.searchHome,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActorsController",
      "searchHome",
      Nil,
      "GET",
      """""",
      this.prefix + """searchHome"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Assets_versioned16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned16_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_WebJarAssets_at17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at17_invoker = createInvoker(
    WebJarAssets_2.at(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """webjars/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_4.index)
      }
  
    // @LINE:7
    case controllers_Application_sources1_route(params) =>
      call { 
        controllers_Application_sources1_invoker.call(Application_4.sources)
      }
  
    // @LINE:8
    case controllers_Application_inscription2_route(params) =>
      call { 
        controllers_Application_inscription2_invoker.call(Application_4.inscription)
      }
  
    // @LINE:9
    case controllers_Formulaires_inscription3_route(params) =>
      call { 
        controllers_Formulaires_inscription3_invoker.call(Formulaires_1.inscription)
      }
  
    // @LINE:10
    case controllers_Formulaires_login4_route(params) =>
      call { 
        controllers_Formulaires_login4_invoker.call(Formulaires_1.login)
      }
  
    // @LINE:11
    case controllers_Formulaires_deconnexion5_route(params) =>
      call { 
        controllers_Formulaires_deconnexion5_invoker.call(Formulaires_1.deconnexion)
      }
  
    // @LINE:12
    case controllers_Application_ajoutFavVideo6_route(params) =>
      call { 
        controllers_Application_ajoutFavVideo6_invoker.call(Application_4.ajoutFavVideo)
      }
  
    // @LINE:13
    case controllers_Application_removeFavVideo7_route(params) =>
      call { 
        controllers_Application_removeFavVideo7_invoker.call(Application_4.removeFavVideo)
      }
  
    // @LINE:14
    case controllers_Application_getFavVideos8_route(params) =>
      call { 
        controllers_Application_getFavVideos8_invoker.call(Application_4.getFavVideos)
      }
  
    // @LINE:15
    case controllers_Application_ajoutFavArticle9_route(params) =>
      call { 
        controllers_Application_ajoutFavArticle9_invoker.call(Application_4.ajoutFavArticle)
      }
  
    // @LINE:16
    case controllers_Application_removeFavArticle10_route(params) =>
      call { 
        controllers_Application_removeFavArticle10_invoker.call(Application_4.removeFavArticle)
      }
  
    // @LINE:17
    case controllers_Application_getFavArticles11_route(params) =>
      call { 
        controllers_Application_getFavArticles11_invoker.call(Application_4.getFavArticles)
      }
  
    // @LINE:18
    case controllers_Application_favoris12_route(params) =>
      call { 
        controllers_Application_favoris12_invoker.call(Application_4.favoris)
      }
  
    // @LINE:19
    case controllers_Application_timeline13_route(params) =>
      call { 
        controllers_Application_timeline13_invoker.call(Application_4.timeline)
      }
  
    // @LINE:22
    case controllers_ActorsController_searchRss14_route(params) =>
      call { 
        controllers_ActorsController_searchRss14_invoker.call(ActorsController_3.searchRss)
      }
  
    // @LINE:23
    case controllers_ActorsController_searchHome15_route(params) =>
      call { 
        controllers_ActorsController_searchHome15_invoker.call(ActorsController_3.searchHome)
      }
  
    // @LINE:26
    case controllers_Assets_versioned16_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned16_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:27
    case controllers_WebJarAssets_at17_route(params) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at17_invoker.call(WebJarAssets_2.at(file))
      }
  }
}