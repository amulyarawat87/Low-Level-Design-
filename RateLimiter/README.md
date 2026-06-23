# Rate Limiter

## Overview
Implements two popular rate limiting algorithms used in API gateways, microservices, and load balancers.

## Algorithms

### 1. Token Bucket
- **Concept**: Bucket maintains a fixed number of tokens. Each request consumes one token. Tokens are refilled at a constant rate.
- **Best For**: APIs with bursty traffic, allowing temporary spikes
- **Time Complexity**: O(1) per request
- **Space Complexity**: O(1)

**Pros**:
- Allows burst requests up to bucket capacity
- Simple and efficient
- Good for handling temporary spikes

**Cons**:
- Can allow short traffic bursts that exceed rate limit

### 2. Sliding Window
- **Concept**: Tracks request timestamps in a sliding time window. Rejects requests if count in last N milliseconds exceeds limit.
- **Best For**: Strict rate limiting with precise control
- **Time Complexity**: O(n) where n = requests in window
- **Space Complexity**: O(n)

**Pros**:
- More accurate rate limiting
- No burst allowance
- Precise per-second limits

**Cons**:
- Higher memory usage
- O(n) time complexity

## Use Cases
- API rate limiting (prevent abuse)
- DDoS protection
- Resource throttling
- Request batching

## Key Features
- Thread-safe implementation using ReentrantLock
- Configurable rate (requests per second)
- Configurable window size
- Real-time request tracking

## Building and Running

```bash
javac -d out src/*.java
java -cp out Main
```

## Example Output

```
=== Token Bucket Rate Limiter Demo ===
Request 1: ALLOWED ✓
Request 2: ALLOWED ✓
Request 3: ALLOWED ✓
Request 4: ALLOWED ✓
Request 5: ALLOWED ✓
Request 6: REJECTED ✗

Waiting 1.5 seconds for refill...

Request 7: ALLOWED ✓
```
