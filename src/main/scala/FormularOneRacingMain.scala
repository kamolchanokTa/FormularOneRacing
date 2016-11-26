/**
  * Created by u6037291 on 11/25/2016.
  */
import scala.collection.mutable.ListBuffer
import util.control.Breaks._

case class RaceCar(var id:Int, var acceleration:Int,var speed:Float,  var topSpeed:Float,var nitro:Float, val handlingFactor:Float, var position:Double, var isUseNitro:Boolean,var isFinished:Boolean) {//extends Car(id, acceleration, speed,topSpeed ){
  override  def toString = s"id: $id , speed: $speed  postion: $position  acceleration: $acceleration  topSpeed: $topSpeed nitro: $isUseNitro finished: $isFinished"
}

class RaceCarResult(val car:RaceCar, val finishedTime:Int, val finalSpeed:Float) {
  override  def toString = s"id: $car.id , finishedTime: $finishedTime  finalSpeed: $finalSpeed "
}

class RaceResult() {
    val raceResult =  new ListBuffer[RaceCarResult]
}

class CarRacing(var racingTeam:ListBuffer[RaceCar], val distance:Float){

  val DELTA_TIME:Int = 2
  val TAILGATING:Int = 10
  var longDistance = distance
  var racingCars = racingTeam
  var finishedCars = new ListBuffer[RaceCar]

  val raceResult = new RaceResult


  private def printStatus() {
    for (car <- racingCars) {
      println(car)
    }
  }

  private def accesses(t: Int) {
    println("time:" + t)
    var minPos = java.lang.Double.MAX_VALUE
    var minIdx = -1
    // refresh speed and position of each car
    var iteration = 0
    while (iteration < racingCars.size) {
      {
        var car = racingCars(iteration)
        breakable {
          if (car.isFinished) break
        }
        // refresh position
        car.position += car.speed * DELTA_TIME + 0.5 * car.acceleration * DELTA_TIME * DELTA_TIME
        if (car.position < minPos) {
          minPos = car.position
          minIdx = iteration
        }
        // refresh speed
        if (car.speed < car.topSpeed) car.speed = Math.min(car.speed + car.acceleration * DELTA_TIME, car.topSpeed)
        // check if the car finish racing
        if (car.position >= distance) {
          car.isFinished = true
          var result = new RaceCarResult(car,t,car.speed)
          finishedCars += car
          raceResult.raceResult += result
          println("car " + car.id + " finish racing")
          println(car)
        }
        iteration += 1
      }
    }
    printStatus()
    // if some one is tailgating, decelerate
    var i = 0
    while (i < racingCars.size) {
      {
        val cari = racingCars(i)
        breakable {
          if (cari.isFinished) break
        }
        //todo: continue is not supported
        var j = 0
        while (j != i && j < racingCars.size) {
          val carj = racingCars(j)
          breakable {
            if (carj.isFinished) break
          }
          if (carj.position > cari.position && (carj.position - cari.position) < TAILGATING) {
            cari.speed *= cari.handlingFactor
            println("car " + cari.id + " is tailgating car " + carj.id + " at time:" + t)
            println(cari)
            println(carj)
          }
          j += 1
        }
        i += 1
      }
    }
    // the last position car may use nitro
    if (minIdx != -1) {
      val car = racingCars(minIdx)
      if (!car.isUseNitro) {
        car.speed = Math.min(car.topSpeed, car.speed * car.nitro)
        car.isUseNitro = true
        println("car " + car.id + " use nitro")
        println(car)
      }
    }
  }

  def isFinished():Boolean = {
    finishedCars.length == racingCars.length
  }
  def race():RaceResult = {
    var time:Int = 0
    while(!isFinished())
      {
        time += DELTA_TIME
        accesses(time)
      }
    return raceResult
  }
}

object RacingMain {
  def main(args: Array[String]) {
    val n:Int = 5
    val distance:Float = 5000
    val i:Int =0
    val cars = new ListBuffer[RaceCar]
    for(i <- 1 to n){
      val car  = new RaceCar( i,2*i,0,150+10*i, 2,0.8f,200*(n-i),false,false)
      cars += car
    }
    val intial = new CarRacing(cars,distance)
    val raceResult = intial.race()
    println("RACING RESULT")
    for(carResult <- raceResult.raceResult)
      {
        println(s"$carResult.car , finishedTime: $carResult.finishedTime,  finalSpeed: $carResult.finalSpeed")
      }
  }
}

