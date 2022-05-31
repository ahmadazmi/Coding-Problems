/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode traverseOneNode = head;
        ListNode traverseTwoNode = head;
        while (traverseTwoNode != null && traverseTwoNode.next != null) {
            traverseOneNode = traverseOneNode.next;
            traverseTwoNode = traverseTwoNode.next.next;
            if (traverseOneNode == traverseTwoNode) return true;
        }
        return false;
    }
}