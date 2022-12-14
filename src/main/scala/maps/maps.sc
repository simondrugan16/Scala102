Map("myKey" -> "myValue").map{ case (key, value) =>
  s"key: $key, value: $value"
}

Map("myKey" -> "myValue").map{ case (key, value) =>
  value -> key
}

List(1,2,3).map(x => List(x*2, x*4, x*6)).flatten

List(1,2,3).flatMap(x => List(x*2, x*4, x*6))

List(1,2,3).flatMap{
  case x@(1|3) => Some(x*2)
  case _ => None
}

Some(3).map(number => number * 3)

Some(3).map {
  case 1 => 10
  case x => x * 2
}

Option.empty[Int].map(number => number * 3)

Some(3).flatMap(x => if(x == 3) Some(9) else None)

Some(2).flatMap(x => if(x == 3) Some(9) else None)

Option.empty[Int].flatMap(x => if(x == 3) Some(9) else None)

Right[String, Int](3).map(number => number * 3)

Right[String, Int](1).map {
  case 1 => 10
  case x => x * 2
}

Left[String, Int]("Hi").map(number => number * 3)


////////////////
// Practicals //
////////////////

val variableIsTheBest: String => String = (variable) => {
  variable.map(x => x.toUpper) + " ARE THE BEST"
}

variableIsTheBest("macbooks")

val changeStringsToInts: List[String] => Int = myList => {
  myList.map(element => element.toInt * 2).sum
}

changeStringsToInts(List("1", "2", "3"))


////////////////////////////////////////////////

val optionalIntMultiplier: Option[Int] => Int = {
  case optionalInt@Some(_) => optionalInt.getOrElse(0) * 12
  case None => 12
}

optionalIntMultiplier(None)
optionalIntMultiplier(Some(12))

val scores = Seq(None, Some("A"), Some("B"), Some("C"), None, Some("F"))

//scores.filter{
//  _.nonEmpty
//}

scores.map{
  case element@Some(_) => element.getOrElse("SOMETHING WRONG")
  case None => "F"
}


