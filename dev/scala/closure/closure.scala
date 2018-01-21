def startAt(x: Int) = (y: Int) => x + y

var s1 = startAt(1)
var s2 = startAt(10)
println(s1(1))
println(s2(1))
println(startAt(1)(1))
