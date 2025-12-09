package section2;

import java.util.Scanner;

public class MyPolynomialApp {
	int capacity = 100;
	private Polynomial [] polys = new Polynomial[capacity];
	int n = 0;
	private Scanner kb = new Scanner(System.in);
	public MyPolynomialApp() {
		
	}
	
	public void processCommand() {
		
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("create")) {
				handleCreate();
			}else if(command.equals("add")){
				handleAdd();
			}else if(command.equals("calc")){
				handleCalc();
			}else if(command.equals("print")){
				handlePrint();
			}else if(command.equals("exit")){
				break;
			}
		}
		kb.close();
	}
	
	private void handleCreate() {
		char name = kb.next().charAt(0);
		Polynomial p = new Polynomial(name);
		polys[n++] = p;
	}

	private void handleAdd() {
		char name = kb.next().charAt(0);
		int coef = kb.nextInt();
		int expo = kb.nextInt();
		int index = find(name);
		if(index < 0) {
			System.out.println("No such polynomial");
			return;
		}
		polys[index].addTerm(coef, expo);
	}

	private int find(char name) {
		for(int i =0;i<n;i++) {
			if(polys[i].name == name) {
				return i;
			}
		}
		return -1;
	}

	private void handleCalc() {
		char name = kb.next().charAt(0);
		int x = kb.nextInt();
		int index = find(name);
		if(index < 0) {
			System.out.println("No such polynomial");
			return;
		}
		System.out.println(polys[index].calc(x));
		
	}

	private void handlePrint() {
		char name = kb.next().charAt(0);
		int index = find(name);
		if(index < 0) {
			System.out.println("No such polynomial");
			return;
		}
		System.out.println(polys[index].toString());
		
	}

	public static void main(String[] args) {
		MyPolynomialApp app = new MyPolynomialApp();
		app.processCommand();
	}

}
