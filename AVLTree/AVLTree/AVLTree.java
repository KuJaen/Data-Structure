package AVLTree;

/**
 * AVLTree클래스는 AVLTree에 관련된 메서드들이 들어있다.
 * @author NoA
 *
 */
public class AVLTree {
	private Node root; // AVLTree의 root를 저장하는 필드
	
	/**
	 * AVLTree의 첫번째 생성자이다.
	 * 처음 AVLTree가 생성될 때 root값을 따로 받지 않아 root에 null을 저장한다.
	 */
	public AVLTree() {
		this.root = null;
	}
	
	/**
	 * AVLTree의 두번째 생성자이다.
	 * root를 param값으로 받아 저장한다.
	 * @param root root로 저장할 Node
	 */
	public AVLTree(Node root) {
		this.root = root;
	}
	
	/**
	 * getRoot 메서드
	 * @return root를 반환한다.
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/** 
	 * setRoot 메서드
	 * @param newNode param값 newNode를 입력받아 root로 설정한다.
	 */
	public void setRoot(Node newNode) {
		this.root = newNode;
	}
	
	/**
	 * height메서드
	 * 
	 * 이 메서드는 실습에서 제공받은 기본 코드이다. 
	 * 나는 편의를 위해 Node클래스에 높이에 대한 메서드를 따로 만들어 놓았으므로 실질적으로 이 메서드는 사용되지 않을 것이다.
	 * param의 높이를 반환하는 메서드
	 * @param N 높이를 반환할 param노드
	 * @return param의 높이를 반환한다.
	 */
	int height(Node N) {
		// param이 null이면 높이로 0을 반환한다.
		if(N == null)
			return 0;
		// 위 조건에 해당하지 않으면 getHeight메서드를 호출하여 높이값을 반환한다.
		return N.getHeight();
	}
	
	/**
	 * getBalance메서드
	 * 
	 * 이 메서드는 실습에서 제공받은 기본 코드이다.
	 * 나는 편의를 위해 Node클래스에 Balance에 대한 메서드를 따로 만들어 놓았으므로 실질적으로 이 메서드는 사용되지 않을 것이다.
	 * @param balance값을 얻고싶은 노드를 param으로 받는다.
	 * @return param의 balance값을 계산하고 반환한다.
	 */
	int getBalance(Node N) {
		// param이 null이면 0을 반환한다.
		if(N == null)
			return 0;
		// 위 조건에 해당하지 않으면 balance를 계산, 반환한다.
		return height(N.getLeftChild()) - height(N.getRightChild());
	}
	
	/** 
	 * preOrderPrint메서드
	 * @param node 재귀적으로 Node들을 출력하기 위해 사용될 param값으로 이 param값부터 노드들이 출력된다.
	 */
	void preOrderPrint(Node node) {
		// node가 비어있다면 출력하지 실행되지 않는다.
		if(node != null) {
			// node의 value값을 출력하고 출력 메서드를 재귀적으로 호출한다.
			System.out.print(node.getValue() + " ");
			preOrderPrint(node.getLeftChild());
			preOrderPrint(node.getRightChild());
		}
	}
	
