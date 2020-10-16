package Lectures.Part1Basics

object CBNvsCBV extends App{

  // the computer evaluates nanotime() and then uses the computed value in the entire function
  // value is computed before call
  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  // => the parameter will be called by name
  // the expression is passed and it's evaluated everytime (thus it changes!)
  // lazy evaluation
  def calledByName(x: => Long): Unit ={
    println("By name: " + x)
    println("By name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
  // will crash
  // printFirst(infinite(),34)

  // the byname implementation passes an expression and only computes it when needed
  // y is not used, then, no need to compute it
  printFirst(34, infinite())

}
