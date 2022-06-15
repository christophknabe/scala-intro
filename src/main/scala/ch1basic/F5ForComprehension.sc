//For Comprehensions
// (C) 2022-06-15 Christoph Knabe

//See https://docs.scala-lang.org/tour/for-comprehensions.html

// Example set notation in mathematics:
// Let F = { f(x) | x ∊ ₦, x < 100 }

//Cf. Set Comprehension in Python:
// newSet= { expression  for element in iterable  if condition }
// F = { f(x) for x in natural if x < 100 }
// In Python we have similar comprehensions for lists, and maps, as well.

//Scala-Prelude:
val generator = 1 to 999
def condition(item: Int): Boolean = ???
def expression(item: Int): Int = ???
def doNotCall = {
  // The Scala syntax of the for comprehension is:
  for {
    item <- generator
    if condition(item)
    name = expression(item)
  } yield expression(name)
  // These elements can occur multiply and be mixed. All are optional.
  // for must be, yield once, or a block.
}

// If you use () instead of {} you have to separate by ;
val by4 = for(i <- 1 to 100; if i%2==0; even=i) yield 2*even

println("Simple usage as loop:")
for(i <- 1 to 10 by 2){
  print(s"$i ")
}

println("Combines iterations like a nested loop:")
val chessFields = for {
  c <- 'A' to 'H'
  i <- 1 to 8
} yield s"$c$i "

val numberList = (1 to 10).toList
val numberSet = (5 to 15).toSet
println("Result type depends on first iterable:")
val startedWithList = for{
  i <- numberList
  j <- numberSet
} yield i+j
val startedWithSet = for{
  j <- numberSet
  i <- numberList
} yield i+j

println("The for comprehension")
val byFor = for{
  i <- 1 to 3
  j <- 'A' to 'C'
  k <- 1 to 3
} yield s"$i$j$k"
println("is translated to an equivalent nesting of flatMap and map invocations:")
val byMapFlatMap =
  (1 to 3).flatMap{ i =>
    ('A' to 'C').flatMap{ j =>
      (1 to 3).map{ k =>
        s"$i$j$k"
      }
    }
  }

// For comprehensions are very often used with Monad types like Future
// in order to express asynchronous programming sequentially.

