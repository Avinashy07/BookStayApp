public class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 600, 9000);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Beds: " + getBeds());
        System.out.println("Size: " + getSize() + " sq ft");
        System.out.println("Price per night: ₹" + getPrice());
    }
}
