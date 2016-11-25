/**
  * Created by u6037291 on 11/25/2016.
  */
 class Car(val id:Int, val acceleration:Int, val speed:Float, val topSpeed:Int){
  println("Inside primary Constructor")

  def setId(id:Int) =  { val ID = id; ID}
  def setAcceleration(acceleration:Int)={
    val Acceleration = acceleration; Acceleration
  }

  println("Still in constructor")
}
import scala.collection.mutable
case class RaceCar(override val id:Int, override val acceleration:Int, override val speed:Float, override val topSpeed:Float, nitro:Float, val handlingFactor:Float, val position:Float, val isUseNitro:Boolean,val isFinished:Boolean) extends Car(id, acceleration, speed,topSpeed ){
  override  def toString = s"id: $id , speed: $speed  postion: $position  acceleration: $acceleration  topSpeed: $topSpeed nitro: $isUseNitro finished: $isFinished"
}

class RaceCarResult(val car:RaceCar, val finishedTime:Int, val finalSpeed:Float) {
  override  def toString = s"id: $car.id , finishedTime: $finishedTime  finalSpeed: $finalSpeed "
}

class RaceResult() {
  def resultRacing() = { val raceResult =  new ListBuffer[RaceCarResult]}
}

object RacingMain {
  def main(args: Array[String]) {
    val n:Int = 5
    val distance:Float = 5000
    val i:Int =0
    val cars = List[RaceCar]
    for(i <- 1 to n){
      val car  = new RaceCar( i,2*i,0,150+10*i, 2,0.8f,200*(n-i),false,false)
      cars.in
    }
    println(newCar.setAcceleration(1850))
  }
}

