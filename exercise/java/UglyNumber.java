import java.util.*;

public class UglyNumber {

	public static void main(String[] args) {
		//System.out.println(isUgly(1000));
		
		//Number nums[] = new Integer[5]
		
		System.out.println(findTheDifference("abcd", "abcde"));
	}
	
	
    public static boolean isUgly(int num) {
        
        if (num == 0) return false;
        for (int i = 2; i < 6; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
    
    public static char findTheDifference(String s, String t) {
        int[] map = new int[26];
        
        for (char c: s.toCharArray()) {
            map[c - 'a'] += 1;
        }
        
        for (char c: t.toCharArray()) {
            map[c - 'a'] -= 1;
        }
        
        int i;
        for (i = 0; i < 26; i++) {
            if (map[i] == 1) break;
        }
        
        System.out.println(i);
        return (char)(i + 'a');
    }
       
}
