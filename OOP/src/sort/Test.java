package sort;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * int[] array=new int[10]; ArrayUtils.setArrayValues(array,100);
		 * System.out.println("����ǰ:"); ArrayUtils.showArrayValues(array);
		 * ArrayUtils.bubbleSort(array); System.out.println("�����:");
		 * ArrayUtils.showArrayValues(array);
		 */
		Student[] stu = new Student[10];
		ArrayUtils.setArrayValues(stu, 100);
		System.out.println("����ǰ:");
		ArrayUtils.showArrayValues(stu);
		// ArrayUtils.sort(stu);
		System.out.println("�����:");
		// ArrayUtils.showArrayValues(stu);
		 IdCompartor com1=new IdCompartor();
		 ScoreCompartor com2 = new ScoreCompartor();
		/*
		 * ArrayUtils.sort(stu, com1); ArrayUtils.showArrayValues(stu);
		
		ArrayUtils.sort(stu,com2); */
		ArrayUtils.sort(stu);
		ArrayUtils.showArrayValues(stu);
		

	}
}
