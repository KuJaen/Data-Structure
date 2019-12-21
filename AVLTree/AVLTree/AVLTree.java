package AVLTree;

/**
 * AVLTreeŬ������ AVLTree�� ���õ� �޼������ ����ִ�.
 * @author NoA
 *
 */
public class AVLTree {
	private Node root; // AVLTree�� root�� �����ϴ� �ʵ�
	
	/**
	 * AVLTree�� ù��° �������̴�.
	 * ó�� AVLTree�� ������ �� root���� ���� ���� �ʾ� root�� null�� �����Ѵ�.
	 */
	public AVLTree() {
		this.root = null;
	}
	
	/**
	 * AVLTree�� �ι�° �������̴�.
	 * root�� param������ �޾� �����Ѵ�.
	 * @param root root�� ������ Node
	 */
	public AVLTree(Node root) {
		this.root = root;
	}
	
	/**
	 * getRoot �޼���
	 * @return root�� ��ȯ�Ѵ�.
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/** 
	 * setRoot �޼���
	 * @param newNode param�� newNode�� �Է¹޾� root�� �����Ѵ�.
	 */
	public void setRoot(Node newNode) {
		this.root = newNode;
	}
	
	/**
	 * height�޼���
	 * 
	 * �� �޼���� �ǽ����� �������� �⺻ �ڵ��̴�. 
	 * ���� ���Ǹ� ���� NodeŬ������ ���̿� ���� �޼��带 ���� ����� �������Ƿ� ���������� �� �޼���� ������ ���� ���̴�.
	 * param�� ���̸� ��ȯ�ϴ� �޼���
	 * @param N ���̸� ��ȯ�� param���
	 * @return param�� ���̸� ��ȯ�Ѵ�.
	 */
	int height(Node N) {
		// param�� null�̸� ���̷� 0�� ��ȯ�Ѵ�.
		if(N == null)
			return 0;
		// �� ���ǿ� �ش����� ������ getHeight�޼��带 ȣ���Ͽ� ���̰��� ��ȯ�Ѵ�.
		return N.getHeight();
	}
	
	/**
	 * getBalance�޼���
	 * 
	 * �� �޼���� �ǽ����� �������� �⺻ �ڵ��̴�.
	 * ���� ���Ǹ� ���� NodeŬ������ Balance�� ���� �޼��带 ���� ����� �������Ƿ� ���������� �� �޼���� ������ ���� ���̴�.
	 * @param balance���� ������ ��带 param���� �޴´�.
	 * @return param�� balance���� ����ϰ� ��ȯ�Ѵ�.
	 */
	int getBalance(Node N) {
		// param�� null�̸� 0�� ��ȯ�Ѵ�.
		if(N == null)
			return 0;
		// �� ���ǿ� �ش����� ������ balance�� ���, ��ȯ�Ѵ�.
		return height(N.getLeftChild()) - height(N.getRightChild());
	}
	
	/** 
	 * preOrderPrint�޼���
	 * @param node ��������� Node���� ����ϱ� ���� ���� param������ �� param������ ������ ��µȴ�.
	 */
	void preOrderPrint(Node node) {
		// node�� ����ִٸ� ������� ������� �ʴ´�.
		if(node != null) {
			// node�� value���� ����ϰ� ��� �޼��带 ��������� ȣ���Ѵ�.
			System.out.print(node.getValue() + " ");
			preOrderPrint(node.getLeftChild());
			preOrderPrint(node.getRightChild());
		}
	}
	
