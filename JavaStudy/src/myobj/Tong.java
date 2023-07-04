package myobj;

public class Tong {

	int[] hole;
	public int count = 0;
	public boolean die = false;
	
	/** 기본 사이즈, 홈 20개 꽝 4개 */
	public Tong() {
		this(20, 4);
	}
	
	
	/** 통에 대해 직접 설정하기 */
	public Tong(int size, int lose) {
		hole = new int[size];
		
		for (int i = 0; i < lose; ++i) {
			hole[i] = -1;
		}
		
		shuffle();
	}
	
	public void shuffle() {
		for (int i = 0; i < 100; ++i) {
			int ran = (int)(Math.random() * hole.length);
			int temp = hole[ran];
			hole[ran] = hole[0];
			hole[0] = temp;
		}
	}
	
	// 한 줄에 10개씩 보여주기
	public void screen() {
		for (int i = 0; i < hole.length; ++i) {
			
			if (hole[i] == 1) {
				System.out.print("[X]\t");
			} else {
				System.out.print("[O]\t");
			}
			
			if (i % 10 == 9) {
				System.out.println();
			}
		}
	}
	
	public void stab(int num) {
		if (hole[num] == -1) {
			++count;
			die = true; // 아저씨를 죽은 상태로 변경
		} else if (hole[num] == 0) {
			++count;
			hole[num] = 1; // 찌른 적 있는 상태로 변경
		} else {
			System.out.println("이미 찌른 곳입니다... 다른 곳을 선택해주세요");
		}
	}
}
