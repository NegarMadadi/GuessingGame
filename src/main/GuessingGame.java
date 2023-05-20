import java.util.Random;

public class GuessingGame {

    public String guess(int guessedNumber) {

        return guessedNumber == getRandomNumber() ? "You got it" : "You didn't get it";
    }

    public int getRandomNumber() {
        int randomNumber = 0;
        return randomNumber;
    }
}
