package Hashtable;

/** BasicHashtable Ŭ����
 * Hashtable�� ���� �⺻������ �޼��尡 ���ԵǾ� �ִ� Ŭ����
 * @author NoA
 *
 */
public class Hashtable {
	private Entry[] entries; // hash����Ʈ �ʵ�
	private int size; // �迭�� ũ�� �ʵ�
	
	/** BasicHashtable������
	 * @param capacity Hashtable�� �뷮�� �Ű����� �޾ƿ�
	 */
	public Hashtable(int capacity) {
		this.entries = new Entry[capacity]; // Entry����Ʈ ��ü ����
		this.size = 0; // Hashtable�� ó�� ũ��� 0��
	}
	
	/** get�޼���
	 * param�� key�� key������ ���� ��Ʈ���� value���� ��ȯ�ϴ� �޼���
	 * @param key ã���� �ϴ� �ؽ��� key��
	 * @return param���� key�� ���� �ؽ��� value��
	 */
	public Object get(Object key) {
		return entries[hash(key)].getValue(); // key���� ���� �ؽ��� value���� ��ȯ�Ѵ�.
	}
	
	/** hash�޼���
	 * �ؽ� ���̺� ������ ��Ʈ���� index���� ��ȯ���ϴ� �޼���
	 * @param key �ؽ��� key��
	 * @return �ؽ� �ε��� ��
	 * 
	 * ���� �� ���� 
	 * hashCode�� ObjectŬ������ �޼���� ��� �ٸ� �޼��忡 ��ӵǾ� ���ȴ�.
	 * �� �޼���� ��ü�� �޸� �ּҸ� 32��Ʈ�� ������ ��ȯ�ϴµ� �̴� ����� ���� �ְ� ������ ���� �ִ�.
	 * ���� �����÷ο츦 �����ϱ� ���� �񱳿������� ����� �ٲپ��ش�. (0x7fffffff�� �񱳿���)
	 * �׸��� �׿� ���� ����� entry�迭�� ���̷� �����ٸ� key�� ����� �ε����� ��Ÿ���� �ȴ�.
	 * (�̴� �迭�� �޸� �ּ� ,�� �����Ϳ� ���� ��Ÿ�� �� �ֱ� ������ ������ �����̴�.)
	 */
	public int hash(Object key) {
		// ���� key���� ���ٸ� -1�� ��ȯ�Ѵ�.
		if(key == null)
			return -1;
		return (key.hashCode()&0x7fffffff)%entries.length; // �ؽ� �ε��� ��ȯ
	}
	
	/** put�޼���
	 * key���� value���� ���� ��Ʈ���� �콬���̺� �߶��ϴ� �޼���
	 * @param key �ؽ����̺� ������ ��Ʈ���� key��
	 * @param value �ؽ����̺� ������ ��Ʈ���� value��
	 * @return put�� ���� ��ȯ���� ���� �����Ƿ� null�� ��ȯ�Ѵ�.
	 */
	public Object put(Object key, Object value) {
		Entry newEntry = new Entry(key, value, null); // ����� �� ��Ʈ��
		
		// �ش� ���̺��� ����ִٸ�
		if(entries[hash(key)] == null)
			entries[hash(key)] = newEntry; // newEntry�� �ؽ����̺� �����Ѵ�.
		// ������� �ʴٸ�
		else {
			Entry tmp = entries[hash(key)]; // tmp�� �ش� ���̺��ڸ��� ��Ʈ������ Ž���� ��Ʈ��
			// tmp�� next�� ��� ���� �� ���� tmp�� next�� �����Ѵ�.
			while(tmp.getNext() != null) 
				tmp = tmp.getNext();
			// ����ִ� �ڸ��� �߰��ϸ� �� �ڸ��� ���ο� ��Ʈ���� �߰��Ѵ�.
			tmp.setNext(newEntry);
		}
		++size; // ���ο� entry�� �߰��Ǿ����Ƿ� size���� �ø���.
		return null; // ��ȯ���� ���� ����
	}
	
	/** remove�޼���
	 * param���� key�� ���� ��Ʈ���� �����ϴ� �޼���
	 * @param key �ؽ����̺� ����� ��Ʈ�� �� param�� key�� key������ ���� ��Ʈ���� �����ϴ� �޼���
	 * @return value - ������ entry�� value���� ��ȯ
	 */
	public Object remove(Object key) {
		int hashIndex = hash(key); // key�� key������ ���� ��Ʈ���� �ε����� �����ϴ� �ʵ�
		Object value = null; // value�� ������ entry���� ��ȯ �� ���̴�.
		
		Entry tmp = entries[hashIndex]; // tmp�� �ش� �ؽ����̺� �ڸ��� ��Ʈ������ Ž���Ѵ�.
		// ���� tmp�� key���� param���� �����ϴٸ� �� �ؽ����̺� ��Ʈ���� next�� ���� ��Ʈ���� ����� ���� ��Ʈ���� �����Ѵ�.
		if(tmp.getKey() == key)
			entries[hashIndex] = tmp.getNext();
		
		// ���� ��쿡 �ش����� �ʴ´ٸ� break�� �ްų� ��� ��Ʈ���� Ž���� ������ �ݺ��Ѵ�.
		while(tmp.getNext() != null) {
			// ���� �ش� �ؽ����̺� �ڸ��� ����Ǿ� �ִ� ��Ʈ�� �� key���� ���� ��Ʈ���� �ִٸ� �� ���� ��Ʈ���� ����� �����ϰ� �����Ѵ�.
			if(tmp.getNext().getKey() == key) {
				value = tmp.getNext().getValue();
				tmp.setNext(tmp.getNext().getNext());
				break;
			}
			tmp = tmp.getNext(); // �ؽ����̺� Ž��
		}
		--size; // �ϳ��� ��Ʈ���� �����Ǿ����Ƿ� size�� �پ���.
		return value; // ������ ��Ʈ���� value�� ��ȯ
	}
	
	/** size�޼���
	 * �ؽ����̺��� size�� ��ȯ�ϴ� �޼���
	 * @return size - �ؽ����̺��� size (����� ��Ʈ�� ��)
	 */
	public int size() {
		return this.size; // size�� ��ȯ
	}
	
	/** printEntries �޼���
	 * �ؽ����̺� ����� ��� entry�� ����ϴ� �޼���
	 */
	public void printEntries() {
		// entries�� ���̸�ŭ ��, ��� entry�� ����Ѵ�.
		for(int i = 0; i < this.entries.length; i++) {
			
			// ����ִ� �ؽ����̺� �ڸ��� ������� �ʴ´�.
			if(this.entries[i] != null) {
				// tmp�� ���Ḯ��Ʈ�� ����� ��� ��Ʈ������ ����ϱ� ���� ��� �� ���̴�.
				Entry tmp = entries[i];
				// ���̺� �ڸ� ǥ��
				System.out.print("Table["+i+"] = ");
				// �ش� ���̺� �ڸ��� �ִ� ��� ��Ʈ���� ����Ѵ�. next�� ->�� ���� ǥ���� �ֵ��� �Ѵ�.
				while(tmp != null) {
					System.out.print(tmp.getKey().toString() + " , " + tmp.getValue().toString());
					// ->�� ǥ���� ���� ������ ��Ʈ�������� ������� �ʵ��� �Ѵ�.
					if(tmp.getNext() != null)
						System.out.print(" -> ");
					tmp = tmp.getNext();
				}
				System.out.println();
			}
		}
	}
}
