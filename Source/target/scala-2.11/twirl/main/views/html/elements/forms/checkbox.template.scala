
package views.html.elements.forms

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object checkbox_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class checkbox extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,String,String,String,Html,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id : String, name : String, label : String, labelClass : String)(content : Html)(implicit m: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.105*/("""

"""),format.raw/*8.3*/("""
"""),format.raw/*9.1*/("""<li class="list-group-item" ng-init="options.one.selected=true">
    """),_display_(/*10.6*/label),format.raw/*10.11*/("""
    """),_display_(/*11.6*/content),format.raw/*11.13*/("""
    """),format.raw/*12.5*/("""<div class="material-switch pull-right">
        <input id=""""),_display_(/*13.21*/id),format.raw/*13.23*/("""" name=""""),_display_(/*13.32*/name),format.raw/*13.36*/("""" type="checkbox" ng-model=""""),_display_(/*13.65*/id),format.raw/*13.67*/("""" ng-checked="options.one.selected"/>
        <label for=""""),_display_(/*14.22*/id),format.raw/*14.24*/("""" class=""""),_display_(/*14.34*/labelClass),format.raw/*14.44*/(""""></label>
    </div>
</li>"""))
      }
    }
  }

  def render(id:String,name:String,label:String,labelClass:String,content:Html,m:Messages): play.twirl.api.HtmlFormat.Appendable = apply(id,name,label,labelClass)(content)(m)

  def f:((String,String,String,String) => (Html) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (id,name,label,labelClass) => (content) => (m) => apply(id,name,label,labelClass)(content)(m)

  def ref: this.type = this

}


}

/**/
object checkbox extends checkbox_Scope0.checkbox
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:30 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/elements/forms/checkbox.scala.html
                  HASH: 9ee9f6baa891cc1440bd824dbdab10a1689f042b
                  MATRIX: 583->1|782->104|810->304|837->305|933->375|959->380|991->386|1019->393|1051->398|1139->459|1162->461|1198->470|1223->474|1279->503|1302->505|1388->564|1411->566|1448->576|1479->586
                  LINES: 20->1|25->1|27->8|28->9|29->10|29->10|30->11|30->11|31->12|32->13|32->13|32->13|32->13|32->13|32->13|33->14|33->14|33->14|33->14
                  -- GENERATED --
              */
          