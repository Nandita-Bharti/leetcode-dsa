import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    // Define the Doubly Linked List Node structure
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        // Mark as most recently used by moving it to the front
        remove(node);
        insertToFront(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        // If key already exists, update its value and move to front
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToFront(node);
            return;
        }
        
        // If capacity is reached, evict the least recently used item (node right before tail)
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        
        // Create new node and add it to the front (most recently used)
        Node newNode = new Node(key, value);
        insertToFront(newNode);
        map.put(key, newNode);
    }
    
    // --- Helper Methods for Doubly Linked List ---
    
    // Remove a node from its current position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Insert a node right after the dummy head (making it the Most Recently Used)
    private void insertToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */