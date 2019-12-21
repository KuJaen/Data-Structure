package ListMap;

import java.io.*;
import java.util.StringTokenizer;

/** 
 * �����Լ�
 * �ؽ�Ʈ ������ �޾ƿ� �д´�. �ؽ�Ʈ ���Ͽ� �ִ� �ܾ�(����)���� ListMap�� �����Ѵ�. 
 * ListMap�� put�� ���� ó�� put�Ǵ� ���� value�� 1�� �����Ƿ� �Ű����� value������ 1�� �־��ش�.
 * ��� ���� ListMap�� ������ �Ŀ��� ListMap�� Size�� ��ȯ�ϰ� ���α׷��� ��ģ��.
 * @author Ku
 */
public class Main {
	public static void main(String[] args) {
		long start;
		long end;
		ListMap ListMap = new ListMap();
		String filePath = "Sample-text-file-500kb.txt";
		try {
			start = System.nanoTime();
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String line = in.readLine();
			
			while(line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;=.?!");
				
				while(parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					ListMap.put(word, 1);
				}
				line = in.readLine();
			}
			in.close();
			end = System.nanoTime();
			ListMap.printList();
			System.out.println("ListMap Size : " + ListMap.size());
			System.out.println("�ɸ� �ð� : " + (end - start));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
