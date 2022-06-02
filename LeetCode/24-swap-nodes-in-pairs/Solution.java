// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    // U: The problem wants us to swap every pair of nodes
    // M: This is a while-loop list node problem
    // P: We can create a while loop with the conidition "while (node.next != null)"
    //    This condition will let us take the current node and the next node then swap them
    //    Then, we go to the next pair by using "node = node.next.next"
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        // The new head is the head.next
        // But if there's only one node, then we simply return head
        if (head.next == null) return head;
        ListNode newHead = head.next;
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode thirdNode = head.next.next;
        while (firstNode != null && secondNode != null) {
            // Analogy: we have [1,2,3,4]
            // before: firstNode.next = 2, secondNode.next = 3
            // after: firstNode.next = 3, secondNode.next = 1
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            // since another node pair exists, firstNode must point to 4
            if (thirdNode == null || thirdNode.next == null) break;
            firstNode.next = thirdNode.next;
            // before: firstNode = 1, secondNode = 2, thirdNode = 3
            // after: firstNode = 3, secondNode = 4, thirdNode = null
            firstNode = thirdNode;
            secondNode = thirdNode.next;
            thirdNode = thirdNode.next.next;
        }
        return newHead;
    }
    // R: Solution works (passed all leetcode problems)
    // E: Space complexity is O(1) as we are not storing any data / new object
    //    Time complexity is O(n) because we traverse through the entire list once
}