package gui;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class S16_CardLayout {

	/*
	  	다음 카드로 넘기듯이 컴포넌트를 넘기면서 보여줄 수 있는 레이아웃
	  	ex> 설치 프로그램의 다음.. 다음..
	*/
	
	public static void main(String[] args) {
		JFrame f = new JFrame("CardLayout ...");
		
		CardLayout card = new CardLayout();
		f.setLayout(card);
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("<html>우리 설치 프로그램에 오신 것을 환영합니다.."
				+ "<br>다음 버튼을 눌러주세요..</html>");
		JButton button1 = new JButton("다음");
		
		label1.setBounds(30,100,300,80);
		button1.setBounds(300,300,100,40);
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 카드 레이아웃을 조정할 때는 해당 레이아웃의
				// 부모 컨테이너가 누구인지 전달해줘야 한다
				card.next(f.getContentPane());
			}
		});
		
		panel1.setLayout(null);
		panel1.add(label1);
		panel1.add(button1);
		
		JPanel panel2 = new JPanel();
		
		panel2.setLayout(new GridLayout(2,2));
		
		panel2.add(new JButton("Button 1"));
		panel2.add(new JButton("Button 2"));
		panel2.add(new JButton("이전으로") {
			/** temparate setting for JButton where S16_CardLayout class*/
			private static final long serialVersionUID = 4386623966310760378L;
			{
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 카드 레이아웃의 이전 컴포넌트로 이동하기
						// card.previous(f.getContentPane());
						
						// 카드 레이아웃의 첫 번째 컴포넌트로 이동하기
						// card.first(f.getContentPane());
						
						// 카드 레이아웃의 원하는 카드로 이동하기
						// (이 때 add할 때 사용한 name을 사용)
						card.show(f.getContentPane(), "p1");
					}
				});
			}
		});
		panel2.add(new JButton("Button 4"));
		
		JPanel panel3 = new JPanel();
		
		// 카드 레이아웃에 컴포넌트를 붙일 때는 이름을 설정해야 한다
		// (show())할 때 사용
		f.add("p1", panel1);
		f.add("p2", panel2);
		f.add("p3", panel3);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
	
}
