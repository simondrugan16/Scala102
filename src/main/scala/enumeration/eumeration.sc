import enumeration.AnimalsEnum.DogEnum
import enumeration.AnimalsEnum.Serpent
import enumeration.CanFlyEnum.{NoEnum, Yes}
import enumeration.{AnimalEnum, AnimalSealed, EvolutionaryPeriod, Exobody, Feathers, No, OstrichSealed, Pleistocene, Pliocene, Scales, SerpentSealed, YesSealed}

object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

Weekday.Monday.toString

Weekday.Monday

Weekday.withName("Monday")

//Weekday.withName("Mondai")

object WeekdayShort extends Enumeration {

  val Monday = Value("Mon")
  val Tuesday = Value("Tue")
  val Wednesday = Value("Wed")
  val Thursday = Value("Thur")
  val Friday = Value("Fri")
  val Saturday = Value("Sat")
  val Sunday = Value("Sun")
}

WeekdayShort.Monday.toString

WeekdayShort.Monday

WeekdayShort.values

WeekdayShort.Monday < WeekdayShort.Tuesday

WeekdayShort.Sunday > WeekdayShort.Monday

WeekdayShort.Monday == WeekdayShort.Monday

WeekdayShort.Saturday > WeekdayShort.Sunday

object WeekdayNumbers extends Enumeration {
  val Monday = Value(6)
  val Tuesday = Value(5)
  val Wednesday = Value(4)
  val Thursday = Value(3)
  val Friday = Value(2)
  val Saturday = Value(1)
  val Sunday = Value(0)
}

WeekdayNumbers.values.toList.sorted

def nonExhaustive(weekday: WeekdayShort.Value) {
  weekday match {
    case WeekdayShort.Monday => println("I hate Mondays")
    case WeekdayShort.Sunday => println("The weekend is already over? :( ")
  }
}

object OtherEnum extends Enumeration {
  val A, B, C = Value
}

def test(enum: Weekday.Value) = {
  println(s"enum: $enum")
}

def test(enum: OtherEnum.Value) = {
  println(s"enum: $enum")
}

sealed trait WeekdaySealed

case object Monday extends WeekdaySealed
case object Tuesday extends WeekdaySealed
case object Wednesday extends WeekdaySealed
case object Thursday extends WeekdaySealed
case object Friday extends WeekdaySealed
case object Saturday extends WeekdaySealed
case object Sunday extends WeekdaySealed

def test(weekday: WeekdaySealed) = {
  weekday match {
    case Monday => println("I hate Mondays")
    case Sunday => println("The weekend is already over? :( ")
  }
}

abstract class error(val status: String, val message: String)

case object InternalServer extends error("SERVER_ERROR", "An internal server error occurred")
case object NotFound extends error("NOT_FOUND", "Matching resource was not found")

abstract class Error(val status: String, val message: String, val order: Int) {
  def compare(that: Error) = this.order - that.order
}

case object InternalServer extends Error("SERVER_ERROR", "An internal server error occurred", 0)
case object NotFound extends Error("NOT_FOUND", "Matching resource was not found", 1)

NotFound.compare(InternalServer)

////////////////
// Practicals //
////////////////

object FootballCountryShortens extends Enumeration {
  val England = Value("ENG")
  val France = Value("FRA")
  val Argentina = Value("ARG")
  val Morocco = Value("MAR")
}

for ( i <- FootballCountryShortens.values) println(i)

sealed trait FootballCountryShortensSealed{val shortened: String}

case object England extends FootballCountryShortensSealed{override val shortened: String = "ENG"}
case object France extends FootballCountryShortensSealed{override val shortened: String = "FRA"}
case object Argentina extends FootballCountryShortensSealed{override val shortened: String = "ARG"}
case object Morocco extends FootballCountryShortensSealed{override val shortened: String = "MAR"}

def printEnums(country: FootballCountryShortensSealed) = {
  println(country.shortened)
}

printEnums(England)
printEnums(France)
printEnums(Argentina)

printEnums(Morocco)

////////////////////////////////////////////////

val komodoDragon: AnimalEnum = AnimalEnum(species = Serpent, canFlyEnum = NoEnum, evolutionaryPeriod = EvolutionaryPeriod.Pleistocene, exobody = Exobody.Scales)
val pterodactyl: AnimalSealed = AnimalSealed(canFlySealed = YesSealed, animalsSealed = OstrichSealed, evolutionaryPeriodSealed = Pliocene, exobodySealed = Feathers)

pterodactyl.canFlySealed match {
  case YesSealed => s"${pterodactyl.animalsSealed} can fly!"
  case No => s"${pterodactyl.animalsSealed} can't fly :("
}
