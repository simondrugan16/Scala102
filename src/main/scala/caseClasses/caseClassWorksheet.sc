import caseClasses.{Bird, Cat, Dog, Kennel}

val dogOne = Dog(name = "Bonnie", breed = "Miniature Cockapoo", age = 9)
val dogTwo = Dog(name = "Molly", breed = "Yorkie", age = 12)
val dogThree = Dog(name = "Digby", breed = "Dawg", age = 23)
val dogFour = Dog(name = "Buster", breed = "Kjee", age = 25)

val catOne = Cat(name = "Daryl", scratchiness = 9, catculation = 4)

val birdOne = Bird(name = "Maggie", age = 99, peckSpeed = 3, taste = "Slightly metallic")

val reallyNiceKennel: Kennel = Kennel(name = "Woofy Hole", Dogs = List(dogOne, dogTwo, dogThree, dogFour), Cats = List(catOne), Birds = List(birdOne))
