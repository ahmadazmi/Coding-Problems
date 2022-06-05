// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode node = head;
        ListNode prevNode = dummyHead;
        
        int seenVal = Integer.MIN_VALUE;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                seenVal = node.val;
                prevNode.next = node.next.next;
                node = node.next.next;
            }
            else if (node.val == seenVal) {
                prevNode.next = node.next;
                node = node.next;
            }
            else {
                prevNode = prevNode.next;
                node = node.next;
            }
        }
        if (node != null && node.val == seenVal) prevNode.next = null;
        return dummyHead.next;
    }
}