package graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author KNoA
 *
 *�׷��� Ŭ����
 */
class Graph 
{ 
	String print = ""; // ���������� ����� ���� ��, BFS Ž�� ����� ������ �ʵ��̴�.
    private int V; // V�� �׷����� ����� ���� �ǹ��Ѵ�.
    private LinkedList<Object> adj[]; // �� ������ ����� ��ũ�� ����Ʈ
  
   /**
    * Graph ������
    * @param v �� ����� ������ param������ ����
    * @param list ��� ����Ʈ�� �Է¹޴´�. �� ����Ʈ �ȿ��� �� ������ ����ִ�.
    */
    Graph(int v, String list[]) 
    { 
        V = v; // �׷����� ũ������
        adj = new LinkedList[v]; // adj ��ü ����
        
        /* adj�� �� ���ڴ� �ٽ� ��ũ�帮��Ʈ�� �����Ѵ�. ��, 2���� �迭�� �����ϸ� �ȴ�.
         * �� ���� ����Ʈ �ȿ��� ù��°�� �� ��尡, �� �ڷδ� �ش� ���� ����Ǿ��ִ� �ٸ� ������ ����ȴ�.
         */
        for (int i=0; i<v; ++i) { 
            adj[i] = new LinkedList(); // �� ���ڿ� ��ũ�� ����Ʈ ����
            adj[i].add(list[i]); // �� ��带 ������ ����Ʈ�� ù��° ���ڷ� �����Ѵ�.
        }
    } 
  
