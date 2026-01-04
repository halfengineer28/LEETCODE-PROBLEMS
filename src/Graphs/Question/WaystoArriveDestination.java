package Graphs.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Double {
    int node;
    long wt;
    public Double(int node, long wt){
        this.node = node;
        this.wt = wt;
    }
}


public class WaystoArriveDestination {
    public int  countPaths(int n, int[][] roads){
        int m = roads.length;
        // Create adjacent list for 2d matrix
       ArrayList<ArrayList<Double>> adj = new ArrayList<>();

       for(int i = 0; i < n; i++){
           adj.add(new ArrayList<>());
       }
        // bi-directional graphs
       for (int i = 0; i < m; i++){
           adj.get(roads[i][0]).add(new Double(roads[i][1], roads[i][2]));
           adj.get(roads[i][1]).add(new Double(roads[i][0], roads[i][2]));
       }
        // priority queue ways array and distance array for Dijkstra algo;
       int [] ways = new int [n];
       long [] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        PriorityQueue<Double> pq = new PriorityQueue<>((Double1, Double2) -> Long.compare(Double1.wt, Double2.wt));
        pq.add(new Double(0,0));
        dis[0] = 0;
        ways[0] = 1;
        int mod = 1000000007;
        while (!pq.isEmpty()){
            Double pair = pq.poll();
            int newnode = pair.node;
            long newdis = pair.wt;

            for (Double adjNode : adj.get(newnode)){
                int pathNode = adjNode.node;
                long pathwt = adjNode.wt;
                if (newdis + pathwt < dis[pathNode]){
                    dis[pathNode] = newdis + pathwt;
                    ways[pathNode] = ways[newnode];
                } else if (newdis + pathwt == dis[pathNode]) {
                    ways[pathNode] = (ways[pathNode] + ways[newnode]) % mod;

                }
            }

        }
       return ways[n-1] % mod;





    }
}
