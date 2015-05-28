import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    public void testGutterGame() throws Exception {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }


    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    public void testSpare() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        assertEquals(16, game.score());
    }

    @Test
    public void testStrike() throws Exception {
        rollStrike();
        game.roll(4);
        game.roll(3);
        rollMany(16, 0);

        assertEquals(24, game.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);

        assertEquals(300, game.score());

    }
}