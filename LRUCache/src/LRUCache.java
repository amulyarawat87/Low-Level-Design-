import java.util.*;

/**
 * LRU (Least Recently Used) Cache
 * 
 * Maintains a fixed-size cache with O(1) get/put operations.
 * Evicts least recently used item when capacity exceeded.
 * Implemented using HashMap + Doubly LinkedList for efficient operations.
 * 
 * Time Complexity: O(1) for get() and put()
 * Space Complexity: O(capacity)
 */
public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private Node<K, V> head; // Most recently used
    private Node<K, V> tail; // Least recently used

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node<>(null, null); // Dummy head
        this.tail = new Node<>(null, null); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Node<K, V> node = cache.get(key);
        moveToHead(node); // Mark as recently used
        return node.value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                evictLRU(); // Evict least recently used
            }
            Node<K, V> newNode = new Node<>(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void evictLRU() {
        Node<K, V> lru = tail.prev;
        removeNode(lru);
        cache.remove(lru.key);
    }

    public int size() {
        return cache.size();
    }
}
