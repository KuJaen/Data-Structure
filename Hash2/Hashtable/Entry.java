package Hashtable;

/** Entry클래스
 * key값에 따른 value값이 저장되는 Entry클래스
 * @author NoA
 *
 */
public class Entry {
	private Object key; // key값
	private Object value; // value값
	
	/** Entry생성자
	 * 
	 * @param k key값을 매개로 받아 저장함
	 * @param v value값을 매개로 받아 저장함
	 */
	public Entry(Object k, Object v) {
		this.key = k;
		this.value = v;
	}
	
	/** getKey메서드
	 * 
	 * @return key값 반환
	 */
	public Object getKey() {
		return key;
	}
	
	/** getValue메서드
	 * 
	 * @return value값 반환
	 */
	public Object getValue() {
		return this.value;
	}
	
	/** setValue메서드
	 * 
	 * @param value 이 Entry의 value값을 value값으로 설정
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}