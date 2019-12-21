package BigIntCalculator;
/** Main  함수
 * @author Ku
 * BigInt와 BigIntCaculator를 실행 시킨다.
 */
public class Main {
	public static void main(String[] args) {
		BigInt a = new BigInt("4359102947289"); // BigInt a정의
		BigInt b = new BigInt("3147493234799"); // BigInt b정의
		BigIntCaculator BIC = new BigIntCaculator(); // BigIntCaculaotr객체 생성
		
		// addBigInt 실행
		System.out.println("* addBigInt 결과");
		BigInt sum = BIC.addBigInt(a, b);
		sum.printBigInt();
		
		System.out.println("////////////////////");
		
		// subtractBigInt 실행
		System.out.println("* subtractBigInt 결과");
		sum = BIC.subtractBigInt(a, b);
		sum.printBigInt();
	}
}
