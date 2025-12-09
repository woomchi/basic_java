package section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySingleLinkedList<T> {

	public Node<T> head;
	public int size;	//보유 노드 개수
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	//inner 클래스
	private static class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T item) {
			data = item;
			next = null;
		}	
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T>{
		private Node<T> nextNode;
		public MyIterator() {
			nextNode = head;
		}
		
		public boolean hasNext() {
			return nextNode != null;
		}
		
		public T next() {
			if(nextNode == null) {	//맨 마지막 노드
				throw new NoSuchElementException();
			}
			T val = nextNode.data;
			nextNode = nextNode.next;
			return val;
		}
		
		public void remove() {
			
		}
	}
	
	private void addFirst(T item) {	//새로운 노드 생성 및 추가
		Node<T> newNode = new Node<T>(item);	//T : type parameter
		newNode.next = head;
		head = newNode;
		size++;
	}
	private void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<T>(item);
		temp.next = before.next;
		before.next = temp;	
		size++;
	}
	
	private T removeFirst() {
		if(head == null) {
			return null;
		}else {
			T temp = head.data;
			head = head.next;
			size--;
			return temp;
		}
	}

	private T removeAfter(Node<T> before) {
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
			throw new IndexOutOfBoundsException();
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
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			return removeFirst();
		}else {
			Node<T> q = getNode(index-1);
			return removeAfter(q);
		}
		
	}
	
	public boolean remove(T item) {
		Node<T> p = head;
		Node<T> q= null;	//p(head) 이전 노드가 존재하지 않으므로 null임
		while(p!=null && !p.data.equals(item)) {
			q=p;	//다음 노드로 이동하기 전에 q에 p를 저장해놓으면 이전 노드가 저장됨
			p=p.next;
		}
		if(p==null) {
			return false;
		}
		if(q==null) {	// 첫번째 노드에서 찾았을 때
			T tmp = removeFirst();
			return tmp != null;
		}else {
			T tmp = removeAfter(q);
			return tmp != null;
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
