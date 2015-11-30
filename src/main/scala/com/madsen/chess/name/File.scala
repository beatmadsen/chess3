package com.madsen.chess.name

import scala.collection.SortedSet

sealed trait File {
}


/**
  * Created by erikmadsen on 30/11/2015.
  */
object File {

  private implicit val fileOrdering: Ordering[LetterFile] = Ordering.by(_.letter)

  private val files: Vector[File] = SortedSet(A, B, C, D, E, F, G, H).toVector


  def apply(letter: Char): File = {

    val index: Int = letter - 'A'

    files(index)
  }


  private[File] abstract class LetterFile(val letter: Char) extends File {

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
