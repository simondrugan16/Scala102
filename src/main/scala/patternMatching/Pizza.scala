package patternMatching

sealed trait Size

case class Pizza(size: String = "Medium",
                 crust: String = "")
