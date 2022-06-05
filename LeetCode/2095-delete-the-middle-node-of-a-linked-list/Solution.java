// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slowNode = dummyHead;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {slowNode = slowNode.next; fastNode = fastNode.next.next;}
        slowNode.next = slowNode.next.next;
        return head;
    }
}