package test.lambda;

public class TestMain {
	public static void main(String args[]) {
		
		TestMain test = new TestMain();
		
		/*
		test.testPreLamba();
		
		test.testLambaExpression();
		
		test.testMethodReference();
		*/
		
		test.testHandleAnimal();
	}

	public void testPreLamba() {
		Animal an = new Animal() {
			public void run(String runMsg) {
				System.out.println(runMsg);
			}
		};
		
		an.run("PreLambda animal runs");
		an.walk();
	}
	
	public void testLambaExpression() {
		/*
		Animal an = () -> {
			System.out.println("Lambda-expression animal runs");
		};
		*/
		
		// remove curly braces, when there is only one statement
		Animal an = (msg) -> System.out.println(msg);
		
		an.run("Lambda-Expression animal runs");
		an.walk();
	}
	
	public void testMethodReference() {

		// static method reference
		Animal an = System.out::println; // since it only calls one method
		
		an.run("Method-Reference animal runs");
		an.walk();
	}
	
	void handleAnimal(Animal animal) {
		for (int i = 0; i < 2; i++)
			animal.walk();
		
		animal.run("I'm running");
	}
	
	public void testHandleAnimal() {
		
		System.out.println("passing an object");
		
		Animal animal = new Animal() {
			public void run(String runMsg) {
				System.out.println(runMsg);
			}
		};
		
		handleAnimal(animal);
		
		
		System.out.println("\npassing a lambda");
		handleAnimal((msg) -> {System.out.println(msg);});
	
		// since it only calls one method, It is a compact and easy form of lambda expression. 
		System.out.println("\npassing method reference");  
		handleAnimal(System.out::println);
	}
}
