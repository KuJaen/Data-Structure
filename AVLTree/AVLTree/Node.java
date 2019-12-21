package AVLTree;
/**
 * Node 클래스는 AVLTree에 저장될 노드들이다.
 * @author NoA
 *
 */
public class Node {
	private int value; // 노드의 값
	private Node leftChild; // 노드의 왼쪽 자녀노드
	private Node rightChild; // 노드의  오른쪽 자녀노드
	private int height; // 노드의 높이
	private int balance; // 노드의 balance
	
	/** 노드 생성자
	 * 
	 * @param _v value값을 입력받아 저장한다.
	 * @param lc 왼쪽 자녀노드를 입력받아 저장한다.
	 * @param rc 오른쪽 자녀노드를 입력받아 저장한다.
	 */
	public Node(int _v, Node lc, Node rc) {
		this.value = _v;
		this.leftChild = lc;
		this.rightChild = rc;
		this.height = 1; // 노드의 처음 높이는 1이다. 자녀노드가 추가되면서 이는 갱신될 것이다.
		this.balance = 0; // 처음에는 자녀노드가 없기떄문에 balance가 0이다.
	}
	
	/**
	 * getValue 메서드
	 * @return 노드의 value값을 반환한다.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * getLeftChild 메서드
	 * @return 노드의 왼쪽 자녀노드를 반환한다.
	 */
	public Node getLeftChild() {
		return this.leftChild;
	}
	
	/** 
	 * getRightChild 메서드
	 * @return 노드의 오른쪽 자녀노드를 반환한다.
	 */
	public Node getRightChild() {
		return this.rightChild;
	}
	
	/**
	 * getHeight 메서드
	 * @return 노드의 높이를 반환한다.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * setLeftChild 메서드
	 * @param lc 노드의 왼쪽 자녀를 param값으로 지정한다.
	 */
	public void setLeftChild(Node lc) {
		this.leftChild = lc;
	}
	
	/**
	 * setRightChild 메서드
	 * @param rc 노드의 오른쪽 자녀를 param값으로 저장한다.
	 */
	public void setRightChild(Node rc) {
		this.rightChild = rc;
	}
	
	/**
	 * setHeight 메서드
	 * @param height 높이를 param값으로 지정한다.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/** 
	 * getBalance 메서드
	 * @return 노드의 balance를 반환한다.
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * setBalance 메서드
	 * 노드의 두 자녀노드를 통해 balance값을 연산한다.
	 */
	public void setBalance() {
		int lch; // 왼쪽 자녀노드의 높이를 저장할 변수
		int rch; // 오른쪽 자녀노드의 높이를 저장할 변수
		// NullPoint 에러를 방지하기 위해 try-catch구문 사용
		// lch와 rch의 값을 받아옴 (catch시 해당 자녀노드가 없음을 의미하므로 0저장)
		try {lch = leftChild.getHeight();}
		catch(Exception e){lch = 0;}
		try {rch = rightChild.getHeight();}
		catch(Exception e) {rch = 0;}
		balance = rch - lch; // node의 벨런스 값 저장
	}
	
	/**
	 * setValue 메서드
	 * @param value value값을 param값으로 저장
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
