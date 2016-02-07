
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object nav_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class nav extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Messages,Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(implicit m : Messages, session: Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.58*/("""

"""),format.raw/*3.1*/("""<nav class="navbar navbar-default navbar-inverse navbar-static-top"  role="navigation">
    <div class="container-fluid">
        """),format.raw/*5.56*/("""
        """),format.raw/*6.9*/("""<div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=""""),_display_(/*13.44*/routes/*13.50*/.Application.index()),format.raw/*13.70*/("""">CJ Project</a><img class="navbar-brand" height="50px" src=""""),_display_(/*13.132*/routes/*13.138*/.Assets.versioned("images/logos/aperture.png")),format.raw/*13.184*/("""" onerror=" this.src='"""),_display_(/*13.207*/routes/*13.213*/.Assets.versioned("images/imageNotFound.jpg")),format.raw/*13.258*/("""';" alt="Logo aperture"/>
        </div>

        """),format.raw/*16.41*/("""
        """),format.raw/*17.9*/("""<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            """),format.raw/*18.45*/("""
            """),format.raw/*19.13*/("""<ul class="nav navbar-nav">
                <li><a href=""""),_display_(/*20.31*/routes/*20.37*/.Application.index()),format.raw/*20.57*/("""">"""),_display_(/*20.60*/Messages("tpl.nav.home")),format.raw/*20.84*/("""</a></li> <!--<li class="active">-->
                <li><a href=""""),_display_(/*21.31*/routes/*21.37*/.Application.sources()),format.raw/*21.59*/("""">"""),_display_(/*21.62*/Messages("tpl.nav.sources")),format.raw/*21.89*/("""</a></li>
                <li><a href=""""),_display_(/*22.31*/routes/*22.37*/.Application.timeline()),format.raw/*22.60*/("""">"""),_display_(/*22.63*/Messages("tpl.nav.conf")),format.raw/*22.87*/("""</a></li>
                """),_display_(/*23.18*/if(session.get("user")!=None)/*23.47*/ {_display_(Seq[Any](format.raw/*23.49*/("""
                    """),format.raw/*24.21*/("""<li><a href="/favoris">Favoris</a></li>
                """)))}),format.raw/*25.18*/("""
                """),format.raw/*26.42*/("""
                    """),format.raw/*27.125*/("""
                    """),format.raw/*28.63*/("""
                        """),format.raw/*29.60*/("""
                        """),format.raw/*30.68*/("""
                        """),format.raw/*31.73*/("""
                        """),format.raw/*32.54*/("""
                        """),format.raw/*33.68*/("""
                        """),format.raw/*34.54*/("""
                        """),format.raw/*35.77*/("""
                    """),format.raw/*36.30*/("""
                """),format.raw/*37.26*/("""
            """),format.raw/*38.13*/("""</ul>

            """),format.raw/*40.37*/("""
            """),format.raw/*41.69*/("""
                """),format.raw/*42.45*/("""

                    """),format.raw/*44.129*/("""
                """),format.raw/*45.27*/("""
                    """),format.raw/*46.91*/("""
                """),format.raw/*47.64*/("""
            """),format.raw/*48.24*/("""

            """),format.raw/*50.52*/("""
            """),format.raw/*51.13*/("""<ul class="nav navbar-nav navbar-right">
                """),_display_(/*52.18*/if(session.get("user")==None)/*52.47*/{_display_(Seq[Any](format.raw/*52.48*/("""
                """),format.raw/*53.17*/("""<li><p class="navbar-text">"""),_display_(/*53.45*/Messages("tpl.nav.alreadyRegistered")),format.raw/*53.82*/("""</p></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>"""),_display_(/*55.88*/Messages("tpl.nav.login")),format.raw/*55.113*/("""</b> <span class="caret"></span></a>
                        <ul id="login-dp" class="dropdown-menu">
                            <li>
                                <div class="row">
                                    <div class="col-md-12">
                                        Saisir vos identifiants
                                        <form class="form" role="form" accept-charset="UTF-8" id="login-nav">
                                            <div class="form-group">
                                                <label class="sr-only" for="exampleInputEmail2">"""),_display_(/*63.98*/Messages("tpl.nav.mail")),format.raw/*63.122*/("""</label>
                                                <input type="email" class="form-control" name="login" id="exampleInputEmail2" placeholder=""""),_display_(/*64.141*/Messages("tpl.nav.mail")),format.raw/*64.165*/("""" required>
                                            </div>
                                            <div class="form-group">
                                                <label class="sr-only" for="exampleInputPassword2">"""),_display_(/*67.101*/Messages("tpl.nav.password")),format.raw/*67.129*/("""</label>
                                                <input type="password" class="form-control" name="password" id="exampleInputPassword2" placeholder=""""),_display_(/*68.150*/Messages("tpl.nav.password")),format.raw/*68.178*/("""" required>
                                                <div id="error-login" style="display:none;color:red"></div>
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-primary btn-block">"""),_display_(/*72.106*/Messages("tpl.nav.signIn")),format.raw/*72.132*/("""</button>
                                            </div>

                                        </form>
                                    </div>
                                    <div class="bottom text-center">
                                        """),_display_(/*78.42*/Messages("tpl.nav.newUser")),format.raw/*78.69*/(""" """),format.raw/*78.70*/("""<a href=""""),_display_(/*78.80*/routes/*78.86*/.Application.inscription),format.raw/*78.110*/(""""><b>"""),_display_(/*78.116*/Messages("tpl.nav.joinUs")),format.raw/*78.142*/("""</b></a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                """)))}),format.raw/*84.18*/("""
                """),_display_(/*85.18*/if(session.get("user")!=None)/*85.47*/{_display_(Seq[Any](format.raw/*85.48*/("""
                    """),format.raw/*86.21*/("""<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>"""),_display_(/*87.88*/session/*87.95*/.get("user")),format.raw/*87.107*/("""</b> <span class="caret"></span></a>
                        <ul id="login-dp" class="dropdown-menu">
                            <li>
                                <div class="row">
                                    <div class="col-md-12">

                                        <form class="form" role="form" method="post" action="/deconnexion" accept-charset="UTF-8" id="login-nav">
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-primary btn-block">Se déconnecter</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                """)))}),format.raw/*103.18*/("""
            """),format.raw/*104.13*/("""</ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav><!-- /.navbar -->"""))
      }
    }
  }

  def render(title:String,m:Messages,session:Session): play.twirl.api.HtmlFormat.Appendable = apply(title)(m,session)

  def f:((String) => (Messages,Session) => play.twirl.api.HtmlFormat.Appendable) = (title) => (m,session) => apply(title)(m,session)

  def ref: this.type = this

}


}

