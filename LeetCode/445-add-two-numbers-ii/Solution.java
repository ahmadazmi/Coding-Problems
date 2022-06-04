// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Len = 0, l2Len = 0;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        while (l1 != null) {l1Len++; l1 = l1.next;}
        while (l2 != null) {l2Len++; l2 = l2.next;}
        while (l1Len < l2Len) {
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = l1Head;
            l1Head = dummyNode;
            l1Len++;
        }
        while (l2Len < l1Len) {
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = l2Head;
            l2Head = dummyNode;
            l2Len++;
        }
        ListNode l3 = addTwoNumbersHelper(l1Head, l2Head);
        if (l3.val == 0) return l3.next;
        else return l3;
    }
    
    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return new ListNode(0);
        ListNode numSum = addTwoNumbersHelper(l1.next, l2.next);
        numSum.val = numSum.val + l1.val + l2.val;
        ListNode newNumSum = new ListNode(0);
        if (numSum.val > 9) {newNumSum.val = 1; numSum.val = numSum.val%10;}
        newNumSum.next = numSum;
        return newNumSum;
    }
}