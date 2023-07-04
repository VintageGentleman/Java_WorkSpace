package gui.quiz.register_T;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PwChkField extends JPasswordField {

	/** JPasswordField for S07_Register_T */
	private static final long serialVersionUID = -4225562397058520291L;

	public PwChkField(PwField pwField, JLabel stateLabel) {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!pwField.getIsValid()) {
					stateLabel.setForeground(Color.RED);
					stateLabel.setText("확인전에 올바른 비밀번호를 입력해주세요");
					return;
				}
				
				if(Arrays.equals(pwField.getPassword(), getPassword())) {
					stateLabel.setForeground(new Color(0x1d6309));
					stateLabel.setText("확인");
				} else {
					stateLabel.setForeground(Color.RED);
					stateLabel.setText("불일치");
				};
			}
		});
	}
	
}
