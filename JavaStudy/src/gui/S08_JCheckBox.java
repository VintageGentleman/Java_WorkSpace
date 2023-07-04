package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class S08_JCheckBox {

	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox example");

		JLabel lang = new JLabel("What is your language?");
		
		JCheckBox box1 = new JCheckBox("Java");
		JCheckBox box2 = new JCheckBox("Python");
		JCheckBox box3 = new JCheckBox("C++");

		JButton btn = new JButton("Check!");
		
		lang.setBounds(50,100,300,30);
		box1.setBounds(50,150,100,50);
		box2.setBounds(50,200,100,50);
		box3.setBounds(50,250,100,50);
		btn.setBounds(50,330,100,30);
		
		f.add(lang);
		f.add(box1);
		f.add(box2);
		f.add(box3);
		f.add(btn);

		ItemListener listener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(((JCheckBox)e.getSource()).getText() + " 버튼이 방금 변경되었습니다..");
			}
		};
		
		// 체크박스 컴포넌트의 상태가 변경될 때마다 발생하는 이벤트
		box1.addItemListener(listener);
		box2.addItemListener(listener);
		box3.addItemListener(listener);
		
		// 선택된 것으로 설정 (아이템 리스너 발동시킴)
		box2.setSelected(true);
		
		// 프로그램적으로 클릭 발생시키기 (아이템 리스너 발동시킴)
		box3.doClick();
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Java? " + box1.isSelected());
				System.out.println("Python? " + box2.isSelected());
				System.out.println("C++? " + box3.isSelected());
			}
		});
		
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
	
}
