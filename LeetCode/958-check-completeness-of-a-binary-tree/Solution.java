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

    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> bfs = new LinkedList<>();
        boolean lastFound = false;
        bfs.addLast(root);
        while (!bfs.isEmpty()) {
            int len = bfs.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = bfs.removeFirst();
                if (node.left == null) lastFound = true;
                else if (lastFound) return false;
                else bfs.addLast(node.left);
                if (node.right == null) lastFound = true;
                else if (lastFound) return false;
                else bfs.addLast(node.right);
            }
        }
        return true;
    }
}