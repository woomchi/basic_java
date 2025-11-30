import java.util.Scanner;

public class Code14 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int[n];
		
		for(int i=0;i<n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		// 하나의 최댓값을 찾아 배열 맨 마지막으로 보낸 뒤 그 값을 제외한 다음 최댓값을 구해 반복하는 방법
		// 이전에 C언어 배울 때 한 건 그런거 없이 다음 값과의 비교를 반복해 구하는 방법이었음
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(data[j]>data[j-1]) {
					int tmp = data[j];
					data[j] = data[j-1];
					data[j-1]= tmp;
				}
			}
		}
		System.out.println("Sorted data: ");
		for(int i=0;i<n;i++) {
			System.out.println(data[i]);
		}

	}

}
