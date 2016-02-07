
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(implicit m: Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.57*/("""

"""),_display_(/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
    """),format.raw/*4.5*/("""<script defer="defer" type="text/javascript" src='"""),_display_(/*4.56*/routes/*4.62*/.Assets.versioned("javascripts/home.js")),format.raw/*4.102*/("""'></script>

    <div ng-controller="HomeCtrl">
        """),format.raw/*7.30*/("""
        """),_display_(/*8.10*/elements/*8.18*/.panels.panelAccueil(Messages("page.Home.panelNews"),"primary","col-sm-12 col-md-12 col-xs-12","panelNews")/*8.125*/ {_display_(Seq[Any](format.raw/*8.127*/("""
            """),format.raw/*9.13*/("""<div class="row-fluid">
                <div class="col-sm-12 col-md-12 col-xs-12">
                    """),format.raw/*11.50*/("""
                    """),format.raw/*12.43*/("""
                    """),format.raw/*13.67*/("""
                    """),format.raw/*14.31*/("""

                    """),format.raw/*16.21*/("""<img ng-show="!resultsSlideshow[0].length" class="img-responsive center-block" ng-src=""""),_display_(/*16.109*/routes/*16.115*/.Assets.versioned("images/loading.gif")),format.raw/*16.154*/("""" alt="Image Chargement"/>

                    <div class="carousel slide" ng-show="resultsSlideshow[0].length" id="myCarousel">
                        <div class="carousel-inner">
                            <!-- InfoQ -->
                            <div class="item active">
                                <div class="thumbnails">
                                    <div  ng-repeat="res in resultsSlideshow[0]">
                                        <div class="col-sm-3 col-md-3 col-xs-12">
                                            <div class="thumbnail thumbnailAccueil">
                                                <img ng-hide="res.urlImage == ''" class="img-responsive" ng-src=""""),format.raw/*26.114*/("""{"""),format.raw/*26.115*/("""{"""),format.raw/*26.116*/("""res.urlImage"""),format.raw/*26.128*/("""}"""),format.raw/*26.129*/("""}"""),format.raw/*26.130*/("""" alt="Image Resultat"/>
                                                <img ng-show="res.urlImage == ''" class="img-responsive" src=""""),_display_(/*27.112*/routes/*27.118*/.Assets.versioned("images/logos/infoq.jpeg")),format.raw/*27.162*/(""""   alt="Image Resultat"/>

                                                <div class="caption">
                                                    <h4>"""),format.raw/*30.57*/("""{"""),format.raw/*30.58*/("""{"""),format.raw/*30.59*/("""res.title"""),format.raw/*30.68*/("""}"""),format.raw/*30.69*/("""}"""),format.raw/*30.70*/("""</h4>
                                                    <p><a target="_blank" href=""""),format.raw/*31.81*/("""{"""),format.raw/*31.82*/("""{"""),format.raw/*31.83*/("""res.link"""),format.raw/*31.91*/("""}"""),format.raw/*31.92*/("""}"""),format.raw/*31.93*/("""" class="btn btn-primary" role="button">&raquo; En savoir plus</a>
                                                        """),_display_(/*32.58*/if(session.get("user")!=None)/*32.87*/{_display_(Seq[Any](format.raw/*32.88*/("""
                                                            """),format.raw/*33.61*/("""<button ng-if="isIn=(favorisArticlesLink.indexOf(res.link) > -1)" my-article="" title=""""),format.raw/*33.148*/("""{"""),format.raw/*33.149*/("""{"""),format.raw/*33.150*/("""res.title"""),format.raw/*33.159*/("""}"""),format.raw/*33.160*/("""}"""),format.raw/*33.161*/("""" description=""""),format.raw/*33.176*/("""{"""),format.raw/*33.177*/("""{"""),format.raw/*33.178*/("""res.description"""),format.raw/*33.193*/("""}"""),format.raw/*33.194*/("""}"""),format.raw/*33.195*/("""" link=""""),format.raw/*33.203*/("""{"""),format.raw/*33.204*/("""{"""),format.raw/*33.205*/("""res.link"""),format.raw/*33.213*/("""}"""),format.raw/*33.214*/("""}"""),format.raw/*33.215*/("""" date=""""),format.raw/*33.223*/("""{"""),format.raw/*33.224*/("""{"""),format.raw/*33.225*/("""res.date"""),format.raw/*33.233*/("""}"""),format.raw/*33.234*/("""}"""),format.raw/*33.235*/("""" urlImage=""""),format.raw/*33.247*/("""{"""),format.raw/*33.248*/("""{"""),format.raw/*33.249*/("""res.urlImage"""),format.raw/*33.261*/("""}"""),format.raw/*33.262*/("""}"""),format.raw/*33.263*/("""" categories=""""),format.raw/*33.277*/("""{"""),format.raw/*33.278*/("""{"""),format.raw/*33.279*/("""res.categories"""),format.raw/*33.293*/("""}"""),format.raw/*33.294*/("""}"""),format.raw/*33.295*/("""" class="btn btn-default" role="button">Supprimer favoris</button>
                                                            <button ng-if="!isIn" my-article="" title=""""),format.raw/*34.104*/("""{"""),format.raw/*34.105*/("""{"""),format.raw/*34.106*/("""res.title"""),format.raw/*34.115*/("""}"""),format.raw/*34.116*/("""}"""),format.raw/*34.117*/("""" description=""""),format.raw/*34.132*/("""{"""),format.raw/*34.133*/("""{"""),format.raw/*34.134*/("""res.description"""),format.raw/*34.149*/("""}"""),format.raw/*34.150*/("""}"""),format.raw/*34.151*/("""" link=""""),format.raw/*34.159*/("""{"""),format.raw/*34.160*/("""{"""),format.raw/*34.161*/("""res.link"""),format.raw/*34.169*/("""}"""),format.raw/*34.170*/("""}"""),format.raw/*34.171*/("""" date=""""),format.raw/*34.179*/("""{"""),format.raw/*34.180*/("""{"""),format.raw/*34.181*/("""res.date"""),format.raw/*34.189*/("""}"""),format.raw/*34.190*/("""}"""),format.raw/*34.191*/("""" urlImage=""""),format.raw/*34.203*/("""{"""),format.raw/*34.204*/("""{"""),format.raw/*34.205*/("""res.urlImage"""),format.raw/*34.217*/("""}"""),format.raw/*34.218*/("""}"""),format.raw/*34.219*/("""" categories=""""),format.raw/*34.233*/("""{"""),format.raw/*34.234*/("""{"""),format.raw/*34.235*/("""res.categories"""),format.raw/*34.249*/("""}"""),format.raw/*34.250*/("""}"""),format.raw/*34.251*/("""" class="btn btn-default" role="button">Ajouter favoris</button>
                                                        """)))}),format.raw/*35.58*/("""
                                                    """),format.raw/*36.53*/("""</p>
                                                    <p>"""),format.raw/*37.56*/("""{"""),format.raw/*37.57*/("""{"""),format.raw/*37.58*/("""res.description"""),format.raw/*37.73*/("""}"""),format.raw/*37.74*/("""}"""),format.raw/*37.75*/("""</p>
                                                    <p>Date : """),format.raw/*38.63*/("""{"""),format.raw/*38.64*/("""{"""),format.raw/*38.65*/("""res.date"""),format.raw/*38.73*/("""}"""),format.raw/*38.74*/("""}"""),format.raw/*38.75*/("""</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- DvptCom -->
                            <div class="item">
                                <div class="thumbnails">
                                    <div  ng-repeat="res in resultsSlideshow[1]">
                                        <div class="col-sm-3 col-md-3 col-xs-12">
                                            <div class="thumbnail thumbnailAccueil">
                                                <img ng-hide="res.urlImage == ''" class="img-responsive" ng-src=""""),format.raw/*52.114*/("""{"""),format.raw/*52.115*/("""{"""),format.raw/*52.116*/("""res.urlImage"""),format.raw/*52.128*/("""}"""),format.raw/*52.129*/("""}"""),format.raw/*52.130*/("""" alt="Image Resultat"/>
                                                <img ng-show="res.urlImage == ''" class="img-responsive" src=""""),_display_(/*53.112*/routes/*53.118*/.Assets.versioned("images/logos/developpezcom.jpeg")),format.raw/*53.170*/(""""   alt="Image Resultat"/>

                                                <div class="caption">
                                                    <h4>"""),format.raw/*56.57*/("""{"""),format.raw/*56.58*/("""{"""),format.raw/*56.59*/("""res.title"""),format.raw/*56.68*/("""}"""),format.raw/*56.69*/("""}"""),format.raw/*56.70*/("""</h4>
                                                    <p><a target="_blank" href=""""),format.raw/*57.81*/("""{"""),format.raw/*57.82*/("""{"""),format.raw/*57.83*/("""res.link"""),format.raw/*57.91*/("""}"""),format.raw/*57.92*/("""}"""),format.raw/*57.93*/("""" class="btn btn-primary" role="button">&raquo; En savoir plus</a>
                                                        """),_display_(/*58.58*/if(session.get("user")!=None)/*58.87*/{_display_(Seq[Any](format.raw/*58.88*/("""
                                                            """),format.raw/*59.61*/("""<button ng-if="isIn=(favorisArticlesLink.indexOf(res.link) > -1)" my-article="" title=""""),format.raw/*59.148*/("""{"""),format.raw/*59.149*/("""{"""),format.raw/*59.150*/("""res.title"""),format.raw/*59.159*/("""}"""),format.raw/*59.160*/("""}"""),format.raw/*59.161*/("""" description=""""),format.raw/*59.176*/("""{"""),format.raw/*59.177*/("""{"""),format.raw/*59.178*/("""res.description"""),format.raw/*59.193*/("""}"""),format.raw/*59.194*/("""}"""),format.raw/*59.195*/("""" link=""""),format.raw/*59.203*/("""{"""),format.raw/*59.204*/("""{"""),format.raw/*59.205*/("""res.link"""),format.raw/*59.213*/("""}"""),format.raw/*59.214*/("""}"""),format.raw/*59.215*/("""" date=""""),format.raw/*59.223*/("""{"""),format.raw/*59.224*/("""{"""),format.raw/*59.225*/("""res.date"""),format.raw/*59.233*/("""}"""),format.raw/*59.234*/("""}"""),format.raw/*59.235*/("""" urlImage=""""),format.raw/*59.247*/("""{"""),format.raw/*59.248*/("""{"""),format.raw/*59.249*/("""res.urlImage"""),format.raw/*59.261*/("""}"""),format.raw/*59.262*/("""}"""),format.raw/*59.263*/("""" categories=""""),format.raw/*59.277*/("""{"""),format.raw/*59.278*/("""{"""),format.raw/*59.279*/("""res.categories"""),format.raw/*59.293*/("""}"""),format.raw/*59.294*/("""}"""),format.raw/*59.295*/("""" class="btn btn-default" role="button">Supprimer favoris</button>
                                                            <button ng-if="!isIn" my-article="" title=""""),format.raw/*60.104*/("""{"""),format.raw/*60.105*/("""{"""),format.raw/*60.106*/("""res.title"""),format.raw/*60.115*/("""}"""),format.raw/*60.116*/("""}"""),format.raw/*60.117*/("""" description=""""),format.raw/*60.132*/("""{"""),format.raw/*60.133*/("""{"""),format.raw/*60.134*/("""res.description"""),format.raw/*60.149*/("""}"""),format.raw/*60.150*/("""}"""),format.raw/*60.151*/("""" link=""""),format.raw/*60.159*/("""{"""),format.raw/*60.160*/("""{"""),format.raw/*60.161*/("""res.link"""),format.raw/*60.169*/("""}"""),format.raw/*60.170*/("""}"""),format.raw/*60.171*/("""" date=""""),format.raw/*60.179*/("""{"""),format.raw/*60.180*/("""{"""),format.raw/*60.181*/("""res.date"""),format.raw/*60.189*/("""}"""),format.raw/*60.190*/("""}"""),format.raw/*60.191*/("""" urlImage=""""),format.raw/*60.203*/("""{"""),format.raw/*60.204*/("""{"""),format.raw/*60.205*/("""res.urlImage"""),format.raw/*60.217*/("""}"""),format.raw/*60.218*/("""}"""),format.raw/*60.219*/("""" categories=""""),format.raw/*60.233*/("""{"""),format.raw/*60.234*/("""{"""),format.raw/*60.235*/("""res.categories"""),format.raw/*60.249*/("""}"""),format.raw/*60.250*/("""}"""),format.raw/*60.251*/("""" class="btn btn-default" role="button">Ajouter favoris</button>
                                                        """)))}),format.raw/*61.58*/("""
                                                    """),format.raw/*62.53*/("""</p>
                                                    <p>"""),format.raw/*63.56*/("""{"""),format.raw/*63.57*/("""{"""),format.raw/*63.58*/("""res.description"""),format.raw/*63.73*/("""}"""),format.raw/*63.74*/("""}"""),format.raw/*63.75*/("""</p>
                                                    <p>Date : """),format.raw/*64.63*/("""{"""),format.raw/*64.64*/("""{"""),format.raw/*64.65*/("""res.date"""),format.raw/*64.73*/("""}"""),format.raw/*64.74*/("""}"""),format.raw/*64.75*/("""</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- WikiCFP -->
                            <div class="item">
                                <div class="thumbnails">
                                    <div  ng-repeat="res in resultsSlideshow[2]">
                                        <div class="col-sm-3 col-md-3 col-xs-12">
                                            <div class="thumbnail thumbnailAccueil">
                                                <img ng-hide="res.urlImage == ''" class="img-responsive" ng-src=""""),format.raw/*78.114*/("""{"""),format.raw/*78.115*/("""{"""),format.raw/*78.116*/("""res.urlImage"""),format.raw/*78.128*/("""}"""),format.raw/*78.129*/("""}"""),format.raw/*78.130*/("""" alt="Image Resultat"/>
                                                <img ng-show="res.urlImage == ''" class="img-responsive" src=""""),_display_(/*79.112*/routes/*79.118*/.Assets.versioned("images/logos/wikicfp.png")),format.raw/*79.163*/(""""   alt="Image Resultat"/>

                                                <div class="caption">
                                                    <h4>"""),format.raw/*82.57*/("""{"""),format.raw/*82.58*/("""{"""),format.raw/*82.59*/("""res.title"""),format.raw/*82.68*/("""}"""),format.raw/*82.69*/("""}"""),format.raw/*82.70*/("""</h4>
                                                    <p><a target="_blank" href=""""),format.raw/*83.81*/("""{"""),format.raw/*83.82*/("""{"""),format.raw/*83.83*/("""res.link"""),format.raw/*83.91*/("""}"""),format.raw/*83.92*/("""}"""),format.raw/*83.93*/("""" class="btn btn-primary" role="button">&raquo; En savoir plus</a>
                                                        """),_display_(/*84.58*/if(session.get("user")!=None)/*84.87*/{_display_(Seq[Any](format.raw/*84.88*/("""
                                                            """),format.raw/*85.61*/("""<button ng-if="isIn=(favorisArticlesLink.indexOf(res.link) > -1)" my-article="" title=""""),format.raw/*85.148*/("""{"""),format.raw/*85.149*/("""{"""),format.raw/*85.150*/("""res.title"""),format.raw/*85.159*/("""}"""),format.raw/*85.160*/("""}"""),format.raw/*85.161*/("""" description=""""),format.raw/*85.176*/("""{"""),format.raw/*85.177*/("""{"""),format.raw/*85.178*/("""res.description"""),format.raw/*85.193*/("""}"""),format.raw/*85.194*/("""}"""),format.raw/*85.195*/("""" link=""""),format.raw/*85.203*/("""{"""),format.raw/*85.204*/("""{"""),format.raw/*85.205*/("""res.link"""),format.raw/*85.213*/("""}"""),format.raw/*85.214*/("""}"""),format.raw/*85.215*/("""" date=""""),format.raw/*85.223*/("""{"""),format.raw/*85.224*/("""{"""),format.raw/*85.225*/("""res.date"""),format.raw/*85.233*/("""}"""),format.raw/*85.234*/("""}"""),format.raw/*85.235*/("""" urlImage=""""),format.raw/*85.247*/("""{"""),format.raw/*85.248*/("""{"""),format.raw/*85.249*/("""res.urlImage"""),format.raw/*85.261*/("""}"""),format.raw/*85.262*/("""}"""),format.raw/*85.263*/("""" categories=""""),format.raw/*85.277*/("""{"""),format.raw/*85.278*/("""{"""),format.raw/*85.279*/("""res.categories"""),format.raw/*85.293*/("""}"""),format.raw/*85.294*/("""}"""),format.raw/*85.295*/("""" class="btn btn-default" role="button">Supprimer favoris</button>
                                                            <button ng-if="!isIn" my-article="" title=""""),format.raw/*86.104*/("""{"""),format.raw/*86.105*/("""{"""),format.raw/*86.106*/("""res.title"""),format.raw/*86.115*/("""}"""),format.raw/*86.116*/("""}"""),format.raw/*86.117*/("""" description=""""),format.raw/*86.132*/("""{"""),format.raw/*86.133*/("""{"""),format.raw/*86.134*/("""res.description"""),format.raw/*86.149*/("""}"""),format.raw/*86.150*/("""}"""),format.raw/*86.151*/("""" link=""""),format.raw/*86.159*/("""{"""),format.raw/*86.160*/("""{"""),format.raw/*86.161*/("""res.link"""),format.raw/*86.169*/("""}"""),format.raw/*86.170*/("""}"""),format.raw/*86.171*/("""" date=""""),format.raw/*86.179*/("""{"""),format.raw/*86.180*/("""{"""),format.raw/*86.181*/("""res.date"""),format.raw/*86.189*/("""}"""),format.raw/*86.190*/("""}"""),format.raw/*86.191*/("""" urlImage=""""),format.raw/*86.203*/("""{"""),format.raw/*86.204*/("""{"""),format.raw/*86.205*/("""res.urlImage"""),format.raw/*86.217*/("""}"""),format.raw/*86.218*/("""}"""),format.raw/*86.219*/("""" categories=""""),format.raw/*86.233*/("""{"""),format.raw/*86.234*/("""{"""),format.raw/*86.235*/("""res.categories"""),format.raw/*86.249*/("""}"""),format.raw/*86.250*/("""}"""),format.raw/*86.251*/("""" class="btn btn-default" role="button">Ajouter favoris</button>
                                                        """)))}),format.raw/*87.58*/("""
                                                    """),format.raw/*88.53*/("""</p>
                                                    <p>"""),format.raw/*89.56*/("""{"""),format.raw/*89.57*/("""{"""),format.raw/*89.58*/("""res.description"""),format.raw/*89.73*/("""}"""),format.raw/*89.74*/("""}"""),format.raw/*89.75*/("""</p>
                                                    <p>Date : """),format.raw/*90.63*/("""{"""),format.raw/*90.64*/("""{"""),format.raw/*90.65*/("""res.date"""),format.raw/*90.73*/("""}"""),format.raw/*90.74*/("""}"""),format.raw/*90.75*/("""</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="control-box">
                            <a data-slide="prev" href="#myCarousel" class="slideshowA carousel-control left carousel-control-color">‹Précédent</a>
                            <a data-slide="next" href="#myCarousel" class="slideshowA carousel-control right carousel-control-color">Suivant›</a>
                        </div>
                            <!-- /.control-box -->
                    </div> <!-- /#myCarousel -->
                </div> <!-- /.span12 -->
            </div> <!-- /.row -->
        """)))}),format.raw/*107.10*/(""" """),format.raw/*107.35*/("""

        """),format.raw/*109.29*/("""
        """),format.raw/*110.137*/("""

            """),format.raw/*112.13*/("""<div class="row-fluid">
                <div class="col-sm-6 col-md-6 col-xs-6">
                    <div id="keywordsJqCloud"> <!-- Fetches keywords on page load -->
                        """),format.raw/*115.86*/("""
                    """),format.raw/*116.21*/("""</div>
                </div>
            </div>
        """),format.raw/*119.14*/("""

        """),_display_(/*121.10*/elements/*121.18*/.panels.panelAccueil(Messages("page.home.panelKeywords"),"primary","col-sm-6 col-md-6 col-xs-6","panelKeywords")/*121.130*/ {_display_(Seq[Any](format.raw/*121.132*/("""
            """),format.raw/*122.13*/("""<div id="notifKeywordSearched">

            </div>

            <div id="loadingKeywordsSearch" style="display:none">
                <img class="img-responsive center-block" ng-src=""""),_display_(/*127.67*/routes/*127.73*/.Assets.versioned("images/loading.gif")),format.raw/*127.112*/("""" alt="Image Chargement"/>
            </div>

            <p ng-show="!resultsArticlesKeyword.length">Aucun résultat trouvé !</p>
            <div class="row-fluid">
                <div  dir-paginate="res in resultsArticlesKeyword | itemsPerPage: 2" pagination-id="resultArticle">
                    <div class="col-sm-12 col-md-12 col-xs-12">
                        <div class="thumbnail thumbnailHauteurArticleKeyword" id=""""),format.raw/*134.83*/("""{"""),format.raw/*134.84*/("""{"""),format.raw/*134.85*/("""res.link"""),format.raw/*134.93*/("""}"""),format.raw/*134.94*/("""}"""),format.raw/*134.95*/("""">
                            <img ng-hide="res.urlImage == ''" class="img-responsive" ng-src=""""),format.raw/*135.94*/("""{"""),format.raw/*135.95*/("""{"""),format.raw/*135.96*/("""res.urlImage"""),format.raw/*135.108*/("""}"""),format.raw/*135.109*/("""}"""),format.raw/*135.110*/("""" alt="Image Resultat"/>

                            <img ng-show="res.urlImage == ''" height="150" width="200" src=""""),_display_(/*137.94*/routes/*137.100*/.Assets.versioned("images/logos/aperture.png")),format.raw/*137.146*/(""""   alt="Image Resultat"/>
                            <div class="caption">
                                <h3>"""),format.raw/*139.37*/("""{"""),format.raw/*139.38*/("""{"""),format.raw/*139.39*/("""res.title"""),format.raw/*139.48*/("""}"""),format.raw/*139.49*/("""}"""),format.raw/*139.50*/("""</h3>
                                <p><a target="_blank" href=""""),format.raw/*140.61*/("""{"""),format.raw/*140.62*/("""{"""),format.raw/*140.63*/("""res.link"""),format.raw/*140.71*/("""}"""),format.raw/*140.72*/("""}"""),format.raw/*140.73*/("""" class="btn btn-primary" role="button">Lien</a>
                                    """),_display_(/*141.38*/if(session.get("user")!=None)/*141.67*/{_display_(Seq[Any](format.raw/*141.68*/("""
                                        """),format.raw/*142.41*/("""<button ng-if="isIn=(favorisArticlesLink.indexOf(res.link) > -1)" my-article="" title=""""),format.raw/*142.128*/("""{"""),format.raw/*142.129*/("""{"""),format.raw/*142.130*/("""res.title"""),format.raw/*142.139*/("""}"""),format.raw/*142.140*/("""}"""),format.raw/*142.141*/("""" description=""""),format.raw/*142.156*/("""{"""),format.raw/*142.157*/("""{"""),format.raw/*142.158*/("""res.description"""),format.raw/*142.173*/("""}"""),format.raw/*142.174*/("""}"""),format.raw/*142.175*/("""" link=""""),format.raw/*142.183*/("""{"""),format.raw/*142.184*/("""{"""),format.raw/*142.185*/("""res.link"""),format.raw/*142.193*/("""}"""),format.raw/*142.194*/("""}"""),format.raw/*142.195*/("""" date=""""),format.raw/*142.203*/("""{"""),format.raw/*142.204*/("""{"""),format.raw/*142.205*/("""res.date"""),format.raw/*142.213*/("""}"""),format.raw/*142.214*/("""}"""),format.raw/*142.215*/("""" urlImage=""""),format.raw/*142.227*/("""{"""),format.raw/*142.228*/("""{"""),format.raw/*142.229*/("""res.urlImage"""),format.raw/*142.241*/("""}"""),format.raw/*142.242*/("""}"""),format.raw/*142.243*/("""" categories=""""),format.raw/*142.257*/("""{"""),format.raw/*142.258*/("""{"""),format.raw/*142.259*/("""res.categories"""),format.raw/*142.273*/("""}"""),format.raw/*142.274*/("""}"""),format.raw/*142.275*/("""" class="btn btn-default" role="button">Supprimer favoris</button>
                                        <button ng-if="!isIn" my-article="" title=""""),format.raw/*143.84*/("""{"""),format.raw/*143.85*/("""{"""),format.raw/*143.86*/("""res.title"""),format.raw/*143.95*/("""}"""),format.raw/*143.96*/("""}"""),format.raw/*143.97*/("""" description=""""),format.raw/*143.112*/("""{"""),format.raw/*143.113*/("""{"""),format.raw/*143.114*/("""res.description"""),format.raw/*143.129*/("""}"""),format.raw/*143.130*/("""}"""),format.raw/*143.131*/("""" link=""""),format.raw/*143.139*/("""{"""),format.raw/*143.140*/("""{"""),format.raw/*143.141*/("""res.link"""),format.raw/*143.149*/("""}"""),format.raw/*143.150*/("""}"""),format.raw/*143.151*/("""" date=""""),format.raw/*143.159*/("""{"""),format.raw/*143.160*/("""{"""),format.raw/*143.161*/("""res.date"""),format.raw/*143.169*/("""}"""),format.raw/*143.170*/("""}"""),format.raw/*143.171*/("""" urlImage=""""),format.raw/*143.183*/("""{"""),format.raw/*143.184*/("""{"""),format.raw/*143.185*/("""res.urlImage"""),format.raw/*143.197*/("""}"""),format.raw/*143.198*/("""}"""),format.raw/*143.199*/("""" categories=""""),format.raw/*143.213*/("""{"""),format.raw/*143.214*/("""{"""),format.raw/*143.215*/("""res.categories"""),format.raw/*143.229*/("""}"""),format.raw/*143.230*/("""}"""),format.raw/*143.231*/("""" class="btn btn-default" role="button">Ajouter favoris</button>
                                    """)))}),format.raw/*144.38*/("""
                                """),format.raw/*145.33*/("""</p>
                                <p>"""),format.raw/*146.36*/("""{"""),format.raw/*146.37*/("""{"""),format.raw/*146.38*/("""res.description"""),format.raw/*146.53*/("""}"""),format.raw/*146.54*/("""}"""),format.raw/*146.55*/("""</p>
                                <p>Date : """),format.raw/*147.43*/("""{"""),format.raw/*147.44*/("""{"""),format.raw/*147.45*/("""res.date"""),format.raw/*147.53*/("""}"""),format.raw/*147.54*/("""}"""),format.raw/*147.55*/("""</p>
                            </div>
                        </div>
                    </div>
                </div>
                <dir-pagination-controls template-url=""""),_display_(/*152.57*/routes/*152.63*/.Assets.versioned("javascripts/dirPagination.tpl.html")),format.raw/*152.118*/("""" pagination-id="resultArticle"></dir-pagination-controls>
            </div>
        """)))}),format.raw/*154.10*/("""
    """),format.raw/*155.5*/("""</div>

    """),_display_(/*157.6*/elements/*157.14*/.panels.panelAccueil(Messages("source.panel.title"),"success","col-sm-12 col-md-12 col-xs-12","panelSources")/*157.123*/ {_display_(Seq[Any](format.raw/*157.125*/("""

        """),_display_(/*159.10*/elements/*159.18*/.thumbnails.thumbnailAccueil("Logo infoQ", Messages("source.infoq.label"),Messages("source.infoq.description"),"http://www.infoq.com/",Messages("thumbnail.link.accessSite"))/*159.191*/{_display_(_display_(/*159.193*/routes/*159.199*/.Assets.versioned("images/logos/infoq.jpeg")))}),format.raw/*159.244*/("""

        """),_display_(/*161.10*/elements/*161.18*/.thumbnails.thumbnailAccueil("Logo Youtube", Messages("source.youtube.label"),Messages("source.youtube.description"),"https://www.youtube.com",Messages("thumbnail.link.accessSite"))/*161.199*/{_display_(_display_(/*161.201*/routes/*161.207*/.Assets.versioned("images/logos/youtube.png")))}),format.raw/*161.253*/("""

        """),_display_(/*163.10*/elements/*163.18*/.thumbnails.thumbnailAccueil("Logo IEEE", Messages("source.ieee.label"),Messages("source.ieee.description"),"https://www.ieee.org/index.html",Messages("thumbnail.link.accessSite"))/*163.198*/{_display_(_display_(/*163.200*/routes/*163.206*/.Assets.versioned("images/logos/iee.png")))}),format.raw/*163.248*/("""

        """),_display_(/*165.10*/elements/*165.18*/.thumbnails.thumbnailAccueil("Logo Developpez.com", Messages("source.dvptcom.label"),Messages("source.dvptcom.description"),"http://www.developpez.com/",Messages("thumbnail.link.accessSite"))/*165.209*/{_display_(_display_(/*165.211*/routes/*165.217*/.Assets.versioned("images/logos/developpezcom.jpeg")))}),format.raw/*165.270*/("""

        """),_display_(/*167.10*/elements/*167.18*/.thumbnails.thumbnailAccueil("Logo WikiCfp", Messages("source.wikicfp.label"),Messages("source.wikicfp.description"),"http://www.wikicfp.com/cfp/",Messages("thumbnail.link.accessSite"))/*167.203*/{_display_(_display_(/*167.205*/routes/*167.211*/.Assets.versioned("images/logos/wikicfp.png")))}),format.raw/*167.257*/("""
    """)))}),format.raw/*168.6*/(""" """),format.raw/*168.35*/("""
""")))}),format.raw/*169.2*/("""
"""),format.raw/*170.20*/("""
"""))
      }
    }
  }

  def render(title:String,m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(title)(m,session)

  def f:((String) => (Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (title) => (m,session) => apply(title)(m,session)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:29 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/index.scala.html
                  HASH: 79d535e2a8eee6637fa613893dc59ba34c3d9a61
                  MATRIX: 544->1|694->56|722->59|741->70|780->72|811->77|888->128|902->134|963->174|1046->251|1082->261|1098->269|1214->376|1254->378|1294->391|1426->524|1475->567|1524->634|1573->665|1623->687|1739->775|1755->781|1816->820|2544->1519|2574->1520|2604->1521|2645->1533|2675->1534|2705->1535|2869->1671|2885->1677|2951->1721|3133->1875|3162->1876|3191->1877|3228->1886|3257->1887|3286->1888|3400->1974|3429->1975|3458->1976|3494->1984|3523->1985|3552->1986|3703->2110|3741->2139|3780->2140|3869->2201|3985->2288|4015->2289|4045->2290|4083->2299|4113->2300|4143->2301|4187->2316|4217->2317|4247->2318|4291->2333|4321->2334|4351->2335|4388->2343|4418->2344|4448->2345|4485->2353|4515->2354|4545->2355|4582->2363|4612->2364|4642->2365|4679->2373|4709->2374|4739->2375|4780->2387|4810->2388|4840->2389|4881->2401|4911->2402|4941->2403|4984->2417|5014->2418|5044->2419|5087->2433|5117->2434|5147->2435|5346->2605|5376->2606|5406->2607|5444->2616|5474->2617|5504->2618|5548->2633|5578->2634|5608->2635|5652->2650|5682->2651|5712->2652|5749->2660|5779->2661|5809->2662|5846->2670|5876->2671|5906->2672|5943->2680|5973->2681|6003->2682|6040->2690|6070->2691|6100->2692|6141->2704|6171->2705|6201->2706|6242->2718|6272->2719|6302->2720|6345->2734|6375->2735|6405->2736|6448->2750|6478->2751|6508->2752|6661->2874|6742->2927|6830->2987|6859->2988|6888->2989|6931->3004|6960->3005|6989->3006|7084->3073|7113->3074|7142->3075|7178->3083|7207->3084|7236->3085|8052->3872|8082->3873|8112->3874|8153->3886|8183->3887|8213->3888|8377->4024|8393->4030|8467->4082|8649->4236|8678->4237|8707->4238|8744->4247|8773->4248|8802->4249|8916->4335|8945->4336|8974->4337|9010->4345|9039->4346|9068->4347|9219->4471|9257->4500|9296->4501|9385->4562|9501->4649|9531->4650|9561->4651|9599->4660|9629->4661|9659->4662|9703->4677|9733->4678|9763->4679|9807->4694|9837->4695|9867->4696|9904->4704|9934->4705|9964->4706|10001->4714|10031->4715|10061->4716|10098->4724|10128->4725|10158->4726|10195->4734|10225->4735|10255->4736|10296->4748|10326->4749|10356->4750|10397->4762|10427->4763|10457->4764|10500->4778|10530->4779|10560->4780|10603->4794|10633->4795|10663->4796|10862->4966|10892->4967|10922->4968|10960->4977|10990->4978|11020->4979|11064->4994|11094->4995|11124->4996|11168->5011|11198->5012|11228->5013|11265->5021|11295->5022|11325->5023|11362->5031|11392->5032|11422->5033|11459->5041|11489->5042|11519->5043|11556->5051|11586->5052|11616->5053|11657->5065|11687->5066|11717->5067|11758->5079|11788->5080|11818->5081|11861->5095|11891->5096|11921->5097|11964->5111|11994->5112|12024->5113|12177->5235|12258->5288|12346->5348|12375->5349|12404->5350|12447->5365|12476->5366|12505->5367|12600->5434|12629->5435|12658->5436|12694->5444|12723->5445|12752->5446|13568->6233|13598->6234|13628->6235|13669->6247|13699->6248|13729->6249|13893->6385|13909->6391|13976->6436|14158->6590|14187->6591|14216->6592|14253->6601|14282->6602|14311->6603|14425->6689|14454->6690|14483->6691|14519->6699|14548->6700|14577->6701|14728->6825|14766->6854|14805->6855|14894->6916|15010->7003|15040->7004|15070->7005|15108->7014|15138->7015|15168->7016|15212->7031|15242->7032|15272->7033|15316->7048|15346->7049|15376->7050|15413->7058|15443->7059|15473->7060|15510->7068|15540->7069|15570->7070|15607->7078|15637->7079|15667->7080|15704->7088|15734->7089|15764->7090|15805->7102|15835->7103|15865->7104|15906->7116|15936->7117|15966->7118|16009->7132|16039->7133|16069->7134|16112->7148|16142->7149|16172->7150|16371->7320|16401->7321|16431->7322|16469->7331|16499->7332|16529->7333|16573->7348|16603->7349|16633->7350|16677->7365|16707->7366|16737->7367|16774->7375|16804->7376|16834->7377|16871->7385|16901->7386|16931->7387|16968->7395|16998->7396|17028->7397|17065->7405|17095->7406|17125->7407|17166->7419|17196->7420|17226->7421|17267->7433|17297->7434|17327->7435|17370->7449|17400->7450|17430->7451|17473->7465|17503->7466|17533->7467|17686->7589|17767->7642|17855->7702|17884->7703|17913->7704|17956->7719|17985->7720|18014->7721|18109->7788|18138->7789|18167->7790|18203->7798|18232->7799|18261->7800|19158->8665|19188->8690|19227->8720|19266->8857|19309->8871|19529->9123|19579->9144|19665->9206|19704->9217|19722->9225|19845->9337|19887->9339|19929->9352|20142->9537|20158->9543|20220->9582|20678->10011|20708->10012|20738->10013|20775->10021|20805->10022|20835->10023|20960->10119|20990->10120|21020->10121|21062->10133|21093->10134|21124->10135|21271->10254|21288->10260|21357->10306|21499->10419|21529->10420|21559->10421|21597->10430|21627->10431|21657->10432|21752->10498|21782->10499|21812->10500|21849->10508|21879->10509|21909->10510|22023->10596|22062->10625|22102->10626|22172->10667|22289->10754|22320->10755|22351->10756|22390->10765|22421->10766|22452->10767|22497->10782|22528->10783|22559->10784|22604->10799|22635->10800|22666->10801|22704->10809|22735->10810|22766->10811|22804->10819|22835->10820|22866->10821|22904->10829|22935->10830|22966->10831|23004->10839|23035->10840|23066->10841|23108->10853|23139->10854|23170->10855|23212->10867|23243->10868|23274->10869|23318->10883|23349->10884|23380->10885|23424->10899|23455->10900|23486->10901|23665->11051|23695->11052|23725->11053|23763->11062|23793->11063|23823->11064|23868->11079|23899->11080|23930->11081|23975->11096|24006->11097|24037->11098|24075->11106|24106->11107|24137->11108|24175->11116|24206->11117|24237->11118|24275->11126|24306->11127|24337->11128|24375->11136|24406->11137|24437->11138|24479->11150|24510->11151|24541->11152|24583->11164|24614->11165|24645->11166|24689->11180|24720->11181|24751->11182|24795->11196|24826->11197|24857->11198|24991->11300|25053->11333|25122->11373|25152->11374|25182->11375|25226->11390|25256->11391|25286->11392|25362->11439|25392->11440|25422->11441|25459->11449|25489->11450|25519->11451|25724->11628|25740->11634|25818->11689|25937->11776|25970->11781|26010->11794|26028->11802|26148->11911|26190->11913|26229->11924|26247->11932|26431->12105|26463->12107|26480->12113|26550->12158|26589->12169|26607->12177|26799->12358|26831->12360|26848->12366|26919->12412|26958->12423|26976->12431|27167->12611|27199->12613|27216->12619|27283->12661|27322->12672|27340->12680|27542->12871|27574->12873|27591->12879|27669->12932|27708->12943|27726->12951|27922->13136|27954->13138|27971->13144|28042->13190|28079->13196|28109->13225|28142->13227|28172->13247
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|28->4|28->4|28->4|31->7|32->8|32->8|32->8|32->8|33->9|35->11|36->12|37->13|38->14|40->16|40->16|40->16|40->16|50->26|50->26|50->26|50->26|50->26|50->26|51->27|51->27|51->27|54->30|54->30|54->30|54->30|54->30|54->30|55->31|55->31|55->31|55->31|55->31|55->31|56->32|56->32|56->32|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|57->33|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|58->34|59->35|60->36|61->37|61->37|61->37|61->37|61->37|61->37|62->38|62->38|62->38|62->38|62->38|62->38|76->52|76->52|76->52|76->52|76->52|76->52|77->53|77->53|77->53|80->56|80->56|80->56|80->56|80->56|80->56|81->57|81->57|81->57|81->57|81->57|81->57|82->58|82->58|82->58|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|83->59|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|84->60|85->61|86->62|87->63|87->63|87->63|87->63|87->63|87->63|88->64|88->64|88->64|88->64|88->64|88->64|102->78|102->78|102->78|102->78|102->78|102->78|103->79|103->79|103->79|106->82|106->82|106->82|106->82|106->82|106->82|107->83|107->83|107->83|107->83|107->83|107->83|108->84|108->84|108->84|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|109->85|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|110->86|111->87|112->88|113->89|113->89|113->89|113->89|113->89|113->89|114->90|114->90|114->90|114->90|114->90|114->90|131->107|131->107|133->109|134->110|136->112|139->115|140->116|143->119|145->121|145->121|145->121|145->121|146->122|151->127|151->127|151->127|158->134|158->134|158->134|158->134|158->134|158->134|159->135|159->135|159->135|159->135|159->135|159->135|161->137|161->137|161->137|163->139|163->139|163->139|163->139|163->139|163->139|164->140|164->140|164->140|164->140|164->140|164->140|165->141|165->141|165->141|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|166->142|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|167->143|168->144|169->145|170->146|170->146|170->146|170->146|170->146|170->146|171->147|171->147|171->147|171->147|171->147|171->147|176->152|176->152|176->152|178->154|179->155|181->157|181->157|181->157|181->157|183->159|183->159|183->159|183->159|183->159|183->159|185->161|185->161|185->161|185->161|185->161|185->161|187->163|187->163|187->163|187->163|187->163|187->163|189->165|189->165|189->165|189->165|189->165|189->165|191->167|191->167|191->167|191->167|191->167|191->167|192->168|192->168|193->169|194->170
                  -- GENERATED --
              */
          