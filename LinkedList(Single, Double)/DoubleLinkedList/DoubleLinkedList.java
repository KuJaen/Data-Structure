package DoubleLinkedList;

/** DoubleLinkedList 클래스
 * Node head 시작Node 즉, 가장 앞에 있는 Node
 * int size List의 크기 즉, List에 포함된 Node의 수
 * @author Ku
 */
public class DoubleLinkedList implements LinkedList{
	private Node head;
	private int size;
	
	/** DoubleLinkedList의 생성자
	 * 처음 head값을 null로 설정
	 * 처음 size값을 0으로 설정
	 */
	public DoubleLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	/** insert 메서드
	 * 인터페이스(LinkedList.java) 참고
	 */
	@Override
	public boolean insert(Object data) {
		// TODO Auto-generated method stub
		
		// head가 비어있다면 즉, List가 비어있다면
		if(this.head == null) {
			// head에 새로운 노드를 추가하고 size의 크기를 1 추가한다.
			this.head = new Node(data, null, null);
			this.size++;
			return true; // 성공적으로 insert가 이루어졌음을 true를 반환하여 알림
		}
		// head가 null이 아니면 즉, List가 비어있지 않다면.
		else {
			Node tmp = this.head; //temp는 List를 탐색하기 위해 사용할 Node타입 변수이다.
			
			// List의 꼬리 즉, List의 끝부분을 찾아준다.
			while(tmp.next != null) {
				tmp = tmp.next;
				
			}
			
			// List의 꼬리부분에 새로운 Node를 추가하고 size에 1을 추가한다.
			// DoubleLinkedList는 prev를 갖고있다. 따라서 tmp.next와 tmp를 연결해준다.
			tmp.next = new Node(data, null, null);
			tmp.next.prev = tmp;
			this.size++;
			
			return true; // 성공적으로 insert가 이루어 졌으므로 true반환
		}
	}

	/** delete 메서드
	 * 인터페이스(LinkedList.java) 참고
	 */
	@Override
	public boolean delete(Object target) {
		// TODO Auto-generated method stub
		// head가 null이면 즉, 삭제할 노드가 없다면
		if(this.head == null)
			return false; // delete가 이루어지지 않았음을 false를 반환하여 알림
		
		Node tmp = this.head; // tmp는 List를 탐색하는데 사용 될 Node타입 변수이다.
		Node prevTmp = null; // prevTmp는 tmp의 이전 Node를 의미한다.
		
		// tmp가 null이 될 때까지 즉, 모든 Node를 검사한다.
		while(tmp != null) {
			// 만약 target에 해당하는 data값을 가진 Node가 있다면
			if(tmp.getData().equals(target)) {
				Node nextNode = tmp.next; // nextNode는 tmp의 다음 Node를 의마한다.
				// 이 조건문은 target값을 가진 Node가 head에 있을 경우에 해당한다.
				if(prevTmp == null) {
					head = nextNode;
				}
				// target값을 가진 Node가 head가 아닌 다른 곳에 있을 경우
				else {
					// prevTmp의 다음 Node가 nextNode이다. 즉 두 노드를 연결해 준다.
					// 원래 두 Node사이에 있던 tmp는 삭제 대상이므로 다음 과정에서 사라진다.
					prevTmp.next = nextNode;
				}
				
				this.size--; // Node가 삭제되었으므로 size의 크기를 줄여준다.
				return true; // 성공적으로 delete되었음을 true를 반환하여 알린다.
			}
			// target에 해당하는 data값을 가진 Node가 없다면 prevTmp에 tmp값을 tmp는 다음 tmp값을 받아 탐색을 계속한다.
			// 이때 tmp.next와 tmp값(prevTmp)을 연결한다.(DoubleLinkedList 요소)
			prevTmp = tmp;
			tmp = tmp.next;
			tmp.next.prev = prevTmp;
		}
		return false; // 모든 Node를 탐색하고 해당 data값을 가진 Node가 없다면 false를 반환한다.
	}

	/** contains 메서드
	 * 인터페이스(LinkedList.java) 참고
	 */
	@Override
	public boolean contains(Object searchingData) {
		// TODO Auto-generated method stub
		Node tmp = this.head; // tmp는 List를 탐색할 때 사용 될 Node타입 변수이다.
		
		// 아래 반복문은 List의 크기가 1일때 실행되지 않는다. 따라서 이 조건문을 넣어준다.
		if(tmp.getData() == searchingData)
			return true;
		
		// List 전체를 탐색한다.
		while(tmp.next != null) {
			// 만약 searchingData값과 일치하는 data값을 가진 Node가 있다면 true를 반환한다.
			if(tmp.getData().equals(searchingData)) {
				return true;
			}
			// tmp를 다음 Node로 이동시켜 주면서 탐색한다.
			tmp = tmp.next;
		}
		// searchingData와 동일한 data값을 가진 Node가 없다면 false를 반환한다.
		return false;
	}

	/** size메서드
	 * 인터페이스(LinkedList.java) 참고
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size; // size를 반환한다.
	}

	/** printList
	 * 인터페이스(LinkedList.java) 참고
	 */
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		Node tmp = this.head; // List전체를 탐색하는데 사용될 Node타입 변수
		
		// List 전체를 탐색하면서 Data값 출력
		while(tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.next;
		}
	}
}
