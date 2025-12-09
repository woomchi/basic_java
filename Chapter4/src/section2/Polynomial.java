package section2;
import section1.MySingleLinkedList;
import section1.Node;

public class Polynomial {
	public char name;
	public MySingleLinkedList<Term> terms;	//다른 패키지 클래스는 import를 사용해야함
	
	public Polynomial( char name) {
		this.name = name;
		terms = new MySingleLinkedList<Term>();
	}
	
	public void addTerm(int coef, int expo) {
		if(coef == 0) {
			return;
		}
		Node<Term> p = terms.head;
		Node<Term> q = null;	//head 이전 노드는 null
		while(p!=null && p.data.expo > expo) {
			q=p;
			p=p.next;
		}
		
		if(p!=null && p.data.expo == expo) {
			p.data.coef += coef;
			if(p.data.coef == 0) {
				// remove this node
				if(q==null) {
					terms.removeFirst();
				}else {					
					terms.removeAfter(q);
				}
			}
		}else {
			Term t = new Term(coef, expo);
			if(q==null) {
				terms.addFirst(t);
			}else {
				terms.addAfter(q, t);				
			}
		}
	}
	
	public int calc(int x) {
		int result = 0;
		Node<Term> p = terms.head;
		while(p!=null) {
			result += p.data.calc(x);
			p=p.next;
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		Node<Term> p = terms.head;
		while(p!=null) {
			result += ("+"+p.data.toString());
			p=p.next;
		}
		return result;
	}
}
