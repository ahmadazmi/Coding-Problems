class Node {
    Node next, prev;
    int key, value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node head; // Serves as a sentinel node
    Node tail; // Serves as a sentinel node
    int capacity, current_capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        current_capacity = 0;
    }
    
    private void sendToBack(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    private void addNode(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        sendToBack(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            sendToBack(node);
        }
        else {
            if (current_capacity == capacity) {
                Node node = new Node(key, value);
                addNode(node);
                map.remove(head.next.key);
                head.next.next.prev = head;
                head.next = head.next.next;
                map.put(key, node);
            }
            else {
                Node node = new Node(key, value);
                addNode(node);
                map.put(key, node);
                current_capacity++;
            }
        }        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */