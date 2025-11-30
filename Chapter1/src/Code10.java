
public class Code10 {

	public static void main(String[] args) {
		for(int n=2;n<=100000;n++) {
			boolean isPrime = true;	//초기화
			for(int i=2;i*i<=n;i++) {	//n/2까지 하는 것보다 제곱근까지 계산하는 방식으로 개선
				// n이 소수라면 본인을 제외한 나머지로부터 나누어떨어지지않음
				if(n%i==0) {
					isPrime =false;
					break;	//소수가 아니라면 나누어떨어지기 때문에 바로 반복문을 중단해 효율을 높일 수 있음
				}
			}
			if(isPrime) {
				System.out.println(n);
			}
		}

	}

}
