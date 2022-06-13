package testDemo

class Stack {

  import Stack.EmptyException // from companion object

  private var content: List[String] = List.empty

  def push(item: String): Unit = {
    // Calling method from a Java library:
    if(org.apache.commons.lang3.StringUtils.isBlank(item)){
      throw new IllegalArgumentException("Blank argument to push")
    }
    // :: is the cons(truct) operator for Lists. Put item before the list.
    content = item :: content
  }
  def pop(): String = content match {
    // In pattern matching the :: decomposes a list into its head and its tail.
    case head :: tail =>
      content = tail
      head
    case Nil =>
      throw new EmptyException()
  }
}

object Stack {
  class EmptyException extends Exception("The Stack is empty.")
}
