package DoubleLinkedList;

/**
 * ���� �Լ�
 * ���� �Լ��� �ǽ��ڷῡ �ִ� �ڵ带 �״�� �Ű���ϴ�.
 * DoubleLinkedList�� ��ü�� �����Ͽ� LinkedList�� �ùٸ��� �۵��ϴ��� Ȯ���մϴ�.
 * @author Ku
 */
public class Main {
	public static void main(String[] args) {
		DoubleLinkedList dl = new DoubleLinkedList();
		dl.insert("�ȳ��ϼ���");
		dl.printList();
		System.out.println("--------------------");
		dl.insert("��ſ�");
		dl.printList();
		System.out.println("--------------------");
		dl.insert("�ڷᱸ��");
		dl.printList();
		System.out.println("--------------------");
		dl.insert("�ð��Դϴ�.");
		dl.printList();
		System.out.println("--------------------");
		dl.delete("�ȳ��ϼ���");
		dl.printList();
		System.out.println("--------------------");
	}
}
