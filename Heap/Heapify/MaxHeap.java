package Heapify;

/**
 * MaxHeap Ŭ���� ���Ұ� �߰��ǰų� ���� �� ������ heap������ �����ϴ� �ڷᱸ��
 * 
 * @author NoA
 *
 */
public class MaxHeap {
	private int[] Heap; // heap�� ����Ʈ �ʵ�
	private int size; // heap�� ũ�� �ʵ�

	/**
	 * MaxHeap�� ������ heap�� �ִ�ũ�⸦ �޾� MaxHeap�� ��ü ����
	 * 
	 * @param heapSize heap�� �ִ�ũ��
	 */
	public MaxHeap(int heapSize) {
		this.size = 0; // ó�� ũ��� 0 �̴�.
		Heap = new int[heapSize]; // Heap����Ʈ ����
	}

	/**
	 * print �޼��� ����Ʈ�� �θ���Ҵ� �� �ڽĿ��� �������� ���
	 */
	public void print() {
		// ��� �θ���Ҹ� ����Ѵ�.
		for (int i = 0; i <= size / 2; i++) {
			System.out.println(i); // �θ������ ���� ���
			System.out.println("Parent = " + Heap[i]); // �θ���� ���

			// ���� �ڽĿ��� ���
			if ((2 * i + 1) < this.Heap.length) {
				System.out.println("\tLeft = " + Heap[2 * i + 1]);
			}
			// ������ �ڽĿ��� ���
			if ((2 * i + 2) < this.Heap.length) {
				System.out.println("\tRight = " + Heap[2 * i + 2]);
			}

			System.out.println();
		}
	}

	/**
	 * delete�޼��� ��Ʈ �����ϴ� �޼���
	 * 
	 * @return value : ���� �� �� ��, ��Ʈ�� ��ȯ -1 : ���� ����
	 */
	public int delete() {
		// size�� 0 �̸� ������ ������
		if (size == 0)
			return -1;

		// size�� 1�̸� ��Ʈ�� 0���� �ٲٰ� size�� �ٿ���.
		else if (size == 1) {
			int value = Heap[0];
			Heap[0] = 0;
			size--;
			return value;
		}

		// size�� 2 �̻��� ���
		else {
			// ��Ʈ�� ������ ���Ҹ� �ٲ��ְ� ������ ���Ҹ�(�ٲ�� �� ��Ʈ) ������
			int value = Heap[0];
			Heap[0] = Heap[size - 1];
			Heap[size - 1] = 0;

			// ���� �ڽĿ��Ұ� ������ �ڽĿ��Һ��� Ŭ��
			if (Heap[1] > Heap[2]) {
				// ��Ʈ���� ���� �ڽĿ��Ұ� ũ�ٸ� �����ڽĿ��ҿ� ��Ʈ�� ��ġ�� ��ü�Ѵ�.
				if (Heap[0] < Heap[1]) {
					int flag = Heap[0];
					Heap[0] = Heap[1];
					Heap[1] = flag;
				}
			}

			// ������ �ڽĿ��Ұ� ���� �ڽĿ��Һ��� Ŭ��
			else {
				// ��Ʈ���� ������ �ڽĿ��Ұ� ũ�ٸ� ������ �ڽĿ��ҿ� ��Ʈ�� ��ġ�� ��ü�Ѵ�.
				if (Heap[0] < Heap[2]) {
					int flag = Heap[0];
					Heap[0] = Heap[2];
					Heap[2] = flag;
				}
			}
			size--; // ���� �� size�� �ٿ��ش�.
			return value; // ���� ��Ʈ ��ȯ
		}
	}

	/**
	 * insert�޼��� element�� �ش��ϴ� ���� ����Ʈ�� �߰��ϰ� Heap
	 * 
	 * @param element // �߰� ��
	 */
	public void insert(int element) {
		Heap[size] = element; // ����Ʈ�� �������� ���ҷ� element�߰�

		int tmp = size; // Ʈ���� Ž���ϱ� ���� tmp
		while (tmp > 0) {
			int flag = Heap[tmp]; // flag�� �� ������ �ڸ����濡 ���
			// �߰��� ���Ұ� ������ Ʈ���� ���� ���
			if (tmp % 2 == 0) {
				// �߰��� ���Ұ� �θ𺸴� Ŭ ��� ��ġ�� �ٲ���
				if (Heap[tmp] > Heap[tmp / 2 - 1]) {
					Heap[tmp] = Heap[tmp / 2 - 1];
					Heap[tmp / 2 - 1] = flag;

					tmp = tmp / 2 - 1; // ���� ������ ���� tmp�� ����
				} else // �߰��� ���Ұ� �θ���Һ��� ���� ��� break;
					break;
			}

			// �߰��� ���Ұ� ���� Ʈ���� ���� ���
			else {
				// �߰��� ���Ұ� �θ���Һ��� Ŭ ��� ��ġ�� �ٲ���
				if (Heap[tmp] > Heap[tmp / 2]) {
					Heap[tmp] = Heap[tmp / 2];
					Heap[tmp / 2] = flag;

					tmp = tmp / 2; // ���� ������ ���� tmp�� ����
				} else
					break; // �߰��� ���Ұ� �θ���Һ��� ���� ��� break;
			}
		}
		size++; // insert�� ��ġ�� size�� �ø�
	}
}
