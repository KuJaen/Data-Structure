package graph;


import java.io.*; 
import java.util.*; 
  
/**
 * DFS�� GraphŬ����
 * BFS�� �׷����� �����ϴ� ����� ������ �߰��ϴ� ����� �����ϹǷ� �̿����� ������ �����ϰ� �ʿ��� �κи� �����ϰڴ�
 * @author KNoA
 *
 */
class DFSGraph 
{ 
	String print = "";
    private int V;
    private LinkedList<Object> adj[];
    
    /**
     * DFSGraph Ŭ����
     * @param v �׷����� ũ��
     * @param list ������ ����Ʈ
     */
    DFSGraph(int v, String[] list) 
    { 
    	V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) { 
            adj[i] = new LinkedList();
            adj[i].add(list[i]);
        }
    } 
    
    /**
     * addEdge Ŭ����. ������ �����ϴ� Ŭ����
     * @param v ������ �� ��� �� ù��° ���
     * @param w ������ �� ��� �� �ι�° ���
     */
    void addEdge(String v, String w) 
    { 
    	for(int i=0; i<V; ++i) {
    		if(((String)adj[i].element()).equals(v)) {
    			if(!(adj[i].contains(w)))
    				adj[i].add(w);
    		}
    	}
    	for(int i=0; i<V; ++i) {
    		if(((String)adj[i].element()).equals(w)) {
    			if(!(adj[i].contains(v)))
    				adj[i].add(v);
    		}
    	} 
    } 
  
    /**
     * DFSUtil Ŭ����
     * ���� �켱 Ž�������� ����ִ� Ŭ����
     * @param s Ž������ ���
     * @param visited visited���� BFS�� ������ �ǹ̸� ���� �ִ�.
     */
    void DFSUtil(String s,boolean visited[]) 
    {  
    	// ��� s�� ��ġ�� Ž���Ͽ� tmp�� �����Ѵ�.
    	int tmp = 0;
		for(int t=0; t<V; t++) {
			if(((String)adj[t].element()).equals(s)) {
				tmp = t;
			}
		}
		// ���� ��� s�� Ž���� �̷���� ��尡 �ƴ϶�� print�� �߰��ϰ� visited���� true�� �ٲ۴�.
		if(!visited[tmp]) {
			visited[tmp] = true; 
	        print = print + s + " "; 
		}
		// ��� s�� ����Ǿ� �ִ� �ٸ� ���� ���� Ž���Ѵ�.
        Iterator<Object> i = adj[tmp].listIterator(); 
        // temp�� BFS�ʹ� �ݴ�� ���� �ʺ� ������ ������������ Ž���ϱ� ���� ���ȴ�.
        LinkedList<Object> temp = new LinkedList<Object>();
        while (i.hasNext()) 
        { 
        	// �Ʒ��δ� temp�� ������������ Ž���� ������ �����ϴ� �������� BFS�� �����ϴ�.
        	// �ٸ� �κ��� �ִٸ� temp�� �ִ� ������ � ������ Ž���ϵ��� �ϴ����̴�.
        	// ���� ������ temp�� ������ ������������ �����ϴ� ���� ����, Ž�� �������� �ٽ� �̾���� �ϰڴ�.
            s = (String) i.next(); 
            
            for(int k=0; k<V; k++) {
    			if(((String)adj[k].element()).equals(s)) {
    				tmp = k;
    			}
    		}
            if (!visited[tmp]) {
            	Iterator<Object> iterator = temp.listIterator();
                int t = 0;
                while(iterator.hasNext()) {
                	String ch = (String) iterator.next();
                	
                	if(ch.length() < s.length()) {
                		String str = "";
                		for(int flg=0; flg<ch.length(); flg++) {
                			str = str + ch.charAt(flg);
                			if(ch.charAt(flg) < s.charAt(flg)){
                				t++;
                				break;
                			}
                			else if(str.equals(ch)) {
                				t++;
                				break;
                			}
                		}
                	}
                	else if(ch.length() == s.length()) {
                		for(int flg=0; flg<ch.length(); flg++) {
                			if(ch.charAt(flg) < s.charAt(flg)){
                				t++;
                				break;
                			}
                		}
                	}
                	else {
                		String str = "";
                		for(int flg=0; flg<s.length(); flg++) {
                			if(ch.charAt(flg) < s.charAt(flg)){
                				t++;
                				break;
                			}
                		}
                	}
                }
                temp.add(t, s);
            }
        }
        /* temp�� ����� ������ ������� Ž���Ǵµ� BFS�ʹ� �ٸ���.
         * BFS�� temp�� ����Ǿ� �̴� ��� ��带 queue�� �����Ͽ� Ž���� �����ߴ�.
         * �� �������� ���� ���̿� �ִ� ��, �ʺ�켱 Ž���� �����ϵ��� �� ���̴�.
         * ������ DFS�� �̿ʹ� �ٸ��� ������������ �켱���� ��带 ���� Ž���ϵ�
         * �� �������� Ž������ ����� ���̰� ��� Ž���Ǳ� ������ Ž���� �̷������ �ʴ´�.
         * �� ���� �켱 Ž���� �̷������ ���̴�.
         */
        Iterator<Object> iterator = temp.listIterator();
        // �ݺ��� ������ ��͹����� ���Ͽ� ��� ���̰� Ž���Ǳ� ������ �� �ݺ����� �ݺ��� �̷������ �ʴ´�.
        // �� ���� �켱 Ž���� �̷������ ���̴�.
        while(iterator.hasNext()) {
        	
        	String sc = (String)iterator.next();
            DFSUtil(sc, visited);
        }
    } 
    
    /**
     * DFSUtil�� ����Ǵ� DFSŬ�����̴�.
     * @param s Ž���� �߽��� �� ��带 ��Ÿ����.
     */
    void DFS(String s) 
    { 
        boolean visited[] = new boolean[V]; 

        DFSUtil(s, visited); // DFS����
        System.out.println(print.trim()); // ��� ���
    } 
}
    
public class DFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		String[] num = n.split(" ");
		
		
		n = sc.nextLine();
		String[] nodeName = n.split(" ");
		
		DFSGraph g = new DFSGraph(Integer.parseInt(num[0]), nodeName); 

		String[] tmp;
		for(int j=0;j<Integer.parseInt(num[1]);j++) {
			String s = sc.nextLine();
			tmp = s.split(" ");
			
			g.addEdge(tmp[0], tmp[1]);
		}
		
		n = sc.next();
		
		g.DFS(n);
	}
}
