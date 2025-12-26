package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class  Pair {
    public int first;
    public  int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DijkstrasAlgorithm {

    public static void main(String[] args) {

    }
   public int [] Dijkstras(int [][] graph, int src, int V){
        // Create adjactent list
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       for (int i = 0; i < V; i++){
           adj.add(new ArrayList<>());
       }

       for (int [] e : graph){
           int u = e[0];
           int v = e[1];
           int wt = e[2];
           adj.get(u).add(new Pair(v, wt));
           adj.get(v).add(new Pair(u, wt));
       }
       // array to track distance from src fill the array with INTEGER.MAX_VALUE;
       int [] dis = new int [V];
       Arrays.fill(dis, Integer.MAX_VALUE);
       // mark src of dis to zero;
       dis[src] = 0;
       // priority queue for dijkstra to check minimum distance from src to each node;
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(src, 0));
       while (!pq.isEmpty()){
           Pair pair = pq.poll();
           int u = pair.first;
           int wt = pair.second;
           // search in adjacent elements
           for (Pair it : adj.get(u)){
               int x = it.first;
               int y = it.second;

               if(dis[x] > wt + y){
                   dis[x] = wt + y;
                   pq.add(new Pair(x, dis[x]));
               }

           }

       }
    return dis;

   }
}