/**/
object nav extends nav_Scope0.nav
              /*
                  -- GENERATED --
                  DATE: Sun Feb 07 20:32:27 CET 2016
                  SOURCE: /home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/app/views/nav.scala.html
                  HASH: 64d78a08a56a1aa07c2b9e6568b67208daebfb1f
                  MATRIX: 540->1|691->57|719->59|876->236|911->245|1369->676|1384->682|1425->702|1515->764|1531->770|1599->816|1650->839|1666->845|1733->890|1811->972|1847->981|1960->1098|2001->1111|2086->1169|2101->1175|2142->1195|2172->1198|2217->1222|2311->1289|2326->1295|2369->1317|2399->1320|2447->1347|2514->1387|2529->1393|2573->1416|2603->1419|2648->1443|2702->1470|2740->1499|2780->1501|2829->1522|2917->1579|2962->1621|3012->1746|3061->1809|3114->1869|3167->1937|3220->2010|3273->2064|3326->2132|3379->2186|3432->2263|3481->2293|3526->2319|3567->2332|3614->2375|3655->2444|3700->2489|3751->2619|3796->2646|3845->2737|3890->2801|3931->2825|3973->2878|4014->2891|4099->2949|4137->2978|4176->2979|4221->2996|4276->3024|4334->3061|4500->3200|4547->3225|5159->3810|5205->3834|5382->3983|5428->4007|5688->4239|5738->4267|5924->4425|5974->4453|6347->4798|6395->4824|6685->5087|6733->5114|6762->5115|6799->5125|6814->5131|6860->5155|6894->5161|6942->5187|7171->5385|7216->5403|7254->5432|7293->5433|7342->5454|7478->5563|7494->5570|7528->5582|8437->6459|8479->6472
                  LINES: 20->1|25->1|27->3|29->5|30->6|37->13|37->13|37->13|37->13|37->13|37->13|37->13|37->13|37->13|40->16|41->17|42->18|43->19|44->20|44->20|44->20|44->20|44->20|45->21|45->21|45->21|45->21|45->21|46->22|46->22|46->22|46->22|46->22|47->23|47->23|47->23|48->24|49->25|50->26|51->27|52->28|53->29|54->30|55->31|56->32|57->33|58->34|59->35|60->36|61->37|62->38|64->40|65->41|66->42|68->44|69->45|70->46|71->47|72->48|74->50|75->51|76->52|76->52|76->52|77->53|77->53|77->53|79->55|79->55|87->63|87->63|88->64|88->64|91->67|91->67|92->68|92->68|96->72|96->72|102->78|102->78|102->78|102->78|102->78|102->78|102->78|102->78|108->84|109->85|109->85|109->85|110->86|111->87|111->87|111->87|127->103|128->104
                  -- GENERATED --
              */
          