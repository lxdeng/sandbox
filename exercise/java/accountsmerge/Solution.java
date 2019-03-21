package accountsmerge;

import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		
		
		
		ArrayList<List<String>> accts = new ArrayList<>();
		ArrayList<String> l = new ArrayList<>();
		accts.add(l);
		l.add("David");
		l.add("David0@m.co");
		l.add("David1@m.co");
		
		l = new ArrayList<>();
		accts.add(l);
		l.add("David");
		l.add("David2@m.co");
		l.add("David1@m.co");
	/*
		l = new ArrayList<>();
		accts.add(l);
		l.add("David");
		l.add("David4@m.co");
		l.add("David5@m.co");
		
		l = new ArrayList<>();
		accts.add(l);
		l.add("David");
		l.add("David2@m.co");
		l.add("David3@m.co");
		
		l = new ArrayList<>();
		accts.add(l);
		l.add("David");
		l.add("David1@m.co");
		l.add("David2@m.co");
*/
		List<List<String>> r = new Solution().accountsMerge(accts);
		System.out.println(r.size());
	}

public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        ArrayList<List<String>> result = new ArrayList<>();
        
        int totalEmails = 0;
        for (List<String> acct : accounts) {
            totalEmails += acct.size() - 1;
        }
        
        UF uf = new UF(totalEmails);
        int id = 0;    
    
        HashMap<String, Integer> eMap = new HashMap<>(); // email -> id
        HashMap<String, String> nameMap = new HashMap<>(); // email -> name
        for (List<String> acct : accounts) {
            if (acct.size() == 1) {
                result.add(acct);
                continue;
            }
            
            String name = acct.remove(0);
            
            for (int i = 0; i < acct.size(); i++) {
                String email = acct.get(i);
                if (!eMap.containsKey(email)) {
                    eMap.put(email, id++);
                    nameMap.put(email, name);
                }
                
                uf.union(eMap.get(acct.get(0)), eMap.get(email));
            } 
        }
                         
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String em : eMap.keySet()) {
            id = eMap.get(em);
            id = uf.find(id);
            if (!map.containsKey(id))
                map.put(id, new ArrayList<String>());
            map.get(id).add(em);
        }
                         
        for (List<String> emList : map.values()) {
            Collections.sort(emList);
            String name = nameMap.get(emList.get(0));
            //emList.add(0, name);
            result.add(emList);
        }                 
                         
        return result;
    }
}

class UF {
    int[] parent;
    
    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    
    int find(int p) {
        if (parent[p] == p) return p;
        parent[p] = find(parent[p]);
        return parent[p];
    }
    
    void union(int p1, int p2) {
        int root1 = find(p1);
        int root2 = find(p2);
        if(root1 == root2) return;
        
        parent[root1] = root2;
    }

}