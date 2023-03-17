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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicates = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        dfs(root, count, duplicates);
        return duplicates;
    }
    
    private String dfs(TreeNode node, HashMap<String, Integer> count, List<TreeNode> duplicates) {
        if (node == null) return "";
        String left = dfs(node.left, count, duplicates);
        String right = dfs(node.right, count, duplicates);
        String hashed = node.val+">"+left+right;
        count.merge(hashed, 1, (a,b)->a+b);
        if (count.get(hashed) == 2) duplicates.add(node);
        return hashed;
    }
}