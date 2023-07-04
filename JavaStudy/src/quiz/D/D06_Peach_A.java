package quiz.D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myobj2.Peach;
import myobj2.Peach_grade;
import myobj2.Peach_FarmName;

public class D06_Peach_A {
	
	public static void main(String[] args) {

		List<Peach> peaches = new ArrayList<>();
		
		Collections.addAll(peaches,
				new Peach(1500, 8, 'C', 0.9, "꿀꿀농장"),
				new Peach(1200, 9, 'B', 1.2, "꿀통농장"),
				new Peach(1000, 10, 'A', 1.5, "꿀꿀농장"),
				new Peach(1300, 7, 'B', 0.41, "나비농장"),
				new Peach(1400, 8, 'C', 0.42, "대궐같은농장"));
		
		System.out.println("원본 :\n" + peaches);
		
		Collections.sort(peaches);
		
		System.out.println("기본정렬(무게) :\n" + peaches);
		
		Collections.sort(peaches, new Peach_grade());
		
		System.out.println("기본정렬(등급/가격) :\n" + peaches);
		
		Collections.sort(peaches, new Peach_FarmName());
		
		System.out.println("기본정렬(이름/맛) :\n" + peaches);
	}
}
