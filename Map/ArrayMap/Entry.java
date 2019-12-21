package Map;

/** 
 * key, value 데이터를 보유한 Entry클래스
 * @author Ku
 *
 */
public class Entry {
	private Object key;
	private int value; //value값은 단어가 나온 횟수를 카운트 할 것이다
	
	/**
	 * Entry의 생성자
	 * @param key
	 * @param value
	 */
	public Entry(Object key, int value) {
		this.key = key;
		this.value = value;
	}
	
	/** getKey메서드
	 * 
	 * @return key
	 */
	public Object getKey() {
		return this.key;
	}
	
	/** getValue메서드
	 * 
	 * @return value
	 */
	public int getValue() {
		return this.value;
	}
	
	/** 
	 * setKey메서드
	 * @param key
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	
	/** 
	 * setValue메서드
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
