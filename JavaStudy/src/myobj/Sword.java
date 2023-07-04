package myobj;

public class Sword {

	public int attack = 10;
	
	String name;
	public int durability;
	
	public Sword(String name) {
		this.name = name;
		durability = 10;
	}
	
	/** 이 칼을 휘두른다 (내구도 -1) */
	public void swing() {
		if (--durability == 0) {
			System.out.println("\"" + this.name + "\"이(가) 파괴되었습니다!");
		} else {
			System.out.println("\"" + this.name + "\"을(를) 휘둘렀습니다.");
		}
	}
}
