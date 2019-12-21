package DoubleLinkedList;

/** LinkedList 인터페이스
 * @author Ku
 */
public interface LinkedList {
	
	/** insert 추상메서드
	 * List에 Object data를 추가한다.
	 * @param data data값을 받아옴
	 * @return true insert는 항상 성공적으로 이루어진다.
 	 */
	public boolean insert(Object data);
	
	/** delete 추상메서드
	 * List에서 Object target을 삭제한다.
	 * @param target target은 삭제 목표이다.
	 * @return true target이 List에 없을 때 반환된다.
	 */
	public boolean delete(Object target);
	
	/** contains 추상메서드
	 * List에 Object searchingData가 있는지 검사한다.
	 * @param searchingData 검사하는 데이터를 의미한다.
	 * @return true searchingData가 List에 있을 때 반환된다.
	 */
	public boolean contains(Object searchingData);
	
	/** size 추상메서드
	 * List의 size를 반환한다.
	 * @return size
	 */
	public int size();
	
	/** printList 추상메서드
	 *  List를 출력한다.
	 */
	public void printList();
}
