package acer.allen.collection.set;

import java.util.Comparator;

/**
 * �ⲿ�Ƚ���
 * 
 * @author acer
 *
 */
public class StuIdCompartor implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getAge() - o2.getAge();
	}



}
