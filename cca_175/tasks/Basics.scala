// Databricks notebook source
// Scala Basics
// 2020-09-27
// Source: https://docs.scala-lang.org/tour/unified-types.html

// COMMAND ----------

object HelloWorld {
  def main(args: Array[String]) {
    println("Hello World")
  }
}

// COMMAND ----------

HelloWorld.main(null)

// COMMAND ----------

// Values 

// COMMAND ----------

val x = 1+1 
println(x)

// COMMAND ----------

// Same but declaring type 
val x: Int = 1+1 

// COMMAND ----------

// Variables 

// COMMAND ----------

var x = 1+1 
x = 3 
println(x)


// COMMAND ----------

// Values that are functions 

// COMMAND ----------

val addOne = (x: Int) => x + 1
println(addOne(1)) // 2 

// COMMAND ----------

// Methods

// COMMAND ----------

def add(x: Int, y:Int): Int = x + y 
println(add(1, 5)) //6

// COMMAND ----------

def getSquareString(input: Double): String = {
  val square = input * input
  square.toString  // Returned value 
}
println(getSquareString(5.5))

// COMMAND ----------

// Classes 
// Instances are compared by reference 

// COMMAND ----------

class Greeter(prefix: String, suffix:String) {
  // Metodo 
  // The return type is Unit --> there is nothing meaningful to return 
  def greet(name: String): Unit = 
    println(prefix + name + suffix)
}

// COMMAND ----------

val greeter = new Greeter("Hello, ", " <3")
greeter.greet("Xisca")

// COMMAND ----------

// Case classes 
// Special type of classes that Scala has. Instances are immutable (they are compared by value). Useful for pattern matching

// COMMAND ----------

case class Point(x : Int, y:Int) 

// COMMAND ----------

val point = Point(1, 2) 
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

// COMMAND ----------

if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are different.")
} // Point(1,2) and Point(1,2) are the same.

if (point == yetAnotherPoint) {
  println(point + " and " + yetAnotherPoint + " are the same.")
} else {
  println(point + " and " + yetAnotherPoint + " are different.")
} // Poi

// COMMAND ----------

// Objects
// Single instances of their own definitions 

// COMMAND ----------

object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter +=1 
    counter 
  }
}

// COMMAND ----------

val newId: Int = IdFactory.create()
println(newId)
val newerId: Int = IdFactory.create()
println(newerId)

// COMMAND ----------

// Trait Objects

// COMMAND ----------

trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}

// COMMAND ----------

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0
  override def hasNext: Boolean = current < to
  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1 
      t
    } else 0
  }
}

// COMMAND ----------

val iterator = new IntIterator(10)

// COMMAND ----------

for (i <- Range(0, 15, 1)) {
  println("Value of i: " + i + " and iterator: " + iterator.next())
}

// COMMAND ----------

// Main Method 
// The entry point of Scala program. The Java Virtual Machine requieres a main method (named main) that takes one argument: an array of strings

// COMMAND ----------

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, Xisca!")
  }
}

// COMMAND ----------

// Class with Methods 

// COMMAND ----------

class Point(var x: Int, var y: Int) {
  def move(dx: Int, dy: Int): Unit = {
    x = x + dx 
    y = y + dy
  }
  // Override cause toString already exists (from AnyRef)
  override def toString: String = {
    s"($x, $y)"
  }
}

// COMMAND ----------

val point1 = new Point(2, 3) 
println(point1.x)

// COMMAND ----------

point1.toString()
point1.move(2, 3)
point1.toString()

// COMMAND ----------

// Private Members and Getter/Setter Syntax 
class Point {
  // Private vars
  private var _x = 0  // where the data is stored 
  private var _y = 0
  private val bound = 100
  
  def x = _x // methods to access private data 
  def x_= (newValue: Int): Unit = { // this clases are for validating and setting value
    if (newValue < bound) _x = newValue else printWarning
  }
  // this is the getter syntax _y
  def y = _y
  // this is the setters syntax: y_
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }
  
  private def printWarning = println("WARNING: Out of bounds")
}

// COMMAND ----------

val point1 = new Point 
point1.x = 99 
point1.y = 101 // Out of bounds

// COMMAND ----------

// Default parameter values

// COMMAND ----------

def log(message: String, level:String = "Info") = println(s"$level: $message")

// COMMAND ----------

log("System starting")

// COMMAND ----------

// More Traits

// COMMAND ----------

import scala.collection.mutable.ArrayBuffer

// COMMAND ----------

trait Pet {
  val name: String
}

