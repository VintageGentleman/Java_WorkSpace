package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class S15_JScrollPane {

	/*
	  	Panel : 다른 컴포넌트를 붙일 수 있으며 레이아웃을 설정할 수 있음
	  	Pane  : 다른 컴포넌트를 붙일 수 있으며 특수한 기능을 가짐 
	*/
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Scroll...");
		f.setLayout(new BorderLayout());
		
		JScrollPane pane = new JScrollPane();
		JTextArea textarea = new JTextArea();
		
		pane.setViewportView(textarea);
		
		// 세로 스크롤 정책 설정
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// 가로 스크롤 정책 설정
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  
		
		f.add(pane, BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
	
}
