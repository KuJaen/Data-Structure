package ArraySet;

import java.util.Random;

//메인 함수
public class Main {
	public static void main(String[] args) {
		ArraySet arraySet = new ArraySet(); //arraySet의 객체 생성
		int[] searchNumberArray = {94, 359, 553, 731, 972}; //searchNumberArray는 내가 탐색하려는 수들의 배열이다. 
		
		Random random = new Random(); // random 객체 생성
		
		//random객체를 사용하여 0부터 1000까지 랜덤으로 수를 뽑아 arraySet에 추가한다.
		for(int i = 0; i < 10000; i++) {
			int randomInt = random.nextInt(1000);
			arraySet.add(randomInt);
		}
		
		//시간을 나타내는 변수 startTime과 endTime이다. 0으로 초기화 해준다.
		long startTime = 0;
		long endTime = 0;
		
		//Sequential Search
		System.out.println("* Sequential Search ---------------------------------");
		
		//searchNumberArray의 인자들을 하나씩 탐색한다.
		for(int i = 0; i < 5; i++) {
			System.out.print("The time for finding " + searchNumberArray[i] + " = ");
			startTime = System.nanoTime(); //탐색 시작
			arraySet.contains(searchNumberArray[i], true); //매개변수가 true일때는 Sequential Search로 탐색
			endTime = System.nanoTime(); //탐색 끝
			System.out.println(endTime - startTime); //탐색 시간 출력
		}
		
		System.out.println("-----------------------------------------------------");
		//Binary Search
		System.out.println("* Binary Search -------------------------------------");
		for(int i = 0; i < 5; i++) {
			System.out.print("The time for finding " + searchNumberArray[i] + " = ");
			startTime = System.nanoTime(); //탐색 시작
			arraySet.contains(searchNumberArray[i], false); //매개변수가 false일때는 Binary Search로 탐색
			endTime = System.nanoTime(); //탐색 끝
			System.out.println(endTime - startTime); //탐색 시간 출력
		}
		System.out.println("-----------------------------------------------------");
	}
}
