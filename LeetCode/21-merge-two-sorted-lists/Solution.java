// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode head = new ListNode();
        ListNode dummyNode = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummyNode.next = list1;
                list1 = list1.next;
            } else {
                dummyNode.next = list2;
                list2 = list2.next;
            }
            dummyNode = dummyNode.next;
        }
        
        if (list1 == null) dummyNode.next = list2;
        else dummyNode.next = list1;
        
        return head.next;
    }
}