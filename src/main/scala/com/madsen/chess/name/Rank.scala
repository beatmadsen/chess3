package com.madsen.chess.name

import com.madsen.chess.name.Direction._

import scala.collection.SortedSet

/**
  * Created by erikmadsen on 30/11/2015.
  */
sealed trait Rank extends Neighbour {
  type T = Rank
}


object Rank {

  private implicit val rankOrdering: Ordering[NumberRank] = Ordering.by(_.number)

  private val ranks: Vector[Rank] = SortedSet(`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`).toVector


  def apply(rank: Char): Rank = {

    val index: Int = rank - 1

    ranks(index)
  }


  private[Rank] abstract class NumberRank(val number: Char) extends Rank {

    override def toString: String = number.toString


    def neighbour(direction: Direction): Option[Rank] = direction match {
      case N | NE | NW ⇒
        if (number == 8) None
        else Some(ranks(number % 8))
      case S | SE | SW ⇒
        if (number == 1) None
        else Some(ranks((number - 2) % 8))
      case _ ⇒ Some(this)
    }
  }


  object `1` extends NumberRank(1)


  object `2` extends NumberRank(2)


  object `3` extends NumberRank(3)


  object `4` extends NumberRank(4)


  object `5` extends NumberRank(5)


  object `6` extends NumberRank(6)


  object `7` extends NumberRank(7)


  object `8` extends NumberRank(8)


}


