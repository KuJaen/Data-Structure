package Hashtable;

/** ���� Ŭ����
 * BasicHashtable�� ����� �ܼ� �۾� (����)
 * @author NoA
 */
public class Main {
	public static void main(String[] args) {
		Hashtable libraryHashTable = new Hashtable(15);
		
		// put �޼��带 �׽�Ʈ
		System.out.println("* Put Test --------------------------------------------------\n");
		System.out.println("\"��ҿ�\" : \"���޷���\" �߰�");
		libraryHashTable.put("��ҿ�", "���޷���"); // key: ��ҿ�     value: ���޷���
		System.out.println("\"������\" : \"������� ��\" �߰�");
		libraryHashTable.put("������", "��� ���� ��"); // key: ������     value: ��� ���� ��
		System.out.println("\"������\" : \"�����\" �߰�");
		libraryHashTable.put("������", "�����"); // // key: ������     value: �����
		System.out.println("\"������\" : \"����\" �߰�");
		libraryHashTable.put("������", "����"); // // key: ������     value: ����
		System.out.println("\"�ڸ��\" : \"������ �ҹ�\" �߰�");
		libraryHashTable.put("�ڸ��", "������ �Ҹ�"); // // key: �ڸ��     value: ������ �ҹ�
		libraryHashTable.printEntries(); // hashtable ���
		
		// remove �޼��� �׽�Ʈ
		System.out.println("\n* Remove Test ----------------------------------------------");
		System.out.println("������ ����");
		libraryHashTable.remove("������");
		libraryHashTable.printEntries();
		
		System.out.println("\n\n��ҿ� ����");
		libraryHashTable.remove("��ҿ�");
		libraryHashTable.printEntries();
		
		// reHashing �׽�Ʈ
		System.out.println("\n* Rehash Test ----------------------------------------------");
		System.out.println("\"������\" : \"���\" �߰�");
		libraryHashTable.put("������", "���"); // key: ������     value: ���
		System.out.println("\"������\" : \"û����\" �߰�");
		libraryHashTable.put("������", "û����"); // key: ������     value: û����
		System.out.println("\"�ڰ渮\" : \"����\" �߰�");
		libraryHashTable.put("�ڰ渮", "����"); // key: �ڰ渮     value: ����
		System.out.println("\"�����\" : \"���̵� �����\" �߰�");
		libraryHashTable.put("�����", "���̵� �����"); // key: �����     value: ���̵� �����
		System.out.println("\"�̻�\" : \"����\" �߰�");
		libraryHashTable.put("�̻�", "����"); // key: �̻�     value: ����
		System.out.println("\"������\" : \"����� ��\" �߰�");
		libraryHashTable.put("������", "����� ��"); // key: ������     value: ����� ��
		System.out.println("\"������\" : \"��� �����\" �߰�");
		libraryHashTable.put("������", "��� �����"); // key: ������     value: ��� �����
		System.out.println("\"�迵��\" : \"����� �Ǳ������\" �߰�");
		libraryHashTable.put("�迵��", "����� �Ǳ������"); // key: �迵��     value: ����� �Ǳ������
		System.out.println("\"��ҿ�\" : \"���޷���\" �߰�");
		libraryHashTable.put("��ҿ�", "���޷���"); // key: ��ҿ�     value: ���޷���
		libraryHashTable.printEntries();
		
	}
}
