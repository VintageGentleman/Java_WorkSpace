package screen;

import javax.swing.JTextField;

import comp.GeneralBtn;
import comp.GeneralLabel;
import comp.functions.SubmitBtnFunc;
import comp.functions.TextFieldFunc;
import comp.functions.ToFirstBtnFunc;
import properties.Basic;
import properties.GameWord;

public class GameScreen extends DefaultPanel {

	/**
	 * JPanel for GameScreen
	 */
	private static final long serialVersionUID = -9090020901458734904L;

	public JTextField textField;
	public GeneralLabel imageLabel, categoryLabel, scoreLabel, wrongLabel;
	public GeneralBtn submitBtn;
	
	public GameScreen() {
		int x_2 = Basic.HALF_START_X;
		int h_width = Basic.HALF_WIDTH;
		
		GeneralLabel getTextLabel = new GeneralLabel("<html>알파벳만 입력<br>(숫자)는 단어의 길이</html>");
		getTextLabel.setLocation(Basic.LAST);
		
		textField = new JTextField();
		textField.setLocation(x_2, Basic.LAST_Y);
		textField.setSize(h_width/2, height);
		textField.setFont(Basic.HEAD_FONT);
		textField.setHorizontalAlignment(JTextField.CENTER);
		
		submitBtn = new GeneralBtn("입력");
		submitBtn.setLocation(textField.getX() + textField.getWidth() + 5, Basic.LAST_Y);
		submitBtn.setSize(h_width/2 - 5, height);
		submitBtn.addActionListener(new SubmitBtnFunc());
		
		TextFieldFunc keyListener = new TextFieldFunc(textField);
		textField.addKeyListener(keyListener);
		
		imageLabel = new GeneralLabel();
		imageLabel.setLocation(Basic.DEFAULT);
		imageLabel.setSize(h_width, 430);
		
		categoryLabel = new GeneralLabel("카테고리");
		categoryLabel.setLocation(x_2, blank);
		
		scoreLabel = new GeneralLabel("현재 맞춘 글자 보이기");
		scoreLabel.setLocation(x_2, categoryLabel.getY() + height + blank);
		
		wrongLabel = new GeneralLabel();
		wrongLabel.setLocation(x_2, scoreLabel.getY() + height + blank);
		
		GeneralBtn newBtn = new GeneralBtn("처음으로");
		newBtn.setSize(Basic.HALF_COMP_SIZE);
		newBtn.setLocation(x_2, wrongLabel.getY() + height + blank);
		newBtn.addActionListener(new ToFirstBtnFunc());
		
		add(imageLabel);
		add(categoryLabel);
		add(scoreLabel);
		add(wrongLabel);
		add(getTextLabel);
		add(textField);
		add(submitBtn);
		add(newBtn);
	}
	
	/** scoreLabel에 underbar 채움 */
	public void setScoreLabel() {
		StringBuilder sb = new StringBuilder();
		
		int len = GameWord.nowWord.length();
		
		for(int i = 0; i < len; ++i) {
			sb.append('_');
		}
		
		sb.append(String.format(" (%d)", len));
		
		scoreLabel.setText(sb.toString());
	}
	
}
