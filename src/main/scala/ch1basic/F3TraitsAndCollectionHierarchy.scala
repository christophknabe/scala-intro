package ch1basic

object F3TraitsAndCollectionHierarchy extends App {

  // A trait is much like a Java interface.
  trait Swimmer {
    def swim() = println("Swimming...")
  }
  trait Driver {
    def drive(): Unit = println("Driving...")
  }
  // A class or object can extend one class or trait, and add many traits by keyword 'with'.
  class Ship extends Swimmer
  class Car extends Driver
  class AmphibianVehicle extends Swimmer with Driver //Alternative: Driver with Swimmer
  val torroVW = new AmphibianVehicle
  torroVW.swim()
  torroVW.drive()

  // A trait can additionally allow attributes and implemented methods:
  trait Logging {
    private var count = 0
    def log(message: String) = {
      count += 1
      println(s"#$count: $message")
    }
  }
  class AmphibianLoggingVehicle extends Swimmer with Driver with Logging
  val multiVehicle = new AmphibianLoggingVehicle
  multiVehicle.swim()
  multiVehicle.drive()
  multiVehicle.log("Arrived")

  // A modular style mixing in several traits is named **mixin-based** programming.

  // The Scala Collections Framework makes heavy use of mixing in traits.
  val list: List[String] = List("alpha", "beta", "gamma")
  // Navigate into type List => many traits are incorporated (by 'with').

  // ====== Core Abstractions ======
  // https://docs.scala-lang.org/overviews/collections/overview.html
  // The most general collection trait is Traversable.
  val traversable: Traversable[String] = list
  // This offers sequential traversability as a whole like:
  traversable.foreach(println)

  // More specific traits are Seq, Set, Map.
  // The traits in the Traversable hierarchy have immutable implementations as default,
  // but also mutable implementations.

  //Set operations
  val names1 = Set("Hans", "Lisa", "Anton", "Maria", "Fred")
  val names2 = Set("Maria", "Lorelei", "Hans", "Valeria", "Anton")
  val union = names1 ++ names2
  println(s"union=$union")
  val intersection = names1 -- names2
  println(s"intersection=$intersection")






  // A trait with only abstract methods is just like a traditional Java interface.
  // this.type is the type of the concrete object we have.
  trait Comparable[A] {
    /** @return a negative number, if this comes before that,
     *         0 if they are equal,
     *         a positive number, if this comes after that.*/
    def compareTo(that: this.type ): Int //abstract
  }

  // A class or object can extend one class or trait, and add many traits by keyword 'with'.
  class Level(val number: Int) extends Comparable[Level] {
    override def compareTo(that: Level.this.type): Int = this.number - that.number
  }

  // The Scala Collection Framework offers two worlds:
  // immutable, and mutable collections with common traits.
  // The mutable collections have additional methods for mutation.

}
