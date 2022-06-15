package testDemo

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers

/** Test our Stack implementation in Spec style. */
class StackSpec extends AnyFunSpec with Matchers {

  describe("Stack.push") {
    it("must fail for a blank argument") {
      val testee = new Stack
      assertThrows[IllegalArgumentException]{
        testee.push(null)
      }
      assertThrows[IllegalArgumentException]{
        testee.push("")
      }
      assertThrows[IllegalArgumentException]{
        testee.push(" \t\r\n")
      }
    }
  }
  describe("Stack.pop") {
    it("must fail for an empty stack") {
      val testee = new Stack
      assertThrows[Stack.EmptyException]{
        testee.pop()
      }
    }
    it("must return items in Last-In First-Out (LIFO) order") {
      val testee = new Stack
      // We are testing an example usage:
      testee.push("A")
      testee.push("B")
      testee.push("C")
      testee.pop() mustBe "C"
      testee.pop() mustBe "B"
      testee.pop() mustBe "A"
      assertThrows[Stack.EmptyException]{
        testee.pop()
      }
    }
  }
}