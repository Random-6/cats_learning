package Lectures.Part2OOP

object CaseClasses extends App{

/*
equals, hasCode, toString : Case Classes: short hand
 */

  case class Person(name: String, age:Int)

  // 1. class parameters are fields
  val jim= new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim) // println(instance)=println(instance.toString)
  println(jim.toString)

  // 3. equals and hashCode implemented OOTB (out of the box)
  val jim2 = new Person("Jim",34)
  // true, with class would be false
  println(jim ==jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age=45) // new instance with different age value
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  // apply method makes a companion object callable like a function
  val mary = Person("Mary",23)  // we don't use keyword new

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand MyList - use case classes and case objects
   */
}
