package AVLTree;
/**
 * Node Ŭ������ AVLTree�� ����� �����̴�.
 * @author NoA
 *
 */
public class Node {
	private int value; // ����� ��
	private Node leftChild; // ����� ���� �ڳ���
	private Node rightChild; // �����  ������ �ڳ���
	private int height; // ����� ����
	private int balance; // ����� balance
	
	/** ��� ������
	 * 
	 * @param _v value���� �Է¹޾� �����Ѵ�.
	 * @param lc ���� �ڳ��带 �Է¹޾� �����Ѵ�.
	 * @param rc ������ �ڳ��带 �Է¹޾� �����Ѵ�.
	 */
	public Node(int _v, Node lc, Node rc) {
		this.value = _v;
		this.leftChild = lc;
		this.rightChild = rc;
		this.height = 1; // ����� ó�� ���̴� 1�̴�. �ڳ��尡 �߰��Ǹ鼭 �̴� ���ŵ� ���̴�.
		this.balance = 0; // ó������ �ڳ��尡 ���⋚���� balance�� 0�̴�.
	}
	
	/**
	 * getValue �޼���
	 * @return ����� value���� ��ȯ�Ѵ�.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * getLeftChild �޼���
	 * @return ����� ���� �ڳ��带 ��ȯ�Ѵ�.
	 */
	public Node getLeftChild() {
		return this.leftChild;
	}
	
	/** 
	 * getRightChild �޼���
	 * @return ����� ������ �ڳ��带 ��ȯ�Ѵ�.
	 */
	public Node getRightChild() {
		return this.rightChild;
	}
	
	/**
	 * getHeight �޼���
	 * @return ����� ���̸� ��ȯ�Ѵ�.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * setLeftChild �޼���
	 * @param lc ����� ���� �ڳฦ param������ �����Ѵ�.
	 */
	public void setLeftChild(Node lc) {
		this.leftChild = lc;
	}
	
	/**
	 * setRightChild �޼���
	 * @param rc ����� ������ �ڳฦ param������ �����Ѵ�.
	 */
	public void setRightChild(Node rc) {
		this.rightChild = rc;
	}
	
	/**
	 * setHeight �޼���
	 * @param height ���̸� param������ �����Ѵ�.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/** 
	 * getBalance �޼���
	 * @return ����� balance�� ��ȯ�Ѵ�.
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * setBalance �޼���
	 * ����� �� �ڳ��带 ���� balance���� �����Ѵ�.
	 */
	public void setBalance() {
		int lch; // ���� �ڳ����� ���̸� ������ ����
		int rch; // ������ �ڳ����� ���̸� ������ ����
		// NullPoint ������ �����ϱ� ���� try-catch���� ���
		// lch�� rch�� ���� �޾ƿ� (catch�� �ش� �ڳ��尡 ������ �ǹ��ϹǷ� 0����)
		try {lch = leftChild.getHeight();}
		catch(Exception e){lch = 0;}
		try {rch = rightChild.getHeight();}
		catch(Exception e) {rch = 0;}
		balance = rch - lch; // node�� ������ �� ����
	}
	
	/**
	 * setValue �޼���
	 * @param value value���� param������ ����
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
