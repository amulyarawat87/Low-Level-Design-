public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Token Bucket Rate Limiter: 5 requests per second
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 1000);

        System.out.println("=== Token Bucket Rate Limiter Demo ===");
        System.out.println("Capacity: 5 requests/sec, Refill: every 1000ms\n");

        // Simulate 12 rapid requests
        for (int i = 1; i <= 12; i++) {
            boolean allowed = limiter.allowRequest();
            System.out.println("Request " + i + ": " + (allowed ? "ALLOWED ✓" : "REJECTED ✗"));
            
            if (i == 6) {
                System.out.println("\nWaiting 1.5 seconds for refill...\n");
                Thread.sleep(1500);
            }
        }

        System.out.println("\n=== Sliding Window Rate Limiter Demo ===");
        SlidingWindowRateLimiter slidingLimiter = new SlidingWindowRateLimiter(5, 1000);

        for (int i = 1; i <= 8; i++) {
            boolean allowed = slidingLimiter.allowRequest(System.currentTimeMillis());
            System.out.println("Request " + i + ": " + (allowed ? "ALLOWED ✓" : "REJECTED ✗"));
            
            if (i == 3) {
                System.out.println("\nWaiting 600ms...\n");
                Thread.sleep(600);
            }
        }
    }
}
