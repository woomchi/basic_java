package Section1;

public class Code1 {

	public static void main(String[] args) {

		Person1 first;			//Person1 클래스 타입의 변수 선언
		first = new Person1();	//해당 클래스 타입 변수를 객체로써 생성
		
		//클래스 멤버 변수에 값을 저장
		first.name = "John";
		first.number = "0102483120";
		
		System.out.println("Name: "+first.name+", Number: "+first.number);
		
		Person1 [] members = new Person1[100];
		members[0] = first;
		members[1] = new Person1();
		members[1].name = "David";
		members[1].number = "2873548327457";
		
		System.out.println("Name: "+members[1].name+", Number: "+members[1].number);
		
	}

}
