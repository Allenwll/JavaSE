package acer.allen.oop.interface1;

/**
 * * 接口： API 继承： is-a关系 dog is an Animal 接口 has -a 设计：不是同一种类型，拥有共同的一个功能
 * 设计父类时：必须是一类事物的集合，而不是某种功能的体现 接口是面向功能开发。它代表了一种规范 接口： 都是抽象方法 都是public类型的
 * public和static可以省略 有且只有抽象方法和全局常量 全局常量 中的public static final 关键字可以省略
 * 
 * @author acer
 *
 */
public interface Flyable {
	// 可以省略public static final；
	String TAG = "Allen";

	// 可以省略public abstract;
	void fly();// public abstract void fly();

	// public static final int NUM = 12;

	// public abstract void flag();

}
