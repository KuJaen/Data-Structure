package Sort;

import java.util.Random;

public class SortFunction implements SortInterface {
	private static int MAX_SIZE = 100000; // Array�� �ִ� ũ��
	private int[] numberArray; // ������ MAX_SIZE��ŭ ���ڰ� �߰��� Array
	private int[] sortedArray; // Sort�� ����ǰ� ���������� Sort�� ���� Array�� ����� �޼���
	private Random random; // ���� ������ ���� ��ü ����
	
	//������
	public SortFunction() {
		this.numberArray = new int[MAX_SIZE]; // numberArray ����
		this.random = new Random(); // random ��ü ����
		
		// numberArray�� 0���� 1000������ ���ڸ� �������� �ִ´�.
		for(int i = 0; i < this.numberArray.length; i++) {
			numberArray[i] = random.nextInt(1000);
		}
		
		this.sortedArray = new int[MAX_SIZE]; //sortedArray ����
		// numberArray�� 0���� MAX_SIZE���� ��, ��ü�� sortedArray�� �����Ѵ�.
		System.arraycopy(numberArray, 0, sortedArray, 0, MAX_SIZE);
	}
	
	//sortedArray�� �ʱ�ȭ �ϴ� �޼���
	public void setSortedArray() {
		//sortedArray�� Sort�������� �ǵ�����.
		System.arraycopy(numberArray, 0, sortedArray, 0, MAX_SIZE);
	}
	
	// Bubble Sort �޼���
	@Override
	public void bubbleSort() {
		int temp; // temp�� Bubble Sort�������� ������ �� ���ڸ� ���� ��ȯ�ϴµ� ����� �����̴�.
		
		/* Bubble Sort�� �����ʿ������� ���ʴ�� �ϼ��Ǿ� ����. 
		 * ���� �ݵ�� n���̻��� �˻簡 �̷���� ���̰� �̰��� ������ �ð����⵵��  ��(n)�� �����̴�. */
		 for(int i = sortedArray.length; i > 0; i--) {
			 //���ʺ��� ������� ������ ���ڳ��� ���Ѵ�.
	         for (int j = 0; j < i-1; j++) {
	        	 //���� ������ �� ���� �� ���ʿ� �ִ� ���ڰ� �� ũ�ٸ� �� ������ �ڸ��� ��ü�Ѵ�.
	             if(sortedArray[j] > sortedArray[j+1]) {
	                 temp = sortedArray[j]; 
	                 sortedArray[j] = sortedArray[j+1];
	                 sortedArray[j+1] = temp;
	             }
	         }
	     }
	}
	
	// Selection Sort �޼���
	@Override
	public void selectionSort() {
		int min; // ���ĵ��� ���� ������ ���� ���� ������ ��ġ�� ��Ÿ���� ����
		int temp; // ������ �ڸ��� ��ȯ�ϴµ� ����ϴ� ����
		
		// ���ĵ��� ���� ������ ���� ���ʺ��� �ʱ� min���� �����Ѵ�. �̴� Array�� ������ʺ��� ���ʴ�� �������� �ǹ��Ѵ�.
		for(int i = 0; i < sortedArray.length-1; i++){
            min = i; // ���ʺ��� ������� min���� ����
            
            // ������ min������ ���ڵ�� ���������� ũ�⸦ ���Ѵ�.
            for(int j = i+1; j < sortedArray.length; j++){
            	// ���� min�� �ش��ϴ� ���ں��� ���� ���ڰ� �߰ߵȴٸ� min ��, �ּڰ��� ������ �ش�.
                if(sortedArray[min] > sortedArray[j]){
                    min = j;
                }
            }
            
            /* min�� �ش��ϴ� ���ڿ� i�� �ش��ϴ� ������ ��ġ�� ���� �ٲپ��ش�.
             * �̷��� Array�� ���ʺ��� ���� ������ ������ �� ���̴�.
             */
            temp = sortedArray[min];
            sortedArray[min] = sortedArray[i];
            sortedArray[i] = temp;
        }
	} // ��ó: https://hahahoho5915.tistory.com/7
	
