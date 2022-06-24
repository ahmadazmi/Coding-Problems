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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> largestValueEveryRow = new ArrayList<>();
        LinkedList<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            int maxValueThisRow = Integer.MIN_VALUE;
            int rowWidth = bfs.size();
            for (int i = 0; i < rowWidth; i++) {
                TreeNode node = bfs.poll();
                maxValueThisRow = Math.max(node.val, maxValueThisRow);
                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
            }
            largestValueEveryRow.add(maxValueThisRow);
        }
        return largestValueEveryRow;
    }
}