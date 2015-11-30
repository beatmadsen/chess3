package com.madsen.chess.name

/**
  * Created by erikmadsen on 30/11/2015.
  */
sealed trait Rank {
}

object Rank {

  private val ranks: Vector[Rank] = Vector(`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`)


  def apply(rank: Char): Rank = {

    val index: Int = rank - 1

    ranks(index)
  }


  private[Rank] abstract class NumberRank(val number: Char) extends Rank {

    require(number >= 1)
    require(number <= 8)


    override def toString: String = number.toString
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


