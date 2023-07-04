package myobj;

public class Class_MachineLearning extends School_Class {
	int scoreMath;
	int scoreStatistics;
	int scorePL;
	int scoreNO_SQL;
	
	public Class_MachineLearning() {
		super();
		scoreMath = setRandomScore();
		scoreStatistics = setRandomScore();
		scorePL = setRandomScore();
		scoreNO_SQL = setRandomScore();
		calTotalScore();
		calAverage();
		this.grade = calGrade();
	}
	
	@Override
	public String toString() {
		String answer = String.format("국어 %3d 영어 %3d 수학 %3d 통계학 %3d PL %3d NO-SQL %3d ",
				scoreKorean, scoreEnglish, scoreMath, scoreStatistics, scorePL, scoreNO_SQL);
		return answer;
	}
	
	@Override
	void calTotalScore() {
		super.calTotalScore();
		totalScore += scoreMath + scoreStatistics + scorePL + scoreNO_SQL;
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
