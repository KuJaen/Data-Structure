package Map;

/** 
 * ArrayMapŬ����
 * @author Ku
 */
public class ArrayMap implements Map {
	private static final int INITIAL_SIZE = 100; // �ʱ��� ũ��� 100�̴�.
	private Entry[] entryArray; // entryArray�� Entry���� ������ �迭�� �ǹ��Ѵ�.
	private int size; // ���� Array�� ���Ե� Entry�� ���� ��Ÿ����.

	/** 
	 * ArrayMap�� ������
	 */
	public ArrayMap() {
		this.entryArray = new Entry[INITIAL_SIZE]; // �ʱ� ũ��� entryArray��ü�� �����Ѵ�.
		this.size = 0; // ó�� size�� 0
	}

	 /**
	  * get�޼���
	  * �Ű����� key�� �ش��ϴ� ���� key������ ������ �ִ� Entry�� �ִ��� �˻��ϰ� �ִٸ� �� Entry�� value���� ��ȯ�Ѵ�.
	  * return null
	  */
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		// for�ݺ����� ����Ͽ� �Ű����� key�� ���� Entry�� �ִ��� �˻��Ѵ�.
		for (int i = 0; i < this.size; i++) {
			//���� �ִٸ� �ش� Entry�� value���� ��ȯ�Ѵ�.
			if (this.entryArray[i].getKey().equals(key)) {
				return this.entryArray[i].getValue();
			}
		}
		// ���ٸ� null�� ��ȯ�Ѵ�.
		return null;
	}

	/** 
	 * put�޼���
	 * �Ű����� key���� value���� �����ִ� Entry�� Array�� �����ϴ� �޼���. key���� ���������� ����Ǹ� value�� �ش� �ܾ ���� Ƚ���� �ǹ��Ѵ�.
	 * return oldValue key�� �̹� �����Ѵٸ�
	 * return null
	 */
	@Override
	public Object put(Object key, int value) {
		// TODO Auto-generated method stub
		// �ݺ������� ó������ ������ �̹� �Ű����� key���� �����ִ� Entry�� �ִ��� �˻��Ѵ�.
		for (int i = 0; i < this.size; i++) {
			//���� �ִٸ�
			if (this.entryArray[i].getKey().equals(key)) {
				Object oldValue = this.entryArray[i].getValue(); // ���� oldValue�� ���� value���� �����ϰ�
				this.entryArray[i].setValue(entryArray[i].getValue()+1); // �ش� Entry�� Value���� ������ �ش�.
				return oldValue; // oldValue���� ��ȯ�ϰ� ��ģ��.
			}
		}
		
		// �Ű����� key���� ���� Entry�� ���� ��� ����
		// Array�� �̹� ���� �� �ִٸ�
		if (size == entryArray.length) {
			reSize(); // �ִ� ũ�⸦ ������ �ش�.
		} 
		
		// ���������� �����ϱ����� �̹� ����Ǿ��ִ� key����� ���� ���̴�.
		for (int i = 0; i < this.size; i++) {
			// ������������ �Ű����� key�� �ش��ϴ� ������ ū ���� Array�� ����Ǿ� �ִٸ�
			if (entryArray[i].getKey().toString().compareTo(key.toString()) > 0) {
				// ����Ȱ����� �ڷ� �о��ְ� �ùٸ� �ڸ��� �Ű����� key���� ���� ���ο� Entry�� �߰��� �ش�.
				System.arraycopy(entryArray, i, entryArray, i + 1, size - i);
				entryArray[i] = new Entry(key, value);

				this.size++; // ���ο� ���ڰ� �߰��Ǿ����Ƿ� sizeũ�⸦ 1Ű���ش�.
				return null; // ��ġ�� key���� �������Ƿ� null�� ��ȯ�Ѵ�.
			}
		}
		//for���� return���� ��� ���ư��ٸ� �Ű����� key�� �ش��ϴ� ���� ���� ū ���̴�.
		this.entryArray[size] = new Entry(key, value); // ���� Array�������� Entry�� �����Ѵ�.
		this.size++; // ���ο� ���ڰ� �߰��Ǿ����Ƿ� sizeũ�⸦ 1Ű���ش�.
		return null; // ��ġ�� key���� �������Ƿ� null�� ��ȯ�Ѵ�.
	}
	
	/**
	 *  size���� ��ȯ�ϴ� �޼���
	 *  return size
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	/**
	 * �Ű����� key�� ���� Entry�� �����ϴ� �޼���
	 * return true Entry���� ������
	 * return false Entry���� ���н�
	 */
	@Override
	public boolean remove(Object key) {
		// TODO Auto-generated method stub
		// key�� ���� Entry�� �ִ��� ��ü������ �˻��Ѵ�.
		for (int i = 0; i < this.size; i++) {
			//���� �ִٸ�
			if (this.entryArray[i].getKey().equals(key)) {
				//Array�� ���ڵ��� �ش� �ڸ����� ��� ���� Entry���� ���ְ� ���鼭 size-1���ڿ� ���� key���� ���Ե� size�� null������ �ٲ��ش�.
				System.arraycopy(entryArray, i + 1, entryArray, i, size - i - 1);
				this.entryArray[size] = null;
				this.size--; // ũ�Ⱑ �ϳ� �پ����Ƿ� sizeũ�⸦ 1 �ٿ��ش�.
				return true; // �ùٸ��� remove�� �̷�������� true�� ��ȯ�Ͽ� �˸���.
			}
		}
		return false; // remove�� �̷������ ��������(key���� ���� Entry�� ������) false�� ��ȯ�Ͽ� �˸���.
	}
	
	/**
	 * Array�� �ִ�ũ�⸦ �缳���ϴ� �޼���
	 */
	public void reSize() {
		// ���� Arrayũ���� 2���� ũ�⸦ ���� copiedArray ��ü ����
		Entry[] copiedArray = new Entry[this.entryArray.length * 2];
		//copiedArray�� entryArray�� �����Ѵ�.
		System.arraycopy(entryArray, 0, copiedArray, 0, this.size);
		this.entryArray = copiedArray; // entryArray�� copiedArray�� �ʱ�ȭ ��Ų��.
	}
	
	/**
	 *  Array����� ����ϴ� �޼��� �̴�.
	 */
	@Override
	public void printArray() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size; i++) {
			// key���� �ش��ϴ� Value���� ���� ����Ѵ�.
			System.out.println(this.entryArray[i].getKey() + " : " + this.entryArray[i].getValue());
			// 20��° �� ���� ���پ� �����
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}

}
