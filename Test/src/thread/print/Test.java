package thread.print;

public class Test {

	public static void main(String[] args) {
		Print p=new Print();
		new NumberPrinter(p).start();
		new LetterPrinter(p).start();
		
	}

}
