package acer.allen.oop.inner;

import acer.allen.oop.test.Point;

public class Anonymous {
	public static void main(String[] args) {

	}

	public void show() {
		new Point() {
			@SuppressWarnings("unused")
			private void show() {
				// TODO Auto-generated method stub

			}
			void eat(){
				
			}
		}.eat();
		@SuppressWarnings("unused")
		MyClass my = new MyClass() {
		};
		 new Compare2() {

			@Override
			public void show() {
				// TODO Auto-generated method stub

			}
		};
	}
}