	/**
	 * insert �޼���
	 * @param node ��������� insert�� �����ϱ� ���� ���� param���̴�.
	 * @param key ���� ����� ����� key���̴�.
	 * @return insert�� ������ ��찡 ���� �����Ƿ� null�� ��ȯ�� ���̴�.
	 */
	public Node insert(Node node, int key) {
		Node newNode = new Node(key, null, null); // newNode�� ���Ӱ� ����� ��带 �ǹ��Ѵ�.
		
		// root�� null�̸� root�� newNode�� �����ϰ� ��ģ��.
		if(root == null) {
			root = newNode;
			return null;
		}
		// root�� null�� �ƴ϶�� �Ʒ��� �ڵ���� ����ȴ�.
		// �̹� Tree�� key���� ���� ��尡 ����Ǿ� �ִٸ� �޼��带 ��ģ��.
		if(node.getValue() == key)
			return null;
		
		// node�� Value���� param�� key�� ũ�⸦ ���ϸ� newNode�� ����� ��ġ�� Ž���Ѵ�.
		
		// ���� node�� value���� key�� ���� ũ�ٸ�
		else if(node.getValue() > key) {
			// node�� ���� �ڳ��尡 ����ִٸ� newNode�� ���� �ڳ���� �����Ѵ�.
			if(node.getLeftChild() == null)
				node.setLeftChild(newNode);
			// node�� ���� �ڳ��尡 ������� �ʴٸ� insert�� �����ڳ��带 �������� ��������� ȣ���Ͽ� �ٽ� Ž���Ѵ�.
			else
				insert(node.getLeftChild(), key);
		}
		// ���� node�� value���� key�� ���� �۴ٸ�
		else {
			// node�� ������ �ڳ��尡 ����ִٸ� newNode�� ������ �ڳ���� �����Ѵ�.
			if(node.getRightChild() == null)
				node.setRightChild(newNode);
			// node�� ������ �ڳ��尡 ������� ���ϸ� insert�� �������ڳ��带 �������� ��������� ȣ���Ͽ� �ٽ� Ž���Ѵ�.
			else
				insert(node.getRightChild(), key);	
		}
		
		// �̰����� AVLTree�� ���� �ڷᱸ�� ������ ���� �ڵ��̴�.
		
		// �� ������ ��������� ȣ��Ǹ� ���̰� 1�� �ٳ��� ���� �Ʒ������� ����Ǵµ� ������� node���� �¿� �ڳ������ ���̿� node�� Balance�� ���� ��´�.
		// * �¿� �ڳ����� ���̸� ����
		int lch; // ���� �ڳ����� ����
		int rch; // ������ �ڳ����� ����
		// NullPoint ������ �����ϱ� ���� try-catch���� (catch�� �ش� �ڳ��尡 ������ �ǹ��ϹǷ� 0����)
		try {lch = node.getLeftChild().getHeight();}
		catch(Exception e){lch = 0;}
		try {rch = node.getRightChild().getHeight();}
		catch(Exception e) {rch = 0;}
		
		node.setBalance(); // Balacne�� ����
		
		// * node�� ���� ���� (���� RR, RL, LL, LR�� �ش��Ѵٸ� ��� �������� ���̴� updateHeight�޼��忡 ���� ���ŵ� ���̴�.)
		// �켱 �� ������ ���� node�� ���̴� �� �ڳ����� ���̰� �� ū ���̰�+1�� ���´�.
		if(lch > rch)
			node.setHeight(lch + 1);
		else
			node.setHeight(rch + 1);
		
		
		// Right (RR, RL) - balance�� ���������� ġ��������
		if(node.getBalance() >= 2) {
			// Right Right - �� �߿����� ���������θ� ġ�������� 
			if(node.getRightChild().getBalance() > 0) {
				// �ش� ��带 �������� ������ �������� ȸ���ϰ� ���̰� ���ŵȴ�.
				leftRotation(node);
				updateHeight(root);
			}
			// Right Left - ������ ���� ������ ġ��������
			else if(node.getRightChild().getBalance() < 0) {
				// node�� ������ �ڳ��带 �������� ���������� �ѹ� ȸ���ϰ� node�� �������� �ٽ� �������� ȸ���Ѵ�. ���̴� �ٽ� ���ŵȴ�.
				rightRotation(node.getRightChild());
				leftRotation(node);
				updateHeight(root);
			}
			else
				return null; // ������ ������ ����Ͽ� null�� ��ȯ�ϵ��� �Ͽ���.
		}
		// Left - balance�� �������� ġ��������
		else if(node.getBalance() <= -2) {
			// Left Right - ���� ������ ������ ġ��������
			if(node.getLeftChild().getBalance() > 0) {
				// node�� ���� �ڳ��带 �������� �������� �ѹ� ȸ���ϰ� node�� �������� �ٽ� ���������� ȸ���Ѵ�. ���̴� �ٽ� ���ŵȴ�.
				leftRotation(node.getLeftChild());
				rightRotation(node);
				updateHeight(root);
			}
			// Left Left - ���߿����� �������θ� ġ��������
			else if(node.getLeftChild().getBalance() < 0) {
				// �ش� ��带 �������� ���������� ȸ���ϰ� ���̰� ���ŵȴ�.
				rightRotation(node);
				updateHeight(root);
			}
			else
				return null; // ������ ������ ����Ͽ� null�� ��ȯ�ϵ��� �Ͽ���.
		}
		// insert������ ������ null�� ��ȯ�ϰ� ��ģ��.
		return null;
	}
	
	/**
	 * updateHeight �޼���
	 * AVLTree�� ������ ���̸� �����ϴ� �޼���
	 * @param node �� �޼��尡 ��������� ȣ��Ǳ� ���� ���� param��
	 */
	public void updateHeight(Node node) {
		// node�� ������� �ʴٸ� ����ȴ�.
		if(node != null) {
			// �¿� �ڳ��忡���� ��������� ȣ��ȴ�. (���̰� 1�� �ٳ������ ���������� ���̰� ���ŵȴ�.)
			updateHeight(node.getLeftChild());
			updateHeight(node.getRightChild());
			int lch; // ���� �ڳ����� ����
			int rch; // ������ �ڳ����� ����
			// NullPoint ������ �����ϱ����� try-catch���� (catch�� �ش� �ڳ��尡 ������ �ǹ��Ͽ� 0����)
			try {lch = node.getLeftChild().getHeight();}
			catch(Exception e){lch = 0;} 
			try {rch = node.getRightChild().getHeight();}
			catch(Exception e) {rch = 0;}
			
			// * node�� ���� ���� (�� �ڳ����� ������ ū ���̰� + 1)
			if(lch > rch)
				node.setHeight(lch + 1);
			else
				node.setHeight(rch + 1);
		}
	}
	
