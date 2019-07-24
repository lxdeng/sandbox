package test.mapandstream;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

import java.util.HashMap;

public class TestMain {
	public static void main(String args[]) {	
		test1();
		
		test2();
	}
	
	public static void test1() {
		System.out.println("test1");
		
		Map<String, String> books = new HashMap<>(); // ISBN --> Book titles
		
		books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
		books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
		books.put("978-0134685991", "Effective Java");
		
		//We are interested in finding the ISBN for the book with the title “Effective Java”.
		
		for (Map.Entry<String, String> ent : books.entrySet()) {
			if (ent.getValue().equals("Effective Java"))
				System.out.println(ent.getKey());
		}


		Optional<String> optionalIsbn = books.entrySet().stream()
				  .filter(e -> "Effective Java".equals(e.getValue()))
				  //.map(Map.Entry::getKey)
				  .map(e -> e.getKey())
				  .findFirst();  // return a single object
		
		if(optionalIsbn.isPresent())
			System.out.println(optionalIsbn.get());
			
	}

	public static void test2() {
		System.out.println("test2");
		
		Map<String, String> books = new HashMap<>(); // ISBN --> Book titles
		
		books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
		books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
		books.put("978-0134685991", "Effective Java");
		books.put("978-0321356680", "Effective Java: Second Edition");

		Set<String> isbnCodes = books.entrySet().stream()
				  .filter(e -> e.getValue().startsWith("Effective Java"))
				  .map(Map.Entry::getKey)
				  .collect(Collectors.toSet()); // collect as a set
		
		for (String isbn : isbnCodes)
			System.out.println(isbn);
		
		
		List<String> titles = books.entrySet().stream()
				  .filter(e -> e.getKey().startsWith("978-0"))
				  .map(Map.Entry::getValue)
				  .collect(Collectors.toList());
		
		for (String t : titles)
			System.out.println(t);
		
	}
}	