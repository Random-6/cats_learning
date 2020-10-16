package Exercises

/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty? Boolean
  add(int) => list with this element added
  toString => a string representation of the list
 */


abstract class myListGeneric[+A] {
  def head: A
  def tail: myListGeneric[A] // rest of the list
  def isEmpty: Boolean
  def add[B >: A] (element: B): myListGeneric[B]

  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  // higher-order functions
  // receive functions as parameters/return functions as results
  def map[B](transformer: A => B): myListGeneric[B]
  def flatMap[B](transformer: A => myListGeneric[B]): myListGeneric[B]
  def filter(predicate: A => Boolean): myListGeneric[A]

  // concatenation
  def ++[B >: A](list: myListGeneric[B]): myListGeneric[B]

  //HOFS
  def foreach(f:A => Unit):Unit
  def sort(compare: (A,A) => Int): myListGeneric[A]
  def zipWith[B, C](list: myListGeneric[B], zip:(A, B) => C): myListGeneric[C]
  def fold[B](start: B)(operator: (B,A) => B): B

}

case object EmptyB extends myListGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: myListGeneric[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): myListGeneric[B] = new ConsB(element, EmptyB)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): myListGeneric[B] = EmptyB
  def flatMap[B](transformer: Nothing => myListGeneric[B]): myListGeneric[B] = EmptyB
  def filter(predicate: Nothing => Boolean): myListGeneric[Nothing] = EmptyB

  def ++[B >: Nothing](list: myListGeneric[B]): myListGeneric[B] = list

  def foreach(f:Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) = EmptyB
  def zipWith[B, C](list: myListGeneric[B], zip: (Nothing, B) => C): myListGeneric[C]=
    if( !list.isEmpty) throw new RuntimeException("List do not have the same length")
    else EmptyB
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start

}

case class ConsB[+A](h: A, t: myListGeneric[A]) extends myListGeneric[A] {
  def head: A = h

  def tail: myListGeneric[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): myListGeneric[B] = new ConsB(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: A => Boolean): myListGeneric[A] = {
    if (predicate.apply(h)) new ConsB(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: A => B): myListGeneric[B] =
    new ConsB(transformer.apply(h), t.map(transformer))


  def ++[B >: A](list: myListGeneric[B]): myListGeneric[B] = new ConsB(h, t ++ list)

  def flatMap[B](transformer: A => myListGeneric[B]): myListGeneric[B] =
    transformer.apply(h) ++ t.flatMap(transformer)

  // HOFS
  def foreach(f:A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): myListGeneric[A] = {
    def insert(x: A, sortedList: myListGeneric[A]): myListGeneric[A] =
      if (sortedList.isEmpty) new ConsB(x, EmptyB)
      else if (compare(x, sortedList.head) <= 0) new ConsB(x, sortedList)
      else new ConsB(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
  def zipWith[B, C](list: myListGeneric[B], zip: (A,B)=> C): myListGeneric[C]=
    if(list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new ConsB(zip(h, list.head), t.zipWith(list.tail,zip ))

  /*
  [1,2,3].fold(0)(+) =
  = [2,3].fold(1)(+) =
  = [3].fold(3)(+) =
  = [].fold(6)(+) =
  = 6
   */


  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

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

/*
  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}
*/

object listTest extends App {
  val listOfIntegers: myListGeneric[Int] = new ConsB(1, new ConsB(2, new ConsB(3, EmptyB)))
  val cloneListOfIntegers: myListGeneric[Int] = new ConsB(1, new ConsB(2, new ConsB(3, EmptyB)))
  val anotherListOfIntegers: myListGeneric[Int] = new ConsB(4, new ConsB(5, EmptyB))
  val listOfStrings: myListGeneric[String] = new ConsB("Hello", new ConsB("Scala", EmptyB))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  /*
  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }).toString)

   */

  println(listOfIntegers.map(elem => elem * 2).toString)

  /*
  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }).toString)

   */
  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

/*
  println(listOfIntegers.flatMap(new Function1[Int, myListGeneric[Int]] {
    override def apply(elem: Int): myListGeneric[Int] = new ConsB(elem, new ConsB(elem +1, EmptyB))
  }).toString)

 */

  println(listOfIntegers.flatMap(elem => new ConsB(elem, new ConsB(elem +1, EmptyB))).toString)

  // case object avoids you'd need to define a recursive
  // equals method (compare all elements recursive)
  println(cloneListOfIntegers == listOfIntegers)


  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x,y) => y-x))
  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _+ "-" + _))

  print(listOfIntegers.fold(0)(_+_))


  // for comprehensions

  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string

  println(combinations)
}

/*
The map function takes a transformer between your type and another type,
e.g. B, and returns a list of Bs.
For example, if you have a list [1,2,3] and you pass a transformer
whose method transform takes an int and returns that number in a string,
then your list becomes a list of strings: ["1", "2", "3"].
The map signature thus needs to be:

def map[B](transformer: MyTransformer[A, B]): MyList[B]


The flatMap function takes a transformer between your type and a LIST
of some other type, and returns a list of Bs, obtained by
concatenating all of the small lists together.
Example: same list [1,2,3], the transformer takes and int x and
returns a list [x, x+1]. At the end we would obtain [1,2, 2,3, 3,4],
obtained by concatenating the small lists [1,2], [2,3], [3,4] together.
The flatMap signature thus needs to be:

def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

The filter takes a predicate of your type and returns a list containing
just the elements for which that predicate's method returns true.

def filter(predicate: MyPredicate[A]): MyList[A]

 */