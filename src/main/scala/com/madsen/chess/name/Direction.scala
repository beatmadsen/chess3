package com.madsen.chess.name

import scala.collection.SortedSet

sealed trait Direction {

  def next: Direction

  def previous: Direction

  def orthogonal: (Direction, Direction)
}


object Direction {
  private implicit val dirOrdering: Ordering[NumberDirection] = Ordering.by(_.number)
  private val Sorted: SortedSet[NumberDirection] = SortedSet(N, NE, W, SE, S, SW, E, NW)

  val All: Set[Direction] = Sorted.toSet
  val Diagonal: Set[Direction] = {
    Sorted filter (_.number % 2 == 1)
  }.toSet
  val Normal: Set[Direction] = {
    Sorted filter (_.number % 2 == 0)
  }.toSet


  private val Directions: Vector[Direction] = Sorted.toVector


  private[Direction] abstract class NumberDirection(val number: Char) extends Direction {

    def next: Direction = Directions((number + 1) % 8)


    def previous: Direction = Directions((number + 7) % 8)


    def orthogonal: (Direction, Direction) = (Directions((number + 6) % 8), Directions((number + 2) % 8))
  }


  object N extends NumberDirection(0)

  object NE extends NumberDirection(1)

  object E extends NumberDirection(2)

  object SE extends NumberDirection(3)

  object S extends NumberDirection(4)

  object SW extends NumberDirection(5)

  object W extends NumberDirection(6)

  object NW extends NumberDirection(7)

}
