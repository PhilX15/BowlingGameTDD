package tdd;

public class TooManyRollsException extends RuntimeException {
	public TooManyRollsException() {
		super("Exceeded the maximum number of rolls");
	}
}
