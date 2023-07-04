package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import myobj.Prize;

public class S10_JComboBox {

	public static void main(String[] args) {
		JFrame f = new JFrame("ComboBox Example");

		Prize[] prizes = new Prize[] {
				new Prize("텀블러", 10000, 100, 0.1),
				new Prize("안마의자", 2000000, 1, 0.01),
				new Prize("손소독제", 5000, 500, 0.3),
		};
		
		// 제네릭 사용 가능
		// 해당 객체의 toString을 호출
		JComboBox<Prize> combo = new JComboBox<>(prizes);
		
		combo.setBounds(50,50,200,30);
		// 항목 추가
		combo.addItem(new Prize("제로콜라", 1000, 10, 0.2));
		
		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("지금 선택된 것: " + e.getItem());
				} else if(e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println("선택해제된 것: " + e.getItem());
				}
			}
		});
		
		f.add(combo);
		
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
}
