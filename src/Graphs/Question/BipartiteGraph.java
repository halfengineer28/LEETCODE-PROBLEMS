package Graphs.Question;

import java.util.Arrays;

public class BipartiteGraph {
    public static void main(String[] args) {

    }
    public  boolean isBipartite (int [][] graphs){
        int n = graphs.length;
        int [] color = new int[n];
        Arrays.fill(color,-1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1){
                if (dfs(color, i, graphs, 0 ) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs (int [] color,int i, int [][] graph, int col){
        color[i] = col;

        for (int adj : graph[i]){
            if (color[adj] == -1){
               if (dfs(color,adj, graph, col ^1) == false){
                   return false;
               }
            } else if (color[adj] == col) {
                return false;

            }

        }
        return true;

    }


}
