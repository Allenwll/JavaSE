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
		System.out.println("我就是一个普通老百姓");
		System.out.println("=================================");
		System.out.println("大家好！我是"+super.getName()+
				"\n今年"+super.getAge()+"\n我擅长的运动项目是:"+sportEvent+"\n最好的成绩是:"+
				hScore);
	}

}
