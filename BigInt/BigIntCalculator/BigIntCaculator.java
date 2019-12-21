package BigIntCalculator;

/** BigIntCaculator Ŭ����
 * addBigInt �޼���� subtractBigInt �޼��尡 ���ԵǾ� �ִ� Ŭ����
 * @author Ku
 */
public class BigIntCaculator {
	/** addBigInt �޼���
	 * @param a �ǿ����� a
	 * @param b �ǿ����� b
	 * @return result ��� �� ��ȯ
	 */
	public BigInt addBigInt(BigInt a, BigInt b) {
		Node aNode = a.bigIntValue; // aNode�� a�� bigIntValue �� a�� head
		Node bNode = b.bigIntValue; // bNode�� b�� bigIntValue �� b�� head
		
		int n = aNode.getDigit() +bNode.getDigit(); // n�� aNode�� bNode�� digit���̴�
		
		BigInt result = new BigInt(String.valueOf(n%10)); // result�� n�� 10���� ���� �������� ���� ��, �������� ������ ���� ����ȴ�.
		
		// resultTmp�� result�� bigIntValue���� �޾� �����Ѵ�.
		// �� ������ �������� ���� ���� �� ���̴�.
		Node resultTmp = result.bigIntValue; 
		
		aNode = aNode.next; // aNode�� ���� Node�� �����´�
		bNode = bNode.next; // bNode�� ���� Node�� �����´�
		
		// aNode�� bNode�� ��� null�� �ƴ� ���� ����ȴ�. ��, aNode�� bNode�� null�� �Ǹ� �����Ѵ�.
		while(aNode != null && bNode != null) {
			// aNode�� digit���� bNode�� digit��, n�� ������(13�̶�� 1�� ���Ѵ�)�� ���Ѵ�.
			n = n/10+aNode.getDigit() + bNode.getDigit();
			resultTmp.next = new Node(n%10, resultTmp, null); // ������ ���Ѱ��� �������� �����ϰ� resultTmp�� ���� ��忡 ����ȴ�.
			aNode = aNode.next; // aNode�� ���� Node�� �����´�.
			bNode = bNode.next; // bNode�� ���� Node�� �����´�.
			resultTmp = resultTmp.next; // resultTmp�� ���� ��带 �����´�.
		}
		
		// aNode�� bNode ���� �ϳ��� null�� �Ǿ����� �ٸ� �ϳ��� null�� �ƴҶ� �Ʒ� while������ ����ȴ�.
		// aNode�� null�� �ƴ϶��
		while(aNode != null) {
			// aNode�� digit���� �������� ���ϰ� �̸� resultTmp�� ���� ���� �����Ѵ�.
			// �ܼ��� �� while���� ������ aNode�� ����Ͽ� �̾�� ���̴�.
			n = n/10+aNode.getDigit();
			resultTmp.next = new Node(n%10, resultTmp, null);
			aNode = aNode.next;
			resultTmp = resultTmp.next;
		}
		
		// bNode�� null�� �ƴ϶��
		while(bNode != null) {
			// bNode�� digit���� �������� ���ϰ� �̸� resultTmp�� ���� ���� �����Ѵ�.
			// �ܼ��� �� while���� ������ bNode�� ����Ͽ� �̾�� ���̴�.
			n = n/10+bNode.getDigit();
			resultTmp.next = new Node(n%10, resultTmp, null);
			bNode = bNode.next;
			resultTmp = resultTmp.next;
		}
		//aNode�� bNode�� ������ Node���� ������ �������� ������ٸ�
		if(n > 9)
			resultTmp.next = new Node(n/10, resultTmp, null); // �� �������� resultTmp�� �������� �����Ѵ�.
		
		return result; // result�� ��ȯ�ϰ� ��ģ��.
	}
	
	
	/** subtractBigInt �޼���
	 * @param a �ǿ����� a
	 * @param b �ǿ����� b
	 * @return result ��� �� ��ȯ
	 */
	public BigInt subtractBigInt(BigInt a, BigInt b) {
		Node aNode = a.bigIntValue; // aNode�� a�� bigIntValue �� a�� head
		Node bNode = b.bigIntValue; // bNode�� b�� bigIntValue �� b�� head
		int n;
		int temp; // ������ ���Ǽ��� ���� ��� �� ���̴�.
		
		// ���� aNode�� digit���� bNode�� digit������ ũ�ų� ���ٸ�
		if(aNode.getDigit() >= bNode.getDigit()) {
			n = aNode.getDigit() - bNode.getDigit(); // n�� aNode�� bNode�� digit�� �̴�
			temp = 0;
		}
		// �� ���� ��� ��, bNode�� digit���� �� ũ�ٸ�
		else {
			n = (10 + aNode.getDigit()) - bNode.getDigit(); // n�� 10 + aNode�� digit�� - bNode�� digit ���̴�
			temp = 1;
		}
		
		BigInt result = new BigInt(String.valueOf(n)); // ���밪 n�� 10�� �Ѿ�� �����Ƿ� n���� ����ȴ�.
		
		// resultTmp�� result�� bigIntValue���� �޾� �����Ѵ�.
		// �� ������ �������� ���� ���� �� ���̴�.
		Node resultTmp = result.bigIntValue; 
		
		aNode = aNode.next; // aNode�� ���� Node�� �����´�
		bNode = bNode.next; // bNode�� ���� Node�� �����´�
		
		// aNode�� bNode�� ��� null�� �ƴ� ���� ����ȴ�. ��, aNode�� bNode�� null�� �Ǹ� �����Ѵ�.
		while(aNode != null && bNode != null) {
			// aNode�� digit���� bNode�� digit��, n�� ������(a-b=-6 �̶�� 1�� ���Ѵ�)�� ����.
			// �ּ� ������ a�� b�� ���� �ڸ� �� �������� a�� ���� �� �۴ٸ� �� ���ڸ� ������ 1�� �޾� 10�� ���ؼ� ������ �����ϹǷ� �� �ڸ����� 1�� �� �־���Ѵ�.
			// �̶� �� 1�� �������� �ϰڴ�.
			n = (aNode.getDigit()- temp) - bNode.getDigit();
			temp = 0; // temp���� ���꿡 ��� �Ǿ����Ƿ� 0���� �ʱ�ȭ �����ش�.
			// n�� 0���� �۴ٸ�
			if(n < 0) {
				n = n + 10; // n���� 10�� ������ ���� n�� �����ϰ�
				temp = 1; // ���� ���꿡�� a�� ���ڸ��� 1�� ���ֱ� ���� temp�� 1�� �����Ѵ�. 
			}
			resultTmp.next = new Node(n, resultTmp, null); // n���� resultTmp�� ���� ��忡 ����ȴ�.
			aNode = aNode.next; // aNode�� ���� Node�� �����´�.
			bNode = bNode.next; // bNode�� ���� Node�� �����´�.
			resultTmp = resultTmp.next; // resultTmp�� ���� ��带 �����´�.
		}
		
		// aNode�� bNode ���� �ϳ��� null�� �Ǿ����� �ٸ� �ϳ��� null�� �ƴҶ� �Ʒ� while������ ����ȴ�.
		// aNode�� null�� �ƴ϶��
		while(aNode != null) {
			// aNode�� digit���� �������� ���� ���ǿ� ���� resultTmp�� ���� ���� �����Ѵ�.
			// �ܼ��� �� while���� ������ aNode�� ����Ͽ� �̾�� ���̴�.
			n = aNode.getDigit() - temp;
			temp = 0; // temp���� ���꿡 ��� �Ǿ����Ƿ� 0���� �ʱ�ȭ �����ش�.
			// n�� 0���� �۴ٸ�
			if(n < 0) {
				n = n + 10; // n���� 10�� ������ ���� n�� �����ϰ�
				temp = 1; // ���� ���꿡�� a�� ���ڸ��� 1�� ���ֱ� ���� temp�� 1�� �����Ѵ�. 
			}
			resultTmp.next = new Node(n, resultTmp, null); // n���� resultTmp�� ���� ��忡 �����Ѵ�.
			aNode = aNode.next; // aNode�� ���� Node�� �ҷ��´�.
			resultTmp = resultTmp.next; // resultTmp�� ���� ��带 �ҷ��´�.
		}
				
		// bNode�� null�� �ƴ϶��
		while(bNode != null) {
			// temp�� ���� �޾ƿ´�. temp���� 1�̶��
			if (temp == 1) {
				//resultTmp�� digit�� ���ڸ��� ���� �޾ƿ� ���� �� �����Ѵ�.
				resultTmp.setDigit(10 - resultTmp.getDigit());
			}
			// ���� bNode�� next�� 0�̸� ���� ������ ���� ������ �Ǵ��ϰ� n�� -���� �����Ѵ�.
			if(bNode.next == null) {
				n = -bNode.getDigit();
			}
			// �׷��� ������ n�� bNode�� digit���� �ް� ���߿� �� �ڸ��� ���� �޾ƿ� ���� �� �ٽ� �����Ѵ�.
			else {
				n = bNode.getDigit();
			}
			// �� ���ǹ����� ��� ���� resultTmp�� n���� digit�� �����Ѵ�.
			resultTmp.next = new Node(n, resultTmp, null);
			bNode = bNode.next;
			resultTmp = resultTmp.next;	
		}
		return result; // result�� ��ȯ�ϰ� ��ģ��.
	}
}
