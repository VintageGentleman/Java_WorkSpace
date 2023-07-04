package gui.quiz.register;

import javax.swing.JPasswordField;

public class R_Password extends JPasswordField {

	private static final long serialVersionUID = -1619251889398145457L;

	boolean checkup;
	
	public R_Password(int x, int y, int width, int height) {
		setBounds(x, y, width, height);
	}
	
	public boolean isCheckup() {
		return checkup;
	}
	
	public void setCheckup(boolean result) {
		checkup = result;
	}
	
}
