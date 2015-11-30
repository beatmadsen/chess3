package com.madsen.chess


object Name {

  def apply(file: Char, rank: Char): Name = {

    NameImpl(File(file), Rank(rank))
  }


  case class NameImpl(file: File, rank: Rank) extends Name


}


sealed trait Name {
}


object Rank {

  private val ranks: Vector[Rank] = Vector(`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`)


  def apply(rank: Char): Rank = {

    val index: Int = rank - 1

    ranks(index)
  }


  private abstract class NumberRank(val number: Char) extends Rank {

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


sealed trait Rank {
}


object File {

  private val files: Vector[File] = Vector(A, B, C, D, E, F, G, H)


  def apply(letter: Char): File = {

    val index: Int = letter - 'A'

    files(index)
  }


  private abstract class LetterFile(val letter: Char) extends File {

    require(letter >= 'A')
    require(letter <= 'H')


    override def toString: String = letter.toString
  }


  object A extends LetterFile('A')


  object B extends LetterFile('B')


  object C extends LetterFile('C')


  object D extends LetterFile('D')


  object E extends LetterFile('E')


  object F extends LetterFile('F')


  object G extends LetterFile('G')


  object H extends LetterFile('H')


}


sealed trait File {
}


