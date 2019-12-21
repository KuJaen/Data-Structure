package Sort;

// Sort에 대한 인터페이스 입니다.
public interface SortInterface {
	public void bubbleSort(); /** Bubble sort 메서드 */
	public void selectionSort(); /** selection Sort 메서드  */
	public void quickSort(int left, int right); /** Quick Sort 메서드 (필요에 의해 변형하였습니다.) */
	public void insertionSort(); /** Insertion Sort 메서드 */
	public void printOriginalArray(); /** Sort이전 Array를 출력하는 메서드 */
	public void printSortedArray(); /** Sort이후 Array를 출력하는 메서드 */
}
