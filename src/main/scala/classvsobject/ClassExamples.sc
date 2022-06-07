//See https://github.com/Baeldung/scala-tutorials/blob/master/scala-core-oop/src/main/scala/com/baeldung/scala/classvsobject/ClassExamples.scala
val constA = "A"
val constB = 4
//primary constructor:
class Abc(var a: String, var b: Int) {
  //auxiliary constructors:
  def this(a: String) {
    this(a, constB)
  }
  def this(b: Int) {
    this(constA, b)
  }
  def this() {
    this(constA, constB)
  }
}
//Check the values of the not passed attributes:
val abc1 = new Abc("String")
println(s"abc1.b = ${abc1.b}")
val abc2 = new Abc(42)
println(s"abc2.a=${abc2.a}")

//var is mutable, val is immutable
//val or var in constructor makes the parameter an attribute.
//val or var without visibility modifier is public.
class Car(val manufacturer: String, var brand: String, var model: String) {
  private var speed: Double = 0;
  private var gear: Int = 0;
  protected var isOn: Boolean = false;
  //How many atttributes? 6

  def start(keyType: String): String = {
    s"Car started using the $keyType"
  }

  def selectGear(gearNumber: Int): String = {
    gear = gearNumber
    //last expression of block is its result:
    s"Gear has been changed to $gearNumber"
  }

  def accelerate(rate: Double, seconds: Double): String = {
    speed += rate * seconds
    s"Car accelerates at $rate per second for $seconds seconds."
  }

  def brake(rate: Double, seconds: Double): String = {
    speed -= rate * seconds
    s"Car slows down at $rate per second for $seconds seconds."
  }

  def stop(): String = {
    speed = 0;
    gear = 0;
    isOn = false;
    "Car has stopped."
  }
}

class Toyota(transmission: String, brand: String, model: String)
  extends Car("Toyota", brand, model) {
  override def start(keyType: String): String = {
    if (isOn) {
      return "Car is already on."
    }
    if (transmission == "automatic") {
      isOn = true
      s"Car started using the $keyType"
    } else {
      isOn = true
      s"Please ensure you're holding down the clutch. Car started using the $keyType"
    }
  }
}
// up to here at 22-06-07
object Prediction {
  implicit class AgeFromName(name: String) {
    val r = new scala.util.Random
    def predictAge(): Int = 10 + r.nextInt(90)
  }
}

class PlayList {
  var songs: List[Song] = Nil

  def addSong(song: Song): Unit = {
    songs = song :: songs
  }

  class Song(title: String, artist: String)
}
