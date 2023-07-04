package myobj2;

import java.util.Comparator;

public class Peach_FarmName implements Comparator<Peach> {
	
	@Override
	public int compare(Peach o1, Peach o2) {
		String farm1 = o1.farmName;
		String farm2 = o2.farmName;
		
		if(farm1.equals(farm2)) {
			return o2.taste - o1.taste;
		}
		
		return farm1.compareTo(farm2);
	}
}
