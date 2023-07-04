package myobj;

public class FishBread2 {

	static String[] tastes = {"팥", "슈크림", "초코"};
	static int[] prices = {800, 1000, 1200};
	static String[] qualityNames = {"상급 붕어빵", "중급 붕어빵", "하급 붕어빵"};
	static int[] qualityPrices = {50, 0, -50};
			
	String taste;
	int price;
	int quality;
	
	/** 맛과 품질을 랜덤으로 결정 */
	public FishBread2() {
		int type = (int)(Math.random() * tastes.length);
		this.taste = tastes[type];
		this.price = prices[type];
		this.quality = (int)(Math.random() * qualityNames.length);
	}
	
	/** 맛과 품질을 직접 설정 */
	public FishBread2(String taste, int price, int quality) {
		this.taste = taste;
		this.price = price;
		this.quality = quality;
	}
	
	public int getPrice() {
		return this.price + qualityPrices[this.quality];
	}

	public void info() {
		System.out.printf("(%s, %d, %s)\n", 
				taste, getPrice(), qualityNames[quality]);
	}
}
