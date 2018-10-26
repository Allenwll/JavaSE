package acer.allen.oop.act;

public class Actor extends Person {
	private String graduateSchool;
	private String masterWork;
	public String getGraduateSchool() {
		return getGraduateSchool();
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getMasterWork() {
		return masterWork;
	}

	public void setMasterWork(String masterWork) {
		this.masterWork = masterWork;
	}

	@Override
	public void introduce() {
		System.out.println("��Һã�����"+super.getName()+
				"\n����"+super.getAge()+"\n�ұ�ҵ��"+graduateSchool+"\n��������:"+
				masterWork);
	}

	public Actor(String name, int age, String sex,String graduateSchool,String masterWork) {
		super(name, age, sex);
		this.graduateSchool=graduateSchool;
		this.masterWork=masterWork;

	}

}
