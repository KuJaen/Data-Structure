package BigIntCalculator;
/** Main  �Լ�
 * @author Ku
 * BigInt�� BigIntCaculator�� ���� ��Ų��.
 */
public class Main {
	public static void main(String[] args) {
		BigInt a = new BigInt("4359102947289"); // BigInt a����
		BigInt b = new BigInt("3147493234799"); // BigInt b����
		BigIntCaculator BIC = new BigIntCaculator(); // BigIntCaculaotr��ü ����
		
		// addBigInt ����
		System.out.println("* addBigInt ���");
		BigInt sum = BIC.addBigInt(a, b);
		sum.printBigInt();
		
		System.out.println("////////////////////");
		
		// subtractBigInt ����
		System.out.println("* subtractBigInt ���");
		sum = BIC.subtractBigInt(a, b);
		sum.printBigInt();
	}
}
