package comp.functions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import properties.Basic;

public class TextFieldFunc extends KeyAdapter {

	JTextField textField;
	
	public TextFieldFunc(JTextField textField) {
		this.textField = textField;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			Basic.frame.game.submitBtn.doClick();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		int len = textField.getText().length();
		
		if(len >= 1) {
			e.consume();
		}
	}
}
