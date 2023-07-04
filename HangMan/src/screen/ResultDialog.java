package screen;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import comp.GeneralBtn;
import comp.GeneralLabel;
import properties.Basic;

public class ResultDialog extends JDialog {

	/**
	 * JDialog for ResultDialog
	 */
	private static final long serialVersionUID = -5969086030352889215L;

	public ResultDialog(int result) {
		setTitle("결과");
		setLayout(new GridLayout(2, 1));
		
		GeneralLabel textLabel = new GeneralLabel();
		
		GeneralBtn nextBtn = new GeneralBtn("최종결과창으로");
		nextBtn.addActionListener(e -> {
			dispose();
			
			Basic.card.show(Basic.frame.getContentPane(), "resultScreen");
		});
		
		if(result == ResultScreen.LOSE) {
			textLabel.setText("당신의 패배입니다");
			Basic.frame.result.setResult(ResultScreen.LOSE);
		} else {
			textLabel.setText("당신의 승리입니다");
			Basic.frame.result.setResult(ResultScreen.WIN);
		}
		
		add(textLabel);
		add(nextBtn);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				nextBtn.doClick();
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) nextBtn.doClick();
			}
		});
		
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(Basic.frame);
		setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
}
