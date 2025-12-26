package Graphs;

import java.util.*;

public class TopoLogicalSort {
    public static void main(String[] args) {

    }
    public List<Integer> topodfs(List<List<Integer>> adj, int v){
        List<Integer> ans = new ArrayList<>();
        int [] vis = new int [v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++){
            if (vis[i] != 1){
                dfs(adj, vis, i, stack);
            }
        }
        for (Integer it : stack){
            ans.add(stack.pop());
        }
    return ans;
    }
    public  void dfs(List<List<Integer>> adj, int [] vis, int i, Stack<Integer> stack){
        vis[i] = 1;

        for (Integer it : adj.get(i)){
            if (vis[it] != 1){
                dfs(adj, vis, it, stack);
            }
            stack.push(it);
        }

    }
    public List<Integer> topobfs(List<List<Integer>> adj, int v){
        int [] indeg = new int [v];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < v; i++){
            for (int it : adj.get(i)){
                indeg[it] = indeg[it] + 1;

            }
        }
        for (int i = 0; i < v; i++){
            if (indeg[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int ver = queue.poll();
            ans.add(ver);
            for (int it : adj.get(ver)){
                indeg[it] = indeg[it]-1;
                if (indeg[it] == 0){
                    queue.add(it);
                }
            }

        }
        return ans;
    }
}
