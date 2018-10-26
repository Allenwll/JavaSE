package test4;

public class TestMain {
	public static void main(String[] args) {
		Student[] stu = new Student[2]; 
		ArrayUtils.setArrayValues(stu, 100);
		System.out.println("排序前:");
		ArrayUtils.showArrayValues(stu);
		System.out.println("排序后 倒序输出:");
		ArrayUtils.sort(stu);
		ArrayUtils.showArrayValues(stu);
		News[] n=new News[2];
		ArrayUtils.setArrayValue(n, 100);
		System.out.println("排序前:");
		ArrayUtils.showArrayValues(n);
		System.out.println("排序后 正序输出:");
		ArrayUtils.sortNew(n);
		ArrayUtils.showArrayValues(n);
	}

}
