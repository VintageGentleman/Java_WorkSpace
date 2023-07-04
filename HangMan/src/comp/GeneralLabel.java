package comp;

import javax.swing.JLabel;

import properties.Basic;

public class GeneralLabel extends JLabel {

	/**
	 * JLabel for GeneralLabel
	 */
	private static final long serialVersionUID = -5960011175055040970L;

	public GeneralLabel() {
		this("");
	}
	
	public GeneralLabel(String text) {
		super(text);
		
		setSize(Basic.HALF_COMP_SIZE);
		setHorizontalAlignment(CENTER);
		setFont(Basic.LABEL_FONT);
	}
	
}
