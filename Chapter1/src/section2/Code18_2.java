package section2;

import java.util.Scanner;

public class Code18_2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int[n];
		for(int i=0; i<n;i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		bubblesort(n, data);
		for(int i = 0 ; i < n ; i++){
			System.out.println(data[i]);
		}
	}
	public static void bubblesort(int n,int [] data) {
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(data[j]>data[j-1]) {
					//swap
					int tmp = data[j];
					data[j] = data[j-1];
					data[j-1] = tmp;
				}
			}
		}
	}
	// 값에 의한 호출에 의거해 swap이 이루어지지않음
	// But, 배열은 값에 의한 호출에 영향 받지 않는 예외임
//	public static void swap(int a, int b) {
//		int tmp = a;
//		a = b;
//		b= tmp;
//	}
}
