package printer;

/**
 * ≤‚ ‘¿‡
 * 
 * @author acer
 *
 */
public class Test {

	public static void main(String[] args) {
		Print p = new Print();
		NumberPrinter np = new NumberPrinter(p);
		LetterPrinter lp = new LetterPrinter(p);
		np.start();
		lp.start();

	}

}
