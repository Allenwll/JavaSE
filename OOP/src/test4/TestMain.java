package test4;

public class TestMain {
	public static void main(String[] args) {
		Student[] stu = new Student[2]; 
		ArrayUtils.setArrayValues(stu, 100);
		System.out.println("����ǰ:");
		ArrayUtils.showArrayValues(stu);
		System.out.println("����� �������:");
		ArrayUtils.sort(stu);
		ArrayUtils.showArrayValues(stu);
		News[] n=new News[2];
		ArrayUtils.setArrayValue(n, 100);
		System.out.println("����ǰ:");
		ArrayUtils.showArrayValues(n);
		System.out.println("����� �������:");
		ArrayUtils.sortNew(n);
		ArrayUtils.showArrayValues(n);
	}

}
