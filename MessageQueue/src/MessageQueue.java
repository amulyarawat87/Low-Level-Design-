import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * Thread-Safe Message Queue (Producer-Consumer)
 * 
 * Supports multiple producers and consumers with blocking operations.
 * Uses ReentrantLock and Condition variables for synchronization.
 * 
 * Time Complexity: O(1) for enqueue/dequeue
 * Space Complexity: O(n)
 */
public class MessageQueue<T> {
    private final int capacity;
    private final Queue<T> queue;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    // Producer: enqueues message, blocks if queue is full
    public void enqueue(T message) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= capacity) {
                notFull.await(); // Wait until queue has space
            }
            queue.add(message);
            System.out.println("[ENQUEUE] " + message + " | Queue size: " + queue.size());
            notEmpty.signalAll(); // Wake up waiting consumers
        } finally {
            lock.unlock();
        }
    }

    // Consumer: dequeues message, blocks if queue is empty
    public T dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // Wait until queue has messages
            }
            T message = queue.poll();
            System.out.println("[DEQUEUE] " + message + " | Queue size: " + queue.size());
            notFull.signalAll(); // Wake up waiting producers
            return message;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
