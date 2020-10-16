package Lectures.Part1Basics

object Expressions extends App {

  val x: Int = 1 + 2 // EXPRESSION
  println(x)

  println( 2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // logical negation, ! && ||

  var aVariable = 2
  aVariable += 3 // also work with -= *= /= ... side effects
  println(aVariable)

  // Instructions (Tell the computer what to DO) vs Expressions (VALUE)
  // Scala works with Expressions

  // If expression
  val aCondition = false
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION NOT IF INSTRUCTION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN!!

  // Everything in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // SIDE EFFECTS: Println(), whiles, reassigning --> expressions returning Unit

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
    // the value of a block is the value of the last expression
  }

 // val anotherValue = z + 1 // z is defined inside the block and it's not visible outside

  // 1. difference between "hello word" vs println("hello world")?

  // "hello world" is a string and println("hello world") returns a Unit.
  // 2. What's the value of?

  val someValue = {
    2 < 3
  }
  // someValue = true -->  Boolean

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // someOtherValue = 42 --> last line evaluated
}
