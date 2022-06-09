//2022-06-07 Christoph Knabe

//Functional Programming languages have functions as first-class citizens.
//Traditional (before Java 8):
// Objects can be created, passed as argument, stored, retrieved, and used.
// Methods can only be defined, and used.

//First-class citizen: You can do all alike with functions.

//Problem: Process a List of values in several ways.
//Here are some iterative functions:
//List is a generic type, parameterized with its element type.
//Generic parameters are in Scala designated by square brackets []
//Indexes are just as function arguments designated by round parentheses ()
def sum(list: List[Int]): Long = {
  var result: Long = 0
  for(item <- list){ //for each item in the list
    result += item
  }
  result
}
def min(list: List[Int]): Long = {
  var result: Long = Int.MaxValue
  for(item <- list){
    if(item < result){
      result = item
    }
  }
  result
}
//What is redundant, what is different between these functions?






//Now a redundancy-free solution by a higher-order function,
// which accepts a function as parameter processItem:
// Function processItem must map a Long and an Int to a Long.
def fold(list: List[Int], start: Long, processItem: (Long, Int) => Long): Long = {
  var result = start
  for(item <- list){
    result = processItem(result, item)
  }
  result
}
//Here we implement sum and min by using our higher-order function 'fold'.
def sum2(list: List[Int]) = fold(list, 0, (accu, item) => accu+item)
def min2(list: List[Int]) = fold(list, Int.MaxValue, (accu, item) => if(item<accu) item else accu)
//Now we test them:
val numbers = List(7,1,5,9,10,2,8,3,4,6)
println(s"sum2(numbers)=${sum2(numbers)}")
println(s"min2(numbers)=${min2(numbers)}")

//Further explanations

// We use a conditional expression:   if(item<accu)  item else accu
// In Java it has another syntax:        item<accu ? item  :   accu
// The signature of our processItem function:   (Long, Int) => Long
// The function literals for different calls of fold:
//   (accu, item) => accu+item
//   (accu, item) => if(item<accu) item else accu


//How would we compute the maximum of a List[Int]?
def max(list: List[Int]) = ???
println(s"max(numbers)=${max(numbers)}")

// A fold function is already included into the Scala standard library for collections.
// Note: foldLeft is a function with two parameter lists.
def sum3(list: List[Int]) = list.foldLeft(0)((accu, item) => accu+item)
def min3(list: List[Int]) = list.foldLeft(Int.MaxValue)((accu, item) => if(item<accu) item else accu)
val numbers = List(7,1,5,9,10,2,8,3,4,6)
println(s"sum3(numbers)=${sum3(numbers)}")
println(s"min3(numbers)=${min3(numbers)}")

// You can partially apply a function with multiple parameter lists,
// but that is not very often useful:
def zeroFold(list: List[Int]): ((Long, Int) => Long => Long) =
  list.foldLeft(0)