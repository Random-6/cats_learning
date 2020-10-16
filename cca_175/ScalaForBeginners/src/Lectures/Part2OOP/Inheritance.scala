package Lectures.Part2OOP

object Inheritance extends App {

  // single class inheritance
  // superclass of Cat
  class Animal {
    val creatureType = "wild"
    //public, private and protectec

    def eat = println("nomnom")
    // final def eat = println("nomnom")
    // private def eat = println("nomnom")
    //protected def eat = println("nomnom")
  }

  //subclass of Animal
  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors:
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)


  // overriding
  class Dog (override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
      }
    }


  //class Dog(dogType: String) extends Animal {
  //  override val creatureType = dogType
  //}
  val dog = new Dog("K9")
  //dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  // uses Dog methods
  unknownAnimal.eat

  // overRIDING: supplying a different implementation in derived classes
  // vs
  // overLOADING: supplying multiple methods with different signatures but with the same name in the same class

  // super: refer fields or methods from parent class

  // preventing overrides
  // 1. final: use final on member
  // You can also put final on the entire class : no inheritance
  // 2. seal the class = extend classes in THIS FILE, prevent extension in other files
  // sealed class
  // prevent class to be extended in other files!


}
