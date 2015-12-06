package com.madsen.chess.name

import com.madsen.chess.name.Direction.{N, NW}
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

/**
  * Created by erikmadsen on 06/12/2015.
  */
class NameTest extends FlatSpec {


  "A name" should "list right neighbours in direction" in {
    Name('C', 4).follow(NW) should contain inOrderOnly(Name('B', 5), Name('A', 6))
    Name('D', 1).follow(N) should contain inOrderOnly(
      Name('D', 2),
      Name('D', 3),
      Name('D', 4),
      Name('D', 5),
      Name('D', 6),
      Name('D', 7),
      Name('D', 8)
      )
  }
}
