package OrderedTree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/** OrderedTree Ŭ����
 * 
 * OrederedTree�� �����ϰ� �ִ� Ŭ������ Level Order, Pre Order, Post Order�� ���� ������ �����ִ�.
 * @author NoA
 *
 */
public class OrderedTree {
	private Object root; // root�ʵ�
	private List subtrees; // subtrees�� �����ϴ� �ʵ�
	private int size; // ������ �����ϴ� �ʵ�
	
	/** OrderedTree�� ù��° ������
	 * OrderedTree��ü�� ������ �� �ƹ��� �۾��� ���� �ʴ´�.
	 */
	public OrderedTree() {
		
	}
	
	/** OrderedTree�� �ι�° ������
	 * OrderedTree��ü�� ������ �� root�� �Ű��� �޾� �����ϰ� subtrees��ü�� �����Ѵ�.
	 * @param root ��Ʈ ��, �ش� Ʈ���� �ֻ��� ���
	 */
	public OrderedTree(Object root) {
		this.root = root;
		subtrees = new LinkedList();
		this.size = 1; // root�� �����Ƿ� size�� 1
	}
	
	/** OrderedTree�� ����° ������
	 * OrderedTree��ü�� ������ �� root�� trees�� �Ű��� �޴´�. 
	 * �ι�° �������� ������ �״�� �ϸ鼭 trees�� ���ڵ��� ���������� subtrees�� �����Ѵ�. 
	 * @param root ��Ʈ ��, �ش� Ʈ���� �ֻ��� ���
	 * @param trees subtrees�� ����Ʈ�η�(subtrees�� ���� tree) ����� Ʈ��
	 */
	public OrderedTree(Object root, List trees) {
		this (root); // root�� �Ű������� �޴� ��, OrderedTree(Object root)�� ȣ���Ѵ�.
		
		// �Ű����� trees�� Iterator�� �ݺ�Ž��
		for(Iterator it = trees.iterator(); it.hasNext();) {
			Object object = it.next(); // object�� trees�� ���ڸ� ���������� ��Ÿ����.
			
			// object�� Ÿ���� OrderedTree�̰ų� �θ��� ��, OrderedTree�� ����ȯ�� �����ϸ�
			if(object instanceof OrderedTree) {
				// object�� OrderedTree�� ����ȯ�ϰ� subtrees�� �����Ѵ�.
				OrderedTree tree = (OrderedTree)object;
				subtrees.add(tree);
				size += tree.size(); // ���ο� ��尡 �߰��Ǿ����Ƿ� size�� ũ�⸦ �÷��ش�.
			}
		}
	}
	
	/** size�޼���
	 * ��ü ��� �� ��ȯ
	 * @return ���� tree�� size ��, ��� �� ��ȯ
	 */
	public int size() {
		return this.size;
	}
	
	/** printTreeByLevelOrder �޼���
	 * LevelOrder�� Ʈ���� Ž���Ͽ� ����ϴ� �޼���
	 */
	public void printTreeByLevelOrder() {
		ArrayDeque queue = new ArrayDeque(); // queue��ü ����
		
		queue.add(this); // queue�� OrderedTree�� ���� ���������� �߰��Ѵ�.
		
		// queue�� �� ������ pop�ϸ鼭 ����Ѵ�.
		while(!queue.isEmpty()) { 
			// tmpSubtrees�� queue�� ���ڸ� ��, �θ� tree�� root�� �ϳ��� �����ذ��� �����Ѵ�.
			OrderedTree tmpSubtrees = (OrderedTree)queue.pop();
			System.out.print(tmpSubtrees.root + " "); // tmpSubtrees�� root�� ����Ѵ�.
			
			// tmpSubtrees�� subtree���� �ݺ��ڷ� Ž���Ѵ�.(�̶� subtree�� �ļճ�� ��ΰ� �ƴ϶� �ٷ� ���� Level�� ������ ���Ѵ�.)
			for(Iterator it = tmpSubtrees.subtrees.iterator(); it.hasNext();) {
				Object object = it.next(); // object�� subtrees�� ���ڵ��� �ϳ��� �����Ѵ�.
				
				// ���� object�� OrderedTree�� ����ȯ �� �� �ִٸ�
				if(object instanceof OrderedTree) {
					// object�� OrederedTree�� ����ȯ �� queue�� �߰��Ѵ�. (�׷� queue�� �޼��� ������� ���ι��� Ʈ�� ���� (A), (B,C,D), (E,F), (G) ������ �����Ѵ�.)
					OrderedTree tree = (OrderedTree)object;
					queue.add(tree);
				}
			}
		}
	}
	
	/** printTreeByPreOrder �޼���
	 * PreOrder�� Ʈ���� Ž���Ͽ� ����ϴ� �޼���
	 */
	public void printTreeByPreOrder() {
		System.out.print(root + " "); // PreOrder�� �־��� Tree�� root���� Ž���ϱ� �����Ѵ�.
		
		// Iterator�ݺ����� ���Ͽ� subtree�� Ž���Ѵ�.
		for(Iterator it = subtrees.iterator(); it.hasNext();) {
			Object object = it.next(); // object�� subtrees�� ���ڵ��� �ϳ��� �����Ѵ�.
			
			// ���� object�� OrderedTree�� ����ȯ �� �� �ִٸ�
			if(object instanceof OrderedTree) {
				// object�� OrderedTree�� ����ȯ �� printTreeByPreOrder�޼��带 ��������� ȣ���Ѵ�
				// �� ��� root�� �ٳ�� �϶����� ����Ʈ������ Ž���ذ��� �� ����Ʈ���� root�� ����ϴ� ���̴�.
				OrderedTree tree = (OrderedTree)object;
				tree.printTreeByPreOrder();
			}
		}
	}
	
	/** printTreeByPostOrder �޼���
	 * PostOrder�� Ʈ���� Ž���Ͽ� ����ϴ� �޼���
	 */
	public void printTreeByPostOrder() {
		
		// �� ��¹��� PreOrder���� �ݴ�� Ž���ϸ� ����ϴ� ������� Ž�� ���Ŀ� ��¹��� ����ȴ�. (PreOrder�� ������� Ž��) 
		// ���� �������� ������ ��¹� ��ġ�� �����ϰ� PreOrder�� �����ϴ�.
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
