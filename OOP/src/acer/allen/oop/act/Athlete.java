package acer.allen.oop.act;

public class Athlete extends Person {
	private String sportEvent;
	private String hScore;

	public String gethScore() {
		return hScore;
	}

	public void sethScore(String hScore) {
		this.hScore = hScore;
	}

	public String getSportEvent() {
		return sportEvent;
	}

	public void setSportEvent(String sportEvent) {
		this.sportEvent = sportEvent;
	}

	public Athlete(String name, int age, String sex,String sportEvent,String hScore) {
		super(name, age, sex);
		this.sportEvent=sportEvent;
		this.hScore=hScore;

	}
	@Override
	public void introduce() {
		System.out.println("�Ҿ���һ����ͨ�ϰ���");
		System.out.println("=================================");
		System.out.println("��Һã�����"+super.getName()+
				"\n����"+super.getAge()+"\n���ó����˶���Ŀ��:"+sportEvent+"\n��õĳɼ���:"+
				hScore);
	}

}
