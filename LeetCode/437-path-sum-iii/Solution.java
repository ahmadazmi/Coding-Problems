import java.util.*;

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
    public int pathSum(TreeNode root, int targetSum) {
        List<TreeNode> nodes = new ArrayList<>();
        pathSumTraversal(root, nodes);
        int pathSum = 0;
        for (TreeNode node : nodes)
            pathSum += pathSumHelper(node, 0, targetSum);
        return pathSum;
    }
    
    private void pathSumTraversal(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        nodes.add(root);
        pathSumTraversal(root.left, nodes);
        pathSumTraversal(root.right, nodes);
    }
    
    private int pathSumHelper(TreeNode root, int sum, int targetSum) {
        if (root == null) return 0;
        int numPaths = 0;
        if (root.val + sum == targetSum) numPaths++;
        numPaths = numPaths + pathSumHelper(root.left, sum+root.val, targetSum);
        numPaths = numPaths + pathSumHelper(root.right, sum+root.val, targetSum);
        return numPaths;
    }
}