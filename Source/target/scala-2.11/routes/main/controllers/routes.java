
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/msb/Documents/Linux/ING3/Informatique/ProjetReactProgOpenData/git/ProjetReactProgOpenData/Source/conf/routes
// @DATE:Sun Feb 07 20:32:26 CET 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseWebJarAssets WebJarAssets = new controllers.ReverseWebJarAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFormulaires Formulaires = new controllers.ReverseFormulaires(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseActorsController ActorsController = new controllers.ReverseActorsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseWebJarAssets WebJarAssets = new controllers.javascript.ReverseWebJarAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFormulaires Formulaires = new controllers.javascript.ReverseFormulaires(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseActorsController ActorsController = new controllers.javascript.ReverseActorsController(RoutesPrefix.byNamePrefix());
  }

}