	/**
	 * insert 메서드
	 * @param node 재귀적으로 insert를 진행하기 위해 사용될 param값이다.
	 * @param key 새로 저장될 노드의 key값이다.
	 * @return insert가 실패할 경우가 딱히 없으므로 null을 반환할 것이다.
	 */
	public Node insert(Node node, int key) {
		Node newNode = new Node(key, null, null); // newNode는 새롭게 저장될 노드를 의미한다.
		
		// root가 null이면 root에 newNode를 저장하고 마친다.
		if(root == null) {
			root = newNode;
			return null;
		}
		// root가 null이 아니라면 아래의 코드들이 실행된다.
		// 이미 Tree에 key값을 갖는 노드가 저장되어 있다면 메서드를 마친다.
		if(node.getValue() == key)
			return null;
		
		// node의 Value값과 param값 key의 크기를 비교하며 newNode가 저장될 위치를 탐색한다.
		
		// 만약 node의 value값이 key값 보다 크다면
		else if(node.getValue() > key) {
			// node의 왼쪽 자녀노드가 비어있다면 newNode를 왼쪽 자녀노드로 저장한다.
			if(node.getLeftChild() == null)
				node.setLeftChild(newNode);
			// node의 왼쪽 자녀노드가 비어있지 않다면 insert를 왼쪽자녀노드를 기준으로 재귀적으로 호출하여 다시 탐색한다.
			else
				insert(node.getLeftChild(), key);
		}
		// 만약 node의 value값이 key값 보다 작다면
		else {
			// node의 오른쪽 자녀노드가 비어있다면 newNode를 오른쪽 자녀노드로 저장한다.
			if(node.getRightChild() == null)
				node.setRightChild(newNode);
			// node의 오른쪽 자녀노드가 비어있지 안하면 insert를 오른쪽자녀노드를 기준으로 재귀적으로 호출하여 다시 탐색한다.
			else
				insert(node.getRightChild(), key);	
		}
		
		// 이곳부터 AVLTree에 대한 자료구조 정리에 관한 코드이다.
		
		// 위 과정이 재귀적으로 호출되며 높이가 1인 잎노드들 부터 아래과정이 실행되는데 가장먼저 node들의 좌우 자녀노드들의 높이와 node의 Balance값 부터 얻는다.
		// * 좌우 자녀노드의 높이를 저장
		int lch; // 왼쪽 자녀노드의 높이
		int rch; // 오른쪽 자녀노드의 높이
		// NullPoint 에러를 방지하기 위한 try-catch구문 (catch시 해당 자녀노드가 없음을 의미하므로 0저장)
		try {lch = node.getLeftChild().getHeight();}
		catch(Exception e){lch = 0;}
		try {rch = node.getRightChild().getHeight();}
		catch(Exception e) {rch = 0;}
		
		node.setBalance(); // Balacne값 설정
		
		// * node의 높이 설정 (만약 RR, RL, LL, LR에 해당한다면 모든 노드들이의 높이는 updateHeight메서드에 의해 갱신될 것이다.)
		// 우선 이 과정에 의해 node의 높이는 두 자녀노드의 높이값 중 큰 높이값+1을 갖는다.
		if(lch > rch)
			node.setHeight(lch + 1);
		else
			node.setHeight(rch + 1);
		
		
		// Right (RR, RL) - balance가 오른쪽으로 치우쳤을때
		if(node.getBalance() >= 2) {
			// Right Right - 그 중에서도 오른쪽으로만 치우쳤을때 
			if(node.getRightChild().getBalance() > 0) {
				// 해당 노드를 기준으로 노드들이 왼쪽으로 회전하고 높이가 갱신된다.
				leftRotation(node);
				updateHeight(root);
			}
			// Right Left - 오른쪽 왼쪽 순으로 치우쳤을때
			else if(node.getRightChild().getBalance() < 0) {
				// node의 오른쪽 자녀노드를 기준으로 오른쪽으로 한번 회전하고 node를 기준으로 다시 왼쪽으로 회전한다. 높이는 다시 갱신된다.
				rightRotation(node.getRightChild());
				leftRotation(node);
				updateHeight(root);
			}
			else
				return null; // 만약의 오류를 대비하여 null을 반환하도록 하였다.
		}
		// Left - balance가 왼쪽으로 치우쳤을때
		else if(node.getBalance() <= -2) {
			// Left Right - 왼쪽 오른쪽 순으로 치우쳤을때
			if(node.getLeftChild().getBalance() > 0) {
				// node의 왼쪽 자녀노드를 기준으로 왼쪽으로 한번 회전하고 node를 기준으로 다시 오른쪽으로 회전한다. 높이는 다시 갱신된다.
				leftRotation(node.getLeftChild());
				rightRotation(node);
				updateHeight(root);
			}
			// Left Left - 그중에서도 왼쪽으로만 치우쳤을때
			else if(node.getLeftChild().getBalance() < 0) {
				// 해당 노드를 기준으로 오른쪽으로 회전하고 높이가 갱신된다.
				rightRotation(node);
				updateHeight(root);
			}
			else
				return null; // 만약의 오류를 대비하여 null을 반환하도록 하였다.
		}
		// insert과정이 끝나면 null을 반환하고 마친다.
		return null;
	}
	
	/**
	 * updateHeight 메서드
	 * AVLTree의 노드들의 높이를 갱신하는 메서드
	 * @param node 이 메서드가 재귀적으로 호출되기 위해 사용될 param값
	 */
	public void updateHeight(Node node) {
		// node가 비어있지 않다면 실행된다.
		if(node != null) {
			// 좌우 자녀노드에서도 재귀적으로 호출된다. (높이가 1인 잎노드들부터 순차적으로 높이가 갱신된다.)
			updateHeight(node.getLeftChild());
			updateHeight(node.getRightChild());
			int lch; // 왼쪽 자녀노드의 높이
			int rch; // 오른쪽 자녀노드의 높이
			// NullPoint 에러를 방지하기위한 try-catch구문 (catch시 해당 자녀노드가 없음을 의미하여 0저장)
			try {lch = node.getLeftChild().getHeight();}
			catch(Exception e){lch = 0;} 
			try {rch = node.getRightChild().getHeight();}
			catch(Exception e) {rch = 0;}
			
			// * node의 높이 갱신 (두 자녀노드의 높이중 큰 높이값 + 1)
			if(lch > rch)
				node.setHeight(lch + 1);
			else
				node.setHeight(rch + 1);
		}
	}
	
