
package views.html.elements.panels

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object panelAccueil_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class panelAccueil extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,String,String,String,Html,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title : String, typePanel : String, classes : String, idPanel : String)(content: Html)(implicit m: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.111*/("""

"""),format.raw/*12.3*/("""

"""),format.raw/*14.1*/("""<div class=""""),_display_(/*14.14*/classes),format.raw/*14.21*/("""" id=""""),_display_(/*14.28*/idPanel),format.raw/*14.35*/("""">
    <div class="panel panel-"""),_display_(/*15.30*/typePanel),format.raw/*15.39*/("""">
        <div class="panel-heading">
            <h3 class="panel-title">"""),_display_(/*17.38*/title),format.raw/*17.43*/("""</h3>
        </div>
        <div class="panel-body">
            """),_display_(/*20.14*/content),format.raw/*20.21*/("""
        """),format.raw/*21.9*/("""</div>
    </div>
</div>

"""))
      }
    }
  }

  def render(title:String,typePanel:String,classes:String,idPanel:String,content:Html,m:Messages): play.twirl.api.HtmlFormat.Appendable = apply(title,typePanel,classes,idPanel)(content)(m)

  def f:((String,String,String,String) => (Html) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (title,typePanel,classes,idPanel) => (content) => (m) => apply(title,typePanel,classes,idPanel)(content)(m)

  def ref: this.type = this

}


}

/**/
object panelAccueil extends panelAccueil_Scope0.panelAccueil
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:30 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/elements/panels/panelAccueil.scala.html
                  HASH: a87fd333eb87558af4dfe0eaa5a25af6fc5256f3
                  MATRIX: 592->1|797->110|826->393|855->395|895->408|923->415|957->422|985->429|1044->461|1074->470|1177->546|1203->551|1297->618|1325->625|1361->634
                  LINES: 20->1|25->1|27->12|29->14|29->14|29->14|29->14|29->14|30->15|30->15|32->17|32->17|35->20|35->20|36->21
                  -- GENERATED --
              */
          