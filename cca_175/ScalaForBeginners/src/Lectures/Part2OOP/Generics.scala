package Lectures.Part2OOP

object Generics extends App{

  // type A: generic type
  // Generic class
  class MyList[+A] {
    // use the type A inside class definition
    def add[B >: A] (element: B): MyList[B] = ???
    /*
    A= Cat
    B= Dog = Animal
    myList[Cats] --> myList[Animals]
     */

  }

  // traits can also be type-parameterized

  // 2 generic types
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]


  // generic methods
  // objects cannot be type-parameterized
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  // Cats are animals!
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ?? HARD QUESTION
  // We return a list of Animals

  // 2. no: List[Cat] and list[Animals] are different things = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  //class ContravariantList[-A]
  //val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  class Trainer[-A]
  // better because it's more generic (trainer of animals is more generic than trainer of cats)
  val trainer: Trainer[Cat] = new Trainer[Animal]


  // bounded types
  // use generic causes for certain types (super/sub class of certain types)
  // class Cage only accept subclasses of Animal (upper-bounded type)
  class Cage[A <: Animal](animal:A)
  val cage = new Cage(new Dog)

  // class Car is not a subclass of Animal
  //class Car
  //val newCage = new Cage(new Car)

  // class Cage only accept superclasses of Animal (lower-bounded type)
  //class Cage[A >: Animal](animal:A)
  //val cage = new Cage(new Dog)


  // expand MyList to be generic

}
