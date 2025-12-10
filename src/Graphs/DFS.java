package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {



    }
    public static List<Integer> dfs (){
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int v = adj.size();
        boolean[] vis = new boolean[v];
        Dfsrec(ans, adj, 0, vis);
        return ans;
    }
    public static void Dfsrec(List<Integer> ans, List<List<Integer>>adj, int src, boolean [] vis){
        ans.add(src);
        vis[src] = true;

        for (Integer it : adj.get(src)){
            if(!vis[it]){
                Dfsrec(ans, adj, it, vis);
            }
        }
    }
    public static void dfsrecDG(ArrayList<ArrayList<Integer>> adj, boolean [] vis, int src, List<Integer> ans ){
        vis[src] = true;
        ans.add(src);

        for (Integer it : adj.get(src)){
            if (!vis[it]){
                dfsrecDG(adj, vis, src, ans);
            }
        }


    }
    public static List<Integer> DGDFS(ArrayList<ArrayList<Integer>> adj){
        List<Integer> ans = new ArrayList<>();
        int v = adj.size();
        boolean [] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]){
                dfsrecDG(adj,vis,i,ans);
            }

        }
        return ans;


    }
}
