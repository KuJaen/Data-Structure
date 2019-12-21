package ArraySet;

import java.util.Arrays;

public class ArraySet implements Set {
	private static final int MAX_SIZE = 10000; //Set�� �ִ� ũ�⸦ 100���� ����
	private int maxSize; //maxSize���� ����
	private Object[] objects; //Set�� ����Ʈ�� ��Ÿ�� object����Ʈ ����
	private int size = 0; //Set�� ó�� ũ��� 0��
	
	public ArraySet() {
		this.maxSize = MAX_SIZE; //maxSize�� MAX_SIZE �� 100��
		this.objects = new Object[maxSize]; //ũ�Ⱑ maxSize�� object����Ʈ ����
		this.size = 0; //Set�� ó�� ũ��� 0��
}
	
	//�������̽��� add�Լ�
	@Override
	public boolean add(Object object) {
		// TODO Auto-generated method stub
		//���� size�� maxSize�� ���ٸ� ��, Set�� ������� ���ٸ� false�� ��ȯ�Ѵ�.
		if(size == maxSize) {
			return false;
		}
		//�ƴϸ� �̹� �Ű����� object�� �ش��ϴ� ���� �����Ѵٸ� ���������� false�� ��ȯ�Ѵ�.
		else if(contains(object, true)) {
			return false;
		}
		//�� �ΰ��� ���ǿ� ��� �ش����� ���� ��� Set�� object�� �߰��ϰ� true�� ��ȯ�Ѵ�.
		objects[size++] = object;
		return true;
	}
		
	//�������̽��� contains�Լ�
	@Override
	public boolean contains(Object object, boolean mode) {
		// TODO Auto-generated method stub
		
		//mode�� true�� �� Sequential Search�� ���� �˻��Ѵ�.
		if(mode == true) {
			//���������� object�� ��ġ�ϴ� ���ڰ� objects����Ʈ�� �����ϴ��� �˻��Ѵ�.
			for(int i = 0; i < objects.length; i++) { 
				if(objects[i] == object) {
					return true; //�����Ѵٸ� true�� ��ȯ�Ѵ�.
				}
			}
			return false; //object�� �������� �ʴ´ٸ� false�� ��ȯ�Ѵ�.
		}
			
		//mode�� false�� �� Binary Search�� �˻��Ѵ�.
		else {
			//Binary Search�� ���ؼ��� ���� ����Ʈ�� ������ �� �ʿ䰡 �ִ�.
			//����Ʈ�� ������ �־������ �ϳ��� �������� ũ�� ������ �����ذ��� Ž���� �� �� �ִ�.
			Integer[] copieArray = new Integer[size]; //objects����Ʈ�� ������ �迭�� ������ ����Ʈ ��ü copieArray ����
			System.arraycopy(objects, 0, copieArray, 0, size); //objects�� ��� ���ڸ� copieArray�� �����´�.
			Arrays.sort(copieArray); // copieArray�� �����ϴ� �޼���
			
			int startIndex = 0; //Ž���� ������ ���� ��
			int endIndex = objects.length; //Ž���� ������ ������ ��
			
			while(startIndex <= endIndex) { //endIndex�� startIndex���� ũ�ų� ���� ������ ��, Ž���� ���� �� ���� �ݺ�
				int index = (startIndex + endIndex)/2; //index�� �˻��� ���ڸ� ��Ÿ���� Ž���� ������ ����� ��Ÿ����.
				if(copieArray[index] == object) { //���� �˻��� ���ڰ� object�� ���ٸ�
					return true; //true�� ��ȯ�Ѵ�.
				}
				else if(copieArray[index] < (int)object) { //���� �˻��� ���ڰ� object���� �۴ٸ�
					startIndex = index+1; //startIndex�� index+1�� �ʱ�ȭ ��Ų��. ��, Ž�������� index�� �������� ���������� �Ѵ�.
				}
				else { //�� ���� ���. ���� �˻��� ���ڰ� object���� ũ�ٸ�
					endIndex = index -1; //endIndex�� index -1�� �ʱ�ȭ ��Ų��. ��, Ž�������� index�� �������� �������� �Ѵ�.
				}
			}
			return false; //object�� �������� �ʴ´ٸ� false�� ��ȯ�Ѵ�.
		}
	}
	
