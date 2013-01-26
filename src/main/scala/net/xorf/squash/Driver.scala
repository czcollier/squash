package net.xorf.squash

import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import info.gamlor.db.Database
import model._

object Driver extends App {
  println("running...")

  val people = new Relation {
    val name = "people"
    val header = Map("id" -> UUIDAttribute, "name" -> TextAttribute, "age" -> NumericAttribute)
  }

  val tasks = new Relation {
    val name = "people"
    val header = Map("id" -> UUIDAttribute, "title" -> TextAttribute, "owner" -> new RelationAttribute(people))
  }

  val myRel = new Model {
    val relations = Set(people, tasks)
  }

  def testAkka() {
    val config = ConfigFactory.load()
    val app1 = ActorSystem("myapp", config.getConfig("myapp").withFallback(config))

    val db = Database(app1)

    val qres = {
      for {
        conn <- db.connect()
        people = conn.executeQuery("select id, name, age from people")
        _ <- conn.close()
      } yield people
    }.onSuccess {
      case rs => rs.foreach {
        result => {
          println("result: " + result.getClass.toString)
          result.foreach(row => println(row.get("id").getValue.asInstanceOf[String].length))
        }
      }
      app1.shutdown()
    }.onFailure {
      case e => e.printStackTrace()
      app1.shutdown()
    }
  }

  val types = myRel.relations.map(r => r.header.toList.map(x => Attribute.getType(x._2)))
  println(types.mkString(", "))

}

