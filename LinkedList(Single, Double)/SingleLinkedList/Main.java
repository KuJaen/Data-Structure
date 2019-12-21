package SingleLinkedList;

/**
 * 메인 함수
 * 메인 함수는 실습자료에 있는 코드를 그대로 옮겼습니다.
 * SingleLinkedList의 객체를 생성하여 LinkedList가 올바르게 작동하는지 확인합니다.
 * @author Ku
 */
public class Main {
	public static void main(String[] args) {
		SingleLinkedList sl = new SingleLinkedList();
		sl.insert("안녕하세요");
		sl.printList();
		System.out.println("--------------------");
		sl.insert("즐거운");
		sl.printList();
		System.out.println("--------------------");
		sl.insert("자료구조");
		sl.printList();
		System.out.println("--------------------");
		sl.insert("시간입니다.");
		sl.printList();
		System.out.println("--------------------");
		sl.delete("안녕하세요");
		sl.printList();
		System.out.println("--------------------");
	}
}
