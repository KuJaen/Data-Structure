package DoubleLinkedList;

/** Node 클래스
 * data는 Node의 data값
 * next는 Node의 다음 Node를 의미함
 * prev는 Node의 이전 Node를 의미함.
 * @author Ku
 */
public class Node {
	private Object data;
	public Node next;
	public Node prev;
	
	/** Node의 생성자
	 * @param data Node의 data값 설정
	 * @param next Node의 next설정
	 * @param prev Node의 prev설정
	 */
	public Node(Object data, Node next, Node prev)
	{
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	/** getData 메서드
	 * Node의 data값을 반환하는 메서드
	 * @return data Node의 data값 반환
	 */
	public Object getData()
	{
		return data;
	}
	
	/** getNext 메서드
	 * Node의 next를 반환하는 메서드
	 * @return next Node의 next 반환
	 */
	public Node getNext()
	{
		return next;
	}
	
	/** getPrev 메서드
	 * Node의 prev를 반환하는 메서드
	 * @return prev Node의 prev 반환
	 */
	public Node getPrev()
	{
		return prev;
	}
	
	/** setData 메서드
	 * Node의 data값을 설정하는 메서드
	 * @param data 기존 data에 param값을 대입함
	 */
	public void setData(Object data)
	{
		this.data = data;
	}
	
	/** setNext 메서드
	 * Node의 next를 설정하는 메서드
	 * @param next next를 param값으로 지정
	 */
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	/** setPrev 메서드
	 * Node의 prev를 설정하는 메서드
	 * @param prev prev를 param값으로 지정
	 */
	public void setPrev(Node prev)
	{
		this.prev = prev;
	}
}
