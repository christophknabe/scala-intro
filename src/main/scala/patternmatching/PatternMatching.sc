//Author: Christoph Knabe
//2022-06-07

// Scala simplifies declaring immutable classes and pattern matching their content.
// A case class:
// - has all constructor parameters published as value attributes
// - has a companion object with an apply method usable as factory method
// - has generated methods: toString, equals, hashCode
case class Color(red: Int, green: Int, blue: Int){
  checkRange("red", red)
  checkRange("green", green)
  checkRange("blue", blue)
  private def checkRange(name: String, value: Int): Unit ={
    if(value < 0 || value > 255){
      throw new IllegalArgumentException(s"Color component $name has illegal value $value out of range 0..255")
    }
  }
}

//Calling the constructor:
val c1 = new Color(255, 0, 0)
//Calling the factory method explicitly:
val c2 = Color.apply(255, 0, 0)
//Calling the factory method implicitly:
val c3 = Color(255, 0, 0)
//General rule: If a method has the name 'apply',
// you can leave out the dot and the name.

// Object identity vs. equality:
//Are c1 and c2 identical?
val c1IdenticalC2 = c1 eq c2
//Are c1 and c2 equal (same content)?
val c1EqualC2 = c1 == c2
//Are c2 and c3 equal by java means?
val c2EqualsC3 = c2 equals c3 // c1.equals(c3)


// See https://www.rapidtables.com/web/color/html-color-codes.html
// Matching Color objects against patterns
def toCSS(color: Color): String = color match {
  case Color(255, 0, 0) => "color: red"
  case Color(0, 255, 0) => "color: green"
  case Color(0, 0, 255) => "color: blue"
  case Color(r, g, b) => s"color: rgb($r, $g, $b)"
}
val green = toCSS(Color(0, 255, 0))
val orange = toCSS(Color(255, 165, 0))

def isSleepReady(color: Color) = color match {
  // This branch is entered only if the if-condition holds:
  case Color(_, _, blue) if blue < 25 => true
  // matches all the other colors:
  case _ => false
}
val saddleBrown = Color(139, 69, 19)
val saddleBrownIsSleepy = isSleepReady(saddleBrown)
val lightYellow = Color(255, 255, 224)
val lightYellowIsSleepy = isSleepReady(lightYellow)

