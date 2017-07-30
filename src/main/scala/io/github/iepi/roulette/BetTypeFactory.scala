package io.github.iepi.roulette

object BetTypeFactory {

  def red(): BetType = {
    BetType(2, _.color == Colour.Red)
  }

  def black(): BetType = {
    BetType(2, _.color == Colour.Black)
  }

  def first12(): BetType = {
    BetType(3, slice => (slice.number > 0) && (slice.number <= 12))
  }

  def inner12(): BetType = {
    BetType(3, slice => (slice.number > 12) && (slice.number <= 24))
  }

  def last12(): BetType = {
    BetType(3, slice => slice.number > 24)
  }

}
