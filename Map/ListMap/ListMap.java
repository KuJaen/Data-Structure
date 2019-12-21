package ListMap;

/**
 * ListMapŬ����
 * @author Ku
 */
public class ListMap implements Map {
	private Entry entry; // entry ���� ����
	private int size; // size ���� ����. �̴� entry�� ���� �ǹ��Ѵ�.
	
	/** 
	 * ListMap������
	 */
	public ListMap() {
		this.entry = null; // ó�� entry�� ����ִ�.
		this.size = 0; // entry�� ó������ ����ֱ� ������ �ʱ� size���� 0�̴�.
	}
	
	/** get�޼���
	 * key���� ���� entry�� �ִ��� �˻��ϴ� �޼���
	 * return null
	 */
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		Entry tmp = this.entry; // tmp�� Entry���� Ž���� Entry�����̴�.
		
		// tmp�� null���� ������ ���� ��, ��� Entry�� �˻��ϰų� return�� �̷��� ������ �˻縦 ����Ѵ�.
		while(tmp != null) {
			// ���� key���� ���� entry�� �ִٸ�
			if(tmp.getKey().equals(key)) {
				return tmp.getValue(); // �ش� entry�� value���� ��ȯ�ϰ� �����Ѵ�.
			}
			tmp = tmp.next; // ���ٸ� ���� Entry�� �˻��Ѵ�. 
		}
		// ��� entry�� �˻��ϰ� key���� ���� Entry�� ���ٸ� null�� ��ȯ�ϰ� ��ģ��.
		return null;
	}
	
	/**
	 * put�޼���
	 * key���� value���� ���� Entry�� ���������� �����Ѵ�. �̶� value���� �ش� key���� ���� Ƚ�� ī��Ʈ�̴�.
	 * return oldValue ������ key���� ���� Entry�� �ִٸ�
	 * return null ������ key���� ���� Entry�� ���ٸ�
	 */
	@Override
	public Object put(Object key, int value) {
		// TODO Auto-generated method stub
		// ���� ��� entry�� ����ִٸ�
		if(entry == null) {
			// ó������ �Ű����� key���� value���� ���� Entry�� �߰��Ѵ�.
			entry = new Entry(key, value, null);
			this.size++; // ���ο� Entry�� �߰��Ǿ����Ƿ� size���� 1�� �߰��Ѵ�. 
			return null; // �Ű����� key���� ���� Entry�� ������ �������� �ʾ����Ƿ� null�� ��ȯ�Ѵ�.
		}
		
		//tmp�� ������ ������ ���� ���� ������ Entry�����̴�.
		Entry tmp = entry;
		
		// tmp�� null�϶� ���� ��, return�� �̷�����ų� ��� Entry�� �˻��� ������ Ž���Ѵ�.
		while(tmp != null) {
			// ���� key���� ���� Entry�� �̹� �����Ѵٸ�
			if(tmp.getKey().equals(key)) {
				// �ش� Entry�� value���� oldValue�� �����ϰ� Ƚ�� value���� 1�� �߰����ش�.
				Object oldValue = tmp.getValue(); 
				tmp.setValue(tmp.getValue()+1);
				return oldValue; // ���� Entry�� value���� ��ȯ�ϰ� ��ģ��.
			}
			
			//���� tmp.next�� null�̸� ��, ��� Entry�� Ž���ߴٸ� �����Ѵ�.
			if(tmp.next == null)
				break;
			tmp = tmp.next; // Entry�� ���������� �˻��Ѵ�.
		}
		
		tmp = entry; // tmp�� ���� ��� �˻縦 �� ���̹Ƿ� entry�� �ʱ�ȭ �����ش�.
		
		// tmp ��, ���� �տ� �ִ� Entry entry�� key���� �Ű����� key���� ���Ͽ� ������ �켱������ ���Ѵ�.
		// ���� �Ű����� key���� �� �켱���̶�� 
		if(tmp.getKey().toString().compareTo(key.toString()) > 0) {
			Entry tmp2 = new Entry(key, value, null); // tmp2�� ���ο� Entry�� �����Ѵ�.
			// tmp2�� tmp������ Entry�� �� ���̸� ���ο� entry�� �� ���̴�.
			tmp2.next = tmp;
			entry = tmp2;
			size++; // ���ο� Entry�� �߰��Ǿ����Ƿ� size�� ũ�⸦ �÷��ش�.
			return null; // �Ű����� key���� ��ġ�� ���� ���� Entry�� �������Ƿ� null�� ��ȯ�Ѵ�.
		}
		
		// tmp�� null�϶� ���� ��, return�� �̷�����ų� ��� Entry�� �˻��� ������ Ž���Ѵ�.
		while(tmp != null) {
			// tmp���� Entry�� null���� ��� �˻��Ѵ�. ���� null�̶�� �Ű����� key���� ���� Entry�� �߰��Ѵ�.
			if(tmp.next == null) {
				tmp.next = new Entry(key,value,null);
				size++; // ���ο� Entry�� �߰��Ǿ����Ƿ� size�� ũ�⸦ �÷��ش�.
				break; // Entry�� ������ �߰� �Ǿ����Ƿ� break��.
			}
			
			// tmp���� Entry�� null�� �ƴ϶��
			if(tmp.next!= null) {
				// tmp���� Entry�� �Ű����� key���� ������ �켱������ �Ǻ��Ѵ�. ���� ���� key�� �� �켱���̶�� 
				if(tmp.next.getKey().toString().compareTo(key.toString())>0) {
					Entry tmp2 = tmp.next; // tmp2�� �����Ͽ� tmp�� ���� Entry�� �������ش�.
					// tmp�� ���� Entry�� ���ο� Entry�� ������� �� ���� Entry�� tmp2�� ������ List�� �о��ش�.
					tmp.next = new Entry(key, value, null);
					tmp.next.next = tmp2;
					
					size++; // ���ο� Entry�� �߰��Ǿ����Ƿ� �������� ũ�⸦ �÷��ش�.
					break; // Entry�� ������ �߰� �Ǿ����Ƿ� break��.
				}
			}
			tmp = tmp.next; // �� �� ���ǿ��� �������� ������ tmp�� �ٿ� Entry�� �ٲپ��ָ� �˻縦 ��� �����Ѵ�.
		}
		return null; // �Ű����� key���� ��ġ�� ���� ���� Entry�� �������Ƿ� null�� ��ȯ�Ѵ�.
	}
	
	/**
	 * size�޼���
	 * return size
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size; //size�� ũ�⸦ ��ȯ�Ѵ�.
	}

	/**
	 * remove�޼���
	 * return true remove�� �����Ͽ��ٸ�
	 * return false remove�� �����ߴٸ�
	 */
	@Override
	public boolean remove(Object key) {
		// TODO Auto-generated method stub
		
		// ���� entry == null�̶�� ��, List�� ����ִٸ�
		if(entry == null)
			return false; // remove�� �̷������ �ʾ����� false�� ��ȯ�Ͽ� �˸���.
		
		// �׷��� �ʴٸ� tmp�� entry�� �����Ͽ� �˻��Ѵ�.
		Entry tmp = this.entry;
		// return���� ��ȯ�ǰų� Ȥ�� ��� Entry�� �˻��� ������ Ž���Ѵ�.
		while(tmp != null) {
			//���� �Ű����� key�� �ش��ϴ� ���� ���� Entry�� �ִٸ�
			if(tmp.next.getKey().equals(key)) {
				// tmp�� ���� ���� Entry�� nextEntry�� �����Ͽ� �ش� Entry���� ������ �����Ѵ�.
				Entry nextEntry = tmp.next.next;
				tmp.next = nextEntry;
				this.size--; // Entry�� �ϳ� �پ����Ƿ� size�� ũ�⸦ �ٿ��ش�.
				return true; // �ùٸ��� remove�� �̷�������� true�� ��ȯ�Ͽ� �˸���.
			}
			// �� ������ �̷������ �ʾҴٸ� tmp�� ���� Entry�� �����Ͽ� ��� Ž���Ѵ�.
			tmp = tmp.next;
		}
		
		return false; // �ش� key���� ���� Entry�� ���ٸ� false�� ��ȯ�Ѵ�.
	}
	
	/**
	 * printList�޼���
	 * ��� Entry�� ����ϴ� �޼����̴�.
	 */
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		Entry tmp = this.entry; // tmp�� ù��° Entry���� ������ Entry���� ���������� �����ȴ�.
		
		// ù���� Entry���� ������ Entry���� Key���� �ش��ϴ� Value���� ����Ѵ�.
		while(tmp != null) {
			System.out.println(tmp.getKey() + " : " + tmp.getValue());
			tmp = tmp.next;
		}
	}
}
