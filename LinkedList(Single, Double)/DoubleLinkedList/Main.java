package DoubleLinkedList;

/**
 * 메인 함수
 * 메인 함수는 실습자료에 있는 코드를 그대로 옮겼습니다.
 * DoubleLinkedList의 객체를 생성하여 LinkedList가 올바르게 작동하는지 확인합니다.
 * @author Ku
 */
public class Main {
	public static void main(String[] args) {
		DoubleLinkedList dl = new DoubleLinkedList();
		dl.insert("안녕하세요");
		dl.printList();
		System.out.println("--------------------");
		dl.insert("즐거운");
		dl.printList();
		System.out.println("--------------------");
		dl.insert("자료구조");
		dl.printList();
		System.out.println("--------------------");
		dl.insert("시간입니다.");
		dl.printList();
		System.out.println("--------------------");
		dl.delete("안녕하세요");
		dl.printList();
		System.out.println("--------------------");
	}
}
