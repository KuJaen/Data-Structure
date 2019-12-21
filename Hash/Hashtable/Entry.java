package Hashtable;

/** EntryŬ����
 * key���� ���� value���� ����Ǵ� EntryŬ����
 * @author NoA
 *
 */
public class Entry {
	private Object key; // key��
	private Object value; // value��
	private Entry next;
	
	/** Entry������
	 * 
	 * @param k key���� �Ű��� �޾� ������
	 * @param v value���� �Ű��� �޾� ������
	 * @param next next��Ʈ���� ��Ÿ��
	 */
	public Entry(Object k, Object v, Entry next) {
		this.key = k;
		this.value = v;
		this.next = next;
	}
	
	/** getKey�޼���
	 * 
	 * @return key�� ��ȯ
	 */
	public Object getKey() {
		return key;
	}
	
	/** getValue�޼���
	 * 
	 * @return value�� ��ȯ
	 */
	public Object getValue() {
		return this.value;
	}
	
	public void setNext(Entry next) {
		this.next = next;
	}
	
	public Entry getNext() {
		return next;
	}
}
