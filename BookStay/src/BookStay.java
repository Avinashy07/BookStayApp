import java.util.HashMap;
import java.util.Map;

public class BookStay {
public static void main(String args[]){

    RoomInventory inventory = new RoomInventory();
    inventory.addRoomType("Single", 10);
    inventory.addRoomType("Double", 0);  // intentionally unavailable
    inventory.addRoomType("Suite", 3);

    // Room catalog (domain model)
    Map<String, Room> roomCatalog = new HashMap<>();

    roomCatalog.put("Single", new Room("Single", 1000, "Bed, WiFi"));
    roomCatalog.put("Double", new Room("Double", 1800, "Bed, WiFi, TV"));
    roomCatalog.put("Suite", new Room("Suite", 3000, "Bed, WiFi, TV, Mini Bar"));

    // Guest triggers search
    SearchService searchService = new SearchService();
    searchService.searchAvailableRooms(inventory, roomCatalog);

    // Verify inventory is unchanged
    System.out.println("\nInventory After Search (unchanged):");
    inventory.displayInventory();
    }
}

