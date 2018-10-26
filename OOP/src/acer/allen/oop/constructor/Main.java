package acer.allen.oop.constructor;

public class Main {
/**
 * 实例化过程
 * 先初始化成员变量，再执行构造方法内的代码
 * 
 * 首先已经编译过了 有了.class JVM开始将对应的类加载到方法区
 * 通过方法区内的类Class对象，帮助我们在堆内存中生成相应的对象。对象中只保存成员变量的空间
 * 所有的该类的对象共享同一个方法区内的方法.
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 类的实例化
		Student s = new Student();
		// 调用睡觉方法
		s.sleep();
		// 调用学习方法
		s.study();
		// 调用显示方法
		s.show();
		Student s1 = new Student(2016002, "Merray", '女', 19, "龙城小区");
		// 调用显示方法
		s1.show();
		
	}

}
