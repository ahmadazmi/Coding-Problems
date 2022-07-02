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

class BSTIterator {
    LinkedList<TreeNode> bstTraversal;
    
    public BSTIterator(TreeNode root) {
        bstTraversal = new LinkedList<>();
        bstIteratorConstructor(root);
    }
    
    private void bstIteratorConstructor(TreeNode node) {
        if (node == null) return;
        bstIteratorConstructor(node.left);
        bstTraversal.add(node);
        bstIteratorConstructor(node.right);
    }
    
    public int next() {
        return bstTraversal.remove().val;
    }
    
    public boolean hasNext() {
        return !bstTraversal.isEmpty();
    }
}