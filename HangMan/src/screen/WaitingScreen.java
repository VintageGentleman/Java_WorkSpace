package screen;

import javax.swing.JLabel;

import comp.GeneralBtn;
import comp.functions.StartBtnFunc;
import properties.Basic;

public class WaitingScreen extends DefaultPanel {

	/**
	 * JPanel for WaitingScreen
	 */
	private static final long serialVersionUID = -7587785271523525985L;

	public WaitingScreen() {
		JLabel headLabel = new JLabel("HANG MAN");
		headLabel.setLocation(Basic.DEFAULT);
		headLabel.setSize(width, 320);
		Basic.setImage(headLabel, "images/_last.png", width, 250);
		headLabel.setHorizontalTextPosition(JLabel.CENTER);
		headLabel.setVerticalTextPosition(JLabel.BOTTOM);
		headLabel.setFont(Basic.HEAD_FONT);
		
		GeneralBtn startBtn = new GeneralBtn("게임시작");
		startBtn.setLocation(blank, headLabel.getY() + headLabel.getHeight() + blank);
		startBtn.addActionListener(new StartBtnFunc());
		
		GeneralBtn outBtn = new GeneralBtn("나가기");
		outBtn.setLocation(Basic.LAST);
		outBtn.addActionListener(e -> Basic.frame.dispose());
		
		add(headLabel);
		add(startBtn);
		add(outBtn);
	}
	
}
