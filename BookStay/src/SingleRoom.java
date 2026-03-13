public class SingleRoom extends Room {

        public SingleRoom() {
            super("Single Room", 1, 200, 3000);
        }

        @Override
        public void displayRoomDetails() {
            System.out.println("Room Type: " + getRoomType());
            System.out.println("Beds: " + getBeds());
            System.out.println("Size: " + getSize() + " sq ft");
            System.out.println("Price per night: ₹" + getPrice());
        }
    }

