package com.madsen.chess.name

import com.madsen.chess.name.Direction.{E ⇒ East, NE, NW, SE, SW, W}

import scala.collection.SortedSet

sealed trait File extends Neighbour {
  type T = File
}


object File {

  private implicit val fileOrdering: Ordering[LetterFile] = Ordering.by(_.letter)

  private val files: Vector[File] = SortedSet(A, B, C, D, E, F, G, H).toVector


  def apply(letter: Char): File = {

    val index: Int = letter - 'A'

    files(index)
  }


  def values: Iterable[File] = files


  private[File] abstract class LetterFile(val letter: Char) extends File {

    override def toString: String = letter.toString


    def neighbour(direction: Direction): Option[File] = direction match {

      case W | NW | SW ⇒
        if (letter == 'A') None
        else Some(files((letter - 'A' + 7) % 8))

      case East | NE | SE ⇒
        if (letter == 'H') None
        else Some(files((letter - 'A' + 1) % 8))

      case _ ⇒ Some(this)
    }
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
