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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int runningSum) {
        if (node.left == null && node.right == null) return (runningSum*10)+node.val;
        int left = node.left == null ? 0 : sumNumbers(node.left, (runningSum*10)+node.val);
        int right = node.right == null ? 0 : sumNumbers(node.right, (runningSum*10)+node.val);
        return left+right;
    }
}