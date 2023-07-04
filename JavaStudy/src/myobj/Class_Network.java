package myobj;

public class Class_Network extends School_Class {
	int scoreLinux;
	int scoreNetwork;
	int scoreCCNA;
	
	public Class_Network() {
		super();
		scoreLinux = setRandomScore();
		scoreNetwork = setRandomScore();
		scoreCCNA = setRandomScore();
		calTotalScore();
		calAverage();
		this.grade = calGrade();
	}
	
	@Override
	public String toString() {
		String answer = String.format("국어 %3d 영어 %3d 리눅스 %3d 네트워크 %3d CCNA %3d\t ",
				scoreKorean, scoreEnglish, scoreLinux, scoreNetwork, scoreCCNA);
		return answer;
	}
	
	@Override
	void calTotalScore() {
		super.calTotalScore();
		totalScore += scoreLinux + scoreNetwork + scoreCCNA;
	}
	
	@Override
	void calAverage() {
		scoreAverage = totalScore / 5.0;
	}
	
	@Override
	char calGrade() {
		return super.calGrade();
	}

}
