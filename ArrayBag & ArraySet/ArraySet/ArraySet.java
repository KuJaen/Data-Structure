package ArraySet;

public class ArraySet implements set {
	private static final int MAX_SIZE = 100; //Set의 최대 크기를 100으로 지정
	private int maxSize; //maxSize변수 설정
	private Object[] objects; //Set의 리스트를 나타낼 object리스트 설정
	private int size = 0; //Set의 처음 크기는 0임
	
	public ArraySet() {
		this.maxSize = MAX_SIZE; //maxSize는 MAX_SIZE 즉 100임
		this.objects = new Object[maxSize]; //크기가 maxSize인 object리스트 생성
		this.size = 0; //Set의 처음 크기는 0임
}
	
	//인터페이스의 add함수
	@Override
	public boolean add(Object object) {
		// TODO Auto-generated method stub
		//만약 size가 maxSize와 같다면 즉, Set에 빈공간이 없다면 false를 반환한다.
		if(size == maxSize) {
			return false;
		}
		//아니면 이미 매개변수 object에 해당하는 값이 존재한다면 마찬가지로 false를 반환한다.
		else if(contains(object)) {
			return false;
		}
		//위 두가지 조건에 모두 해당하지 않을 경우 Set에 object를 추가하고 true를 반환한다.
		objects[size++] = object;
		return true;
	}
		
	//인터페이스의 contains함수
	@Override
	public boolean contains(Object object) {
		// TODO Auto-generated method stub
		//for반복문을 사용하여 Bag의 원소를 순차적으로 검사한다.
		for(int k = 0; k < size; k++) {
			//만약 매개변수 object에 해당하는 값이 Bag에 포함되어 있다면 true를 반환하고 멈춘다.
			if(objects[k] == object) {
				return true;
			}
		}
		return false; //만약 포함되어 있지 않다면 false를 반환한다.
	}
	
	//인터페이스의 size함수
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size; //Bag에 포함되어있는 원소의 갯수를 반환한다.
	}
	
	//인터페이스의 isEmpty함수
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//Bag에 포함되어 있는 원소의 갯수가 0이면 true를 반환한다.
		if(size == 0)
			return true;
		return false; // 만약 원소가 하나라도 포함되어 있다면 false를 반환한다.
	}
	
	//인터페이스의 getFirst함수
	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return objects[0]; //Bag의 첫번째 원소에 해당하는 값을 반환한다.
	}
	
	//인터페이스의 remove함수
	@Override
	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		//isEmpty함수가 참이라면 즉, Bag에 포함된 원소가 하나도 존재하지 않는다면 false를 반환한다.
		if(isEmpty())
		{
			return false;
		}
		
		//Bag에 원소가 하나라도 존재한다면
		for(int k = 0; k < size; k++) {
			//각 원소를 순차적으로 매개변수 object에 해당하는 값과 일치하는지 검사한다.(즉 object에 해당하는 값이 있는지 검사한다.)
			if(objects[k] == object)
			{
				//만약 해당값이 있다면 그 원소를 없앤다.
				System.arraycopy(objects, k+1, objects, k, size-k-1);
				//해당 원소를 삭제하는 과정에서 마지막 원소가 중복되서 저장되므로 가장 뒷쪽의 원소를 삭제한다.
				objects[size-1] = null;
				size--; //원소가 하나 없어졌으므로 size의 크기 또한 하나 줄어들어야 한다.
				break;
			}
		}
		return true; //무사히 원소를 삭제하였다면 true를 반환한다.
	}
	
	//인터페이스의 removeFirst함수
	@Override
	public Object removeFirst() {
		// TODO Auto-generated method stub
		//isEmpty함수가 참이라면, 즉 원소가 하나도 존재하지 않는다면 false를 반환한다.
		if(isEmpty())
		{
			return false;
		}
		
		//원소가 하나라도 존재한다면 첫번째 원소를 없애준다.
		System.arraycopy(objects, 1, objects, 0, size-1);
		objects[size-1] = null; //삭제하는 과정에서 마지막 원소가 중복되어 저장되어 있으므로 사장 뒷쪽의 원소를 삭제해준다.
		size--; //원소가 하나 없어졌으므로 size의 크기 또한 하나 줄어들어야 한다.
		return true; //무사히 원소가 삭제되었다면 true를 반환한다.
	}
	
	//인터페이스의 printAll함수
	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		//리스트의 전체 원소를 출력해줄 것이므로 리스트를 나타내는 표현으로 []의 형식으로 출력할 것이다.
		System.out.print("["); // [를 가장 먼저 출력한다
		//원소를 순차적으로 출력한다.
		for(int k = 0; k < size; k ++) {
			System.out.print(objects[k]);
			//마지막 원소를 출력할때는 쉼표를 찍지 않는다.
			if(k<size-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");// 마지막으로 ]를 출력한다.
	}
}