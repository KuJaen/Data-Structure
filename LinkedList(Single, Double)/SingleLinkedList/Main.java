package SingleLinkedList;

/**
 * ���� �Լ�
 * ���� �Լ��� �ǽ��ڷῡ �ִ� �ڵ带 �״�� �Ű���ϴ�.
 * SingleLinkedList�� ��ü�� �����Ͽ� LinkedList�� �ùٸ��� �۵��ϴ��� Ȯ���մϴ�.
 * @author Ku
 */
public class Main {
	public static void main(String[] args) {
		SingleLinkedList sl = new SingleLinkedList();
		sl.insert("�ȳ��ϼ���");
		sl.printList();
		System.out.println("--------------------");
		sl.insert("��ſ�");
		sl.printList();
		System.out.println("--------------------");
		sl.insert("�ڷᱸ��");
		sl.printList();
		System.out.println("--------------------");
		sl.insert("�ð��Դϴ�.");
		sl.printList();
		System.out.println("--------------------");
		sl.delete("�ȳ��ϼ���");
		sl.printList();
		System.out.println("--------------------");
	}
}
