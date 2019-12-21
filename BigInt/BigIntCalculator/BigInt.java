package BigIntCalculator;

import BigIntCalculator.Node;

/** BigInt 클래스
 * @author Ku
 * bigIntValue는 8비트 이상의 수의 1의 자리를 digit으로 갖는 Node이다. 즉 모든 BigInt Node의 head이다.
 * BigInt는 DoubleLinkedList의 형태로 구현하겠다.
 */
public class BigInt {
	public Node bigIntValue;
	
	/** BigInt의 생성자
	 * 8바이트 이상의 수를 1의 자리부터 역순으로 Node에 저장한다.
	 * @param bigIntStrValue 8바이트 이상의 수를 String형으로 받아옴
	 */
	public BigInt(String bigIntStrValue) {
		// bigIntValue에 bigIntStrValue의 1의 자리를 digit으로 하는 Node를 저장한다.
		this.bigIntValue = new Node(Integer.parseInt(bigIntStrValue.substring(bigIntStrValue.length()-1, bigIntStrValue.length())), null, null);
		Node p = bigIntValue; // p는 모든 Node를 탐색할때 사용한다.
		
		// p를 사용하여 bigIntValue를 head로 bigIntStrValue를 역순으로 저장한다.
		for(int i = bigIntStrValue.length()-2; i >= 0; i--) {
			p.next = new Node(Integer.parseInt(bigIntStrValue.substring(i, i+1)), p, null);
			p = p.next;
		}
	}
	
	/** printBigInt 메서드
	 * BigInt를 출력한다.
	 */
	public void printBigInt() {
		Node tmp = bigIntValue; // tmp는 BigInt의 Node를 탐색하는데 사용 된다.
		String digitStr = ""; // digitStr은 BigInt를 String형으로 저장한다.
		
		// BigInt의 Node를 처음부터 끝까지 탐색하여 digitStr에 head부터 순차적으로 저장한다.
		while(tmp != null) {
			digitStr = String.valueOf(tmp.getDigit()) + digitStr;
			tmp = tmp.next;
		}
		
		// digitStr을 출력한다
		System.out.println(digitStr.toString());
	}
	
	/** getBigInt 메서드
	 * 편의를 위해 추가한 digit값을 String으로 반환하는 메서드
	 * @return digitStr digit값을 String 형으로 반환한다.
	 */
	public String getBigInt() {
		Node tmp = bigIntValue; // tmp는 BigInt의 Node를 탐색하는데 사용 된다.
		String digitStr = ""; // digitStr은 BigInt를 String형으로 저장한다.
		
		// BigInt의 Node를 처음부터 끝까지 탐색하여 digitStr에 head부터 순차적으로 저장한다.
		while(tmp != null) {
			digitStr = String.valueOf(tmp.getDigit()) + digitStr;
			tmp = tmp.next;
		}
		return digitStr;
	}
}
