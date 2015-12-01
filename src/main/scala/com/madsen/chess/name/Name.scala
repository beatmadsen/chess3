package com.madsen.chess.name

object Name {

  def apply(name: String): Name = (name: Seq[Char]) match {
    case Seq(file, rank) ⇒ apply(file, rank)
  }


  def apply(file: Char, rank: Char): Name = NameImpl(File(file), Rank(rank))


  private[Name] case class NameImpl(file: File, rank: Rank) extends Name {

    def neighbour(direction: Direction): Name = {


      ???
    }
  }


}


trait Neighbour {
  type T >: this.type <: Neighbour // this.type < T < Neighbour

  def neighbour(direction: Direction): T
}

sealed trait Name extends Neighbour {
  type T = Name
}
