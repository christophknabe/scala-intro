// 2022-06-08 Christoph Knabe
// predefined Collection methods:
// here we use the generic collection class List.
val concatenatedNames = "Sandra Anton Lisa Derrick Virginia Hans Mu Amir"
//Chinese female name "Mu" means "admired", arab male name "Amir" means "prince".
val names = concatenatedNames.split(' ').toList

//=======filter=======
// We only want the short names:
val shortNames = names.filter(x => x.length < 5)
// x => x.length < 5     is a function literal, aka closure.
// Here the identifier x is redundant. So there is an abbreviation for it:
// _.length < 5
val shortNames2 = names.filter(_.length < 5)

//How would you filter all names which start with an 'A'?









val aNames = names.filter(_.startsWith("A"))

// If we also want the opposite names, we can use partition:
val shortVsLongNames = names.partition(_.length < 5)
// We got a tuple: (shortNames, longNames) and can decompose it by pattern matching:
val (shortnames, longNames) = shortVsLongNames

//========= map =========
val lengths = names.map(_.length)
//Why does the following not work?
//val namesWithLength0 = names.map(_ + _.length)
//How do we have to create a List with elements like "Sandra6"?


val namesWithLength = names.map(x => x + x.length)

//========== reduce ==========
//By reduce we can reduce a List to one result of the element type.
//We need to provide a
val namesString = names.reduce((x,y) => x + "~" + y)
//Here we can apply the underscore abbreviation, as we use the parametrs in their order:
val namesString2 = names.reduce(_ + "~" + _)
//reduce is a simplified form of the fold operation we learned.

//Exercise:
//How would you compute the shortest name from the List?
def shortest(list: List[String]): String = {
  ???
}