package actors

import akka.actor._
import model.RequestsHome
import play.api.libs.json.Json
import play.api.libs.ws.WSClient
import scala.concurrent.ExecutionContext.Implicits.global

// ----------------------
// Case classes
// ----------------------
case class fetchKeywords()
case class fetchSlideshow()
case class fetchKeywordSearch(toSearch : String)
case class fetchConferencesTimeline()

// ----------------------
// Companion object
// ----------------------
object ActorHome {
  def props(out : ActorRef, ws : WSClient, system: ActorSystem) = Props(new ActorHome(out,ws,system))
}

class ActorHome(out : ActorRef, ws : WSClient, system: ActorSystem) extends Actor with ActorLogging {

  def json_to_return(status: String, message: String) = {
    Json.toJson(Map(status -> message)).toString()
  }

  def receive = {
    case fetchKeywords() =>
      RequestsHome.handleKeywordsFetching(ws).map(resultKeywords => {

        out ! json_to_return("dataKeywords",resultKeywords.toString())
        out ! json_to_return("notifInfo","Keywords obtained !")
      })

    case fetchSlideshow() =>
      val actorFeeds = system.actorOf(Props(new ActorFeeds(out,ws)))
      actorFeeds ! WikiCfp("","normal")
      actorFeeds ! InfoQ("","normal")
      actorFeeds ! DvptCom("","normal")

    case fetchKeywordSearch(toSearch : String) =>
      val actorFeeds = system.actorOf(Props(new ActorFeeds(out,ws)))
      actorFeeds ! Ieee(toSearch.toLowerCase,"keywordSearch")
      actorFeeds ! WikiCfp(toSearch.toLowerCase,"keywordSearch")
      actorFeeds ! InfoQ(toSearch.toLowerCase,"keywordSearch")
      actorFeeds ! DvptCom(toSearch.toLowerCase,"keywordSearch")

    case fetchConferencesTimeline() =>
      val actorFeeds = system.actorOf(Props(new ActorFeeds(out,ws)))
      actorFeeds ! WikiCfp("","normal")

    // Initialisation -> calls function according to the task asked
    case msg : String =>
      println("Initializing Actor Home")
      val msgJson = Json.parse(msg) //Parsing string to json

      val items = (msgJson \ "items").as[List[Map[String, String]]]
      val whatToDo = items.head.get("researchContent").getOrElse("", "")

      whatToDo match {
        case "fetchKeywords" => self ! fetchKeywords()
        case "fetchSlideshow" => self ! fetchSlideshow()
        case "fetchKeywordSearch" => self ! fetchKeywordSearch(items(1).get("keywordSearched").getOrElse("", "").toString)
        case "fetchConferencesTimeline" => self ! fetchConferencesTimeline()
        case _ => out ! json_to_return("notifError", "Une erreur a été trouvée dans les données envoyées")
      }

  }
}
