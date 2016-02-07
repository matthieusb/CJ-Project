
package views.html.errors

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object onBadRequest_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class onBadRequest extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.26*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <link rel='stylesheet' href='"""),_display_(/*5.39*/routes/*5.45*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap.css")),format.raw/*5.104*/("""'>
        <link rel='stylesheet' href='"""),_display_(/*6.39*/routes/*6.45*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap-theme.css")),format.raw/*6.110*/("""'>
    </head>
    <body>
        <h2>400 - Bad Request</h2>
        <p>You requested: """),_display_(/*10.28*/request/*10.35*/.path),format.raw/*10.40*/("""</p>
        """),format.raw/*11.46*/("""

        """),format.raw/*13.9*/("""<img class="img-responsive" src=""""),_display_(/*13.43*/routes/*13.49*/.Assets.versioned("images/400.png")),format.raw/*13.84*/("""" alt="Error 400 Image"/>
    </body>
</html>"""))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(request)

  def f:((RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (request) => apply(request)

  def ref: this.type = this

}


}

/**/
object onBadRequest extends onBadRequest_Scope0.onBadRequest
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:32 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/errors/onBadRequest.scala.html
                  HASH: 0bb04fff169eaae0d0a4452c62a941f4b9104151
                  MATRIX: 555->1|674->25|702->27|784->83|798->89|878->148|945->189|959->195|1045->260|1160->348|1176->355|1202->360|1243->410|1280->420|1341->454|1356->460|1412->495
                  LINES: 20->1|25->1|27->3|29->5|29->5|29->5|30->6|30->6|30->6|34->10|34->10|34->10|35->11|37->13|37->13|37->13|37->13
                  -- GENERATED --
              */
          