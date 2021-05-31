package generic.round2

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import generic.round2.GenericFunctionExercises._
import org.scalacheck.{Arbitrary, Gen}

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.util.Try


class GenericFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  ////////////////////
  // Exercise 1: Pair
  ////////////////////

  test("Pair swap") {
    forAll {
      (x: Int, y: Int) => {
      assert(Pair(x, y).swap == Pair(y, x))
    }
    }
  }

  test("Pair map") {
    forAll {
      (s1: String, s2:String) =>
      assert(Pair(s1,s2).map(_.length) == Pair(s1.length,s2.length))
        assert(Pair(s1,s2).map(identity) == Pair(s1,s2))
    }
  }

  test("Pair decoded") {

    assert(decoded == Pair("Functional","Programming"))

  }

  test("Pair zipWith") {

    forAll {
      (p1: Int, p2: Int, p3: String, p4: String) =>

      assert(Pair(p1,p2).zipWith(Pair(p3,p4))( _.toString + _) == Pair(p1.toString + p3,p2.toString + p4))
      println(Pair(p1,p2).zipWith(Pair(p3,p4))(List(_,_)))

    }

  }

  test("Pair productNames") {}

  ////////////////////////////
  // Exercise 2: Predicate
  ////////////////////////////

  test ("mein eigener Test für das Verständnis von Predicate") {
    val p = Predicate((s:String) => false)
    val ergebnis = p("richtig")
    println(ergebnis)
  }
  test("mein flip") {
    val p = Predicate[Int](_ > 0)
    assert(p.flip(-10))
    assert(p(10))
  }


  test("Predicate &&") {

    assert((isEven && isPositive)(12))
    assert(! (isEven && isPositive)(11))
    assert(! (isEven.&&(isPositive))(11))
    assert(!(isEven && isPositive)(-4))
    assert(!(isEven && isPositive)(-7))

  }

  test ("Predicate && plus PBT") {
    forAll {
      (eval1: Int => Boolean, eval2: Int => Boolean, value: Int) =>
      val p1 = Predicate(eval1)
      val p2 = Predicate(eval2)

      def False[A]: Predicate[A] = Predicate(_ => false)
      def True[A]: Predicate[A] = Predicate(_ => true)

      assert(!(p1 && False)(value))
      assert((p2 && True)(value) == p2(value))
    }
  }

  test ("Predicate || plus PBT") {
    forAll {
      (eval1: Int => Boolean,  value: Int) =>
        val p1 = Predicate(eval1)

        def False[A]: Predicate[A] = Predicate(_ => false)
        def True[A]: Predicate[A] = Predicate(_ => true)

        assert((p1 || False)(value) == p1(value))
        assert((p1 || True)(value))
    }


  }


  test("Predicate ||") {}

  test("Predicate flip") {

    assert(!isPositive.flip(5))
    assert(isPositive.flip(-5))

    //hier nehme ich Unit
    val test: Predicate[Int] = Predicate.True
    //wen ich nichts angebe wird Nothing genommen
    val test1: Predicate[Nothing] = Predicate.True

    assert(!Predicate.True.flip(()))
    assert(Predicate.False.flip(()))


  }

  test("is Valid User") {
    assert(isValidUser(User("Hipler", 19)))
    assert(!isValidUser(User("hipler",19)))
    assert(!isValidUser(User("Hi",19)))
    assert(!isValidUser(User("Hipler",17)))

  }


  ////////////////////////////
  // Exercise 3: JsonDecoder
  ////////////////////////////

  test("JsonDecoder UserId") {

    assert(Try(userIdDecoder.decode("hello world")).isFailure)

    forAll { (i: Int) => {
      val userId = userIdDecoder.decode(i.toString)
      assert(userId.value == i)

    }

    }
  }

  val genLocalDate:Gen[LocalDate] =
    Gen
      .choose(LocalDate.MIN.toEpochDay, LocalDate.MAX.toEpochDay)
      .map(LocalDate.ofEpochDay)
  implicit val local_Date :Arbitrary[LocalDate] =
    Arbitrary(genLocalDate)


  test("JsonDecoder LocalDate with PBT") {

    forAll{(localDate: LocalDate) =>

    val json = "\"" + DateTimeFormatter.ISO_LOCAL_DATE.format(localDate) + "\""
      assert (localDateDecoder.decode(json) == localDate)

    }


  }



  test("JsonDecoder weirdLocalDateDecoder") {}

}
