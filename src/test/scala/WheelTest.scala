import scala.util.Random
import io.github.iepi.roulette.{Colour, Slice, Wheel}
import org.scalatest._

class WheelTest extends FlatSpec {

  "A Wheel" should "have exactly 37 slices" in {
    val slices = (0 to 36).map((index : Int) => Slice(index, Colour.Red)).toList
    val wheel = Wheel(slices, Random)
    assert(wheel.slices.length == 37)
  }
}