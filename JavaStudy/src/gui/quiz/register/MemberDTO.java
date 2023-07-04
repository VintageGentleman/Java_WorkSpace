package gui.quiz.register;

public class MemberDTO {
	Integer members_key;
	String members_id;
	String members_pw;
	String members_name;
	String members_RRM;
	String members_email;
	
	// 이 아래는 get과 set 메서드 모음집 (Set_key은 없음)
	
	public Integer getMembers_key() {
		return members_key;
	}
		
	public String getMembers_id() {
		return members_id;
	}
	
	public void setMembers_id(String members_id) {
		this.members_id = members_id;
	}

	public void setMembers_RRM(String members_RRM) {
		this.members_RRM = members_RRM;
	}

	public String getMembers_pw() {
		return members_pw;
	}

	public void setMembers_pw(String members_pw) {
		this.members_pw = members_pw;
	}

	public String getMembers_name() {
		return members_name;
	}

	public void setMembers_name(String members_name) {
		this.members_name = members_name;
	}

	public String getMembers_RRM() {
		return members_RRM;
	}

	public String getMembers_email() {
		return members_email;
	}

	public void setMembers_email(String members_email) {
		this.members_email = members_email;
	}
	
	
	
}
