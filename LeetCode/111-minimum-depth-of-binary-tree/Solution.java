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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> dfs = new LinkedList<TreeNode>();
        dfs.add(root);        
        int depth = 1;
        while (!dfs.isEmpty()) {
            int queueSize = dfs.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = dfs.remove();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    dfs.add(node.left);
                if (node.right != null)
                    dfs.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}