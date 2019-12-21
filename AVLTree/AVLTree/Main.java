package AVLTree;

/**
 * Main 
 * main�������� LL, RR, LR, RL�� ���� ������ ����� �����Ǵ��� Ȯ���� ���̴�.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		// �� ������ ���� AVLTree����
		AVLTree AVLLL = new AVLTree();
		AVLTree AVLRR = new AVLTree();
		AVLTree AVLLR = new AVLTree();
		AVLTree AVLRL = new AVLTree();
		
		// LL�׽���
		System.out.println("LL �׽���");
		AVLLL.insert(AVLLL.getRoot(), 13);
		AVLLL.insert(AVLLL.getRoot(), 10);
		AVLLL.insert(AVLLL.getRoot(), 15);
		AVLLL.insert(AVLLL.getRoot(), 5);
		AVLLL.insert(AVLLL.getRoot(), 16);
		AVLLL.insert(AVLLL.getRoot(), 11);
		AVLLL.insert(AVLLL.getRoot(), 4);
		AVLLL.insert(AVLLL.getRoot(), 8);
		AVLLL.insert(AVLLL.getRoot(), 3);
		
		AVLLL.preOrderPrint(AVLLL.getRoot());
		
		// RR�׽���
		System.out.println("\n\nRR �׽���");
		AVLRR.insert(AVLRR.getRoot(), 30);
		AVLRR.insert(AVLRR.getRoot(), 5);
		AVLRR.insert(AVLRR.getRoot(), 35);
		AVLRR.insert(AVLRR.getRoot(), 32);
		AVLRR.insert(AVLRR.getRoot(), 40);
		AVLRR.insert(AVLRR.getRoot(), 45);
		
		AVLRR.preOrderPrint(AVLRR.getRoot());
		
		// LR�׽���
		System.out.println("\n\nLR �׽���");
		AVLLR.insert(AVLLR.getRoot(), 13);
		AVLLR.insert(AVLLR.getRoot(), 10);
		AVLLR.insert(AVLLR.getRoot(), 15);
		AVLLR.insert(AVLLR.getRoot(), 5);
		AVLLR.insert(AVLLR.getRoot(), 11);
		AVLLR.insert(AVLLR.getRoot(), 16);
		AVLLR.insert(AVLLR.getRoot(), 4);
		AVLLR.insert(AVLLR.getRoot(), 6);
		AVLLR.insert(AVLLR.getRoot(), 7);
		
		AVLLR.preOrderPrint(AVLLR.getRoot());
		
		// RL�׽���
		System.out.println("\n\nRL �׽���");
		AVLRL.insert(AVLRL.getRoot(), 5);
		AVLRL.insert(AVLRL.getRoot(), 2);
		AVLRL.insert(AVLRL.getRoot(), 7);
		AVLRL.insert(AVLRL.getRoot(), 1);
		AVLRL.insert(AVLRL.getRoot(), 4);
		AVLRL.insert(AVLRL.getRoot(), 6);
		AVLRL.insert(AVLRL.getRoot(), 9);
		AVLRL.insert(AVLRL.getRoot(), 3);
		AVLRL.insert(AVLRL.getRoot(), 16);
		AVLRL.insert(AVLRL.getRoot(), 15);
		
		AVLRL.preOrderPrint(AVLRL.getRoot());
	}
}
