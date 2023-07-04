package myobj;

public class GiftList {
	// giftName의 0번 인덱스 값은 항상 "꽝"에 해당하는 값이어야 한다 
	static String[] giftName = {"꽝", "노트북", "태블릿", "휴대폰", "모니터암", "터치펜"};
	int[] giftCount = {50, 1, 5, 10, 20, 14};
	int totalGiftCount; 
	
	String[] giftList;

	public GiftList() {
		totalGiftCount = calTotalGiftCount();
		giftList = new String[totalGiftCount];
		int index = 0;
		for(int i = 0; i < giftName.length; ++i) {
			for(int k = 0; k < giftCount[i]; ++k) {
				giftList[index++] = giftName[i];
			}
		}
	}
	
	public void calRate() {
		System.out.println("현재 상품 당첨 확률");
		for(int i = 0; i < giftName.length; ++i) {
			double rate = giftCount[i] / (double) totalGiftCount;  
			System.out.printf("%s : %.2f%%\n", giftName[i], rate * 100);
		}
		System.out.println();
	}
	
	public void drawGift() {
		int lotteryNumber = turnTable();
		System.out.println(giftList[lotteryNumber] + "을(를) 뽑으셨습니다\n");
		int index = 0;
		for(int i = 0; i < giftName.length; ++i) {
			if(giftList[lotteryNumber].equals(giftName[i])) {
				index = i;
			}
		}
		--giftCount[index];
		++giftCount[0];
		giftList[lotteryNumber] = giftList[0];
	}

	public void getRemainGift() {
		int len = giftName.length;
		int[] remainGift = new int[len];
		for(int i = 0; i < len; ++i) {
			int count = 0;
			for(int j = 0; j < giftList.length; ++j) {
				if(giftName[i].equals(giftList[j])) {
					++count;
				}
			}
			remainGift[i] = count;
		}
		System.out.println("현재 남은 상품의 개수는");
		int totalCount = 0;
		for(int i = 1; i < len; ++i) {
			System.out.printf("%s : %d\n", giftName[i], remainGift[i]);
			totalCount += remainGift[i];
		}
		System.out.println("Total : " + totalCount);
		System.out.println();
	}
	
	private int turnTable() {
		return (int)(Math.random() * totalGiftCount);
	}
	
	private int calTotalGiftCount() {
		int temp = 0;
		for(int i = 0; i < giftCount.length; ++i) {
			temp += giftCount[i];  
		}
		return temp;
	}
}
