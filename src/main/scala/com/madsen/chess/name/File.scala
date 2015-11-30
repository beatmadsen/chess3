package com.madsen.chess.name

sealed trait File {
}


/**
  * Created by erikmadsen on 30/11/2015.
  */
object File {

  private val files: Vector[File] = Vector(A, B, C, D, E, F, G, H)


  def apply(letter: Char): File = {

    val index: Int = letter - 'A'

    files(index)
  }


  private[File] abstract class LetterFile(val letter: Char) extends File {

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
