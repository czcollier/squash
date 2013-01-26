package net.xorf.squash.model

import java.util.UUID

trait Attribute {
  type T
}

object Attribute {
  def getType[T](v: T)(implicit manifest: Manifest[T]) = manifest.erasure
}

object TextAttribute extends Attribute {
  type T = String
}

object NumericAttribute extends Attribute {
  type T = Number
}

object UUIDAttribute extends Attribute {
  type T = UUID
}

class RelationAttribute(r: Relation) extends Attribute {
  type T = Relation
}

