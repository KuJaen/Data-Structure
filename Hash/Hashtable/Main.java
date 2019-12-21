package Hashtable;

/** ���� Ŭ����
 * BasicHashtable�� ����� �ܼ� �۾� (����)
 * @author NoA
 */
public class Main {
	public static void main(String[] args) {
		Hashtable libraryHashTable = new Hashtable(15);
		
		// put �޼��带 �׽�Ʈ�Ѵ�.
		System.out.println("* Put Test --------------------------------------------------\n");
		libraryHashTable.put("��ҿ�", "���޷���"); // key: ��ҿ�     value: ���޷���
		libraryHashTable.put("������", "��� ���� ��"); // key: ������     value: ��� ���� ��
		libraryHashTable.put("������", "�����"); // // key: ������     value: �����
		libraryHashTable.put("������", "����"); // // key: ������     value: ����
		libraryHashTable.put("������", "û����"); // // key: ������     value: û����
		libraryHashTable.put("�ڸ��", "������ �Ҹ�"); // // key: �ڸ��     value: ������ �ҹ�
		libraryHashTable.put("������", "���"); // // key: ������     value: ���
		libraryHashTable.printEntries(); // hashtable ���
		
		// remove �޼��� �׽�Ʈ
		System.out.println("\n* Remove Test ----------------------------------------------");
		System.out.println("������ ����\n");
		libraryHashTable.remove("������");
		libraryHashTable.printEntries();
		
		System.out.println("\n��ҿ� ����\n");
		libraryHashTable.remove("��ҿ�");
		libraryHashTable.printEntries();
		
		//get�޼��� �׽�Ʈ
		System.out.println("\n* Get Test -------------------------------------------------");
		System.out.println("������ Value = " + libraryHashTable.get("������"));
		
		// �ؽ����̺��� Collision���� üũ
		System.out.println("\n* Collision Test -------------------------------------------\n");
		libraryHashTable.put("������", "�� ��� ��");
		libraryHashTable.put("������", "����");
		libraryHashTable.printEntries();
	}
}
