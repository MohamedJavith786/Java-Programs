import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numberToGuess = random.nextInt(100) + 1;  // 1 to 100
        int numberOfTries = 5;
        int guess = 0;
        boolean hasWon = false;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100. You have " + numberOfTries + " tries.");

        for (int i = 1; i <= numberOfTries; i++) {
            System.out.print("Attempt " + i + ": Enter your guess: ");
            guess = scanner.nextInt();

            if (guess < 1 || guess > 100) {
                System.out.println("Please guess a number between 1 and 100.");
                i--; // don't count invalid input as an attempt
                continue;
            }

            if (guess < numberToGuess) {
                System.out.println("Too low! Try a higher number.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try a lower number.");
            } else {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("🎉 Congratulations! You guessed the number: " + numberToGuess);
        } else {
            System.out.println("❌ You've used all your tries. The correct number was: " + numberToGuess);
        }

        scanner.close();
    }
}
