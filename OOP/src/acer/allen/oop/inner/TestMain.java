package acer.allen.oop.inner;

import acer.allen.oop.inner.OutterClass.InnerClass;
import acer.allen.oop.inner.OutterClass.InnerClass1;

public class TestMain {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		OutterClass o = new OutterClass();
		o.showInner();
		//成员内部类
		InnerClass in = new OutterClass().new InnerClass();
		//静态内部类
		InnerClass1 in1=new OutterClass.InnerClass1();
			new MyFrame();
	}
}
