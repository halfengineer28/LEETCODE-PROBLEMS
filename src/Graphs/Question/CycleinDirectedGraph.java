package Graphs.Question;

public class CycleinDirectedGraph {
    public static void main(String[] args) {

    }
    public boolean CycleDAG(int v, int [][] graph){
        int [] vis = new int[v];
        int [] path = new int[v];

        for (int i = 0; i < v; i++){
            if (vis[i] != 1) {
                if (dfs(graph, vis, path, i) == true) {
                    return true;
                }

            }
        }
        return false;
    }
    public boolean dfs(int [][] graph, int [] vis, int [] path, int i){
        vis[i] = 1;
        path[i] = 1;

        for ( int adj : graph[i]){
            if (vis[adj] != 1){
                if (dfs(graph, vis,path, adj) == true){
                    return true;
                };
            }else if (path[adj] == 1 ){
                return true;
            }
        }
        path[i] = 0;
        return false;
    }
}
