package section2;

public class Polynomial2 {

	public char name;		//다항식 이름
	public Term2 [] terms;	//다항식의 배열
	public int nTerms;		//다항식 개수
	
	public int calcPolynomial(int x) {
		int result = 0;
		for(int i=0;i<nTerms;i++) {
			result += terms[i].calcTerm(x);
		}
		return result;
	}
	
	public void printPolynomial() {
		for(int i=0;i<nTerms;i++) {
			terms[i].printTerm();
			if(i != nTerms-1) {	//존재하는 term 중에 마지막이 아닐때만 + 붙이기
				System.out.print("+");
			}
		}
		System.out.println();
	}
	
	public void addTerm(int c, int e) {
		int index = findTerm(e);
		if( index != -1 ) {
			terms[index].coef += c;	// +5x^3	-5x^3
			//coef가 0이면 해당 term은 없어짐
			if(terms[index].coef == 0) {
				// p.terms[0] p.terms[1] 중에 p.terms[0]을 없애야함
				int i = nTerms-1;
				while(i>=0 && terms[i].expo <e) {
					i--;
				}
				for(;i<nTerms;i++) {
					terms[i] = terms[i+1];
				}
				nTerms--;
			}
			
		}else {
			int i = nTerms-1;
			while(i>=0 && terms[i].expo < e) {
				terms[i+1] = terms[i];
				i--;
			}
			terms[i+1] = new Term2();
			terms[i+1].coef = c;
			terms[i+1].expo = e;
			nTerms++;
		}
	}

	public int findTerm(int e) {
		for(int i=0;i<nTerms && terms[i].expo >= e;i++) {
			if(terms[i].expo == e) {
				return i;
			}
		}
		return -1;
	}
	
}
