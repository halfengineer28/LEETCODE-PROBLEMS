package POTD;

import javax.swing.tree.TreeCellRenderer;

public class SmallestSubtreewithalltheDeepestNodes {
    TreeNode ans;
    int maxdepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root){
        // find the depth of each Node;
        // check the level of the tree if level of both node is same
        // possibly root is our ans
        ans = null;
        maxdepth = -1;
        helper(root, 0);
        return ans;

    }
    public int helper(TreeNode root, int level){
        if (root == null){
            return 0;
        }

        int left = helper(root.left, level+1);
        int right = helper(root.right, level+1);

        if (left == right && (left + level >= maxdepth)){
            ans = root;
            maxdepth = left +  level;
        }
        return  1 +  Math.max(left, right);
    }
}
