package net.xorf.squash.model

trait Relation {
  type RelationType = Map[String, Attribute]

  val name: String
  val header: Map[String, Attribute]
}