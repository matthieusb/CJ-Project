package model

import com.mongodb.casbah.MongoClient
import org.bson
import play.api.Play.current
//import com.mongodb.casbah.Imports._

object Mongodb {
  //Change IP according to your mongoDB configuration in conf/application.cong
  val mongoClient = MongoClient(current.configuration.getString("mongo.simple.url").getOrElse(""), current.configuration.getInt("db.mongo.simple.port").getOrElse(27017))
  val db = mongoClient(current.configuration.getString("mongo.simple.name").getOrElse("vtBDD"))
}

