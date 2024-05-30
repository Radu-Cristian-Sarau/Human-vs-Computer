import java.util.Scanner;

/**
 * Simple number guessing game for computers.
 * 
 * Think of a number and type "go". Your computer starts guessing
 * your number. Reply "lower" when the guess is too high, "higher" 
 * when it is too low, and "guessed" when the computer guessed
 * your number correctly.
 * 
 * @author Horia-George Dună
 * @id     1949284
 * @author Radu-Cristian Sarău
 * @id     1939149
 * @data   14/09/2023
 */
public class ComputerGame {
    Scanner scanner = new Scanner(System.in);

    /**
     * giveUp is a method that checks whether or not the computer failed in guessing the number.
     * If so, "I give up" is printed in the terminal.
     * 
     * @param computerGuesses is an integer that keeps count of the number of guesses 
     *     the computer made
     * @param guessed is a boolean  variable that is true when the computer guessed the code
     * 
     */
    
    void giveUp(int computerGuesses, boolean guessed) {
        
        if (computerGuesses == 10 && !guessed) {
            System.out.println("I give up");
        }
        
    }

    void run() {
        
        String answer;

        //define the interval [0, 999]
        int marginLeft = 0;
        int marginRight = 999;
        int middle;
        
        //used to keep count of the number of guesses the computer made
        int computerGuesses = 0;

        //determines whether the computer guessed the code or not
        boolean guessed = false;
        
        System.out.println("Think of a secret number not "
            + "smaller than 0 and not greater than 999. Type 'go' when you have one.");
        
        answer = scanner.nextLine(); //waits for "go"

        //the game starts
        while (!guessed && computerGuesses < 10) {
            
            //calculate the middle of the interval
            middle = (marginLeft + marginRight  + 1) / 2;
           
            System.out.println(middle);
            answer = scanner.nextLine();
            
            //increases the number of guesses made by the computer after each guess
            computerGuesses++;
            
            //the interval is constantly updated
            if ("lower".equals(answer)) {
                marginRight = middle - 1; 
            } else if ("higher".equals(answer)) {
                marginLeft = middle + 1;
            } else {
                guessed = true;
            }
        }

        //called in case the computer loses the game
        giveUp(computerGuesses, guessed);
    }

    public static void main(String[] args) {
        new ComputerGame().run();
    }
}
