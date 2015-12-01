package com.madsen.chess.name

object Name {

  def apply(name: String): Name = (name: Seq[Char]) match {
    case Seq(file, rank) ⇒ apply(file, rank)
  }


  def apply(file: Char, rank: Char): Name = NameImpl(File(file), Rank(rank))


  val map: Map[(File, Rank), Name] = {

    ???
  }

  private[Name] case class NameImpl(file: File, rank: Rank) extends Name {

    def neighbour(direction: Direction): Option[Name] = {

      val nFile = file neighbour direction
      val nRank = rank neighbour direction

      ???
    }
  }


}


trait Neighbour {
  type T >: this.type <: Neighbour // this.type < T < Neighbour

  def neighbour(direction: Direction): Option[T]
}

sealed trait Name extends Neighbour {
  type T = Name
}
