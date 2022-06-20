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

class AnotherSolution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> bfsLeft = new LinkedList<>();
        Queue<TreeNode> bfsRight = new LinkedList<>();
        if (root == null || root.left == root.right) return true;
        else if ((root.left != null && root.right == null) || (root.left == null && root.right != null))
            return false;
        else if (root.left.val != root.right.val) return false;
        
        bfsLeft.add(root.left);
        bfsRight.add(root.right);
        while (!bfsLeft.isEmpty() && !bfsRight.isEmpty()) {
            TreeNode nodeLeft = bfsLeft.remove();
            TreeNode nodeRight = bfsRight.remove();
            if (nodeLeft == nodeRight) continue;
            else if ((nodeLeft != null && nodeRight == null) || (nodeLeft == null && nodeRight != null))
                return false;
            else if (nodeLeft.val != nodeRight.val) return false;
            
            bfsLeft.add(nodeLeft.left);
            bfsLeft.add(nodeLeft.right);
            bfsRight.add(nodeRight.right);
            bfsRight.add(nodeRight.left);
        }
        return true;
    }
}