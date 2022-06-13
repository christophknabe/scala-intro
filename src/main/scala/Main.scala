object Main {
  def main(args: Array[String]): Unit = {
    val name = if (args.length > 0) args(0) else "world"
    println(s"Hello, $name")
  }
}
