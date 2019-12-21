package SingleLinkedList;

/** LinkedList 인터페이스
 * @author Ku
 */
public interface LinkedList {
	
	/** insert 추상메서드
	 * List에 Object data를 추가한다.
	 * @param data
	 * @return true
 	 */
	public boolean insert(Object data);
	
	/** delete 추상메서드
	 * List에서 Object target을 삭제한다.
	 * @param target
	 * @return true target이 List에 없을 때 빈환된다.
	 * @return false target이 List에 있을 때 반환된다.
	 */
	public boolean delete(Object target);
	
	/** contains 추상메서드
	 * List에 Object searchingData가 있는지 검사한다.
	 * @param searchingData
	 * @return true searchingData가 List에 있을 때 반환된다.
	 * @return false searchingData가 List에 없을 때 반환된다.
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
