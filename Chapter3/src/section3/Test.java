package section3;

public class Test {	//subclass of object

	public int a = 10;
	public double x = 1.23;
	
	public String toString() {
		return a+", "+x;
	}
	
	public boolean equals(Object other) {
		Test other2 = (Test)other;
		return a==other2.a && x==other2.x;
	}
	
	public static void main(String [] args) {
//		Test t1 = new Test();
//		Test t2 = new Test();
////		t2.a = 5;
////		t2.x = 1.248549;
//		
//		System.out.println(t1.toString());
//		
//
//		if(t2.equals(t1)) {
//			System.out.println("yes");
//		}else {
//			System.out.println("no");
//		}
		
		Object [] array = new Object[100];
//		
		int a = 20;
//		Integer age = new Integer(a);	//wrapping
		
		array[0] = a;	//Autoboxing
		
		int b = (Integer)array[0];	//Autounboxing
		System.out.println(b);
		
//		int b = age.intValue();	//unwrapping
		
		Object [] theArray = new Object[100];
		theArray[0] = 10;
//		int a = (Integer)theArray[0];
//		System.out.println(a);
		
	}
}
