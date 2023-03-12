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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root.val == subRoot.val && checkTree(root, subRoot)) return true;
        if (root.left != null) if (isSubtree(root.left, subRoot)) return true;
        if (root.right != null) if (isSubtree(root.right, subRoot)) return true;
        return false;
    }

    private boolean checkTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return root.val == subRoot.val && checkTree(root.left, subRoot.left) && checkTree(root.right, subRoot.right);
    }
}