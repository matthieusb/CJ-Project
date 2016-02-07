import play.api.{Play, Application, GlobalSettings}
import  play.api.Play.current
import play.api.mvc.{Result, RequestHeader, Controller}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object Global extends GlobalSettings with Controller {
  override def onStart(app : Application): Unit = {
    println("########### Lancement serveur Play ! ###########")
  }

  override def onStop(app : Application): Unit = {
    println("########### Extinction serveur Play ! ###########")
  }

  // --------------------------------
  // ------- ERREURS ----------
  // --------------------------------

  // Route found but not possible to bind the request parameters
  override def onBadRequest(requestHeader : RequestHeader, error : String) : Future[Result] =  {
    if (Play.isProd) {
      Future(BadRequest(views.html.errors.onBadRequest(requestHeader)))
    } else {
      super.onBadRequest(requestHeader,error)
    }
  }

  // 500 - internal server error
  override def onError(request: RequestHeader, throwable: Throwable) : Future[Result] = {
    if (Play.isProd) {
      Future(InternalServerError(views.html.errors.onError(throwable)))
    } else {
      super.onError(request,throwable)
    }
  }

  // 404 error
  override def onHandlerNotFound(requestHeader : RequestHeader) : Future[Result] =  {
    if (Play.isProd) {
      Future(NotFound(views.html.errors.onHandlerNotFound(requestHeader)))
    } else {
      super.onHandlerNotFound(requestHeader)
    }
  }
}
