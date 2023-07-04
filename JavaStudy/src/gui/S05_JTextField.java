package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class S05_JTextField extends JFrame {

	private static final long serialVersionUID = -5802231493230049310L;

	// 직접 입력이 가능한 텍스트칸 컴포넌트
	public S05_JTextField() {
		JTextField tf = new JTextField("Hello, text!");
		
		tf.setBounds(50, 50, 300, 50);
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("현재 입력되어 있는 것: "
				//	 	+ tf.getText());
			
				// # ActionEvent의 메서드들
				
				// getActionCommand() : 해당 이벤트 액션과 관련된 값을 가져온다
				System.out.println(e.getActionCommand());
				
				// getSource() : 이벤트가 발생한 해당 컴포넌트를 반환한다
				JTextField field = (JTextField) e.getSource();
				
				System.out.println(field.getText());
				
				// getWhen() : 이벤트 발생 시각을 알려준다
				System.out.println(new Date(e.getWhen()));
			}
		});
		
		add(tf);
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new S05_JTextField();
		
	}
	
}
