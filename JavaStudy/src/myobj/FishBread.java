package myobj;

public class FishBread {
	
	//tasteType과 typePrice의 length와 index값은 항상 서로 일치해야한다
	public static String[] tasteType = new String[] {"팥", "슈크림", "초코"};
	static int[] typePrice = new int[] {800, 1000, 1200};
	public static String[] gradeType = new String[] {"상", "중", "하"};
	static int[] qualityGap = {100, 0, -100};
	
	public int taste;
	public int grade;
	
	public FishBread() {
		int random1 = (int)(Math.random() * tasteType.length);
		int random2 = (int)(Math.random() * gradeType.length);
		this.taste = random1;
		this.grade = random2;
	}
	
	/**FishBread 배열이 들어오면 배열 내 붕어빵 총 가격을
	   int 형식으로 반환하는 메소드*/
	public int breadPrice(FishBread[] bread) {
		int totalPrice = 0;
		for (int i = 0; i < bread.length; ++i) {
			int breadPrice = 0;
			breadPrice += typePrice[bread[i].taste];
			breadPrice += qualityGap[bread[i].grade];
			totalPrice += breadPrice;
		}		
		return totalPrice;
	}	
	
	/**FishBread 배열이 들어오면 배열 내 붕어빵 타입을 종류별로
	   계산해서 보여주는 메소드*/
	public void breadTypeCount(FishBread[] bread) {
		int[] count = new int[tasteType.length];
		for (int i = 0; i < bread.length; ++i) {
			++count[bread[i].taste];
		}
		for (int i = 0; i < tasteType.length; ++i) {
			System.out.printf("%s맛\t붕어빵: %d개\n", tasteType[i], count[i]);
		}
	}
	
}
