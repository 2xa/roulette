package io.github.iepi.roulette


import scala.util.Random

object StrategyFactory {
  def randomColour(random: Random): Strategy = {
    new Strategy {
      override def apply(index: Int, credit: Int): List[Bet] = {
        val red = random.nextBoolean()
        val betType = if (red) BetTypeFactory.red() else BetTypeFactory.black()
        List(Bet((credit * 0.1).toInt, betType))
      }
    }
  }

  def iepiStrategy1(random: Random): Strategy = {
    val x2Strategies = Array(BetTypeFactory.red(), BetTypeFactory.black())
    val x3Strategies = Array(BetTypeFactory.first12(), BetTypeFactory.inner12(), BetTypeFactory.last12())
    new Strategy {
      override def apply(index: Int, credit: Int): List[Bet] = {
        val betType = index match {
          case i: Int if i % 100 == 0 => x3Strategies(random.nextInt(x3Strategies.length))
          case _ => x2Strategies(random.nextInt(x2Strategies.length))
        }
        List(Bet((credit * 0.2).toInt, betType))
      }
    }
  }
}
