class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        int len = 0;
        while (node != null) {len++; node = node.next;}
        int[] values = new int[len];
        node = head;
        for (int i = 0; i < len; i++) {values[i] = node.val; node = node.next;}
        return constructBST(values, 0, len-1); 
    }

    private TreeNode constructBST(int[] values, int left, int right) {
        if (left > right) return null;
        int mid = (right+left)/2;
        return new TreeNode(values[mid], constructBST(values, left, mid-1), constructBST(values, mid+1, right));
    }
}