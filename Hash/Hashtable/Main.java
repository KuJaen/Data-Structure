package Hashtable;

/** 메인 클래스
 * BasicHashtable을 사용한 단순 작업 (예시)
 * @author NoA
 */
public class Main {
	public static void main(String[] args) {
		Hashtable libraryHashTable = new Hashtable(15);
		
		// put 메서드를 테스트한다.
		System.out.println("* Put Test --------------------------------------------------\n");
		libraryHashTable.put("김소월", "진달래꽃"); // key: 김소월     value: 진달래꽃
		libraryHashTable.put("현진건", "운수 좋은 날"); // key: 현진건     value: 운수 좋은 날
		libraryHashTable.put("김유정", "동백꽃"); // // key: 김유정     value: 동백꽃
		libraryHashTable.put("최인훈", "광장"); // // key: 최인훈     value: 광장
		libraryHashTable.put("이육사", "청포도"); // // key: 이육사     value: 청포도
		libraryHashTable.put("박목월", "보랏빛 소모"); // // key: 박목월     value: 보랏빛 소묘
		libraryHashTable.put("정지용", "향수"); // // key: 정지용     value: 향수
		libraryHashTable.printEntries(); // hashtable 출력
		
		// remove 메서드 테스트
		System.out.println("\n* Remove Test ----------------------------------------------");
		System.out.println("최인훈 삭제\n");
		libraryHashTable.remove("최인훈");
		libraryHashTable.printEntries();
		
		System.out.println("\n김소월 삭제\n");
		libraryHashTable.remove("김소월");
		libraryHashTable.printEntries();
		
		//get메서드 테스트
		System.out.println("\n* Get Test -------------------------------------------------");
		System.out.println("김유정 Value = " + libraryHashTable.get("김유정"));
		
		// 해쉬테이블의 Collision현상 체크
		System.out.println("\n* Collision Test -------------------------------------------\n");
		libraryHashTable.put("윤동주", "별 헤는 밤");
		libraryHashTable.put("이육사", "광야");
		libraryHashTable.printEntries();
	}
}
