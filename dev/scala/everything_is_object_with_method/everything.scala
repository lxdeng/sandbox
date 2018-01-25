// number is object, operators are methods
println(1+2)
println(1.+(2)) // same as 1 + 2, + as a method on object 1

// general rule, if one method takes only one argument, it can be called without dot or parentheses
// for (i <- 0 to 2) is same as 
// for (i <- (0).to(2)) or for (i <- 0.to(2)) 

for (i <- 0.to(2))
  println(i)

// arrays are instances of classes
val strs = new Array[String](3)
strs(0) = "Hello"
// is same as
strs.update(0, "Hello")

println(strs(0))
// is same as
println(strs.apply(0))