	/** 
	 * rightRotation메서드
	 * @param node node를 기준으로 노드들을 오른쪽으로 회전시킨다.
	 */
	public void rightRotation(Node node) {
		int tmp = node.getValue(); // 현재 노드의 값을 저장
		// 두 tmpNode는 노드들을 회전하는데에 사용 될 것임
		Node tmpNode = null; 
		Node tmpNode2 = null;
		
		// 먼저 node의 value값을 왼쪽 자녀노드의 value값으로 바꾼다.
		node.setValue(node.getLeftChild().getValue());
		
		// 왼쪽 자녀노드의 오른쪽자녀노드가 존재한다마녀 그 노드를 tmpNode에 저장하고 node의 왼쪽 자녀노드를 왼쪽 자녀노드의 왼쪽 자녀노드로 교체한다. (이 과정에서 높이가 1차이인 왼쪽 자녀노드들이 삭제된다.)
		// 이 과정을 하는 이유는  node를 왼쪽 자녀노드로 바꿔주면서 노드들의 충돌을 방지하기 위함이다.
		// 이 과정을 통해 회전에서 왼쪽 자녀노드에 대한 정리는 끝났다.
		if(node.getLeftChild().getRightChild() != null)
			tmpNode = node.getLeftChild().getRightChild();
		node.setLeftChild(node.getLeftChild().getLeftChild());
		
		// node의 오른쪽 자녀노드가 비어있지 않다면 tmpNode2에 그 노드를 저장하고 node의 오른쪽 자녀노드를 tmp 즉, node의 기존value값을 갖는 새로운 노드로 저장한다.
		// 이떄 새로 저장된 노드는 왼쪽 자녀노드로 tmpNode를 오른쪽 자녀노드로 tmpNode2를 갖는다.
		if(node.getRightChild() != null) {
			tmpNode2 = node.getRightChild();
			node.setRightChild(new Node(tmp, tmpNode, tmpNode2));
		}
		// 만약 오른쪽 자녀노드가 비어있다면 tmpNode2를 제외하고 같은 과정을 진행한다.
		else {
			node.setRightChild(new Node(tmp, tmpNode, null));
		}
	}
	
	
	/** 
	 * leftRotation 메서드
	 * @param node param노드를 기준으로 왼쪽으로 회전한다.
	 */
	public void leftRotation(Node node) {
		int tmp = node.getValue(); // 현재 노드의 값을 저장
		// 두 tmpNode는 노드들을 회전하는데에 사용 될 것임
		Node tmpNode = null; 
		Node tmpNode2 = null;
		
		// 먼저 node의 value값을 오른쪽 자녀노드의 value값으로 바꾼다.
		node.setValue(node.getRightChild().getValue());
		
		// 오른쪽 자녀노드의 왼쪽자녀노드가 존재한다마녀 그 노드를 tmpNode에 저장하고 node의 오른쪽 자녀노드를 오른쪽 자녀노드의 오른쪽 자녀노드로 교체한다. (이 과정에서 높이가 1차이인 오른쪽 자녀노드들이 삭제된다.)
		// 이 과정을 하는 이유는  node를 오른쪽 자녀노드로 바꿔주면서 노드들의 충돌을 방지하기 위함이다.
		// 이 과정을 통해 회전에서 오른쪽 자녀노드에 대한 정리는 끝났다.
		if(node.getRightChild().getLeftChild() != null)
			tmpNode = node.getRightChild().getLeftChild();
		node.setRightChild(node.getRightChild().getRightChild());
		
		// node의 왼쪽 자녀노드가 비어있지 않다면 tmpNode2에 그 노드를 저장하고 node의 왼쪽 자녀노드를 tmp 즉, node의 기존value값을 갖는 새로운 노드로 저장한다.
		// 이떄 새로 저장된 노드는 오른쪽 자녀노드로 tmpNode를 왼쪽 자녀노드로 tmpNode2를 갖는다.
		if(node.getLeftChild() != null) {
			tmpNode2 = node.getLeftChild();
			node.setLeftChild(new Node(tmp, tmpNode2, tmpNode));
		}
		// 만약 왼쪽 자녀노드가 비어있다면 tmpNode2를 제외하고 같은 과정을 진행한다.
		else {
			node.setLeftChild(new Node(tmp, null, tmpNode));
		}
	}
}
