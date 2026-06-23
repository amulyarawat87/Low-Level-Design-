# LRU Cache

## Overview
A high-performance Least Recently Used (LRU) Cache implementation with O(1) time complexity for both get and put operations.

## Data Structure
- **HashMap**: Provides O(1) key lookups
- **Doubly Linked List**: Maintains insertion/access order for efficient LRU eviction

## How It Works

1. **Cache Hit** (key found):
   - Return value from HashMap
   - Move node to head (mark as most recently used)

2. **Cache Miss** (key not found):
   - Return null or default value

3. **Put with existing key**:
   - Update value in HashMap
   - Move node to head

4. **Put with new key**:
   - If capacity exceeded, remove tail node (least recently used)
   - Add new node to head (most recently used)

## Performance

| Operation | Time | Space |
|-----------|------|-------|
| get(key) | O(1) | O(1) |
| put(key, value) | O(1) | O(capacity) |
| Eviction | O(1) | - |

## Use Cases
- Browser caching (history)
- CPU cache management
- CDN caching strategies
- Database query caching
- Memoization in algorithms

## Key Design Decisions
- Doubly linked list for O(1) removal from any position
- Dummy head/tail nodes to eliminate null checks
- HashMap for O(1) access to nodes

## Building and Running

```bash
javac -d out src/*.java
java -cp out Main
```

## Example Output

```
=== LRU Cache Demo (Capacity: 3) ===

put("user:1", "Alice") → Cache size: 1
put("user:2", "Bob") → Cache size: 2
put("user:3", "Charlie") → Cache size: 3

Accessing user:1 (marks as recently used)
get("user:1") → Alice

Adding user:4 (should evict user:2 as LRU)
put("user:4", "David") → Cache size: 3

Trying to get evicted user:2
get("user:2") → null (evicted)
```

## Interview Tips
- Explain why HashMap + LinkedList is better than just HashMap
- Discuss tradeoffs between array vs linked list for maintenance
- Talk about why dummy nodes simplify edge cases
- Mention real-world applications (browser cache, CPU cache)
