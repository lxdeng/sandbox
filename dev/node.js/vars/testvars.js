var x =1.1

// "var" is optional, but y escapes the current scope to be global, bad!!!
y = x + 2.0

console.log(y)

y = "hello"
console.log(y)

console.log(0/0)


//Variables declared by let have as their scope the block in which they are defined, 
//as well as in any contained sub-blocks. In this way, let works very much like var. 
//The main difference is that the scope of a var variable is 
//the entire enclosing function:
function varTest() {
    var x = 1;
    if (true) {
      var x = 2;  // same variable!
      console.log(x);  // 2
    }
    console.log(x);  // 2
  }
  
  function letTest() {
    let x = 1;
    if (true) {
      let x = 2;  // different variable
      console.log(x);  // 2
    }
    console.log(x);  // 1
  }

  varTest()

  letTest()