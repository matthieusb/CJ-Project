package model

import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSClient

import scala.annotation.tailrec
import scala.collection.generic.CanBuildFrom
import scala.concurrent.Future
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
import scala.xml.{Node, NodeSeq, Elem}


// ----------------------
// Case classes
// ----------------------
case class Item(title : String, description : String, link : String, date : String, urlImage : String, categories : Seq[String])

// ----------------------
// Case classes
// ----------------------
object Item {
  implicit val itemWriter = Json.writes[Item]
}

//This object takes functions that handle XML getting and parsing
object XmlHandler {
  // ------------------------------------------
  // GENERAL
  // ------------------------------------------
  //Get the rss flux according to its URL
  def getRss(url : String, ws : WSClient) : Future[Elem] = {
    ws.url(url).withHeaders("Accept" -> "application/*+xml;version=5.1").get().map {
      response => {
        response.xml
      }
    }
  }

  //Removes HTML tags from an xml nodeseq obtained
  def removeAllTagsFromNodeSeq(node : NodeSeq) : String = {
    val patternHtmlTags = "<[^>]*>"

    node.text.replaceAll(patternHtmlTags,"")
  }

  //TODO
//  def getRssWithLang(url : String, lang : String) = ???

  // ------------------------------------------
  // INFOQ
  // ------------------------------------------
  //Return all the items
  def searchXmlInfoQ(xml : Elem) : NodeSeq = {
    xml \ "channel" \ "item"
  }

  def getUrlImageFromDescriptionInfoQ(node : Node) : String = {
    val patternImg = "<img[^>]*>".r
    val patternSrc = "\".*\"".r

    val descr = (node \ "description").text
    val tagFound = patternImg.findFirstIn(descr).getOrElse("")

    patternSrc.findFirstIn(tagFound).getOrElse("").replaceAll("\"","")
  }

  // Creates maps of data from xml returned by InfoQ feeds
  def createMapsFromXmlInfoQ(xml : Elem, xmlNews : Elem) = {
    val resNormal = searchXmlInfoQ(xml)

    val formatIncoming = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val formatOutgoing = new java.text.SimpleDateFormat("dd MMMM yyyy")

    val resNormalSeq = resNormal.map(node => new Item((node \ "title").text,
      removeAllTagsFromNodeSeq(node \ "description"),
      (node \ "link").text,
      formatOutgoing.format(formatIncoming.parse((node \ "date").text)).toString,
      getUrlImageFromDescriptionInfoQ(node), (node \ "category").map(x => x.text))).distinct

      resNormalSeq//Normally would send both feeds but we got duplicates we can get rid of
  }

  //Generates the json to return for InfoQ from a case class
  def jsonToReturnInfoQ(xml : Elem, xmlNews : Elem, toSearch : String) = {
    val allResults = createMapsFromXmlInfoQ(xml, xmlNews)

    val listSearchedWords = toSearch.split(" ") // Get a list of keywords entered by the user

    if (toSearch != "") {
      val resultsFiltered = allResults.filter(x =>
        (x.title.split(" ").map(y => y.toLowerCase) intersect listSearchedWords).toList != List()
          || (x.description.split(" ").map(y => y.toLowerCase) intersect listSearchedWords).toList != List()
          || (x.categories.map(y => y.toLowerCase) intersect listSearchedWords).toList != List()
      )
      Json.toJson(resultsFiltered)
    } else {//In case we just want to fetch all articles from the rss
      Json.toJson(allResults)
    }
  }

  def getInfoQRss(ws : WSClient) = {
    getRss(current.configuration.getString("infoq.rss.url").getOrElse(""),ws)
  }

  def getInfoQNewsRss(ws : WSClient) = {
    getRss(current.configuration.getString("infoq.rss.news.url").getOrElse(""),ws)
  }

  def handleInfoQSearch(toSearch : String, ws : WSClient) : Future[JsValue] = {
    println("Handling InfoQ feeds")

    for {
      resInfoQ <- getInfoQRss(ws)
      resInfoQNews <- getInfoQNewsRss(ws)
    } yield jsonToReturnInfoQ(resInfoQ, resInfoQNews, toSearch)
  }

  // ------------------------------------------
  // IEE
  // ------------------------------------------

  //Calls to the ieee xml api, route is the arguments needed to do the research
  def getIeeeApi(route : String, ws : WSClient)  = {
    getRss(current.configuration.getString("ieee.rss.url").getOrElse("")+route,ws)
  }

