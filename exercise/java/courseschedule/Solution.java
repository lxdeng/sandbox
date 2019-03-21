package courseschedule;

import java.util.*;

public class Solution {
	

	public static void main(String args[]) {
	
		int[][] pres = {{0,1},{0,2},{2,1}};
		//System.out.println(new Solution().canFinish(3, pres));
		
		for (int c : new Solution().topoSortByDegree(3, pres))
			System.out.println(c);
	}

	public int[] topoSortByDegree(int numCourses, int[][] prerequisites) {
				
		int[] coures = new int[numCourses];
		int idx = 0;
		
		HashMap<Integer, Integer> inDegreeMap = new HashMap<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[0]))
                map.put(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
            
            inDegreeMap.put(pre[1], inDegreeMap.getOrDefault(pre[1], 0) + 1);
        }
        
        LinkedList<Integer> zeroDegreeNodes = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
        	if (!inDegreeMap.containsKey(i))
        		zeroDegreeNodes.add(i);
        }
		
        while(!zeroDegreeNodes.isEmpty()) {
        	int node = zeroDegreeNodes.remove(0);
        	coures[idx++] = node;
        	
        	List<Integer> deps = map.get(node);
        	if (deps != null) {
        	  for (int d : deps) {
        		int prevDegree = inDegreeMap.get(d);
        		if (prevDegree == 1) {
        			zeroDegreeNodes.add(d);
        			inDegreeMap.remove(d);
        		} else
        			inDegreeMap.put(d, prevDegree - 1);     		
        	  }
        	}
        }
        
        return coures;
	}
	
	public int[] topoSort(int numCourses, int[][] prerequisites) {
		int[] coures = new int[numCourses];
		int idx = numCourses - 1;
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[0]))
                map.put(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }    
        
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) 
                continue;
         
            ArrayList<Integer> visitedNodes = new ArrayList<>();
            dfs(map, visited, i, visitedNodes);
            for (int node : visitedNodes)
            	coures[idx--] = node;
        }
        
		return coures;
	}
	
	
	private void dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int i, ArrayList<Integer> visitedNodes) {
		visited[i] = true;
		
		if (map.containsKey(i)) {
			for (int dep : map.get(i)) {
				if (!visited[dep]) 
					dfs(map, visited, dep, visitedNodes);
			}
		}
		
		visitedNodes.add(i);
	}
	
	
	

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[0]))
                map.put(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }    
        
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) 
                continue;

            HashSet<Integer> set = new HashSet<>();
            if (dfsDetectLoop(i, map, set, visited))
                return false;
        }
        
        return true;
    }
    
    // return true if found loop
    boolean dfsDetectLoop(int i, HashMap<Integer, List<Integer>> map, HashSet<Integer> set, boolean[] visited) {
        visited[i] = true;
        set.add(i);
        
        if (map.containsKey(i)) {
            for (int dep : map.get(i)) {
            	if (set.contains(dep)) 
                    return true;
            	
                if (dfsDetectLoop(dep, map, set, visited))
                     return true;
            }
        }
        
        return false;
    }
}