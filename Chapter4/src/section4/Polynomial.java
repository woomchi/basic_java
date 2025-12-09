package section4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	public char name;
	public LinkedList<Term> terms;	//다른 패키지 클래스는 import를 사용해야함
	
	public Polynomial( char name) {
		this.name = name;
		terms = new LinkedList<Term>();
	}
	
	public void addTerm(int coef, int expo) {
		if(coef == 0) {
			return;
		}
		ListIterator<Term> iter = terms.listIterator();
		while(iter.hasNext()) {
			Term t = iter.next();
			if(t.expo == expo) {
				t.coef += coef;
				if(t.coef == 0) {
					iter.remove();					
				}
				return;
			}else if(t.expo < expo) {
				iter.previous();
				iter.add(new Term(coef, expo));
			}
		}
		iter.add(new Term(coef, expo));
		
		
//		Node<Term> p = terms.head;
//		Node<Term> q = null;	//head 이전 노드는 null
//		while(p!=null && p.data.expo > expo) {
//			q=p;
//			p=p.next;
//		}
//		
//		if(p!=null && p.data.expo == expo) {
//			p.data.coef += coef;
//			if(p.data.coef == 0) {
//				// remove this node
//				if(q==null) {
//					terms.removeFirst();
//				}else {					
//					terms.removeAfter(q);
//				}
//			}
//		}else {
//			Term t = new Term(coef, expo);
//			if(q==null) {
//				terms.addFirst(t);
//			}else {
//				terms.addAfter(q, t);				
//			}
//		}
	}
	
	public int calc(int x) {
		int result = 0;
		Iterator<Term> iter = terms.iterator();
		while(iter.hasNext()) {
			Term t = iter.next();
			result += t.calc(x);
		}
		return result;
		
	}
	
	public String toString() {
		String result = "";
		Iterator<Term> iter = terms.iterator();
		while(iter.hasNext()) {
			Term t = iter.next();
			result += ("+"+t.toString());
		}
		return result;
	}
}
