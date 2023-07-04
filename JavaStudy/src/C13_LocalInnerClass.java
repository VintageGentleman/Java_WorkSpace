import school.ProgrammingStudent;
import school.Student;

public class C13_LocalInnerClass {

	/*
	  	# 지역 내부 클래스 
	  	
	  	- 클래스는 메서드 내부에서도 선언할 수 있다
	  	- 해당 메서드 밖에서는 사용할 수 없는 아주 일시적인 클래스
	  	- 메서드가 끝나면 클래스의 수명도 끝난다
	  	
	  	# 익명 지역 내부 클래스
	  	
	  	- 메서드 내부에서 클래스를 바로 상속받아 사용하는 방식
	  	- 클래스 이름을 지정할 수 없기 때문에 익명 클래스라고 불린다
	*/
	
	public static void main(String[] args) {
		
		Student s = new Student();
		
		// 바로 Student 클래스를 상속받아 마음대로 고쳐버리는 행위
		// 만드는 즉시 업캐스팅이 됨. 다운캐스팅은 클래스 이름이 없어서 불가능
		Student s2 = new Student() {
			@Override
			public int getTotal() {
				return 123;
			}
			
			@Override
			public void info() {
				System.out.println("내가 만든 인포");
			}
		};

		// s는 그냥 Student의 인스턴스이므로 Student에 구현된 동작을 한다
		s.info();
		System.out.println(s.getTotal());
		
		// s2는 Student를 마음대로 오버라이드한 자식 클래스의 업캐스팅이기 때문에
		// 오버라이드 된 동작을 한다
		s2.info();
		System.out.println(s2.getTotal());
		
		// 매개변수로 클래스의 인스턴스를 요구하는 곳에 보낼 수 있는 것
		Student s3 = new Student();
		
		print(s3); // 0. 인스턴스가 담긴 변수
		print(new Student()); // 1. 인스턴스 바로 보내기
		print(new ProgrammingStudent()); // 2. 자식 인스턴스 (다형성)
		print(new Student() {
			public void info() {
				System.out.println("산대특 바리스타 특별 훈련 과정");
			}
		}); // 4. 해당 클래스를 오버라이드한 익명 지역 내부 클래스
		
	}
	
	public static void print(Student s) {
		s.info();
	}
	
	public static int add(int a, int b) {
		// 지역 내부 클래스. add 메서드 없이는 존재할 수 없음.
		@SuppressWarnings("unused")
		class Waffle {
			int price;
			int flavor;
		}
		
		System.out.println(new Waffle());
		
		return a + b;
	}
}
