import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystem {
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
        initializeCredentials();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter login ID: ");
            String loginId = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            loggedIn = validateCredentials(loginId, password);

            if (!loggedIn) {
                System.out.println("Invalid login credentials. Please try again.");
            }
        }

        while (loggedIn) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Reservation System");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Logout");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    makeReservation(scanner);
                    break;

                case 2:
                    cancelReservation(scanner);
                    break;

                case 3:
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void initializeCredentials() {
        userCredentials.put("Janhavi", "pass4");
        userCredentials.put("user2", "password2");
    }

    private static boolean validateCredentials(String loginId, String password) {
        String storedPassword = userCredentials.get(loginId);
        return storedPassword != null && storedPassword.equals(password);
    }

    private static void makeReservation(Scanner scanner) {
        System.out.println("Reservation System");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        String trainName = getTrainName(trainNumber);

        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter from (place): ");
        String from = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        Reservation reservation = new Reservation(name, trainNumber, trainName, classType, dateOfJourney, from, destination);
        reservations.put(reservation.getPnrNumber(), reservation);

        System.out.println("Reservation successful. Your PNR number is: " + reservation.getPnrNumber());
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.println("Cancellation Form");
        System.out.print("Enter PNR number: ");
        String pnrNumber = scanner.nextLine();

        Reservation reservation = reservations.get(pnrNumber);

        if (reservation != null) {
            System.out.println("Reservation Details:");
            System.out.println(reservation);
            System.out.print("Are you sure you want to cancel this reservation? (Enter 'OK' to confirm): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("OK")) {
                reservations.remove(pnrNumber);
                System.out.println("Reservation successfully cancelled.");
            } else {
                System.out.println("Cancellation not confirmed.");
            }
        } else {
            System.out.println("No reservation found with the given PNR number.");
        }
    }

    private static String getTrainName(String trainNumber) {
        
		String trainName;

    switch (trainNumber) {
        case "123":
            trainName = "Shatabi Express";
            break;

        case "456":
            trainName = "Chennai Express";
            break;

        case "789":
            trainName = "Local Train";
            break;

        default:
            trainName = "RajDhani Express";
            break;
    }

    return trainName;
    }

    static class Reservation {
        private static int pnrCounter = 1;
        private String pnrNumber;
        private String name;
        private String trainNumber;
        private String trainName;
        private String classType;
        private String dateOfJourney;
        private String from;
        private String destination;

        public Reservation(String name, String trainNumber, String trainName, String classType, String dateOfJourney, String from, String destination) {
            this.pnrNumber = "PNR" + pnrCounter++;
            this.name = name;
            this.trainNumber = trainNumber;
            this.trainName = trainName;
            this.classType = classType;
            this.dateOfJourney = dateOfJourney;
            this.from = from;
            this.destination = destination;
        }

        public String getPnrNumber() {
            return pnrNumber;
        }

        @Override
        public String toString() {
            return "PNR: " + pnrNumber +
                    "\nName: " + name +
                    "\nTrain Number: " + trainNumber +
                    "\nTrain Name: " + trainName +
                    "\nClass Type: " + classType +
                    "\nDate of Journey: " + dateOfJourney +
                    "\nFrom: " + from +
                    "\nDestination: " + destination;
        }
    }
}
