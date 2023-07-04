package gui.quiz.register;

import java.awt.Font;

import javax.swing.JButton;

import gui.quiz.S07_Register_A;

public class Id_Button extends JButton {

	private static final long serialVersionUID = -2782939040306317520L;

	public static int NOTPASS = 0;
	public static int PASS = 1;
	public static int NONE = 2; 
	
	int checkPass = NONE;
	
	public Id_Button(S07_Register_A parents) {
		
		setText("중복확인");
		setSize(80, 30);
		setFont(new Font("굴림", Font.BOLD, 11));
		setHorizontalAlignment(CENTER);
	}
	
	public int isCheckPass() {
		return checkPass;
	}
	
	public void setCheckPass(int checkPass) {
		this.checkPass = checkPass;
	}
}
