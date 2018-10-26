package acer.allen.oop.work;

public class Draw {

	public int count;
	public int lines;
	 public Draw(int count,int lines) {
		this.count=count;
		this.lines=lines;
	}
	void drawTrian(){
		System.out.println("直角三角形:");
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j <i+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	void drawRec(){
		System.out.println("矩形:");
		for (int i = 0; i <lines; i++) {
			for (int j = 0; j < count; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	void draPra(){
		System.out.println("平行四边形:");
		for (int i = 0; i < lines; i++) {
			for (int k = lines; k >i; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j < count; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Draw d=new Draw(10, 6);
		d.drawTrian();
		d.drawRec();
		d.draPra();
	}

}
