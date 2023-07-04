package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class S03_JButton extends JFrame {

	JButton mainBtn = new JButton("main Button");
	JButton subBtn = new JButton("sub Button");
	
	public S03_JButton() {
		super("JButton Test 입니다");
	
		setLayout(new BorderLayout());
		
		add(mainBtn, BorderLayout.CENTER);
		add(subBtn, BorderLayout.SOUTH);
	
		// 버튼 텍스트 바꾸기
		mainBtn.setText("<html>Hello!<br>Welcome!<html>");
		
		// 버튼 글꼴 바꾸기 (windows/fonts에 있는 모든 글꼴 사용 가능)
		// 스타일 옵션은 | (OR) 연산으로 복수 적용 가능
		mainBtn.setFont(new Font("Curlz MT", Font.PLAIN, 50));
		
		// 버튼 색 변경 (색상에는 RGB, HEX(16진수) 사용 가능)
		mainBtn.setBackground(Color.white);
		mainBtn.setForeground(new Color(168, 50, 117));
		
		// 버튼의 이벤트 동작 설정
		// (ActionListener 인터페이스를 구현한 인스턴스를 요구함)
		mainBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("메인 버튼을 누르셨습니다.");
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new S03_JButton();
	}
	
}
