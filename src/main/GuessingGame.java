import java.util.Random;


public class GuessingGame {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue;

        do {
            String input = System.console().readLine("Enter a number: ");
            if ("q".equals(input)) {
                return;
            }
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);
            loopShouldContinue = (output.contains("You git it") || output.contains("over") ? false : true);
        } while (loopShouldContinue);
    }

    private final int randomNumber = new Random().nextInt(10) + 1;
    private int counter = 0;

    public String guess(int guessedNumber) {
        counter++;
        String tryText = counter == 1 ? "try" : "tries";
        String winningMsg = String.format("You got it in %d %s", counter, tryText);
        String response = null;

        if (counter == 4 && guessedNumber != getRandomNumber()) {
            response = String.format("You didn't get it and you've had %d %s. Game Over!", counter, tryText);
        } else if (counter > 4 && guessedNumber != getRandomNumber()) {
            response = "Sorry, you are limited to only 4 tries. Your game is over!";
        } else {
            String tooLowHighText = null;
            if (guessedNumber < getRandomNumber()) {
                tooLowHighText = "- You're too low";
            } else if (guessedNumber > getRandomNumber()) {
                tooLowHighText = "- You're too high";
            } else {
                tooLowHighText = "";
            }
            String loseText = String.format("You didn't get it %s", tooLowHighText);
            response = guessedNumber == getRandomNumber() ? winningMsg : loseText;
        }
        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
