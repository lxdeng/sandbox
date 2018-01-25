def add(a: Int, b: Int): Int = {
  // cannot change b, since b is a val
  // b = 1

  // In the absence of any explicit return statement,
  // a Scala function returns the last value computed
  // think of each function as an expression that yields one value
  // avoid having explicit, and especially multiple, return statements. 
  a + b
}

println(add(1, 2))

// The type A => B is the type of a function that takes an argument of type A and returns a result of type B
def apply(f: Int => Int, x: Int) :Int = f(x)

def double(x: Int) = x * 2
def triple(x: Int) = x * 3

println(apply(double, 10))
println(apply(triple, 10))

def factory(name: String): Int => Int = name match {
  case "double" => double
  case "triple" => triple
}

var f = factory("double")
println(f)
println(f(2))

f = factory("triple")
println(f(2))

