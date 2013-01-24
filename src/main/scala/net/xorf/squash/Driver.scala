package net.xorf.squash

import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import info.gamlor.db.Database

object Driver extends App {
  println("running...")
  val config = ConfigFactory.load()
  val app1 = ActorSystem("myapp", config.getConfig("myapp").withFallback(config))

  val db = Database(app1)

  val qres = for {
    conn <- db.connect()
    people = conn.executeQuery("select id, name, age from people")
    _ <- conn.close()
  } yield people

  qres.onSuccess {
    case rs => rs.foreach(row => row.foreach(x => println(x.toString())))
    app1.shutdown()
  }.onFailure {
    case e => e.printStackTrace()
    app1.shutdown()
  }
}

