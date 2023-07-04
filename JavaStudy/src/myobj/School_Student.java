package myobj;

public class School_Student {
	School_Class classType; 
	String name;
	int number;
	String studentNum;
	static int index = 1;
	
	public School_Student() {
		selectClass();
		this.name = setName();
		setStudentNum();
	}

	public void showReportCard() {
		System.out.printf("[%s/%s/%s/%3d/%.2f/%c]\n",
				studentNum, name, classType, classType.getTotalScore(),
				classType.getScoreAverage(), classType.getGrade());
	}
	
	public void setStudentNum() {
		if(index < 10) {
			this.studentNum = "EZEN-00" + index++;
		} else if(index < 100) {
			this.studentNum = "EZEN-0" + index++;
		} else {
			this.studentNum = "EZEN-" + index++;
		}
	}
	
	private String setName() {
		String name = "";
		String familyName = "김이박최정조강윤장임한전권신강송오서황문양고"; 
		String firstName = "가인철수영희기태종범자구나민준서도윤예시우하주원지호후우건현";
		for(int i = 0; i < 3; ++i) {
			int random = (int)(Math.random() * familyName.length());
			int random2 = (int)(Math.random() * familyName.length());
			if(i == 0) {
				name += familyName.charAt(random);
			} else {
				name += firstName.charAt(random2);
			}
		}
		return name;
	}
	
	private void selectClass() {
		int random = (int)(Math.random() * 3);
		switch(random) {
		case 0:
			this.classType = new Class_Programming();
			break;
		case 1:
			this.classType = new Class_Network();
			break;
		case 2:
			this.classType = new Class_MachineLearning();
			break;
		}
	}
	
}
