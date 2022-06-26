import java.util.concurrent.atomic.*;

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
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, k, new AtomicInteger(1));
    }
    
    private int kthSmallest(TreeNode root, int k, AtomicInteger i) {
        if (root == null) return -1;
        int ret = kthSmallest(root.left, k, i);
        if (ret > -1) return ret;
        else if (i.getAndIncrement() == k) return root.val;
        ret = kthSmallest(root.right, k, i);
        if (ret > -1) return ret;
        return -1;
    }
}