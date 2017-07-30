package io.github.iepi.roulette

import scala.util.Random

case class Wheel(slices: List[Slice], random: Random) {

  def spin() : Slice = {
      slices(random.nextInt(slices.length))
  }
}