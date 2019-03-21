package customsort;

import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        
        for (String log : logs) {
            char c = log.split(" ")[1].charAt(0);
            if (Character.isDigit(c))
                digitList.add(log);
            else
                letterList.add(log);
        }
        
        Collections.sort(letterList, (String log1, String log2) -> {
            String[] s1 = log1.split(" ");
            String[] s2 = log2.split(" ");
            
            int s1Len = s1.length, s2Len = s2.length;
            
            for (int i = 1; i < Math.min(s1Len, s2Len); i++) {
                int x = s1[i].compareTo(s2[i]);
                if (x != 0)
                    return x;
            }
            
            if (s1Len == s2Len)
                return s1[0].compareTo(s2[0]);
            else 
                return (s1Len < s2Len) ? -1 : 1;
            
        });

        for (int i = 0; i < logs.length; i++) {
            if (i < letterList.size()) {
                logs[i] = letterList.get(i);
            } else {
                logs[i] = digitList.get(i - letterList.size());
            }
        }
        
        return logs;
    }
    
    public static void main(String[] args) {
    	String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act car"};
    	Solution sol = new Solution();
    	logs = sol.reorderLogFiles(logs);
    	for (String l : logs) {
    		System.out.print(l + ", ");
    	}
    }
}