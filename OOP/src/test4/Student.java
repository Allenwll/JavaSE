package test4;

public class Student implements Comparable {

	private int id;
	private String name;
	private int age;
	private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

	public Student(int score) {
		super();
		this.score = score;
	}

	@Override
	public int compareTo(Object obj) {
		 Student stu=(Student) obj;
		return this.getScore()-stu.getScore();
	}

}
