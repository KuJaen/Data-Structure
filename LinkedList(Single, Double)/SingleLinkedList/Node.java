package SingleLinkedList;

/** Node Ŭ����
 * data�� Node�� data��
 * next�� Node�� ���� Node�� �ǹ���
 * @author Ku
 */
public class Node {
	private Object data;
	public Node next;
	
	/** Node�� ������
	 * @param data Node�� data�� ����
	 * @param next Node�� next����
	 */
	public Node(Object data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	/** getData �޼���
	 * Node�� data���� ��ȯ�ϴ� �޼���
	 * @return data Node�� data�� ��ȯ
	 */
	public Object getData()
	{
		return data;
	}
	
	/** getNext �޼���
	 * Node�� next�� ��ȯ�ϴ� �޼���
	 * @return next Node�� next ��ȯ
	 */
	public Node getNext()
	{
		return next;
	}
	
	/** setData �޼���
	 * Node�� data���� �����ϴ� �޼���
	 * @param data ���� data�� param���� ������
	 */
	public void setData(Object data)
	{
		this.data = data;
	}
	
	/** setNext �޼���
	 * Node�� next�� �����ϴ� �޼���
	 * @param next next�� param������ ����
	 */
	public void setNext(Node next)
	{
		this.next = next;
	}
}
