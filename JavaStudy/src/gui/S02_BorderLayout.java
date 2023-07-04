package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_BorderLayout {

	/*
	 	# 레이아웃(Layout)
	 	
	 	- 컨테이너에는 레이아웃을 설정할 수 있다
	 	- 레이아웃은 컨테이너를 배치하는 방식을 결정한다
	  	- 레이아웃이 설정되지 않은 컨테이너는 컴포넌트를 자유롭게 배치할 수 있다
	  	  (직접 좌표를 찍어서 배치 가능)
	  	  
	  	# BorderLayout
	  	
	  	- JFrame의 기본 레이아웃
	  	- 동서남북과 가운데로 이루어진 레이아웃
	*/
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("I am JFrame");

		// 프레임에 보더레이아웃을 설정
		BorderLayout layout = new BorderLayout();
		
		layout.setVgap(15);
		layout.setHgap(15);
		
		f.setLayout(layout);
		
		// BorderLayout에 컴포넌트 붙이기
		f.add(new JButton("Button1"), BorderLayout.EAST);
		f.add(new JButton("Button2"), BorderLayout.WEST);
		f.add(new JButton("Button3"), BorderLayout.SOUTH);
		f.add(new JButton("Button4"), BorderLayout.NORTH);
		f.add(new JButton("Button5"), BorderLayout.CENTER);
		
		// Location과 Size를 한번에 설정하는 메서드
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
	
}
