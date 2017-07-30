package io.github.iepi.roulette

case class Game(wheel: Wheel, strategy: Strategy) {

  def play(rounds: Int, initialCredit: Int): List[Int] = {
    (0 to rounds).foldLeft(List(initialCredit)) {
      (history, round) =>
        val bet = strategy(round, history.head)
        val credit = history.head - bet.amount + bet.collect(wheel.spin())
        credit :: history
    }
  }
}
