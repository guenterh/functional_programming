
val valfunc = (n: Int, text:String) => List.fill(n)(text).mkString(" ")
val replicate = valfunc

//println(valfunc(10, "hello"))

def updateString(text: String, update: Char => Char) = text.map(update)


updateString("my Weird StrinG", _.toUpper)