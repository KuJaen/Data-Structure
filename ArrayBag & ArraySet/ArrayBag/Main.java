package ArrayBag;

public class Main {
	public static void main(String args[]) {
		//arrayBag�� ��ü�� �����Ѵ�.
		ArrayBag arrayBag = new ArrayBag();
		
		//arrayBag�� �ùٸ��� �۵��ϴ��� �˻��Ѵ�.
		System.out.println("* Hi ���� �߰�");
		System.out.println("--------------------------------------");
		arrayBag.add("Hi");
		arrayBag.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* Hi ���� ����");
		System.out.println("--------------------------------------");
		arrayBag.remove("Hi");
		arrayBag.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* ArrayBag�� �����?");
		System.out.println("--------------------------------------");
		System.out.println(arrayBag.isEmpty());
		System.out.println("--------------------------------------");
		
		System.out.println("* ���� �߰�");
		System.out.println("--------------------------------------");
		arrayBag.add("�����");
		arrayBag.add("�����");
		arrayBag.add("201802049");
		arrayBag.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* ���� ���� ���");
		System.out.println("--------------------------------------");
		System.out.println(arrayBag.size());
		System.out.println("--------------------------------------");
		
		System.out.println("* �й��� Bag�� �����ϴ°�?");
		System.out.println("--------------------------------------");
		System.out.println(arrayBag.contains("201802049"));
		System.out.println("--------------------------------------");
		
		System.out.println("* ù��° ���� ����");
		System.out.println("--------------------------------------");
		arrayBag.removeFirst();
		arrayBag.printAll();
		System.out.println("--------------------------------------");
	}
}
