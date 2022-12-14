package finalPractical

trait MenuItem {
  val price: BigDecimal
  val name: String
  val temperature: String
  val itemType: String
}

object Orangina extends MenuItem {
  val price: BigDecimal = 1.50
  val name: String = "Cola"
  val temperature: String = "Cold"
  val itemType: String = "Drink"
}

object FishBroth extends MenuItem {
  val price: BigDecimal = 3.00
  val name: String = "Fish Broth"
  val temperature: String = "Hot"
  val itemType: String = "Drink"
}

object SalmonSushi extends MenuItem {
  val price: BigDecimal = 5.50
  val name: String = "Salmon Sushi"
  val temperature: String = "Cold"
  val itemType: String = "Food"
}

object TempuraPrawns extends MenuItem {
  val price: BigDecimal = 9.50
  val name: String = "Tempura Prawns"
  val temperature: String = "Hot"
  val itemType: String = "Food"
}

object Lobster extends MenuItem {
  val price: BigDecimal = 25.00
  val name: String = "Lobster"
  val temperature: String = "Hot"
  val itemType: String = "Luxury"
}

object Beer extends MenuItem {
  val price: BigDecimal = 4.0
  val name: String = "Beer"
  val temperature: String = "Cold"
  val itemType: String = "Alcohol"
}