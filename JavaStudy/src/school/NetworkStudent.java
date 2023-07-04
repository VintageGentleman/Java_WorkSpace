package school;

public class NetworkStudent extends Student {
	// 국어, 영어, 리눅스, 네트워크, CCNA
	int kor;
	int eng;
	int linux;
	int network;
	int ccna;
	
	public NetworkStudent() {
		kor = getRandomScore();
		eng = getRandomScore();
		linux = getRandomScore();
		network = getRandomScore();
		ccna = getRandomScore();
		subName = "Network Management";
	}
	
	@Override
	public void info() {
		// [학번/이름/과목별점수/총점/평균/등급]
		System.out.println("#### NetworkStudent ####");
		System.out.printf("학번\t:%s\n", this.stuId);
		System.out.printf("이름\t:%s\n", name.getFullName());
		System.out.printf("국어\t:%d\n", kor);
		System.out.printf("영어\t:%d\n", eng);
		System.out.printf("리눅스\t:%d\n", linux);
		System.out.printf("네트워크\t:%d\n", network);
		System.out.printf("CCNA\t:%d\n", ccna);
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
		return kor + eng + linux + network + ccna;
	}
	
	public double getAvg() {
		return getTotal() / 5.0;
	}
}
