import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    Random numgen;
    ListNode head;
    int len;
    int[] list;

    public Solution(ListNode head) {
        this.numgen = new Random();
        this.head = head;
        this.len = 0;
        ListNode node = this.head;
        while (node != null) {this.len++; node = node.next;}
        this.list = new int[this.len];
        node = this.head;
        int i = 0;
        while (node != null) {this.list[i++] = node.val; node = node.next;}
    }
    
    public int getRandom() {
        int pick = this.numgen.nextInt(len);
        return this.list[pick];
    }
}