package Lectures.Part3FP

import Exercises.myListGeneric

object WhatsAFunction extends App{

  // DREAM: use functions as first class elements
  // PROBLEM: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))
  
  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  /*
  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
*/

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS


  /*
  1. Function which takes 2 strings and concatenates them
  2. Transform the MyPredicate and MyTransformer into function types
  3. Define a function which takes an int and returns another function which takes an int and returns an int
    - what's the type of this function
    - how to do it (implement it)

   */



  // 1. Function which takes 2 strings and concatenates them
  def concatStrings:(String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatStrings("Hello ", "Scala"))

  // teacher version
  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  //  3. Define a function which takes an int and returns another function which takes an int and returns an int
  //    - what's the type of this function
  //    - how to do it (implement it)

  // Function1[Int, Function1[Int, Int]]

  val superAdder: Function1[Int, Function1[Int, Int]]= new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x+y
    }
  }


  val adder3 = superAdder(3)

  println(adder3(4))
  println(superAdder(3)(4)) // curried function


}

/*
trait Action[A,B] {
  def execute(element:A): B
}
 */

trait MyFunction[A,B] {
  def apply(element:A): B
}
