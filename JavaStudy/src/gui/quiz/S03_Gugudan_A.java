package gui.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class S03_Gugudan_A {
	
	/*
	  	# 실행하면 구구단이 출력되는 GUI 프로그램을 만들어보세요
	  	
	 	(1) 프로그램을 처음 실행하면 구구단 2단이 출력되어 있는 상태로 시작
	 	
	 	(2) + 버튼을 누르면 단이 증가하며 구구단 내용이 바뀜 (최대 9단 까지)
	 	
	 	(3) - 버튼을 누르면 단이 감소하며 구구단 내용이 바뀜 (최소 2단 까지)
	*/
	
	static int dan = 2;
	static JTextArea text;
	
	static {
		text = new JTextArea(gugudan());
		text.setEditable(false);
		text.setFont(new Font("굴림", Font.BOLD, 30));
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Gugudan");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(700,300,350,400);
		
		f.add(text, BorderLayout.CENTER);
		f.add(plusBtn("plus"), BorderLayout.NORTH);
		f.add(minusBtn("minus"), BorderLayout.SOUTH);
		
		f.setVisible(true);
	}
	
	private static String gugudan() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < 10; ++i) {
			sb.append(String.format(
					"%d * %d = %d\n", dan, i, dan * i));
		}
		
		return sb.toString();
	}
		
	private static JButton plusBtn(String name) {
		JButton plusbtn = new JButton(name);
		
		plusbtn.setBackground(new Color(245, 66, 105));
		plusbtn.setFont(new Font("굴림", Font.BOLD, 15));
		
		plusbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dan < 9) {
					++dan;
					text.setText(gugudan());
				} else {
					dan = 10;
					text.setText("dan이 9보다 큼");
				}
			}
		});
		
		return plusbtn;
	}
	
	private static JButton minusBtn(String name) {
		JButton minusbtn = new JButton(name);
		
		minusbtn.setBackground(new Color(48, 91, 219));
		minusbtn.setFont(new Font("굴림", Font.BOLD, 15));
		
		minusbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dan > 2) {
					--dan;
					text.setText(gugudan());
				} else {
					dan = 1;
					text.setText("dan이 2보다 작음");
				}
			}
		});
		
		return minusbtn;
	}
}
