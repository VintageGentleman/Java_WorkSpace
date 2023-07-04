package gui.quiz.gugudan;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class GugudanButton extends JButton {
	
	int dan = 2;
	int gop;
	
	public GugudanButton(int gop) {
		this.gop = gop;
		
		setSize(200, 50);
		setLocation(50, 50 + 60 * (gop - 1));
		
		update();
	}
	
	public void setDan(int dan) {
		if(dan > 9 || dan < 2) {
			return;
		}
		
		this.dan = dan;
		update();
	}
	
	private void update() {
		setText(String.format("%d x %d = %d", dan, gop, dan * gop));
	}

	public int getDan() {
		return dan;
	}	
	
}
