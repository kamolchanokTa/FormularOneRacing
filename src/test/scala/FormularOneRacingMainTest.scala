/**
  * Created by Miruku on 11/26/2016.
  */
import org.scalatest.FunSuite
import org.scalatest._

import scala.collection.mutable.ListBuffer
class FormularOneRacingMainTest extends FunSuite with BeforeAndAfter {

  val n: Int = 5
  val distance: Float = 5000
  val i: Int = 0
  var cars: ListBuffer[RaceCar] =  _
  before {
    cars = new ListBuffer[RaceCar]
  }
  test("new carRacing has zero car") {
    assert(cars.size == 0)
  }

  test("Add 5 carRacing"){
    for (i <- 1 to n) {
      val car = new RaceCar(i, 2 * i, 0, 150 + 10 * i, 2, 0.8f, 200 * (n - i), false, false)
      cars += car
    }
    assert(cars.size == 5)
  }
}
