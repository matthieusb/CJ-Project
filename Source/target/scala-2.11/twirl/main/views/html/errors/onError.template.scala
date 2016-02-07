
package views.html.errors

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object onError_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class onError extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Throwable,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(throwable : Throwable):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.25*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <link rel='stylesheet' href='"""),_display_(/*5.39*/routes/*5.45*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap.css")),format.raw/*5.104*/("""'>
        <link rel='stylesheet' href='"""),_display_(/*6.39*/routes/*6.45*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap-theme.css")),format.raw/*6.110*/("""'>
    </head>
    <body>
        <h2>Error 500 - An error occured </h2>
        <p>"""),_display_(/*10.13*/throwable/*10.22*/.getMessage),format.raw/*10.33*/("""</p>

        <img class="img-responsive" src=""""),_display_(/*12.43*/routes/*12.49*/.Assets.versioned("images/500.png")),format.raw/*12.84*/("""" alt="Error 500 Image"/>s
    </body>
</html>"""))
      }
    }
  }

  def render(throwable:Throwable): play.twirl.api.HtmlFormat.Appendable = apply(throwable)

  def f:((Throwable) => play.twirl.api.HtmlFormat.Appendable) = (throwable) => apply(throwable)

  def ref: this.type = this

}


}

/**/
object onError extends onError_Scope0.onError
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:32 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/errors/onError.scala.html
                  HASH: a50c79b8494621573ad9a13034c663265b72cf9c
                  MATRIX: 541->1|659->24|687->26|769->82|783->88|863->147|930->188|944->194|1030->259|1142->344|1160->353|1192->364|1267->412|1282->418|1338->453
                  LINES: 20->1|25->1|27->3|29->5|29->5|29->5|30->6|30->6|30->6|34->10|34->10|34->10|36->12|36->12|36->12
                  -- GENERATED --
              */
          