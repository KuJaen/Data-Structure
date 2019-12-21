package BigIntCalculator;

import BigIntCalculator.Node;

/** BigInt Ŭ����
 * @author Ku
 * bigIntValue�� 8��Ʈ �̻��� ���� 1�� �ڸ��� digit���� ���� Node�̴�. �� ��� BigInt Node�� head�̴�.
 * BigInt�� DoubleLinkedList�� ���·� �����ϰڴ�.
 */
public class BigInt {
	public Node bigIntValue;
	
	/** BigInt�� ������
	 * 8����Ʈ �̻��� ���� 1�� �ڸ����� �������� Node�� �����Ѵ�.
	 * @param bigIntStrValue 8����Ʈ �̻��� ���� String������ �޾ƿ�
	 */
	public BigInt(String bigIntStrValue) {
		// bigIntValue�� bigIntStrValue�� 1�� �ڸ��� digit���� �ϴ� Node�� �����Ѵ�.
		this.bigIntValue = new Node(Integer.parseInt(bigIntStrValue.substring(bigIntStrValue.length()-1, bigIntStrValue.length())), null, null);
		Node p = bigIntValue; // p�� ��� Node�� Ž���Ҷ� ����Ѵ�.
		
		// p�� ����Ͽ� bigIntValue�� head�� bigIntStrValue�� �������� �����Ѵ�.
		for(int i = bigIntStrValue.length()-2; i >= 0; i--) {
			p.next = new Node(Integer.parseInt(bigIntStrValue.substring(i, i+1)), p, null);
			p = p.next;
		}
	}
	
	/** printBigInt �޼���
	 * BigInt�� ����Ѵ�.
	 */
	public void printBigInt() {
		Node tmp = bigIntValue; // tmp�� BigInt�� Node�� Ž���ϴµ� ��� �ȴ�.
		String digitStr = ""; // digitStr�� BigInt�� String������ �����Ѵ�.
		
		// BigInt�� Node�� ó������ ������ Ž���Ͽ� digitStr�� head���� ���������� �����Ѵ�.
		while(tmp != null) {
			digitStr = String.valueOf(tmp.getDigit()) + digitStr;
			tmp = tmp.next;
		}
		
		// digitStr�� ����Ѵ�
		System.out.println(digitStr.toString());
	}
	
	/** getBigInt �޼���
	 * ���Ǹ� ���� �߰��� digit���� String���� ��ȯ�ϴ� �޼���
	 * @return digitStr digit���� String ������ ��ȯ�Ѵ�.
	 */
	public String getBigInt() {
		Node tmp = bigIntValue; // tmp�� BigInt�� Node�� Ž���ϴµ� ��� �ȴ�.
		String digitStr = ""; // digitStr�� BigInt�� String������ �����Ѵ�.
		
		// BigInt�� Node�� ó������ ������ Ž���Ͽ� digitStr�� head���� ���������� �����Ѵ�.
		while(tmp != null) {
			digitStr = String.valueOf(tmp.getDigit()) + digitStr;
			tmp = tmp.next;
		}
		return digitStr;
	}
}
