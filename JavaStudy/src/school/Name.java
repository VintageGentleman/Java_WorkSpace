package school;

public class Name {
	String firstName;
	String lastName;
	String fullName;

	private static String[] firstNames = {
			"민수", "철수", "희수", "고수", "신수", "성훈", "영희", "민지"
	};
	
	private static String[] lastNames = {
			"김", "이", "박", "최", "고", "윤", "권", "강", "여"
	};
	
	public Name() {
		this(
			firstNames[(int)(Math.random() * firstNames.length)],
			lastNames[(int)(Math.random() * lastNames.length)]
		);
	}
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = lastName + firstName;
	}
	
	// Getter : 원할 때 인스턴스 변수를 꺼내가는 메서드
	public String getFirstName() {
		return firstName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getBlindName() {
		return lastName + "XX";
	}
	
	// Setter : 해당 인스턴스 변수에 원하는 값을 채우는 메서드
	// 해당 인스턴스 변수에 Setter를 만들어두지 않는다는 것은
	// 읽기 전용 클래스 같은 느낌을 줄 수 있다 
	
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
}
