// function constructor 
function Person(first, last, age) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
}

//this does not work
Person.nation="USA";

//But keep in mind that the implicit ‘this’ is only assigned to a new object when using ‘new’. 
//If you forget ‘new’ keyword then ‘this’ will be the global object. 
var myFather = new Person("John", "Doe", 50);
var myMother = new Person("Sally", "Rally", 48);

console.log(myFather.age);
console.log(myFather.nation);

//secret link
console.log(myFather.__proto__);

console.log(Object.getPrototypeOf(myFather))
//true
console.log(Object.getPrototypeOf(myFather) === Person.prototype)

//true, myFather and myMother points to the same prototype, which is "Person.prototype"
console.log(Object.getPrototypeOf(myFather) === Object.getPrototypeOf(myMother))

//true
console.log(Person.__proto__ === Function.prototype)

//the .prototype is object
console.log(Person.prototype);

// add a new property via prototype
Person.prototype.nation = "English";
console.log("myFather.nation: ", myFather.nation);
console.log("myMother.nation: ", myMother.nation);

// add a method via prototype
Person.prototype.name = function() {
    return this.firstName + " " + this.lastName;
}

console.log("myFather.name(): ", myFather.name());

//true
console.log("Person instance of Function: ", Person instanceof Function)