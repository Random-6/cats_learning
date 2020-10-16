package Lectures.Part1Basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))

  // when recursive depth is too deep: StackOverflowError (e.g. factorial (5000))

  def anotherFactorial(n: Int): Int = {
    @tailrec // to make sure the function is TAIL recursive
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) //TAIL RECURSION: recursive call as the LAST expression

    factHelper(n, 1)
  }

  // Use BigInt if we need very big numbers!!

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
  1. Concatenate a string n times tail recursive
  2. IsPrime function tail recursive
  3. Fibonacci function tail recursive

  tip: need accumulator: as many as recursive calls


  */

  // 1. Greeting function
  def concatenateString(aString: String, n: Int): String = {
    @tailrec // to make sure the function is TAIL recursive
    def concatHelper(s: String, x: Int): String = {
      if (x == 1) s
      else concatHelper(s + aString, x - 1)
    }
    concatHelper(aString, n)
  }

  //TEACHER VERSION
  @tailrec // to make sure the function is TAIL recursive
  def anotherconcatenateString(aString: String, n: Int, accumulator:String): String = {
    if (n <= 0) accumulator
    else anotherconcatenateString(aString, n - 1,aString + accumulator)
  }

  println(concatenateString("Alex ",5))




  // isPrime function
  //TEACHER VERSION
  def anotherisPrimeFunction(n: Int): Boolean = {
    @tailrec // to make sure the function is TAIL recursive
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)
    isPrimeTailrec(n / 2, true)
  }

// Fibonacci function
//TEACHER VERSION
  def anotherFibonacciFunction(n: Int): Int ={
    @tailrec // to make sure the function is TAIL recursive
    def fibHelper(i: Int, last:Int, nextToLast:Int): Int =
      if (i >= 2) last
      else fibHelper(i+1, last+nextToLast,last)

    if (n <=2) 1
    else fibHelper(2, 1, 1)
  }

  /*
  anotherFibonacciFunction(5)
  fibHelper(5,1)
  fibHelper(4,1+1)
  fibHelper(3,1+1+1)
  fibHelper(2,1+1+1) --> 3

  anotherFibonacciFunction(3)
  fibHelper(3,1)
  fibHelper(2,1+1)
  fibHelper(2,1+1+1) --> 3

  */


}
