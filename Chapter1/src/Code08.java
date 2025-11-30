import java.util.Scanner;

public class Code08 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int[n];	//가변 길이가 n인 data 배열
		
		for(int i=0; i<n;i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		int sum = 0; 
		int max = data[0];	//배열 값의 범위를 알 수 없기 때문에 첫 번째 배열을 기준으로 해야함
		for(int i=0; i<n ;i++) {
			sum += data[i];
			if(data[i]>max) {
				max = data[i];
			}
		}
		System.out.println("The sum is "+sum + " and the maximum is "+max);

	}

}
