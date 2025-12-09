package section4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWLinkedList<E> {
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	private static class Node<T> {
		public T data;
		public Node<T> next;
		public Node<T> prev;
		
		public Node(T item) {
			data = item;
			next = null;
		}	
	}
	
	public Iterator<E> iterator(){
		return new KWListIterator(0);
	}
	
	public Iterator<E> listiterator(){
		return new KWListIterator(0);
	}
	
	public Iterator<E> listiterator(int index){
		return new KWListIterator(index);
	}
	
	private class KWListIterator implements ListIterator<E>{

		// data member and contructor
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index;
		
		public KWListIterator(int i) {
			if(i<0 || i > size) {
				throw new IndexOutOfBoundsException();
			}
			lastItemReturned = null;
			if(i == size) {
				index = size;
				nextItem = null;
			}else {
				nextItem = head;	//입력받은 index번까지 iterator를 이동시킴
				for(index = 0 ; index < i ; index++) {
					nextItem = nextItem.next;
				}
			}
			
		}
		
		@Override
		public boolean hasNext() {
			return nextItem != null;
		}

		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;	//다음 노드로 iterator를 이동시키기 전 반환할 데이터 저장
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}

		public boolean hasPrevious() {
			// 1. 노드가 존재하는(size!=0)마지막 노드에 있어 nextItem이 null인 경우도 고려
			// 2. 마지막 노드에 있어 nextItem이 없는 경우
			return (nextItem == null && size != 0) || nextItem.prev != null;	
		}

		public E previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(nextItem == null) {	//nextItem이 없는 경우 마지막 노드이므로 null, 즉 tail임
				nextItem = tail;
			}
			nextItem = nextItem.prev;	//다음노드가 이전노드가 되고 최근 노드는 이동 후의 다음 노드가 됨
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}


		public int nextIndex() {
			return index;
		}

		public int previousIndex() {
			return index-1;
		}

		public void add(E obj) {
			// 1. 노드가 없는 경우
			if(head == null) {
				head = new Node<E>(obj);
				tail = head;
				nextItem = null;	
				index = 1;
			}else if(nextItem == head) {
				// 2. 헤드 앞에 있는 경우
				Node<E> newNode = new Node<E>(obj);
				newNode.next =  nextItem;
				nextItem.prev = newNode;
				head = newNode;
			}else if(nextItem == null) {
				//3. tail에 있는 경우
				Node<E> newNode = new Node<E>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}else {
				//4. 노드 사이에 있는 경우
				Node<E> newNode = new Node<E>(obj);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			index++;
			size++;
		}
		
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		public void set(E e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
	public int indexOf(E item) {
		Node<E> p = head;
		int i=0;
		while(i<size) {
			if(listiterator(i).equals(item)) {
				return i;
			}
			p =p.next;
			i++;
		}
		return -1;
	}
	
	public void add(int index, E item) {
		((KWLinkedList<E>.KWListIterator) listiterator(index)).add(item);
	}
	
	public E get(int index) {
		return listiterator(index).next();
	}
	
	public E remove(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		Iterator<E> iter = listiterator(index);
		E result = iter.next();
		iter.remove();
		return result;
	}
	
	public boolean remove(E obj) {
		return true;
	}
	
	public int size() {
		return size;
	}
}
