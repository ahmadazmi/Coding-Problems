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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSumHelper(root, targetSum, 0);
    }
    
    private boolean hasPathSumHelper(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return false;
        currentSum += node.val;
        if (node.left == null && node.right == null) return targetSum == currentSum;
        return (hasPathSumHelper(node.left, targetSum, currentSum)
            || hasPathSumHelper(node.right, targetSum, currentSum));
        
    }
}