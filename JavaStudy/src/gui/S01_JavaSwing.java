package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class S01_JavaSwing {
	
	/*
	  	# Java Swing
	  	
	  	- 자바로 GUI 프로그램을 만들 수 있는 API
	  	
	  	# Container
	  	
	  	- 위에 여러 컴포넌트들을 배치할 수 있는 판
	  	- JFrame, JPanel, JDialog ... 등이 다양한 클래스들이
	  	  컨테이너 역할을 할 수 있다
	  	
	  	# Component
	  
	  	- 컨테이너 위에 배치할 수 있는 다양한 것들
	  	- 버튼, 라벨, 표, 슬라이더 ... 등이 있다
	*/

	public static void main(String[] args) {
	
		// 프레임 인스턴스를 생성 (초기에는 보이지 않는 상태)
		JFrame frame = new JFrame();

		// 컴포넌트 인스턴스들을 생성
		JButton button1 = new JButton("I am Button1");
		JButton button2 = new JButton("I am not Button1");
		
		button1.setLocation(10, 10);
		button2.setLocation(10, 100);
		
		button1.setSize(250, 50);
		button2.setSize(300, 50);
		
		// 컨테이너에 컴포넌트를 부착한다
		frame.add(button1);
		frame.add(button2);
		
		// 해당 프레임의 레이아웃을 사용하지 않음
		frame.setLayout(null);
		
		// 해당 프레임의 X버튼을 눌렀을 때 동작을 설정
		frame.setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		
		// 해당 프레임의 초기 위치를 설정
		// (x:모니터 왼쪽에서부터 얼마나 떨어져 있는가,
		//  y:모니터 맨위에서부터 얼마나 떨어져 있는가)
		frame.setLocation(700, 300);
				
		// 해당 프레임의 크기를 설정 (width:너비, height:높이)
		frame.setSize(500, 500);
		
		// 해당 프레임을 보이는 상태로 설정
		// setVisible()하는 시점에 화면에 프레임을 다시 그리므로
		// 맨 마지막에 setVisible()하는 것이 좋다
		frame.setVisible(true);
		
	}
	
}
