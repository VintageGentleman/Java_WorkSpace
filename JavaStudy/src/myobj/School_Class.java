package myobj;

public class School_Class {
	int scoreKorean;
	int scoreEnglish;
	int totalScore;
	double scoreAverage;
	char grade;
	
	public School_Class() {
		this.scoreKorean = setRandomScore();
		this.scoreEnglish = setRandomScore();
		calTotalScore();
		calAverage();
		this.grade = calGrade();
	}
	
	int setRandomScore() {
		return (int)(Math.random() * 101);
	}
	
	char calGrade() {
		if(scoreAverage >= 90) {
			return 'A';
		} else if(scoreAverage >= 80) {
			return 'B';
		} else if(scoreAverage >= 70) {
			return 'C';
		} else if(scoreAverage >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}
	
	void calTotalScore() {
		this.totalScore = scoreKorean + scoreEnglish;
	}
	
	void calAverage() {
		this.scoreAverage = totalScore / 2.0;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public double getScoreAverage() {
		return scoreAverage;
	}
	
	public char getGrade() {
		return grade;
	}
}
