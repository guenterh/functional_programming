def filter (text: String, cFilter:Char => Boolean) = text.map(cFilter)

val filteredString = filter("This Is My Long Text", _.isLetter)

import scala.io.Source

def usingFile(filename: String, processing: Iterator[String] => Int) = {
  val handle = Source.fromResource(filename)
  processing(handle.getLines())
  handle.close()
}

usingFile("gh.txt", (i: Iterator[String]) => {
  i.foreach(println)
  i.length
})
