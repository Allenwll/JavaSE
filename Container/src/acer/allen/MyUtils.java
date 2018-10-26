package acer.allen;

import java.util.Random;

public final class MyUtils {
	// 随机数
	private static Random random = new Random();

	// 姓名数字
	private static final int NAME_COUNT = Name.values().length;
	
	// 性别数字
	private static final int GENDER_COUNT = Gender.values().length;

	// 得到随机数
	public static final int getNextInt(int n) {
		return random.nextInt(n);
	}

	// 得到随机姓名
	public static final Name getRandomName() {
		int ran = getNextInt(NAME_COUNT);
		return Name.values()[ran];
	}

	// 得到随机性别
	public static final Gender getRandomGender() {
		int ran = getNextInt(GENDER_COUNT);
		return Gender.values()[ran];
	}
}
