package acer.allen.oop.inner;

import acer.allen.oop.factory.Animal;
import acer.allen.oop.plant.Plant;

/**
 * 内部类 InnerClass 可以实现多重继承
 * 
 * @author acer
 *
 */
public class OutterClass extends Animal {
	@SuppressWarnings("unused")
	private int i;
	static int a;

	public OutterClass() {
		// TODO Auto-generated constructor stub
	}

	public void showOutter() {
		// 方法内部类 只能访问方法中定义的final类型的局部变量
		final int c=6;
		class InnerClass2 {

			public void show() {
				OutterClass.this.i = 0;
				System.out.println("  说说");
				System.out.println(c);
			}
			
		}
		InnerClass2 ner = new InnerClass2();
		ner.show();
		

	}

	public void showInner() {
		InnerClass inner = new InnerClass();
		inner.innerI = 20;
		inner.show();
	}

	// 成员内部类 可以实现多继承
	public class InnerClass extends Plant {
		public int innerI;
		@SuppressWarnings("unused")
		private int i;

		@SuppressWarnings("unused")
		public void show() {
			int i = 0;
			innerI = 0;
			i++;// 局部
			this.i++;// 内部成员
			OutterClass.this.i++; // 外部成员
			OutterClass.a = 0;
			showOutter();
		}

		@Override
		public void grow() {
			// TODO Auto-generated method stub

		}

		@Override
		public void die() {
			// TODO Auto-generated method stub

		}
	}

	// 静态成员内部类 只能访问静态成员
	public static class InnerClass1 {
		@SuppressWarnings("unused")
		private int i;
		@SuppressWarnings("unused")
		private int a;

		public InnerClass1() {
			a++;
			OutterClass.a = 0;
		}
	}
}
