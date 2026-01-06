package POTD;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
    // do level order traversal while each level add the sum of each level
    // in variable compare it with previous sum if sum is greater
    // change ans to level and previous sum to sum of that level
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(Node root){
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int sum = Integer.MIN_VALUE;
        int ans = 1;

        while (!queue.isEmpty()){

            int size = queue.size();
            int adjSum = 0;

            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                adjSum += node.val;


                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (adjSum > sum){
                sum = adjSum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}
