class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (isBalancedHelper(root) == -1) return false;
        return true;
    }
    
    private int isBalancedHelper(TreeNode node) {
        if (node == null) return 0;
        int leftTreeHeight = isBalancedHelper(node.left);
        int rightTreeHeight = isBalancedHelper(node.right);
        if (leftTreeHeight == -1 || rightTreeHeight == -1) return -1;
        leftTreeHeight++; rightTreeHeight++;
        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) return -1;
        return leftTreeHeight > rightTreeHeight ? leftTreeHeight : rightTreeHeight;
    }
}