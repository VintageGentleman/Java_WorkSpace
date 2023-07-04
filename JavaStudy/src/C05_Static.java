import myobj.*;

public class C05_Static {
	
	/*
	  	# static (정적 영역, 클래스 영역 <==> 인스턴스 영역)
	  	
	  	- 인스턴스 영역의 반대되는 개념이다
	  	- 같은 클래스의 모든 인스턴스들이 함께 사용하는 공동 영역을
	  	  정적 영역(클래스 영역)이라고 한다
	  	- 앞에 static이 붙은 자원들은 모든 인스턴스들이 함께 사용하는
	  	  공동 자원이 된다
	*/
	
	public static void main(String[] args) {
		
		Sword s1 = new Sword("녹슨 검");
		Sword s2 = new Sword("여행자의 검");
		
		for (int i = 0; i < 8; ++i) {
			s1.swing();
		}
		
		System.out.println("칼1의 내구도 " + s1.durability);
		System.out.println("칼2의 내구도 " + s2.durability);
		
		s1.attack = 55;
		
		System.out.println(s1.attack);
		System.out.println(s2.attack);
		
		// myobj 패키지에 static 자원을 포함한 클래스를 하나 설계해보세요
		
		GhostType ghost = new GhostType("witch", 200);
		
		ghost.info();

		ghost.beAttacked(100, "물리");
		
		ghost.attack(100);
		
		ghost.beAttacked(200, "마법");
		
		ghost.info();
				
	}

}
