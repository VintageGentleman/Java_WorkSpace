package screen;

import javax.swing.JPanel;

import properties.Basic;

public abstract class DefaultPanel extends JPanel {

	/**
	 * JPanel for DefaultPanel
	 */
	private static final long serialVersionUID = 4547206355621623951L;

	int blank = Basic.BLANK;
	int height = Basic.DEFAULT_HEIGHT;
	int width = Basic.DEFAULT_WIDTH;
	
	public DefaultPanel() {
		setLayout(null);
		setBackground(Basic.MAIN_COLOR);
		setSize(Basic.FRAME_SIZE);
	}
	
}
