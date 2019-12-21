package OrderedTree;

import java.util.LinkedList;
import java.util.List;

/** 메인 클래스
 * 
 * 메인 함수는 Tree를 임의로 생성하고 각 탐색법이 올바르게 작동하는지 확인한다.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		OrderedTree treeA, treeB, treeD; // treeA는 최종 tree의 root, B와 D는 treeA의 자녀노드 중 하나이다.
		
		// treeC와 treeE, treeF, treeG는 잎노드이다.
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeE = new OrderedTree("E");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeG = new OrderedTree("G");
		
		// treeB에 대한 설계이다.
		List subtreesOfB = new LinkedList(); // subtreesOfB는 노드B의 서브트리
		// treeB는 E와 F를 자녀노드로 갖는다.
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);;
		treeB = new OrderedTree("B", subtreesOfB);
		
		// treeD에 대한 설계이다.
		List subtreesOfD = new LinkedList(); // subtreesOfD는 노드 D의 서브트리
		// treeD는 G를 자녀노드로 갖는다.
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);
		
		//treeA에 대한 설계이다.
		List subtreesOfA = new LinkedList(); // subtreesOfA는 노드 A의 서브트리
		// treeA는 B와C와D를 자녀노드로 갖는다.
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);
		
		// 각 탐색법을 실행한다.
		System.out.print("Level Order Print : ");
		treeA.printTreeByLevelOrder();
		System.out.println();
		System.out.print("Pre Order Print : ");
		treeA.printTreeByPreOrder();
		System.out.println();
		System.out.print("Post Order Print : ");
		treeA.printTreeByPostOrder();
	}
}
