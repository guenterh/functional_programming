def map[A,B](list: List[A])(update: A => B):List[B] = list.map(update)

def map1[A](list: List[A])(update: A => A):List[A] = list.map(update)



case class User(name: String, age: Int)

val luser = List(User("günter", 61), User("manuela",60 ))

val lNumbers = List(1,2,3)

println(map(luser)(_.name))


println(map(lNumbers)(_+1))

def predicate[A](pred: A): Boolean = ???

case class Predicate[A](pred: A => Boolean) extends ((A) => Boolean) {
  override def apply(v1: A): Boolean = pred(v1)
}

val l = List(1,2,3)

val newList = l.filter(Predicate((i:Int) => i % 2 == 0))

println(newList)