class Cat(val name: String) extends Pet 
class Dog(val name: String) extends Pet 

val dog = new Dog("Harry")
val cat = new Cat("Sally")

val animals = ArrayBuffer.empty[Pet]
animals.append(dog) 
animals.append(cat) 
animals.foreach(pet => println(pet.name))

// COMMAND ----------

// Tuple: value that contains a fixed number of elements, each with its own type. 
// Tuple are immutable. they are handy for returning multiple values from a method 
// It can be difficult to choose between tuples or case classes (as the elements in classes are named)

// COMMAND ----------

val ingredient = ("Sugar", 25) // Defining

// COMMAND ----------

ingredient._1 // Accessing first value

// COMMAND ----------

// Pattern matching 
val (name, quantity) = ingredient 
println(name)

// COMMAND ----------

val planets = List(
  ("Mercury", 57.9), 
  ("Venus", 108.2), 
  ("Earth", 149.6)
)

planets.foreach{
  case ("Earth", distance) => 
    println(s"Our planet is $distance million km from the sun")
  case _ =>
}

// COMMAND ----------

// Class Composition with mixins
// mixins are traint --> used to compose a class 

// COMMAND ----------

abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  def loudMessage = message.toUpperCase()
}

class D extends B with C
val d = new D

// COMMAND ----------

println(d.message) // Print the message 
println(d.loudMessage)  // print the message but upper case

// COMMAND ----------

// Differences 
// abstract class -> it contains both abstract and non-abstract methods, do not support multiple inheritance. It can not be added to an object. It contains constructor params 
// traits --> uspport multiple inheritance, it can be added to an object. It does not contain constructor params 

// COMMAND ----------

// High-order functions: take other functions as parameters or return a function as a result. 

// COMMAND ----------

val salaries = Seq(2000, 7000, 4000) 
val doubleSalary = (x: Int) => x * 2
val newSalaries = salaries.map(doubleSalary)

// COMMAND ----------

val newSalaries = salaries.map(_ * 2) // parameter is a single Int, caveat is enough

// COMMAND ----------

// Functions that return functions 

// COMMAND ----------

def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if (ssl) "https://" else "http:/"
  (endpoint: String, query:String) => s"$schema$domainName/$endpoint?$query"
}


// COMMAND ----------

val domainName = "www.example.com" 
def getUrl = urlBuilder(ssl = true, domainName) 
val endpoint = "users" 
val query = "id-1" 
val url = getUrl(endpoint, query) // secondary strings 

// COMMAND ----------

// Nested methods 

// COMMAND ----------

def factorial(x :Int): Int = {
  // Nested method 
  def fact(x: Int, accumulator: Int): Int = {
    if (x <= 1) accumulator
    else fact(x -1, x * accumulator)
  }
  fact(x, 1)
}

println("Factor of 2: " + factorial(2))

// COMMAND ----------

// Case class
// are good for modeling immutable data 

// COMMAND ----------

case class Book(isbn: String) 
// It does not need "new" because they have an apply method, by default which 
// takes care of object construction
val frankenstein = Book("828-82351893")

// COMMAND ----------

// they are compared by structure and not by reference
case class Message(sender: String, recipient: String, body: String)

val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val messagesAreTheSame = message2 == message3  // true

// COMMAND ----------

// Pattern matching 
// check a value against a pattern --> a successful match can also deconstruct a value 
// into itsconstituent parts 

// COMMAND ----------

import scala.util.Random 
val x: Int = Random.nextInt(10)
x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}

// COMMAND ----------

// Singleton object 
// Object --> class that has exactly one instance. It is created lzaily when its referenced

// COMMAND ----------

object Box

// COMMAND ----------

// Object with Method 
package logging 
object Logger {
  def info(message: String): Unit = println(s"Info: $message")
}

// COMMAND ----------

// companion object 
// object with the same name as a class --> companion object 
import scala.math._

case class Circle(radius: Double) {
  import Circle._
  def area: Double = calculateArea(radius) // this is a member 
}

object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0) // method 
}

// COMMAND ----------

val circle1 = Circle(5.0)
circle1.area

// COMMAND ----------

// Regex 

// COMMAND ----------

import scala.util.matching.Regex
val numberPattern: Regex = "[0-9]".r

// COMMAND ----------

numberPattern.findFirstMatchIn("awesomepassword") match {
  case Some(_) => println("All good") 
  case None => println("Password must contain a number")
}

// COMMAND ----------

// Next: https://docs.scala-lang.org/tour/extractor-objects.html
