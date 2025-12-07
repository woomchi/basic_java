package section1;

public class MySingleLinkedList<T> {

	public Node<T> head;
	public int size;	//보유 노드 개수
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(T item) {	//새로운 노드 생성 및 추가
		Node<T> newNode = new Node<T>(item);	//T : type parameter
		newNode.next = head;
		head = newNode;
		size++;
	}
	public void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<T>(item);
		temp.next = before.next;
		before.next = temp;	
		size++;
	}
	
	public T removeFirst() {
		if(head == null) {
			return null;
		}else {
			T temp = head.data;
			head = head.next;
			size--;
			return temp;
		}
	}

	public T removeAfter(Node<T> before) {
		if(head == null) {
			return null;
		}else {			
			T temp = before.next.data;
			before.next = (before.next).next;
			size--;
			return temp;
		}
	}
	
	public void add(int index, T item) {	//insert
		if(index <0 || index>size) {
			return;
		}
		if(index == 0) {	//특수 케이스
			addFirst(item);
		}else {			
			Node<T> q = getNode(index-1);	//index번째 전 노드를 찾아 연결시키는데 사용
			addAfter(q, item);
		}
	}
	
	public T remove(int index) {	//delete
		if(index <0 || index>size) {
			return null;
		}
		if(index == 0) {
			return removeFirst();
		}else {
			Node<T> q = getNode(index-1);
			return removeAfter(q);
		}
		
	}
	
	public T remove(T item) {
		Node<T> p = head;
		Node<T> q= null;	//p(head) 이전 노드가 존재하지 않으므로 null임
		while(p!=null && !p.data.equals(item)) {
			q=p;	//다음 노드로 이동하기 전에 q에 p를 저장해놓으면 이전 노드가 저장됨
			p=p.next;
		}
		if(p==null) {
			return null;
		}
		if(q==null) {	// 첫번째 노드에서 찾았을 때
			return removeFirst();
		}else {
			return removeAfter(q);
		}
	}
	
	
	public int indexOf(T item) {	//search
		Node<T> p = head;
		int index = 0;
		while(p!=null) {
			if(p.data.equals(item)) {
				return index;
			}
			p=p.next;
			index++;
		}
		return -1;
	}
	
	public Node<T> getNode(int index){
		if(index<0 || index>=size) {
			return null;
		}
		Node<T> p = head;
		for(int i=0;i<index;i++) {
			p=p.next;
		}
		return p;
	}
	
	public T get(int index) {
		if(index<0 || index>=size) {
			return null;
		}
//		Node<T> p = head;
//		for(int i=0;i<index;i++) {
//			p=p.next;
//		}
//		return p.data;
			
		return getNode(index).data;
	}

	public static void main(String[] args) {
		
		MySingleLinkedList<String> list = new MySingleLinkedList<String>();
//		list.add(0, "Saturday");
//		list.add(1, "Friday");	// S, F
//		list.add(0, "Monday");	// M, S, F
//		list.add(2, "Tuesday");	// M, S, T, F
//		
//		String str = list.get(2);
//		list.remove(2);
//		int pos = list.indexOf("Friday");
		
		list.addFirst("Monday");	//M
		list.addFirst("Sunday");	//Sun M
		list.add(2, "Saturday");	//Sun M Sat
		list.add(2, "Friday");		//Sun M F Sat
		list.remove("Friday");		//Sun M Sat
		int index = list.indexOf("Saturday");
		System.out.println(index);
	}

}
