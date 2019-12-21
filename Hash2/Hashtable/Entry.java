package Hashtable;

/** EntryŬ����
 * key���� ���� value���� ����Ǵ� EntryŬ����
 * @author NoA
 *
 */
public class Entry {
	private Object key; // key��
	private Object value; // value��
	
	/** Entry������
	 * 
	 * @param k key���� �Ű��� �޾� ������
	 * @param v value���� �Ű��� �޾� ������
	 */
	public Entry(Object k, Object v) {
		this.key = k;
		this.value = v;
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
	
	/** setValue�޼���
	 * 
	 * @param value �� Entry�� value���� value������ ����
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}