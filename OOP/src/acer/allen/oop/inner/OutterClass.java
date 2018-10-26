package acer.allen.oop.inner;

import acer.allen.oop.factory.Animal;
import acer.allen.oop.plant.Plant;

/**
 * �ڲ��� InnerClass ����ʵ�ֶ��ؼ̳�
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
		// �����ڲ��� ֻ�ܷ��ʷ����ж����final���͵ľֲ�����
		final int c=6;
		class InnerClass2 {

			public void show() {
				OutterClass.this.i = 0;
				System.out.println("  ˵˵");
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

	// ��Ա�ڲ��� ����ʵ�ֶ�̳�
	public class InnerClass extends Plant {
		public int innerI;
		@SuppressWarnings("unused")
		private int i;

		@SuppressWarnings("unused")
		public void show() {
			int i = 0;
			innerI = 0;
			i++;// �ֲ�
			this.i++;// �ڲ���Ա
			OutterClass.this.i++; // �ⲿ��Ա
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

	// ��̬��Ա�ڲ��� ֻ�ܷ��ʾ�̬��Ա
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
