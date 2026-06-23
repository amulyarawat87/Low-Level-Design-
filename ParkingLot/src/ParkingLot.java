import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Parking Lot System Design
 * 
 * Manages parking spaces with different vehicle types.
 * Features:
 * - Assign/free parking spots based on vehicle type
 * - Calculate parking fees based on duration
 * - Thread-safe with ReentrantLock
 * 
 * Time Complexity: O(1) for park/unpark
 * Space Complexity: O(n)
 */
public class ParkingLot {
    private final int compactSpots;
    private final int largeSpots;
    private final Map<String, ParkingTicket> parkedVehicles;
    private final Deque<Integer> availableCompactSpots;
    private final Deque<Integer> availableLargeSpots;
    private final ReentrantLock lock = new ReentrantLock();
    private final double hourlyRate = 50.0; // INR per hour

    public enum VehicleType {
        COMPACT(1), LARGE(2);
        final int spotsNeeded;
        VehicleType(int spotsNeeded) { this.spotsNeeded = spotsNeeded; }
    }

    public ParkingLot(int compactSpots, int largeSpots) {
        this.compactSpots = compactSpots;
        this.largeSpots = largeSpots;
        this.parkedVehicles = new HashMap<>();
        this.availableCompactSpots = new LinkedList<>();
        this.availableLargeSpots = new LinkedList<>();

        for (int i = 1; i <= compactSpots; i++) {
            availableCompactSpots.push(i);
        }
        for (int i = 1; i <= largeSpots; i++) {
            availableLargeSpots.push(i);
        }
    }

    public ParkingTicket parkVehicle(String licensePlate, VehicleType type) {
        lock.lock();
        try {
            if (type == VehicleType.COMPACT && availableCompactSpots.isEmpty()) {
                System.out.println("❌ No compact spots available");
                return null;
            }
            if (type == VehicleType.LARGE && availableLargeSpots.isEmpty()) {
                System.out.println("❌ No large spots available");
                return null;
            }

            int spotNumber = (type == VehicleType.COMPACT) ? 
                availableCompactSpots.pop() : availableLargeSpots.pop();

            ParkingTicket ticket = new ParkingTicket(licensePlate, type, spotNumber);
            parkedVehicles.put(licensePlate, ticket);
            
            System.out.println("✓ Vehicle " + licensePlate + " parked at spot " + spotNumber);
            return ticket;
        } finally {
            lock.unlock();
        }
    }

    public double unparkVehicle(String licensePlate) {
        lock.lock();
        try {
            if (!parkedVehicles.containsKey(licensePlate)) {
                System.out.println("❌ Vehicle " + licensePlate + " not found");
                return -1;
            }

            ParkingTicket ticket = parkedVehicles.remove(licensePlate);
            long minutesParked = ChronoUnit.MINUTES.between(ticket.entryTime, LocalDateTime.now());
            double fee = (minutesParked / 60.0) * hourlyRate;

            if (ticket.type == VehicleType.COMPACT) {
                availableCompactSpots.push(ticket.spotNumber);
            } else {
                availableLargeSpots.push(ticket.spotNumber);
            }

            System.out.println("✓ Vehicle " + licensePlate + " unparked. Duration: " + 
                minutesParked + "min, Fee: ₹" + String.format("%.2f", fee));
            return fee;
        } finally {
            lock.unlock();
        }
    }

    public void displayAvailability() {
        lock.lock();
        try {
            System.out.println("\n[Availability] Compact: " + availableCompactSpots.size() + 
                "/" + compactSpots + " | Large: " + availableLargeSpots.size() + "/" + largeSpots);
        } finally {
            lock.unlock();
        }
    }

    private static class ParkingTicket {
        String licensePlate;
        VehicleType type;
        int spotNumber;
        LocalDateTime entryTime;

        ParkingTicket(String licensePlate, VehicleType type, int spotNumber) {
            this.licensePlate = licensePlate;
            this.type = type;
            this.spotNumber = spotNumber;
            this.entryTime = LocalDateTime.now();
        }
    }
}
