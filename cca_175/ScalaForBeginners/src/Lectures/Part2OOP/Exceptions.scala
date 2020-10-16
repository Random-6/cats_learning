package Lectures.Part2OOP

import java.nio.BufferOverflowException

object Exceptions extends App{


  val x: String = null

  //println(x.length)
  // this will crash with a NullPointerException
  // 1. Throwing exceptions

  // exceptions are instances of classes (NPE)
  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable classs
  // Exception and Error the major Throwable subtypes

  // 2. How to catch exceptions
  def getIn(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might fail
    getIn(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    //optional
    // does not influence the return type of this expression
    // use finally only for side effects
    // code that will get executed NO MATTER WHAT
    println("finally")
  }


  // 3. How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException
  //throw exception

  /*
  1. Crash your program with an OutOfMemoryError
  2. Crash your program with SOError
  3. PocketCalculator
    - add(x,y)
    -subtract(x,y)
    - multiply(x,y)
    - divide(x,y)

    Throw
      - OverflowException if add(x,y) exceeds Int.Max_VALUE
      - UnderflowException if subtract(x,y)exceeds Int.MIN_VALUE
      - MathCalculationException for division by 0

   */

  //  Crash your program with an OutOfMemoryError
  try {
    val array = Array.ofDim(Int.MaxValue)
  } catch {
    case e: OutOfMemoryError => println("Caught an OutOfMemoryError")
  } finally {
    println("End of try-catch OOMError block")
  }

  // Crash your program with SOError

  try{
    def infinite: Int = 1 + infinite
    val noLimit = infinite
  } catch {
    case e: StackOverflowError => println("Caught a StackOverflowError")
  } finally {
    println("End of try-catch SOError block")
  }

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")


  object PocketCalculator {
    def add(x: Int, y:Int)= {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y:Int)= {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y:Int)= {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new UnderflowException
      else if (x > 0 && y < 0 && result > 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }


    def divide(x: Int, y:Int)= {
      val result = x / y
      if (y == 0) throw new MathCalculationException
      else x / y
    }
    //def multiply(x: Int, y:Int): Int = x * y
    //def divide(x: Int, y:Int): Int = x / y
  }

  //println(PocketCalculator.add(Int.MaxValue,10))
  //println(PocketCalculator.subtract(20,10))
  println(PocketCalculator.divide(10,0))
}

