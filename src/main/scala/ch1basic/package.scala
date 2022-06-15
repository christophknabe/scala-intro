package object ch1basic {
  // package object: a container for definitions global in the package.

  //Basics
  //2022-06-14 Christoph Knabe

  // A program consists of packages. Unlike Java not package==directory

  // A package consists of definitions starting with keyword:

  // import: makes a name available without qualification. Placeable anywhere.
  import scala.annotation.tailrec

  // type: a type alias
  type Person = (String, Int) //meaning name, age  // better use a case class

  // val: a value
  val N = 77 //unmodifiable

  // var: a variable
  var x = 99 //modifiable
  x += 1

  // def: a method
  def square(x: Double) = x*x

  // class: a class
  case class BetterPerson(name: String, age: Int)

  // object: a singleton object
  object Counter {
    private var count = 0
    def incr() = count += 1
    def get = count
  }

}
