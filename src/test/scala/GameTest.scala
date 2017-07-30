import io.github.iepi.roulette.{Game, StrategyFactory, WheelFactory}
import org.scalatest._

import scala.util.Random

class GameTest extends FlatSpec {

//  "A game " should "" in {
//    val random = Random
//    val wheel = WheelFactory.european(random)
//    val strategy = StrategyFactory.randomColour(random)
//    val finalCredit = Game(wheel, strategy).play(rounds = 10, initialCredit = 1000)
//    println(finalCredit)
//  }

  "A game " should " have a final credit" in {
    val random = Random
    val wheel = WheelFactory.european(random)
    val rounds = random.nextInt(1000)
    var credit = 1000
    (0 to rounds).foreach(round => {
      val strategy = StrategyFactory.randomColour(random)
      val roundCredit = Game(wheel, strategy).play(rounds = 1, initialCredit = credit)
      credit = roundCredit.head
    })
    println("Final credit is " + credit)
  }
}