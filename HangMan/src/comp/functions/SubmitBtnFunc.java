package comp.functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import comp.GeneralLabel;
import properties.*;
import screen.*;

public class SubmitBtnFunc implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GameScreen parent = Basic.frame.game;
		String str = parent.textField.getText();
		
		if(str.equals("")) return;
		
		parent.textField.setText("");
		
		if(!str.matches("[a-zA-Z]")) {
			JOptionPane.showMessageDialog(parent, String.format("알파벳만 입력하세요 ('%s')", str), "알파벳 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		char letter = str.charAt(0);

		letter = Character.toLowerCase(letter);
		
		StringBuilder sb = new StringBuilder(parent.scoreLabel.getText());
		
		String answer = GameWord.nowWord;
		
		boolean correct = false;
		for(int i = 0; i < answer.length(); ++i) {
			if(answer.charAt(i) == letter) {
				sb.setCharAt(i, letter);
				correct = true;
			}
		}
		
		parent.scoreLabel.setText(sb.toString());
		
		if(sb.indexOf("_") == -1) {
			new ResultDialog(ResultScreen.WIN).setVisible(true);
			return;
		}
		
		if(!correct) {
			GeneralLabel imageLabel = parent.imageLabel;
			parent.wrongLabel.setText(parent.wrongLabel.getText() + " " + letter);
			Basic.setImage(imageLabel, HangMan.HANGMAN_IMAGE[--HangMan.life] , imageLabel.getWidth(), imageLabel.getHeight());
	
			if(HangMan.life == 0) {
				new ResultDialog(ResultScreen.LOSE).setVisible(true);
			}
		}
	}

}
