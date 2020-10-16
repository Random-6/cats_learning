package Lectures.Part3FP

object AnonymousFunction extends App{

  // OOP version
  /*
  val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }
  */

  // Functional version
  // anonymous function (LAMBDA)

  //val doubler = (x: Int) => x * 2 // lambda:  (x: Int) => x * 2

  val doubler: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething)  // function itself
  println(justDoSomething()) // call


  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MORE syntactic sugar
  //val niceIncrementer: Int => Int = (x:Int) => x +1
  val niceIncrementer: Int => Int = _ +1 // equivalent to x => x +1
  //val niceAdder: (Int, Int) => Int = (a,b) => a + b
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  /*
  1. MyList: replace all FunctionX calls with lambdas
  2. Rewrite the "special" adder as an anonymous function
   */

  /*
  2. Rewrite the "special" adder as an anonymous function

    val superAdder: Function1[Int, Function1[Int, Int]]= new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x+y
    }
  }
   */

  val superAdd = (x: Int) => (y:Int) => x + y
  println(superAdd(3)(4))
}


