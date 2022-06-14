import scala.annotation.tailrec
// Control Abstraction
//Author: Christoph Knabe
//2022-06-10

// Question: What is a Control Structure?

// ScaLa is a Scalable Language. We can define our own control structures. How?

// A Block is an Expression
/* There is no big difference in Scala between a block {...} and an expression (...).
* A block contains many expressions, separated by ; or newline,
*   which are evaluated in sequence.
* A block also is an expression, which returns the value of its last expression.
 */
val block1 = {
  1;
  2 //Why grey?
  3
}
val block2 = {4; 5; 6}

// An parameter list with one parameter can be satisfied by a block as argument list.
def sqrt(x: Double) = math.sqrt(x)
val srqtOf25 = sqrt(25)
val sqrtOf100 = sqrt{
  val x = 100 //Why here not grey?
  println(s"Now passing $x")
  x
}

// A method/function can have multiple parameter lists
def power(base: Double)(exponent: Double) = math.pow(base, exponent)
// So we can transform a function with two parameters
// into a function with two parameter lists of length 1.
// Now we can provide a block as argument.
val base2power10 = power(2){
  println("Passing the exponent")
  10
}

// Call-by-Name Parameters
/* Scala has a feature which already existed in the pioneer languages
* LISP 1956 and Algol 1960:
* "Call-by-Name" parameters.
* Not the argument value is passed into the function execution,
* but the argument expression.
* It is evaluated every time the parameter is applied, that means 0..n times.
* By that we can create our own control structures.
*
* A call-by-name parameter is notated similar to a function signature
* from no argument to a result type,
* Syntax    name: => Type
*/

//Question: When can it be useful not to evaluate an argument
// before we enter into the called method?










// First usage: Optional evaluation

abstract class Level(val value: Int)
case object WARN extends Level(2)
case object DEBUG extends Level(1)

var logLevel = WARN

def log(messageLevel: Level, messageText: => String): Unit ={
  if(messageLevel.value >= logLevel.value){
    println(messageText)
  }
}
// In Java the costly  message computation would be executed,
// even if the logLevel will ignore the message.
// here with call-by-name parameter for message, it is computed only if really needed.
log(WARN, "WARN: Our current log level is " + logLevel)
log(DEBUG, "DEBUG: Our current log level is " + logLevel)
//Question: What is costly in the above message computation?


// Second usage: Multiple evaluation

// We write our own simple loop:
@tailrec
def repeat(count: Int)(body: => Unit): Unit = {
  if(count <= 0){ return } //Interrupt the recursion
  body
  repeat(count - 1)(body) //Deepen the recursion
}
repeat(10){
  println("==========")
}

//==========================
// Dummy data
val from = 123456
val to = 7890123
val amount = 199.95
// dummy implementations:
object connection {
  def commit() = {}
  def rollback() = {}
}
object logic {
  def sendMoney(from: Long, to: Long, amount: Double) = {}
}


// Third usage: Evaluation inside a try-catch
// Example: Define your own transaction mechanism:
def transaction(name: => String)(block: => Unit) = try {
  block
  connection.commit();
} catch {
  case ex: Exception => connection.rollback();
    System.err.println(s"Transaction $name failed.")
    ex.printStackTrace()
}

// Usage:
transaction("Send money"){
  logic.sendMoney(from, to, amount)
}

//Recap: By Call-by-Name parameters we can define our own control structures.