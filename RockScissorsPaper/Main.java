package RockScissorsPaper;

public class Main {	
	//���ڸ� ������ �Լ�
	public String whoIsWinner(String userInput, String PCInput) {
		String winner = "";
		
		//��ǻ�Ͱ� ������ ���� ���
		if(PCInput.equals("����")) {
			switch(userInput) {
			case "����":
				winner = "���º�";
				break;
			case "����":
				winner = "USER";
				break;
			case "��":
				winner = "PC";
				break;
			default:
				winner = "Error";
				break;
			}
		}
		
		//��ǻ�Ͱ� ������ ���� ���
		else if(PCInput.equals("����")) {
			switch(userInput) {
			case "����":
				winner = "PC";
				break;
			case "����":
				winner = "���º�";
				break;
			case "��":
				winner = "USER";
				break;
			default:
				winner = "Error";
				break;
			}
		}
		
		//��ǻ�Ͱ� ���� ���� ���
		else if(PCInput.equals("��")) {
			switch(userInput) {
			case "����":
				winner = "USER";
				break;
			case "����":
				winner = "PC";
				break;
			case "��":
				winner = "���º�";
				break;
			default:
				winner = "Error";
				break;
			}
		}
		
		//�� ���� ���� ������ ó���մϴ�.
		else {
			winner = "Error";
		}
		
		return winner;
	}
	
	
	//�����Լ�
	public static void main(String[] args) {
		RockScissorsPaper RSP = new RockScissorsPaper();
		
		String str = new Main().whoIsWinner(RSP.getUserInput(), RSP.getPCInput());
		System.out.println("Winner: " + str);
	}
}
