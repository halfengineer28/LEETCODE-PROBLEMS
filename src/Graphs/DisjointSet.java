package Graphs;

public class DisjointSet {
   int [] parent;
   int [] rank;
   int [] size;
   int n;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        this.n = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node){
        if (node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);

    }
    public void UnionByRank(int u, int v){
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v){
            return;
        }

        if (rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
        } else if (rank[parent_v] < rank[parent_u]) {
            parent[parent_v] = parent_u;

        }else {
            parent[parent_u] = parent_v;
            rank[parent_v]++;
        }
    }
    public void UnionBySize(int u, int v){
       int parent_u = findParent(u);
       int parent_v = findParent(v);
       if (parent_u == parent_v){
           return;
       }
       if (size[parent_u] < size[parent_v]){
           parent[parent_u] = parent_v;
           size[parent_v] += size[parent_u];
       }else {
           parent[parent_v] = parent_u;
           size[parent_u] += size[parent_v];
       }
    }

}
