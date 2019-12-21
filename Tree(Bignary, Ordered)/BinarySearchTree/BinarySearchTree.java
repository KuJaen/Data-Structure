package BinarySearchTree;

/** BinarySearchTree클래스
 * 이진트리에 대한 클래스이다.
 * @author NoA
 *
 */
public class BinarySearchTree {
	private Node root;
	
	/** BinarySearchTree의 생성자1. 
	 * root가 없다.
	 */
	public BinarySearchTree() {
		this.root = null;
	}
	
	/** BinarySearchTree의 생성자2. 
	 * param값을 root로 받는다.
	 * @param root root를 받는다.
	 */
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	
	/** Node클래스
	 * @author NoA
	 */
	private class Node{
		private int key; // key 필드
		private Node left, right; // 왼쪽 자녀노드와 오른쪽 자녀노드 필드
		
		/** Node클래스의 생성자
		 * @param key key값 즉, 노드
		 */
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right =null;
		}
	}
	
	/** getRoot메서드
	 * @return root 해당 Tree의 root를 반환
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/** printTree메서드
	 * 왼쪽 서브트리부터 출력된다.
	 * @param root root값부터 출력한다.
	 */
	public void printTree(Node root) {
		// 서브트리의 root가 null이 아닐때 까지 재귀적으로 탐색, 출력한다.
		if(root != null) {
			printTree(root.left); // 왼쪽부터 탐색, 출력
			System.out.print(root.key + " "); // 각 노드 값 출력
			printTree(root.right); // 왼쪽 서브트리를 모드 탐사한후 오른쪽 서브트리를 탐색.
			
			// * (이때도 오른쪽 서브트리의 왼쪽 서브트리를 우선적으로 탐색, 출력한다)
		}
	}
	
	/** deleteNode 메서드
	 * 패럼값 root를 root로 갖는 트리에서 targetValue를 key로 갖는 노드를 찾아 삭제하는 메서드
	 * @param root tree의 root
	 * @param targetValue 삭제하려는 노드의 value
	 * @return newRoot 삭제에 성공한 결과 트리를 반환한다.
	 */
	public Node deleteNode(Node root, int targetValue) {
		Node tmp, tmp2, dNode; // dNode는 삭제될 노드 tmp, tmp2는 탐색노드이다.
		// root의 key값이 targetValue와 동일 할 때
		// 네가지 경우를 나누어서 생각하되 서순에 유의한다. (강의자료에는 세가지라고 했지만 필요에 의해 네개로 늘리겠다.)
		if(root.key == targetValue) {
			// root가 잎노드인 경우이다.
			if(root.left == null && root.right == null) {
				root = null; // root를 null로 해주고 마친다.
				return null;
			}
			
			// 서브트리가 오른쪽에만 존재할 경우이다.
			else if(root.left == null) {
				// 삭제하려는 노드를 오른쪽 서브트리로 교체한다.
				tmp = root.right;
				return tmp;
			}
			
			// 서브트리가 왼쪽에만 존재할 경우이다.
			else if(root.right == null) {
				// 삭제하려는 노드를 왼쪽 서브트리로 교체한다.
				tmp = root.left;
				return tmp;
			}
			
			// 서브트리가 양쪽에 모두 존재할 경우이다.
			else {
				tmp2 = root; // tmp2는 tmp의 부모노드로 탐색될 것이다.
				tmp = root.right; // root의 오른쪽 서브트리의 최소 노드를 찾는데 사용될 노드
				//최소 노드를 찾는다.
				while(tmp.left != null) {
					tmp2 = tmp;
					tmp = tmp.left;
				}
				
				// 최소노드가 오른쪽 서브노드를 가질때 생기는 오류를 방지한 코드이다.
				// 최소노드를 삭제하려는 노드와 교체할 때 최소노드가 오른쪽 서브노드를 갖고있다면
				// 오른쪽 서브노드와 삭제노드의 오른쪽 서브노드가 충돌하는 오류가 발생한다. 이를 방지하기 위한 코드이다.
				if(tmp2.left == tmp)
					tmp2.left = tmp.right;
				
				else
					tmp2.right = tmp.right;
				
				// root의 key값과 root를 모두 교체해준다.
				// root만 교체할 시 key값은 교체되지 않는 오류가 발생한다.
				root.key = tmp.key;
				root = tmp;
				return tmp2;
			}
		}
		
		// targetValue보다 root의 key값이 클때
		if(targetValue < root.key) {
			// deleteNode를 재호출 (왼쪽 서브트리에서 다시 탐색)
			dNode = deleteNode(root.left, targetValue);
			root.left = dNode; // 삭제한 트리를 다시 연결해 준다.
		}
		// targetValue보다 root의 key값이 작을때
		else {
			// deleteNode를 재호출 (오른쪽 서브트리에서 다시 탐색)
			dNode = deleteNode(root.right, targetValue);
			root.right = dNode; // 삭제한 트리를 다시 연결해 준다.
		}
		return root; // root반환
	}
	
	/** insert메서드
	 * 패럼값 value를 트리에 추가하는 메서드
	 * @param value 추가하는 값
	 * @return true or false (추가에 성공하면 true 이미 해당 노드가 있으면 false)
	 */
	public boolean insert(int value) {
		// 만약 tree가 비어있다면 value는 새 root이다.
		if(root == null) {
			root = new Node(value);
			return true;
		}
		
		Node tmp = root; // value값을 삽입할 위치를 찾기 위해 사용되는 tmp
		Node pTmp; // tmp의 부모 노드
		
		// 자리를 찾을 때까지 반복
		while(tmp != null) {
			pTmp = tmp;
			
			// tmp의 key값이 value와 같다면 즉, 값을 중복해서 삽입한다면
			if(pTmp.key == value)
				return false; // false를 반환하여 삽입에 실패하였음을 알림
			
			// tmp의 key값보다 value가 크다면 tmp의 오른쪽 서브트리와 비교를 이어나감
			else if(pTmp.key < value) {
				tmp = pTmp.right;
				
				// tmp가 비어있다면 value삽입
				if(tmp == null) 
					pTmp.right = new Node(value);
			}
			
			// tmp의 key값보다 value가 작다면 tmp의 왼쪽 서브트리와 비교를 이어나감
			else {
				tmp = pTmp.left;
				
				// tmp가 비어있다면 value삽입
				if(tmp == null) 
					pTmp.left = new Node(value);
			}
		}
		return true; // 삽입에 성공하였으므로 true 반환
	}
}
