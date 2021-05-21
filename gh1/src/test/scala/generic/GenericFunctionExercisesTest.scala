package generic

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import generic.GenericFunctionExercises.{Pair, Predicate, Product, decoded, isEven, isPositive, products}


class GenericFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  ////////////////////
  // Exercise 1: Pair
  ////////////////////

  test("Pair swap") {

    assert(Pair("eins", 2).swap == Pair(2,"eins"))


  }

  test("Pair map") {

    assert(Pair("eins","zwei").map(identity) == Pair("eins","zwei"))


  }

  test("Pair decoded") {

    assert(decoded == Pair("Functional", "Programming"))

  }

  test("Pair zipWith") {

    assert(Pair(3,4).zipWith(Pair(3,4))((i:Int,o:Int) =>  i * o) == Pair(9,16))

  }

  test("Pair productNames") {

    assert(products == Pair(Product("Coffee",2.5), Product("Plane ticket",329.99)))

  }

  ////////////////////////////
  // Exercise 2: Predicate
  ////////////////////////////

  test("Predicate &&") {
    assert((isEven && isPositive) (12))
    assert(!(isEven && isPositive) (11))
    assert(!(isEven && isPositive)(-4))
    assert(!(isEven && isPositive)(-7))

    //zuletzt 4:35

  }


  test("Predicate && plus PBT") {

    forAll { (eval1: Int => Boolean, eval2: Int => Boolean, value: Int) =>

      val p1 = Predicate(eval1)
      val p2 = Predicate(eval2)

      def False[A] : Predicate[A] = Predicate(_ => false)
      def True[A]: Predicate[A] = Predicate(_ => true)

      assert((p1 && False)(value) == false)
      assert(!(p1 && False) (value))
      assert((p1 && True) (value) == p1(value))
    }
  }



  test("Predicate || plus PBT") {

    forAll { (eval1: Int => Boolean, value: Int) =>

      val p1 = Predicate(eval1)

      def False[A] : Predicate[A] = Predicate(_ => false)
      def True[A]: Predicate[A] = Predicate(_ => true)

      assert((p1 || False) (value) == p1(value))
      assert((p1 || True) (value) == true)
      assert((p1 || True) (value))
    }
  }

  //letzte Minuten 10:00 (mit Test - dann einfach nur weitergehört)


  test("Predicate ||") {}

  test("Predicate flip") {}

  ////////////////////////////
  // Exercise 3: JsonDecoder
  ////////////////////////////

  test("JsonDecoder UserId") {}

  test("JsonDecoder LocalDate") {}

  test("JsonDecoder weirdLocalDateDecoder") {}

}
