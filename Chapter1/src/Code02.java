import java.util.Scanner;

public class Code02 {

	public static void main(String[] args) {

		int num = 123;
		Scanner kb = new Scanner(System.in);	//kb라는 Scanner 객체 생성
		
		int input = kb.nextInt();
		if(input == num) {
			System.out.println("Numbers match! :-)");
		}else {
			System.out.println("Numbers do not match! :-(");
		}
		kb.close();

	}

}
