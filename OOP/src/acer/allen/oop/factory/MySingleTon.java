package acer.allen.oop.factory;
/**
 * ����ģʽ ���ڴ���ֻ��һ��
 * @author acer
 *
 */
public class MySingleTon {
	private MySingleTon() {
	}
	private static MySingleTon singleTon=null;
	//�ṩ������Ψһ�ӿ�
	public static MySingleTon getInstatnce(){
		if(singleTon==null){
			singleTon=new MySingleTon();
		}
		return singleTon;
	}
	public void test(){
		System.out.println("\n����ģʽ����~~~~~~~~");
	}

}
