package section4;

import java.util.Arrays;
import java.util.Scanner;

public class Schedular {

	private int capacity = 10;
	public Event [] events = new Event[capacity];
	public int n = 0;
	private Scanner kb;
	
	public void processCommand() {
		kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("addevent")) {
				String type = kb.next();	//Event 종류 입력 받음
				if(type.equalsIgnoreCase("oneday")) {
					handleAddOneDayEvent();
				}else if(type.equalsIgnoreCase("duration")) {
					handleAddDurationEvent();
				}else if(type.equalsIgnoreCase("deadline")) {
					handleAddDeadlinedEvent();
				}
			}else if(command.equals("list")) {
				handleList();
			}else if(command.equals("show")) {
				// 특정 날짜가 포함되는 이벤트 출력
				// oneday : 일치 여부
				// duration : 날짜 사이에 있는지
				// deadline : 데드라인 전인지
				handleShow();
			}else if(command.equals("sort")) {
				Arrays.sort(events,0,n);
			}else if(command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}
	
	private void handleShow() {
		String dateString = kb.next();
		MyDate theDate = parseDateString(dateString);
		for(int i=0;i<n;i++) {
			if(events[i].isRelevant(theDate)) {
				System.out.println(events[i].toString());
			}
		}
	}

	private void handleList() {
		for(int i=0;i<n;i++) {
			System.out.println("    "+events[i].toString());
		}
		
	}

	private void handleAddDeadlinedEvent() {
		System.out.print("  when: ");
		String dateString = kb.next();
		System.out.print("  title: ");
		String title = kb.next();
		
		MyDate date = parseDateString(dateString);
		
		DeadlinedEvent ev = new DeadlinedEvent(title, date);	
		events[n++] = ev;
		
	}
	
	private void handleAddDurationEvent() {
		System.out.print("  Begin Date: ");
		String begin = kb.next();
		System.out.print("  End Date: ");
		String end = kb.next();
		System.out.print("  Title: ");
		String title = kb.next();
		
		MyDate d1 = parseDateString(begin);
		MyDate d2 = parseDateString(end);
		
		DurationEvent ev = new DurationEvent(title, d1, d2);
		events[n++] = ev;
		
	}
	
	private void handleAddOneDayEvent() {
		System.out.print("  when: ");
		String dateString = kb.next();	//2025/12/05
		System.out.print("  title: ");
		String title = kb.next();
		
		MyDate date = parseDateString(dateString);
		
		OneDayEvent ev = new OneDayEvent(title, date);	
		addEvent(ev);
	}

	private void addEvent(Event ev) {
		if(n >= capacity) {
			reallocate();
		}
		events[n++] = ev;	//events는 Event 클래스이지만 다형성으로 OneDayEvent를 assignment함
	}

	private void reallocate() {
		Event [] tmp = new Event[capacity *2];
		for(int i=0;i<n;i++){
			tmp[i] = events[i];
		}
		events = tmp;
		capacity *= 2;
	}

	private MyDate parseDateString(String dateString) {
		String [] tokens = dateString.split("/");
		
		int year =Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);
		
		MyDate d = new MyDate(year, month, day);
		return d;
	}

	public static void main(String[] args) {
		Schedular app = new Schedular();
		app.processCommand();
	}

}
