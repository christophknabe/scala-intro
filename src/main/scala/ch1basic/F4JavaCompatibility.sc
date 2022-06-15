// Some Methods for Java Compatibility

/*Java:
null: Often used to express a missing object.
 */
//Scala:
val name: String = null //same meaning as in Java, but better to be replaced by Option, or Either.

/*Java:
 public String toString(Object object){
   if(object instanceof String){ // type check
     return (String)object; // type cast
   }
   throw new IllegalArgumentException();
 }
 */
// We should avoid that style in Scala, that is why we have to type more:
def toString(anyRef: AnyRef): String = {
  if(anyRef.isInstanceOf[String]){ // type check
    return anyRef.asInstanceOf[String] // type cast
  }
  throw new IllegalArgumentException()
}

//The Java postfixed .class keyword gives us a literal for a class object in a typed manner.
// That we can use for reflection operations.
/*Java:
  factory.create(Person.class)
*/
//If a Java library expects us to pass a class object for class X
// in Scala we can use classOf[X]:
// factory.create(classOf[Person])

// The class object is the entry point for Java reflection:
val methods = classOf[testDemo.Stack].getMethods
println(s"Stack Methods=========================\n")
methods.foreach(println)