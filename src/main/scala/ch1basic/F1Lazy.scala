package ch1basic

object F1Lazy extends App {

  // Demonstration of the evaluation of
  // Strict values vs. Lazy values vs. function definitions
  val aaa = { // strict value will be initialized at definition
    println("Initializing aaa")
    1
  }
  lazy val bbb = { //will be initialized only at first usage
    println("Initializing bbb")
    2
  }
  def ccc = { // method will be computed at each invocation
    println("Computing ccc")
    3
  }
  val ddd = { // strict value will be initialized at definition
    println("Initializing ddd")
    4
  }
  println(s"aaa=$aaa, bbb=$bbb, ccc=$ccc, ddd=$ddd")
  println("========Second Run========")
  println(s"aaa=$aaa, bbb=$bbb, ccc=$ccc, ddd=$ddd")

}
