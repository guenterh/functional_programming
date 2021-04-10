

class Spaceship {
  private def autodestroy(): Unit = println("Boom - das war's")
}

val shuttle = new Spaceship

val method = classOf[Spaceship].getDeclaredMethod("autodestroy")

method.setAccessible(true)

method.invoke(shuttle)