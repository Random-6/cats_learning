package Lectures.Part1Basics

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

// SCALA PARTICULARITIES
  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // apending
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age +1} years old"
  println(anotherGreeting)

  // F-interpolators: formatted string (%s : string format; %2.2f 2 characters total, minimum, 2 decimal precision)
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.5f burgers per minute "
  println(myth)

  // raw-interpolator
  // ignores \n with raw text, but not as part of a val
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
