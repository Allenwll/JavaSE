package car;

public class Test {

	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		v.start();
		v.stop();
		FamilyCar f=new FamilyCar();
		f.setName("С��");
		f.show();
		f.arrive();
		Taxi t = new Taxi();
		t.setCompany("��˳���⳵��˾");
		t.setCarNo("��B123");
		t.arrive();
		t.show();

	}

}
