import scala.math.BigInt.int2bigInt

/**
  * Created by u6037291 on 11/25/2016.
  */
case class Car(id: Int,  acceleration: Int,  speed: Float,  topSpeed: Int){
  println("Inside primary Constructor")
  }

  object Car {

    var cars = Set(
      Car(1,1,2,1)
    )

    /**
      * Products sorted by EAN code.
      */
    def findAll = cars.toList.sortBy(_.id)

    /**
      * The product with the given EAN code.
      */
    def findById(ean: Long) = cars.find(_.id == id)

    /**
      * Deletes a product from the catalog.
      */
    def remove(car: Car) = {
      val oldCars = cars
      cars = cars - car
      oldCars.contains(car)
    }

    /**
      * Adds a product to the catalog.
      */
    def add(car: Car) {
      cars = cars + car
    }
  }