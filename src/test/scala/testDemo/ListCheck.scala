package testDemo

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
/** ScalaCheck property-based testing based on generated examples.
 * @author Christoph Knabe
 * @since 2022-06-13
 */
object ListCheck extends Properties("List") {

  // We do not try singular examples, but formulate laws,
  // which must hold for all generated input values.

  property("reverse") = forAll { l: List[Int] =>
    //println(l);
    l.reverse.reverse == l
  }
  property("head :: tail") = forAll { l: List[Int] =>
    l.isEmpty || l.head :: l.tail == l
  }
  property("List(head) ++ tail") = forAll { l: List[Int] =>
    l.isEmpty || List(l.head) ++ l.tail == l
  }
  property("sum") = forAll { l: List[Int] =>
    l.isEmpty || l.sum == l.reduce(_+_)
  }
  property("fold, sum") = forAll { l: List[Int] =>
    val result = l.fold(0)((a, b) => a+b)
    l.isEmpty && result==0 ||
    result == l.sum
  }
  property("take, drop") = forAll { (l: List[Int], n: Int) =>
    val takeNumber = math.abs(n) % (l.length + 1)
    println(s"takeNumber=$takeNumber")
    val left = l.take(takeNumber)
    val right = l.drop(takeNumber)
    println(s"left=$left")
    println(s"right=$right")
    //Still a failing test about left.size:
    left.size == takeNumber &&
    //That worked OK without the size test:
    left ++ right == l
  }

}
