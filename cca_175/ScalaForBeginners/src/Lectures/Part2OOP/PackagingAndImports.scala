package Lectures.Part2OOP

import Playground.{Cinderella => Princess, PrinceCharming}

// packages with same name!
import java.util.Date
//import java.sql.Date

// aliasing
import java.sql.{Date => sqlDate}

// import all
//import Playground._

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package if not in the same package
  //val princess = new Cinderella
  val princess = new Princess

  // specify the whole route: fully qualified name
  //val princess = new Playground.Cinderella

  // packages are in hierarchy
  // matching folder structure

  // package object

  sayHello
  println(SPEED_OF_LIGHT)

  // imports

  val prince = new PrinceCharming

  // 1. use FQ name
  val date = new Date
  val sqlDate = new java.sql.Date(2018,5,4)

  // 2. aliasing
  val sqlDate2 = new sqlDate(2018,5,4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???s

}
