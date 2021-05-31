
case class Point(first:Int, second: Int) {
  def foreach[To](action:Int => To): Unit = {
    action(first)
    action(second)
  }

}
val point = Point(1,2)
val shapes = List("triangle", "square")

for {
 shape <- shapes
  number <- point
} println(s"there is $number ${shape}(s)")


for (shape <- shapes) {
  println(shape)
}

for {
  shape <- shapes
} yield shape

for {
  shape <- shapes
} println( shape)