	/** 
	 * rightRotation�޼���
	 * @param node node�� �������� ������ ���������� ȸ����Ų��.
	 */
	public void rightRotation(Node node) {
		int tmp = node.getValue(); // ���� ����� ���� ����
		// �� tmpNode�� ������ ȸ���ϴµ��� ��� �� ����
		Node tmpNode = null; 
		Node tmpNode2 = null;
		
		// ���� node�� value���� ���� �ڳ����� value������ �ٲ۴�.
		node.setValue(node.getLeftChild().getValue());
		
		// ���� �ڳ����� �������ڳ��尡 �����Ѵٸ��� �� ��带 tmpNode�� �����ϰ� node�� ���� �ڳ��带 ���� �ڳ����� ���� �ڳ���� ��ü�Ѵ�. (�� �������� ���̰� 1������ ���� �ڳ������ �����ȴ�.)
		// �� ������ �ϴ� ������  node�� ���� �ڳ���� �ٲ��ָ鼭 ������ �浹�� �����ϱ� �����̴�.
		// �� ������ ���� ȸ������ ���� �ڳ��忡 ���� ������ ������.
		if(node.getLeftChild().getRightChild() != null)
			tmpNode = node.getLeftChild().getRightChild();
		node.setLeftChild(node.getLeftChild().getLeftChild());
		
		// node�� ������ �ڳ��尡 ������� �ʴٸ� tmpNode2�� �� ��带 �����ϰ� node�� ������ �ڳ��带 tmp ��, node�� ����value���� ���� ���ο� ���� �����Ѵ�.
		// �̋� ���� ����� ���� ���� �ڳ���� tmpNode�� ������ �ڳ���� tmpNode2�� ���´�.
		if(node.getRightChild() != null) {
			tmpNode2 = node.getRightChild();
			node.setRightChild(new Node(tmp, tmpNode, tmpNode2));
		}
		// ���� ������ �ڳ��尡 ����ִٸ� tmpNode2�� �����ϰ� ���� ������ �����Ѵ�.
		else {
			node.setRightChild(new Node(tmp, tmpNode, null));
		}
	}
	
	
	/** 
	 * leftRotation �޼���
	 * @param node param��带 �������� �������� ȸ���Ѵ�.
	 */
	public void leftRotation(Node node) {
		int tmp = node.getValue(); // ���� ����� ���� ����
		// �� tmpNode�� ������ ȸ���ϴµ��� ��� �� ����
		Node tmpNode = null; 
		Node tmpNode2 = null;
		
		// ���� node�� value���� ������ �ڳ����� value������ �ٲ۴�.
		node.setValue(node.getRightChild().getValue());
		
		// ������ �ڳ����� �����ڳ��尡 �����Ѵٸ��� �� ��带 tmpNode�� �����ϰ� node�� ������ �ڳ��带 ������ �ڳ����� ������ �ڳ���� ��ü�Ѵ�. (�� �������� ���̰� 1������ ������ �ڳ������ �����ȴ�.)
		// �� ������ �ϴ� ������  node�� ������ �ڳ���� �ٲ��ָ鼭 ������ �浹�� �����ϱ� �����̴�.
		// �� ������ ���� ȸ������ ������ �ڳ��忡 ���� ������ ������.
		if(node.getRightChild().getLeftChild() != null)
			tmpNode = node.getRightChild().getLeftChild();
		node.setRightChild(node.getRightChild().getRightChild());
		
		// node�� ���� �ڳ��尡 ������� �ʴٸ� tmpNode2�� �� ��带 �����ϰ� node�� ���� �ڳ��带 tmp ��, node�� ����value���� ���� ���ο� ���� �����Ѵ�.
		// �̋� ���� ����� ���� ������ �ڳ���� tmpNode�� ���� �ڳ���� tmpNode2�� ���´�.
		if(node.getLeftChild() != null) {
			tmpNode2 = node.getLeftChild();
			node.setLeftChild(new Node(tmp, tmpNode2, tmpNode));
		}
		// ���� ���� �ڳ��尡 ����ִٸ� tmpNode2�� �����ϰ� ���� ������ �����Ѵ�.
		else {
			node.setLeftChild(new Node(tmp, null, tmpNode));
		}
	}
}
