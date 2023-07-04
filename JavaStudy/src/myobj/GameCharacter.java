package myobj;

import java.util.Arrays;

public class GameCharacter {
	String name;
	int age;
	int level;
	public String job;
	String[] itemSlot = new String[8];

	public GameCharacter() {
		this("사람A", 20, 1, "무직");
	}
	
	public GameCharacter(String name) {
		this(name, 20, 1, "무직");
	}
	
	public GameCharacter(String name, int age, int level, String job) {
		this.name = name;
		this.age = age;
		this.level = level;
		this.job = job;
	}

	public void levelUp () {
		++level;
	}
	
	public void levelDown() {
		--level;
	}
	
	public void getItem(String item, int slotNumber) {
		itemSlot[slotNumber] = item;
	}
	
	public void listItem() {
		System.out.println(Arrays.toString(itemSlot));
	}
	
	public void info() {
		System.out.printf("캐릭명: %s\n나이: %d\n레벨: %d\n직업: %s\n\n",
				name, age, level, job);
	}
	
}