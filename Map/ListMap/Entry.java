package ListMap;

/** 
 * key, value �����͸� ������ EntryŬ����
 * @author Ku
 */
public class Entry {
	private Object key;
	private int value;
	public Entry next;
	
	/**
	 *  Entry������
	 * @param key
	 * @param value
	 * @param next
	 */
	public Entry(Object key, int value, Entry next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	/** getKey�޼���
	 * 
	 * @return key
	 */
	public Object getKey() {
		return this.key;
	}
	
	/** getValue�޼���
	 * 
	 * @return value
	 */
	public int getValue() {
		return this.value;
	}
	
	/** 
	 * getNext
	 * @return next
	 */
	public Entry getNext() {
		return this.next;
	}
	
	/** 
	 * setKey
	 * @param key
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	
	/** 
	 * setValue
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/** 
	 * setNext
	 * @param entry
	 */
	public void setNext(Entry entry) {
		this.next = entry;
	}
}
