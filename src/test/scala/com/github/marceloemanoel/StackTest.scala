package com.github.marceloemanoel

import org.scalatest.junit.JUnitSuite
import org.junit.{Test, Before}
import org.junit.Assert._
import org.hamcrest.CoreMatchers._

/**
 * Use the JUnit style of testing
 */
class StackTest extends JUnitSuite {

  var emptyStack: Stack = null

  @Before
  def setUp() {
    emptyStack = new EmptyStack()
  }

  @Test
  def anEmptyStackHaveSizeEqualToZero() {
    assertThat(emptyStack.size(), is(equalTo(Integer.valueOf(0))))
  }

  @Test
  def anEmptyStackDoesNotHaveATop() {
    val expected: Option[Integer] = None
    assertThat(emptyStack.top(), is(equalTo(expected)))
  }

  @Test
  def pushingToAnEmptyStackCreatesAnStackWithOneValue() {
    val newStack = emptyStack.push(1)
    val expected:Option[Integer] = Some(1)

    assertThat(newStack.top(), is(equalTo(expected)))
    assertThat(newStack.size(), is(equalTo(Integer.valueOf(1))))
  }

  @Test
  def popingFromAnEmptyStackShouldFailWithAnStackUnderflow() {
    intercept[StackUnderflow]{ emptyStack.pop() }
  }
}
