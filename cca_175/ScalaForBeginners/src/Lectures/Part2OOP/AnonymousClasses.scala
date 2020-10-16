package Lectures.Part2OOP

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahaha")
  }

  /*
  equivalent with:

  class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("ahahahahahahaha")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service")
  }

  // anonymous classes work for traits and classes (abstract or not)


  /*

  1. Create generic trait MyPredicate[-T] with method test(T) => Boolean :
  (contravariant in type T)

  2. Generic trait MyTransformer[-A,B] with method transform(A) => B : transform A into B
  (contravariant in type A)

  3. MyList:
  -map(transformer) => MyList
  -filter(predicate) => MyList
  -flatMap(transformer from A to MyList[B]) => MyList[B]

  class evenPredicate extends MyPredicate[Int]: Boolean (even or not)
  class StringToIntTransformer extends MyTransformer[String, Int]

  [1,2,3].map(n * 2)=[2,4,6]
  [1,2,3,4].filter(n % 2) =[2,4]
  [1,2,3].flatmap(n => [n, n+1]) => [1,2,2,3,3,4]

   */

}
