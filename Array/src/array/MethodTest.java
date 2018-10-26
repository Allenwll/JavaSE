package array;

public class MethodTest {

	public static void main(String[] args) {
		// 数组的动态初始化
		int[] a = new int[100];
		// 随机赋值[0,99]
		for (String str : args) {
			System.out.println(str);
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		// 打印
		System.out.println("查找到的下标为:" + search(55, a));
		/*
		 * int result=add(); result=add(1); result=add(1,2);
		 * result=add(1,1,1,1,1,1,1,1); System.out.println(result);
		 */
	}

	/**
	 * @param k 代表需要查找的数据
	 * 
	 * @param is 代表可变参数中的数组
	 */
	static int search(int k, int... is) {
		// 循环数组
		for (int i = 0; i < is.length; i++) {
			if (is[i] == k) {// 查找到与之对应的数据
				return i;// 返回该索引
			}
		}
		return -1;// 没找到与之对应的数据，返回-1
	}

	static int add(int... is) {
		int result = 0;
		for (int i : is) {
			result += i;
		}
		return result;
	}

}
