package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code19 {

	public static void main(String[] args) {
		//String fileName = "input.txt";
		//파일 데이터를 저장할 변수 선언
		String [] name = new String[1000];	//input에서 입력받을 배열			
		String [] number = new String[1000];
		int n = 0;
		
		
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

		for(int i = 0; i<n;i++) {
			System.out.println(name[i] + ": "+number[i]);
		}
	}

}
