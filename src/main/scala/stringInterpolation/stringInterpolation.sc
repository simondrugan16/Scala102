import caseClasses.Person

val myName: String = "Simon"
println(s"My name is $myName")

println(s"I don't know about you, but i'm feeling ${30-8} - Taytay Swift")

val number: Int = 3

println(s"All I did was blink twice, now you're number ${number / 3}")

val pi: Double = 3.141592653589793

println(f"Pi to 2 decimal places is $pi%1.2f") //Pi to 2 decimal places is 3.14
println(f"Pi to 4 decimal places is $pi%.4f") //Pi to 4 decimal places is 3.1416

println(s"I'm going to go on a \nnew line") //I’m going to go on a *new line* new line
println(raw"I'm going to go on a \nnew line") //I’m going to go on a \nnew line

////////////////
// Practicals //
////////////////

val baez = Person(name = "Baez", age = 523, favouritePokemon = "Dialga", magicalAbilityOutOfTen = 9.666)
val ron = Person(name = "Ron Weasley", age = 18, favouritePokemon = "Raticate", magicalAbilityOutOfTen = 3.12)

println(s"${baez.name} is much older than ${ron.name}")
println(s"${baez.name} is ${baez.age - ron.age} years older than ${ron.name}")
println(f"${baez.name} is ${100 * (baez.magicalAbilityOutOfTen / ron.magicalAbilityOutOfTen)}%f%% better at magic than ${ron.name}")

println(raw"\n\n\n\n\n\n\n\nsameline\n\n")

println(s"${baez.name} is much older than ${ron.name}")
println(f"${baez.name}'s magical ability to two decimal places is ${baez.magicalAbilityOutOfTen}%1.2f")
println(raw"if an animal /p erson was to kill a horcrux, ${ron.age} years of magical excellence would help")