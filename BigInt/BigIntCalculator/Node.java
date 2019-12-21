package BigIntCalculator;
/** Node 클래스
 * digit는 Node의 data값 (BigInt에서 data값(digit값)은 int타입이므로 편의성을 위해 int형으로 작서하였습니다.)
 * next는 Node의 다음 Node를 의미함
 * prev는 Node의 이전 Node를 의미함.
 * @author Ku
 */
public class Node {
	private int digit;
	public Node next;
	public Node prev;
	
	/** Node의 생성자
	 * @param digit Node의 digit값 설정
	 * @param next Node의 next설정
	 * @param prev Node의 prev설정
	 */
	public Node(int digit, Node prev, Node next)
	{
		this.digit = digit;
		this.next = next;
		this.prev = prev;
	}
	
	/** getDigit 메서드
	 * Node의 digit값을 반환하는 메서드
	 * @return digit Node의 digit값 반환
	 */
	public int getDigit()
	{
		return digit;
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
	
	/** setDigit 메서드
	 * Node의 digit값을 설정하는 메서드
	 * @param digit 기존 digit에 param값을 대입함
	 */
	public void setDigit(int digit)
	{
		this.digit = digit;
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
	 * @param prev prev를 param값으로 지정한다
	 */
	public void setPrev(Node prev)
	{
		this.prev = prev;
	}
}
