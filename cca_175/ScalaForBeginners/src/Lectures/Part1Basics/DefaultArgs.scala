package Lectures.Part1Basics

object DefaultArgs extends App{

// acc by default 1
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n >= 1) acc
    else trFact(n-1, n*acc)
  }

  // always starts with 1 as default
  val fact10 = trFact(10)

  def savePicture(format: String= "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")

  // default params need to be specified
  savePicture("jpg", 800, 600)
  savePicture()
  // the compiler is confused
  //savePicture(800)
  savePicture(width = 800)

  /*
  SOLUTIONS:
  1. Pass in every leading argument
  2. Name the arguments

  */
  // inputs can be specified in another order
  savePicture(height = 600, width = 800, format = "bmp")

}
