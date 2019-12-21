package ArrayBag;

public interface Bag {
	//Bag에 원소를 추가하는 함수
	public boolean add(Object object);
	
	//Bag에 매개변수 object가 포함되는지 검사하는 함수
	public boolean contains(Object object);
	
	//Bag의 원소의 개수를 반환하는 함수
	public int size();
	
	//Bag에 원소가 0개인지 아닌지를 반환하는 함수
	public boolean isEmpty();
	
	//Bag의 첫번째 원소를 반환하는 함수
	public Object getFirst();
	
	//Bag에 존재하는 매개변수 object를 삭제하는 함수
	public boolean remove(Object object);
	
	//Bag에 존재하는 첫 번째 원소를 삭제하는 함수
	public Object removeFirst();
	
	//Bag에 존재하는 원소를 모두 출력하는 함수
	public void printAll();
}
