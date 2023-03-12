class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        int target = 0;
        ListNode node = head;
        while (node != null) {node = node.next; target++;}
        target = target - n - 1;
        if (target == -1) return head.next;
        node = head;
        while (target > 0) {node = node.next; target--;}
        node.next = node.next.next;
        return head;
    }
}