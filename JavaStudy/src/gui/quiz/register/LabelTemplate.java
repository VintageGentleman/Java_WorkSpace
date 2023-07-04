package gui.quiz.register;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelTemplate extends JLabel {

	private static final long serialVersionUID = -6898945804021033005L;

	public static final int GENERAL = 0;
	public static final int HEAD = 1;
	public static final int ISPASS = 2;
	
	public LabelTemplate create(int type, String text) {
		LabelTemplate lb = new LabelTemplate();
		
		lb.setText(text);
		
		if(type == GENERAL) {
			lb.setSize(50, 30);
			lb.setFont(new Font("굴림", Font.PLAIN, 12));
			
			return lb;
		}
		
		if(type == HEAD) {
			lb.setSize(150, 50);
			
			lb.setFont(new Font("굴림", Font.BOLD, 30));
			lb.setHorizontalAlignment(SwingConstants.CENTER);
			return lb;
		}
		
		if(type == ISPASS) {
			lb.setSize(200, 20);
			
			lb.setFont(new Font("굴림", Font.BOLD, 11));
			lb.setHorizontalAlignment(SwingConstants.LEADING);
			lb.setForeground(new Color(224, 32, 25));
			return lb;
		}
		
		return null;
	}
}
