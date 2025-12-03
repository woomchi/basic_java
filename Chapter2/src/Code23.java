

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code23 {

	static String [] words = new String[100000];
	static int [] count = new int[100000];
	static int n = 0;
	
	public static void main(String[] args) {
		// 단어 안에 특수기호, 숫자가 포함되어 이를 개선하는 버전
		// + 대소문자 구별없이 목록에 저장
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
				String trimmed = trimming(str);
				// 문자열이 없다고 판별되어 null이 반환되기도 하므로 null이 아닌 경우에만 addWord가 이루어져야함
				if(trimmed != null) {
					String t= trimmed.toLowerCase();
					addWord(t);					
				}
				
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
			int i=n-1;
			while(i>=0&&words[i].compareToIgnoreCase(str) > 0) {
				words[i+1] = words[i];
				count[i+1] = count[i];
				i--;
			}
			words[i+1] = str;
			count[i+1] = 1;
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
	public static String trimming(String str) {
		if(str==null || str.length()<=0) {
			return null;
		}
		int i=0, j=str.length()-1;
		while(i <= str.length()-1 && !Character.isLetter(str.charAt(i))) {
			i++;
		}
		while(j>=0 && !Character.isLetter(str.charAt(j))) {
			j--;
		}
		
		//System.out.println(str + ":"+i+":"+j);
		//문자열 안에 알파벳이 하나도 없는 경우에는 i가 j보다 커지므로 StringIndexOutOfBoundsException이 발생함
		if(i>j) {
			return null;
		}
		return str.substring(i,j+1);
	}
}
