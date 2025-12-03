package Section1;

public class Code1_2 {

	public static void main(String[] args) {

		Person1 first = new Person1();	//해당 클래스 타입 변수를 객체로써 생성
		first.name = "John";
		first.number = "0102483120";
		
		//first 변수값을 복사 => second의 참조는 first임(새로운 객체가 생성된 것이 아니라 second는 first를 가리키고 있는것)
		Person1 second = first;
		second.name = "Tom";
		System.out.println(first.name+" , "+first.number);
		
		
		Person1 [] members = new Person1[100];
		members[0] = first;
		members[1] = second;
				
		System.out.println("Name: "+members[0].name+", Number: "+members[0].number);
		System.out.println("Name: "+members[1].name+", Number: "+members[1].number);
		
		members[2] = new Person1();
		members[2].name = "David";
		members[2].number = "2376457264";
		
		
	}

}
