package OrderedTree;

import java.util.LinkedList;
import java.util.List;

/** ���� Ŭ����
 * 
 * ���� �Լ��� Tree�� ���Ƿ� �����ϰ� �� Ž������ �ùٸ��� �۵��ϴ��� Ȯ���Ѵ�.
 * @author NoA
 *
 */
public class Main {
	public static void main(String[] args) {
		OrderedTree treeA, treeB, treeD; // treeA�� ���� tree�� root, B�� D�� treeA�� �ڳ��� �� �ϳ��̴�.
		
		// treeC�� treeE, treeF, treeG�� �ٳ���̴�.
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeE = new OrderedTree("E");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeG = new OrderedTree("G");
		
		// treeB�� ���� �����̴�.
		List subtreesOfB = new LinkedList(); // subtreesOfB�� ���B�� ����Ʈ��
		// treeB�� E�� F�� �ڳ���� ���´�.
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);;
		treeB = new OrderedTree("B", subtreesOfB);
		
		// treeD�� ���� �����̴�.
		List subtreesOfD = new LinkedList(); // subtreesOfD�� ��� D�� ����Ʈ��
		// treeD�� G�� �ڳ���� ���´�.
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);
		
		//treeA�� ���� �����̴�.
		List subtreesOfA = new LinkedList(); // subtreesOfA�� ��� A�� ����Ʈ��
		// treeA�� B��C��D�� �ڳ���� ���´�.
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);
		
		// �� Ž������ �����Ѵ�.
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