	// QuickSort �޼���
	@Override
	/* �Ű����� left, right�� Sort�� �̷���� Array ��Ƽ���� �¿� ���� ���� �Ǹ��Ѵ�.
	 * �̶� Array ��Ƽ���̶� Quick Sort�� �ϳ��� Array�� pivot�� �������� �ΰ��� Array�� ������ �����ϴµ� �� ������ ���ҵ� Array��
	 * Array ��Ƽ���̶� �ϰڴ�. (������ ���Ǽ��� ���� ������ ��Ī�̴�.)
	 */
	public void quickSort(int left, int right) {
		int low, high; // �˻簡 �̷������ ������ ���� ������ġ, ������ġ�� ��Ÿ����.
		int pivot; // ������ �Ǵ� pivot �����̴�.
		int temp; //������ ��ġ�� ��ü�ϴµ� ����� �����̴�.
		
		// ����  right�� left���� ũ�ٸ�. ��, ���� ������ ���ڸ� ��Ÿ���� right�� ���� ������ ��Ÿ���� left���� �����ʿ� ���� ��츦 ���Ѵ�.
		// left�� right���� �� ũ�ٸ� �̴� ������ �������� �ǹ��Ѵ�.
		if(left<right)
		{
		   low = left; // low�� left���� �����Ѵ�.
		   high = right; // high�� right���� �����Ѵ�.
		   pivot = sortedArray[left]; // pivot�� �����ϴ� Array�� ù��° ����
		   
		   //���� ����
		   while(low < high) //high�� low���� Ŭ������. ��, �ѹ��� ������ ���� �� ����
		   {
			  // pivot�� �ش��ϴ� ���ں��� ���� sortedArray[high]���ڰ� ���� �� ���� high�ε����� �ϳ��� �ٿ��ش�.
		      while(sortedArray[high] > pivot) {
		    	  high--;
		      }
		      
		      // pivot�� �ش��ϴ� ���ں��� ū sortedArray[low]���ڰ� ���� �� ���� low�ε����� �ϳ��� �÷��ش�.
		      while(low < high && sortedArray[low] <= pivot) {
		    	  low++;
		      }
		      
		     //pivot���� ũ�� ���� ��  sortedArray[low], sortedArray[high] �ε����� ��ġ�� �ٲ��ش�.
	         temp = sortedArray[low];
	         sortedArray[low] = sortedArray[high];
	         sortedArray[high] = temp;
	       }
		   
		   /* �� �������� �����ϴ� Array�� ù���� ���ڸ� pivot���� ����Ѵ�.
		    * �̶� �ѹ� �̻� ������ �̷���� �������� Array ��Ƽ�ǿ����� ù��° ���ڸ� pivot���� ����Ͽ��� �ϱ� ������
		    * ù ���� ������ ��ġ�� low��ġ ���ڸ� �־��ְ� low��ġ�� pivot�� ��, õ��° ������ ��ġ�� �־��ش�.
		    * �̴� �� ��Ƽ�� �� low��ġ�� �������� ���������� �ǹ��Ѵ�. */
		   sortedArray[left] = sortedArray[low];
		   sortedArray[low] = pivot;
	       
		   // �Լ��� ��������� ȣ���Ͽ� �� Array ��Ƽ������ ������ �ٽ� ������ �����Ѵ�.
	       quickSort(left, low-1);
	       quickSort(low+1, right);  
	    }
	 } // ��ó: https://cocomo.tistory.com/247 [Cocomo Coding]
	
	// insertionSort �޼���
	@Override
	
	// �ε���1���� �ϳ��� �տ��ִ� ���ڵ�� ���Ͽ� key�� �ش��ϴ� ���ں��� ū ���ڰ� �ִٸ� ��ġ�� �ٲ۴�. �̴� ���ʿ��� ���������� ������ ����ȴ�.
	public void insertionSort() {
		//Array�� �� ���̱��� ������ ����ȴ�.
		for(int i = 1; i < sortedArray.length; i++) {
			int key = sortedArray[i]; //key�� ��ġ�� �ٲ� ���� �ε����� �ش��ϴ� �����̴�.
			int k = i - 1; // k�� i�ε��� ��ġ���� ���� ��ġ�� �ش��ϴ� �ε����� �ǹ��Ѵ�.
			
			// k�� 0���� ũ�� key���� ū ���ڰ� key�ٷ� ������ �ִٸ� key���� �۰ų� ���� ���ڰ� ���ö����� �����Ѵ�.
			while(k >= 0 && key < sortedArray[k]) {
				sortedArray[k+1] = sortedArray[k]; //key���� ū ���ڵ��� key��ġ ���� ��ĭ�� Array�� �о��ش�.
				
				k--;
			}
			sortedArray[k+1] = key; //Array�� �о��־��ٸ� �о��� ���ڵ� ���� �տ� key�� ����.
			//�׷��� ���� ��쿡�� ��ȭ�� ����.
		}
	}

	//���� ���� Array�� ����ϴ� �޼����̴�.
	@Override
	public void printOriginalArray() {
		int temp = 0; // ���ٿ� ����� ���ڸ� �����ϱ� ���� �����̴�.
		
		// ��� ���ڵ��� ����Ѵ�.
		while(temp < numberArray.length) {
			//���ٿ� 20���� ����Ѵ�.
			for(int i = temp; i < temp + 20; i++) {
				System.out.print(numberArray[i] + " ");
			}
			// 20���� ��� ��µǾ��ٸ� ���� ��� �ٽ� 20���� ����Ѵ�.
			System.out.println();
			temp = temp + 20;
		}
	}
	
	//���� ���� Array�� ����ϴ� �޼����̴�.
	@Override
	public void printSortedArray() {
		int temp = 0; // ���ٿ� ����� ���ڸ� �����ϱ� ���� �����̴�.
		
		// ��� ���ڸ� ����Ѵ�.
		while(temp < sortedArray.length) {
			//���ٿ� 20���� ����Ѵ�.
			for(int i = temp; i < temp + 20; i++) {
				System.out.print(sortedArray[i] + " ");
			}
			// 20���� ��� ��µǾ��ٸ� ���� ��� �ٽ� 20���� ����Ѵ�.
			System.out.println();
			temp = temp + 20;
		}
	}
}
