package Lectures.Part1Basics

object ValuesVariablesTypes extends App {

  val x = 42 // TYPES OF VALS ARE OPTIONAL --> COMPILER CAN INFER TYPES
  println(x)

  // x = 2 --> VALS ARE IMMMUTABLE

  val aString: String = "hello, Scala"; // ; ARE ALLOWED BUT NOT NECESSARY
  val anotherString = "Goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 4613583920456456785L //Big numbers need L at the end
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects

  // VARIABLES ARE MUTABLE --> SIDE EFFECTS

}
