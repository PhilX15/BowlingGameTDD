package tdd;

public class Game {

	private int[] rolls = new int[BowlingGameConfig.MAX_THROW_NUMBER];
	private int currentRoll;

	public void roll(int pins) {
		if (currentRoll + 1 > BowlingGameConfig.MAX_THROW_NUMBER) {
			throw new TooManyRollsException();
		}

		if (pins < 0 || pins > BowlingGameConfig.MAX_PIN_COUNT) {
			throw new IllegalArgumentException("Invalid number of pins");
		}

		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int rollCounter = 0;
		for (int frame = 0; frame < BowlingGameConfig.MAX_FRAME_NUMBER; frame++) {
			if (isStrike(rollCounter)) {
				score += strikeBonus(rollCounter);
				rollCounter++;
			} else if (isSpare(rollCounter)) {
				score += spareBonus(rollCounter);
				rollCounter += 2;
			} else {
				score += frameScore(rollCounter);
				rollCounter += 2;
			}
		}

		return score;
	}

	private int strikeBonus(int rollCounter) {
		return BowlingGameConfig.MAX_PIN_COUNT + rolls[rollCounter + 1] + rolls[rollCounter + 2];
	}

	private boolean isStrike(int rollCounter) {
		return rolls[rollCounter] == BowlingGameConfig.MAX_PIN_COUNT;
	}

	private int frameScore(int rollCounter) {
		return rolls[rollCounter] + rolls[rollCounter + 1];
	}

	private int spareBonus(int rollCounter) {
		return BowlingGameConfig.MAX_PIN_COUNT + rolls[rollCounter + 2];
	}

	private boolean isSpare(int rollCounter) {
		return frameScore(rollCounter) == BowlingGameConfig.MAX_PIN_COUNT;
	}
}