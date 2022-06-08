import java.io.{Serializable,File}

//Keyword 'object' introduces an anonymous class
// and one single object of this class.
//This avoids the static/dynamic universes of Java or C++ programming.

object Counter {
  private var count: Int = 0
  def get = count
  def incr(): Unit = count+=1
}
//new Counter
//There is only one instance!
Counter.incr()
println(s"counter=${Counter.get}")

object Person {
  def hello = "hello"
}
// Why is that better than the Java/C++ approach with keyword 'static'?
{ //This block opens a new name scope by which I avoid a name clash between outer and inner Counter.
  // If you need multiple counters, simply replace 'object' by 'class':
  class Counter {
    private var count: Int = 0
    def get = count
    def incr(): Unit = count+=1
  }
  // If you want to retain the old singleton API,
  // create 1 instance with the name 'Counter':
  val Counter = new Counter
  Counter.incr()
  Counter.incr()
  println(s"counter2=${Counter.get}")
  val counter3 = new Counter
  counter3.incr()
  // Local import example:
  import java.io.File.pathSeparator
  println(s"$pathSeparator")
  Person.hello
}


class Router(path: String) {
  import Router._ // Imports all names from the companion object.
  def get(): Response = getAction(path)
  def post(): Response = postAction(path)
  def patch(): Response = patchAction(path)
  def put(): Response = putAction(path)
  def delete(): Response = deleteAction(path)
}

//For a class we can define a companion object with the same name.
//Both may access private parts of the other.
object Router {
  val baseUrl: String = "https://www.baeldung.com"

  case class Response(baseUrl: String, path: String, action: String)

  private def getAction(path: String): Response = Response(baseUrl, path, "GET")
  private def postAction(path: String): Response = Response(baseUrl, path, "POST")
  private def patchAction(path: String): Response = Response(baseUrl, path, "PATCH")
  private def putAction(path: String): Response = Response(baseUrl, path, "PUT")
  private def deleteAction(path: String): Response = Response(baseUrl, path, "DELETE")
}