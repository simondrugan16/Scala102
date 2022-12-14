import caseClasses.Bird
import patternMatching.{Animal, Caramel, CatPractical, Chocolate, Cookie, DogPractical, Flavour, Pizza}
////////////////
// Practicals //
////////////////


val chocolate: Flavour = Chocolate
val cookie: Flavour = Cookie
val caramel: Flavour = Caramel
val flavours: List[Flavour] = List(chocolate, cookie, caramel)

for ( flavour <- flavours ) yield {
  flavour match {
    case Chocolate => "patternMatching.Chocolate Fudge Brownie"
    case Caramel => "patternMatching.Caramel Chew Chew"
    case Cookie => "patternMatching.Cookie Dough"
    case _ => flavour
  }
}

val pizzaOne = Pizza(size = "Personal")
val pizzaTwo = Pizza(size = "Small")
val pizzaThree = Pizza(crust = "Stuffed")
val pizzaFour = Pizza(size = "Large", crust = "Stuffed")
val pizzas: List[Pizza] = List(pizzaOne, pizzaTwo, pizzaThree, pizzaFour)

for ( pizza <- pizzas) yield {
  pizza match {
    case Pizza("Personal", "Stuffed") => "Cost is £8.98"
    case Pizza("Personal", _) => "Cost is £5.99"
    case Pizza("Small", "Stuffed") => "Cost is £13.98"
    case Pizza("Small", _) => "Cost is £10.99"
    case Pizza("Medium", "Stuffed") => "Cost is £15.98"
    case Pizza("Medium", _) => "Cost is £12.99"
    case Pizza("Large", "Stuffed") => "Cost is £17.98"
    case Pizza("Large", _) => "Cost is £14.99"
  }
}

//////////////////////////////////

def capitaliseTheCapital(city: String): String = {
  city match {
    case _ if city == "london" || city == "belfast" || city == "cardiff" || city == "edinburgh" => {
      city.capitalize
    }
    case _ => s"${city} is not a capital city"
  }
}

capitaliseTheCapital("london")
capitaliseTheCapital("bristol")

//////////////////////////////////

def checkMyAnimal(animal: Animal): String = {
  animal match {
    case DogPractical(name, age) => "Doggo"
    case CatPractical(name, age) => "Kitty"
    case _ => "Wat animal is THIS??"
  }
}

checkMyAnimal(DogPractical(name = "Bonnie", age = 9))
checkMyAnimal(CatPractical(name = "Bonnie", age = 9))
checkMyAnimal(Bird(name = "MARGARET", age = 90, peckSpeed = 10, taste = "Bony"))


//////////////////////////////////


def isItSam(animal: Animal): String = {
  animal.name match {
    case "Sam" => s"Sam's age is ${animal.age} years old"
    case _ => s"${animal.name} is not Sam..."
  }
}

isItSam(DogPractical(name = "Jimmy McGill", age = 33))
isItSam(CatPractical(name = "Sam", age = 23))

//////////////////////////////////

def animalAges(animal: Animal): String = {
  animal.age match {
    case _ if animal.age > 10 => s"${animal.name} is ${animal.age} years old"
    case _ => s"${animal.name} is young"
  }
}
animalAges(CatPractical(name = "Sam", age = 23))
animalAges(DogPractical(name = "Jamiroquai", age = 5))
