class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode node = head;
        while (true) {
            int smallest = getSmallest(lists);
            if (smallest < 0) break;
            node.next = lists[smallest];
            lists[smallest] = lists[smallest].next;
            node = node.next;
        }
        return head.next;
    }

    private int getSmallest(ListNode[] lists) {
        int smallest = -1, value = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (lists[i].val < value) {smallest = i; value = lists[i].val;}
        }
        return smallest;
    }
}