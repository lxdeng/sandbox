package test.lambda;

@FunctionalInterface
public interface Animal { // it can only have one abstract method
	void run(String runMsg);
	
	default void walk() {
		System.out.println("All animals walk in the same way.");
	}
}
