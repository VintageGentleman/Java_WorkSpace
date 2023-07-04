package myobj;

public class Class_Programming extends School_Class {
	int scoreMath;
	int scorePL;
	int scoreOS;
	int scoreDS;
	
	public Class_Programming() {
		super();
		scoreMath = setRandomScore();
		scorePL = setRandomScore();
		scoreOS = setRandomScore();
		scoreDS = setRandomScore();
		calTotalScore();
		calAverage();
		this.grade = calGrade();
	}

	@Override
	public String toString() {
		String answer = String.format("국어 %3d 영어 %3d 수학 %3d PL %3d OS %3d DS %3d\t ",
				scoreKorean, scoreEnglish, scoreMath, scorePL, scoreOS, scoreDS);
		return answer;
	}
	
	@Override
	void calTotalScore() {
		super.calTotalScore();
		totalScore += scoreMath + scorePL + scoreOS + scoreDS;
	}
	
	@Override
	void calAverage() {
		scoreAverage = totalScore / 6.0;
	}
	
	@Override
	char calGrade() {
		return super.calGrade();
	}
}
