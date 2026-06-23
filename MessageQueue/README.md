# Message Queue (Producer-Consumer)

## Overview
A thread-safe, blocking message queue implementing the classic Producer-Consumer pattern using ReentrantLock and Condition variables.

## Synchronization Mechanism

### ReentrantLock
- Allows reentrant acquisition (same thread can acquire multiple times)
- More flexible than synchronized blocks

### Condition Variables
- `notEmpty`: Signaled when message added, wakes up waiting consumers
- `notFull`: Signaled when message removed, wakes up waiting producers

## How It Works

### Enqueue (Producer)
1. Acquire lock
2. While queue is full, wait on `notFull` condition
3. Add message to queue
4. Signal `notEmpty` to wake consumers
5. Release lock

### Dequeue (Consumer)
1. Acquire lock
2. While queue is empty, wait on `notEmpty` condition
3. Remove and return message from queue
4. Signal `notFull` to wake producers
5. Release lock

## Performance

| Operation | Time | Space |
|-----------|------|-------|
| enqueue() | O(1) | O(1) amortized |
| dequeue() | O(1) | O(1) amortized |
| Space Used | - | O(n) |

## Features
- Thread-safe for concurrent access
- Blocking semantics (producers wait if queue full, consumers wait if queue empty)
- Generic implementation (works with any type T)
- Supports multiple producers and consumers

## Use Cases
- Task scheduling systems (e.g., ThreadPool with work queue)
- Event processing pipelines
- Asynchronous request handling
- Decoupling producers from consumers
- Message brokers (simplified version of Kafka)

## Real-World Applications
- Java's BlockingQueue implementations
- Worker thread pools (Thread pool executor)
- Event streaming platforms (Kafka, RabbitMQ internally)
- Pub-Sub systems

## Building and Running

```bash
javac -d out src/*.java
java -cp out Main
```

## Example Output

```
=== Message Queue Demo (Capacity: 5) ===

Starting Producer and Consumer threads...

[ENQUEUE] Message-1 | Queue size: 1
[ENQUEUE] Message-2 | Queue size: 2
[DEQUEUE] Message-1 | Queue size: 1
[ENQUEUE] Message-3 | Queue size: 2
[DEQUEUE] Message-2 | Queue size: 1
...

✓ All messages processed!
```

## Key Interview Points
- Explain why lock.lock() and lock.unlock() vs synchronized
- Discuss spurious wakeups and why we use while() not if()
- Compare with Java's BlockingQueue
- Talk about deadlock prevention (always unlock in finally)
- Mention difference between Signal vs SignalAll
