
public class BookStay {
public static void main(String args[]){


        System.out.println("====================================");
        System.out.println(" Book My Stay - Hotel Booking System");
        System.out.println(" Version 2.1");
        System.out.println("====================================\n");

        // Creating Room Objects using polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailability = 10;
        int doubleRoomAvailability = 7;
        int suiteRoomAvailability = 3;

        // Display room information

        System.out.println("Single Room Details:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailability);
        System.out.println();

        System.out.println("Double Room Details:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailability);
        System.out.println();

        System.out.println("Suite Room Details:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailability);
        System.out.println();

        System.out.println("Application execution completed.");
    }
}

