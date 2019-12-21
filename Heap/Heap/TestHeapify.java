package Heap;

/** TestHeapify Ŭ����
 * Heap������ �׽�Ʈ �ϴ� �޼����̴�.
 * @author NoA
 *
 */
public class TestHeapify {
	/** buildHeap �޼���
	 * Heap�� ����� �޼���
	 * @param a heap�� �����ϴ� ���ڵ��� ���� �迭�� �Ű��� ����
	 * @param i heap�� ��������� ����ϱ� ���� �Ű�����. ���ڵ��� ��ġ�� ��Ÿ����.
	 * @param n heap�� ũ��
	 */
	public static void buildHeap(int[] a, int i, int n) {
		// ���� ����Ʈ���� ��üũ���� ���̴�. ���� heap�� ���� �Ҷ� ���ʼ���Ʈ�� ���� ������ ����Ʈ�� ���� �����ϹǷ� i�� n/2���� ũ�ų� �������� �����Ѵ�.
		if(i >= n/2) 
			return;
		buildHeap(a, 2*i+1, n); // ���� ����Ʈ�� ����
		buildHeap(a, 2*i+2, n); // ������ ����Ʈ�� ����
		heapify(a,i,n); // ��Ʈ�� ����� ��ü ����Ʈ�� ����
		printArray(a); // heap�� ����Ѵ�.
	}
	
	/** heapify �޼���
	 * i�� root�� �� heap ����Ʈ���� heap�Ѵ�. heap�� ������ �� level�� ���� �� ���� heap�� �̷�����鼭 ��ü Ʈ���� heap�ϰ� �ȴ�.
	 * @param array heap�� �̷������ array
	 * @param i ����Ʈ���� root
	 * @param n ��üƮ���� ũ��
	 */
	public static void heapify(int[] array, int i, int n) {
		int array_i = array[i]; // array_i�� ��Ʈ�� ��Ÿ����.
		
		// buildHeap�޼��忡���� �����ߵ��� �� ����Ʈ���� ������ heap�� �����ϹǷ� i�� ��üũ���� ���� ������ �̷������.
		while(i < n/2) {
			int j = 2*i + 1; // ���� ����Ʈ���� index
			
			// j+1 ��, ������ ����Ʈ���� n���� �۰� ������ ����Ʈ���� ���� ����Ʈ������ Ŭ ��
			if(j+1 < n && array[j+1] > array[j])
				++j; // ++j : �� ��� �� ũ�Ⱑ ū ��尡 heap�� �����Ѵ�.
			// j�� array_i ��, root�� �Ѿ �� heap�� ������� �ʴ´�.
			if(array[j] <= array_i) // ���� ��Ʈ�� heap�� �̷���� ��� ���� ũ�ٸ� break
				break;
			
			// ���� root���� ū ��带 �߰��ϸ� heap ����
			array[i] = array[j];
			i = j; // heap�� �������� i�� heap�� �̷���� �������� index�� ����Ų��.
		}
		array[i] = array_i; // heap�� �̷���� �����带 root�� ������ ����
	}
	
	/** printArray �޼���
	 * 
	 * @param array heap�� ���ڵ��� ����ִ� ����Ʈ
	 */
	public static void printArray(int[] array) {
		// array�� ��� ���ڵ��� ����Ѵ�.
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	/** �����Լ�
	 * heap�Ǳ� �� array�� ����ϰ� heap�� �ѹ� �̷���� ������ array�� �ٽ� ����Ѵ�.
	 * @param args .
	 */
	public static void main(String[] args) {
		int[] array = {22,33,44,55,66,77,88,99}; // array ����
		printArray(array);
		buildHeap(array, 0, array.length);
	}
}
