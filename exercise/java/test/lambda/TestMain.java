package test.lambda;

public class TestMain {
	public static void main(String args[]) {
		
		TestMain test = new TestMain();
		
		test.testPreLamba();
		
		test.testLambaExpression();
		
		test.testMethodReference();
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
}
