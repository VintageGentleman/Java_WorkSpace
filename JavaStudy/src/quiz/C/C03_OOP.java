package quiz.C;

import java.util.Arrays;

/*
		실제로 존재하는 객체를 하나 참고하여 클래스를 생성한 후
		해당 클래스의 인스턴스를 생성하고 인스턴스의 상태를 출력해보세요
		(단, 인스턴스 변수 3개 이상, 메서드는 2개 이상, 책, 과일 금지)
	*/

class Coffee {
	String name;
	int degree;
	int price;
	
	void addWater(int num) {
		degree -= num;
	}
	
	void addShot(int num) {
		degree += num;
	}
}

class Character {
	String name;
	int age;
	int level;
	String job;
	String[] itemSlot = new String[8];

	public Character(String string, int i, int j, String string2) {
		this.name = string;
		this.age = i;
		this.level = j;
		this.job = string2;
	}

	void levelUp () {
		++level;
	}
	
	void levelDown() {
		--level;
	}
	
	void getItem(String item, int slotNumber) {
		itemSlot[slotNumber] = item;
	}
	
	void listItem() {
		System.out.println(Arrays.toString(itemSlot));
	}
	
}

public class C03_OOP {
	public static void main(String[] args) {
		Character c1 = new Character("철수", 15, 15, "Warrior");
		c1.getItem("빨간포션", 0);
		c1.getItem("파란포션", 1);
		c1.getItem("철제검", 2);
		
		c1.listItem();
		c1.levelUp();
		System.out.println(c1.name);
		System.out.println(c1.job);
		System.out.println(c1.age);
		System.out.println(c1.level);
	}
}
