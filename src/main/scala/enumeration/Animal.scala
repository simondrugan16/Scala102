package enumeration

case class AnimalEnum(species: AnimalsEnum.Value,
                  canFlyEnum: CanFlyEnum.Value,
                  evolutionaryPeriod: EvolutionaryPeriod.Value,
                  exobody: Exobody.Value)

object AnimalsEnum extends Enumeration {
  val DogEnum, CatEnum, Ostrich, Gorilla, Serpent = Value
}

object CanFlyEnum extends Enumeration {
  val Yes, NoEnum, Kinda = Value
}

object EvolutionaryPeriod extends Enumeration {
  val Holocene, Pleistocene, Pliocene = Value
}

object Exobody extends Enumeration {
  val Skin, Feathers, Scales, Spikes = Value
}


//////////////////////////////////////////////////////////////////

case class AnimalSealed(canFlySealed: CanFlySealed,
                        animalsSealed: AnimalsSealed,
                        evolutionaryPeriodSealed: EvolutionaryPeriodSealed,
                        exobodySealed: ExobodySealed)

sealed trait CanFlySealed

case object YesSealed extends CanFlySealed
case object No extends CanFlySealed
case object Kinda extends CanFlySealed

sealed trait AnimalsSealed

case object DogSealed extends AnimalsSealed
case object CatSealed extends AnimalsSealed
case object OstrichSealed extends AnimalsSealed
case object GorillaSealed extends AnimalsSealed
case object SerpentSealed extends AnimalsSealed

sealed trait EvolutionaryPeriodSealed

case object Holocene extends EvolutionaryPeriodSealed
case object Pleistocene extends EvolutionaryPeriodSealed
case object Pliocene extends EvolutionaryPeriodSealed

sealed trait ExobodySealed

case object Skin extends ExobodySealed
case object Feathers extends ExobodySealed
case object Scales extends ExobodySealed
case object Spikes extends ExobodySealed