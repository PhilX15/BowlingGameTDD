package tdd;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

	private Game g;

	@BeforeEach
	void setup() {
		g = new Game();
	}

	@Test
	void testSpareInTheLastFrame() {
		rollMany(BowlingGameConfig.MAX_THROW_NUMBER - 3, 0);

		rollSpare();
		g.roll(3);

		assertEquals(13, g.score());
	}

	@Test
	void testStrikeInTheLastFrame() {
		rollMany(BowlingGameConfig.MAX_THROW_NUMBER - 3, 0);

		rollStrike();
		g.roll(3);
		g.roll(5);

		assertEquals(18, g.score());
	}

	@Test
	void testTooManyRolls() {
		rollMany(BowlingGameConfig.MAX_THROW_NUMBER, 0);

		assertThrows(TooManyRollsException.class, () -> g.roll(0));
	}

	@Test
	void testRollMoreThanTenPins() {
		Game g = new Game();

		assertThrows(IllegalArgumentException.class, () -> g.roll(BowlingGameConfig.MAX_PIN_COUNT + 1));
	}

	@Test
	void testTooManyRollsAfterOnlyStrikes() {
		rollMany(12, 10);
		assertThrows(TooManyRollsException.class, () -> g.roll(0));
	}

	private void rollStrike() {
		g.roll(10);
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

	private void rollMany(int rolls, int pins) {
		for (int i = 0; i < rolls; i++) {
			g.roll(pins);
		}
	}
}