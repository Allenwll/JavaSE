package acer.allen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		final int COUNT = 5;
		List<Person> list = new Vector<Person>();
		for (int i = 0; i < COUNT; i++) {
			Person p = new Person(i);
			list.add(p);
		}
		System.err.println("\n---------------VectorÈÝÆ÷:----------------------\n");
		System.out.println(list);
		List<Person> list2 = new LinkedList<Person>();
		for (int i = 0; i < COUNT; i++) {
			Person p = new Person(i + 6);
			list2.add(p);
		}
		System.err.println("\n-------------LinkedListÈÝÆ÷:------------------------\n");
		System.out.println(list2);
		Iterator<Person> it = list.iterator();
		while (it.hasNext()) {
			Person p = it.next();
			Iterator<Person> it1 = list2.iterator();
			while (it1.hasNext()) {
				Person p1 = it1.next();
				if (p.equals(p1)) {
					it.remove();
					it1.remove();
				}
			}
		}
		System.err.println("----------------È¥³ýÖØ¸´ºó--------------------------");
		System.err.println("\n---------------VectorÈÝÆ÷:----------------------\n");
		System.out.println(list);
		System.err.println("\n-------------LinkedListÈÝÆ÷:------------------------\n");
		System.out.println(list2);
	}

}
