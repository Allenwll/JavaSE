package array;

public class MethodTest {

	public static void main(String[] args) {
		// ����Ķ�̬��ʼ��
		int[] a = new int[100];
		// �����ֵ[0,99]
		for (String str : args) {
			System.out.println(str);
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		// ��ӡ
		System.out.println("���ҵ����±�Ϊ:" + search(55, a));
		/*
		 * int result=add(); result=add(1); result=add(1,2);
		 * result=add(1,1,1,1,1,1,1,1); System.out.println(result);
		 */
	}

	/**
	 * @param k ������Ҫ���ҵ�����
	 * 
	 * @param is ����ɱ�����е�����
	 */
	static int search(int k, int... is) {
		// ѭ������
		for (int i = 0; i < is.length; i++) {
			if (is[i] == k) {// ���ҵ���֮��Ӧ������
				return i;// ���ظ�����
			}
		}
		return -1;// û�ҵ���֮��Ӧ�����ݣ�����-1
	}

	static int add(int... is) {
		int result = 0;
		for (int i : is) {
			result += i;
		}
		return result;
	}

}
