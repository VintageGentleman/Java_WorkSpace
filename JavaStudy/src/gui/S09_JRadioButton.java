package gui;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class S09_JRadioButton {

	public static void main(String[] args) {
		JFrame f = new JFrame("Radio Button Example");
		
		JRadioButton btn1 = new JRadioButton("Left");
		JRadioButton btn2 = new JRadioButton("Right");
		
		btn1.setBounds(50,100,100,50);
		btn2.setBounds(150,100,100,50);
		
		// 버튼 그룹 (그룹의 여러 버튼들 중 하나만 선택할 수 있게 된다)
		ButtonGroup group = new ButtonGroup();
		
		group.add(btn1);
		group.add(btn2);

		f.add(btn1);
		f.add(btn2);
		
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
	
}
