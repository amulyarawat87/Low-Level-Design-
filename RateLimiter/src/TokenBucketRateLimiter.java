import java.util.concurrent.locks.ReentrantLock;

/**
 * Token Bucket Rate Limiter
 * 
 * Maintains a bucket of tokens. Each request consumes one token.
 * Tokens are refilled at a fixed rate (e.g., 5 tokens per second).
 * If bucket is full, new requests are rejected until tokens are available.
 * 
 * Time Complexity: O(1) per request
 * Space Complexity: O(1)
 */
public class TokenBucketRateLimiter {
    private final int capacity;        // Max tokens in bucket
    private final long refillInterval; // Milliseconds between refills
    private final int tokensPerRefill; // Tokens added on each refill
    
    private double currentTokens;
    private long lastRefillTime;
    private final ReentrantLock lock = new ReentrantLock();

    public TokenBucketRateLimiter(int capacity, long refillIntervalMs) {
        this.capacity = capacity;
        this.refillInterval = refillIntervalMs;
        this.tokensPerRefill = 1;
        this.currentTokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        lock.lock();
        try {
            refillTokens();
            
            if (currentTokens >= 1) {
                currentTokens--;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    private void refillTokens() {
        long now = System.currentTimeMillis();
        long timePassed = now - lastRefillTime;
        
        // Calculate how many refill cycles have passed
        long refillCycles = timePassed / refillInterval;
        if (refillCycles > 0) {
            currentTokens = Math.min(capacity, currentTokens + refillCycles * tokensPerRefill);
            lastRefillTime = now;
        }
    }
}
