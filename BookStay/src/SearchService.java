public class SearchService {
    public void searchAvailableRooms(RoomInventory inventory, Map<String, Room> roomCatalog) {

        System.out.println("\nAvailable Rooms:\n");

        for (String roomType : roomCatalog.keySet()) {

            int availableCount = inventory.getAvailability(roomType);

            // Defensive check: only show available rooms
            if (availableCount > 0) {
                Room room = roomCatalog.get(roomType);

                room.displayDetails();
                System.out.println("Available Count: " + availableCount);
                System.out.println("-----------------------------");
            }
        }
    }
}
