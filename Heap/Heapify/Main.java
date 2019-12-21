package Heapify;

/** 메인 클래스
 * 메인 함수는 insert메서드와 delete메서드가 제대로 작동하는지 테스트한다.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		MaxHeap MH = new MaxHeap(10); // MaxHeap객체 생성
		
		// insert메서드를 테스트한다
		System.out.println("insert() 테스트");
		MH.insert(3);
		MH.insert(10);
		MH.insert(6);
		MH.insert(8);
		MH.insert(5);
		MH.insert(7);
		MH.insert(11);
		MH.print();
		
		// delete메서드를 테스트한다
		System.out.println("\ndelete() 테스트");
		System.out.println("delete1회");
		MH.delete();
		MH.print();
		System.out.println("\ndelete2회");
		MH.delete();
		MH.print();
		System.out.println("\ndelete3회");
		MH.delete();
		MH.print();
	}
}
