package unionfind;

import java.util.Arrays;

class UF {
    int sz;
    int comps;
    int parent[];
    
    UF(int sz) {
        this.sz = sz;
        parent = new int[sz];
        Arrays.fill(parent, -1);
    }
    
    int components() {
        return comps;
    }
    
    void add(int p) {
        if (parent[p] == -1) {
            parent[p] = p;
            comps++;
        }
    }
    
    void union(int p1, int p2) {
        int root1 = find(p1);
        int root2 = find(p2);
        if (root1 == root2)
            return;
        
        parent[root1] = root2;
        comps--;
    }
    
    int find(int p) {     
        //recursion for easy coding
        if (p == parent[p]) return p;
        
        parent[p] = find(parent[p]);
        return parent[p];
    	
    	/*
         while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
        */
    }
    
}
