import java.io.Serializable

//Keyword object introduces a class and one single object of this class.
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


class Router(path: String) {
  import Router._
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

  private def getAction(path: String): Response = {
    Response(baseUrl, path, "GET")
  }

  private def postAction(path: String): Response = {
    Response(baseUrl, path, "POST")
  }

  private def patchAction(path: String): Response = {
    Response(baseUrl, path, "PATCH")
  }

  private def putAction(path: String): Response = {
    Response(baseUrl, path, "PUT")
  }

  private def deleteAction(path: String): Response = {
    Response(baseUrl, path, "DELETE")
  }
}


sealed class BaeldungEnvironment extends Serializable {
  val name: String = "int"
}

object BaeldungEnvironment {

  case class ProductionEnvironment() extends BaeldungEnvironment {
    override val name: String = "production"
  }

  case class StagingEnvironment() extends BaeldungEnvironment {
    override val name: String = "staging"
  }

  case class IntEnvironment() extends BaeldungEnvironment {
    override val name: String = "int"
  }

  case class TestEnvironment() extends BaeldungEnvironment {
    override val name: String = "test"
  }

  def fromEnvString(env: String): Option[BaeldungEnvironment] = {
    env.toLowerCase match {
      case "int"        => Some(IntEnvironment())
      case "staging"    => Some(StagingEnvironment())
      case "production" => Some(ProductionEnvironment())
      case "test"       => Some(TestEnvironment())
      case _            => None
    }
  }
}