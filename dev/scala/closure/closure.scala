/*
Nested functions may in certain situations (and languages) lead to the creation of a closure. If it is possible for the nested function to escape the enclosing function, for example if functions are first class objects and a nested function is passed to another function or returned from the enclosing function, then a closure is created and calls to this function can access the environment of the original function.
*/
def startAt(x: Int) = (y: Int) => x + y
// same as
// def startAt(x: Int): Int => Int = { (y: Int) => x + y }

var s1 = startAt(1)
var s2 = startAt(10)
println(s1(1))
println(s2(1))
println(startAt(1)(1))

def startAt2(x: Int): Int => Int = {
  def increment(y: Int): Int = x + y
  increment
}

var t2 = startAt2(10)
println(t2)
println(t2(1))

// notice the following different
def E(x: Float): Float = {
  def F(y: Float) = x + y
  F(x)
}

// E(5) is a Float, not function
println(E(5))
