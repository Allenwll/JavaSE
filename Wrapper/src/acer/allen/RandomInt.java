package acer.allen;

import java.util.Random;

public class RandomInt {
	static int count = 0;

	public static void main(String[] args) {

		// �������1-100֮�ڵ���:
		 show(10);
		//showRandom();

	}

	/**
	 * ����1-10���� 10������ӵ���50���� �����м���
	 */
	static void showRandom() {
		Random random = new Random();

		while (true) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int r = random.nextInt(10);
				sum += r;
			}
			count++;
			if (sum == 50)
				break;
		}
		System.out.println("count:" + count);

		/*
		 * int sum = 0; for (;;) { for (int i = 0; i < 10; i++) { int r =
		 * random.nextInt(10); sum += r; } count++; if (sum == 50) break; }
		 * 
		 * System.out.println("count:" + count);
		 */
	}

	/**
	 * 1-100���ڵ������
	 * 
	 * @param len
	 */
	static void show(int len) {
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			int r = random.nextInt();
			System.out.println((r >>> 1) % 100);
		}
	}

	/**
	 * 10-23
	 */
	static void show1() {

		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 13) + 10;
			System.out.println("num:" + num);
		}

		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int num = (r.nextInt(13)) + 10;
			System.out.println("num:" + num);
		}
		Random r1 = new Random();
		for (int i = 0; i < 10; i++) {
			double num = (r1.nextDouble() * 13) + 10;
			System.out.println("num:" + (int) num);
		}
	}

}
