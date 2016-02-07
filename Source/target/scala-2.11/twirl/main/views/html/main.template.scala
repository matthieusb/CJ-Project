
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Html,Html,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, includesHeader: Html = Html(""))(content: Html)(implicit m: Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.105*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html ng-app="appelsRest" lang=""""),_display_(/*5.34*/m/*5.35*/.lang),format.raw/*5.40*/("""">

    """),_display_(/*7.6*/header(title, includesHeader)),format.raw/*7.35*/("""

    """),format.raw/*9.5*/("""<body>
        """),_display_(/*10.10*/nav(title)),format.raw/*10.20*/("""

        """),_display_(/*12.10*/content),format.raw/*12.17*/("""

        """),_display_(/*14.10*/footer(m,session)),format.raw/*14.27*/("""
    """),format.raw/*15.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,includesHeader:Html,content:Html,m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(title,includesHeader)(content)(m,session)

  def f:((String,Html) => (Html) => (Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (title,includesHeader) => (content) => (m,session) => apply(title,includesHeader)(content)(m,session)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:29 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/main.scala.html
                  HASH: 0776a7ccbc9ecbbee908fb915a49cb5d20c2a159
                  MATRIX: 552->1|751->104|779->106|855->156|864->157|889->162|923->171|972->200|1004->206|1047->222|1078->232|1116->243|1144->250|1182->261|1220->278|1252->283
                  LINES: 20->1|25->1|27->3|29->5|29->5|29->5|31->7|31->7|33->9|34->10|34->10|36->12|36->12|38->14|38->14|39->15
                  -- GENERATED --
              */
          