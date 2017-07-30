import io.github.iepi.roulette.{Game, StrategyFactory, WheelFactory}
import org.scalatest._

import scala.util.Random

class Iepi1GameTest extends FlatSpec {

  "A game " should " should be fun" in {
    val random = Random
    val wheel = WheelFactory.european(random)
    var credit = 1000
    val history = (0 to 1000).foldLeft(List[(Int, List[Int])]())((historyAcc, game) => {
      val strategy = StrategyFactory.iepiStrategy1(random)
      val gameHistory: List[Int] = Game(wheel, strategy).play(rounds = 12, initialCredit = credit)
      println(s"$game -> $gameHistory")
      (game, gameHistory) :: historyAcc
    })
    history.groupBy(_._2.head / 100).map({
      case (hundreds, games) => (hundreds * 100, games.length)
    }).toList.sortBy(_._1).foreach(println)

    println("avg=" + history.map(_._2.head).sum / 1000)
    println("<1000=" + history.map(_._2.head).count(_ <= 1000))
    println("1000-2000=" + history.map(_._2.head).count(outcome => outcome <= 2000 && outcome > 1000))
    println(">2000=" + history.map(_._2.head).count(_ > 2000))
  }
}