	//�������̽��� size�Լ�
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size; //Bag�� ���ԵǾ��ִ� ������ ������ ��ȯ�Ѵ�.
	}
	
	//�������̽��� isEmpty�Լ�
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//Bag�� ���ԵǾ� �ִ� ������ ������ 0�̸� true�� ��ȯ�Ѵ�.
		if(size == 0)
			return true;
		return false; // ���� ���Ұ� �ϳ��� ���ԵǾ� �ִٸ� false�� ��ȯ�Ѵ�.
	}
	
	//�������̽��� getFirst�Լ�
	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return objects[0]; //Bag�� ù��° ���ҿ� �ش��ϴ� ���� ��ȯ�Ѵ�.
	}
	
	//�������̽��� remove�Լ�
	@Override
	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		//isEmpty�Լ��� ���̶�� ��, Bag�� ���Ե� ���Ұ� �ϳ��� �������� �ʴ´ٸ� false�� ��ȯ�Ѵ�.
		if(isEmpty())
		{
			return false;
		}
		
		//Bag�� ���Ұ� �ϳ��� �����Ѵٸ�
		for(int k = 0; k < size; k++) {
			//�� ���Ҹ� ���������� �Ű����� object�� �ش��ϴ� ���� ��ġ�ϴ��� �˻��Ѵ�.(�� object�� �ش��ϴ� ���� �ִ��� �˻��Ѵ�.)
			if(objects[k] == object)
			{
				//���� �ش簪�� �ִٸ� �� ���Ҹ� ���ش�.
				System.arraycopy(objects, k+1, objects, k, size-k-1);
				//�ش� ���Ҹ� �����ϴ� �������� ������ ���Ұ� �ߺ��Ǽ� ����ǹǷ� ���� ������ ���Ҹ� �����Ѵ�.
				objects[size-1] = null;
				size--; //���Ұ� �ϳ� ���������Ƿ� size�� ũ�� ���� �ϳ� �پ���� �Ѵ�.
				break;
			}
		}
		return true; //������ ���Ҹ� �����Ͽ��ٸ� true�� ��ȯ�Ѵ�.
	}
	
	//�������̽��� removeFirst�Լ�
	@Override
	public Object removeFirst() {
		// TODO Auto-generated method stub
		//isEmpty�Լ��� ���̶��, �� ���Ұ� �ϳ��� �������� �ʴ´ٸ� false�� ��ȯ�Ѵ�.
		if(isEmpty())
		{
			return false;
		}
		
		//���Ұ� �ϳ��� �����Ѵٸ� ù��° ���Ҹ� �����ش�.
		System.arraycopy(objects, 1, objects, 0, size-1);
		objects[size-1] = null; //�����ϴ� �������� ������ ���Ұ� �ߺ��Ǿ� ����Ǿ� �����Ƿ� ���� ������ ���Ҹ� �������ش�.
		size--; //���Ұ� �ϳ� ���������Ƿ� size�� ũ�� ���� �ϳ� �پ���� �Ѵ�.
		return true; //������ ���Ұ� �����Ǿ��ٸ� true�� ��ȯ�Ѵ�.
	}
	
	//�������̽��� printAll�Լ�
	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		//����Ʈ�� ��ü ���Ҹ� ������� ���̹Ƿ� ����Ʈ�� ��Ÿ���� ǥ������ []�� �������� ����� ���̴�.
		System.out.print("["); // [�� ���� ���� ����Ѵ�
		//���Ҹ� ���������� ����Ѵ�.
		for(int k = 0; k < size; k ++) {
			System.out.print(objects[k]);
			//������ ���Ҹ� ����Ҷ��� ��ǥ�� ���� �ʴ´�.
			if(k<size-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");// ���������� ]�� ����Ѵ�.
	}
	
	//getValueByIndex�Լ�
	@Override
	public Object getValueByIndex(int index) { //index�� °�� �ش��ϴ� ���ڸ� ��ȯ�Ѵ�.
		return objects[index];
	}
}