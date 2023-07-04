package screen;

import java.awt.Color;

import comp.GeneralBtn;
import comp.GeneralLabel;
import comp.functions.RestartBtnFunc;
import comp.functions.ToFirstBtnFunc;
import properties.Basic;

public class ResultScreen extends DefaultPanel {

	/**
	 * JPanel for ResultScreen
	 */
	private static final long serialVersionUID = 7207040489768307810L;

	public static final int LOSE = 0;
	public static final int WIN = 1;
	
	public GeneralLabel resultLabel, solutionLabel;
	
	public ResultScreen() {
		resultLabel = new GeneralLabel("승패결과");
		resultLabel.setHorizontalAlignment(GeneralLabel.CENTER);
		resultLabel.setLocation(Basic.DEFAULT);
		resultLabel.setSize(width, 210);
		resultLabel.setFont(Basic.HEAD_FONT2);
		
		solutionLabel = new GeneralLabel("정답글자");
		solutionLabel.setHorizontalAlignment(GeneralLabel.CENTER);
		solutionLabel.setSize(Basic.GENERAL_COMP_SIZE);
		solutionLabel.setLocation(blank, resultLabel.getY() + resultLabel.getHeight() + blank); 
		
		GeneralBtn regameBtn = new GeneralBtn("다시하기");
		regameBtn.setLocation(blank, solutionLabel.getY() + solutionLabel.getHeight() + blank);
		regameBtn.addActionListener(new RestartBtnFunc());
		
		GeneralBtn outBtn = new GeneralBtn("처음으로");
		outBtn.setLocation(Basic.LAST);
		outBtn.addActionListener(new ToFirstBtnFunc());
		
		add(outBtn);
		add(regameBtn);
		add(solutionLabel);
		add(resultLabel);
	}

	/** 결과표시창의 내용을 바꿈 */
	public void setResult(int result) {
		if(result == LOSE) {
			resultLabel.setText("YOU LOSE");
			resultLabel.setForeground(Color.RED);
		} else {
			resultLabel.setText("YOU WIN");
			resultLabel.setForeground(Color.BLUE);
		}
	}
	
}
