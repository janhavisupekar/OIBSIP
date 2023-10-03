import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("A random number between " + minNumber + " and " + maxNumber + " has been generated.");

        Random random = new Random();
        int generatedNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;

        Scanner scanner = new Scanner(System.in);

        boolean guessed = false;
        int attempts = 0;

        while (!guessed && attempts < maxAttempts) {
            System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
            int guess = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            attempts++;

            if (guess == generatedNumber) {
                guessed = true;
                score = maxAttempts - attempts + 1;
                System.out.println("Congratulations! You guessed the number correctly.");
            } else if (guess < generatedNumber) {
                System.out.println("The number is higher. Try again.");
            } else {
                System.out.println("The number is lower. Try again.");
            }
        }

        if (!guessed) {
            System.out.println("Sorry, you exceeded the maximum number of attempts.");
        }

        System.out.println("Game Over!");
        System.out.println("Your Score: " + score);
    }
}
