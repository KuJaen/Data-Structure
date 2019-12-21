package ListMap;

/**
 * ListMap클래스
 * @author Ku
 */
public class ListMap implements Map {
	private Entry entry; // entry 변수 선언
	private int size; // size 변수 선언. 이는 entry의 수를 의미한다.
	
	/** 
	 * ListMap생성자
	 */
	public ListMap() {
		this.entry = null; // 처음 entry는 비어있다.
		this.size = 0; // entry가 처음에는 비어있기 때문에 초기 size값도 0이다.
	}
	
	/** get메서드
	 * key값을 갖는 entry가 있는지 검사하는 메서드
	 * return null
	 */
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		Entry tmp = this.entry; // tmp는 Entry들을 탐색할 Entry변수이다.
		
		// tmp는 null값을 가질때 까지 즉, 모든 Entry를 검사하거나 return이 이뤄질 때까지 검사를 계속한다.
		while(tmp != null) {
			// 만약 key값을 갖는 entry가 있다면
			if(tmp.getKey().equals(key)) {
				return tmp.getValue(); // 해당 entry의 value값을 반환하고 정지한다.
			}
			tmp = tmp.next; // 없다면 다음 Entry를 검사한다. 
		}
		// 모든 entry를 검사하고도 key값을 갖는 Entry가 없다면 null을 반환하고 마친다.
		return null;
	}
	
	/**
	 * put메서드
	 * key값과 value값을 갖는 Entry를 사전순으로 저장한다. 이때 value값은 해당 key값이 사용된 횟수 카운트이다.
	 * return oldValue 기존에 key값을 가진 Entry가 있다면
	 * return null 기존에 key값을 가진 Entry가 없다면
	 */
	@Override
	public Object put(Object key, int value) {
		// TODO Auto-generated method stub
		// 만약 모든 entry가 비어있다면
		if(entry == null) {
			// 처음으로 매개변수 key값과 value값을 갖는 Entry를 추가한다.
			entry = new Entry(key, value, null);
			this.size++; // 새로운 Entry가 추가되었으므로 size값에 1을 추가한다. 
			return null; // 매개변수 key값을 갖는 Entry가 사전에 존재하지 않았으므로 null을 반환한다.
		}
		
		//tmp는 사전식 저장을 위해 사용될 임의의 Entry변수이다.
		Entry tmp = entry;
		
		// tmp가 null일때 까지 즉, return이 이루어지거나 모든 Entry를 검사할 때까지 탐색한다.
		while(tmp != null) {
			// 만약 key값을 갖는 Entry가 이미 존재한다면
			if(tmp.getKey().equals(key)) {
				// 해당 Entry의 value값을 oldValue에 저장하고 횟수 value값에 1을 추가해준다.
				Object oldValue = tmp.getValue(); 
				tmp.setValue(tmp.getValue()+1);
				return oldValue; // 기존 Entry의 value값을 반환하고 마친다.
			}
			
			//만약 tmp.next가 null이면 즉, 모든 Entry를 탐색했다면 정지한다.
			if(tmp.next == null)
				break;
			tmp = tmp.next; // Entry를 순차적으로 검사한다.
		}
		
		tmp = entry; // tmp를 통해 계속 검사를 할 것이므로 entry로 초기화 시켜준다.
		
		// tmp 즉, 가장 앞에 있는 Entry entry의 key값과 매개변수 key값을 비교하여 사전적 우선순위를 정한다.
		// 만약 매개변수 key값이 더 우선적이라면 
		if(tmp.getKey().toString().compareTo(key.toString()) > 0) {
			Entry tmp2 = new Entry(key, value, null); // tmp2를 새로운 Entry로 지정한다.
			// tmp2는 tmp이전의 Entry가 될 것이며 새로운 entry가 될 것이다.
			tmp2.next = tmp;
			entry = tmp2;
			size++; // 새로운 Entry가 추가되었으므로 size의 크기를 늘려준다.
			return null; // 매개변수 key값과 겹치는 값을 갖는 Entry가 없었으므로 null을 반환한다.
		}
		
		// tmp가 null일때 까지 즉, return이 이루어지거나 모든 Entry를 검사할 때까지 탐색한다.
		while(tmp != null) {
			// tmp다음 Entry가 null인지 계속 검사한다. 만약 null이라면 매개변수 key값을 갖는 Entry를 추가한다.
			if(tmp.next == null) {
				tmp.next = new Entry(key,value,null);
				size++; // 새로운 Entry가 추가되었으므로 size의 크기를 늘려준다.
				break; // Entry가 무사히 추가 되었으므로 break함.
			}
			
			// tmp다음 Entry가 null이 아니라면
			if(tmp.next!= null) {
				// tmp다음 Entry와 매개변수 key값중 사전적 우선순위를 판별한다. 만약 다음 key가 더 우선적이라면 
				if(tmp.next.getKey().toString().compareTo(key.toString())>0) {
					Entry tmp2 = tmp.next; // tmp2를 생성하여 tmp의 다음 Entry로 지정해준다.
					// tmp의 다음 Entry에 새로운 Entry를 덧씌우고 그 다음 Entry에 tmp2를 대입해 List를 밀어준다.
					tmp.next = new Entry(key, value, null);
					tmp.next.next = tmp2;
					
					size++; // 새로운 Entry가 추가되었으므로 사이즈의 크기를 늘려준다.
					break; // Entry가 무사히 추가 되었으므로 break함.
				}
			}
			tmp = tmp.next; // 위 두 조건에도 성립하지 않으면 tmp를 다움 Entry로 바꾸어주며 검사를 계속 진행한다.
		}
		return null; // 매개변수 key값과 겹치는 값을 갖는 Entry가 없었으므로 null을 반환한다.
	}
	
	/**
	 * size메서드
	 * return size
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size; //size의 크기를 반환한다.
	}

	/**
	 * remove메서드
	 * return true remove에 성공하였다면
	 * return false remove에 실패했다면
	 */
	@Override
	public boolean remove(Object key) {
		// TODO Auto-generated method stub
		
		// 만약 entry == null이라면 즉, List가 비어있다면
		if(entry == null)
			return false; // remove가 이루어지지 않았음을 false를 반환하여 알린다.
		
		// 그러지 않다면 tmp를 entry로 지정하여 검사한다.
		Entry tmp = this.entry;
		// return값이 반환되거나 혹은 모든 Entry를 검사할 때까지 탐색한다.
		while(tmp != null) {
			//만약 매개변수 key에 해당하는 값을 갖는 Entry가 있다면
			if(tmp.next.getKey().equals(key)) {
				// tmp의 다음 다음 Entry를 nextEntry로 지정하여 해당 Entry까지 덧씌워 삭제한다.
				Entry nextEntry = tmp.next.next;
				tmp.next = nextEntry;
				this.size--; // Entry가 하나 줄었으므로 size의 크기를 줄여준다.
				return true; // 올바르게 remove가 이루어졌음을 true를 반환하여 알린다.
			}
			// 위 과정이 이루어지지 않았다면 tmp를 다음 Entry로 지정하여 계속 탐색한다.
			tmp = tmp.next;
		}
		
		return false; // 해당 key값을 갖는 Entry가 없다면 false를 반환한다.
	}
	
	/**
	 * printList메서드
	 * 모든 Entry를 출력하는 메서드이다.
	 */
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		Entry tmp = this.entry; // tmp는 첫번째 Entry부터 마지막 Entry까지 순차적으로 지정된다.
		
		// 첫번쨰 Entry부터 마지막 Entry까지 Key값에 해당하는 Value값을 출력한다.
		while(tmp != null) {
			System.out.println(tmp.getKey() + " : " + tmp.getValue());
			tmp = tmp.next;
		}
	}
}
