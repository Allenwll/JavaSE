package acer.allen.oop.factory;
/**
 * 单例模式 在内存中只有一份
 * @author acer
 *
 */
public class MySingleTon {
	private MySingleTon() {
	}
	private static MySingleTon singleTon=null;
	//提供给外界的唯一接口
	public static MySingleTon getInstatnce(){
		if(singleTon==null){
			singleTon=new MySingleTon();
		}
		return singleTon;
	}
	public void test(){
		System.out.println("\n单例模式测试~~~~~~~~");
	}

}
