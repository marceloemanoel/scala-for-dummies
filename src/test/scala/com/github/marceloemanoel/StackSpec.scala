package com.github.marceloemanoel

import org.scalatest.{FunSpec, Matchers}

/**
 * Uses the RSpec style of testing
 */
class StackSpec extends FunSpec with Matchers {

  describe("An EmptyStack") {
    val emptyStack = new EmptyStack()

    it("have size 0") {
      emptyStack.size() should be(0)
    }

    it("doesn't have a top") {
      emptyStack.top() should be(None)
    }

    it("returns a new stack once pushed") {
      val newStack = emptyStack.push(2)

      newStack.size() should be(1)
      newStack.top() should be(Some(2))
    }

    it("should underflow once popped") {
      intercept[StackUnderflow] { emptyStack.pop() }
    }
  }

  describe("A NonEmptyStack") {
    val stack: Stack = new NonEmptyStack(1, new NonEmptyStack(2, new EmptyStack()))

    it("have size 2") {
      stack.size() should be(2)
    }

    it("tops to 1") {
      stack.top() should be(Some(1))
    }

    it("returns another stack on pop") {
      val stack2 = stack.pop()
      stack2.top() should be(Some(2))
    }

    it("after pop still tops to 1") {
      stack.pop()
      stack.top() should be(Some(1))
    }
  }
}
