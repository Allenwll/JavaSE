package acer.allen;

public class RabbitAndChicken {
	public static void main(String[] args) {
		for (int i = 0; i <= 35; i++) {
			for (int j = 0; j <=35; j++) {
				if(i+j==35&&2*i+4*j==94)
					System.out.printf("����%dֻ������%dֻ\n",i,j);
			}
		}
	}
}
