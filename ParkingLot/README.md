# Parking Lot System Design

## Overview
A complete parking lot management system demonstrating multi-level design, state management, and thread-safe concurrent operations.

## System Design

### Core Components

1. **ParkingLot**: Main manager class
   - Manages parking spots (compact and large)
   - Tracks parked vehicles
   - Calculates fees
   - Thread-safe with ReentrantLock

2. **ParkingTicket**: Represents a parking session
   - Stores vehicle information
   - Tracks entry time for billing
   - Associates spot with vehicle

3. **VehicleType**: Enum for vehicle classifications
   - COMPACT: Requires 1 spot
   - LARGE: Requires 2 spots (can use large spots only)

## Features

### Parking Management
- **Park Vehicle**: Assign available spot based on vehicle type
- **Unpark Vehicle**: Free spot and calculate fee
- **Availability Tracking**: Real-time spot availability

### Fee Calculation
- Hourly rate: ₹50 per hour
- Calculated based on actual duration
- Supports fractional hours

### Thread Safety
- ReentrantLock for all operations
- Safe for concurrent park/unpark
- No race conditions on spot allocation

## Performance

| Operation | Time | Space |
|-----------|------|-------|
| parkVehicle() | O(1) | O(1) |
| unparkVehicle() | O(1) | O(1) |
| displayAvailability() | O(1) | - |
| Total Space | - | O(spots + vehicles) |

## Design Patterns Used

1. **State Management**: Tracks vehicle parking state
2. **Resource Pooling**: Manages limited parking spots
3. **Lock-Based Synchronization**: Thread-safe operations

## Extensibility

Can be extended to support:
- Multiple levels/floors
- Reserved spots
- Different vehicle types (motorcycles, handicapped)
- Online booking system
- Payment integration
- Dynamic pricing

## Building and Running

```bash
javac -d out src/*.java
java -cp out Main
```

## Example Output

```
=== Parking Lot Management System ===

✓ Vehicle KA01AB1234 parked at spot 1
✓ Vehicle MH02CD5678 parked at spot 1
✓ Vehicle KA01EF9012 parked at spot 2

[Availability] Compact: 3/5 | Large: 2/3

Simulating parked time (2 seconds = 2 hours for demo)...

✓ Vehicle KA01AB1234 unparked. Duration: 120min, Fee: ₹100.00
✓ Vehicle MH02CD5678 unparked. Duration: 120min, Fee: ₹100.00

[Availability] Compact: 4/5 | Large: 3/3
```

## Real-World Applications
- Parking management systems (ParkWhiz, SpotHero)
- Building access control
- Resource allocation in cloud systems
- Seat/ticket booking systems

## Interview Highlights
- Demonstrates multi-level abstraction
- Thread-safe design for real-world usage
- State management and tracking
- Fee/billing calculations
- Resource allocation algorithms
