package Lectures.Part2OOP

object Objects extends App{

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // Objects have static-like functionality

  // Objects DO NOT receive parameters
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method: build persons giving some parameters
    //def from(mother: Person, father: Person): Person = new Person("Bobbie")
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")


  }

  class Person(val name: String) {
    // instance-level functionality

  }

  // COMPANIONS: same scope and same name
  // whole code can reside in a class or an object

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects = SINGLETON INSTANCE
  val mary = new Person("Mary") // instance of Person type
  val john = new Person("John")
  println(mary == john) // different instances

  // singleton: single instance that can be referred to with the namePerson
  val person1= Person
  val person2 = Person
  println(person1 == person2)

  //val bobbie = Person.from(mary, john)
  //val bobbie = Person.apply(mary, john)
  // apply method
  val bobbie = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit


}
