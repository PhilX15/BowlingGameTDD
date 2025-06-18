package tdd;

public class Game {
	
	private int[] rolls = new int[21];
	private int currentRoll;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	public int score() {
		int score = 0;
		int rollCounter = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isSpare(rollCounter)) {
				score += spareBonus(rollCounter);
				rollCounter += 2;
			} else {
				score += frameScore(rollCounter);
				rollCounter += 2;
			}
		}
		
		return score;
	}

	private int frameScore(int rollCounter) {
		return rolls[rollCounter] + rolls[rollCounter + 1];
	}

	private int spareBonus(int rollCounter) {
		return 10 + rolls[rollCounter + 2];
	}

	private boolean isSpare(int rollCounter) {
		return frameScore(rollCounter) == 10;
	}
}