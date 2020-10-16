package Exercises


/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty? Boolean
  add(int) => list with this element added
  toString => a string representation of the list
 */


abstract class myList {
  def head: Int
  def tail: myList // rest of the list
  def isEmpty: Boolean
  def add(element: Int): myList

  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends myList {
  def head: Int = throw new NoSuchElementException
  def tail: myList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): myList = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: myList) extends myList{
  def head: Int = h
  def tail: myList = t
  def isEmpty: Boolean = false
  def add(element: Int): myList = new Cons(element, this)

  override def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
}

object lisTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3,Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)
}