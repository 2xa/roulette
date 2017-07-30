import io.github.iepi.roulette.{Bet, BetTypeFactory, Colour, Slice}
import org.scalatest._

class BetTest extends FlatSpec {

  "A bet" should "have positive gain" in {
    val bet = Bet(10, BetTypeFactory.red())
    val outcomeRed = bet.collect(Slice(1, Colour.Red))
    assert(outcomeRed == 20)
    val outcomeBlack = bet.collect(Slice(2, Colour.Black))
    assert(outcomeBlack == 0)
  }
}