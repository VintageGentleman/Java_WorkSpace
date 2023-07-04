package screen;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import properties.Basic;
import properties.GameWord;

public class MainFrame extends JFrame {

	/**
	 * JFrame for MainFrame
	 */
	private static final long serialVersionUID = -5367605608778134394L;

	public GameScreen game;
	public ResultScreen result;
	
	public MainFrame() {
		setTitle("HANG MAN");
		CardLayout card = new CardLayout();
		setLayout(card);
		
		new Basic(this, card);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("images/icon.jpg");
		setIconImage(img);
		
		new GameWord();
		
		WaitingScreen wait= new WaitingScreen();
		game = new GameScreen();
		result = new ResultScreen();
		
		add(wait, "waitScreen");
		add(game, "gameScreen");
		add(result, "resultScreen");
		
		setSize(Basic.FRAME_SIZE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
