import optionals.{DogOptionals, NumberOptionals}

def dogInsurance(dog: DogOptionals): String = {
  dog.insuranceProvider match {
    case Some(_) => dog.insuranceProvider.getOrElse("OrElse")
    case None => s"${dog.name} has no insurance :("
  }
}

dogInsurance(DogOptionals(name = "Rover", insuranceProvider = Some("Pet Plan"), walksPerDay = Some(3)))
dogInsurance(DogOptionals(name = "Barney", insuranceProvider = None, walksPerDay = None))

///////////////////////////////

def optionalMultiplication(numberOptionals: NumberOptionals): Option[Int] = {
  numberOptionals.numberValue match {
    case Some(_) => Some(numberOptionals.numberValue.getOrElse(0) * 2)
    case None => None
  }
}

optionalMultiplication(NumberOptionals(name = "Seven", numberValue = Some(7)))
optionalMultiplication(NumberOptionals(name = "Not a number", numberValue = None))

