package ArrayBag;

public interface Bag {
	//Bag�� ���Ҹ� �߰��ϴ� �Լ�
	public boolean add(Object object);
	
	//Bag�� �Ű����� object�� ���ԵǴ��� �˻��ϴ� �Լ�
	public boolean contains(Object object);
	
	//Bag�� ������ ������ ��ȯ�ϴ� �Լ�
	public int size();
	
	//Bag�� ���Ұ� 0������ �ƴ����� ��ȯ�ϴ� �Լ�
	public boolean isEmpty();
	
	//Bag�� ù��° ���Ҹ� ��ȯ�ϴ� �Լ�
	public Object getFirst();
	
	//Bag�� �����ϴ� �Ű����� object�� �����ϴ� �Լ�
	public boolean remove(Object object);
	
	//Bag�� �����ϴ� ù ��° ���Ҹ� �����ϴ� �Լ�
	public Object removeFirst();
	
	//Bag�� �����ϴ� ���Ҹ� ��� ����ϴ� �Լ�
	public void printAll();
}
