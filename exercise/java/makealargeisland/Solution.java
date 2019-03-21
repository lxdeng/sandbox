package makealargeisland;

import java.util.*;

public class Solution {
    int max = 0;
    int offset[][] ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    
    public static void main(String[] args) {
    	
    	Solution sol = new Solution();
    	int[][] grid = {{1,0},{1,1}};
    	
    	System.out.println(sol.largestIsland(grid));
    }
    

        public int largestIsland(int[][] grid) {

            // key: island id, value: island area
            HashMap<Integer, Integer> islands = new HashMap<>();
            
            // find all islands, and color each island with an unique id
            int id = 2;
            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 1) {
                        // found an island
                        int area = islandArea(grid, i, j, id);
                        islands.put(id, area);
                        max = Math.max(max, area); // case of full 1's
                        ++id;
                    }
                }

            // change 0 to 1
            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid.length; j++)
                    if (grid[i][j] == 0) {
                        max = Math.max(max, enlarge(grid, i, j, islands));   
                    }    
            
            return max;
        }
        
        int islandArea(int[][] grid, int i, int j, int id) {
            //if (i < 0 || j < 0 || i > grid.length-1 || j > grid.length-1 || grid[i][j] != 1) return 0;

            grid[i][j] = id; // mark island with id
        
            int area = 1;
            if (i > 0 && grid[i-1][j] == 1)
                area += islandArea(grid, i-1, j, id);
            
            if (i < grid.length-1 && grid[i+1][j] == 1)
                area += islandArea(grid, i+1, j, id);
            
            if (j > 0 && grid[i][j-1] == 1)
                area += islandArea(grid, i, j-1, id);
            
            if (j < grid.length-1 && grid[i][j+1] == 1)
                area += islandArea(grid, i, j+1, id);
            
            return area;
        }
            
        // enlarge island and return the resulted area
        int enlarge(int[][] grid, int i, int j, HashMap<Integer, Integer> islands) {
            int area = 1; 
            
            HashSet<Integer> set = new HashSet<>();
            
            for (int[] off : offset) {
                int x = i + off[0];    
                int y = j + off[1];
                
                if (x < 0 || y < 0 || x > grid.length-1 || y > grid.length-1) 
                    continue;
                    
                if (islands.containsKey(grid[x][y]))
                    set.add(grid[x][y]);
            }
            
            for (int id : set)
                area += islands.get(id);
            
            return area;
        }
        
}