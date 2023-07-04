package myobj;

public class GhostType {

	public static String type = "AstralBody";
	public static boolean physicalTouch = false;
	public static boolean magicalAttack = true;
	public static int attackAmplDegree = 5;
	boolean alive = true;
	String name;
	int hp;
	
	public GhostType() {
		this("GhostType A", 100);
	}
	
	public GhostType(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	public void beAttacked(int damage, String attackType) {
		System.out.printf("%d의 %s데미지가 들어왔습니다\n",
				damage, attackType);
		if (!physicalTouch && attackType.equals("물리")) {
			System.err.println("물리적 공격에는 데미지를 입지 않습니다");
		} else if (attackType.equals("마법")) {
			hp -= damage;
			System.err.println(damage + "의 마법데미지를 입었습니다");
		}
		
		if (hp <= 0) {
			alive = false;
			System.out.println(name + "이(가) 소멸했습니다");
		}
	}
	
	public void attack(int damage) {
		int totalDamage = damage * attackAmplDegree;
		if (!magicalAttack) {
			System.out.println(totalDamage + "의 물리데미지를 입혔습니다!");
		} else {
			System.out.println(totalDamage + "의 마법데미지를 입혔습니다!");
		}
	}
			
	public void info() {
		System.out.printf("개체명: %s, 타입: %s, 체력 %d\n", name, type, hp);
	}
}
