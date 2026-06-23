public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = new ParkingLot(5, 3);

        System.out.println("=== Parking Lot Management System ===\n");

        // Park some vehicles
        lot.parkVehicle("KA01AB1234", ParkingLot.VehicleType.COMPACT);
        lot.parkVehicle("MH02CD5678", ParkingLot.VehicleType.LARGE);
        lot.parkVehicle("KA01EF9012", ParkingLot.VehicleType.COMPACT);
        lot.displayAvailability();

        System.out.println("\nSimulating parked time (2 seconds = 2 hours for demo)...");
        Thread.sleep(2000);

        // Unpark vehicles
        lot.unparkVehicle("KA01AB1234");
        lot.unparkVehicle("MH02CD5678");
        lot.displayAvailability();

        // Park more vehicles
        System.out.println("\nParking additional vehicles...");
        lot.parkVehicle("KA04GH3456", ParkingLot.VehicleType.LARGE);
        lot.parkVehicle("MH05IJ7890", ParkingLot.VehicleType.COMPACT);
        lot.displayAvailability();
    }
}
