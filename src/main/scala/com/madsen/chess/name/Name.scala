package com.madsen.chess.name

object Name {

  private val map: Map[(File, Rank), Name] = {

    val tuples: Iterable[((File, Rank), NameImpl)] = for {
      f ← File.values
      r ← Rank.values
    } yield (f, r) → NameImpl(f, r)

    tuples.toMap
  }


  def apply(name: String): Name = (name: Seq[Char]) match {
    case Seq(file, rank) ⇒ apply(file, rank)
  }


  def apply(file: Char, rank: Char): Name = NameImpl(File(file), Rank(rank))


  private[Name] case class NameImpl(file: File, rank: Rank) extends Name {

    def follow(direction: Direction): Seq[Name] =
      neighbour(direction).toStream flatMap { name ⇒
        name #:: (name follow direction).toStream
      }


    def neighbour(direction: Direction): Option[Name] = for {
      f ← file neighbour direction
      r ← rank neighbour direction
      tuple = (f, r)
      name ← map get tuple
    } yield name
  }


}


trait Neighbour {
  type T >: this.type <: Neighbour // this.type < T < Neighbour

  def neighbour(direction: Direction): Option[T]
}

sealed trait Name extends Neighbour {
  type T = Name

  def follow(direction: Direction): Seq[Name]
}
