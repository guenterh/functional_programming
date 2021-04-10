package generic

import generic.GenericFunctionExercises.{Pair, decoded, secret}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class GenericFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  ////////////////////
  // Exercise 1: Pair
  ////////////////////

  test("Pair swap") {
    assert(Pair(1,2).swap == Pair(2,1))
    assert(Pair("zero","one").swap == Pair("one","zero"))
  }

  test("Pair map") {
    assert(Pair(0,1).map(identity) == Pair(0,1))

  }

  test("Pair decoded") {


  }

  test("Pair zipWith") {
    assert(Pair(1,2).zipWith(Pair(3,4))((first,second) => first * second) == Pair(3,8))
  }

  test("Pair productNames") {}

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
