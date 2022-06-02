// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    // U: Problem requires us to send last k nodes to the beginning of the list
    // M: This problem is similar to changing node.next pointer
    // P: A possible solution would be to find the length of the list by traversing
    //    the list once. And once we reach the final node, we make it point to head.
    //    Now, we traverse the list again, but only go through length-k-1 nodes, so that
    //    we reach the kth+1 node from last, then we make it point to null.
    //    Finally, we return the new head.
    // I:
    public ListNode rotateRight(ListNode head, int k) {
        // If no rotation or list is empty or has only one node, return head
        if (k <= 0 || head == null || head.next == null) return head;
        // Find length of list
        int listLen = 0;
        ListNode lastNode = head;
        // Get to the last node, while finding length of list
        while (lastNode.next != null) {listLen++; lastNode = lastNode.next;}
        listLen++;
        lastNode.next = head;
        // If k > listLen then the rotation would be the same as k%listLen
        k = k%listLen;
        
        ListNode lastKthNode = head;
        for (int i = 0; i < listLen-k-1; i++) lastKthNode = lastKthNode.next;
        ListNode newHead = lastKthNode.next;
        lastKthNode.next = null;
        
        return newHead;
    }
    // R: The code passes all leetcode test cases...
    // E: Space complexity is O(1) since we are not storing any new data
    //    Time complexity is O(n) since we have to traverse the entire node list at least once
}