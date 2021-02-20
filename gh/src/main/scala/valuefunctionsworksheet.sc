
def increment(number:Int) = number + 1

val incr = increment _

val functionNoLiteral = (n: Int, text: String) => List.fill(n)(text).mkString(" ")

val filled = functionNoLiteral(20,"hello")

trait Printer {
  def apply(message: String): Unit
}

val p: Printer = (m) => println(m)

val test: Int => Double = (n) => n + 0.1


p.apply("hello world")

test(1)