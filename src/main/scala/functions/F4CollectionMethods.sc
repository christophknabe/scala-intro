// 2022-06-08 Christoph Knabe
// Chapter: Predefined Collection Methods

// Base data
val concatenatedNames = "Sandra Anton Lisa Derrick Virginia Hans Mu Amir"
//Chinese female name "Mu" means "admired", arab male name "Amir" means "prince".

val splitted: Array[String] = concatenatedNames.split(' ')
// Array[T] is Scala's representation for Java's T[].

// Here we transform the Array[String] to the generic collection class List.
val names: List[String] = splitted.toList

// Now we will look at some predefined higher-order functions of Scala collections.

//====================filter====================
// We only want the short names:
val shortNames = names.filter(x => x.length < 5)
// x => x.length < 5     is a function literal, aka closure, aka lambda expression.
// Here the identifier x is redundant. So there is an abbreviation for it:
// _.length < 5
val shortNames2 = names.filter(_.length < 5)

//Task: How would you filter all names which start with an 'A'?





val aNames = names.filter(_.startsWith("A"))

//Task: How would you call 'startsWith' in Infix Syntax?


val aNames2 = names.filter(_ startsWith "A")

//Task: How would we additionally call 'filter' in Infix Syntax'?


val aNames3 = names filter (_ startsWith "A")

//Task: Can we even remove the remaining parentheses?
//val aNames4 = names filter _ startsWith "A"


// If we also want the opposite names, we can use partition:
val shortVsLongNames = names.partition(_.length < 5)
// We got a tuple: (shortNames, longNames) and can decompose it by pattern matching:
val (shortnames, longNames) = shortVsLongNames

//==================== map ====================
// map applies a function to each item and
// collects the results in a collection of the same type.
val lengths = names.map(_.length)
//Why does the following not work?
//val namesWithLength0 = names.map(_ + _.length)
//How can we create a List with elements like "Sandra6", or "Lisa4"?




val namesWithLength = names.map(x => x + x.length)
// Conclusion: Underscore works only, if it stands for arg0, arg1, ...


//==================== reduce ====================
//By reduce we can reduce a List to one result of the element type.
//We need to provide an associative function which combines two elements,
// or an accumulator and an element.
val namesString = names.reduce((x,y) => x + "~" + y)
//Here we can apply the underscore abbreviation, as we use the parameters in their order:
val namesString2 = names.reduce(_ + "~" + _)
//reduce is a simplified form of the fold operation we learned,
//but it is undefined for an empty List.

//Exercise:
//How would you compute the shortest name from the List?
def shortest(list: List[String]): String = {
  ???
}