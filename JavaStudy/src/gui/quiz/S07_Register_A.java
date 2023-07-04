package gui.quiz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.quiz.register.Id_Button;
import gui.quiz.register.LabelTemplate;
import gui.quiz.register.MemberDTO;
import gui.quiz.register.R_Password;
import gui.quiz.register.R_TextField;
import gui.quiz.register.RegistDAO;

public class S07_Register_A extends JFrame {

	private static final long serialVersionUID = 1450425051064794270L;

	/*
	 	회원가입 창을 만들어보세요
	 	
	 	(1) 아이디, 비밀번호, 비밀번호 확인
	 	 	이름, 주민등록번호(123456-1XXXXXX), 이메일
	 	
	 	(2) 아이디 중복 체크 기능을 구현해야 한다
	 		중복체크를 진행하지 않으면 회원가입 버튼을 누를 때 경고가 나와야 한다
	 	
	 	(3) 회원가입 버튼을 눌렀을 때 입력한 내용들이 올바르지 않다면 
	 		올바르지 않은 곳에 빨간 글씨로 올바르지 않은 이유를 설명해줘야 한다
	 		
	 	(4) 회원가입 버튼을 눌렀을 때 모든 값들이 올바르다면 DB에 회원 정보를 저장한다
	 	
	 	(5) 비밀번호는 대문자, 소문자, 특수문자가 최소 하나 이상씩 포함되어있어야 하며
	 		6글자 이상이어야 한다 (언어는 영어만 허용)
	 	
	 	(6) 비밀번호, 비밀번호 확인은 회원가입 버튼을 눌렀을 때 확인하는 것이 아니라 
	 	    키보드를 입력할때마다 메세지가 실시간으로 변해야 한다
	*/
	
