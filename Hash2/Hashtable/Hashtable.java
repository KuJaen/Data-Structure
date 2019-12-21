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
	 * key���� value���� ���� ��Ʈ���� �콬���̺� �߰��ϴ� �޼���
	 * @param key �ؽ����̺� ������ ��Ʈ���� key��
	 * @param value �ؽ����̺� ������ ��Ʈ���� value��
	 * @return put�� ���� ��ȯ���� ���� �����Ƿ� null�� ��ȯ�Ѵ�.
	 */
	public Object put(Object key, Object value) {
		Entry newEntry = new Entry(key, value); // ���� ����� Entry����
		int hashIndex = hash(key); // newEntry�� ����� Index�� ���� (���ǿ� ���� ��� ���� �� ����)
		int tmpIndex = 0;
		
		while(tmpIndex < entries.length) {
			if(entries[tmpIndex] != null) {
				if(entries[tmpIndex].getKey() == key) {
					entries[tmpIndex].setValue(value);
					return null;
				}
			}
		tmpIndex++;	
		}
		
		// ���� size�� entriesũ���� 70%���� ũ�ٸ� ��, �������� 70%�� �ʰ��ϸ� ���ؽ��Ѵ�.
		if(((double)size) > (double)(entries.length)*7.0/10.0) {
			reHashing(); // ���ؽ� �޼���
			// ���ؽ����� �˸��� ���ο� ���Ҹ� �߰��� �� ����� ����Ѵ�.
			System.out.println("* ������ 70%�ʰ�. ���ؽ��մϴ�. \n");
			put(key, value); // ���ؽ��� entries�� put�� �ٽ� �����Ѵ�.
			return null;
		}
		
		// put����. flag�� true�� �ٲ���� �� put�� ������ ���̴�.
		boolean flag = false;
		while(!flag) {
			// newEntry�� ������ �� entries[hashIndex]�� ������� �ʴٸ�
			if(entries[hashIndex] != null) {
				// hashIndex�� ��ĭ �ڷ� �о��ش�. �̶� ������ ĭ�̶�� ó�� Index�� ���ư���.
				// �տ��� ���ؽ��� ���� ���־��� ������ �̰����� ���ѷ����� �� ������ ����.
				if(hashIndex < entries.length-1)
					hashIndex++;
				else
					hashIndex = 0;
			}
			// ����ִٸ� �� �ڸ��� newEntry�� �߰��Ѵ�.
			else {
				entries[hashIndex] = newEntry;
				flag = true;
			}
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
		int hashIndex = hash(key); // hashIndex�� param key�� Index�̴�. �̰����� ���� ������ key�� Ž���Ѵ�.
		Object value = entries[hashIndex]; // value�� param key�� value���̴�. ������ entry�� value���� ��ȯ�ϱ� ���� ����Ѵ�.
		
		// ������ �����ϸ� flag�� true�� �ٲ�鼭 �ݺ����� �����Ѵ�.
		boolean flag = false;
		while(!flag) {
			value = entries[hashIndex]; // ��ȯ�� ���� value�� ����
			// entries[hashIndex]�� key���� param key�� �����ϴٸ� �ش� ��Ʈ���� �����ϰ� flag�� true�� ��ȯ�� �� value���� �����Ѵ�.
			if(entries[hashIndex].getKey() == key) {
				entries[hashIndex] = null;
				flag = true; // ��� �̺κ��� �ʿ� ������ Ȥ�ø� ���α׷��� �������� ���� �־� �ξ���.
				return value;
			}
			// �ش� hashIndex���� ������ �̷�� ���� �ʾҴٸ� hashIndex�� ��ĭ �ڷ� �о��ش�. �̶� hashIndex�� entries�� ������ Index�� ����Ű�� �ִٸ� 0���� �Ű��ش�.
			else {
				if(hashIndex < entries.length-1)
					hashIndex++;
				else
					hashIndex = 0;
			}
		}
		--size; // �ϳ��� ��Ʈ���� �����Ǿ����Ƿ� size�� �پ���.
		return value;
	}
	
	/** size�޼���
	 * �ؽ����̺��� size�� ��ȯ�ϴ� �޼���
	 * @return size - �ؽ����̺��� size (����� ��Ʈ�� ��)
	 */
	public int size() {
		return this.size; // size�� ��ȯ
	}
	
	/** reHashing�޼���
	 * entries�� �������� ���� ��ġ�� �ʰ��ϸ� entries�� ũ�⸦ �ø��� ���Ӱ� �ؽ����ִ� �޼���
	 */
	public void reHashing() {
		Entry[] newEntries = new Entry[entries.length*2]; // newEntries�� ���ؽ� �� Entry���� ����� ���ο� entries�� ���� entriesũ���� �ι��̴�.
		// ���� entries�� ��� Entry���� Ž���ϸ� �ϳ��� ���ؽ̵� �ڸ��� ã���� ���̴�.
		for(int i = 0; i < entries.length; i++) {
			// �ش� Index�� ������� �ʴٸ� ��, Entry�� ����Ǿ� �ִٸ�
			if(this.entries[i] != null) {
				int newHash = (this.entries[i].getKey().hashCode()&0x7fffffff) % newEntries.length; // ���ο� HashIndex�ڸ��� ã���ش�.
				
				// newEntries�� entries�� ����Ǿ� �ִ� Entry���� ������ ������ �ִ� �����̴�. flag�� true�� �ٲ�� �����Ϸ��� Entry�� ������ ����Ǿ����� ��Ÿ����.
				boolean flag = false;
				while(!flag) {
					// newEntries[newHash]�� ������� �ʴٸ� ��, �̹� �ٸ� Entry�� ����Ǿ� �ִٸ�
					if(newEntries[newHash] != null) {
						// newHash ��, ����� ��ġ�� ��ĭ �ڷ� �о��ش�. �̶� newHash�� �̹� ������ Index�� ��ġ�Ѵٸ� 0���� �Ű��ش�.
						if(newHash < newEntries.length-1)
							newHash++;
						else 
							newHash = 0;
					}
					// newEntries[newHash]�� ����ִٸ� �� �ڸ��� �����Ѵ�.
					else{
						newEntries[newHash] = entries[i];
						flag = true; // ������ ����Ǿ����Ƿ� falg�� true�� �ٲپ��ش�.
					}
				}
			}
		}
		entries = newEntries; // entries�� newEntries�� �ٲپ��ְ� ��ģ��.
	}
	
	/** printEntries �޼���
	 * �ؽ����̺� ����� ��� entry�� ����ϴ� �޼���
	 */
	public void printEntries() {
		// ��� entry�� Ž���ϸ鼭 Index�ڸ������� key��, value������ ����Ѵ�.
		for(int i = 0; i < this.entries.length; i++) {
			if(this.entries[i] != null)
				System.out.println("Table[" + i + "] = " + this.entries[i].getKey().toString()+", " + this.entries[i].getValue().toString());
		}
	}
}
