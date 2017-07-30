package io.github.iepi.roulette

import scala.util.Random

object WheelFactory {

  def european(random: Random): Wheel = {

    val blacks = Array(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35)
    val reds = Array(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36)
    val greens = Array(0)

    val slices = blacks.map(Slice(_, Colour.Black)) ++
      reds.map(Slice(_, Colour.Red)) ++
      greens.map(Slice(_, Colour.Green))

    Wheel(slices.toList, random)
  }
}



