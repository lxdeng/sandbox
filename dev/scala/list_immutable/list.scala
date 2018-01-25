// List is immutable
// ListBuffer is mutable

// One of the big ideas of the functional style of programming is that methods should not have side effects.
//  Applying this functional philosophy to the world of objects means making objects immutable.

val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")

var l = List[String]()
l = "hello" :: l // :: is right associated with the list "l", i.e. method of "l"
println("l=" + l)
