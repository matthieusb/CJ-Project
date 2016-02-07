package controllers

import javax.inject.Inject
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.Imports._
import model.Mongodb
import play.api.i18n.{Messages, I18nSupport, MessagesApi}
import play.api.libs.json.{JsString, Json, Writes}
import play.api.mvc._
import play.twirl.api.Html

class Application @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {
//action get redirigeant sur la page d'accueil
  def index = Action { implicit request =>
    Ok(views.html.index("home"))
  }

  //test de la session sur la page
  //action get redirigeant sur la page source
  def sources = Action { implicit request =>
//    request.session.get("user").map { user =>
      Ok(views.html.pages.sources("sources"))
//    }.getOrElse {
//      Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
//    }
  }

  def timeline = Action {implicit request =>
    Ok(views.html.pages.timeline("Conferences à venir"))
  }
  //action get redirigeant sur la page d'inscription
  def inscription = Action { implicit request =>
    Ok(views.html.pages.inscription("inscription"))
  }
  //action post ajoutant une video en favori dans la bdd
  def ajoutFavVideo = Action(parse.json) { implicit request =>
      println("on rentre dans l'ajout favori")
      request.session.get("user").map { user =>
      val users=Mongodb.db("users")
      val utilisateur = MongoDBObject("login" -> user)
        users.findAndModify(utilisateur, $addToSet("videos" -> MongoDBObject(request.body.toString())))
        //suppression users.findAndModify(utilisateur, $pull("videos" -> "videoid"))
      //val res = users.findOne(utilisateur).get
      //users.update(res, $addToSet("videos" -> MongoDBObject("videoId" -> "tot")), true, true)
      Ok(views.html.pages.sources("sources"))
    }.getOrElse {
        Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
    }
  }
  //action post supprimant une video en favori dans la bdd
  def removeFavVideo = Action(parse.json) { implicit request =>
    println("on rentre dans la suppression favori")
    request.session.get("user").map { user =>
      val users=Mongodb.db("users")
      val utilisateur = MongoDBObject("login" -> user)
      users.findAndModify(utilisateur, $pull("videos" -> MongoDBObject(request.body.toString())))

      //val res = users.findOne(utilisateur).get
      //users.update(res, $addToSet("videos" -> MongoDBObject("videoId" -> "tot")), true, true)
      Ok(views.html.pages.sources("sources"))
    }.getOrElse {
      Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
    }
  }
//action get récupérant la liste des vidéos favorites
  def getFavVideos = Action { implicit request =>
    request.session.get("user").map { user =>
      val users=Mongodb.db("users")
      val utilisateur = MongoDBObject("login" -> user)
      val videos=users.findOne(utilisateur).get.get("videos")
      Ok(Json.parse(videos.toString))
    }.getOrElse {
      Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
    }
  }
  //action get allant sur la page favori
  def favoris = Action { implicit request =>
    request.session.get("user").map { user =>
      Ok(views.html.pages.favoris("favoris"))
    }.getOrElse {
      Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
    }

  }
//action post ajoutant un article en favori dans la bdd
  def ajoutFavArticle = Action(parse.json) { implicit request =>
    println("on rentre dans l'ajout favori article")
    request.session.get("user").map { user =>
      val users=Mongodb.db("users")
      val utilisateur = MongoDBObject("login" -> user)
      users.findAndModify(utilisateur, $addToSet("articles" -> MongoDBObject(request.body.toString())))
      //suppression users.findAndModify(utilisateur, $pull("videos" -> "videoid"))
      //val res = users.findOne(utilisateur).get
      //users.update(res, $addToSet("videos" -> MongoDBObject("videoId" -> "tot")), true, true)
      Ok(views.html.pages.sources("sources"))
    }.getOrElse {
      Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
    }
  }
  //action post supprimant un article en favori dans la bdd
  def removeFavArticle = Action(parse.json) { implicit request =>
    println("on rentre dans la suppression favori article")
    request.session.get("user").map { user =>
      val users = Mongodb.db("users")
      val utilisateur = MongoDBObject("login" -> user)
      users.findAndModify(utilisateur, $pull("articles" -> MongoDBObject(request.body.toString())))

      //val res = users.findOne(utilisateur).get
      //users.update(res, $addToSet("videos" -> MongoDBObject("videoId" -> "tot")), true, true)
      Ok(views.html.pages.sources("sources"))
    }.getOrElse {
      Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
    }
  }

    //action get récupérant la liste des articles favoris
    def getFavArticles = Action { implicit request =>
      request.session.get("user").map { user =>
        val users = Mongodb.db("users")
        val utilisateur = MongoDBObject("login" -> user)
        val articles = users.findOne(utilisateur).get.get("articles")
        Ok(Json.parse(articles.toString))
      }.getOrElse {
        Unauthorized(views.html.errors.onUnauthorized("Not Connected"))
      }
    }
  }