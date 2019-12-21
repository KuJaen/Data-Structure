package ListMap;

/** 
 * Map 인터페이스
 * @author Ku
 */
public interface Map {
	public Object get(Object key);
	public Object put(Object key, int value);
	public int size();
	public boolean remove(Object key);
	public void printList();
}
