package gui.quiz.register_T;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class IdTextField extends JTextField {

	private static final long serialVersionUID = 1445492608954427966L;

	private boolean valid;
	
	
	public IdTextField(JLabel stateLabel) {
		// KeyListener의 모든 메서드를 구현하고 싶지 않을 때 사용하는 클래스
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// Ctrl, Shift 등 KeyChar가 아닌 경우에는 이벤트를 무시
				if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {
					return;
				}
				
				// 입력된 값이 영어와 숫자로만 이루어져 있지 않으면 state 메세지를 변경
				String text = ((JTextField)e.getComponent()).getText();
				
				if(Pattern.matches("[a-zA-Z0-9]+", text)) {
					stateLabel.setForeground(new Color(0x1d6309));
					stateLabel.setText("사용가능");
					valid = true;
				} else {
					stateLabel.setForeground(Color.RED);
					stateLabel.setText("사용 불가능");
					valid = false;
				}
			}
		});
	}
	
	public boolean isValid() {
		return valid;
	}
	
}
