package RockScissorsPaper;

public class Main {	
	//승자를 가리는 함수
	public String whoIsWinner(String userInput, String PCInput) {
		String winner = "";
		
		//컴퓨터가 가위를 냈을 경우
		if(PCInput.equals("가위")) {
			switch(userInput) {
			case "가위":
				winner = "무승부";
				break;
			case "바위":
				winner = "USER";
				break;
			case "보":
				winner = "PC";
				break;
			default:
				winner = "Error";
				break;
			}
		}
		
		//컴퓨터가 바위를 냈을 경우
		else if(PCInput.equals("바위")) {
			switch(userInput) {
			case "가위":
				winner = "PC";
				break;
			case "바위":
				winner = "무승부";
				break;
			case "보":
				winner = "USER";
				break;
			default:
				winner = "Error";
				break;
			}
		}
		
		//컴퓨터가 보를 냈을 경우
		else if(PCInput.equals("보")) {
			switch(userInput) {
			case "가위":
				winner = "USER";
				break;
			case "바위":
				winner = "PC";
				break;
			case "보":
				winner = "무승부";
				break;
			default:
				winner = "Error";
				break;
			}
		}
		
		//그 외의 경우는 에러로 처리합니다.
		else {
			winner = "Error";
		}
		
		return winner;
	}
	
	
	//메인함수
	public static void main(String[] args) {
		RockScissorsPaper RSP = new RockScissorsPaper();
		
		String str = new Main().whoIsWinner(RSP.getUserInput(), RSP.getPCInput());
		System.out.println("Winner: " + str);
	}
}
