package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {
	// 두 개 이상의 메서드에서 사용하면 클래스 멤버변수로 만들 수 있음
	static String [] name = new String[1000];	//input에서 입력받을 배열			
	static String [] number = new String[1000];
	static int n = 0;
	
	public static void main(String[] args) {
		//String fileName = "input.txt";
		//파일 데이터를 저장할 변수 선언
		
		
		try {
			Scanner inFile = new Scanner(new File("input.txt"));
			
			while(inFile.hasNext()) {	//hasNext() : 더 읽게 있는지 확인후 true/false 리턴E
				name[n] = inFile.next();
				number[n] = inFile.next();
				n++;
			}
			
			inFile.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			System.exit(9);	//0 : 정상적인 종료, 이외: 비정상적인 종료
			//return;	//main 함수를 종료 => 프로그램 종료
		}

		bubblesort(n, name, number);
		
		for(int i = 0; i<n;i++) {
			System.out.println(name[i] + ": "+number[i]);
		}
	}
	public static void bubblesort(int n , String [] name, String [] number) {
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				//사람 이름에 대한 정렬
				if(name[j].compareTo(name[j+1]) > 0) {	//문자열은 비교 연산자로 비교 불가능
					String tmp = name[j];
					name[j] = name[j+1];
					name[j+1] = tmp;
					
					tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
				}
			}
		}
	}

}
