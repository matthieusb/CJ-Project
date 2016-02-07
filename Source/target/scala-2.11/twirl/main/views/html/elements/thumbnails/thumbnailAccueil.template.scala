
package views.html.elements.thumbnails

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object thumbnailAccueil_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class thumbnailAccueil extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template9[String,String,String,String,String,String,String,Html,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(alt : String, label : String, description : String, hrefBlue : String = "", labelBlue : String = "", hrefWhite : String = "", labelWhite : String = "")(urlImage : Html)(implicit m: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.193*/("""

"""),format.raw/*10.3*/("""

"""),format.raw/*12.1*/("""<div class="col-sm-6 col-md-4 col-xs-12">
    <div class="thumbnail">
        <img class="img-responsive" src=""""),_display_(/*14.43*/urlImage),format.raw/*14.51*/("""" onerror=" this.src='"""),_display_(/*14.74*/routes/*14.80*/.Assets.versioned("images/imageNotFound.jpg")),format.raw/*14.125*/("""';" alt=""""),_display_(/*14.135*/alt),format.raw/*14.138*/(""""/>
        """),_display_(/*15.10*/elements/*15.18*/.thumbnails.thumbnailCaption(label,description,hrefBlue, hrefWhite, labelBlue,labelWhite)),format.raw/*15.107*/("""
    """),format.raw/*16.5*/("""</div>
</div>"""))
      }
    }
  }

  def render(alt:String,label:String,description:String,hrefBlue:String,labelBlue:String,hrefWhite:String,labelWhite:String,urlImage:Html,m:Messages): play.twirl.api.HtmlFormat.Appendable = apply(alt,label,description,hrefBlue,labelBlue,hrefWhite,labelWhite)(urlImage)(m)

  def f:((String,String,String,String,String,String,String) => (Html) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (alt,label,description,hrefBlue,labelBlue,hrefWhite,labelWhite) => (urlImage) => (m) => apply(alt,label,description,hrefBlue,labelBlue,hrefWhite,labelWhite)(urlImage)(m)

  def ref: this.type = this

}


}

/**/
object thumbnailAccueil extends thumbnailAccueil_Scope0.thumbnailAccueil
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:29 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/elements/thumbnails/thumbnailAccueil.scala.html
                  HASH: 76fd5f0536dda2969d44c0cd8ab8abeb421bb822
                  MATRIX: 625->1|912->192|941->405|970->407|1109->519|1138->527|1188->550|1203->556|1270->601|1308->611|1333->614|1373->627|1390->635|1501->724|1533->729
                  LINES: 20->1|25->1|27->10|29->12|31->14|31->14|31->14|31->14|31->14|31->14|31->14|32->15|32->15|32->15|33->16
                  -- GENERATED --
              */
          