
package views.html.pages

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object inscription_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class inscription extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(implicit m: Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.57*/("""

"""),_display_(/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
    """),_display_(/*4.6*/elements/*4.14*/.panels.panelAccueil(Messages("page.Home.inscription"),"primary","col-sm-12 col-md-12 col-xs-12","panelRegister")/*4.127*/ {_display_(Seq[Any](format.raw/*4.129*/("""

        """),format.raw/*6.9*/("""<form id="inscription">
            <div class="form-group">
                <label for="login">Email address</label>
                <input required type="email" class="form-control" id="login" name="login" placeholder="Email">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input required type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>

            <div id="error-inscription" style="display:none;color:red"></div>

            <input class="btn btn-default" type="submit" value="S'inscrire">
        </form>
    """)))}),format.raw/*20.6*/(""" """),format.raw/*20.35*/("""
""")))}))
      }
    }
  }

  def render(title:String,m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(title)(m,session)

  def f:((String) => (Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (title) => (m,session) => apply(title)(m,session)

  def ref: this.type = this

}


}

/**/
object inscription extends inscription_Scope0.inscription
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:30 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/pages/inscription.scala.html
                  HASH: 9fe6a3e4704a4a22659cfac4505ba35daecfc5c4
                  MATRIX: 562->1|712->56|740->59|759->70|798->72|829->78|845->86|967->199|1007->201|1043->211|1733->871|1762->900
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|28->4|28->4|28->4|30->6|44->20|44->20
                  -- GENERATED --
              */
          