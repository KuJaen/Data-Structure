package ArraySet;

import java.util.Random;

//���� �Լ�
public class Main {
	public static void main(String[] args) {
		ArraySet arraySet = new ArraySet(); //arraySet�� ��ü ����
		int[] searchNumberArray = {94, 359, 553, 731, 972}; //searchNumberArray�� ���� Ž���Ϸ��� ������ �迭�̴�. 
		
		Random random = new Random(); // random ��ü ����
		
		//random��ü�� ����Ͽ� 0���� 1000���� �������� ���� �̾� arraySet�� �߰��Ѵ�.
		for(int i = 0; i < 10000; i++) {
			int randomInt = random.nextInt(1000);
			arraySet.add(randomInt);
		}
		
		//�ð��� ��Ÿ���� ���� startTime�� endTime�̴�. 0���� �ʱ�ȭ ���ش�.
		long startTime = 0;
		long endTime = 0;
		
		//Sequential Search
		System.out.println("* Sequential Search ---------------------------------");
		
		//searchNumberArray�� ���ڵ��� �ϳ��� Ž���Ѵ�.
		for(int i = 0; i < 5; i++) {
			System.out.print("The time for finding " + searchNumberArray[i] + " = ");
			startTime = System.nanoTime(); //Ž�� ����
			arraySet.contains(searchNumberArray[i], true); //�Ű������� true�϶��� Sequential Search�� Ž��
			endTime = System.nanoTime(); //Ž�� ��
			System.out.println(endTime - startTime); //Ž�� �ð� ���
		}
		
		System.out.println("-----------------------------------------------------");
		//Binary Search
		System.out.println("* Binary Search -------------------------------------");
		for(int i = 0; i < 5; i++) {
			System.out.print("The time for finding " + searchNumberArray[i] + " = ");
			startTime = System.nanoTime(); //Ž�� ����
			arraySet.contains(searchNumberArray[i], false); //�Ű������� false�϶��� Binary Search�� Ž��
			endTime = System.nanoTime(); //Ž�� ��
			System.out.println(endTime - startTime); //Ž�� �ð� ���
		}
		System.out.println("-----------------------------------------------------");
	}
}
