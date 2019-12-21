package BigIntCalculator;

/** BigIntCaculator 클래스
 * addBigInt 메서드와 subtractBigInt 메서드가 포함되어 있는 클래스
 * @author Ku
 */
public class BigIntCaculator {
	/** addBigInt 메서드
	 * @param a 피연산자 a
	 * @param b 피연산자 b
	 * @return result 결과 값 반환
	 */
	public BigInt addBigInt(BigInt a, BigInt b) {
		Node aNode = a.bigIntValue; // aNode는 a의 bigIntValue 즉 a의 head
		Node bNode = b.bigIntValue; // bNode는 b의 bigIntValue 즉 b의 head
		
		int n = aNode.getDigit() +bNode.getDigit(); // n은 aNode와 bNode의 digit합이다
		
		BigInt result = new BigInt(String.valueOf(n%10)); // result는 n을 10으로 나눈 나머지가 저장 즉, 오름수를 제외한 수가 저장된다.
		
		// resultTmp는 result의 bigIntValue값을 받아 저장한다.
		// 이 변수는 최종적인 합을 저장 할 것이다.
		Node resultTmp = result.bigIntValue; 
		
		aNode = aNode.next; // aNode의 다음 Node를 가져온다
		bNode = bNode.next; // bNode의 다음 Node를 가져온다
		
		// aNode와 bNode가 모두 null이 아닌 동안 실행된다. 즉, aNode나 bNode가 null이 되면 종료한다.
		while(aNode != null && bNode != null) {
			// aNode의 digit값과 bNode의 digit값, n의 오름수(13이라면 1을 말한다)를 더한다.
			n = n/10+aNode.getDigit() + bNode.getDigit();
			resultTmp.next = new Node(n%10, resultTmp, null); // 위에서 구한값은 오름값을 제외하고 resultTmp의 다음 노드에 저장된다.
			aNode = aNode.next; // aNode의 다음 Node를 가져온다.
			bNode = bNode.next; // bNode의 다음 Node를 가져온다.
			resultTmp = resultTmp.next; // resultTmp도 다음 노드를 가져온다.
		}
		
		// aNode나 bNode 둘중 하나가 null이 되었지만 다른 하나가 null이 아닐때 아래 while문들이 실행된다.
		// aNode가 null이 아니라면
		while(aNode != null) {
			// aNode의 digit값에 오름수를 더하고 이를 resultTmp의 다음 노드로 저장한다.
			// 단순히 위 while문의 연산을 aNode만 사용하여 이어가는 것이다.
			n = n/10+aNode.getDigit();
			resultTmp.next = new Node(n%10, resultTmp, null);
			aNode = aNode.next;
			resultTmp = resultTmp.next;
		}
		
		// bNode가 null이 아니라면
		while(bNode != null) {
			// bNode의 digit값에 오름수를 더하고 이를 resultTmp의 다음 노드로 저장한다.
			// 단순히 위 while문의 연산을 bNode만 사용하여 이어가는 것이다.
			n = n/10+bNode.getDigit();
			resultTmp.next = new Node(n%10, resultTmp, null);
			bNode = bNode.next;
			resultTmp = resultTmp.next;
		}
		//aNode와 bNode의 마지막 Node들의 연산이 오름수를 만들었다면
		if(n > 9)
			resultTmp.next = new Node(n/10, resultTmp, null); // 그 오름수를 resultTmp의 마지막에 저장한다.
		
		return result; // result를 반환하고 마친다.
	}
	
	
	/** subtractBigInt 메서드
	 * @param a 피연산자 a
	 * @param b 피연산자 b
	 * @return result 결과 값 반환
	 */
	public BigInt subtractBigInt(BigInt a, BigInt b) {
		Node aNode = a.bigIntValue; // aNode는 a의 bigIntValue 즉 a의 head
		Node bNode = b.bigIntValue; // bNode는 b의 bigIntValue 즉 b의 head
		int n;
		int temp; // 연산으 편의성을 위해 사용 될 것이다.
		
		// 만약 aNode의 digit값이 bNode의 digit값보다 크거나 같다면
		if(aNode.getDigit() >= bNode.getDigit()) {
			n = aNode.getDigit() - bNode.getDigit(); // n은 aNode와 bNode의 digit차 이다
			temp = 0;
		}
		// 그 외의 경우 즉, bNode의 digit값이 더 크다면
		else {
			n = (10 + aNode.getDigit()) - bNode.getDigit(); // n은 10 + aNode의 digit값 - bNode의 digit 값이다
			temp = 1;
		}
		
		BigInt result = new BigInt(String.valueOf(n)); // 절대값 n은 10을 넘어갈수 없으므로 n만이 저장된다.
		
		// resultTmp는 result의 bigIntValue값을 받아 저장한다.
		// 이 변수는 최종적인 차를 저장 할 것이다.
		Node resultTmp = result.bigIntValue; 
		
		aNode = aNode.next; // aNode의 다음 Node를 가져온다
		bNode = bNode.next; // bNode의 다음 Node를 가져온다
		
		// aNode와 bNode가 모두 null이 아닌 동안 실행된다. 즉, aNode나 bNode가 null이 되면 종료한다.
		while(aNode != null && bNode != null) {
			// aNode의 digit값과 bNode의 digit값, n의 내림수(a-b=-6 이라면 1을 말한다)를 뺀다.
			// 주석 설명에서 a와 b의 같은 자리 수 뺄셈에서 a의 수가 더 작다면 그 윗자리 수에서 1을 받아 10을 더해서 뺄셈을 진행하므로 윗 자리수에 1을 빼 주어야한다.
			// 이때 그 1을 내림수라 하겠다.
			n = (aNode.getDigit()- temp) - bNode.getDigit();
			temp = 0; // temp값이 연산에 사용 되었으므로 0으로 초기화 시켜준다.
			// n이 0보다 작다면
			if(n < 0) {
				n = n + 10; // n값에 10을 더해준 값을 n에 저장하고
				temp = 1; // 다음 연산에서 a의 윗자리에 1을 빼주기 위해 temp에 1을 저장한다. 
			}
			resultTmp.next = new Node(n, resultTmp, null); // n값을 resultTmp의 다음 노드에 저장된다.
			aNode = aNode.next; // aNode의 다음 Node를 가져온다.
			bNode = bNode.next; // bNode의 다음 Node를 가져온다.
			resultTmp = resultTmp.next; // resultTmp도 다음 노드를 가져온다.
		}
		
		// aNode나 bNode 둘중 하나가 null이 되었지만 다른 하나가 null이 아닐때 아래 while문들이 실행된다.
		// aNode가 null이 아니라면
		while(aNode != null) {
			// aNode의 digit값에 내림수를 빼고 조건에 맞춰 resultTmp의 다음 노드로 저장한다.
			// 단순히 위 while문의 연산을 aNode만 사용하여 이어가는 것이다.
			n = aNode.getDigit() - temp;
			temp = 0; // temp값이 연산에 사용 되었으므로 0으로 초기화 시켜준다.
			// n이 0보다 작다면
			if(n < 0) {
				n = n + 10; // n값에 10을 더해준 값을 n에 저장하고
				temp = 1; // 다음 연산에서 a의 윗자리에 1을 빼주기 위해 temp에 1을 저장한다. 
			}
			resultTmp.next = new Node(n, resultTmp, null); // n값을 resultTmp의 다음 노드에 저장한다.
			aNode = aNode.next; // aNode의 다음 Node를 불러온다.
			resultTmp = resultTmp.next; // resultTmp의 다음 노드를 불러온다.
		}
				
		// bNode가 null이 아니라면
		while(bNode != null) {
			// temp의 값을 받아온다. temp값이 1이라면
			if (temp == 1) {
				//resultTmp의 digit는 윗자리의 값을 받아와 연산 후 저장한다.
				resultTmp.setDigit(10 - resultTmp.getDigit());
			}
			// 만약 bNode의 next가 0이면 다음 연산은 없는 것으로 판단하고 n에 -값을 저장한다.
			if(bNode.next == null) {
				n = -bNode.getDigit();
			}
			// 그렇지 않으면 n에 bNode의 digit값을 받고 나중에 윗 자리의 값을 받아와 연산 후 다시 저장한다.
			else {
				n = bNode.getDigit();
			}
			// 위 조건문들이 모두 돌면 resultTmp에 n값을 digit로 저장한다.
			resultTmp.next = new Node(n, resultTmp, null);
			bNode = bNode.next;
			resultTmp = resultTmp.next;	
		}
		return result; // result를 반환하고 마친다.
	}
}
