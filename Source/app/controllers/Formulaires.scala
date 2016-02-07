package controllers


import com.mongodb.casbah.commons.MongoDBObject
import model.Mongodb

import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.{Messages, I18nSupport, MessagesApi}
import play.api.libs.json.{JsString, Json, Writes}
import play.api.mvc._
import play.twirl.api.Html


//case class pour chaque formulaire html
case class Inscription(login:String, password: String)
case class Login(login:String, password: String)
case class Deconnexion(value: String)

class Formulaires @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  //mapping du formulaire inscription
  val formInscription = Form(
    mapping(
      "login" -> nonEmptyText,
      "password" -> nonEmptyText
    )(Inscription.apply)(Inscription.unapply)
  )
  //mapping du formulaire connexion
  val formLogin = Form(
    mapping(
      "login" -> nonEmptyText,
      "password" -> nonEmptyText
    )(Inscription.apply)(Inscription.unapply)
  )
  //mapping du formulaire deconnexion
  val formDeconnexion= Form(
    mapping(
      "value" -> text
    )(Deconnexion.apply)(Deconnexion.unapply)
  )

  //action d'inscription, creation du user en bdd s'il n'existe pas
  def inscription = Action { implicit request =>
    /*session.get("connected").map { user =>
      Ok("Hello " + user)
    }.getOrElse {
      Unauthaurized("Oops, you are not connected")
    }*/
    val el=formInscription.bindFromRequest.get
    val users=Mongodb.db("users")
    val login = MongoDBObject("login" -> el.login)
    if(users.findOne(login)==None) {
      val utilisateur = MongoDBObject("login" -> el.login, "password" -> el.password)
      users.insert(utilisateur)
      Redirect(routes.Application.index).withSession(
        "user" -> el.login
      )
    }else{
      BadRequest(
        Json.obj(
          "Error" -> s"${el.login} existe déjà"
        )
      )
    }
  }
  //action post sur la page d'inscription
  def login = Action { implicit request =>
    val el=formLogin.bindFromRequest.get
    val users=Mongodb.db("users")
    val utilisateur = MongoDBObject("login" -> el.login, "password" -> el.password)
    val exists = users.findOne( utilisateur )
    println(exists)
    if(exists!=None){
      Redirect(routes.Application.index).withSession(
        "user" -> el.login
      )
    }else{
      BadRequest(
        Json.obj(
          "commentaire" -> "Login/mdp n'existent pas"
        )
      )
    }
  }

  def deconnexion = Action { implicit request =>
    Redirect(routes.Application.index).withNewSession
  }
}
