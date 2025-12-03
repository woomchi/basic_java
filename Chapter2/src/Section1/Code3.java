package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code3 {

	static Person1 [] members = new Person1[100];
	static int n = 0;
	
	public static void main(String[] args) {
		//members = new Person1[100];
		try {
			Scanner in = new Scanner(new File("input.txt"));
			while(in.hasNext()) {
				String nm = in.next();
				String nb = in.next();
				members[n] = new Person1();
				members[n].name = nm;
				members[n].number = nb;
				n++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file");
			System.exit(1);
		}
		
		// 이전과 달리 Person1에 대한 데이터가 main안에 있지 않아 직접 access가 가능하므로 매개변수로 넣을 필요가 없음
		bubblesort();
		
		for(int i=0;i<n;i++) {
			System.out.println(members[i].name+" "+members[i].number);
		}

	}
	public static void bubblesort() {
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(members[j].name.compareToIgnoreCase(members[j+1].name) > 0) {
					Person1 tmp = members[j];
					members[j] = members[j+1];
					members[j+1] = tmp;					
				}
			}
		}
	}

}
