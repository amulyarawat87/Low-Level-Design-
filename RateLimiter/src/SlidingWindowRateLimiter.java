import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Sliding Window Rate Limiter
 * 
 * Tracks request timestamps in a sliding time window.
 * Requests are allowed only if count in last N milliseconds < limit.
 * More accurate than token bucket but higher memory usage.
 * 
 * Time Complexity: O(n) per request (n = requests in window)
 * Space Complexity: O(n)
 */
public class SlidingWindowRateLimiter {
    private final int maxRequests;
    private final long windowSize;     // Milliseconds
    private final Queue<Long> timestamps;
    private final ReentrantLock lock = new ReentrantLock();

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeMs) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSizeMs;
        this.timestamps = new LinkedList<>();
    }

    public boolean allowRequest(long currentTime) {
        lock.lock();
        try {
            // Remove old timestamps outside the window
            while (!timestamps.isEmpty() && timestamps.peek() < currentTime - windowSize) {
                timestamps.poll();
            }

            // Check if we can allow this request
            if (timestamps.size() < maxRequests) {
                timestamps.add(currentTime);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
