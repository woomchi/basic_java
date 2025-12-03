package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lesson {
	static String [] names = new String[1000];
	static int [] numbers = new int[1000];	
	static int n = 0;
	
	public static void main(String[] args) {
		Scanner kb;
		try {
			kb = new Scanner(new File("input.txt"));
			while(kb.hasNext()) {
				names[n] = kb.next();
				numbers[n] = kb.nextInt();
				n++;
			}
			kb.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			System.exit(1);
		}
		
		bubblesort(n, names, numbers);
		
		for(int i=0;i<n;i++) {
			System.out.println((i+1)+". Name: "+names[i]+", Number: "+numbers[i]);
		}	
	}
	public static void bubblesort(int n, String [] names, int [] numbers) {
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;

					String tmp = names[j];
					names[j] = names[j+1];
					names[j+1] = tmp;
					
				}
			}
		}
	}

}
