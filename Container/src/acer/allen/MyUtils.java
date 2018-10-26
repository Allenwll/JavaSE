package acer.allen;

import java.util.Random;

public final class MyUtils {
	// �����
	private static Random random = new Random();

	// ��������
	private static final int NAME_COUNT = Name.values().length;
	
	// �Ա�����
	private static final int GENDER_COUNT = Gender.values().length;

	// �õ������
	public static final int getNextInt(int n) {
		return random.nextInt(n);
	}

	// �õ��������
	public static final Name getRandomName() {
		int ran = getNextInt(NAME_COUNT);
		return Name.values()[ran];
	}

	// �õ�����Ա�
	public static final Gender getRandomGender() {
		int ran = getNextInt(GENDER_COUNT);
		return Gender.values()[ran];
	}
}
