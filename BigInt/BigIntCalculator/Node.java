package BigIntCalculator;
/** Node Ŭ����
 * digit�� Node�� data�� (BigInt���� data��(digit��)�� intŸ���̹Ƿ� ���Ǽ��� ���� int������ �ۼ��Ͽ����ϴ�.)
 * next�� Node�� ���� Node�� �ǹ���
 * prev�� Node�� ���� Node�� �ǹ���.
 * @author Ku
 */
public class Node {
	private int digit;
	public Node next;
	public Node prev;
	
	/** Node�� ������
	 * @param digit Node�� digit�� ����
	 * @param next Node�� next����
	 * @param prev Node�� prev����
	 */
	public Node(int digit, Node prev, Node next)
	{
		this.digit = digit;
		this.next = next;
		this.prev = prev;
	}
	
	/** getDigit �޼���
	 * Node�� digit���� ��ȯ�ϴ� �޼���
	 * @return digit Node�� digit�� ��ȯ
	 */
	public int getDigit()
	{
		return digit;
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
	
	/** setDigit �޼���
	 * Node�� digit���� �����ϴ� �޼���
	 * @param digit ���� digit�� param���� ������
	 */
	public void setDigit(int digit)
	{
		this.digit = digit;
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
	 * @param prev prev�� param������ �����Ѵ�
	 */
	public void setPrev(Node prev)
	{
		this.prev = prev;
	}
}
