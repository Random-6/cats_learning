package Lectures.Part3FP

import scala.util.Random

object Sequences extends App{

  // Sequences : well defined order, can be indexed
  // operators: apply, iterator, length reverse
  // concatenation, appending, prepending
  // map, flatmap, filter, grouping, sorting, zipping, searching, slicing, etc


  // Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,5,6))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // Lists
  // immutable linear sequence
  // head, tail, isEmpty methods are fasts
  // most operation are O(n): length, reverse
  // 2 subtypes
  // object Nil (Empty)
  // class :: (Cons)

  // lists
  val aList = List(1,2,3)
  val prepended  = 42 +: aList :+ 89
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-")) //concatenate values with "-"

  // Arrays
  // equivalent of simple Java arrays
  // they're mutable
  // manually constructed with predefined lengths
  // interoperable with Java's T[] arrays
  // indexing is fast

  // array
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)  // default values
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // Vectors
  // effectively constant indexed read and write
  // default implementation for immutable sequences
  // fast element addition: append/prepend
  // implemented as a fixed-branced trie
  // good performance for large sizes

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      // operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns

  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // not efficient when updating elements in the middle
  println(getWriteTime(numbersList))
  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))




}
