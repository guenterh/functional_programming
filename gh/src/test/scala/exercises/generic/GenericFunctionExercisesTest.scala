package exercises.generic

import exercises.generic.GenericFunctionExercises.{Pair, decoded, products, secret}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks


class GenericFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  ////////////////////
  // Exercise 1: Pair
  ////////////////////

  test("Pair swap") {
    assert(Pair(0,1).swap == Pair(1,0))
    assert(Pair("John", "Doe").swap == Pair("Doe", "John"))
  }

  test("Pair map") {
    assert(Pair("Günter", "Hipler").map(_.length) == Pair(6,6))
    assert(Pair("Günter", "Hipler").map(identity) == Pair("Günter", "Hipler"))
  }

  test("Pair decoded") {

    assert(secret.map(bytes => new String(bytes.toArray))
      .map(_.reverse)
      .swap ==  Pair("Functional", "Programming"))

  }

  test("Pair zipWith") {

    assert((Pair(1,2).zipWith(Pair(3,4))((f,s) =>  f * 2 + s)) == Pair(5,8))
    assert(Pair(0, 2).zipWith(Pair(3, 4))((x, y) => x + y) == Pair(3, 6))

  }

  test("Pair productNames") {
    println(products)
  }

  ////////////////////////////
  // Exercise 2: Predicate
  ////////////////////////////

  test("Predicate &&") {}

  test("Predicate ||") {}

  test("Predicate flip") {}

  ////////////////////////////
  // Exercise 3: JsonDecoder
  ////////////////////////////

  test("JsonDecoder UserId") {}

  test("JsonDecoder LocalDate") {}

  test("JsonDecoder weirdLocalDateDecoder") {}

}
