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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelTraversal = new ArrayList<List<Integer>>();
        if (root == null) return levelTraversal;
        LinkedList<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelWidth = bfs.size();
            for (int i = 0; i < levelWidth; i++) {
                TreeNode node = bfs.remove();
                level.add(node.val);
                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
            }
            levelTraversal.add(level);
        }
        return levelTraversal;
    }
}