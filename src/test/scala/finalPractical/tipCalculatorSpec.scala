package finalPractical

import org.scalatest.FlatSpec

class tipCalculatorSpec extends FlatSpec {

  val tipCalculator = new TipCalculator

  "tipCalculator" should "calculate drinks tip correctly" in {
    assert(tipCalculator.masterTip(List(FishBroth, Orangina, FishBroth), 0) === 7.50)
  }

  "tipCalculator" should "calculate cold food tip correctly" in {
    assert(tipCalculator.masterTip(List(SalmonSushi, SalmonSushi), 0) === 12.1)
  }

  "tipCalculator" should "calculate hot food tip correctly" in {
    assert(tipCalculator.masterTip(List(TempuraPrawns, TempuraPrawns), 0) === 22.80)
  }

  "tipCalculator" should "calculate luxury item tip correctly" in {
    assert(tipCalculator.masterTip(List(Lobster, Lobster), 0) === 62.50)
  }

  "tipCalculator" should "calculate luxury item tip correctly below the £40 tip limit" in {
    assert(tipCalculator.masterTip(List(Lobster, Lobster), 0) === 62.50)
  }

  "tipCalculator" should "luxury item tip calculated correctly above the £40 tip limit" in {
    assert(tipCalculator.masterTip(List(Lobster, Lobster, Lobster, Lobster, Lobster, Lobster, Lobster, Lobster,
      Lobster, Lobster), 0) === 290.00)
  }

  "tipCalculator" should "calculate tip correctly with lobster, drinks, hot food and cold food" in {
    assert(tipCalculator.masterTip(List(Lobster, FishBroth, Orangina, SalmonSushi, TempuraPrawns), 0) === 55.625)
  }

  "tipCalculator" should "calculate tip correctly with drinks, hot food and cold food" in {
    assert(tipCalculator.masterTip(List(Orangina, FishBroth, SalmonSushi, TempuraPrawns), 0) === 23.4)
  }

  "tipCalculator" should "calculate tip correctly with drinks and cold food" in {
    assert(tipCalculator.masterTip(List(Orangina, FishBroth, SalmonSushi), 0) === 11.0)
  }

  "tipCalculator" should "calculate tip correctly with loyalty discount under the minimum number of stars" in {
    assert(tipCalculator.masterTip(List(Orangina, TempuraPrawns, SalmonSushi), 2) === 19.8)
  }

  "tipCalculator" should "calculate tip correctly with loyalty discount within the acceptable start range" in {
    assert(tipCalculator.masterTip(List(SalmonSushi, SalmonSushi, SalmonSushi, SalmonSushi), 6) === 20.57)
  }

  "tipCalculator" should "calculate tip correctly with loyalty discount over the minimum number of stars" in {
    assert(tipCalculator.masterTip(List(Orangina, FishBroth, FishBroth), 11) === 6)
  }

  "tipCalculator" should "calculate tip correctly with loyalty discount NOT applied to luxury item" in {
    assert(tipCalculator.masterTip(List(Lobster), 4) === 31.25)
  }

  "tipCalculator" should "calculate total cost correctly during happy hour" in {
    assert(tipCalculator.masterTip(List(Beer, Beer, Beer, Beer), 0) === 8.0)
  }

}
