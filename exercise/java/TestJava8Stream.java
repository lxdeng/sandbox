
import java.util.*;
import java.util.stream.Stream;

public class TestJava8Stream {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("ONE", "TWO", "THREE");
		
		//Stream<String> stream = list.stream();
		
		list.stream()
			.filter(str -> str.startsWith("T"))
			.forEach(str -> System.out.println(str));
			
		//System.out.println(stream.count());
		
		//Stream<String> stream2 = stream.map((v)-> v.toLowerCase());
		//System.out.println(stream2.count());
		
	}
}
