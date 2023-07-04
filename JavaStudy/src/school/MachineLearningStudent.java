package school;

public class MachineLearningStudent extends Student {
	// 국어, 영어, 수학, 통계학, 프로그래밍 언어, NO-SQL
	int kor;
	int eng;
	int math;
	int statistics;
	int pl;
	int noSql;
	
	public MachineLearningStudent() {
		kor = getRandomScore();
		eng = getRandomScore();
		math = getRandomScore();
		statistics = getRandomScore();
		pl = getRandomScore();
		noSql = getRandomScore();
		subName = "Machine Learning";
	}
	
	@Override
	public void info() {
		// [학번/이름/과목별점수/총점/평균/등급]
		System.out.println("#### MachienLearningStudent ####");
		System.out.printf("학번\t:%s\n", this.stuId);
		System.out.printf("이름\t:%s\n", name.getFullName());
		System.out.printf("국어\t:%d\n", kor);
		System.out.printf("영어\t:%d\n", eng);
		System.out.printf("수학\t:%d\n", math);
		System.out.printf("통계학\t:%d\n", statistics);
		System.out.printf("PL\t:%d\n", pl);
		System.out.printf("NO-SQL\t:%d\n", noSql);
		System.out.printf("총합: %d\n", getTotal());
		System.out.printf("평균: %.2f\n", getAvg());
		System.out.printf("등급: %c\n", getGrade());
	}
	
	public char getGrade() {
		double avg = getAvg();
		if(avg >= 90) {
			return 'A';
		} else if(avg >= 80) {
			return 'B';
		} else if(avg >= 70) {
			return 'C';
		} else if(avg >= 60) {
			return 'E';
		} else {
			return 'F';
		}
	}
	
	@Override
	public int getTotal() {
		return kor + eng + math + statistics + pl + noSql;
	}
	
	public double getAvg() {
		return getTotal() / 6.0;
	}
	
}
