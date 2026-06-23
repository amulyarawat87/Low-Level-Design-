public class Main {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue<String> queue = new MessageQueue<>(5);

        System.out.println("=== Message Queue Demo (Capacity: 5) ===\n");

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 8; i++) {
                    queue.enqueue("Message-" + i);
                    Thread.sleep(500); // Simulate work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer-1");

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 8; i++) {
                    queue.dequeue();
                    Thread.sleep(1000); // Simulate processing
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer-1");

        System.out.println("Starting Producer and Consumer threads...\n");
        producer.start();
        Thread.sleep(100);
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("\n✓ All messages processed!");
    }
}
