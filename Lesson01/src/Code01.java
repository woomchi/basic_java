
public class Code01 {

	static int num;	//
	
	public static void main(String[] args) {	//기본적으로 main 메서드가 클래스 생성시 만들어짐
		//System.out.println("Hello Java!!");	// == printf();
		
		int anotherNum = 5;
		num = 2;
		
		System.out.println(num + anotherNum);
		System.out.println("Num: "+num);
		System.out.println("AnotherNum: "+anotherNum);
		System.out.println("Sum: "+num+anotherNum);	//left associativity
		System.out.println("Sum: "+(num+anotherNum));
	}

}
