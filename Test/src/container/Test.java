package container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;
/**
 * 测试类
 * @author Allen
 *
 */
public class Test {
	
	public static void main(String[] args) {
		Student s = new Student(1, "Mars", 17, 58);
		Student s1 = new Student(2, "Juli", 18, 68);
		Student s2 = new Student(3, "Alex", 23, 75);
		Student s3 = new Student(4, "Mars", 17, 58);
		Student s4 = new Student(5, "Ande", 31, 99);
		Student s5 = new Student(6, "Deles", 31, 19);
		int id = 2;
		List<Student> arrayList = new ArrayList<Student>();
		//将Student对象添加进arrayList集合中
		Collections.addAll(arrayList, s,s1,s2,s3,s4,s5);
		Student stu = arrayList.get(id);
		if (stu != null)
			stu.setScore(0);
		else {
			System.err.println("没有找到id为" + id + "的学生！");
		}
		System.err.println("---------------------遍历ArrayList------------------------\n");
		Iterator<Student> it = arrayList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Map<Integer, Student> hashMap = new HashMap<>();
		hashMap.put(s.getId(), s);
		hashMap.put(s1.getId(), s1);
		hashMap.put(s2.getId(), s2);
		hashMap.put(s3.getId(), s3);
		hashMap.put(s4.getId(), s4);
		hashMap.put(s5.getId(), s5);
		System.err.println("-------------------------遍历HashMap--------------------------");
		Student stu1 = hashMap.get(id);
		if (stu1 != null)
			stu1.setScore(0);
		else {
			System.err.println("没有找到id为" + id + "的学生！");
		}
		Set<Entry<Integer, Student>> entrySet = hashMap.entrySet();
		Iterator<Entry<Integer, Student>> itEntry = entrySet.iterator();
		while (itEntry.hasNext()) {
			Entry<Integer, Student> entry = itEntry.next();
			System.out.print("key:-------" + entry.getKey() + "    ");
			System.out.println("Value:-------" + entry.getValue());
		}
		Set<Student> hashSet = new HashSet<Student>();
		Collections.addAll(hashSet, s,s1,s2,s3,s4,s5);
		System.err.println("-------------------------遍历HashSet--------------------------");
		Iterator<Student> itSet = hashSet.iterator();
		boolean flag = false;
		while (itSet.hasNext()) {
			Student stu2 = itSet.next();
			if (stu2.getId() == id) {
				stu2.setScore(98);
				flag = true;
			}

		}
		if (!flag) {
			System.err.println("没有找到id为" + id + "的学生！");
		}
		System.out.println(hashSet);
	}

}
