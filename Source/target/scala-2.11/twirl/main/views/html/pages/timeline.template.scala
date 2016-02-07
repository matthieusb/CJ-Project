
package views.html.pages

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object timeline_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class timeline extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(implicit m: Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.57*/("""

"""),_display_(/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
    """),format.raw/*4.5*/("""<script defer="defer" type="text/javascript" src='"""),_display_(/*4.56*/routes/*4.62*/.Assets.versioned("javascripts/timeline.js")),format.raw/*4.106*/("""'></script>

    <div ng-controller="TimelineCtrl">
        <h1>Conférences à venir</h1>
        <button class="btn" ng-click="leftAlign()">Aligner à gauche</button>
        <button class="btn" ng-click="rightAlign()">Aligner à droite</button>
        <button class="btn" ng-click="defaultAlign()">Alterner l'alignement</button>
        <br/>
        <br/>

        <img ng-show="!events.length" class="img-responsive center-block" ng-src=""""),_display_(/*14.84*/routes/*14.90*/.Assets.versioned("images/loading.gif")),format.raw/*14.129*/("""" alt="Image Chargement"/>

        <timeline>
                <!-- can also hard-code to side="left" or side="right" -->
            <timeline-event ng-repeat="event in events" side=""""),format.raw/*18.63*/("""{"""),format.raw/*18.64*/("""{"""),format.raw/*18.65*/("""side"""),format.raw/*18.69*/("""}"""),format.raw/*18.70*/("""}"""),format.raw/*18.71*/("""">
                    <!-- uses angular-scroll-animate to give it some pop -->
                <timeline-badge class=""""),format.raw/*20.40*/("""{"""),format.raw/*20.41*/("""{"""),format.raw/*20.42*/("""event.badgeClass"""),format.raw/*20.58*/("""}"""),format.raw/*20.59*/("""}"""),format.raw/*20.60*/(""" """),format.raw/*20.61*/("""timeline-hidden"
                when-visible="animateElementIn" when-not-visible="animateElementOut">
                    <i class="glyphicon """),format.raw/*22.41*/("""{"""),format.raw/*22.42*/("""{"""),format.raw/*22.43*/("""event.badgeIconClass"""),format.raw/*22.63*/("""}"""),format.raw/*22.64*/("""}"""),format.raw/*22.65*/(""""></i>
                </timeline-badge>

                    <!-- uses angular-scroll-animate to give it some pop -->
                <timeline-panel class=""""),format.raw/*26.40*/("""{"""),format.raw/*26.41*/("""{"""),format.raw/*26.42*/("""event.badgeClass"""),format.raw/*26.58*/("""}"""),format.raw/*26.59*/("""}"""),format.raw/*26.60*/(""" """),format.raw/*26.61*/("""timeline-hidden"
                when-visible="animateElementIn" when-not-visible="animateElementOut">
                    <timeline-heading>
                        <h4>"""),format.raw/*29.29*/("""{"""),format.raw/*29.30*/("""{"""),format.raw/*29.31*/("""event.title"""),format.raw/*29.42*/("""}"""),format.raw/*29.43*/("""}"""),format.raw/*29.44*/("""</h4>

                        <p ng-if="event.when">
                            <small class="text-muted"><i class="glyphicon glyphicon-time"></i>"""),format.raw/*32.95*/("""{"""),format.raw/*32.96*/("""{"""),format.raw/*32.97*/("""event.when"""),format.raw/*32.107*/("""}"""),format.raw/*32.108*/("""}"""),format.raw/*32.109*/("""</small>
                        </p>
                        <p ng-if="event.titleContentHtml" ng-bind-html="event.titleContentHtml">
                        </p>
                    </timeline-heading>
                    <p ng-bind-html="event.contentHtml"></p>
                    <timeline-footer ng-if="event.footerContentHtml">
                        <span ng-bind-html="event.footerContentHtml"></span>
                    </timeline-footer>
                </timeline-panel>
            </timeline-event>
        </timeline>
    </div>
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
object timeline extends timeline_Scope0.timeline
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:30 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/pages/timeline.scala.html
                  HASH: ee6b57ea8b53afe428a0b46739a6b2578efcee5f
                  MATRIX: 556->1|706->56|734->59|753->70|792->72|823->77|900->128|914->134|979->178|1447->619|1462->625|1523->664|1735->848|1764->849|1793->850|1825->854|1854->855|1883->856|2030->975|2059->976|2088->977|2132->993|2161->994|2190->995|2219->996|2390->1139|2419->1140|2448->1141|2496->1161|2525->1162|2554->1163|2740->1321|2769->1322|2798->1323|2842->1339|2871->1340|2900->1341|2929->1342|3127->1512|3156->1513|3185->1514|3224->1525|3253->1526|3282->1527|3458->1675|3487->1676|3516->1677|3555->1687|3585->1688|3615->1689
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|28->4|28->4|28->4|38->14|38->14|38->14|42->18|42->18|42->18|42->18|42->18|42->18|44->20|44->20|44->20|44->20|44->20|44->20|44->20|46->22|46->22|46->22|46->22|46->22|46->22|50->26|50->26|50->26|50->26|50->26|50->26|50->26|53->29|53->29|53->29|53->29|53->29|53->29|56->32|56->32|56->32|56->32|56->32|56->32
                  -- GENERATED --
              */
          