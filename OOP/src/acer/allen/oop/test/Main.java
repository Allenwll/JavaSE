package acer.allen.oop.test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 类数组的实例化
		Student[] s = new Student[10];
		// 定义整型变量
		int sum = 0;
		// 循环赋值
		for (int i = 0; i < s.length; i++) {
			s[i] = new Student();
			sum += s[i].score;
		}
		// 循环打印数组元素
		for (int i = 0; i < s.length; i++) {
			System.out.println("类数组元素为：" + s[i].score);
		}
		// 打印总和和平均值
		System.out.println("总和为:" + sum + "\n 平均值为:" + (sum / s.length));
	}

}
