
package views.html.errors

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object onHandlerNotFound_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class onHandlerNotFound extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(request : RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <link rel='stylesheet' href='"""),_display_(/*5.39*/routes/*5.45*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap.css")),format.raw/*5.104*/("""'>
        <link rel='stylesheet' href='"""),_display_(/*6.39*/routes/*6.45*/.Assets.versioned("bootstrap-3.3.6-dist/css/bootstrap-theme.css")),format.raw/*6.110*/("""'>
    </head>
    <body>
        <h2>404 - Page Not Found</h2>
        <p>You requested: """),_display_(/*10.28*/request/*10.35*/.path),format.raw/*10.40*/("""</p>

        <img class="img-responsive" src=""""),_display_(/*12.43*/routes/*12.49*/.Assets.versioned("images/404.gif")),format.raw/*12.84*/("""" alt="404"/><br/>
        <a class="navbar-brand" href=""""),_display_(/*13.40*/routes/*13.46*/.Application.index()),format.raw/*13.66*/("""">Back to Home</a>
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
object onHandlerNotFound extends onHandlerNotFound_Scope0.onHandlerNotFound
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:32 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/errors/onHandlerNotFound.scala.html
                  HASH: bb142eef52fc3fbb05252d19d9044c439f833055
                  MATRIX: 565->1|685->26|713->28|795->84|809->90|889->149|956->190|970->196|1056->261|1174->352|1190->359|1216->364|1291->412|1306->418|1362->453|1447->511|1462->517|1503->537
                  LINES: 20->1|25->1|27->3|29->5|29->5|29->5|30->6|30->6|30->6|34->10|34->10|34->10|36->12|36->12|36->12|37->13|37->13|37->13
                  -- GENERATED --
              */
          