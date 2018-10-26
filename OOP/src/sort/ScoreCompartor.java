package sort;

public class ScoreCompartor implements  Comparable2 {

	@Override
	public int compareTo(Object o1, Object o2) {
		Student stu=(Student)o1;
		Student stu1=(Student)o2;
		return stu.getScore()-stu1.getScore();
	}

}
