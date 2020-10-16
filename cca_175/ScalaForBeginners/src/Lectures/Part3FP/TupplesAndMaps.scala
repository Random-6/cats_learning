package Lectures.Part3FP

object TupplesAndMaps extends App{

  // tuples = finite ordered "lists"

  val aTuple = new Tuple2(2, "hello, Scala") // Tuple2[Int, String]= (Int, String)

  //val aTuple =(2, "hello, Scala") // Tuple2[Int, String]= (Int, String)

  // at most 22 elements of different types

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, scala", 2)

  // Maps - keys --> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is sugar for (a,b)
  println(phoneBook)

  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary")) // not exist

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  val newPairing2 = "JIM" -> 999
  val newPhoneBook2 = phoneBook + newPairing2
  println(newPhoneBook2)

  // functionals on maps
  // map, flatMap, filter

  //println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  println(newPhoneBook2.map(pair => pair._1.toLowerCase -> pair._2))

  // filterkeys
  println(phoneBook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phoneBook.mapValues(number => number * 10))
  println(phoneBook.mapValues(number => "0245-" + number))

  // conversion to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  // group names by first letter in the same list
  println(names.groupBy(name => name.charAt(0)))


  /*
  1. What would happen if in the lowerCase map we had two original entries "Jim" -> 555 and "JIM" -> 900
  2. Overly simplified social network based on maps
    Person = String
    association between each name and list of friends
    - add a person to the network
    - remove
    - friend (mutual)
    - unfriend (mutual)

    - number of friends of a person
    - person with most friends
    - How many people have NO friends
    - if there is a social connection between two people (direct or not)

   */


  val socialNetwork = Map(("Jim", "Daniel"), "Daniel" -> "Jim", ("Maria", "Tom" ), ("Tom",()),("Maria",("Jim", "Daniel","Tom"))).withDefaultValue(-1)
  println(socialNetwork)

  // add
  val newLink = "Bob" -> ("Jim","Daniel","Maria")
  val newSocialNetwork = socialNetwork + newLink
  println(newSocialNetwork)

  // remove
  val socialNetworkRemoved = socialNetwork.filterKeys(x => x != "Jim")
  println(socialNetworkRemoved)

}
