package Sort;

// Sort�� ���� �������̽� �Դϴ�.
public interface SortInterface {
	public void bubbleSort(); /** Bubble sort �޼��� */
	public void selectionSort(); /** selection Sort �޼���  */
	public void quickSort(int left, int right); /** Quick Sort �޼��� (�ʿ信 ���� �����Ͽ����ϴ�.) */
	public void insertionSort(); /** Insertion Sort �޼��� */
	public void printOriginalArray(); /** Sort���� Array�� ����ϴ� �޼��� */
	public void printSortedArray(); /** Sort���� Array�� ����ϴ� �޼��� */
}
