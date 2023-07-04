package myobj;

public class PotterWheel {

	Prize[] prizes;
	Prize[] box;
	
	public PotterWheel() {
		prizes = new Prize[5]; 
		
		prizes[0] = new Prize("노트북", 300, 5, 0.001);
		prizes[1] = new Prize("미니 선풍기", 100, 10, 0.002);
		prizes[2] = new Prize("로봇 청소기", 20, 30, 0.01);
		prizes[3] = new Prize("샤프", 0, 300, 0.1);
		prizes[4] = new Prize("물휴지", 0, 1000, 0.3);
		
		updateBox();
	}
	
	public Prize wheel() {
		
		Prize prize = box[(int)(Math.random() * box.length)]; 
		
		if(prize != null) {
			if(prize.qty == 0) {
				return null;
			} else {
				prize.qty--;
			}
		}
		
		return prize;
	}
	
	/** 상품 배열에 새 상품 추가하기 */
	public void addPrize(Prize prize) {
		int len = prizes.length;
		
		// 새 배열의 크기를 1개 증가시킨다
		Prize[] n_prizes = new Prize[len + 1];
		
		// 기존 배열 값을 새 배열로 옮긴다
		for(int i = 0; i < len; ++i) {
			n_prizes[i] = prizes[i];
		}
		
		// 맨 마지막 칸에 새 상품을 추가한다
		n_prizes[len] = prize;
		
		// 방금 새로 만든 배열이 앞으로 상품 배열이 된다
		this.prizes = n_prizes;
		
		// 상품 종류가 변경되었으니 박스를 새로 만들어야 한다
		updateBox();
	}
	
	// 외부에서 박스 업데이트를 신경 쓸 필요없으므로 안보이게 설정한다
	private void updateBox() {
		box = new Prize[1000];
		
		int index = 0;
		
		// 등록된 상품의 종류만큼 반복
		for(int i = 0; i < prizes.length; ++i) {
			// 확률대로 box에 개수를 채워놓는다
			int num = (int) (prizes[i].rate * 1000);
			
			for(int j = 0; j < num; ++j) {
				box[index++] = prizes[i];
			}
		}
	}
	
}
