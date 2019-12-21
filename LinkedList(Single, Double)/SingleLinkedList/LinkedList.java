package SingleLinkedList;

/** LinkedList �������̽�
 * @author Ku
 */
public interface LinkedList {
	
	/** insert �߻�޼���
	 * List�� Object data�� �߰��Ѵ�.
	 * @param data
	 * @return true
 	 */
	public boolean insert(Object data);
	
	/** delete �߻�޼���
	 * List���� Object target�� �����Ѵ�.
	 * @param target
	 * @return true target�� List�� ���� �� ��ȯ�ȴ�.
	 * @return false target�� List�� ���� �� ��ȯ�ȴ�.
	 */
	public boolean delete(Object target);
	
	/** contains �߻�޼���
	 * List�� Object searchingData�� �ִ��� �˻��Ѵ�.
	 * @param searchingData
	 * @return true searchingData�� List�� ���� �� ��ȯ�ȴ�.
	 * @return false searchingData�� List�� ���� �� ��ȯ�ȴ�.
	 */
	public boolean contains(Object searchingData);
	
	/** size �߻�޼���
	 * List�� size�� ��ȯ�Ѵ�.
	 * @return size
	 */
	public int size();
	
	/** printList �߻�޼���
	 *  List�� ����Ѵ�.
	 */
	public void printList();
}
