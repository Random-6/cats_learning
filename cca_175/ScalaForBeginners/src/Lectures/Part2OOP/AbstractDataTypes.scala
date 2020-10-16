package Lectures.Part2OOP

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild" //non-abstract
    def eat: Unit // abstract traot
  }

  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "Fresh Meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    def eat(): Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")

  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 -  multiple traits may be inherited by the same class
  // 3 - traits = behavior, asbtract class = "thing



}
