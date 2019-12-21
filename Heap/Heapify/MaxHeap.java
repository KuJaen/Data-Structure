package Heapify;

/**
 * MaxHeap 클래스 원소가 추가되거나 삭제 될 때마다 heap구조를 유지하는 자료구조
 * 
 * @author NoA
 *
 */
public class MaxHeap {
	private int[] Heap; // heap의 리스트 필드
	private int size; // heap의 크기 필드

	/**
	 * MaxHeap의 생성자 heap의 최대크기를 받아 MaxHeap의 객체 생성
	 * 
	 * @param heapSize heap의 최대크기
	 */
	public MaxHeap(int heapSize) {
		this.size = 0; // 처음 크기는 0 이다.
		Heap = new int[heapSize]; // Heap리스트 생성
	}

	/**
	 * print 메서드 리스트를 부모원소당 두 자식원소 형식으로 출력
	 */
	public void print() {
		// 모든 부모원소를 출력한다.
		for (int i = 0; i <= size / 2; i++) {
			System.out.println(i); // 부모원소의 레벨 출력
			System.out.println("Parent = " + Heap[i]); // 부모원소 출력

			// 왼쪽 자식원소 출력
			if ((2 * i + 1) < this.Heap.length) {
				System.out.println("\tLeft = " + Heap[2 * i + 1]);
			}
			// 오른쪽 자식원소 출력
			if ((2 * i + 2) < this.Heap.length) {
				System.out.println("\tRight = " + Heap[2 * i + 2]);
			}

			System.out.println();
		}
	}

	/**
	 * delete메서드 루트 삭제하는 메서드
	 * 
	 * @return value : 삭제 된 값 즉, 루트값 반환 -1 : 삭제 실패
	 */
	public int delete() {
		// size가 0 이면 삭제에 실패함
		if (size == 0)
			return -1;

		// size가 1이면 루트를 0으로 바꾸고 size를 줄여줌.
		else if (size == 1) {
			int value = Heap[0];
			Heap[0] = 0;
			size--;
			return value;
		}

		// size가 2 이상인 경우
		else {
			// 루트와 마지막 원소를 바꿔주고 마지막 원소를(바뀌기 전 루트) 삭제함
			int value = Heap[0];
			Heap[0] = Heap[size - 1];
			Heap[size - 1] = 0;

			// 왼쪽 자식원소가 오른쪽 자식원소보다 클때
			if (Heap[1] > Heap[2]) {
				// 루트보다 왼쪽 자식원소가 크다면 왼쪽자식원소와 루트의 위치를 교체한다.
				if (Heap[0] < Heap[1]) {
					int flag = Heap[0];
					Heap[0] = Heap[1];
					Heap[1] = flag;
				}
			}

			// 오른쪽 자식원소가 왼쪽 자식원소보다 클때
			else {
				// 루트보다 오른쪽 자식원소가 크다면 오른쪽 자식원소와 루트의 위치를 교체한다.
				if (Heap[0] < Heap[2]) {
					int flag = Heap[0];
					Heap[0] = Heap[2];
					Heap[2] = flag;
				}
			}
			size--; // 삭제 후 size를 줄여준다.
			return value; // 기존 루트 반환
		}
	}

	/**
	 * insert메서드 element에 해당하는 값을 리스트에 추가하고 Heap
	 * 
	 * @param element // 추가 값
	 */
	public void insert(int element) {
		Heap[size] = element; // 리스트의 마지막에 원소로 element추가

		int tmp = size; // 트리를 탐색하기 위한 tmp
		while (tmp > 0) {
			int flag = Heap[tmp]; // flag는 두 원소의 자리변경에 사용
			// 추가된 원소가 오른쪽 트리에 있을 경우
			if (tmp % 2 == 0) {
				// 추가된 원소가 부모보다 클 경우 위치를 바꿔줌
				if (Heap[tmp] > Heap[tmp / 2 - 1]) {
					Heap[tmp] = Heap[tmp / 2 - 1];
					Heap[tmp / 2 - 1] = flag;

					tmp = tmp / 2 - 1; // 다음 연산을 위해 tmp값 변경
				} else // 추가된 원소가 부모원소보다 작을 경우 break;
					break;
			}

			// 추가된 원소가 왼쪽 트리에 있을 경우
			else {
				// 추가된 원소가 부모원소보다 클 경우 위치를 바꿔줌
				if (Heap[tmp] > Heap[tmp / 2]) {
					Heap[tmp] = Heap[tmp / 2];
					Heap[tmp / 2] = flag;

					tmp = tmp / 2; // 다음 연산을 위해 tmp값 변경
				} else
					break; // 추가된 원소가 부모원소보다 작을 경우 break;
			}
		}
		size++; // insert를 마치면 size를 늘림
	}
}
