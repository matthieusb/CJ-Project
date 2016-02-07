
package views.html.errors

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object onUnauthorized_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class onUnauthorized extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(implicit m: Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.57*/("""

"""),_display_(/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
    """),format.raw/*4.5*/("""<h2>Error 403 - Vous n'avez pas accès à cette ressource </h2> """),format.raw/*4.95*/("""
""")))}),format.raw/*5.2*/("""
"""))
      }
    }
  }

  def render(title:String,m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(title)(m,session)

  def f:((String) => (Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (title) => (m,session) => apply(title)(m,session)

  def ref: this.type = this

}


}

/**/
object onUnauthorized extends onUnauthorized_Scope0.onUnauthorized
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:32 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/errors/onUnauthorized.scala.html
                  HASH: 9a4d2454867c802cb20d6c8763848cf8d3cf00c7
                  MATRIX: 569->1|719->56|747->59|766->70|805->72|836->77|925->167|956->169
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|28->4|29->5
                  -- GENERATED --
              */
          