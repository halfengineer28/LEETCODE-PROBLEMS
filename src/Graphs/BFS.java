import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class BFS {
    public static void main(String[] args) {

    }
//    : Given an undirected graph, return a list of all nodes by traversing the graph using breadth-first search (BFS)

    public List<Integer> BreadthforSearch (List<List<Integer>> adj){
        // size of adj list for all elements
        int v = adj.size();
        // ArrayList for adding all node
        List<Integer> ans = new ArrayList<>();
        // boolean array to track all nodes
        boolean [] vis = new boolean[v];

        // queue for checking adj one by one
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);

            for (Integer it : adj.get(node)){
                // checking if adjacent of given node is already visited or not if not adding it to queue;
                if (vis[it] == false){
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }
        return ans;
    }
    // BFS for a single connected component

    public List<Integer> BreadthforSearchSCC (List<List<Integer>> adj){
        int v = adj.size();
        boolean [] vis = new boolean[v];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < v; i++){
            if (!vis[i]){
                bfs(vis, i,ans, adj );
            }
        }
        return ans;
    }
    public  void bfs (boolean[] vis, int src, List<Integer>ans, List<List<Integer>> adj){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;

        while (!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);

            for (Integer it : adj.get(node)){
                if (!vis[it]){
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }

    }
}