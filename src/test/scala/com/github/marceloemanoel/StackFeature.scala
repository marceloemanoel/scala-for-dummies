package com.github.marceloemanoel

import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * Use the cucumber style of testing.
 */
class StackFeature extends FeatureSpec with GivenWhenThen{

  info("As a Stack user")
  info("I want to be able to push and pop values")
  info("So I can use them later")
  info("And know the stack size")
  info("And know which value is on top")

  feature("Stack Size") {
    scenario("user ask the stack size on an empty stack") {

      Given("An empty stack")
      val emptyStack = new EmptyStack

      Then("it should be empty")
      assert(emptyStack.size() == 0)
    }
    scenario("user ask the stack size on a non empty stack") {

      Given("A non empty stack")
      val stack = new NonEmptyStack(1, new NonEmptyStack(2, new EmptyStack))

      Then("it should be 2")
      assert(stack.size() == 2)
    }
  }
}
