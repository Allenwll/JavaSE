package exception;

@SuppressWarnings("serial")
public class ScoreException extends Exception {
	public ScoreException() {
	}
	@Override
	public void printStackTrace() {
		System.err.println("����������0-100֮��!");
	}
}
