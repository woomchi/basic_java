import java.util.Scanner;

public class Code3 {

	public static void main(String[] args) {
		String str = "Hello";
		String input = null;	//문자열에 대하여 보통 null로 초기화해 명시하지 않아도됨
		Scanner kb = new Scanner(System.in);	//System.in : 표준 입력 키보드
		
		input = kb.next();
		if(str.equals(input)) {	//== input.equals(str));
			System.out.println("Numbers match! :-)");
		}else {
			System.out.println("Numbers do not match! :-(");
		}
		kb.close();

	}

}
