package friendcircle;

import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
	  int f[][] = {{1,0,0,1},
			 	   {0,1,1,0},
			       {0,1,1,1},
				   {1,0,1,1}};
		
	  System.out.println(new Solution().findCircleNum(f));
		
	}
	
	public int findCircleNum(int[][] M) {
        HashSet<HashSet<Integer>> groups = new HashSet<>();
        int n = M.length;
        
        for (int i = 0; i < n; i++) {
            boolean inGroup = false; // whether i already in a group
            for (HashSet<Integer> g : groups) {
                if (g.contains(i)) {
                    inGroup = true;
                    break;
                } 
            }
            
            if (!inGroup) {
                HashSet<Integer> group = new HashSet<>();
                groups.add(group);
                group.add(i);
                dfsAddToGroup(group, i, M, n);
            }
        }    
        
        return groups.size();
    }    
    
    void dfsAddToGroup(HashSet<Integer> group, int i, int[][] M, int n) {
        for (int j = 0; j < n; j++)
            if (j != i && M[i][j] == 1) {
                if (!group.contains(j)) {
                    group.add(j);
                    dfsAddToGroup(group, j, M, n);  
                }
            }
    }
}
