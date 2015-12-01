package com.madsen.chess.name

import scala.collection.SortedSet

sealed trait Direction {

  def next: Direction

  def previous: Direction
}


object Direction {

  private implicit val dirOrdering: Ordering[NumberDirection] = Ordering.by(_.number)

  private val directions: Vector[Direction] = SortedSet(N, NE, W, SE, S, SW, E, NW).toVector


  private[Direction] abstract class NumberDirection(val number: Char) extends Direction {

    def next: Direction = directions((number + 1) % 8)


    def previous: Direction = directions((number + 7) % 8)
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
