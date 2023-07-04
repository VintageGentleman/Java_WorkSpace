package gui.quiz.register_T;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.quiz.register_T.dao.MemberDao;

public class JoinButton extends JButton {

	/** JButton for RegisterFrame */
	private static final long serialVersionUID = 3373255395592548096L;

	MemberDao dao = new MemberDao();
	
	public JoinButton(RegisterFrame parent) {
		setText("가입하기");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 각 항목들이 전부 유효한지 체크해야 한다
				if(!parent.idField.isValid()) {
					// 알림 창 띄우기 메서드
					JOptionPane.showMessageDialog(
							parent, 					// 부모 컨테이너 (어느 컨테이너에 알림창을 띄울 것인지)
							"ID값이 유효하지 않음", 			// 원하는 메세지
							"Error", 					// 제목
							JOptionPane.ERROR_MESSAGE); // 타입 (그림이 바뀜)
					parent.idField.requestFocus();
					return;
				} else if(!parent.duplIdBtn.isValid()) {
					JOptionPane.showMessageDialog(parent, "ID중복체크 진행하지 않음", "Error", JOptionPane.ERROR_MESSAGE);
					parent.duplIdBtn.requestFocus();
					return;
				}
				
				// 모든 검사 통과시 DB에 등록
				// dao.insertNewMember(parent.idField.getText(), new String(parent.pwField.getPassword()));
			}
		});
	}
	
}
