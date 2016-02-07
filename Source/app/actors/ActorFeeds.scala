package actors

import akka.actor.{ActorLogging, Actor, Props, ActorRef}
import model.XmlHandler
import play.api.libs.json.Json
import play.api.libs.ws.WSClient
import scala.concurrent.ExecutionContext.Implicits.global

//Companion trait
trait MessageReq

// ----------------------
// Case classes
// ----------------------
case class Init(reqType: String) extends MessageReq

case class InfoQ(keywords : String, typeReq : String)
case class Ieee(keywords : String, typeReq : String)
case class DvptCom(keywords : String, typeReq : String)
case class WikiCfp(keywords : String, typeReq : String)

// ----------------------
// Companion object
// ----------------------
object ActorFeeds {
  def props(out : ActorRef, ws : WSClient) = Props(new ActorFeeds(out,ws))
}

//Actor
class ActorFeeds(out : ActorRef, ws : WSClient) extends Actor with ActorLogging {

  def json_to_return(status: String, message: String) = {
    Json.toJson(Map(status -> message)).toString()
  }

  def receive = {

    // Handling messages and returns for InfoQ
    case InfoQ(keywords : String, typeReq : String) =>
      XmlHandler.handleInfoQSearch(keywords,ws).map(resultInfoQ => {
        out ! json_to_return("notifInfo", "Résultats infoQ obtenus")
        if (typeReq != "normal") {
          out ! json_to_return("dataInfoQKeyword", resultInfoQ.toString())
        } else {
          out ! json_to_return("dataInfoQ", resultInfoQ.toString())
        }
      })

    // Handling messages and returns for Ieee
    case Ieee(keywords : String, typeReq : String) =>
      XmlHandler.handleIeeSearch(keywords,ws).map(resultIeee => {
        out ! json_to_return("notifInfo", "Résultats IEEE obtenus")
        if (typeReq != "normal") {
          out ! json_to_return("dataIeeeKeyword", resultIeee.toString())
        } else {
          out ! json_to_return("dataIeee", resultIeee.toString())
        }
      })

    // Handling messages and returns for Developpez.com
    case DvptCom(keywords : String, typeReq : String) =>
      XmlHandler.handleDvptComSearch(keywords,ws).map(resultDvptCom => {
        out ! json_to_return("notifInfo", "Résultats Developpez.com obtenus")
        if (typeReq != "normal") {
          out ! json_to_return("dataDvptKeyword", resultDvptCom.toString())
        } else {
          out ! json_to_return("dataDvpt", resultDvptCom.toString())
        }
      })

    case WikiCfp(keywords : String, typeReq : String) =>
      XmlHandler.handleWikiCfpSearch(keywords,ws).map(resultWikiCfp => {
      out ! json_to_return("notifInfo", "Résultats WikiCfp obtenus")
        if (typeReq != "normal") {
          out ! json_to_return("dataWikiCfpKeyword", resultWikiCfp.toString())
        } else {
          out ! json_to_return("dataWikiCfp", resultWikiCfp.toString())
        }
    })


    // Initialisation -> calls case according to website chosen in type
    case msg : String =>
      println("Initialising Actor handling feeds")
      val msgJson = Json.parse(msg) //Parsing string to json

      //Filtering items that are actually checked
      val items = (msgJson \ "items").as[List[Map[String, String]]]
      val keywords = items.head.get("researchContent").getOrElse("", "")
      val checkedBoxes = items.filter(x => x.keySet.head != "researchContent").filter(x => x.get("checked").getOrElse("", "") == "true")

      out ! json_to_return("notifInfo", "Lancement de la recherche")

      checkedBoxes.foreach { x =>
        x.get("id").getOrElse("", "") match {
          case "infoqCheckboxId" => self ! InfoQ(keywords.toString.toLowerCase,"normal")
          case "ieeCheckboxId" => self ! Ieee(keywords.toString.toLowerCase,"normal")
          case "dvptcomCheckboxId" => self ! DvptCom(keywords.toString.toLowerCase,"normal")
          case "wikicfpCheckboxId" => self ! WikiCfp(keywords.toString.toLowerCase,"normal")
          case _ => out ! json_to_return("notifError", "Une erreur a été trouvée dans les données envoyées")
        }
      }// -- foreach
  } // -- Receive

}
