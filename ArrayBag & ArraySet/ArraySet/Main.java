package ArraySet;

public class Main {
	public static void main(String args[]) {
		//ArraySet��ü�� �����Ѵ�.
		ArraySet arraySet = new ArraySet();
		
		//arraySet�� �ùٸ��� �۵��ϴ��� �˻��Ѵ�.
		System.out.println("* Hi ���� �߰�");
		System.out.println("--------------------------------------");
		arraySet.add("Hi");
		arraySet.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* Hi ���� ����");
		System.out.println("--------------------------------------");
		arraySet.remove("Hi");
		arraySet.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* ArrayBag�� �����?");
		System.out.println("--------------------------------------");
		System.out.println(arraySet.isEmpty());
		System.out.println("--------------------------------------");
		
		System.out.println("* ���� �߰�");
		System.out.println("--------------------------------------");
		arraySet.add("�����");
		arraySet.add("�����");
		arraySet.add("201802049");
		arraySet.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* ���� ���� ���");
		System.out.println("--------------------------------------");
		System.out.println(arraySet.size());
		System.out.println("--------------------------------------");
		
		System.out.println("* �й��� Bag�� �����ϴ°�?");
		System.out.println("--------------------------------------");
		System.out.println(arraySet.contains("201802049"));
		System.out.println("--------------------------------------");
		
		System.out.println("* ù��° ���� ����");
		System.out.println("--------------------------------------");
		arraySet.removeFirst();
		arraySet.printAll();
		System.out.println("--------------------------------------");
	}
}
