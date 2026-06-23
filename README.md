# Low-Level-Design Java Practice Projects

Comprehensive collection of Low-Level Design (LLD) implementations in Java, demonstrating SOLID principles, design patterns, and system design concepts used in technical interviews.

## Projects

### Game Implementations
- **Chess**: Full chess game with piece movement validation, rules enforcement, and player management. Demonstrates inheritance, polymorphism, and strategy pattern.
- **SnakesAndLadder**: Complete board game with player tracking, dice rolling, and game state management. Shows state management and rules engine design.
- **TicTacToe**: Classic game with optimal winning strategy implementation. Illustrates strategy pattern and game logic.

### System Design & Distributed Systems
- **RateLimiter**: Two implementations of rate limiting algorithms:
  - Token Bucket: Efficient rate limiting with O(1) request handling
  - Sliding Window: Accurate request tracking with time-based eviction
  - Thread-safe with ReentrantLock for concurrent access

- **LRUCache**: Least Recently Used cache with O(1) get/put operations using HashMap + Doubly LinkedList. Demonstrates efficient eviction policies and cache optimization.

- **MessageQueue**: Thread-safe producer-consumer queue with blocking operations. Uses ReentrantLock and Condition variables for synchronization. Supports multiple producers/consumers.

- **ParkingLot**: Complete parking lot management system demonstrating:
  - Multi-level abstraction and state management
  - Thread-safe operations for concurrent vehicle parking/unparking
  - Fee calculation and spot allocation algorithms

## Design Patterns Covered
- Strategy Pattern (Chess, TicTacToe)
- State Pattern (Game controllers)
- Factory & Singleton patterns (implicit in managers)
- Observer patterns (event-driven updates)
- Thread-safe design with concurrent locks

## Prerequisites
- Java JDK 8+ (or any modern JDK)

## Build and Run

Each project is self-contained. From a project directory:

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

Or from the root directory:
```bash
cd RateLimiter && javac -d out src/*.java && java -cp out Main
```

## Example Output

### Rate Limiter
```
=== Token Bucket Rate Limiter Demo ===
Capacity: 5 requests/sec, Refill: every 1000ms

Request 1: ALLOWED ✓
Request 2: ALLOWED ✓
...
Request 6: REJECTED ✗
(After refill)
Request 7: ALLOWED ✓
```

### LRU Cache
```
=== LRU Cache Demo (Capacity: 3) ===
put("user:1", "Alice") → Cache size: 1
...
Adding user:4 (should evict user:2 as LRU)
```

### Message Queue
```
[ENQUEUE] Message-1 | Queue size: 1
[DEQUEUE] Message-1 | Queue size: 0
```

## Performance Characteristics

| Project | Time Complexity | Space Complexity | Key Feature |
|---------|-----------------|------------------|------------|
| RateLimiter (Token Bucket) | O(1) | O(1) | Efficient rate limiting |
| LRUCache | O(1) | O(capacity) | Optimal eviction |
| MessageQueue | O(1) | O(n) | Thread-safe blocking |
| ParkingLot | O(1) | O(n) | Concurrent access |

## Notes
- Most projects include thread-safety implementations suitable for production use
- Comprehensive inline documentation with Big-O complexity analysis
- IntelliJ `.iml` files included for IDE-based execution
- Ideal for interview preparation and understanding core CS concepts