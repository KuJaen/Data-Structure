package RockScissorsPaper;

import java.util.Scanner;

public class RockScissorsPaper {
	//Scanner ��ü ����
	Scanner sc = new Scanner(System.in);
		
	//�����κ��� �Է��� �޴� �Լ�
	public String getUserInput() {
		System.out.println("����, ����, �� �߿� ������ �ֽʽÿ�.");
		String in = "";
		
		while(true) {
			in = sc.next();
			
			if(!in.equals("����") && !in.equals("����") && !in.equals("��")) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ֽʽÿ�.");
				continue;
			}
			break;
		}
		
		return in;
	}
	
	//��ǻ�ͷκ��� �Է��� �޴� �Լ�
	public String getPCInput() {
		//i�� 1�� �� ����, 2�� �� ����, 3�� �� �� �Դϴ�.
		int i = ((int)Math.random()*3)+1;
		
		switch(i) {
		case 1:
			return "����";
		case 2:
			return "����";
		case 3:
			return "��";
		default :
			return "Error";
		}
	}
}