package Hashtable;

/** BasicHashtable 클래스
 * Hashtable에 대한 기본정보와 메서드가 포함되어 있는 클래스
 * @author NoA
 *
 */
public class Hashtable {
	private Entry[] entries; // hash리스트 필드
	private int size; // 배열의 크기 필드
	
	/** BasicHashtable생성자
	 * @param capacity Hashtable의 용량을 매개변수 받아옴
	 */
	public Hashtable(int capacity) {
		this.entries = new Entry[capacity]; // Entry리스트 객체 생성
		this.size = 0; // Hashtable의 처음 크기는 0임
	}
	
	/** get메서드
	 * param값 key를 key값으로 갖는 엔트리의 value값을 반환하는 메서드
	 * @param key 찾고자 하는 해쉬의 key값
	 * @return param값을 key로 갖는 해쉬의 value값
	 */
	public Object get(Object key) {
		return entries[hash(key)].getValue(); // key값을 갖는 해쉬의 value값을 반환한다.
	}
	
	/** hash메서드
	 * 해쉬 테이블에 저장할 엔트리의 index값을 반환한하는 메서드
	 * @param key 해싱할 key값
	 * @return 해쉬 인덱스 값
	 * 
	 * 리턴 값 설명 
	 * hashCode는 Object클래스의 메서드로 모든 다른 메서드에 상속되어 사용된다.
	 * 이 메서드는 객체의 메모리 주소를 32비트로 정수로 반환하는데 이는 양수일 수도 있고 음수일 수도 있다.
	 * 따라서 오버플로우를 방지하기 위해 비교연산으로 양수로 바꾸어준다. (0x7fffffff와 비교연산)
	 * 그리고 그에 따른 결과를 entry배열의 길이로 나눈다면 key가 저장될 인덱스가 나타나게 된다.
	 * (이는 배열은 메모리 주소 ,즉 포인터에 의해 나타낼 수 있기 때문에 가능한 연산이다.)
	 */
	public int hash(Object key) {
		// 만약 key값이 없다면 -1을 반환한다.
		if(key == null)
			return -1;
		return (key.hashCode()&0x7fffffff)%entries.length; // 해쉬 인덱스 반환
	}
	
	/** put메서드
	 * key값과 value값을 갖는 엔트리를 헤쉬테이블에 추라하는 메서드
	 * @param key 해쉬테이블에 저장한 엔트리의 key값
	 * @param value 해쉬테이블에 저장할 엔트리의 value값
	 * @return put에 의한 반환값은 딱히 없으므로 null을 반환한다.
	 */
	public Object put(Object key, Object value) {
		Entry newEntry = new Entry(key, value, null); // 저장될 새 엔트리
		
		// 해당 테이블이 비어있다면
		if(entries[hash(key)] == null)
			entries[hash(key)] = newEntry; // newEntry를 해쉬테이블에 저장한다.
		// 비어있지 않다면
		else {
			Entry tmp = entries[hash(key)]; // tmp는 해당 테이블자리의 엔트리들을 탐색할 엔트리
			// tmp의 next가 비어 있을 때 까지 tmp에 next를 저장한다.
			while(tmp.getNext() != null) 
				tmp = tmp.getNext();
			// 비어있는 자리를 발견하면 그 자리에 새로운 엔트리를 추가한다.
			tmp.setNext(newEntry);
		}
		++size; // 새로운 entry가 추가되었으므로 size값을 늘린다.
		return null; // 반환값은 따로 없다
	}
	
	/** remove메서드
	 * param값을 key로 갖는 엔트리를 삭제하는 메서드
	 * @param key 해쉬테이블에 저장된 엔트리 중 param값 key를 key값으로 갖는 엔트리를 삭제하는 메서드
	 * @return value - 삭제된 entry의 value값을 반환
	 */
	public Object remove(Object key) {
		int hashIndex = hash(key); // key를 key값으로 갖는 엔트리의 인덱스를 저장하는 필드
		Object value = null; // value는 삭제된 entry값을 반환 할 것이다.
		
		Entry tmp = entries[hashIndex]; // tmp는 해당 해시테이블 자리의 엔트리들을 탐색한다.
		// 만약 tmp의 key값이 param값과 동일하다면 그 해시테이블 엔트리의 next를 기존 엔트리에 덮어씌워 기존 엔트리를 삭제한다.
		if(tmp.getKey() == key)
			entries[hashIndex] = tmp.getNext();
		
		// 위의 경우에 해당하지 않는다면 break를 받거나 모든 엔트리를 탐색할 때까지 반복한다.
		while(tmp.getNext() != null) {
			// 만약 해당 해시테이블 자리에 저장되어 있는 엔트리 중 key값을 갖는 엔트리가 있다면 그 다음 엔트리를 덮어씌워 삭제하고 정지한다.
			if(tmp.getNext().getKey() == key) {
				value = tmp.getNext().getValue();
				tmp.setNext(tmp.getNext().getNext());
				break;
			}
			tmp = tmp.getNext(); // 해시테이블 탐색
		}
		--size; // 하나의 엔트리가 삭제되었으므로 size는 줄어든다.
		return value; // 삭제된 엔트리의 value값 반환
	}
	
	/** size메서드
	 * 해쉬테이블의 size를 반환하는 메서드
	 * @return size - 해쉬테이블의 size (저장된 엔트리 수)
	 */
	public int size() {
		return this.size; // size값 반환
	}
	
	/** printEntries 메서드
	 * 해쉬테이블에 저장된 모든 entry를 출력하는 메서드
	 */
	public void printEntries() {
		// entries의 길이만큼 즉, 모든 entry를 출력한다.
		for(int i = 0; i < this.entries.length; i++) {
			
			// 비어있는 해시테이블 자리는 출력하지 않는다.
			if(this.entries[i] != null) {
				// tmp는 연결리스트로 저장된 모든 엔트리들을 출력하기 위해 사용 될 것이다.
				Entry tmp = entries[i];
				// 테이블 자리 표시
				System.out.print("Table["+i+"] = ");
				// 해당 테이블 자리에 있는 모든 엔트리를 출력한다. next는 ->를 통해 표시해 주도록 한다.
				while(tmp != null) {
					System.out.print(tmp.getKey().toString() + " , " + tmp.getValue().toString());
					// ->를 표시할 때도 마지막 엔트리에서는 출력하지 않도록 한다.
					if(tmp.getNext() != null)
						System.out.print(" -> ");
					tmp = tmp.getNext();
				}
				System.out.println();
			}
		}
	}
}
