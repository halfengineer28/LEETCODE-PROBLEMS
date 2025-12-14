package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
}
