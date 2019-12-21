package BinarySearchTree;

/** BinarySearchTreeŬ����
 * ����Ʈ���� ���� Ŭ�����̴�.
 * @author NoA
 *
 */
public class BinarySearchTree {
	private Node root;
	
	/** BinarySearchTree�� ������1. 
	 * root�� ����.
	 */
	public BinarySearchTree() {
		this.root = null;
	}
	
	/** BinarySearchTree�� ������2. 
	 * param���� root�� �޴´�.
	 * @param root root�� �޴´�.
	 */
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	
	/** NodeŬ����
	 * @author NoA
	 */
	private class Node{
		private int key; // key �ʵ�
		private Node left, right; // ���� �ڳ���� ������ �ڳ��� �ʵ�
		
		/** NodeŬ������ ������
		 * @param key key�� ��, ���
		 */
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right =null;
		}
	}
	
	/** getRoot�޼���
	 * @return root �ش� Tree�� root�� ��ȯ
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/** printTree�޼���
	 * ���� ����Ʈ������ ��µȴ�.
	 * @param root root������ ����Ѵ�.
	 */
	public void printTree(Node root) {
		// ����Ʈ���� root�� null�� �ƴҶ� ���� ��������� Ž��, ����Ѵ�.
		if(root != null) {
			printTree(root.left); // ���ʺ��� Ž��, ���
			System.out.print(root.key + " "); // �� ��� �� ���
			printTree(root.right); // ���� ����Ʈ���� ��� Ž������ ������ ����Ʈ���� Ž��.
			
			// * (�̶��� ������ ����Ʈ���� ���� ����Ʈ���� �켱������ Ž��, ����Ѵ�)
		}
	}
	
	/** deleteNode �޼���
	 * �з��� root�� root�� ���� Ʈ������ targetValue�� key�� ���� ��带 ã�� �����ϴ� �޼���
	 * @param root tree�� root
	 * @param targetValue �����Ϸ��� ����� value
	 * @return newRoot ������ ������ ��� Ʈ���� ��ȯ�Ѵ�.
	 */
	public Node deleteNode(Node root, int targetValue) {
		Node tmp, tmp2, dNode; // dNode�� ������ ��� tmp, tmp2�� Ž������̴�.
		// root�� key���� targetValue�� ���� �� ��
		// �װ��� ��츦 ����� �����ϵ� ������ �����Ѵ�. (�����ڷῡ�� ��������� ������ �ʿ信 ���� �װ��� �ø��ڴ�.)
		if(root.key == targetValue) {
			// root�� �ٳ���� ����̴�.
			if(root.left == null && root.right == null) {
				root = null; // root�� null�� ���ְ� ��ģ��.
				return null;
			}
			
			// ����Ʈ���� �����ʿ��� ������ ����̴�.
			else if(root.left == null) {
				// �����Ϸ��� ��带 ������ ����Ʈ���� ��ü�Ѵ�.
				tmp = root.right;
				return tmp;
			}
			
			// ����Ʈ���� ���ʿ��� ������ ����̴�.
			else if(root.right == null) {
				// �����Ϸ��� ��带 ���� ����Ʈ���� ��ü�Ѵ�.
				tmp = root.left;
				return tmp;
			}
			
			// ����Ʈ���� ���ʿ� ��� ������ ����̴�.
			else {
				tmp2 = root; // tmp2�� tmp�� �θ���� Ž���� ���̴�.
				tmp = root.right; // root�� ������ ����Ʈ���� �ּ� ��带 ã�µ� ���� ���
				//�ּ� ��带 ã�´�.
				while(tmp.left != null) {
					tmp2 = tmp;
					tmp = tmp.left;
				}
				
				// �ּҳ�尡 ������ �����带 ������ ����� ������ ������ �ڵ��̴�.
				// �ּҳ�带 �����Ϸ��� ���� ��ü�� �� �ּҳ�尡 ������ �����带 �����ִٸ�
				// ������ ������� ��������� ������ �����尡 �浹�ϴ� ������ �߻��Ѵ�. �̸� �����ϱ� ���� �ڵ��̴�.
				if(tmp2.left == tmp)
					tmp2.left = tmp.right;
				
				else
					tmp2.right = tmp.right;
				
				// root�� key���� root�� ��� ��ü���ش�.
				// root�� ��ü�� �� key���� ��ü���� �ʴ� ������ �߻��Ѵ�.
				root.key = tmp.key;
				root = tmp;
				return tmp2;
			}
		}
		
		// targetValue���� root�� key���� Ŭ��
		if(targetValue < root.key) {
			// deleteNode�� ��ȣ�� (���� ����Ʈ������ �ٽ� Ž��)
			dNode = deleteNode(root.left, targetValue);
			root.left = dNode; // ������ Ʈ���� �ٽ� ������ �ش�.
		}
		// targetValue���� root�� key���� ������
		else {
			// deleteNode�� ��ȣ�� (������ ����Ʈ������ �ٽ� Ž��)
			dNode = deleteNode(root.right, targetValue);
			root.right = dNode; // ������ Ʈ���� �ٽ� ������ �ش�.
		}
		return root; // root��ȯ
	}
	
	/** insert�޼���
	 * �з��� value�� Ʈ���� �߰��ϴ� �޼���
	 * @param value �߰��ϴ� ��
	 * @return true or false (�߰��� �����ϸ� true �̹� �ش� ��尡 ������ false)
	 */
	public boolean insert(int value) {
		// ���� tree�� ����ִٸ� value�� �� root�̴�.
		if(root == null) {
			root = new Node(value);
			return true;
		}
		
		Node tmp = root; // value���� ������ ��ġ�� ã�� ���� ���Ǵ� tmp
		Node pTmp; // tmp�� �θ� ���
		
		// �ڸ��� ã�� ������ �ݺ�
		while(tmp != null) {
			pTmp = tmp;
			
			// tmp�� key���� value�� ���ٸ� ��, ���� �ߺ��ؼ� �����Ѵٸ�
			if(pTmp.key == value)
				return false; // false�� ��ȯ�Ͽ� ���Կ� �����Ͽ����� �˸�
			
			// tmp�� key������ value�� ũ�ٸ� tmp�� ������ ����Ʈ���� �񱳸� �̾��
			else if(pTmp.key < value) {
				tmp = pTmp.right;
				
				// tmp�� ����ִٸ� value����
				if(tmp == null) 
					pTmp.right = new Node(value);
			}
			
			// tmp�� key������ value�� �۴ٸ� tmp�� ���� ����Ʈ���� �񱳸� �̾��
			else {
				tmp = pTmp.left;
				
				// tmp�� ����ִٸ� value����
				if(tmp == null) 
					pTmp.left = new Node(value);
			}
		}
		return true; // ���Կ� �����Ͽ����Ƿ� true ��ȯ
	}
}
