package Hashtable;

/** 메인 클래스
 * BasicHashtable을 사용한 단순 작업 (예시)
 * @author NoA
 */
public class Main {
	public static void main(String[] args) {
		Hashtable libraryHashTable = new Hashtable(15);
		
		// put 메서드를 테스트
		System.out.println("* Put Test --------------------------------------------------\n");
		System.out.println("\"김소월\" : \"진달래꽃\" 추가");
		libraryHashTable.put("김소월", "진달래꽃"); // key: 김소월     value: 진달래꽃
		System.out.println("\"현진건\" : \"운수좋은 날\" 추가");
		libraryHashTable.put("현진건", "운수 좋은 날"); // key: 현진건     value: 운수 좋은 날
		System.out.println("\"김유정\" : \"동백꽃\" 추가");
		libraryHashTable.put("김유정", "동백꽃"); // // key: 김유정     value: 동백꽃
		System.out.println("\"최인훈\" : \"광장\" 추가");
		libraryHashTable.put("최인훈", "광장"); // // key: 최인훈     value: 광장
		System.out.println("\"박목월\" : \"보랏빛 소묘\" 추가");
		libraryHashTable.put("박목월", "보랏빛 소모"); // // key: 박목월     value: 보랏빛 소묘
		libraryHashTable.printEntries(); // hashtable 출력
		
		// remove 메서드 테스트
		System.out.println("\n* Remove Test ----------------------------------------------");
		System.out.println("최인훈 삭제");
		libraryHashTable.remove("최인훈");
		libraryHashTable.printEntries();
		
		System.out.println("\n\n김소월 삭제");
		libraryHashTable.remove("김소월");
		libraryHashTable.printEntries();
		
		// reHashing 테스트
		System.out.println("\n* Rehash Test ----------------------------------------------");
		System.out.println("\"정지용\" : \"향수\" 추가");
		libraryHashTable.put("정지용", "향수"); // key: 정지용     value: 향수
		System.out.println("\"이육사\" : \"청포도\" 추가");
		libraryHashTable.put("이육사", "청포도"); // key: 이육사     value: 청포도
		System.out.println("\"박경리\" : \"토지\" 추가");
		libraryHashTable.put("박경리", "토지"); // key: 박경리     value: 토지
		System.out.println("\"양귀자\" : \"원미동 사람들\" 추가");
		libraryHashTable.put("양귀자", "원미동 사람들"); // key: 양귀자     value: 원미동 사람들
		System.out.println("\"이상\" : \"날개\" 추가");
		libraryHashTable.put("이상", "날개"); // key: 이상     value: 날개
		System.out.println("\"윤동주\" : \"별헤는 밤\" 추가");
		libraryHashTable.put("윤동주", "별헤는 밤"); // key: 윤동주     value: 별헤는 밤
		System.out.println("\"나도향\" : \"벙어리 삼룡이\" 추가");
		libraryHashTable.put("나도향", "벙어리 삼룡이"); // key: 나도향     value: 벙어리 삼룡이
		System.out.println("\"김영랑\" : \"모란이 피기까지는\" 추가");
		libraryHashTable.put("김영랑", "모란이 피기까지는"); // key: 김영랑     value: 모란이 피기까지는
		System.out.println("\"김소월\" : \"진달래꽃\" 추가");
		libraryHashTable.put("김소월", "진달래꽃"); // key: 김소월     value: 진달래꽃
		libraryHashTable.printEntries();
		
	}
}
