import java.util.concurrent.atomic.AtomicLong;

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, new AtomicLong(Long.MIN_VALUE));
    }
    
    private boolean isValidBST(TreeNode root, AtomicLong lastVal) {
        if (root == null) return true;
        boolean leftSubtree = isValidBST(root.left, lastVal);
        if (root.val <= lastVal.get()) return false;
        lastVal.set(root.val);
        boolean rightSubtree = isValidBST(root.right, lastVal);
        return leftSubtree && rightSubtree;
    }
    
}