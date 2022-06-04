// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        /* O(nm) solution
        while (nodeA != null) {
            nodeB = headB;
            while (nodeB != null) {
                if (nodeA == nodeB) return nodeA;
                nodeB = nodeB.next;
            }
            nodeA = nodeA.next;
        }
        return null;
        */
        
        // O(n+m) solution
        while (nodeA != nodeB) {
            if (nodeA == null) nodeA = headB;
            else nodeA = nodeA.next;
            if (nodeB == null) nodeB = headA;
            else nodeB = nodeB.next;
        }
        return nodeA;
    }
}