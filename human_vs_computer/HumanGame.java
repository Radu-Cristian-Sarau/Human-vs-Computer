import java.util.Random;
import java.util.Scanner; // For Scanner, Random, etc.

/** 
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author Horia-George Dună
 * @id     1949284
 * @author Radu-Cristian Sarău
 * @id     1939149
 * @data   12-Sep-2023
 */
public class HumanGame {
    Scanner scanner = new Scanner(System.in);
    Random randomGenerator;
    
    /**
    * This method determines whether the player guessed the right code or reached the maximum number
    of guesses, losing the game.
    * @param guess is an int variable which stores the user's last guess
    * @param code is an int variable which stores the right answer
    * @param guessCount is an int variable which stores the amount of guesses made
    */
    void result(int guess, int code, int guessCount) {
        if (guess == code) {
            System.out.println("Good guess! You won.");
        } else if (guessCount == 7) {
            System.out.println("No more guesses, you lost.");
        }
    }
    
    /**
     * guessingHistory is a method that prints the guessing history of the game, as a line with
     * symbols for the guesses made by the user ("X") and the code ("|").
     * @param guessList is an array which stores the user's guesses
     * @param code is the random int number the user has to guess
     * @param guessCount is an int variable which counts how many guesses were made
     */
    void guessingHistory(int[] guessList, int code, int guessCount) {
        String dots = ".................................................."; //50 dots
        dots = dots + dots; //100 dots
        guessCount++; //we increment because we start counting guesses from 0
        
        System.out.println(guessCount + " guesses:");

        for (int i = 0; i < guessCount; i++) {
            if (guessList[i] < code) {
                System.out.println(dots.substring(0, guessList[i] - 1) 
                    + "X" + dots.substring(guessList[i] + 1, code) + "|"
                    + dots.substring(code + 1));

            } else if (guessList[i] > code) {
                System.out.println(dots.substring(0, code - 1) + "|" 
                    + dots.substring(code + 1, guessList[i]) + "X"
                    + dots.substring(guessList[i] + 1));

            } else {
                System.out.println(dots.substring(0, code - 1) + "X" 
                    + dots.substring(code + 1));
            } 
        }
    }

    void run() {
        long seed;
        int code;
        int guessCount = 0;
        int guess;
        int[] guessList = {0, 0, 0, 0, 0, 0, 0};

        System.out.println("Type an arbitrary number");
        seed = scanner.nextLong();
        randomGenerator = new Random(seed);
        
        code = randomGenerator.nextInt(100);
        
        System.out.println("Start guessing!");

        guess = scanner.nextInt();
        guessList[0] = guess;

        while (guess != code && guessCount < 7) {
            if (guess > code) {
                System.out.println("lower");
                guessCount++;
                guess = scanner.nextInt();
                guessList[guessCount] = guess;
                
            } else if (guess < code) {
                System.out.println("higher");
                guessCount++;
                guess = scanner.nextInt();
                guessList[guessCount] = guess;
            }
        }

        result(guess, code, guessCount);

        guessingHistory(guessList, code, guessCount);
    }

    public static void main(String[] args) {
        new HumanGame().run();
    }
}
