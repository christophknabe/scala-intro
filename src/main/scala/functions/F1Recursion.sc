import scala.annotation.tailrec
//Author: Christoph Knabe
//2022-06-07

var state: Double = 25

//The result of a mathematical function only depends on its argument value.
//Two similar definitions. What is a function?
def sqrt1(x: Double) = Math.sqrt(x)
def sqrt2() = Math.sqrt(state)
// Question: How can we make sqrt2 a function?

sqrt1(25)
sqrt2()

state = state*state
println(s"x modified to $state")

sqrt1(25)
sqrt2()
//Anything what depends on state or modifies state is not a mathematical function!

//----------------

//Task: Compute the Gauss-sum (sum of 1 to n)
//How do we do that in traditional style (iterative solution with variable)?
def gaussIterative(n: Int): Long = {
  var result = 0L
  for(i <- 1 to n){
    result += i
  }
  result
}
println(s"gaussIterative(1000) = ${gaussIterative(1000)}")

//But how do we program a loop without state?
//Recursive solution:
def gaussRecursive(n: Int): Long = {
  if(n <= 0){ //guard clause for special case
    return 0
  }
  n+gaussRecursive(n-1)
}
//How many variables does this algorithm have?
println(s"gaussRecursive(1000) = ${gaussRecursive(1000)}")

//But what about deep recursion?
val big = 10000 //Try increase to 100000
println(s"gaussRecursive($big) = ${gaussRecursive(big)}")

//If we formulate the solution tail-recursive, we avoid the problem:
def gaussTailRecursive(accu: Long, n: Int): Long = {
  if(n <= 0){ //guard clause for special case
    return accu
  }
  gaussTailRecursive(n+accu, n-1)
}
//Tail-recursive means: The recursive call is the last action of the function.
//Important here: The 'accu+n' is evaluated before the recursive call.
println(s"gaussTailRecursive(100000) = ${gaussTailRecursive(0, 100000)}")

//How can we guarantee that our function is tail-recursive?
//Let the compiler check it by the annotation @tailrec
@tailrec
def gaussTailrec(accu: Long, n: Int): Long = {
  if(n <= 0){ //guard clause for special case
    return accu
  }
  gaussTailrec(accu+n, n-1)
}
//@tailrec assures that this function is really tail-recursive.
println(s"gaussTailrec(100000) = ${gaussTailrec(0, 100000)}")

//Let us test what happens if we put @tailrec before gaussRecursive!

//By a tail-recursive function we can emulate a loop without variables,
// as parameters in Scala are immutable.