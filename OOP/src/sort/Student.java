package sort;

public class Student implements Comparable1{
	private int id;
	private  int score;
	private String name;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	public Student(int id,int score,String name) {
		this.id = id;
		this.score=score;
		this.name=name;
	}
	//�����ǰ����id����ʵ�ζ����id ����>0���� 
	@Override
	public int compareTo(Object object) {
		Student student=(Student)object;
		//return this.id-student.id;
		return this.name.compareTo(student.name);
	}

}
