package acer.allen.math;

public class Test {

	public static void main(String[] args) {
		// 得到0-100的随机数
		double d = (Math.random() * 100);
		System.out.println("得到的随机数为:" + d);
		System.out.println("-------------------------");
		System.out.println("四舍五入后为：" + Math.round(d));
		System.out.println("-------------------------");
		System.out.println("开平方后为：" + Math.sqrt(d));
		System.out.println("-------------------------");
		System.out.println("开立方后为：" + Math.cbrt(d));
		System.out.println("-------------------------");
		System.out.println("向下取整为：" + Math.floor(d));
		System.out.println("-------------------------");
		System.out.println("向上取整为：" + Math.ceil(d));

	}

}
