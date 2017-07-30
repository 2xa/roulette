package io.github.iepi.roulette

case class Bet(amount: Int, betType: BetType) {

  def collect(slice: Slice): Int = {
    betType.checker(slice) match {
      case true => amount * betType.gainFactor
      case _=> 0
    }
  }
}
