package ArraySet;

public class Main {
	public static void main(String args[]) {
		//ArraySet객체를 생성한다.
		ArraySet arraySet = new ArraySet();
		
		//arraySet이 올바르게 작동하는지 검사한다.
		System.out.println("* Hi 원소 추가");
		System.out.println("--------------------------------------");
		arraySet.add("Hi");
		arraySet.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* Hi 원소 삭제");
		System.out.println("--------------------------------------");
		arraySet.remove("Hi");
		arraySet.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* ArrayBag이 비었나?");
		System.out.println("--------------------------------------");
		System.out.println(arraySet.isEmpty());
		System.out.println("--------------------------------------");
		
		System.out.println("* 원소 추가");
		System.out.println("--------------------------------------");
		arraySet.add("구재빈");
		arraySet.add("구재빈");
		arraySet.add("201802049");
		arraySet.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* 원소 개수 출력");
		System.out.println("--------------------------------------");
		System.out.println(arraySet.size());
		System.out.println("--------------------------------------");
		
		System.out.println("* 학번이 Bag에 존재하는가?");
		System.out.println("--------------------------------------");
		System.out.println(arraySet.contains("201802049"));
		System.out.println("--------------------------------------");
		
		System.out.println("* 첫번째 원소 삭제");
		System.out.println("--------------------------------------");
		arraySet.removeFirst();
		arraySet.printAll();
		System.out.println("--------------------------------------");
	}
}
