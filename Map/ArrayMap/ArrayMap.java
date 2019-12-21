package Map;

/** 
 * ArrayMap클래스
 * @author Ku
 */
public class ArrayMap implements Map {
	private static final int INITIAL_SIZE = 100; // 초기의 크기는 100이다.
	private Entry[] entryArray; // entryArray는 Entry들을 저장한 배열을 의미한다.
	private int size; // 현재 Array에 포함된 Entry의 수를 나타낸나.

	/** 
	 * ArrayMap의 생성자
	 */
	public ArrayMap() {
		this.entryArray = new Entry[INITIAL_SIZE]; // 초기 크기로 entryArray객체를 생성한다.
		this.size = 0; // 처음 size는 0
	}

	 /**
	  * get메서드
	  * 매개변수 key에 해당하는 값을 key값으로 가지고 있는 Entry가 있는지 검사하고 있다면 그 Entry의 value값을 반환한다.
	  * return null
	  */
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		// for반복문을 사용하여 매개변수 key를 갖는 Entry가 있는지 검사한다.
		for (int i = 0; i < this.size; i++) {
			//만약 있다면 해당 Entry의 value값을 반환한다.
			if (this.entryArray[i].getKey().equals(key)) {
				return this.entryArray[i].getValue();
			}
		}
		// 없다면 null을 반환한다.
		return null;
	}

	/** 
	 * put메서드
	 * 매개변수 key값과 value값을 갖고있는 Entry를 Array에 저장하는 메서드. key값은 사전순으로 저장되며 value는 해당 단어가 사용된 횟수를 의미한다.
	 * return oldValue key가 이미 존재한다면
	 * return null
	 */
	@Override
	public Object put(Object key, int value) {
		// TODO Auto-generated method stub
		// 반복문으로 처음부터 끝까지 이미 매개변수 key값을 갖고있는 Entry가 있는지 검사한다.
		for (int i = 0; i < this.size; i++) {
			//만약 있다면
			if (this.entryArray[i].getKey().equals(key)) {
				Object oldValue = this.entryArray[i].getValue(); // 변수 oldValue에 이전 value값을 저장하고
				this.entryArray[i].setValue(entryArray[i].getValue()+1); // 해당 Entry의 Value값을 갱신해 준다.
				return oldValue; // oldValue값을 반환하고 마친다.
			}
		}
		
		// 매개변수 key값을 가진 Entry가 없을 경우 실행
		// Array가 이미 가득 차 있다면
		if (size == entryArray.length) {
			reSize(); // 최대 크기를 변경해 준다.
		} 
		
		// 사전순으로 저장하기위해 이미 저장되어있는 key값들과 비교할 것이다.
		for (int i = 0; i < this.size; i++) {
			// 사전순서에서 매개변수 key에 해당하는 값보다 큰 값이 Array에 저장되어 있다면
			if (entryArray[i].getKey().toString().compareTo(key.toString()) > 0) {
				// 저장된값들을 뒤로 밀어주고 올바른 자리에 매개변수 key값을 가진 새로운 Entry를 추가해 준다.
				System.arraycopy(entryArray, i, entryArray, i + 1, size - i);
				entryArray[i] = new Entry(key, value);

				this.size++; // 새로운 인자가 추가되었으므로 size크기를 1키워준다.
				return null; // 겹치는 key값이 없었으므로 null을 반환한다.
			}
		}
		//for문이 return없이 모두 돌아갔다면 매개변수 key에 해당하는 값이 가장 큰 것이다.
		this.entryArray[size] = new Entry(key, value); // 따라서 Array마지막에 Entry를 저장한다.
		this.size++; // 새로운 인자가 추가되었으므로 size크기를 1키워준다.
		return null; // 겹치는 key값이 없었으므로 null을 반환한다.
	}
	
	/**
	 *  size값을 반환하는 메서드
	 *  return size
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	/**
	 * 매개변수 key를 갖는 Entry를 삭제하는 메서드
	 * return true Entry삭제 성공시
	 * return false Entry삭제 실패시
	 */
	@Override
	public boolean remove(Object key) {
		// TODO Auto-generated method stub
		// key를 갖는 Entry가 있는지 전체적으로 검사한다.
		for (int i = 0; i < this.size; i++) {
			//만약 있다면
			if (this.entryArray[i].getKey().equals(key)) {
				//Array에 인자들을 해당 자리까지 당겨 기존 Entry값을 없애고 당기면서 size-1인자와 같은 key값을 갖게된 size를 null값으로 바꿔준다.
				System.arraycopy(entryArray, i + 1, entryArray, i, size - i - 1);
				this.entryArray[size] = null;
				this.size--; // 크기가 하나 줄었으므로 size크기를 1 줄여준다.
				return true; // 올바르게 remove가 이루어졌음을 true를 반환하여 알린다.
			}
		}
		return false; // remove가 이루어지지 못했음을(key값을 갖는 Entry가 없음을) false를 반환하여 알린다.
	}
	
	/**
	 * Array의 최대크기를 재설정하는 메서드
	 */
	public void reSize() {
		// 기존 Array크기의 2배의 크기를 갖는 copiedArray 객체 생성
		Entry[] copiedArray = new Entry[this.entryArray.length * 2];
		//copiedArray에 entryArray를 복사한다.
		System.arraycopy(entryArray, 0, copiedArray, 0, this.size);
		this.entryArray = copiedArray; // entryArray를 copiedArray로 초기화 시킨다.
	}
	
	/**
	 *  Array목록을 출력하는 메서드 이다.
	 */
	@Override
	public void printArray() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size; i++) {
			// key값에 해당하는 Value값을 같이 출력한다.
			System.out.println(this.entryArray[i].getKey() + " : " + this.entryArray[i].getValue());
			// 20번째 줄 마다 한줄씩 띄어줌
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}

}
