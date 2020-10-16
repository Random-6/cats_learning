package Lectures.Part1Basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION!!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }


  /*
  1. a Greeting function (name, Age) => Hi, my name is $name, and I am $age years old

  2. Factorial function 1*2*3 * .. * n recursive function

  3. Fibonacci function
    f(1) = 1
    f(2) = 1
     f(n) = f(n-1) + f(n-2)

  4. Function that test if a number is prime

  */

  // 1. Greeting function
  def aGreetingFunction(name: String, age: Int): String = {
    s"Hi, my name is $name and I'm $age years old."
  }
  println(aGreetingFunction("Alex",27))


  // 2. Factorial function

  def aFactorialFunction(n: Int): Int = {
    if (n <= 0) n
    else n * aFactorialFunction(n-1)
  }
  println("A Factorial Function: "+ aFactorialFunction(5))

  // 3. Fibonacci function

  def aFibonacciFunction(n: Int): Int = {
    if ((n == 1) || (n == 2)) 1
    else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)
  }

  println("A Fibonacci Function: "+ aFibonacciFunction(8))

  // 4. Function that test if a number is prime

  def isPrimeFunction(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println("A Prime Function: "+ isPrimeFunction(6))

}

// isPrimeFunction(7) --> isPrimeUntil(3.5) true --> t=2.5, isPrimeUntil(2.5) true, t= 1.5 isPrimeUntil(1.5) true, t=0.5 --> true
