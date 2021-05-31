package dataprocessing

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import ForLoopExercises._

class ForLoopExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  test("sum") {
    assert(sum(List(1, 5, 2)) == 8)
    assert(sum(Nil) == 0)

    forAll((list:List[Int]) => sum(list) == list.sum

    )


  }

  test("sum is consistent with List sum") {
    forAll { (numbers: List[Int]) =>
      assert(sum(numbers) == numbers.sum)
    }
  }

  test("size") {
    assert(size(List(2, 5, 1, 8)) == 4)
    assert(size(Nil) == 0)

    forAll{(list1: List[Int], list2: List[Int]) =>

      assert(size(list1 ++ list2) == size(list1) + size(list2))

    }

  }

  test("min") {

    assert(min(List(2, 5, 1, 8)) == Some(1))
    assert(min(Nil) == None)
  }


  test("min with property based testing") {

    forAll { (list: List[Int]) => {
      min(list) match {
        case Some(value) => list.foreach(value <= _)
        case None => assert(list.isEmpty)
      }
    }
    }

    //Varinate
    forAll {
      (list:List[Int]) =>
      for {
        minNumber <- min(list)
        number <- list
      } assert(minNumber <= number)
    }


  }

  test ("returned min value belongs to the original list") {
    forAll{
      (list: List[Int]) =>
      min(list).foreach(elem => assert(list.contains(elem)))

    }
  }

  test ("pattern min") {

    forAll{


      (list: List[Int]) => {

        //val t = if (list.isEmpty) Option.empty[Int] else Some(list.min(Ordering.Int))

        assert(foldLeft(list, Option.empty[Int])((state, to) => {

          Some(state.getOrElse(to) min to)
        }) == (if (list.isEmpty) Option.empty[Int] else Some(list.min(Ordering.Int))))
      }
    }
  }



  test("wordCount") {
    assert(wordCount(List("Hi", "Hello", "Hi")) == Map("Hi" -> 2, "Hello" -> 1))
    assert(wordCount(Nil) == Map.empty)
  }

  test("wordCount with foldLeft") {
    assert(foldLeft(List("Hi", "Hello", "Hi"),Map[String,Int]())((aggregatedMap,term) => {

      aggregatedMap.updatedWith(term)(value => Some(value.getOrElse(0) + 1))

    }) == Map("Hi" -> 2, "Hello" -> 1))




  assert(foldLeft(List[String](),Map[String,Int]())((aggregatedMap,term) => {

    aggregatedMap.updatedWith(term)(value => Some(value.getOrElse(0) + 1))

  }) == Map[String,Int]())


}



  test("wordCount returns always strictly positive Int values") {

    forAll {
      (list:List[String]) =>

      assert(wordCount(list).values.forall(_ > 0))

    }

  }

  test("every key in resulting map is part of input list") {

    forAll {
      (list:List[String]) =>

        assert(wordCount(list).keys.forall(list.contains(_)))

    }

  }



}
