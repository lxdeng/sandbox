package movestones;

import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		
		//int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		
		int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
		System.out.println(new Solution().removeStones(stones));
	}
	
	
    public int removeStones(int[][] stones) {
        
        HashMap<Integer, List<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, List<Integer>> colMap = new HashMap<>();
        HashMap<String, Integer> stoneMap = new HashMap<>();
        
        UF uf = new UF(stones.length);
        
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            
            stoneMap.put(row + "#"+ col, i);
            
            if (!rowMap.containsKey(row))
                rowMap.put(row, new ArrayList<Integer>());
            
            if (!colMap.containsKey(col))
                colMap.put(col, new ArrayList<Integer>());
            
            rowMap.get(row).add(col);
            colMap.get(col).add(row);
        }
        
        for (int row : rowMap.keySet()) {
            List<Integer> colList = rowMap.get(row);
            if (colList.size() == 1) break;
            
            int s1 = stoneMap.get(row + "#" + colList.get(0));
            for (int j = 1; j < colList.size(); j++) {
                int s2 = stoneMap.get(row + "#" + colList.get(j));
                uf.union(s1, s2);
            }
        }
        
        for (int col : colMap.keySet()) {
            List<Integer> rowList = colMap.get(col);
            if (rowList.size() == 1) break;
            
            int s1 = stoneMap.get(rowList.get(0) + "#" + col);
            for (int j = 1; j < rowList.size(); j++) {
                int s2 = stoneMap.get(rowList.get(j) + "#" + col);
                uf.union(s1, s2);
            }
        }
        
        return uf.moves();
    }
}

class UF {
    int parent[];
    int sz[];
    
    public UF(int n) {
        parent = new int[n]; 
        sz = new int[n]; // size of a group
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    int find(int p) {
        if (parent[p] == p) return p;
        
        parent[p] = find(parent[p]);
        return parent[p];
    }
    
    void union(int p1, int p2) {
        //System.out.println("call union p1=" + p1 + ", p2=" + p2);
        int root1 = find(p1);
        int root2 = find(p2);
        if (root1 == root2) return;
        
        parent[root1] = root2;

        sz[root2] += sz[root1];
        sz[root1] = 0;
    }
    
    int moves() {
        int sum = 0;
        for (int count : sz) {
            //System.out.println("count=" + count);
            if (count > 1)
                sum += count - 1;
        }
        return sum;
    }
    
}