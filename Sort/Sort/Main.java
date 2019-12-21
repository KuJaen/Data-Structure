package Sort;

// 메인 함수
public class Main {
	public static void main(String[] args) {
		SortFunction SF = new SortFunction(); //Sort메서드들이 들어있는 객체 생성
		
		// 시간을 측정하기 위해 사용 될 변수
		long startTime = 0;
		long endTime = 0;
		
		// 정렬 이전 Array 출력
		System.out.println("* Original Number Array ------------------------------");
		System.out.println();
		//SF.printOriginalArray();
		System.out.println("------------------------------------------------------");
		
		
		//Bubble Sort이후 메서드 출력
		System.out.println("* Bubble Sort Result ---------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // 시작 시간 측정
		SF.bubbleSort();
		endTime = System.nanoTime(); // 종료 시간 측정
		//SF.printSortedArray();
		System.out.println("Bubble Sort Time : " + (endTime - startTime)); // 걸린 시간 출력
		System.out.println("------------------------------------------------------");
		
		
		// Selection Sort이후 메서드 출력
		System.out.println("* Selection Sort Result ------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // 시작 시간 측정
		SF.selectionSort();
		endTime = System.nanoTime(); // 종료 시간 측정
		//SF.printSortedArray();
		System.out.println("Selection Sort Time : " + (endTime - startTime)); // 걸린 시간 출력
		System.out.println("------------------------------------------------------");
		
		
		// Quick Sort이후 메서드 출력
		System.out.println("* Quick Sort Result ----------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // 시작 시간 측정
		SF.quickSort(0,99999);
		endTime = System.nanoTime(); // 종료 시간 측정
		//SF.printSortedArray();
		System.out.println("Quick Sort Time : " + (endTime - startTime)); // 걸린 시간 출력
		System.out.println("------------------------------------------------------");
		
		
		// Insertion Sort이후 메서드 출력
		System.out.println("* Insertion Sort Result ------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // 시작 시간 측정
		SF.insertionSort();
		endTime = System.nanoTime(); // 종료 시간 측정
		//SF.printSortedArray();
		System.out.println("Insertion Sort Time : " + (endTime - startTime)); // 걸린 시간 출력
		System.out.println("------------------------------------------------------");
	}
}
