package acer.allen.thread.printnum;

public class Test {

	public static void main(String[] args) {
		Printer p = new Printer();
		NumberPrinter np = new NumberPrinter(p);
		LetterPrinter lp = new LetterPrinter(p);
		np.start();
		lp.start();
	}
}
