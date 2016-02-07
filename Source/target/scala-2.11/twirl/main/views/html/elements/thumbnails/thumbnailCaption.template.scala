
package views.html.elements.thumbnails

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object thumbnailCaption_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class thumbnailCaption extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[String,String,String,String,String,String,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(label : String, description : String, hrefBlue : String, hrefWhite : String, labelBlue : String, labelWhite : String)(implicit m: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.142*/("""

"""),format.raw/*9.3*/("""

"""),format.raw/*11.1*/("""<div class="caption">
    <h3>"""),_display_(/*12.10*/label),format.raw/*12.15*/("""</h3>
    <p>"""),_display_(/*13.9*/description),format.raw/*13.20*/("""</p>

    <p>
        """),format.raw/*16.66*/("""

        """),_display_(/*18.10*/if(hrefBlue == "" && hrefWhite == "")/*18.47*/ {_display_(Seq[Any](format.raw/*18.49*/("""
            """),_display_(/*19.14*/Messages("thumbnail.nolinks")),format.raw/*19.43*/("""
        """)))}/*20.11*/else/*20.16*/{_display_(Seq[Any](format.raw/*20.17*/("""
            """),_display_(/*21.14*/if(hrefBlue != "")/*21.32*/{_display_(Seq[Any](format.raw/*21.33*/("""
                """),format.raw/*22.17*/("""<a href=""""),_display_(/*22.27*/hrefBlue),format.raw/*22.35*/("""" class="btn btn-primary" role="button">"""),_display_(/*22.76*/labelBlue),format.raw/*22.85*/("""</a>
            """)))}),format.raw/*23.14*/("""

            """),_display_(/*25.14*/if(hrefWhite != "")/*25.33*/{_display_(Seq[Any](format.raw/*25.34*/("""
                """),format.raw/*26.17*/("""<a href=""""),_display_(/*26.27*/hrefWhite),format.raw/*26.36*/("""" class="btn btn-default" role="button">"""),_display_(/*26.77*/labelWhite),format.raw/*26.87*/("""</a>
            """)))}),format.raw/*27.14*/("""
        """)))}),format.raw/*28.10*/("""
    """),format.raw/*29.5*/("""</p>
</div>"""))
      }
    }
  }

  def render(label:String,description:String,hrefBlue:String,hrefWhite:String,labelBlue:String,labelWhite:String,m:Messages): play.twirl.api.HtmlFormat.Appendable = apply(label,description,hrefBlue,hrefWhite,labelBlue,labelWhite)(m)

  def f:((String,String,String,String,String,String) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (label,description,hrefBlue,hrefWhite,labelBlue,labelWhite) => (m) => apply(label,description,hrefBlue,hrefWhite,labelBlue,labelWhite)(m)

  def ref: this.type = this

}


}

/**/
object thumbnailCaption extends thumbnailCaption_Scope0.thumbnailCaption
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:29 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/elements/thumbnails/thumbnailCaption.scala.html
                  HASH: 25f4ab7a5d835571b43c6c18f6188028f195748e
                  MATRIX: 613->1|849->141|877->275|906->277|964->308|990->313|1030->327|1062->338|1112->417|1150->428|1196->465|1236->467|1277->481|1327->510|1356->521|1369->526|1408->527|1449->541|1476->559|1515->560|1560->577|1597->587|1626->595|1694->636|1724->645|1773->663|1815->678|1843->697|1882->698|1927->715|1964->725|1994->734|2062->775|2093->785|2142->803|2183->813|2215->818
                  LINES: 20->1|25->1|27->9|29->11|30->12|30->12|31->13|31->13|34->16|36->18|36->18|36->18|37->19|37->19|38->20|38->20|38->20|39->21|39->21|39->21|40->22|40->22|40->22|40->22|40->22|41->23|43->25|43->25|43->25|44->26|44->26|44->26|44->26|44->26|45->27|46->28|47->29
                  -- GENERATED --
              */
          