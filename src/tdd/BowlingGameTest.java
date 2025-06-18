package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BowlingGameTest {
	
	@Test
	void testSpareInTheLastFrame() {
		Game g = new Game();
		
		for (int i = 0; i < 18; i++) {
			g.roll(0);
		}
		
		g.roll(5);
		g.roll(5);
		g.roll(3);
		
		assertEquals(13, g.score());
	}
}