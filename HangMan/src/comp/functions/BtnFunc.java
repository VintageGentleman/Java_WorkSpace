package comp.functions;

import java.awt.event.ActionListener;

import comp.GeneralLabel;
import properties.Basic;
import properties.GameWord;
import properties.HangMan;
import screen.GameScreen;

public abstract class BtnFunc implements ActionListener {

	/** 대기화면으로 나갈 때 초기화 동작을 하는 메서드 */
	protected void toFirstFunc() {
		HangMan.life = HangMan.DEFAULT_LIFE;
		GameWord.setRanWord();
		Basic.frame.game.wrongLabel.setText("");
	}
	
	/** 게임 시작 버튼을 눌렀을 때 이루어져야 하는 설정을 하는 메서드 */
	protected void startFunc() {
		GameScreen game = Basic.frame.game;
		GeneralLabel imageLabel = game.imageLabel;
		
		game.setScoreLabel();
		game.categoryLabel.setText(GameWord.nowCategory);
		Basic.setImage(imageLabel, HangMan.HANGMAN_IMAGE[HangMan.DEFAULT_LIFE] , imageLabel.getWidth(), imageLabel.getHeight());
		Basic.card.show(Basic.frame.getContentPane(), "gameScreen");
		Basic.frame.result.solutionLabel.setText("정답 : " + GameWord.nowWord);
	}
	
}
