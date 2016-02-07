package controllers

import javax.inject.Inject
import akka.actor.ActorSystem
import play.api.Play.current
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSClient
import play.api.mvc._
import actors.{ActorHome, ActorFeeds, Init}
import play.api.mvc.WebSocket.FrameFormatter


class ActorsController @Inject() (system : ActorSystem, ws : WSClient) extends Controller {

  def searchRss = WebSocket.acceptWithActor[String,String] { request =>
    out =>
      ActorFeeds.props(out,ws)
  }

  def searchHome = WebSocket.acceptWithActor[String,String] { request =>
    out =>
      ActorHome.props(out,ws,system)
  }
}
