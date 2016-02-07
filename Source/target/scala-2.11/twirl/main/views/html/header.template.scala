
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object header_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class header extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Html,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, includesHeader: Html)(implicit m: Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.79*/("""

"""),format.raw/*3.1*/("""<head>
    """),format.raw/*4.17*/("""
    """),format.raw/*5.5*/("""<meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>"""),_display_(/*6.13*/Messages("tpl.main.title")),format.raw/*6.39*/(""" """),format.raw/*6.40*/("""- """),_display_(/*6.43*/Messages(s"tpl.nav.${title}")),format.raw/*6.72*/("""</title>
    <link rel="shortcut icon" href=""""),_display_(/*7.38*/routes/*7.44*/.Assets.versioned("images/logos/aperture.png")),format.raw/*7.90*/("""" type="image/x-icon" />

    """),format.raw/*9.18*/("""
    """),format.raw/*10.131*/("""
    """),format.raw/*11.5*/("""<script defer="defer" type="text/javascript" src='"""),_display_(/*11.56*/routes/*11.62*/.Assets.versioned("javascripts/jquery-2.1.4.js")),format.raw/*11.110*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*12.56*/routes/*12.62*/.Assets.versioned("javascripts/jquery-dateFormat.js")),format.raw/*12.115*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*13.56*/routes/*13.62*/.Assets.versioned("javascripts/angular.js")),format.raw/*13.105*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*14.56*/routes/*14.62*/.Assets.versioned("javascripts/dirPagination.js")),format.raw/*14.111*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*15.56*/routes/*15.62*/.Assets.versioned("javascripts/jqcloud.js")),format.raw/*15.105*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*16.56*/routes/*16.62*/.Assets.versioned("javascripts/angular-jqcloud.js")),format.raw/*16.113*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*17.56*/routes/*17.62*/.Assets.versioned("javascripts/angular-sanitize.js")),format.raw/*17.114*/("""'></script>
    <script defer="defer" type="text/javascript" src=""""),_display_(/*18.56*/routes/*18.62*/.Assets.versioned("javascripts/timeline/angular-timeline.js")),format.raw/*18.123*/(""""></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*19.56*/routes/*19.62*/.Assets.versioned("javascripts/main.js")),format.raw/*19.102*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*20.56*/routes/*20.62*/.Assets.versioned("javascripts/appelsRest.js")),format.raw/*20.108*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*21.56*/routes/*21.62*/.Assets.versioned("javascripts/TextLearning.js")),format.raw/*21.110*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*22.56*/routes/*22.62*/.Assets.versioned("javascripts/websocket.js")),format.raw/*22.107*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*23.56*/routes/*23.62*/.Assets.versioned("bootstrap-3.3.6-dist/js/bootstrap.js")),format.raw/*23.119*/("""'></script>
    <script defer="defer" type="text/javascript" src='"""),_display_(/*24.56*/routes/*24.62*/.Assets.versioned("javascripts/jquery.bootstrap-touchspin.js")),format.raw/*24.124*/("""'></script>

    """),format.raw/*26.28*/("""
    """),format.raw/*27.5*/("""<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css" />
    <link rel='stylesheet' href='"""),_display_(/*28.35*/routes/*28.41*/.WebJarAssets.at(WebJarAssets.locate("css/font-awesome.min.css"))),format.raw/*28.106*/("""'>
    <link rel='stylesheet' href='"""),_display_(/*29.35*/routes/*29.41*/.Assets.versioned("stylesheets/main.css")),format.raw/*29.82*/("""'>
    <link rel='stylesheet' href='"""),_display_(/*30.35*/routes/*30.41*/.Assets.versioned("stylesheets/footer.css")),format.raw/*30.84*/("""'>
    <link rel='stylesheet' href='"""),_display_(/*31.35*/routes/*31.41*/.Assets.versioned("stylesheets/spinner.css")),format.raw/*31.85*/("""'>
    <link rel='stylesheet' href='"""),_display_(/*32.35*/routes/*32.41*/.Assets.versioned("stylesheets/jqcloud.css")),format.raw/*32.85*/("""'>

    <link rel="stylesheet" href=""""),_display_(/*34.35*/routes/*34.41*/.Assets.versioned("stylesheets/timeline/angular-timeline.css")),format.raw/*34.103*/("""" />
    <link rel="stylesheet" href=""""),_display_(/*35.35*/routes/*35.41*/.Assets.versioned("stylesheets/timeline/angular-timeline-bootstrap.css")),format.raw/*35.113*/("""" />
    <link rel="stylesheet" href=""""),_display_(/*36.35*/routes/*36.41*/.Assets.versioned("stylesheets/timeline/angular-timeline-animations.css")),format.raw/*36.114*/("""" />

    <link rel='stylesheet' href='"""),_display_(/*38.35*/routes/*38.41*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap.css")),format.raw/*38.100*/("""'>
    <link rel='stylesheet' href='"""),_display_(/*39.35*/routes/*39.41*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap-theme.css")),format.raw/*39.106*/("""'>

    """),_display_(/*41.6*/includesHeader),format.raw/*41.20*/("""
"""),format.raw/*42.1*/("""</head>"""))
      }
    }
  }

  def render(title:String,includesHeader:Html,m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(title,includesHeader)(m,session)

  def f:((String,Html) => (Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (title,includesHeader) => (m,session) => apply(title,includesHeader)(m,session)

  def ref: this.type = this

}


}

/**/
object header extends header_Scope0.header
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:29 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/header.scala.html
                  HASH: 3864620b63d9cbfc2fa4093abdb3e3991d1fbcfc
                  MATRIX: 551->1|723->78|751->80|789->103|820->108|926->188|972->214|1000->215|1029->218|1078->247|1150->293|1164->299|1230->345|1287->388|1321->519|1353->524|1431->575|1446->581|1516->629|1610->696|1625->702|1700->755|1794->822|1809->828|1874->871|1968->938|1983->944|2054->993|2148->1060|2163->1066|2228->1109|2322->1176|2337->1182|2410->1233|2504->1300|2519->1306|2593->1358|2687->1425|2702->1431|2785->1492|2879->1559|2894->1565|2956->1605|3050->1672|3065->1678|3133->1724|3227->1791|3242->1797|3312->1845|3406->1912|3421->1918|3488->1963|3582->2030|3597->2036|3676->2093|3770->2160|3785->2166|3869->2228|3914->2268|3946->2273|4125->2425|4140->2431|4227->2496|4291->2533|4306->2539|4368->2580|4432->2617|4447->2623|4511->2666|4575->2703|4590->2709|4655->2753|4719->2790|4734->2796|4799->2840|4864->2878|4879->2884|4963->2946|5029->2985|5044->2991|5138->3063|5204->3102|5219->3108|5314->3181|5381->3221|5396->3227|5477->3286|5541->3323|5556->3329|5643->3394|5678->3403|5713->3417|5741->3418
                  LINES: 20->1|25->1|27->3|28->4|29->5|30->6|30->6|30->6|30->6|30->6|31->7|31->7|31->7|33->9|34->10|35->11|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|42->18|43->19|43->19|43->19|44->20|44->20|44->20|45->21|45->21|45->21|46->22|46->22|46->22|47->23|47->23|47->23|48->24|48->24|48->24|50->26|51->27|52->28|52->28|52->28|53->29|53->29|53->29|54->30|54->30|54->30|55->31|55->31|55->31|56->32|56->32|56->32|58->34|58->34|58->34|59->35|59->35|59->35|60->36|60->36|60->36|62->38|62->38|62->38|63->39|63->39|63->39|65->41|65->41|66->42
                  -- GENERATED --
              */
          