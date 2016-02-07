
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object footer_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class footer extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(implicit m : Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.43*/("""

"""),format.raw/*3.1*/("""<footer class="footer-distributed col-md-12 col-lg-12 col-sm-12 col-xs-12">
    """),format.raw/*4.26*/("""
    """),format.raw/*5.5*/("""<div class="footer-left">
        <h3>Aperture Science</h3>
        <p class="footer-links">
            <a href="http://www.aperturescience.com/">"""),_display_(/*8.56*/Messages("foot.word.site")),format.raw/*8.82*/("""</a>
            ·
            <a href="http://prenezlapose.tumblr.com/">Blog</a>
            ·
            <!--<a href="http://eisti.fr/fr/lecole/financer-ses-etudes">"""),_display_(/*12.74*/Messages("foot.word.prices")),format.raw/*12.102*/("""</a>-->
        </p>
        <p class="footer-company-name">Aperture Science &copy; 2016</p>
    </div>
    """),format.raw/*16.27*/("""
    """),format.raw/*17.5*/("""<div class="footer-center">
        <div>
            <i class="fa fa-map-marker"></i>
            <p><span>Aperture Science Enrichment Center</span> Upper Michigan, USA</p>
        </div>
    <!--
        <div>
            <i class="fa fa-phone"></i>
            <p>+33 5 59 05 90 90</p>
        </div>
    -->

        <div>
            <i class="fa fa-envelope"></i>
            <p><a href="mailto:cave.johnson&#64;glados.as">cave.johnson&#64;glados.as</a></p>
        </div>
    </div>
    """),format.raw/*34.27*/("""
    """),format.raw/*35.5*/("""<div class="footer-right">

        <p class="footer-company-about">
            <span>"""),_display_(/*38.20*/Messages("foot.title.aboutUs")),format.raw/*38.50*/("""</span>
            """),_display_(/*39.14*/Messages("foot.sentence.aboutUs")),format.raw/*39.47*/("""
        """),format.raw/*40.9*/("""</p>

    <!--
        <div class="footer-icons">
            <a href="https://www.facebook.com/myEISTI/"><i class="fa fa-facebook"></i></a>
            <a href="https://twitter.com/MyEISTI?lang=fr"><i class="fa fa-twitter"></i></a>
            <a href="https://www.linkedin.com/company/90272?trk=tyah&trkInfo=clickedVertical%3Acompany%2CclickedEntityId%3A90272%2Cidx%3A3-1-5%2CtarId%3A1449604653953%2Ctas%3AEisti"><i class="fa fa-linkedin"></i></a>
        </div>
    -->

    </div>

</footer>

"""))
      }
    }
  }

  def render(m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(m,session)

  def f:((Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (m,session) => apply(m,session)

  def ref: this.type = this

}


}

/**/
object footer extends footer_Scope0.footer
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:27 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/footer.scala.html
                  HASH: b1256de86ce5c2a0fa9d23756b807e96a989b213
                  MATRIX: 539->1|675->42|703->44|810->145|841->150|1015->298|1061->324|1257->493|1307->521|1443->651|1475->656|1997->1172|2029->1177|2144->1265|2195->1295|2243->1316|2297->1349|2333->1358
                  LINES: 20->1|25->1|27->3|28->4|29->5|32->8|32->8|36->12|36->12|40->16|41->17|58->34|59->35|62->38|62->38|63->39|63->39|64->40
                  -- GENERATED --
              */
          