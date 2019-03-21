
public class CountAndSay {

	public static void main(String args[]) {
		System.out.println(countAndSay(40));
	}

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        
        String s = countAndSay(n-1);
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) ++j;
            
            int count = j - i;
            sb.append(count);
            sb.append(s.charAt(i));
            i = j;
        }
        
        return sb.toString();
    }
}