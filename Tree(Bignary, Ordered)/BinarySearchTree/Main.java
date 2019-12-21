package BinarySearchTree;

/** Main 클래스
 * 
 * 과제에서 요구하는 사항에 대한 테스트 내용이 작성되어 있는 클래스입니다.
 * 삽입테스트
 * 50, 22, 77, 18, 44, 30, 27, 33, 70, 88, 74, 60, 66, 63, 69, 80, 94 순서대로 삽입하면서 그때마다 트리를 출력한다.
 * 
 * 삭제 테스트
 * 50, 44, 69를 삭제할때마다 트리 출력
 * 트리 모습은 직접 그려서 설명하도록 하겠다.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree(); // 이진 탐색 트리 객체 생성
		
		/////////////////////////삽입 테스트/////////////////////////////
		System.out.println("삽입 테스트");
		
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
		
		/////////////////////////삭제 테스트/////////////////////////////
		System.out.println("\n삭제 테스트");
		
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
