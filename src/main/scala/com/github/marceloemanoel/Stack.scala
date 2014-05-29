package com.github.marceloemanoel

object Stack {
  def apply() = new EmptyStack
}

trait Stack {

  def push(value: Integer): Stack = new NonEmptyStack(value, this)

  def pop(): Stack

  def top(): Option[Integer]

  def size(): Integer

}

class EmptyStack extends Stack {

  override def size(): Integer = 0

  override def top(): Option[Integer] = None

  override def pop(): Stack = throw new StackUnderflow()

}

class NonEmptyStack(value: Integer, stack: Stack) extends Stack {

  override def size(): Integer = 1 + stack.size()

  override def top(): Option[Integer] = Some(value)

  override def pop(): Stack = stack

}

class StackUnderflow extends RuntimeException