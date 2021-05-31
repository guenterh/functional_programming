package valuefunctions

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import valuefunctions.ValueFunctionExercises.{isValidUsername, isValidUsernameCharacter, secret, selectDigits}

class ValueFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  /////////////////////////////////////////////////////
  // Exercise 1: String API with higher-order functions
  /////////////////////////////////////////////////////

  // replace `ignore` by `test` to enable the test
  test("selectDigits examples") {
    assert(selectDigits("hello4world-80") == "480")
    assert(selectDigits("welcome") == "")
  }

  // replace `ignore` by `test` to enable the test
  test("selectDigits length is smaller") {
    forAll { (text: String) =>
      assert(selectDigits(text).length <= text.length)
    }
  }

  test ("my own property based testing use case ") {
    forAll{(text: String
           ) =>

      val d = selectDigits(text)
      assert(d.length <= text.length)

    }
  }

  test("make test n secret") {
    forAll({
      text: String =>
      assert(secret(text) == List.fill(text.length)("*").mkString )

      //idempotation
      val first = secret(text)
      val second = secret(secret(text))
      assert(first == second)

    })
  }

  test ("has only valid user name characters") {
    val validName = "jkkaPk9972-_"
    assert(validName.forall(isValidUsernameCharacter))
    val notvalidName = "jkka#Pk9972-_"
    assert(!notvalidName.forall(isValidUsernameCharacter))

  }

  test ("test nor the complete username") {
    assert(isValidUsername("kJhahsk99776Kkk_jj-ll"))

    assert(!isValidUsername("kJhahsk9?776Kkk_jj-ll"))

  }

  test ("is poitive point") {

    import ValueFunctionExercises.Point
    forAll {
      (x: Int, y: Int, z: Int) =>
        //assert(Point(x.abs, y.abs, z.abs).isPositive)
        assert(Point(x.max(0), y.max(0), z.max(0)).isPositive)


    }
  }

  test ("my is even test for all") {
    import ValueFunctionExercises.Point
    forAll {
      (x: Int, y: Int, z: Int, predicate: Int => Boolean) =>
      assert(Point(x,y,z).forAll(predicate) == List(x,y,z).forall(predicate))
    }

  }


  ///////////////////////
  // Exercise 2: Point
  ///////////////////////

}
