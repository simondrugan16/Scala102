import functions.{OptionalsPractical, Quote, SpongebobCharacter}

import scala.util.Random
////////////////
// Practicals //
////////////////

val pi: Double = 3.14

val circleArea: Int => Double = (radius) => radius * radius * pi
val circleCircumference: Int => Double = (radius) => 2 * radius * pi

def circleResults(operations: (Int) => Double, radius : Int): Double = operations(radius)

circleResults(circleArea, 5)
circleResults(circleCircumference, 5)


////////////////////////////////

val spongeBobQuoteGenerator: SpongebobCharacter => String = (spongebobCharacter) => {
  spongebobCharacter.character match {
    case Some("Spongebob") => "Excuse me, sir, but you’re sitting on my body, which is also my face."
    case Some("Patrick") => "No this is Patrick."
    case Some("Squidward") => "Too bad SpongeBob’s not here to enjoy Spongebob not being here."
    case Some(_) => "Oh well, I guess I’m not wearing any pants today!"
    case None => "No character submitted!"
  }
}

spongeBobQuoteGenerator(SpongebobCharacter(character = Some("Spongebob")))
spongeBobQuoteGenerator(SpongebobCharacter(character = Some("Patrick")))
spongeBobQuoteGenerator(SpongebobCharacter(character = Some("Squidward")))
spongeBobQuoteGenerator(SpongebobCharacter(character = Some("SANDY ?? XYZ")))
spongeBobQuoteGenerator(SpongebobCharacter(character = None))

////////////////////////////////

val quoteOne = Quote(author = Some("Socrates"), quote = Some("The unexamined life is not worth living"))
val quoteTwo = Quote(author = Some("Ludwig Wittgenstein"), quote = Some("Whereof one cannot speak, thereof one must be silent"))
val quoteThree = Quote(author = Some("William of Ockham"), quote = Some("Entities should not be multiplied unnecessarily"))
val quoteFour = Quote(author = Some("Thomas Hobbes"), quote = Some("The life of man (in a state of nature) is solitary, poor, nasty, brutish, and short"))
val quoteFive = Quote(author = Some("René Descartes"), quote = Some("I think therefore I am"))

val quoteList: List[Quote] = List(quoteOne, quoteTwo, quoteThree, quoteFour, quoteFive)

val rand = new Random

val returnAQuote: Quote => String = (quote) => {
  quote.quote match {
    case Some(_) => quote.quote.getOrElse("This should never run")
    case None => quoteList(rand.nextInt(4)).quote.getOrElse("This should never run")
  }
}

returnAQuote(Quote(author = None, quote = None))
returnAQuote(Quote(author = Some("Shakespeare"), quote = Some("All that glitters is not gold")))

def quoteGenerator(operation:Quote => String, quoteOrCharacter: Quote): String = operation(quoteOrCharacter)
def quoteGenerator(operation:SpongebobCharacter => String, quoteOrCharacter: SpongebobCharacter): String = operation(quoteOrCharacter)

quoteGenerator(operation = returnAQuote, Quote(author = Some("None"), quote = None))
quoteGenerator(operation = spongeBobQuoteGenerator, quoteOrCharacter = SpongebobCharacter(character = Some("Patrick")))

