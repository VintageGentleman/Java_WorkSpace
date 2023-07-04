package database.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class J03_PotterWheel_T {
	
	/*
	  	# 경품 추첨 이벤트를 구현해보세요
	  	
	  	(1) DB에 경품들의 이름, 당첨 확률, 남은 수량 등을 저장할 수 있는
	  		테이블이 존재해야 한다
	  		
	   	(2) 콘솔에서 뽑기를 진행하면 실제로 DB에서 수량이 줄어들어야 한다
	   	
	   	(3) 상품이 모두 소진되면 프로그램이 종료되어야 한다
	   	
	   	(4) 리셋 기능을 실행하면 DB의 상품이 다시 충전 된다
	*/
	
	private int potter_size = 1000;
	private PotterWheelDAO dao = new PotterWheelDAO();
	private List<Prize> potter = new ArrayList<>(potter_size);
	
	public J03_PotterWheel_T() {
		List<Prize> prizes = dao.getAllPrizes();
		
		int cnt = 0;
		for(Prize prize : prizes) {
			int num = (int)(prize.getPrize_rate() * potter_size);
			for(int i = 0; i < num; ++i) {
				potter.add(prize);
				cnt++;
			}
		}
		
		while (cnt++ < potter_size) {
			potter.add(null);
		}
		
		Collections.shuffle(potter);
	}
	
	public Prize wheel() {
		int size = potter.size();

		Prize prize = potter.get((int)(Math.random() * size));
		
		if(prize != null) {
			int row = dao.minusQty(prize.getPrize_id());
			
			// row가 0이라면 수량이 다 소진되었다는 의미이므로 prize를 꽝으로 바꿔준다
			if (row == 0) {
				prize = null;
			}
		}
		
		return prize;
	}

	// 남은 수량이 있는지 없는지 체크하는 메서드
	public boolean checkRemain() {
		return dao.getRemainCount() > 0;
	}

	public void reset() {
		dao.resetQty();
	}
	
	public static void main(String[] args) {
		J03_PotterWheel_T potterWheel = new J03_PotterWheel_T();
		
		for(int i = 0; i < 50; ++i) {
			Prize prize = potterWheel.wheel();
			
			if(prize == null) {
				System.out.println("꽝입니다.");
			} else {
				System.out.println(prize.getPrize_name() + "을(를) 뽑았습니다!");
			}
			
			if(!potterWheel.checkRemain()) {
				System.out.println("===상품이 모두 소진되었습니다.");
				potterWheel.reset();
				break;
			}
		}
	}
	
}
