object O {

  import scala.io.Source

  def usingFile(filename: String, processing: Iterator[String] => Int) = {
    val handle = Source.fromResource(filename)
    processing(handle.getLines())
    handle.close()
  }


  def main(args: Array[String]): Unit = {
    usingFile("gh.txt", (i: Iterator[String]) => {
      i.foreach(println)
      i.length
    })

  }

}
