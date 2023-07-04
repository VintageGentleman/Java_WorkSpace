import myobj2.DataScienceStudent;
import myobj2.Student;

public class C16_AbstractClass {

	/*
	  	# 추상 클래스 (abstract class)
	  	
	  	- 추상 메서드를 가지고 있는 클래스
	  	- 추상 클래스 내부에는 완성되지 않은 메서드가 들어있으므로
	  	  인스턴스를 생성할 수 없다
	  	
	  	
	  	# 추상 메서드 (abstract method)
	  	
	  	- 선언만 해놓고 구현은 상속받은 자식들에게 미루는 메서드
	  	- 오버라이드를 위한 메서드
	  	- 자식 클래스에게 오버라이드를 강제하는 효과가 있다
	*/
	
	public static void main(String[] args) {
		Student s = new DataScienceStudent();
		
		// 반드시 오버라이드 해야 하는 메서드를 쉽게 눈치챌 수 있다
		Student s2 = new Student() {
			@Override
			public void info() {
				System.out.println("즉석에서 상속받아 구현해버린 학생입니다.");
			}
		};
		
		s.info();
		s2.info();
	}
}
