public class Main {
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);

        System.out.println("=== LRU Cache Demo (Capacity: 3) ===\n");

        // Add items
        cache.put("user:1", "Alice");
        System.out.println("put(\"user:1\", \"Alice\") → Cache size: " + cache.size());

        cache.put("user:2", "Bob");
        System.out.println("put(\"user:2\", \"Bob\") → Cache size: " + cache.size());

        cache.put("user:3", "Charlie");
        System.out.println("put(\"user:3\", \"Charlie\") → Cache size: " + cache.size());

        System.out.println("\nAccessing user:1 (marks as recently used)");
        System.out.println("get(\"user:1\") → " + cache.get("user:1"));

        System.out.println("\nAdding user:4 (should evict user:2 as LRU)");
        cache.put("user:4", "David");
        System.out.println("put(\"user:4\", \"David\") → Cache size: " + cache.size());

        System.out.println("\nTrying to get evicted user:2");
        System.out.println("get(\"user:2\") → " + cache.get("user:2") + " (evicted)");

        System.out.println("\nCurrent cache contains: user:1, user:3, user:4");
        System.out.println("get(\"user:1\") → " + cache.get("user:1"));
        System.out.println("get(\"user:3\") → " + cache.get("user:3"));
        System.out.println("get(\"user:4\") → " + cache.get("user:4"));
    }
}
