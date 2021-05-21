def format[A] (value: A) = {

  //do someting with more sense
  def truncate (count: Int, value: Double) = value.toString

  value match {
    case v : String => v.toLowerCase
    case v: Double => (truncate(2,v))
    case _ => "N/A"
  }
}