  //Generates the research arguments for the iee request, returns them as the route used for the http request
  def createArgumentsIeeeRequest(toSearch : String) : String = {
    val maxResults = current.configuration.getInt("ieee.rss.maxResults.normalRequest").getOrElse(50)

    //If not enough results, change the way to search (Look in infoQ for splits and intersects AND in the IEEE API documentation)
    s"?ti=$toSearch&ab$toSearch&querytext=$toSearch&sortfield=py&sortorder=desc&hc=$maxResults" //Sorted by date, maximum 75
  }

  //NOT USED YET -> only filters ieee results by query param, which search in ALL fields => a lot of results
  def createArgumentsForNumerousResults(toSearch : String) : String = {
    val maxResults = current.configuration.getInt("ieee.rss.maxResults.hugeRequest").getOrElse(300)

    //If not enough results, change the way to search (Look in infoQ for splits and intersects AND in the IEEE API documentation)
    s"?querytext=$toSearch&sortfield=py&hc=$maxResults" //Sorted by date
  }

  def createMapFromXmlIeee(xml : Elem) = {
    val resIeee = xml \ "document"
    resIeee.map(node => new Item((node \ "title").text, removeAllTagsFromNodeSeq(node \ "abstract"),
      (node \ "mdurl").text, (node \ "py").text, "",
      (node \ "thesaurusterms" \ "term").map(x => x.text)))
  }

  def jsonToReturnIeee(xml : Elem, toSearch : String) = {
    val allResults = createMapFromXmlIeee(xml)

    Json.toJson(allResults)
  }

  def handleIeeSearch(toSearch : String, ws : WSClient) : Future[JsValue] = {
    println("Handling IEEE feeds")

    val arguments = createArgumentsIeeeRequest(toSearch)

    for {
      resIeee <- getIeeeApi(arguments,ws)
    } yield  jsonToReturnIeee(resIeee, toSearch)
  }

  // ------------------------------------------
  // DVPT.COM
  // ------------------------------------------
  def getDvptComRss(ws : WSClient) = {
    getRss(current.configuration.getString("dvptcom.rss.url").getOrElse(""),ws)
  }

  def createMapFromXmlDvptCom(xml : Elem) = {
    val resIeee = xml \ "channel" \ "item"
    resIeee.map(node => new Item((node \ "title").text, removeAllTagsFromNodeSeq(node \ "description").replaceAll("\n",". "),
      (node \ "link").text, (node \ "pubDate").text, (node \ "enclosure" \ "@url").text,
      List()))
  }

  def jsonToReturnDvptCom(xml : Elem, toSearch : String) = {
    val allResults = createMapFromXmlDvptCom(xml)
    val listSearchedWords = toSearch.split(" ") // Get a list of keywords entered by the user

    if (toSearch != "") {
      val resultsFiltered = allResults.filter(x =>
        (x.title.split(" ").map(y => y.toLowerCase) intersect listSearchedWords).toList != List()
          || (x.description.split(" ").map(y => y.toLowerCase) intersect listSearchedWords).toList != List()
      )

      Json.toJson(resultsFiltered)
    } else {//In case we just want to fetch all articles from the rss
      Json.toJson(allResults)
    }
  }

  def handleDvptComSearch(toSearch : String, ws : WSClient) : Future[JsValue] = {
    println("Handling Développez.com feeds")

    for {
      resDvptCom <- getDvptComRss(ws)
    } yield jsonToReturnDvptCom(resDvptCom, toSearch)
  }


  // ------------------------------------------
  // WIKICFP
  // ------------------------------------------
  //Only for WikiCfp, beacause problems with DTD
  def getHtmlWikiCfp(url : String, ws : WSClient) : Future[List[String]] = {
    val patternDivContsec = "(?s)<div class=\"contsec\">.*</div>".r
    val divFooter = "(?s)<div class=\"footer\">.*"
    val patternTr = "(?s)<tr .* bgcolor=\"#f6f6f6\">.*</tr>".r
    val input = "<input.*>"
    val tdParasite = "<td align=\"center\" rowspan=\"2\">"
    val esperluette = "&amp;"

    ws.url(url).withHeaders("Accept" -> "application/*+xml;version=5.1").get().map {
      response => {
        val div = patternDivContsec.findFirstIn(response.body)
        val div2 = div.getOrElse("").replaceAll(divFooter,"").replaceAll(input,"").replaceAll(tdParasite,"").replaceAll(esperluette,"&")
        val div2WithouthBlanks = patternTr.findAllIn(div2).map(x => x.replaceAll("\t","")).toList.head

        val listWithTable = div2WithouthBlanks.split("\n").map(x => x.replaceAll("\t","")).filter(_.nonEmpty)
        val indexTable = listWithTable.indexOf("</table>")
        "<tr>" :: listWithTable.dropRight(listWithTable.length - indexTable).drop(1).toList
      }
    }
  }

