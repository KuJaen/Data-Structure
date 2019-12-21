package Map;

import java.io.*;
import java.util.StringTokenizer;

/** 
 * 메인함수
 * 텍스트 파일을 받아와 읽는다. 텍스트 파일에 있는 단어(문자)마다 arrayMap에 저장한다. 
 * arrayMap에 put할 때는 처음 put되는 Entry의 경우 value값으로 1을 가지므로 매개변수 value값으로 1을 넣어준다.
 * 모든 값을 arrayMap에 저장한 후에는 ArrayMap의 Size와 걸린시간을 반환하고 프로그램을 마친다.
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
			System.out.println("걸린시간 : " + (end - start));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
