package sort;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * int[] array=new int[10]; ArrayUtils.setArrayValues(array,100);
		 * System.out.println("≈≈–Ú«∞:"); ArrayUtils.showArrayValues(array);
		 * ArrayUtils.bubbleSort(array); System.out.println("≈≈–Ú∫Û:");
		 * ArrayUtils.showArrayValues(array);
		 */
		Student[] stu = new Student[10];
		ArrayUtils.setArrayValues(stu, 100);
		System.out.println("≈≈–Ú«∞:");
		ArrayUtils.showArrayValues(stu);
		// ArrayUtils.sort(stu);
		System.out.println("≈≈–Ú∫Û:");
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
