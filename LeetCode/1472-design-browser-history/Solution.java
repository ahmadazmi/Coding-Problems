class BrowserHistory {
    class ListNode {
        String url;
        ListNode prev, next;
        private ListNode(String url) {this.url = url;}
    }

    ListNode page;

    public BrowserHistory(String homepage) {
        page = new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode visit = new ListNode(url);
        if (page.next != null) page.next.prev = null;
        page.next = visit;
        visit.prev = page;
        page = visit;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && page.prev != null) page = page.prev;
        return page.url;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && page.next != null) page = page.next;
        return page.url;
    }
}