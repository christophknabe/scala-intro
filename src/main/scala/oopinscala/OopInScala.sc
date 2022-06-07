//See https://github.com/Baeldung/scala-tutorials/blob/master/scala-core-oop/src/main/scala/com/baeldung/scala/oopinscala/OopConcepts.scala
import scala.collection.mutable.ArrayBuffer

// A parameterless class:
class Person
new Person
val person1 = new Person

//Classical Object Orientation: Object attributes are modifiable.
//Syntax is more concise than Java
// Parameters of primary constructor immediately after class name
class Bread(breadName: String = "white", breadWeight: Int = 1000) {
  val name: String = breadName // value is immutable.
  var weight: Int = breadWeight // variable is mutable.

  def getPrice(priceUnit: Int): Int = { //block as method body
    priceUnit * weight
  }
  override def toString = s"Bread(name=$name, weight=$weight)" //expression as body
}
val defaultBread = new Bread() //uses 2 optional parameters with default value
val myBread = new Bread("black") //uses 1 optional parameter
//val means immutable:
//myBread.name = "Impossible"

//var means mutable:
myBread.weight += myBread.weight / 10 //Augment weight by 10 percent
myBread
val price = myBread.getPrice(2)
// string interpolation: Checks that parameters exist
println(s"My bread is $myBread and costs $price cents.")

class Sandwich(bread: Bread, mainFilling: String) {
  //Encapsulation by private:
  // ArrayBuffer is a mutable collection like Java ArrayList:
  private val fillings = new ArrayBuffer[String]()
  //Initialization statements can be placed in the class body:
  addFilling(mainFilling)

  private def getFillingNames: String = {
    fillings.mkString(", ")
  }

  def getDescription: String = {
    s"This is a sandwich with ${bread.name} bread and $getFillingNames filling"
  }

  // Unit is the return type for nothing (like Java void),
  // the method lives for its side effect:
  def addFilling(extraFilling: String): Unit = {
    fillings.append(extraFilling)
  }
}

val mySandwich = new Sandwich(myBread, "Butter")
mySandwich.addFilling("Ham")
mySandwich.getDescription

//val or var before a constructor parameter make it a public attribute:
class Vehicle(val numWheels: Int, val color: String) {
  def accelerate(): Unit = { println("Vroom Vroom") }
}
val v = new Vehicle(3, "red")
println(s"My Vehicle has ${v.numWheels} wheels.")

//Super constructor invocation occurs by passing arguments after the super class name:
class Bicycle(bikeColor: String, val bikeType: String) extends Vehicle(2, bikeColor) {
  //How many attributes does a Bicycle have?
  def maxSpeed(): Int = {
    bikeType match {
      //That is pattern matching:
      case "road" => 60
      // Underscore is the joker and matches anything
      case _ => 20
    }
  }
  //Method overloading: Same method name, different signatures:
  def maxSpeed(speedLimit: Int): Int = {
    bikeType match {
      case "road" =>
        //Here we use the if-construct as expression like Java ? :
        if(speedLimit < 60) speedLimit else 60
      case _ => if(speedLimit < 20) speedLimit else 20
    }
  }

  override def accelerate(): Unit = { println("Whoooosh") }
}

val bike = new Bicycle("blue", "City")
bike.numWheels
bike.color
bike.bikeType
//bike.bikeColor
//So each val/var parameter translates into an attribute.
bike.maxSpeed()