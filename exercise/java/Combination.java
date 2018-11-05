
public class Combination {
	public static void main(String args[]) { 

		char input[] = {'A', 'B', 'C', 'D'};
		
		pick3(input);
		
		/*
		int size = 3;
		char data[] = new char[3];
		combination(input, data, 0, 3, 0, size);
		*/
		
	 }
	
	static void pick3(char input[]) {
		for (int i = 0; i < 4; i++)
			for (int j = i + 1; j < 4; j++) 
				for (int k = j +1; k < 4; k++) {
					System.out.print(input[i]);
					System.out.print(input[j]);
					System.out.print(input[k]);
					System.out.println();
				}
						
	}
	
	 // s has some unqiue chars
	 static void combination(char input[], char data[], int start, int end, int index, int size) {
		 
		 
		 if (index == size) {
			 System.out.println(new String(data));
			 return;
		 }
		 
		 for (int i = 0; i < size; i++) {
			 data[index] = input[start + i];
			 combination(input, data, start + i + 1, end, index + 1, size);
		 }
	 }
}
