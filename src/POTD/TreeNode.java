package POTD;

public class TreeNode {

        int val;
        POTD.TreeNode left;
        POTD.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, POTD.TreeNode left, POTD.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

}
