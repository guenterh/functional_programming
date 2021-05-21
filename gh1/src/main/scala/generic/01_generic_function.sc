
case class User(name: String, age: Int)

def map[A](list: List[A], update: A=>A) : List[A] = {
  list.map(update(_))
}


def bettermap[A,B](list: List[A])(update: A=>B) : List[B] = {
  list.map(update(_))
}



map[User](List(User("günter", 60), User("manuela", 60)), (u:User) =>

  User("bla", 12)
)

bettermap(List(User("günter", 60), User("manuela", 60)))(_.name)



