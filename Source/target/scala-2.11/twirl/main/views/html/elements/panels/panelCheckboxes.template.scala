
package views.html.elements.panels

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object panelCheckboxes_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class panelCheckboxes extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[String,String,String,String,String,Html,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title : String, typePanel : String, classes : String, idPanel : String, idListe : String)(listItems: Html)(implicit m: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.131*/("""

"""),format.raw/*3.1*/("""<div class=""""),_display_(/*3.14*/classes),format.raw/*3.21*/("""" id=""""),_display_(/*3.28*/idPanel),format.raw/*3.35*/("""">
    <div class="panel """),_display_(/*4.24*/typePanel),format.raw/*4.33*/("""">
        <div class="panel-heading">"""),_display_(/*5.37*/title),format.raw/*5.42*/("""</div>
        <ul class="list-group" id=""""),_display_(/*6.37*/idListe),format.raw/*6.44*/("""">
            """),_display_(/*7.14*/listItems),format.raw/*7.23*/("""
        """),format.raw/*8.9*/("""</ul>
    </div>
</div>
"""))
      }
    }
  }

  def render(title:String,typePanel:String,classes:String,idPanel:String,idListe:String,listItems:Html,m:Messages): play.twirl.api.HtmlFormat.Appendable = apply(title,typePanel,classes,idPanel,idListe)(listItems)(m)

  def f:((String,String,String,String,String) => (Html) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (title,typePanel,classes,idPanel,idListe) => (listItems) => (m) => apply(title,typePanel,classes,idPanel,idListe)(listItems)(m)

  def ref: this.type = this

}


}

/**/
object panelCheckboxes extends panelCheckboxes_Scope0.panelCheckboxes
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:30 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/elements/panels/panelCheckboxes.scala.html
                  HASH: 324a02b44256929d7321ced26bc0c92629e684ce
                  MATRIX: 605->1|830->130|858->132|897->145|924->152|957->159|984->166|1036->192|1065->201|1130->240|1155->245|1224->288|1251->295|1293->311|1322->320|1357->329
                  LINES: 20->1|25->1|27->3|27->3|27->3|27->3|27->3|28->4|28->4|29->5|29->5|30->6|30->6|31->7|31->7|32->8
                  -- GENERATED --
              */
          