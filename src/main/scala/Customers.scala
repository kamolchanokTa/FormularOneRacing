/**
  * Created by u6037291 on 11/25/2016.
  */
class Customer(var fullName:String, var orderValue:Double){
  println("Inside primary Constructor")

  private val address = "BKK"
  var age = 26

  override  def toString = s"$fullName has order value of $orderValue"
  def printAddress { println(s"Address = $address")}
  def printFullName { println(s"FullName = $fullName")}
  def calculateOrderTaxValue(orderValue:Double)={
    val tax = orderValue *0.5; tax
  }

  printAddress
  printFullName
  def this(fullName:String){
    this(fullName,1850)
  }
  println("Still in constructor")
}

object Main {
  def main(args: Array[String]) {
    val cust = new Customer("Danial",1850)
    println(cust.calculateOrderTaxValue(1850))
    cust.fullName = "Scott Ambler"
    cust.orderValue = 1850.85;
    println(cust.fullName)
    println(cust.orderValue)
  }
}