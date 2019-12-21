package ArraySet;

public interface Set {
	//Set�� ���Ҹ� �߰��ϴ� �Լ�
		public boolean add(Object object);
		
		//Set�� �Ű����� object�� ���ԵǴ��� �˻��ϴ� �Լ�
		public boolean contains(Object object, boolean mode);
		
		//Set�� ������ ������ ��ȯ�ϴ� �Լ�
		public int size();
		
		//Set�� ���Ұ� 0������ �ƴ����� ��ȯ�ϴ� �Լ�
		public boolean isEmpty();
		
		//Set�� ù��° ���Ҹ� ��ȯ�ϴ� �Լ�
		public Object getFirst();
		
		//Set�� �����ϴ� �Ű����� object�� �����ϴ� �Լ�
		public boolean remove(Object object);
		
		//Set�� �����ϴ� ù ��° ���Ҹ� �����ϴ� �Լ�
		public Object removeFirst();
		
		//Set�� �����ϴ� ���Ҹ� ��� ����ϴ� �Լ�
		public void printAll();
		
		//index�� �ش��ϴ�  object��ȯ
		public Object getValueByIndex(int index);
}
