package Heapify;

/** ���� Ŭ����
 * ���� �Լ��� insert�޼���� delete�޼��尡 ����� �۵��ϴ��� �׽�Ʈ�Ѵ�.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		MaxHeap MH = new MaxHeap(10); // MaxHeap��ü ����
		
		// insert�޼��带 �׽�Ʈ�Ѵ�
		System.out.println("insert() �׽�Ʈ");
		MH.insert(3);
		MH.insert(10);
		MH.insert(6);
		MH.insert(8);
		MH.insert(5);
		MH.insert(7);
		MH.insert(11);
		MH.print();
		
		// delete�޼��带 �׽�Ʈ�Ѵ�
		System.out.println("\ndelete() �׽�Ʈ");
		System.out.println("delete1ȸ");
		MH.delete();
		MH.print();
		System.out.println("\ndelete2ȸ");
		MH.delete();
		MH.print();
		System.out.println("\ndelete3ȸ");
		MH.delete();
		MH.print();
	}
}
