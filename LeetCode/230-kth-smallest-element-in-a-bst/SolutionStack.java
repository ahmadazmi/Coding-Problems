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

class SolutionStack {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> treeStack = new Stack<>();
        while (k > 0) {
            if (root != null) {
                treeStack.push(root);
                root = root.left;
            }
            else {
                root = treeStack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
        }
        return -1;
    }
}