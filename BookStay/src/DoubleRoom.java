
public class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 350, 5000);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Beds: " + getBeds());
        System.out.println("Size: " + getSize() + " sq ft");
        System.out.println("Price per night: ₹" + getPrice());
    }
}
