package database.quiz;

// Model 역할을 하는 클래스
public class Prize {
	private Integer prize_id;
	private String prize_name;
	private Double prize_rate;
	private Integer prize_curr_qty;
	private Integer prize_max_qty;
	
	public Prize(Integer prize_id, String prize_name, Double prize_rate, Integer prize_curr_qty, Integer prize_max_qty) {
		this.prize_id = prize_id;
		this.prize_name = prize_name;
		this.prize_rate = prize_rate;
		this.prize_curr_qty = prize_curr_qty;
		this.prize_max_qty = prize_max_qty;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%d개", prize_name, prize_curr_qty);
	}
	
	// 이 아래는 get 메서드 모여있는 곳
	public Integer getPrize_id() {
		return prize_id;
	}

	public String getPrize_name() {
		return prize_name;
	}
	
	public Double getPrize_rate() {
		return prize_rate;
	}

	public Integer getPrize_curr_qty() {
		return prize_curr_qty;
	}
	
	public Integer getPrize_max_qty() {
		return prize_max_qty;
	}
	
}
