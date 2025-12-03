package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code22 {

	static String [] words = new String[100000];
	static int [] count = new int[100000];
	static int n = 0;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {	//무한 루프
			
			System.out.println("$ ");	//프롬프트 형식
			String command = kb.next();
			if(command.equals("read")) {
				String filename = kb.next();
				makeIndex(filename);
			}else if(command.equals("find")) {
				String str = kb.next();
				int index = findWord(str);
				if(index > -1) {
					System.out.println("The word "+words[index]+" appears "+count[index]+" times");
				}else {
					System.out.println("The word "+str+" does not appears");
				}
			}else if(command.equals("saveas")) {
				String filename = kb.next();
				saveAs(filename);
			}else if(command.equals("exit")) {
				break;	//break가 없다면 무한 루프로 Scanner가 메모리 leak로 감지함
			}
		}
		kb.close();
//		for(int i=0;i<n;i++) {
//			System.out.println(words[i]+" "+count[i]);
//		}
	}
	public static void makeIndex(String filename) {
		try {
			Scanner inFile = new Scanner(new File(filename));
			
			while(inFile.hasNext()) {	//입력 데이터가 없을 때까지
				String str = inFile.next();
				
				addWord(str);
				
			}
			
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			return;
		}
		
	}
	public static void addWord(String str) {
		int index = findWord(str);	// returns -1 if not found
		if(index != -1) {	//found words[index] == str
			count[index]++;
		}else {
			words[n] = str;
			count[n] = 1;
			n++;
		}
	}
	public static int findWord(String str) {
		//이전에 인덱스로 만든 단어인지 판별
		for(int i=0;i<n;i++) {
			if(words[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	public static void saveAs(String filename) {
		PrintWriter outFile;
		try {
			outFile = new PrintWriter(new FileWriter(filename));
			for(int i=0;i<n;i++) {
				outFile.println(words[i]+" "+count[i]);
			}
			
			outFile.close();
		} catch (IOException e) {
			System.out.println("Save failed. Don't ask me why!");
		}
	}
}
