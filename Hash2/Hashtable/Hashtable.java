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
	 * key값과 value값을 갖는 엔트리를 헤쉬테이블에 추가하는 메서드
	 * @param key 해쉬테이블에 저장한 엔트리의 key값
	 * @param value 해쉬테이블에 저장할 엔트리의 value값
	 * @return put에 의한 반환값은 딱히 없으므로 null을 반환한다.
	 */
	public Object put(Object key, Object value) {
		Entry newEntry = new Entry(key, value); // 새로 저장될 Entry생성
		int hashIndex = hash(key); // newEntry가 저장될 Index를 지정 (조건에 따라 계속 변경 될 것임)
		int tmpIndex = 0;
		
		while(tmpIndex < entries.length) {
			if(entries[tmpIndex] != null) {
				if(entries[tmpIndex].getKey() == key) {
					entries[tmpIndex].setValue(value);
					return null;
				}
			}
		tmpIndex++;	
		}
		
		// 만약 size가 entries크기의 70%보다 크다면 즉, 적재율이 70%를 초과하면 리해싱한다.
		if(((double)size) > (double)(entries.length)*7.0/10.0) {
			reHashing(); // 리해싱 메서드
			// 리해싱함을 알리고 새로운 원소를 추가한 후 결과를 출력한다.
			System.out.println("* 적재율 70%초과. 리해싱합니다. \n");
			put(key, value); // 리해싱한 entries에 put을 다시 진행한다.
			return null;
		}
		
		// put과정. flag가 true로 바뀌었을 때 put에 성공한 것이다.
		boolean flag = false;
		while(!flag) {
			// newEntry를 삽입할 때 entries[hashIndex]가 비어있지 않다면
			if(entries[hashIndex] != null) {
				// hashIndex를 한칸 뒤로 밀어준다. 이때 마지막 칸이라면 처음 Index로 돌아간다.
				// 앞에서 리해싱을 먼저 해주었기 떄문에 이곳에서 무한루프가 돌 이유는 없다.
				if(hashIndex < entries.length-1)
					hashIndex++;
				else
					hashIndex = 0;
			}
			// 비어있다면 그 자리에 newEntry를 추가한다.
			else {
				entries[hashIndex] = newEntry;
				flag = true;
			}
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
		int hashIndex = hash(key); // hashIndex는 param key의 Index이다. 이곳에서 부터 삭제할 key를 탐색한다.
		Object value = entries[hashIndex]; // value는 param key의 value값이다. 삭제된 entry의 value값을 반환하기 위해 사용한다.
		
		// 삭제에 성공하면 flag가 true로 바뀌면서 반복문을 정지한다.
		boolean flag = false;
		while(!flag) {
			value = entries[hashIndex]; // 반환을 위한 value값 설정
			// entries[hashIndex]의 key값이 param key와 동일하다면 해당 엔트리를 삭제하고 flag를 true로 반환한 후 value값을 리턴한다.
			if(entries[hashIndex].getKey() == key) {
				entries[hashIndex] = null;
				flag = true; // 사실 이부분은 필요 없지만 혹시모를 프로그램의 안정성을 위해 넣어 두었다.
				return value;
			}
			// 해당 hashIndex에서 삭제가 이루어 지지 않았다면 hashIndex를 한칸 뒤로 밀어준다. 이때 hashIndex가 entries의 마지막 Index를 가리키고 있다면 0으로 옮겨준다.
			else {
				if(hashIndex < entries.length-1)
					hashIndex++;
				else
					hashIndex = 0;
			}
		}
		--size; // 하나의 엔트리가 삭제되었으므로 size는 줄어든다.
		return value;
	}
	
	/** size메서드
	 * 해쉬테이블의 size를 반환하는 메서드
	 * @return size - 해쉬테이블의 size (저장된 엔트리 수)
	 */
	public int size() {
		return this.size; // size값 반환
	}
	
	/** reHashing메서드
	 * entries의 적재율이 일정 수치를 초과하면 entries의 크기를 늘리고 새롭게 해싱해주는 메서드
	 */
	public void reHashing() {
		Entry[] newEntries = new Entry[entries.length*2]; // newEntries는 리해싱 된 Entry들이 저장될 새로운 entries로 기조 entries크기의 두배이다.
		// 기존 entries의 모든 Entry들을 탐색하며 하나씩 리해싱될 자리를 찾아줄 것이다.
		for(int i = 0; i < entries.length; i++) {
			// 해당 Index가 비어있지 않다면 즉, Entry가 저장되어 있다면
			if(this.entries[i] != null) {
				int newHash = (this.entries[i].getKey().hashCode()&0x7fffffff) % newEntries.length; // 새로운 HashIndex자리를 찾아준다.
				
				// newEntries에 entries에 저장되어 있던 Entry들을 새로히 저장해 주는 과정이다. flag가 true로 바뀌면 저장하려는 Entry가 무사히 저장되었음을 나타낸다.
				boolean flag = false;
				while(!flag) {
					// newEntries[newHash]가 비어있지 않다면 즉, 이미 다른 Entry가 저장되어 있다면
					if(newEntries[newHash] != null) {
						// newHash 즉, 저장될 위치를 한칸 뒤로 밀어준다. 이때 newHash가 이미 마지막 Index에 위치한다면 0으로 옮겨준다.
						if(newHash < newEntries.length-1)
							newHash++;
						else 
							newHash = 0;
					}
					// newEntries[newHash]가 비어있다면 그 자리에 저장한다.
					else{
						newEntries[newHash] = entries[i];
						flag = true; // 무사히 저장되었으므로 falg를 true로 바꾸어준다.
					}
				}
			}
		}
		entries = newEntries; // entries를 newEntries로 바꾸어주고 마친다.
	}
	
	/** printEntries 메서드
	 * 해쉬테이블에 저장된 모든 entry를 출력하는 메서드
	 */
	public void printEntries() {
		// 모든 entry를 탐색하면서 Index자리에대한 key값, value값으로 출력한다.
		for(int i = 0; i < this.entries.length; i++) {
			if(this.entries[i] != null)
				System.out.println("Table[" + i + "] = " + this.entries[i].getKey().toString()+", " + this.entries[i].getValue().toString());
		}
	}
}
