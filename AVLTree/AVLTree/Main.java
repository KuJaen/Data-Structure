package AVLTree;

/**
 * Main 
 * main문에서는 LL, RR, LR, RL에 대한 구조가 제대로 정리되는지 확인할 것이다.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		// 각 구조에 대한 AVLTree생성
		AVLTree AVLLL = new AVLTree();
		AVLTree AVLRR = new AVLTree();
		AVLTree AVLLR = new AVLTree();
		AVLTree AVLRL = new AVLTree();
		
		// LL테스팅
		System.out.println("LL 테스팅");
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
		
		// RR테스팅
		System.out.println("\n\nRR 테스팅");
		AVLRR.insert(AVLRR.getRoot(), 30);
		AVLRR.insert(AVLRR.getRoot(), 5);
		AVLRR.insert(AVLRR.getRoot(), 35);
		AVLRR.insert(AVLRR.getRoot(), 32);
		AVLRR.insert(AVLRR.getRoot(), 40);
		AVLRR.insert(AVLRR.getRoot(), 45);
		
		AVLRR.preOrderPrint(AVLRR.getRoot());
		
		// LR테스팅
		System.out.println("\n\nLR 테스팅");
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
		
		// RL테스팅
		System.out.println("\n\nRL 테스팅");
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
