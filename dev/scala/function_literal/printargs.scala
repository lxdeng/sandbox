// call the foreach method on the args, and pass in the function literal (like an anonymous function)
// for example, (a:Int, b:Int) => a + b
// $ scala printargs.scala Scala is fun
args.foreach(arg => println(arg))
// same as args.foreach((arg: String) => println(arg))

