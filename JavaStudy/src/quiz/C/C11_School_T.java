package quiz.C;

import school.*;

public class C11_School_T {
	
	/*
	  	1. 프로그래밍 반 학생들은 각자의
	  	   국어, 영어, 수학, 프로그래밍 언어, 운영체제, 자료구조 점수가 있다
	  	   
	  	2. 네트워크 반 학생들은 각자의
	  	   국어, 영어, 리눅스, 네트워크, CCNA 점수가 있다
	  	
	  	3. 머신러닝 반 학생들은 각자의
	  	   국어, 영어, 수학, 통계학, 프로그래밍 언어, NO-SQL 점수가 있다
	  	   
	  	4. 100명의 학생을 랜덤으로 생성한다.
	  	   모든 학생의 소속 반, 과목별 점수, 이름이 랜덤으로 생성되어야 하고,
	  	   학생들의 학번은 중복없이 순차적으로 생성되어야 한다
	  	   
	  	5. 성적표 출력 메서드를 통해 각 학생의
	  	   [학번/이름/과목별점수/총점/평균/등급]을 볼 수 있다
	*/

	// main : 각 클래스의 스타트 지점
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// 부모 클래스에 자식 인스턴스를 넣는다 (업캐스팅)
		Student s1 = new Student();
		Student s2 = new ProgrammingStudent(); 
		Student s3 = new MachineLearningStudent();
		Student s4 = new NetworkStudent();
		
		// 인스턴스 (new를 통해서 실제로 생성된 것 또는 주소값)
		ProgrammingStudent p = new ProgrammingStudent();
		MachineLearningStudent m = new MachineLearningStudent();
		
		Student s = p;
		Student ss = new Student();
		
		// ProgrammingStudent[] pArr = {s, ss, m};
		
		Student[] arr = {
				new ProgrammingStudent(),
				new ProgrammingStudent(),
				p, m
		};
		
		// Student 배열에 Student의 자식들은 모두 들어갈 수 있다
		Student[] students = new Student[100];
		
		for (int i = 0; i < students.length; ++i) {
			Student stu;
			
			switch((int)(Math.random() * 3)) {
			case 0:
				stu = new ProgrammingStudent();
				break;
			case 1:
				stu = new NetworkStudent();
				break;
			default:
				stu = new MachineLearningStudent();
				break;
			}
			
			students[i] = stu;
			
			// 업캐스팅과 오버라이드를 이용하면 각 클래스마다 구현이 다른 메서드를
			// 똑같은 이름으로 사용할 수 있다
			stu.info();
		}
		
	}
	
}
