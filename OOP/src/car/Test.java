package car;

public class Test {

	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		v.start();
		v.stop();
		FamilyCar f=new FamilyCar();
		f.setName("小张");
		f.show();
		f.arrive();
		Taxi t = new Taxi();
		t.setCompany("景顺出租车公司");
		t.setCarNo("京B123");
		t.arrive();
		t.show();

	}

}
