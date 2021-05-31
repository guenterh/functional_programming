package dataprocessing

object ForLoopExercises {

  def sum(numbers: List[Int]): Int = {
/*
    var total = 0
    for (number <- numbers)
      total += number
    total
*/

  foldLeft(numbers,0)((state,number) => state + number)

  }

  // a. Implement `size` using a mutable state and a for loop
  // such as size(List(2,5,1,8)) == 4
  // and     size(Nil) == 0
  def size[A](items: List[A]): Int = {
    /*
    var tempSize: Int = 0
    items.foreach(_ => tempSize += 1)
    tempSize
*/
    foldLeft(items,0)((state, item) => state + 1)

  }


  // b. Implement `min` using a mutable state and a for loop
  // such as min(List(2,5,1,8)) == Some(1)
  // and     min(Nil) == None
  // Note: Option is an enumeration with two values:
  // * Some when there is a value and
  // * None when there is no value (a bit like null)
  def min(numbers: List[Int]): Option[Int] = {
    var tempMin: Option[Int] = None

    /*
    //case analysis

    for (number <- numbers) if (tempMin.getOrElse(number) >= number) tempMin = Some(number)

    //Lösung im Kurs
    var tempMin1 = Option.empty[Int]

    for (number <- numbers ) {
      tempMin1 match {
        case None => tempMin1 = Some(number)
        case Some(currentMin) => tempMin1 = Some(currentMin min number)
      }
    }

    tempMin1


     */

    foldLeft(numbers, Option.empty[Int])((state, elem) => Some(state.getOrElse(elem) min elem))

  }

  // c. Implement `wordCount` using a mutable state and a for loop.
  // `wordCount` compute how many times each word appears in a `List`
  // such as wordCount(List("Hi", "Hello", "Hi")) == Map("Hi" -> 2, "Hello" -> 1)
  // and     wordCount(Nil) == Map.empty
  // Note: You can lookup an element in a `Map` with the method `get`
  // and you can upsert a value using `updated`
  def wordCount(words: List[String]): Map[String, Int] = {

    /*
    var counted = Map[String,Int]().empty

    for {
    word <- words
    } if (counted.contains(word)) counted.updated(word, counted(word) + 1) else counted.updated(word) = 1

    counted

     */
    //other possibility

    /*
    var frequencies = Map[String,Int]()
    for (word <- words) {
      //frequencies.get(word) match {
      //  case Some(frequency) => frequencies = frequencies.updated(word,frequency + 1)
      //  case None => frequencies =  frequencies.updated(word,1)
      //}
      //val frequency = frequencies.getOrElse(word,0)
      //frequencies = frequencies.updated(word,frequency + 1)

      //und noch eine weitere Möglichkeit
      frequencies = frequencies.updatedWith(word)(value => Some(value.getOrElse(0) + 1))

    }
    frequencies

    */

    foldLeft(words,Map.empty[String,Int])((status, elem) =>
    status.updatedWith(elem)(value => Some(value.getOrElse(0) + 1))
    )


  }



  // d. `sum`, `size`, `min` and `wordCount` are quite similar.
  // Could you write a higher-order function that captures this pattern?
  // How would you call it?
  def foldLeft[From, To](list:List[From], defaultValue: To)(combine: (To,From) => To): To = {

    var state: To = defaultValue
    for (elem <- list) {
      state = combine(state, elem)
    }
    state
  }

  // e. Refactor `sum`, `size`, `min` and `wordCount` using the higher-order
  // function you defined above.

  //////////////////////////////////////////////
  // Bonus question (not covered by the video)
  //////////////////////////////////////////////

  // f. `foldLeft` can be used to implement most of the List API.
  // Do you want to give it a try? For example, can you implement
  // `map`, `reverse` and `lastOption` in terms of `foldLeft`
  def map[From, To](elements: List[From])(update: From => To): List[To] =
    ???

  // reverse(List(3,8,1)) == List(1,8,3)
  // reverse(Nil) == Nil
  def reverse[A](elements: List[A]): List[A] =
    ???

  // lastOption(List(3,8,1)) == Some(1)
  // lastOption(Nil) == None
  def lastOption[A](elements: List[A]): Option[A] =
    ???

  // g. Can you generalise `min` so that it applies to more types like `Long`, `String`, ...?
  // Note: You may want to use the class Ordering from the standard library
  def generalMin[A](elements: List[A]): Option[A] =
    ???

}
