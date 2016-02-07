
package views.html.pages

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object favoris_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class favoris extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(implicit m: Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.57*/("""

"""),_display_(/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
    """),format.raw/*4.5*/("""<div ng-controller="favorisCTRL">
    """),_display_(/*5.6*/elements/*5.14*/.panels.panelAccueil("Vidéos favorites","primary","col-sm-12 col-md-12 col-xs-12","panelBookmarks")/*5.113*/ {_display_(Seq[Any](format.raw/*5.115*/("""

            """),format.raw/*7.13*/("""<div class="row">
                <p ng-show="!favorisVideos.length">Aucune vidéo favorite trouvée !</p>
                <div ng-repeat="favori in favorisVideos">
                    <div my-favoris="" videoID=""""),format.raw/*10.49*/("""{"""),format.raw/*10.50*/("""{"""),format.raw/*10.51*/("""favori.videoId"""),format.raw/*10.65*/("""}"""),format.raw/*10.66*/("""}"""),format.raw/*10.67*/("""" class="col-sm-6 col-md-3 col-xs-12">
                        <div class="thumbnail thumbnailHauteur" id=""""),format.raw/*11.69*/("""{"""),format.raw/*11.70*/("""{"""),format.raw/*11.71*/("""favori.videoId"""),format.raw/*11.85*/("""}"""),format.raw/*11.86*/("""}"""),format.raw/*11.87*/("""">
                            <img id="image" class="img-responsive" ng-src="""),format.raw/*12.75*/("""{"""),format.raw/*12.76*/("""{"""),format.raw/*12.77*/("""favori.image"""),format.raw/*12.89*/("""}"""),format.raw/*12.90*/("""}"""),format.raw/*12.91*/(""" """),format.raw/*12.92*/("""onerror=" this.src='"""),_display_(/*12.113*/routes/*12.119*/.Assets.versioned("images/imageNotFound.jpg")),format.raw/*12.164*/("""';" alt="DU FUTUR"/>
                            <div class="caption">
                                <h3 id="title">"""),format.raw/*14.48*/("""{"""),format.raw/*14.49*/("""{"""),format.raw/*14.50*/("""favori.title"""),format.raw/*14.62*/("""}"""),format.raw/*14.63*/("""}"""),format.raw/*14.64*/("""</h3>
                                <p id="description">"""),format.raw/*15.53*/("""{"""),format.raw/*15.54*/("""{"""),format.raw/*15.55*/("""favori.description"""),format.raw/*15.73*/("""}"""),format.raw/*15.74*/("""}"""),format.raw/*15.75*/("""</p>
                                <p>Publiée : <i id="publishedat">"""),format.raw/*16.66*/("""{"""),format.raw/*16.67*/("""{"""),format.raw/*16.68*/("""favori.publishedAt"""),format.raw/*16.86*/("""}"""),format.raw/*16.87*/("""}"""),format.raw/*16.88*/("""</i></p>

                                <p><a target="_blank" href="https://youtube.com/watch?v="""),format.raw/*18.89*/("""{"""),format.raw/*18.90*/("""{"""),format.raw/*18.91*/("""favori.videoId"""),format.raw/*18.105*/("""}"""),format.raw/*18.106*/("""}"""),format.raw/*18.107*/("""" class="btn btn-primary" role="button">Lien</a>
                                    <button id="supprimervideo" class="btn btn-default" role="button">Supprimer favoris</button></p>
                                """),format.raw/*20.266*/("""
                            """),format.raw/*21.29*/("""</div>
                        </div>
                    </div>
                </div>
            </div>

    """)))}),format.raw/*27.6*/("""
    """),_display_(/*28.6*/elements/*28.14*/.panels.panelAccueil("Articles favoris","primary","col-sm-12 col-md-12 col-xs-12","panelBookmarks")/*28.113*/ {_display_(Seq[Any](format.raw/*28.115*/("""
        """),format.raw/*29.9*/("""<div class="row-fluid">
            <p ng-show="!favorisArticles.length">Aucun article favori trouvé !</p>
            <div ng-repeat="res in favorisArticles">
                <div my-favoris="" class="col-sm-6 col-md-3 col-xs-12">
                    <div class="thumbnail thumbnailHauteur" id=""""),format.raw/*33.65*/("""{"""),format.raw/*33.66*/("""{"""),format.raw/*33.67*/("""res.link"""),format.raw/*33.75*/("""}"""),format.raw/*33.76*/("""}"""),format.raw/*33.77*/("""">
                        <img ng-hide="res.urlImage == ''" class="img-responsive" ng-src=""""),format.raw/*34.90*/("""{"""),format.raw/*34.91*/("""{"""),format.raw/*34.92*/("""res.urlImage"""),format.raw/*34.104*/("""}"""),format.raw/*34.105*/("""}"""),format.raw/*34.106*/("""" alt="Image Resultat"/>
                        <img ng-show="res.urlImage == ''" class="img-responsive" src=""""),_display_(/*35.88*/routes/*35.94*/.Assets.versioned("images/imageNotFound.jpg")),format.raw/*35.139*/(""""   alt="Image Resultat"/>

                        <div class="caption">
                            <h3>"""),format.raw/*38.33*/("""{"""),format.raw/*38.34*/("""{"""),format.raw/*38.35*/("""res.title"""),format.raw/*38.44*/("""}"""),format.raw/*38.45*/("""}"""),format.raw/*38.46*/("""</h3>
                            <p><a id="link" target="_blank" href=""""),format.raw/*39.67*/("""{"""),format.raw/*39.68*/("""{"""),format.raw/*39.69*/("""res.link"""),format.raw/*39.77*/("""}"""),format.raw/*39.78*/("""}"""),format.raw/*39.79*/("""" class="btn btn-primary" role="button">Lien</a>
                                <button id="supprimerarticle" class="btn btn-default" role="button">Supprimer favoris</button>
                            </p>
                            <p>"""),format.raw/*42.32*/("""{"""),format.raw/*42.33*/("""{"""),format.raw/*42.34*/("""res.description"""),format.raw/*42.49*/("""}"""),format.raw/*42.50*/("""}"""),format.raw/*42.51*/("""</p>
                            <p>Date : """),format.raw/*43.39*/("""{"""),format.raw/*43.40*/("""{"""),format.raw/*43.41*/("""res.date"""),format.raw/*43.49*/("""}"""),format.raw/*43.50*/("""}"""),format.raw/*43.51*/(""" """),format.raw/*43.52*/("""{"""),format.raw/*43.53*/("""{"""),format.raw/*43.54*/("""res.urlImage"""),format.raw/*43.66*/("""}"""),format.raw/*43.67*/("""}"""),format.raw/*43.68*/("""</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    """)))}),format.raw/*49.6*/("""
    """),format.raw/*50.5*/("""</div>
    """),format.raw/*51.33*/("""
""")))}),format.raw/*52.2*/(""" """))
      }
    }
  }

  def render(title:String,m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(title)(m,session)

  def f:((String) => (Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (title) => (m,session) => apply(title)(m,session)

  def ref: this.type = this

}


}

/**/
object favoris extends favoris_Scope0.favoris
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:30 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/pages/favoris.scala.html
                  HASH: 5ca46f88b9a98972734bba1cda5c32e20d37cd81
                  MATRIX: 554->1|704->56|732->59|751->70|790->72|821->77|885->116|901->124|1009->223|1049->225|1090->239|1329->450|1358->451|1387->452|1429->466|1458->467|1487->468|1622->575|1651->576|1680->577|1722->591|1751->592|1780->593|1885->670|1914->671|1943->672|1983->684|2012->685|2041->686|2070->687|2119->708|2135->714|2202->759|2348->877|2377->878|2406->879|2446->891|2475->892|2504->893|2590->951|2619->952|2648->953|2694->971|2723->972|2752->973|2850->1043|2879->1044|2908->1045|2954->1063|2983->1064|3012->1065|3138->1163|3167->1164|3196->1165|3239->1179|3269->1180|3299->1181|3542->1628|3599->1657|3742->1770|3774->1776|3791->1784|3900->1883|3941->1885|3977->1894|4301->2190|4330->2191|4359->2192|4395->2200|4424->2201|4453->2202|4573->2294|4602->2295|4631->2296|4672->2308|4702->2309|4732->2310|4871->2422|4886->2428|4953->2473|5087->2579|5116->2580|5145->2581|5182->2590|5211->2591|5240->2592|5340->2664|5369->2665|5398->2666|5434->2674|5463->2675|5492->2676|5760->2916|5789->2917|5818->2918|5861->2933|5890->2934|5919->2935|5990->2978|6019->2979|6048->2980|6084->2988|6113->2989|6142->2990|6171->2991|6200->2992|6229->2993|6269->3005|6298->3006|6327->3007|6482->3132|6514->3137|6553->3176|6585->3178
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|29->5|29->5|29->5|29->5|31->7|34->10|34->10|34->10|34->10|34->10|34->10|35->11|35->11|35->11|35->11|35->11|35->11|36->12|36->12|36->12|36->12|36->12|36->12|36->12|36->12|36->12|36->12|38->14|38->14|38->14|38->14|38->14|38->14|39->15|39->15|39->15|39->15|39->15|39->15|40->16|40->16|40->16|40->16|40->16|40->16|42->18|42->18|42->18|42->18|42->18|42->18|44->20|45->21|51->27|52->28|52->28|52->28|52->28|53->29|57->33|57->33|57->33|57->33|57->33|57->33|58->34|58->34|58->34|58->34|58->34|58->34|59->35|59->35|59->35|62->38|62->38|62->38|62->38|62->38|62->38|63->39|63->39|63->39|63->39|63->39|63->39|66->42|66->42|66->42|66->42|66->42|66->42|67->43|67->43|67->43|67->43|67->43|67->43|67->43|67->43|67->43|67->43|67->43|67->43|73->49|74->50|75->51|76->52
                  -- GENERATED --
              */
          