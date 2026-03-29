import java.util.*;

// Reservation class
class Reservation {
    String reservationId;
    String customerName;
    String roomType;

    public Reservation(String reservationId, String customerName, String roomType) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return reservationId + " | " + customerName + " | " + roomType;
    }
}

public class UseCase10BookingCancellation {

    // Active reservations
    private static Map<String, Reservation> activeBookings = new HashMap<>();

    // Booking history (for tracking)
    private static List<String> bookingHistory = new ArrayList<>();

    // Inventory
    private static Map<String, Integer> inventory = new HashMap<>();

    // Stack for rollback (LIFO)
    private static Stack<String> rollbackStack = new Stack<>();

    public static void main(String[] args) {

        // Initialize inventory
        inventory.put("DELUXE", 1);
        inventory.put("SUITE", 1);

        // Simulate confirmed bookings
        Reservation r1 = new Reservation("DEL-1", "Avinash", "DELUXE");
        Reservation r2 = new Reservation("SUI-2", "Ravi", "SUITE");

        addBooking(r1);
        addBooking(r2);

        // Perform cancellations
        cancelBooking("DEL-1");  // valid
        cancelBooking("DEL-1");  // duplicate cancel (should fail)
        cancelBooking("XXX-9");  // non-existent (should fail)

        // Final state
        displayState();
    }

    // Add booking (simulate confirmed booking)
    private static void addBooking(Reservation r) {
        activeBookings.put(r.reservationId, r);

        // Reduce inventory
        inventory.put(r.roomType, inventory.get(r.roomType) - 1);

        bookingHistory.add("CONFIRMED: " + r.reservationId);
    }

    // Cancel booking with rollback
    private static void cancelBooking(String reservationId) {

        System.out.println("\nAttempting cancellation for: " + reservationId);

        // Validate existence
        if (!activeBookings.containsKey(reservationId)) {
            System.out.println("Cancellation FAILED: Reservation does not exist.");
            return;
        }

        // Get reservation
        Reservation r = activeBookings.get(reservationId);

        // Step 1: Push to rollback stack
        rollbackStack.push(reservationId);

        // Step 2: Restore inventory
        inventory.put(r.roomType, inventory.get(r.roomType) + 1);

        // Step 3: Remove active booking
        activeBookings.remove(reservationId);

        // Step 4: Update history
        bookingHistory.add("CANCELLED: " + reservationId);

        System.out.println("Cancellation SUCCESS for " + reservationId);
    }

    // Display system state
    private static void displayState() {
        System.out.println("\n--- Active Bookings ---");
        for (Reservation r : activeBookings.values()) {
            System.out.println(r);
        }

        System.out.println("\n--- Inventory ---");
        for (String type : inventory.keySet()) {
            System.out.println(type + " -> " + inventory.get(type));
        }

        System.out.println("\n--- Rollback Stack (Recent Cancels) ---");
        System.out.println(rollbackStack);

        System.out.println("\n--- Booking History ---");
        for (String h : bookingHistory) {
            System.out.println(h);
        }
    }
}
