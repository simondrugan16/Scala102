package finalPractical

import java.time.LocalTime

class TipCalculator extends App {

  def masterTip(startingItemList: List[MenuItem], numberOfStars: BigDecimal): BigDecimal = {
    val allTipInformation = calculateTotalTip(startingItemList)

    val happyHourDrinksDiscount = happyHourDiscount(allTipInformation._5)

    val loyaltyDiscount = totalDiscountCalculator(numberOfStars)

    val postLoyaltyDiscountTotalCost = (allTipInformation._2 - happyHourDrinksDiscount) * (1 - loyaltyDiscount)

    val totalCostExcludingLuxuryItemDiscount = postLoyaltyDiscountTotalCost + (Lobster.price * allTipInformation._4 * loyaltyDiscount)

    allTipInformation._3 match {
      case "Drinks" => totalCostExcludingLuxuryItemDiscount
      case "Cold Food" => totalCostExcludingLuxuryItemDiscount * 1.1
      case "Hot Food" => totalCostExcludingLuxuryItemDiscount * 1.2
      case "Luxury" =>
        if (totalCostExcludingLuxuryItemDiscount < 160) {
          totalCostExcludingLuxuryItemDiscount * 1.25
        } else {
          totalCostExcludingLuxuryItemDiscount + 40
        }
    }
  }

  def calculateTotalTip(remainingItems: List[MenuItem], summativeCost: BigDecimal = 0.0, tipType: String = "Drinks", totalLobsters: Int = 0, totalBeers: Int = 0): (List[MenuItem], BigDecimal, String, Int, Int) = {
    remainingItems match {
      case x :: _ =>
        val lastItemInList: MenuItem = remainingItems.last
        val newTipType: String = calculateTipPercentage(lastItemInList, tipType)
        val price = lastItemInList.price
        val summativeCostAdder = summativeCost + price
        val listAfterRemovingSummedItem = remainingItems.init
        val summativeNumberOfLobsters: Int = if (lastItemInList.itemType == "Luxury") {totalLobsters + 1} else {totalLobsters}
        val summativeNumberOfBeers: Int = if (lastItemInList.itemType == "Alcohol") {totalBeers + 1} else {totalBeers}
        calculateTotalTip(listAfterRemovingSummedItem, summativeCostAdder, newTipType, summativeNumberOfLobsters, summativeNumberOfBeers)
      case _ => (remainingItems, summativeCost, tipType, totalLobsters, totalBeers)
    }
  }

  def calculateTipPercentage(menuItem: MenuItem, tipType: String): String = {
    tipType match {
      case "Drinks" =>
        if (menuItem.temperature == "Cold" && menuItem.itemType == "Food") {
          "Cold Food"
        } else if (menuItem.temperature == "Hot" && menuItem.itemType == "Food") {
          "Hot Food"
        } else if (menuItem.itemType == "Luxury") {
          "Luxury"
        } else {
          "Drinks"
        }
      case "Cold Food" =>
        if (menuItem.temperature == "Hot" && menuItem.itemType == "Food") {
          "Hot Food"
        } else if (menuItem.itemType == "Luxury") {
          "Luxury"
        } else {
          "Cold Food"
        }
      case "Hot Food" =>
        if (menuItem.itemType == "Luxury") {
          "Luxury"
        } else {
          "Hot Food"
        }
      case "Luxury" => "Luxury"
    }
  }

  def totalDiscountCalculator(numberOfStars: BigDecimal): BigDecimal = {
    if (numberOfStars <= 2) {
      0.0
    } else if (numberOfStars > 8) {
      0.2
    } else {
      numberOfStars * 2.5 / 100
    }
  }

  def happyHourDiscount(numberOfBeers: Int): BigDecimal = {
    val happyHourStart = 18
    val happyHourEnd = 21

    if (LocalTime.now.getHour >= happyHourStart && LocalTime.now.getHour < happyHourEnd) {
      0.5 * numberOfBeers
    } else {
      0.0
    }
  }
}