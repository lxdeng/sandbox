package linklistcomponents;

import java.util.HashSet;

class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int g: G) set.add(g);
        
        int count = 0;
        
        while(true) {
            boolean found = false;
            while (head != null) {
                if (set.contains(head.val)) {
                    found = true;
                    break;
                } else     
                    head = head.next;
            }
            
            if (!found) break;
            
            ++count;
            head = head.next;
            while (head != null) {
                if (set.contains(head.val))
                    head = head.next;
                else {
                    head = head.next;
                    break;
                }
            }                      
        }
        
        return count;
    }
}