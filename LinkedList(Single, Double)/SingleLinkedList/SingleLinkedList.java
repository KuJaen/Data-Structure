package SingleLinkedList;

/** SingleLinkedList Ŭ����
 * Node head ����Node ��, ���� �տ� �ִ� Node
 * int size List�� ũ�� ��, List�� ���Ե� Node�� ��
 * @author Ku
 */
public class SingleLinkedList implements LinkedList{
	private Node head;
	private int size;
	
	/** SingleLinkedList�� ������
	 * ó�� head���� null�� ����
	 * ó�� size���� 0���� ����
	 */
	public SingleLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	/** insert �޼���
	 * �������̽�(LinkedList.java) ����
	 */
	@Override
	public boolean insert(Object data) {
		// TODO Auto-generated method stub
		// head�� null�̸�
		if(this.head == null) {
			// head�� ���ο� ��带 �߰��ϰ� size�� 1�� �߰��Ѵ�.
			this.head = new Node(data, null);
			this.size++;
			return true; // ���������� insert�� �̷�� �����Ƿ� true��ȯ
		}
		// head�� null�� �ƴϸ�
		else {
			Node tmp = this.head; //tmp�� List�� Ž���ϴµ� ���� NodeŸ�� �����̴�.
			
			// List�� ���� ��, List�� ���κ��� ã���ش�.
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			
			// List�� �����κп� ���ο� Node�� �߰��ϰ� size�� 1�� �߰��Ѵ�.
			tmp.next = new Node(data, null);
			this.size++;
			
			return true; // ���������� insert�� �̷�� �����Ƿ� true��ȯ
		}
	}

	/** delete �޼���
	 * �������̽�(LinkedList.java) ����
	 */
	@Override
	public boolean delete(Object target) {
		// TODO Auto-generated method stub
		// head�� null�̸� ��, ������ ��尡 ���ٸ�
		if(this.head == null)
			return false; // delete�� �̷������ �ʾ����� false�� ��ȯ�Ͽ� �˸�
		
		Node tmp = this.head; // tmp�� List�� Ž���ϴµ� ��� �� NodeŸ�� �����̴�.
		Node prevTmp = null; // prevTmp�� tmp�� ���� Node�� �ǹ��Ѵ�.
		
		// tmp�� null�� �� ������ ��, ��� Node�� �˻��Ѵ�.
		while(tmp != null) {
			// ���� target�� �ش��ϴ� data���� ���� Node�� �ִٸ�
			if(tmp.getData().equals(target)) {
				Node nextNode = tmp.next; // nextNode�� tmp�� ���� Node�� �Ǹ��Ѵ�.
				// �� ���ǹ��� target���� ���� Node�� head�� ���� ��쿡 �ش��Ѵ�.
				if(prevTmp == null) {
					// head���� nextNode�� �����Ͽ� ���� head���� �����Ѵ�.
					head = nextNode;
				}
				// target���� ���� Node�� head�� �ƴ� �ٸ� ���� ���� ���
				else {
					// prevTmp�� ���� Node�� nextNode�̴�. �� �� ��带 ������ �ش�. 
					// ���� �� Node���̿� �ִ� tmp�� ���� ����̹Ƿ� ������������ �������.
					prevTmp.next = nextNode;
				}
				
				this.size--; // Node�� �����Ǿ����Ƿ� size�� ũ�⸦ �ٿ��ش�.
				return true; // ���������� delete�Ǿ����� true�� ��ȯ�Ͽ� �˸���.
			}
			// target�� �ش��ϴ� data���� ���� Node�� ���ٸ� prevTmp�� tmp���� tmp�� ���� tmp���� �޾� Ž���� ����Ѵ�.
			prevTmp = tmp;
			tmp = tmp.next;
		}
		return false; // ��� Node�� Ž���ϰ� �ش� data���� ���� Node�� ���ٸ� false�� ��ȯ�Ѵ�.
	}

	/** contains �޼���
	 * �������̽�(LinkedList.java) ����
	 */
	@Override
	public boolean contains(Object searchingData) {
		// TODO Auto-generated method stub
		Node tmp = this.head; // tmp�� List�� Ž���� �� ��� �� NodeŸ�� �����̴�.
		
		if(tmp.getData() == searchingData)
			return true;
		
		// List ��ü�� Ž���Ѵ�.
		while(tmp.next != null) {
			// ���� searchingData���� ��ġ�ϴ� data���� ���� Node�� �ִٸ� true�� ��ȯ�Ѵ�.
			if(tmp.getData().equals(searchingData)) {
				return true;
			}
			// tmp�� ���� Node�� �̵����� �ָ鼭 Ž���Ѵ�.
			tmp = tmp.next;
		}
		// serachingData�� ������ data���� ���� Node�� ���ٸ� false�� ��ȯ�Ѵ�.
		return false;
	}
	
	/** size �޼���
	 * �������̽�(LinkedList.java) ����
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size; // size�� ��ȯ�Ѵ�.
	}

	/** printList
	 * �������̽�(LinkedList.java) ����
	 */
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		Node tmp = this.head; // List��ü�� Ž���ϴµ� ���� NodeŸ�� ����
		
		// List ��ü�� Ž���ϸ鼭 Data�� ���
		while(tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.next;
		}
	}
}
