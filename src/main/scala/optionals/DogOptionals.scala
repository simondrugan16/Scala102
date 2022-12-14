package optionals

case class DogOptionals(name: String,
                        insuranceProvider: Option[String],
                        walksPerDay: Option[Int])
