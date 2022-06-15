package ch1basic

class F2TypeHierarchy {

  //In Java there is a strong difference between a primitive type
  // (byte, short, int, long, char, boolean, float, double)
  // and its wrapper class, which is a reference type
  // (Byte, Short, Integer, Long, Char, Boolean, Float, Double).

  // The primitive types need little storage (1 to 64 bits) and have no methods.
  // The reference types are complete objects and have methods like equals, hashCode, and toString.

  // Since Java 5 they are automatically boxed/unboxed, which can lead to inefficient code:
  /*
  Integer i = 0; //Boxing
  while(i<100){ //Unboxing
    System.out.println(i); //Unboxing
    i++; // Unboxing, incrementing, Boxing
  }
  */

  // In Scala these types are unified. The compiler selects the most effective implementation.
  // For computation the primitive implementation.
  // For storage in a collection the boxed implementation.
  // Differences are not observable!
  val myVar: Double = 5d
  println(s"myVar = ${myVar.toString}") //value type Double has methods.

  // The Type Hierarchy:
  // https://docs.scala-lang.org/tour/unified-types.html

  // Any is the supertype of all types in Scala, with methods like equals, hashCode, toString

  // AnyVal is the supertype of all value types.
  // Comparisons by eq (identity) and == (equality) will behave the same.

  // Unit is a subtype of AnyVal without a contained value. The only instance of it is ().
  // Used as return value for procedures (only side effect).

  // AnyRef is the supertype of all reference types in Scala. The Scala name for Java Object.
  // Comparisons by eq (identity) and == (equality) can differ.

  // Null is a subtype of all subtypes of AnyRef.
  // Its only value is null, the null reference. To avoid in Scala.

  // Nothing is a subtype of all types. Does not contain information. Example:
  val empty: List[Nothing] = List()
  // So I can concatenate a List[Nothing] with a List[String]
  val strings: List[String] = empty ++ List("alpha", "beta")

}
