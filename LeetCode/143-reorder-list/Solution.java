// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        int listLen = 0;
        ListNode node = head;
        // Find the lenth of the entire list
        while (node != null) {node = node.next; listLen++;}
        // Split list into l1 and l2, where l2 is the 2nd half of the list but in reverse
        ListNode l1Head = head;
        // Find tail of l2
        ListNode l2Tail;
        node = head;
        for (int i = 0; i < listLen/2; i++) node = node.next;
        l2Tail = node.next;
        node.next = null;
        // We have the "end" of l2, now we have to reverse this list
        node = l2Tail;
        ListNode prevNode = null;
        ListNode nextNode = l2Tail.next;
        while (nextNode != null) {
            ListNode dummyNode = node;
            node.next = prevNode;
            prevNode = dummyNode;
            node = nextNode;
            nextNode = nextNode.next;
        }
        node.next = prevNode;
        ListNode l2Head = node;
        
        ListNode l1Node = l1Head;
        ListNode l2Node = l2Head;
        while (l1Node != null && l2Node != null) {
            ListNode dummyl1Node = l1Node.next;
            ListNode dummyl2Node = l2Node.next;
            l1Node.next = l2Node;
            l2Node.next = dummyl1Node;
            l1Node = dummyl1Node;
            l2Node = dummyl2Node;
        }
    }
}