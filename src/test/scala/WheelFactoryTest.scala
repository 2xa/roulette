import scala.util.Random
import io.github.iepi.roulette.{Colour, WheelFactory}
import org.scalatest._

class WheelFactoryTest extends FlatSpec {

  "An european wheel" should "have exactly 18 reds, 18 blacks and 1 green" in {
    val europeanWheel = WheelFactory.european(Random)
    assert(europeanWheel.slices.length == 37)
    assert(europeanWheel.slices.count(_.color.equals(Colour.Black)) == 18)
    assert(europeanWheel.slices.count(_.color.equals(Colour.Red)) == 18)
    assert(europeanWheel.slices.count(_.color.equals(Colour.Green)) == 1)
  }
}