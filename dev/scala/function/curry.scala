
// non-curry
def add(x: Int, y : Int)= x + y
printf("non-curry: %d\n", add(1, 2))

// curry longhand
// it transfers a function of two parameters into a function of one parameter that returns a function of one parameter.
def add(x: Int): (Int => Int) = (y: Int) => x + y
printf("curry longhand : %d\n", add(1)(2))

// curry shorthand
// the shorthand add2 is same as the longhand add
def add2(x: Int)(y: Int) = x + y
printf("curry shorthand : %d\n", add2(1)(2))


/*
try the following in scala REPL shell

scala> def add(x:Int)(y:Int) = x + y
add: (x: Int)(y: Int)Int

scala> add(1)
<console>:13: error: missing argument list for method add
Unapplied methods are only converted to functions when a function type is expected.
You can make this conversion explicit by writing `add _` or `add(_)(_)` instead of `add`.
       add(1)
          ^

scala> add(1) _
res1: Int => Int = $$Lambda$1056/748316439@7b3cde6f

scala> (add(1)_)apply(2)
res3: Int = 3

*/