	public S07_Register_A() {
		ImageIcon icon = new ImageIcon("src/gui/homestudy/coffee.png");
		RegistDAO dao = new RegistDAO();
		LabelTemplate Lt = new LabelTemplate();
		
		JLabel head = Lt.create(1, "회원가입");
		head.setLocation(150, 10);
		add(head);
		
		int labelX = 20;
		int TextX = 120;
		int[] locaY = new int[] {70, 130, 190, 250, 310, 370};
		
		JLabel id = Lt.create(0, "ID");
		id.setLocation(labelX, locaY[0]);
		add(id);
		
		R_TextField in_id = new R_TextField(TextX, locaY[0], 200, 30);
		add(in_id);
		
		Id_Button id_Chk = new Id_Button(this);
		id_Chk.setLocation(360, locaY[0]);
		add(id_Chk);
		
		JLabel id_pass = Lt.create(2, "");
		id_pass.setLocation(TextX, locaY[0] + 30);
		add(id_pass);
		
		id_Chk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = dao.checkID(in_id.getText());
				
				id_Chk.setCheckPass(result);

				if(id_Chk.isCheckPass() == Id_Button.PASS) {
					id_pass.setForeground(new Color(25, 224, 131));
					id_pass.setText("사용가능한 id입니다");
				} else if(id_Chk.isCheckPass() == Id_Button.NOTPASS) {
					id_pass.setForeground(new Color(224, 32, 25));
					id_pass.setText("중복된 id입니다");
				}
			}
			
		});

		JLabel pw = Lt.create(0, "PW");
		pw.setLocation(labelX, locaY[1]);
		add(pw);
		
		R_Password in_pw = new R_Password(TextX, locaY[1], 200, 30);
		add(in_pw);
		
		JLabel pw_pass = Lt.create(2, "");
		pw_pass.setSize(300, 30);
		pw_pass.setLocation(TextX, locaY[1] + 30);
		add(pw_pass);
		
		in_pw.addKeyListener(new KeyListener() {
			
			String specific = "!@#$%^&*()-_=+";
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				boolean lower = false;
				boolean upper = false;
				boolean special = false; 
				
				char[] pwText = in_pw.getPassword();
				
				for(int i = 0; i < pwText.length; ++i) {
					if(pwText[i] >= 65 && pwText[i] <= 90) {
						upper = true;
					}
					
					if(pwText[i] >= 97 && pwText[i] <= 122) {
						lower = true;
					}
					
					if(specific.indexOf(pwText[i]) != -1) {
						special = true;
					}
				}
				
				if(pwText.length < 6) {
					pw_pass.setForeground(new Color(224, 32, 25));
					pw_pass.setText("비밀번호는 6글자 이상이어야 합니다");
					return;
				}
				
				if(!Pattern.matches("[0-9a-zA-Z" + specific + "]*",  new String(pwText))) {
					pw_pass.setForeground(new Color(224, 32, 25));
					pw_pass.setText("<html>알파벳 대소문자, 숫자, 특수문자 외의 문자는<br>사용할 수 없습니다.</html>");
					return;
				}
				
				if(lower && upper && special) {
					pw_pass.setForeground(new Color(25, 224, 131));
					pw_pass.setText("사용가능합니다.");
					in_pw.setCheckup(true);
				} else {
					pw_pass.setForeground(new Color(224, 32, 25));
					pw_pass.setText("대문자, 소문자, 특수문자가 포함되어야 합니다");
				}
				
			}
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		JLabel pwChk = Lt.create(0, "PW확인");
		pwChk.setLocation(labelX, locaY[2]);
		add(pwChk);
		
		R_Password in_pwChk = new R_Password(TextX, locaY[2], 200, 30);
		add(in_pwChk);
		
		JLabel pwChk_pass = Lt.create(2, "");
		pwChk_pass.setLocation(TextX, locaY[2] + 30);
		add(pwChk_pass);
		
		in_pwChk.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String origin = new String(in_pw.getPassword());
				String copy = new String(in_pwChk.getPassword());

				if(!origin.equals(copy)) {
					pwChk_pass.setForeground(new Color(224, 32, 25));
					pwChk_pass.setText("비밀번호와 일치하지 않습니다.");
				} else {
					pwChk_pass.setForeground(new Color(25, 224, 131));
					pwChk_pass.setText("비밀번호와 일치합니다.");
					in_pwChk.setCheckup(true);
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		JLabel name = Lt.create(0, "이름");
		name.setLocation(labelX, locaY[3]);
		add(name);
		
		R_TextField in_name = new R_TextField(TextX, locaY[3], 200, 30);
		add(in_name);
		
		JLabel name_pass = Lt.create(2, "");
		name_pass.setLocation(TextX, locaY[3] + 30);
		add(name_pass);
		
		JLabel RRM = Lt.create(0, "주민번호");
		RRM.setLocation(labelX, locaY[4]);
		add(RRM);
		
		JLabel RRM_dash = new JLabel("-"); 
		RRM_dash.setBounds(TextX + 110, locaY[4], 5, 30);
		add(RRM_dash);
		
		JLabel RRM_back = Lt.create(0, "XXXXXX"); 
		RRM_back.setLocation(TextX + 142, locaY[4]);
		add(RRM_back);
		
		R_TextField in_RRM_front = new R_TextField(TextX, locaY[4], 100, 30);
		R_TextField in_RRM_back = new R_TextField(TextX + 120, locaY[4], 20, 30);
		add(in_RRM_front);
		add(in_RRM_back);
		
		in_RRM_front.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// 숫자가 6개까지만 들어감
				if(in_RRM_front.getText().length() > 5) {
					e.consume();
				};
			}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		in_RRM_back.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// 숫자가 1개까지만 들어감
				if(in_RRM_back.getText().length() > 0) {
					e.consume();
				};
			}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		JLabel RRM_pass = Lt.create(2, "");
		RRM_pass.setLocation(TextX, locaY[4] + 30);
		add(RRM_pass);
		
		JLabel email = Lt.create(0, "이메일");
		email.setLocation(labelX, locaY[5]);
		add(email);
		
		R_TextField in_email = new R_TextField(TextX, locaY[5], 200, 30);
		add(in_email);
		
		JLabel email_pass = Lt.create(2, "");
		email_pass.setLocation(TextX, locaY[5] + 30);
		add(email_pass);
		
		JLabel last_Chk = Lt.create(2, "");
		last_Chk.setLocation(360, locaY[4] - 10);
		add(last_Chk);
		
		JButton regist = new JButton("회원등록");
		regist.setBounds(360, locaY[4] + 10, 100, 80);
		add(regist);
		
		regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(id_Chk.isCheckPass() != 1) {
					last_Chk.setForeground(new Color(224, 32, 25));
					last_Chk.setText("id중복확인");
					return;
				}
				
				if(!in_pw.isCheckup() || !in_pwChk.isCheckup()) {
					last_Chk.setForeground(new Color(224, 32, 25));
					last_Chk.setText("password확인");
					return;
				}
					
				MemberDTO check = new MemberDTO();
				String password = new String(in_pw.getPassword());
				
				check.setMembers_id(in_id.getText());
				check.setMembers_pw(password);
				check.setMembers_name(in_name.getText());
				check.setMembers_RRM(in_RRM_front.getText() 
						+ in_RRM_back.getText());
				check.setMembers_email(in_email.getText());
				
				name_pass.setText("");
				RRM_pass.setText("");
				email_pass.setText("");
				
				boolean[] checked = dao.checkData(check);
				if(!checked[0]) {
					name_pass.setText("이름 확인");
				}
				
				if(!checked[1]) {
					RRM_pass.setText("주민번호 확인");
				}
				
				if(!checked[2]) {
					email_pass.setText("이메일 확인");
				}
				
				if(checked[0] && checked[1] && checked[2]) {
					dao.regist(check);
					last_Chk.setForeground(new Color(25, 224, 131));
					last_Chk.setText("등록완료");
				}
				
			}
		});
		
		setIconImage(icon.getImage());
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S07_Register_A();
	}
}
