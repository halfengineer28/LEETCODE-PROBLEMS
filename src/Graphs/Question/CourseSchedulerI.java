package Graphs.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedulerI {
    public static void main(String[] args) {

    }
    public boolean canFinish(int [][] prereq, int course){
        // create adj list from prereq matrix:
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < course; i++){
            adj.add(new ArrayList<>());

        }
        int m = prereq.length;
        for (int i = 0; i < m; i++){
            adj.get(prereq[i][0]).add(prereq[i][1]);
        }
        // Topo Sort using BFS
        int [] indegree = new int[course];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < course; i++) {
            for (int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for (int j = 0; j < course; j++){
            if(indegree[j] == 0){
                queue.add(j);

            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for (int it : adj.get(node)){
                indegree[it]--;
            }

        }
        return count == course;
    }
}
