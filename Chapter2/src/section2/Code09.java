package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code09 {
	
	static MyRectangle2 [] rects = new MyRectangle2[100];
	static int n=0;
	
	public static void main(String[] args) {
		
		Scanner in;
		try {
			in = new Scanner(new File("data.txt"));
			while(in.hasNext()) {
				rects[n++] = new MyRectangle2(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());	//인수에 직접 nextInt쓰는 것은 지양하는게 좋음				
// 				rects[n].lu.x = in.nextInt();
//				rects[n].lu.y = in.nextInt();
//				rects[n].width = in.nextInt();
//				rects[n].height = in.nextInt();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file.");
			System.exit(1);
		}
		bubblesort();
		
		for(int i =0;i<n;i++) {
			System.out.println(rects[i].toString());
		}
	}
	public static void bubblesort() {
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(rects[j].calArea() > rects[j].calArea()) {
					MyRectangle2 tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
				}
			}
		}
	}
	

}
