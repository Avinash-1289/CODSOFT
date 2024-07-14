import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int totalRounds = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("Guess a number between 1 and 100:");

            while (attempts < maxAttempts) {
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + numberToGuess);
            }

            totalRounds++;
            totalAttempts += attempts;

            System.out.print("Do you want to play again? (y/n): ");
            String choice = scanner.next();
            playAgain = choice.equalsIgnoreCase("y");
        }

        scanner.close();

        System.out.println("\nGame over!");
        System.out.println("You played " + totalRounds + " rounds with an average of " + (double) totalAttempts / totalRounds + " attempts per round.");
    }
}
