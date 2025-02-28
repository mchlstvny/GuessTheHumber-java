import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Variables
        int numberToGuess, level, userGuess, attempts, score;
        String playAgain;

        // Set Up Input Scanner
        Scanner scanner = new Scanner(System.in);

        // Greetings
        System.out.println("Welcome to Guess the Number!");

        do {
            // Choose Difficulty (resets every time the player plays again)
            System.out.println("\n========== DIFFICULTY LEVELS ==========");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-200)");
            System.out.print("Choose your difficulty level: ");

            level = scanner.nextInt();

            // Adjust the range of the random number based on difficulty level
            if (level == 1) {
                numberToGuess = (int) (Math.random() * 50) + 1;
            } else if (level == 2) {
                numberToGuess = (int) (Math.random() * 100) + 1;
            } else if (level == 3) {
                numberToGuess = (int) (Math.random() * 200) + 1;
            } else {
                System.out.println("Invalid level. Defaulting to Medium.");
                numberToGuess = (int) (Math.random() * 100) + 1;
                level = 2; // Ensure correct score calculation
            }

            attempts = 0;

            // Game loop
            do {
                System.out.print("\nEnter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                }
            } while (userGuess != numberToGuess);

            // Score Calculation
            int baseScore, penalty;

            if (level == 1) { // Easy
                baseScore = 100;
                penalty = 3;
            } else if (level == 2) { // Medium
                baseScore = 150;
                penalty = 4;
            } else { // Hard
                baseScore = 200;
                penalty = 5;
            }

            /*      
            
                    1) Fewer attempts = Higher score
                    2) Each difficulty has a different penalty per attempt
                    3) Minimum score = 10, s it never goes negative

                                                                            */

            score = Math.max(baseScore - (attempts * penalty), 10);
            System.out.println("Your score: " + score);

            // Ask to play again
            System.out.print("Would you like to play again? (Y/N): ");
            playAgain = scanner.next().trim().toUpperCase();

        } while (playAgain.equalsIgnoreCase("Y")); // Restart the whole game if the player wants to play again

        System.out.println("\nThank you for playing! Goodbye!");

        // Close the scanner
        scanner.close();
    }
}
