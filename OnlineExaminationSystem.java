import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineExaminationSystem {
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, String> userProfile = new HashMap<>();
    private static Map<String, Map<String, String>> mcqAnswers = new HashMap<>();
    private static final int EXAM_DURATION_MINUTES = 60;

    public static void main(String[] args) {
        initializeCredentials();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String currentUser = "";

        while (!loggedIn) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            loggedIn = validateCredentials(username, password);

            if (loggedIn) {
                currentUser = username;
                System.out.println("Login successful. Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        int option;
        do {
            displayMainMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    updateProfileAndPassword(scanner, currentUser);
                    break;

                case 2:
                    takeExam(scanner, currentUser);
                    break;

                case 3:
                    closeSession();
                    System.out.println("Logout successful. Goodbye, " + currentUser + "!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 3);

        scanner.close();
    }

    private static void initializeCredentials() {
        userCredentials.put("Janhavi", "pass4");
        userCredentials.put("user2", "password2");

        userProfile.put("Janhavi", "Janhavi SS, Janhavi4@gmail.com");
        userProfile.put("user2", "User2 Name, user2@example.com");

        mcqAnswers.put("Janhavi", new HashMap<>());
        mcqAnswers.put("user2", new HashMap<>());
    }

    private static boolean validateCredentials(String username, String password) {
        String storedPassword = userCredentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Update Profile and Password");
        System.out.println("2. Take Exam");
        System.out.println("3. Close Session and Logout");
        System.out.print("Select an option: ");
    }

    private static void updateProfileAndPassword(Scanner scanner, String username) {
        System.out.println("\nUpdate Profile and Password:");
        System.out.println("Current Profile: " + userProfile.get(username));
        System.out.print("Enter new profile information: ");
        String newProfile = scanner.nextLine();
        userProfile.put(username, newProfile);
        System.out.println("Profile updated successfully.");

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        userCredentials.put(username, newPassword);
        System.out.println("Password updated successfully.");
    }

    private static void takeExam(Scanner scanner, String username) {
        System.out.println("\nExam Instructions:");
        System.out.println("You have " + EXAM_DURATION_MINUTES + " minutes to complete the exam.");
        System.out.println("Answer the multiple-choice questions by entering the corresponding option number.");
        System.out.println("The exam will be automatically submitted once the time is up.");
        System.out.print("Press Enter to start the exam...");
        scanner.nextLine();

        // Start the timer
        long startTime = System.currentTimeMillis();
        long endTime = startTime + (EXAM_DURATION_MINUTES * 60 * 1000);

        while (System.currentTimeMillis() < endTime) {
            System.out.println("\nQuestion 1:When was Java First Introduced?");
            System.out.println("Options:");
            System.out.println("A. 1990");
            System.out.println("B. 1995");
            System.out.println("C. 2000");
            System.out.println("D. 2005");
            System.out.print("Enter your answer: ");
            int answer = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Store the answer for the user
            mcqAnswers.get(username).put("Question 1", String.valueOf(answer));
            System.out.println("\nQuestion 2: Which company developed Java?");
        System.out.println("Options:");
        System.out.println("A. Microsoft");
        System.out.println("B. Apple");
        System.out.println("C. IBM");
        System.out.println("D. Sun Microsystems");
        System.out.print("Enter your answer: ");
        String answer2 = scanner.nextLine().toUpperCase();
        scanner.nextLine(); // Consume the newline character

		// Store the answer for Question 2
		mcqAnswers.get(username).put("Question 2", answer2);

		System.out.println("\nQuestion 3: Which version of Java was the first official release?");
		System.out.println("Options:");
		System.out.println("A. Java 1.0");
		System.out.println("B. Java 2.0");
		System.out.println("C. Java 3.0");
		System.out.println("D. Java 4.0");
		System.out.print("Enter your answer: ");
		String answer3 = scanner.nextLine().toUpperCase();
		scanner.nextLine(); // Consume the newline character

		// Store the answer for Question 3
		mcqAnswers.get(username).put("Question 3", answer3);

		System.out.println("\nQuestion 4: Is Java a compiled language?");
		System.out.println("Options:");
		System.out.println("A. Yes");
		System.out.println("B. No");
		System.out.print("Enter your answer: ");
		String answer4 = scanner.nextLine().toUpperCase();
		scanner.nextLine(); // Consume the newline character

		// Store the answer for Question 4
		mcqAnswers.get(username).put("Question 4", answer4);

        System.out.println("\nExam time is up! Your answers have been automatically submitted.");
        break;
    }
        }
		

    private static void closeSession() {
        // Perform any necessary cleanup or session management tasks
    }
}
