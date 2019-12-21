package Map;

import java.io.*;
import java.util.StringTokenizer;

/** 
 * �����Լ�
 * �ؽ�Ʈ ������ �޾ƿ� �д´�. �ؽ�Ʈ ���Ͽ� �ִ� �ܾ�(����)���� arrayMap�� �����Ѵ�. 
 * arrayMap�� put�� ���� ó�� put�Ǵ� Entry�� ��� value������ 1�� �����Ƿ� �Ű����� value������ 1�� �־��ش�.
 * ��� ���� arrayMap�� ������ �Ŀ��� ArrayMap�� Size�� �ɸ��ð��� ��ȯ�ϰ� ���α׷��� ��ģ��.
 * @author Ku
 */
public class Main {
	public static void main(String[] args) {
		long start;
		long end;
		ArrayMap arrayMap = new ArrayMap();
		String filePath = "Sample-text-file-500kb.txt"; 
		try {
			start = System.nanoTime();
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String line = in.readLine();
			
			while(line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;=.?!");
				
				while(parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					arrayMap.put(word, 1);
				}
				line = in.readLine();
			}
			in.close();
			end = System.nanoTime();
			arrayMap.printArray();
			System.out.println("ArrayMap Size : " + arrayMap.size());
			System.out.println("�ɸ��ð� : " + (end - start));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
