import finalPractical.{FishBroth, MenuItem, Orangina, SalmonSushi, TempuraPrawns, TipCalculator}

import java.time.LocalTime
import java.time.format.DateTimeFormatter

val itemOne = Orangina
val itemTwo = TempuraPrawns
val itemTree = FishBroth
val itemFour = SalmonSushi

val startingItemList: List[MenuItem]= List(SalmonSushi, TempuraPrawns, Orangina)

val tipCalculator: TipCalculator = new TipCalculator

val totalCost = tipCalculator.masterTip(startingItemList, 0)

println(f"Your total to pay is £$totalCost%.2f")

LocalTime.now.getHour

