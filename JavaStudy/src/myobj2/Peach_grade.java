package myobj2;

import java.util.Comparator;

public class Peach_grade implements Comparator<Peach> {
	@Override
	public int compare(Peach o1, Peach o2) {
		int ch1 = o1.grade;
		int ch2 = o2.grade;
		
		if(ch1 == ch2) {
			return o2.price - o1.price;
		}
		
		return ch1 - ch2;
	}
}

