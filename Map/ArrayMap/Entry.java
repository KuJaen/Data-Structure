package Map;

/** 
 * key, value �����͸� ������ EntryŬ����
 * @author Ku
 *
 */
public class Entry {
	private Object key;
	private int value; //value���� �ܾ ���� Ƚ���� ī��Ʈ �� ���̴�
	
	/**
	 * Entry�� ������
	 * @param key
	 * @param value
	 */
	public Entry(Object key, int value) {
		this.key = key;
		this.value = value;
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
	 * setKey�޼���
	 * @param key
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	
	/** 
	 * setValue�޼���
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
