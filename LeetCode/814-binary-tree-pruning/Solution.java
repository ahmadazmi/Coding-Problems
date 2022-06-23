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
    public TreeNode pruneTree(TreeNode root) {
        if (pruneTreeHelper(root) == false)
            return null;
        return root;
    }
    
    private boolean pruneTreeHelper(TreeNode node) {
        if (node == null) return false;
        boolean leftSubTree = pruneTreeHelper(node.left);
        boolean rightSubTree = pruneTreeHelper(node.right);
        if (!leftSubTree) node.left = null;
        if (!rightSubTree) node.right = null;
        return !(node.val == 0 && !leftSubTree && !rightSubTree);
    }
}