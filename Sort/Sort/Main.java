package Sort;

// ���� �Լ�
public class Main {
	public static void main(String[] args) {
		SortFunction SF = new SortFunction(); //Sort�޼������ ����ִ� ��ü ����
		
		// �ð��� �����ϱ� ���� ��� �� ����
		long startTime = 0;
		long endTime = 0;
		
		// ���� ���� Array ���
		System.out.println("* Original Number Array ------------------------------");
		System.out.println();
		//SF.printOriginalArray();
		System.out.println("------------------------------------------------------");
		
		
		//Bubble Sort���� �޼��� ���
		System.out.println("* Bubble Sort Result ---------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // ���� �ð� ����
		SF.bubbleSort();
		endTime = System.nanoTime(); // ���� �ð� ����
		//SF.printSortedArray();
		System.out.println("Bubble Sort Time : " + (endTime - startTime)); // �ɸ� �ð� ���
		System.out.println("------------------------------------------------------");
		
		
		// Selection Sort���� �޼��� ���
		System.out.println("* Selection Sort Result ------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // ���� �ð� ����
		SF.selectionSort();
		endTime = System.nanoTime(); // ���� �ð� ����
		//SF.printSortedArray();
		System.out.println("Selection Sort Time : " + (endTime - startTime)); // �ɸ� �ð� ���
		System.out.println("------------------------------------------------------");
		
		
		// Quick Sort���� �޼��� ���
		System.out.println("* Quick Sort Result ----------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // ���� �ð� ����
		SF.quickSort(0,99999);
		endTime = System.nanoTime(); // ���� �ð� ����
		//SF.printSortedArray();
		System.out.println("Quick Sort Time : " + (endTime - startTime)); // �ɸ� �ð� ���
		System.out.println("------------------------------------------------------");
		
		
		// Insertion Sort���� �޼��� ���
		System.out.println("* Insertion Sort Result ------------------------------");
		System.out.println();
		SF.setSortedArray();
		startTime = System.nanoTime(); // ���� �ð� ����
		SF.insertionSort();
		endTime = System.nanoTime(); // ���� �ð� ����
		//SF.printSortedArray();
		System.out.println("Insertion Sort Time : " + (endTime - startTime)); // �ɸ� �ð� ���
		System.out.println("------------------------------------------------------");
	}
}
