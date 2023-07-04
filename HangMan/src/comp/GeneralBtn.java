package comp;

import javax.swing.JButton;

import properties.Basic;

public class GeneralBtn extends JButton {

	/**
	 * JButton for GeneralBtn
	 */
	private static final long serialVersionUID = 7768145482827794016L;	
	
	public GeneralBtn(String text) {
		super(text);
		
		setFocusable(false);
		setFont(Basic.BTN_FONT);
		setBackground(Basic.BTN_COLOR);
		setSize(Basic.GENERAL_COMP_SIZE);
	}
}
