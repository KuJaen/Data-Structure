package Heap;

/** TestHeapify 클래스
 * Heap과정을 테스트 하는 메서드이다.
 * @author NoA
 *
 */
public class TestHeapify {
	/** buildHeap 메서드
	 * Heap을 세우는 메서드
	 * @param a heap을 구성하는 인자들을 갖는 배열을 매개로 받음
	 * @param i heap을 재귀적으로 사용하기 위한 매개변수. 인자들의 위치를 나타낸다.
	 * @param n heap의 크기
	 */
	public static void buildHeap(int[] a, int i, int n) {
		// 한쪽 서브트리는 전체크기의 반이다. 따라서 heap을 빌드 할때 왼쪽서브트리 따로 오른쪽 서브트리 따로 빌드하므로 i가 n/2보다 크거나 같아지면 정지한다.
		if(i >= n/2) 
			return;
		buildHeap(a, 2*i+1, n); // 왼쪽 서브트리 빌드
		buildHeap(a, 2*i+2, n); // 오른쪽 서브트리 빌드
		heapify(a,i,n); // 루트를 고려한 전체 서브트리 구성
		printArray(a); // heap을 출력한다.
	}
	
	/** heapify 메서드
	 * i를 root로 한 heap 서브트리를 heap한다. heap은 작은쪽 즉 level이 높은 곳 부터 heap이 이루어지면서 전체 트리를 heap하게 된다.
	 * @param array heap이 이루어지는 array
	 * @param i 서브트리의 root
	 * @param n 전체트리의 크기
	 */
	public static void heapify(int[] array, int i, int n) {
		int array_i = array[i]; // array_i는 루트를 나타낸다.
		
		// buildHeap메서드에서도 설명했듯이 두 서브트리로 나뉘어 heap을 진행하므로 i가 전체크기의 반일 때까지 이루어진다.
		while(i < n/2) {
			int j = 2*i + 1; // 왼쪽 서브트리의 index
			
			// j+1 즉, 오른쪽 서브트리가 n보다 작고 오른쪽 서브트리가 왼쪽 서브트리보다 클 때
			if(j+1 < n && array[j+1] > array[j])
				++j; // ++j : 두 노드 중 크기가 큰 노드가 heap에 참여한다.
			// j가 array_i 즉, root를 넘어갈 때 heap은 진행되지 않는다.
			if(array[j] <= array_i) // 만약 루트가 heap이 이루어질 노드 보다 크다면 break
				break;
			
			// 기존 root보다 큰 노드를 발견하면 heap 진행
			array[i] = array[j];
			i = j; // heap을 진행한후 i는 heap이 이루어진 서브노드의 index를 가르킨다.
		}
		array[i] = array_i; // heap이 이루어진 서브노드를 root의 값으로 변경
	}
	
	/** printArray 메서드
	 * 
	 * @param array heap의 인자들을 담고있는 리스트
	 */
	public static void printArray(int[] array) {
		// array의 모든 인자들을 출력한다.
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	/** 메인함수
	 * heap되기 전 array를 출력하고 heap이 한번 이루어질 때마다 array를 다시 출력한다.
	 * @param args .
	 */
	public static void main(String[] args) {
		int[] array = {22,33,44,55,66,77,88,99}; // array 구성
		printArray(array);
		buildHeap(array, 0, array.length);
	}
}
