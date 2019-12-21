package BinarySearchTree;

/** Main Ŭ����
 * 
 * �������� �䱸�ϴ� ���׿� ���� �׽�Ʈ ������ �ۼ��Ǿ� �ִ� Ŭ�����Դϴ�.
 * �����׽�Ʈ
 * 50, 22, 77, 18, 44, 30, 27, 33, 70, 88, 74, 60, 66, 63, 69, 80, 94 ������� �����ϸ鼭 �׶����� Ʈ���� ����Ѵ�.
 * 
 * ���� �׽�Ʈ
 * 50, 44, 69�� �����Ҷ����� Ʈ�� ���
 * Ʈ�� ����� ���� �׷��� �����ϵ��� �ϰڴ�.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree(); // ���� Ž�� Ʈ�� ��ü ����
		
		/////////////////////////���� �׽�Ʈ/////////////////////////////
		System.out.println("���� �׽�Ʈ");
		
		BST.insert(50);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(22);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(77);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(18);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(44);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(30);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(27);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(33);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(70);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(88);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(74);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(60);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(66);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(63);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(69);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(80);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.insert(94);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		/////////////////////////���� �׽�Ʈ/////////////////////////////
		System.out.println("\n���� �׽�Ʈ");
		
		BST.deleteNode(BST.getRoot(), 50);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.deleteNode(BST.getRoot(), 44);
		BST.printTree(BST.getRoot());
		System.out.println();
		
		BST.deleteNode(BST.getRoot(), 69);
		BST.printTree(BST.getRoot());
		System.out.println();
	}
}
