package tdd;

public class Game {
	
	private int[] rolls = new int[21];
	private int currentRoll;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	public int score() {
		int score = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (rolls[frame * 2] + rolls[frame * 2 + 1] == 10) {
				score += 10 + rolls[(frame + 1) * 2];
			} else {
				score += rolls[frame * 2] + rolls[frame * 2 + 1];
			}
		}
		
		return score;
	}
}