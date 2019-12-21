package RockScissorsPaper;

import java.util.Scanner;

public class RockScissorsPaper {
	//Scanner 객체 생성
	Scanner sc = new Scanner(System.in);
		
	//유저로부터 입력을 받는 함수
	public String getUserInput() {
		System.out.println("가위, 바위, 보 중에 선택해 주십시오.");
		String in = "";
		
		while(true) {
			in = sc.next();
			
			if(!in.equals("가위") && !in.equals("바위") && !in.equals("보")) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오.");
				continue;
			}
			break;
		}
		
		return in;
	}
	
	//컴퓨터로부터 입력을 받는 함수
	public String getPCInput() {
		//i가 1일 때 가위, 2일 때 바위, 3일 때 보 입니다.
		int i = ((int)Math.random()*3)+1;
		
		switch(i) {
		case 1:
			return "가위";
		case 2:
			return "바위";
		case 3:
			return "보";
		default :
			return "Error";
		}
	}
}