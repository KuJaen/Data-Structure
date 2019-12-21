package ArrayBag;

public class Main {
	public static void main(String args[]) {
		//arrayBag의 객체를 생성한다.
		ArrayBag arrayBag = new ArrayBag();
		
		//arrayBag이 올바르게 작동하는지 검사한다.
		System.out.println("* Hi 원소 추가");
		System.out.println("--------------------------------------");
		arrayBag.add("Hi");
		arrayBag.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* Hi 원소 삭제");
		System.out.println("--------------------------------------");
		arrayBag.remove("Hi");
		arrayBag.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* ArrayBag이 비었나?");
		System.out.println("--------------------------------------");
		System.out.println(arrayBag.isEmpty());
		System.out.println("--------------------------------------");
		
		System.out.println("* 원소 추가");
		System.out.println("--------------------------------------");
		arrayBag.add("구재빈");
		arrayBag.add("구재빈");
		arrayBag.add("201802049");
		arrayBag.printAll();
		System.out.println("--------------------------------------");
		
		System.out.println("* 원소 개수 출력");
		System.out.println("--------------------------------------");
		System.out.println(arrayBag.size());
		System.out.println("--------------------------------------");
		
		System.out.println("* 학번이 Bag에 존재하는가?");
		System.out.println("--------------------------------------");
		System.out.println(arrayBag.contains("201802049"));
		System.out.println("--------------------------------------");
		
		System.out.println("* 첫번째 원소 삭제");
		System.out.println("--------------------------------------");
		arrayBag.removeFirst();
		arrayBag.printAll();
		System.out.println("--------------------------------------");
	}
}
