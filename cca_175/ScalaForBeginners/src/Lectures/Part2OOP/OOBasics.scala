package Lectures.Part2OOP

object OOBasics extends App{

  val person = new Person("John",26)
  println(person.age)
  person.greet("Daniel")
  person.greet()


  val writer = new Writer("Francesc","Seres",1960)
  println(writer.fullname())
  val novel = new Novel("Contes rusos",2016, writer)

  println(novel.authorAge)

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}
//age is a class parameter but not member fields
// class parameters vs class fields
// constructor: every single instance of Person must be constructed with name and age
class Person(name:String, val age:Int){
  // body: defines implementation of the class
  // var & val definitions are fields (person.x)
  val x = 2
  // evaluate expressions
  print(1 + 3)


  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am ${this.name}")

  // multiple constructors: default parameters can solved this as well
  def this(name: String) = this(name,0)
  def this()= this("John Doe")

}


/*
Novel and a Writter
Writer: first name, surname, year
- method fullname : concatenation of first name and surname

Novel: name, year of release, author (instance of type writter)
- authorAge (year of author at year of release)
- isWrittenBy(author)
- copy (new year of release) = new instance of Novel

 */


class Writer (name:String, surname:String, val year:Int){

  def fullname(): String = name + " " + surname

}

class Novel(title: String, val yearRelease: Int, author: Writer){
 // val author = new Writer(name, surname,2020)
  def authorAge= yearRelease - author.year
  def isWritenBy(author:Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(title,newYear, author)

}

/*
Counter class
- receives an int value
- method current count --> don't need a method, you can specify with val
- method to increment/decrement => new Counter
- overload inc/dec to receive an amount

 */

class Counter(val count: Int = 0) {
/*
  FIRST VERSION!
  def inc = new Counter(count + 1) // immutability: instances are fix--> CANNOT BE MODIFIED INSIDE A CLASS!!
  def dec = new Counter(count - 1)
  // same method name but different input

  def inc(n: Int) = new Counter(count + n)
  def dec(n: Int) = new Counter(count - n)

*/

  def inc = {
    println("incrementing")
    new Counter(count + 1)
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this // returns this same instance
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this // returns this same instance
    else dec.dec(n-1)
  }

  def print = println(count)
}
