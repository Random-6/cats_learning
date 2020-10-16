package Lectures.Part2OOP

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    //def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    // Exercises
    //1.
    def +(nickname: String): Person = new Person(s"$name the $nickname",favoriteMovie)
    //2.
    def unary_+ : Person = new Person(name,favoriteMovie,age.+(1))
    //3.
    def learns(topic: String) = s"${this.name} learns ${topic}"
    def learnsScala: String = learns("Scala")

  }


  val mary= new Person("Mary","Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar): methods with only one parameter
  println(mary.+("rockstar").name)
  println(mary.unary_+.age)

  // "operators" in Scala

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary.hangOutWith(tom))
  println(mary.+("rockstar").hangOutWith(tom))
  println(mary learnsScala)

  println(1 + 2)
  print(1.+(2))

  // ALL OPERATORS ARE METHODS!

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y=1.unary_- // same as above
  // unary_prefix only works with few operators (+ - ~ !)

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply(2))
  println(mary(2)) //equivalent --> the compiler delegates to the apply method



  /*
  1. Overload the + operator (String) -
  mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the person classe with default 0 value
  Add unary + operator => new person with the age + 1
  +mary => mary with age incrementer
  java ++

  3. Add a "learns" method in the Person class => "Mary learns Scala"
  Add a learnsScala method, calls learns method with "Scala".
  Use it in postfix notation

  4. Overload the apply method to receive method and return string
  mary.apply(2) => "Mary watched Inception 2 times"

   */

}
