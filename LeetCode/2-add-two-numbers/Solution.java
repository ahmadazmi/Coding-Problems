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
        int sum = 0, rem = 0, carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode l3Head = l3;
        while (l1 != null || l2 != null) {
            sum = l3.val;
            if (l1 != null) {sum += l1.val; l1 = l1.next;}
            if (l2 != null) {sum += l2.val; l2 = l2.next;}
            rem = sum%10;
            carry = sum/10;
            l3.val = rem;
            if (carry > 0 || l1 != null || l2 != null) l3.next = new ListNode(carry);
            l3 = l3.next;
        }        
        return l3Head;
    }
}