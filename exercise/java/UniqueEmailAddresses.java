import java.util.HashSet;


public class UniqueEmailAddresses {

	 public static void main(String args[])  { 
		 
		 double x = 9;
		 int y = (int)x;
		 
		 String emails[] = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
		 System.out.println(numUniqueEmails(emails));
		 
	 }
	 
	    public static int numUniqueEmails(String[] emails) {
	        if (emails == null) return 0;
	        
	        HashSet<String> set = new HashSet<>();
	        int count = 0;
	        for (String e: emails) {
	            String eProcessed = process(e);
	            set.add(eProcessed);
	        }
	            
	        return set.size();
	    }
	    
	    static String process(String e) {
	        StringBuilder sb = new StringBuilder();
	        
	        char[] a = e.toCharArray();
	        
	        int i = 0;
	        
	        while (i < e.length()) {
	            if (a[i] == '.') {
	                i++;
	            } else if (a[i] == '+') {
	                i++;
	                while (i < e.length() && a[i] != '@') i++;               
	            } else {
	                sb.append(a[i++]);
	            }
	        }
	        
	        System.out.println(new String(sb));
	        return sb.toString();
	    }
}
