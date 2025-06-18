package tdd;

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
        rollMany(18, 0);
        
        rollSpare();
        g.roll(3);
        
        assertEquals(13, g.score());
    }
    
    @Test
    void testStrikeInTheLastFrame() {
        rollMany(18, 0);
        
        g.roll(10);
        g.roll(3);
        g.roll(5);
        
        assertEquals(18, g.score());
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