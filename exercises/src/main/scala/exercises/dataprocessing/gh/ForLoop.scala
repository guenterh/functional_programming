package exercises.dataprocessing.gh

object ForLoop {

  val numbers = List(1,3,4,5,6)

  for {number <- numbers}
    println(s"number $number")


  def doSomething(i:Int) = println(i * 3)

  numbers.foreach(i => doSomething(i))

  //nested for loops
  val shapes = List("triangle", "square")
  val colours = List("red", "green", "blue")

  for {
    shape <-shapes
    color <- colours
  } println(s"$shape is $color")

//same as
  shapes.foreach( shape => colours.foreach( color =>
  println(s"$shape is color $color")))


  def main(args: Array[String]): Unit = {

  }

}
