package com.madsen.chess.name

object Name {

  def apply(file: Char, rank: Char): Name = NameImpl(File(file), Rank(rank))


  private[Name] case class NameImpl(file: File, rank: Rank) extends Name


}


sealed trait Name {
}





