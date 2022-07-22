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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] maxMoney = robDFS(root);
        return Math.max(maxMoney[0], maxMoney[1]);
    }
    
    private int[] robDFS(TreeNode root) {
        if (root.left == null && root.right == null) return new int[]{0, root.val};
        int[] left, right;
        if (root.left != null) left = robDFS(root.left);
        else left = new int[]{0,0};
        if (root.right != null) right = robDFS(root.right);
        else right = new int[]{0,0};
        return new int[]{Math.max(left[0],left[1])+Math.max(right[0],right[1]), left[0]+right[0]+root.val};
    }
}