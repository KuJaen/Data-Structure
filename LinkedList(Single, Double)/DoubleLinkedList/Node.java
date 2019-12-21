package DoubleLinkedList;

/** Node Ŭ����
 * data�� Node�� data��
 * next�� Node�� ���� Node�� �ǹ���
 * prev�� Node�� ���� Node�� �ǹ���.
 * @author Ku
 */
public class Node {
	private Object data;
	public Node next;
	public Node prev;
	
	/** Node�� ������
	 * @param data Node�� data�� ����
	 * @param next Node�� next����
	 * @param prev Node�� prev����
	 */
	public Node(Object data, Node next, Node prev)
	{
		this.data = data;
		this.next = next;
		this.prev = prev;
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
	
	/** getPrev �޼���
	 * Node�� prev�� ��ȯ�ϴ� �޼���
	 * @return prev Node�� prev ��ȯ
	 */
	public Node getPrev()
	{
		return prev;
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
	
	/** setPrev �޼���
	 * Node�� prev�� �����ϴ� �޼���
	 * @param prev prev�� param������ ����
	 */
	public void setPrev(Node prev)
	{
		this.prev = prev;
	}
}
