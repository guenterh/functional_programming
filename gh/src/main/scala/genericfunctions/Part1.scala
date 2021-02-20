package genericfunctions

object Part1 {

  case class User(name: String, age: Int)

  def map[A](list: List[A], update: A => A): List[A] =
    list.map(update)

  def bettermap[A](list: List[A]) (update: A => A): List[A] =
    list.map(update)


  def main(args: Array[String]): Unit = {

    val users = List(User("Günter", 61), User("Manuela", 61))

    println(map(users, (elem:User) => elem.copy(age = elem.age + 1)))
    println(bettermap(users) (elem => elem.copy(age = elem.age + 5)))


  }

}
