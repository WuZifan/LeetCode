package amazon;

public class OnlineTest {

	private static void startPrint(int count) {
		for (int i = 1; i <= count; i++) {
			for (int j = 0; j < count - i; j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++){
				System.out.print("#");
			}
			if(i!=count){
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		startPrint(6);
	}
}
