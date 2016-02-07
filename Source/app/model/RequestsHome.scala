package model

import play.api.Play._
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSClient
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import scala.xml.Elem

object RequestsHome {

  // ------------------------------------------
  // GETTING KEYWORDS(TAGS) FROM INFOQ AND DVPTCOM
  // ------------------------------------------
  def createListTagFromXml(xml : Elem) = {
    val items = xml \ "channel" \ "item"

    items.flatMap(node => (node \ "category").map(x => x.text)).distinct
  }

  def jsonToReturnKeywords(xmlInfoq : Elem) = {
    val resultAll = createListTagFromXml(xmlInfoq)

    Json.toJson(resultAll.toSeq)
  }

  def handleKeywordsFetching(ws : WSClient) = {
    println("Handling Keywords fetching")

    for {
      xmlInfoq <- XmlHandler.getRss(current.configuration.getString("infoq.rss.url").getOrElse(""),ws)
    } yield jsonToReturnKeywords(xmlInfoq)
  }

}
