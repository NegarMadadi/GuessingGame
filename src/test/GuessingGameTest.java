import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);
        assertEquals("You got it", message);
    }

    @Test
    public void testOneWrongNegGuessSituation() {
        String message = game.guess(-5);
        assertEquals("You didn't get it", message);
    }

    @Test
    public void testOneWrongPosSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1);
        assertEquals("You didn't get it", message);
    }

    @Test
    public void testRandomNumberSituation() {
        // 1 2 3 4 5 6 7 8 9 10
        // 1 1 1 1 0 1 0 1 1 1  = 10
        int[] randomNumCount = new int[11];
        for (int counter = 0; counter < 100; counter++) {
            int randomNum = game.getRandomNumber();
            randomNumCount[randomNum] = 1;
        }
        int sum = 0;
        for (int counter = 0; counter < 10; counter++) {
            sum += randomNumCount[counter];
        }
        assertEquals(10, sum);
    }
}