  //Merges all lists into a list of item ready to parse to json for wikicfp
  def createListItemWikiCfp(listTitle : List[String], listHref: List[String],listDescr: List[String],listDate: List[String]) : List[Item] = {
    val size = listTitle.length
    lazy val res = createListItemWikiCfpRec(List(), 0)
    @tailrec
    def createListItemWikiCfpRec(listRes : List[Item], it :Int ) : List[Item] = {
      if (it == size) {
        listRes
      } else {
        val itemTmp = new Item(listTitle(it),listDescr(it),listHref(it),listDate(it),"",List())
        createListItemWikiCfpRec(itemTmp::listRes,it+1)
      }
    }
    res
  }

  //Useful to take only a few elements of a list
  def skip[A](l:List[A], n:Int) = l.zipWithIndex.collect {case (e,i) if ((i+1) % n) == 0 => e} //Thanks StackOverflow

  //Creates list according to every necessary element for creating an item, parsing WikiCFP html output
  def parsePageToItemWikiCfp(listElements : List[String], toSearch : String) : List[Item] = {
    //To format dates correctly

    val listHrefTitle = listElements.filter(x => x.contains("<a href")).map(x => x.replaceAll("(</td>|<td rowspan=\"2\" align=\"left\">)",""))
    val listTitle = listHrefTitle.map(x => x.replaceAll("(<td>)|(</td>)|(</a>)","").split(">")(1))
    val listHref = listHrefTitle.map(x => current.configuration.getString("wikicfp.conf.shorturl").getOrElse("")+x.split("\"")(1))
    val listDescr = listElements.filter(x => x.contains("<td align=\"left\" colspan=\"3\"")).map(x => x.replaceAll("(</td>|<td align=\"left\" colspan=\"3\">)",""))
    val listDateTmp = listElements.filter(x => x.contains("<td align=\"left\">"))
    val listDate = skip(listDateTmp,3).map(x => x.replaceAll("</td>","").split(">")(1))

    val listToFilter = createListItemWikiCfp(listTitle, listHref,listDescr,listDate)
    if(toSearch == "") {//IF empty, we do not use filter as we want more results
      listToFilter
    } else {
      listToFilter.filter(x => (x.description.split(" ").toList.map(y => y.toLowerCase) intersect toSearch.split(" ").toList) != List())
    }
  }

  def jsonToReturnWikiCfp(listsToConcat : List[List[String]], toSearch : String) = {
    val listsToConcatAsItems = listsToConcat.map(x => parsePageToItemWikiCfp(x,toSearch))

    Json.toJson(listsToConcatAsItems.flatten)
  }

  def getWikiCfpWithPage(ws : WSClient, toSearch : String) = {
    for {
      resWiki1 <- getHtmlWikiCfp(current.configuration.getString("wikicfp.conf.url").getOrElse("")+"?page="+1,ws)
      resWiki2 <- getHtmlWikiCfp(current.configuration.getString("wikicfp.conf.url").getOrElse("")+"?page="+2,ws)
      resWiki3 <- getHtmlWikiCfp(current.configuration.getString("wikicfp.conf.url").getOrElse("")+"?page="+3,ws)
      resWiki4 <- getHtmlWikiCfp(current.configuration.getString("wikicfp.conf.url").getOrElse("")+"?page="+4,ws)
      resWiki5 <- getHtmlWikiCfp(current.configuration.getString("wikicfp.conf.url").getOrElse("")+"?page="+5,ws)
    } yield jsonToReturnWikiCfp(List(resWiki1, resWiki2, resWiki3, resWiki4, resWiki5), toSearch)
  }


  def handleWikiCfpSearch(toSearch : String, ws : WSClient) = {
    println("Handling WikiCFP feeds")

    getWikiCfpWithPage(ws, toSearch)
  }

}// -- Object XmlHandler
