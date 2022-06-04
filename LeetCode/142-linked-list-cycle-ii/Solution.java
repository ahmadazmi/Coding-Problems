import java.util.HashSet;
import java.util.Set;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> listSet = new HashSet<ListNode>();
        while (head != null) {
            if (listSet.contains(head)) return head;
            else listSet.add(head);
            head = head.next;
        }
        return null;
    }
}