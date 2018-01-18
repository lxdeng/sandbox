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
