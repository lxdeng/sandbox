
import java.util.*;

public class CamelCaseMatching {
	
	public static void main(String args[]) { 
		
		String[] queries = {"FooBar"};
		String pattern = "FB";
		
		new CamelCaseMatching().camelMatch(queries, pattern);
	}

	public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> res = new ArrayList<>();
        
        for (String q : queries)
            res.add(match(q.toCharArray(), pattern.toCharArray()));
        
        return res;
    }
    
    boolean match(char[] q, char[] p) {
        int i = 0, j = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < q.length && j < p.length) {
            map.clear();
            
            while (i < q.length && Character.isLowerCase(q[i])) {
                map.put(q[i], map.getOrDefault(q[i], 0) + 1);
                i++;
            }

            while (j < p.length && Character.isLowerCase(p[j])) {
                if (map.containsKey(p[j])) {
                    int cnt = map.get(p[j]) - 1;
                    if (cnt == 0)
                        map.remove(p[j]);
                    else
                        map.put(p[j], map.get(p[j]) - 1);    
                } else {
                    return false;
                }
                
                j++;
            }
            
            if (i < q.length && j < p.length) {
                if (q[i] != p[j]) {
                    System.out.println(q[i] + " " + p[j]);
                    return false;
                }    
                i++;
                j++;
            }
            
        }
        
        return i == q.length && j == p.length;
    }
}
