package OrderedTree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/** OrderedTree 클래스
 * 
 * OrederedTree를 정의하고 있는 클래스로 Level Order, Pre Order, Post Order에 대한 정보를 갖고있다.
 * @author NoA
 *
 */
public class OrderedTree {
	private Object root; // root필드
	private List subtrees; // subtrees를 저장하는 필드
	private int size; // 노드수를 저장하는 필드
	
	/** OrderedTree의 첫번째 생성자
	 * OrderedTree객체를 생성할 때 아무런 작업도 하지 않는다.
	 */
	public OrderedTree() {
		
	}
	
	/** OrderedTree의 두번째 생성자
	 * OrderedTree객체를 생성할 때 root를 매개로 받아 저장하고 subtrees객체를 생성한다.
	 * @param root 루트 즉, 해당 트리의 최상위 노드
	 */
	public OrderedTree(Object root) {
		this.root = root;
		subtrees = new LinkedList();
		this.size = 1; // root가 있으므로 size는 1
	}
	
	/** OrderedTree의 세번째 생성자
	 * OrderedTree객체를 생성할 때 root와 trees를 매개로 받는다. 
	 * 두번째 생성자의 역할을 그대로 하면서 trees의 인자들을 순차적으로 subtrees에 저장한다. 
	 * @param root 루트 즉, 해당 트리의 최상위 노드
	 * @param trees subtrees에 서브트로로(subtrees의 하위 tree) 저장될 트리
	 */
	public OrderedTree(Object root, List trees) {
		this (root); // root를 매개변수로 받는 즉, OrderedTree(Object root)를 호출한다.
		
		// 매개변수 trees를 Iterator로 반복탐색
		for(Iterator it = trees.iterator(); it.hasNext();) {
			Object object = it.next(); // object는 trees의 인자를 순차적으로 나타낸다.
			
			// object의 타입이 OrderedTree이거나 부모형 즉, OrderedTree로 형변환이 가능하면
			if(object instanceof OrderedTree) {
				// object를 OrderedTree로 형변환하고 subtrees에 저장한다.
				OrderedTree tree = (OrderedTree)object;
				subtrees.add(tree);
				size += tree.size(); // 새로운 노드가 추가되었으므로 size의 크기를 늘려준다.
			}
		}
	}
	
	/** size메서드
	 * 전체 노드 수 반환
	 * @return 현재 tree의 size 즉, 노드 수 반환
	 */
	public int size() {
		return this.size;
	}
	
	/** printTreeByLevelOrder 메서드
	 * LevelOrder로 트리를 탐색하여 출력하는 메서드
	 */
	public void printTreeByLevelOrder() {
		ArrayDeque queue = new ArrayDeque(); // queue객체 생성
		
		queue.add(this); // queue에 OrderedTree에 대한 참조값들을 추가한다.
		
		// queue가 빌 때까지 pop하면서 출력한다.
		while(!queue.isEmpty()) { 
			// tmpSubtrees는 queue의 인자를 즉, 부모 tree의 root를 하나씩 삭제해가며 저장한다.
			OrderedTree tmpSubtrees = (OrderedTree)queue.pop();
			System.out.print(tmpSubtrees.root + " "); // tmpSubtrees의 root를 출력한다.
			
			// tmpSubtrees의 subtree들을 반복자로 탐색한다.(이때 subtree는 후손노드 모두가 아니라 바로 다음 Level의 노드들을 말한다.)
			for(Iterator it = tmpSubtrees.subtrees.iterator(); it.hasNext();) {
				Object object = it.next(); // object는 subtrees의 인자들을 하나씩 지정한다.
				
				// 만약 object가 OrderedTree로 형변환 할 수 있다면
				if(object instanceof OrderedTree) {
					// object를 OrederedTree로 형변환 후 queue에 추가한다. (그럼 queue는 메서드 종료까지 메인문의 트리 기준 (A), (B,C,D), (E,F), (G) 순서로 저장한다.)
					OrderedTree tree = (OrderedTree)object;
					queue.add(tree);
				}
			}
		}
	}
	
	/** printTreeByPreOrder 메서드
	 * PreOrder로 트리를 탐색하여 출력하는 메서드
	 */
	public void printTreeByPreOrder() {
		System.out.print(root + " "); // PreOrder은 주어진 Tree를 root부터 탐색하기 시작한다.
		
		// Iterator반복문을 통하여 subtree를 탐색한다.
		for(Iterator it = subtrees.iterator(); it.hasNext();) {
			Object object = it.next(); // object는 subtrees의 인자들을 하나씩 지정한다.
			
			// 만약 object가 OrderedTree로 형변환 할 수 있다면
			if(object instanceof OrderedTree) {
				// object를 OrderedTree로 형변환 후 printTreeByPreOrder메서드를 재귀적으로 호출한다
				// 이 경우 root가 잎노드 일때까지 서브트리들을 탐색해가며 그 서브트리의 root를 출력하는 것이다.
				OrderedTree tree = (OrderedTree)object;
				tree.printTreeByPreOrder();
			}
		}
	}
	
	/** printTreeByPostOrder 메서드
	 * PostOrder로 트리를 탐색하여 출력하는 메서드
	 */
	public void printTreeByPostOrder() {
		
		// 이 출력법은 PreOrder과는 반대로 탐색하며 출력하는 방법으로 탐색 이후에 출력문이 실행된다. (PreOrder은 출력이후 탐색) 
		// 따라서 구조적인 원리는 출력문 위치를 제외하고 PreOrder과 동일하다.
		for(Iterator it = subtrees.iterator(); it.hasNext();) {
			Object object = it.next();
			
			if(object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree) object;
				tree.printTreeByPostOrder();
			}
		}
		
		System.out.print(root + " ");
	}
}