    /**
     * ��忡 ������ �����ϴ� �޼���
     * @param v ������ �� ����� ù���� ���
     * @param w ������ �� ����� �ι�° ���
     */
    void addEdge(String v,String w) 
    {
    	/*
    	 * for���� v��带 Ž���ϱ� ���� ���Ǿ���.
    	 * Ž�� ��� ã�Ƴ� v����� ����Ʈ�� v����� ���� ���ڷ� w�� �߰��Ѵ�.
    	 * �̋� �̹� w�� ���ڷ� ���ԵǾ� �ִٸ� w�� �߰����� �ʴ´�.
    	 */
    	for(int i=0; i<V; ++i) {
    		if(((String)adj[i].element()).equals(v)) {
    			if(!(adj[i].contains(w)))
    				adj[i].add(w);
    		}
    	}
    	// �� ������ w��带 ���ؿ����� �ݺ��Ѵ�. ��, �� ��带 �ֹ����� ��������ش�.
    	for(int i=0; i<V; ++i) {
    		if(((String)adj[i].element()).equals(w)) {
    			if(!(adj[i].contains(v)))
    				adj[i].add(v);
    		}
    	} 
    } 
    
    
    /**
     * BFS �޼���
     * �ʺ� �켱���� Ž���ϵ� ���� ���̿� �ִ� ������ ������������ Ž���Ѵ�.
     * @param s Ž���� �߽��� �� ���
     */
	void BFS(String s) 
	{ 	
		// ���s�� ��ġ�� Ž���Ѵ�. ��� ��ġ�� k�� ����ȴ�.
		int k = 0;
		for(int i=0; i<V; ++i) {
    		if(((String)adj[i].element()).equals(s)) {
    			k = i;
    			break;
    		}
    	} 
		
		// BFS���� �̹� Ž���� �Ϸ�� ���� visited���� true�� �ȴ�.
		// true�� �� ���� �ٽ� Ž��, ����� �̷������ �ʴ´�.
		boolean visited[] = new boolean[V]; 
		
		/* Ž�� �� ������ ��µǱ� �� queue�� ���� ����ȴ�. queue���� ��� ���� ��, Ž�� ������� ����ȴ�.
		 * ���� ��� A�� ������ B�� C�� �ִٸ� ���� ������ A - B - C - B�� ������ - ... - C�� ������... �� ���̴�.
		 */
		LinkedList<Object> queue = new LinkedList<Object>(); 

        visited[k]=true; // ��� s�� �湮�����Ƿ� visited���� true�� �ٲ��ش�.
        queue.add(s);  // ��� s�� queue�� �߰��Ѵ�.
        // temp�� ���� ���̿� �ִ� ������ ������������ queue�� ����ϱ� ���Ͽ� ���ȴ�.
        // ���� ���̿� �ִ� ��� ������ temp�� ������������ ���� �� �� queue�� �߰��ȴ�.
        LinkedList<Object> temp = new LinkedList<Object>();
        
        // queue�� size�� 0�� �� ������ ��, ��� ������ ��µ� �� ���� �ݺ��Ѵ�.
		while (queue.size() != 0) 
		{ 
			s = (String) queue.poll(); // queue�� ����� ������ ���ʷ� ������ Ž���Ѵ�.
			print = print + s + " "; // Ž���� ���� print�� ����Ǿ� �Ѳ����� ��µȴ�.
			
			// ��� s�� ����Ǿ� �ִ� ��ġ�� Ž���Ͽ� tmp�� �����Ѵ�.
			int tmp = 0;
			for(int t=0; t<V; t++) {
				if(((String)adj[t].element()).equals(s)) {
					tmp = t;
				}
			}
			
			// ��� s�� �Բ� ���� ����Ǿ� �ִ� �������� ���ͷ����͸� ���� Ž���Ǿ� ������������  temp�� ����� ���̴�.
			Iterator<Object> i = adj[k].listIterator(); 
            while (i.hasNext()) 
            { 
                String c = (String) i.next(); // ��� s�� �Բ� ����Ǿ� �ִ� �������� �ϳ��� Ž���Ǿ� c�� ����ȴ�.
                // temp�� ����Ǳ� ���� c�� �̹� Ž�� �Ǿ������� Ȯ���ؾ� �Ѵ�. ��, visited���� Ȯ���ؾ� �Ѵ�.
                // �̸� ���Ͽ� ��� c�� ��ġ�� ���� Ž���Ѵ�. c�� ��ġ�� n�� ����ȴ�.
                int n = 0;
                for(int j=0; j<V;j++) {
                	if(((String)adj[j].element()).equals(c)) {
                		n=j;
                		break;
                	}
                }
                // ��� c�� ���� Ž������ ���� ����� ����ؼ� �����Ѵ�.
                if (!visited[n]) 
                { 
                	// ��� c�� �̹��� Ž��, �湮�Ͽ��� ������ visited���� true�� �ٲ۴�.
                    visited[n] = true; 
                    
                    // ��� c�� �Ʒ� temp���ͷ����Ϳ� �ݸ��� ���Ͽ� ������������ temp�� ����� ���̴�.
                    int t=0; // t�� ��� c�� ����� ��ġ ��, ������������ ������ ��ġ�� �ǹ��Ѵ�.
                    Iterator<Object> iterator = temp.listIterator();
                    
                    while(iterator.hasNext()) {
                    	// ch�� temp�� �� ���ҵ�� c�� ������������ �񱳰� �̷���� ���̴�.
                    	String ch = (String) iterator.next();
                    	
                    	// ������������ ���� �� �� ù���ڰ� ���� ������ ���� ª�� ���ڰ� �켱���̴�.
                    	// ���� ���̰� ������, ch�� �涧, c�� �涧�� �η��Ͽ� ������ ������ �����Ѵ�.
                    	if(ch.length() < c.length()) {
                    		/* str�� ���̰� ª�� ����� �� ���ڸ� ���ʷ� �����Ѵ�.
                    		 *  str�� �� ���� �������ٸ� �̴� ���̰� �� ���� ���̰� ª�� ��带 ��� �����ϰ� �ִٴ� ���� �ǹ��Ѵ�.
                    		 *  ���� ���̰� ª�� ��尡 ������ �;��ϴ� ���̴�. ���� ���������� t�� ���� �߰��� �� ���̴�.
                    		 */
                    		String str = ""; 
                    		for(int flg=0; flg<ch.length(); flg++) {
                    			str = str + ch.charAt(flg);
                    			// ���� �߰��Ϸ��� ��尡 �̹� temp�� ����Ǿ� �ִ� ��庸�� ���������� �ڿ� �ִٸ�
                    			// t�� ���� �÷� ��ġ�� ���� �� �ش�.
                    			if(ch.charAt(flg) < c.charAt(flg)){
                    				t++;
                    				break;
                    			}
                    			// str���� ch�� �������ٸ� c�� ch�� ��� ���������� �� �� ���ڶ�� ���� �ǹ��ϱ⿡ t�� ���� �÷��ش�.
                    			else if(str.equals(ch)) {
                    				t++;
                    				break;
                    			}
                    		}
                    	}
                    	// ch�� c�� ���̰� ���� ���� str�� ����� �ʿ䰡 ����. �� ���� ������ �����ϴ�.
                    	else if(ch.length() == c.length()) {
                    		for(int flg=0; flg<ch.length(); flg++) {
                    			if(ch.charAt(flg) < c.charAt(flg)){
                    				t++;
                    				break;
                    			}
                    		}
                    	}
                    	// c�� ���̰� ch���� ª���� ch�� c�� ��� ������ �� ���������� �翬�� ������ �;� �ϹǷ�
                    	// �̷������� t�� ���� �÷��� �ʿ�� ����. �� str�� ����� �񱳸� �����Ѵ�.
                    	else {
                    		for(int flg=0; flg<c.length(); flg++) {
                    			if(ch.charAt(flg) < c.charAt(flg)){
                    				t++;
                    				break;
                    			}
                    		}
                    	}
                    }
                    temp.add(t, c); // t��ġ�� c�� �����Ѵ�.
                }
            }
            // temp�� size�� 0�� �� �� ���� ��, temp�� ��� ���Ҹ�  queue�� �����ϸ� ������ �ش�.
            while(temp.size()!=0) {
            	queue.add(temp.removeFirst());
            }
		}
		System.out.println(print.trim()); // ��� ���
	}
} 


public class BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		String[] num = n.split(" ");
		
		
		n = sc.nextLine();
		String[] nodeName = n.split(" ");
		
		Graph g = new Graph(Integer.parseInt(num[0]), nodeName); 

		String[] tmp;
		for(int j=0;j<Integer.parseInt(num[1]);j++) {
			String s = sc.nextLine();
			tmp = s.split(" ");
			
			g.addEdge(tmp[0], tmp[1]);
		}
		
		n = sc.next();
		
		g.BFS(n);
	}
}
