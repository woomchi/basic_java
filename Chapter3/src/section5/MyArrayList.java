package section5;

import java.util.Arrays;

public class MyArrayList<E> {
	
	private static final int INIT_CAPACITY = 10;
	private E [] theData;
	private int size;
	private int capacity = INIT_CAPACITY;
	
	public MyArrayList(){
		theData = (E [])new Object [INIT_CAPACITY];	//new를 통해 객체를 생성할 때 가상의 타입을 사용하는 것은 금지 => 가상 타입 배열로 casting
		size = 0;
	}
	
	public void add(int index, E anEntry) {
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);	//자바식 처리
		}
		if(size>=capacity) {
			reallocate();
		}
		for(int i=size-1;i>=index;i--) {
			theData[i+1] = theData[i];	
		}
		theData[index] = anEntry;	
		size++;
	}
	
	private void reallocate() {
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity);
	}

	public void add(E enEntry) {
		add( size,enEntry );
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(E anEntry) {
		for(int i=0;i<size;i++) {
			if(theData[i].equals(anEntry)) {
				return i;
			}
		}
		return -1;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}
	
	public E set(int index, E newValue) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for(int i=0;i<size;i++) {
			theData[i-1] = theData[i];
		}
		size--;
		return returnValue;
	}
	
	public static void main(String [] args) {
		MyArrayList<String> test = new MyArrayList<>();
		try {
			test.add(1, "hello");			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("-----------");
		}
		System.out.println("***********");
	}
	
}
