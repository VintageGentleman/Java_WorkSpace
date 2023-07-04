package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class S06_JTextArea extends JFrame {

	private static final long serialVersionUID = -8785053029636812421L;
	
	// 여러 줄의 텍스트를 입력할 수 있는 컴포넌트 
	
	public S06_JTextArea() {
		JTextArea ta = new JTextArea("Hello, world!");

		ta.setBounds(10, 10, 400, 400);
		
		// 자동 줄 바꿈 설정 (wrap)
		ta.setLineWrap(true);
		
		// 테두리 설정 (BorderFactory 클래스의 스태틱 메서드들로 제작 가능)
		ta.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// 수정 가능 여부 설정
		ta.setEditable(true);
		
		// addKeyListener() : 키보드 관련 이벤트 설정
		ta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// 키보드를 눌렀을 때 (새로운 문자가 생기는 키 ex: A, B, C ..)
				System.out.println("Key typed! " + e.getWhen());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// 키보드를 눌렀을 때 (새로운 문자가 입력되지 않는 키, ex: F1, F2 ..)
				System.out.println("Key pressed! " + e.getWhen());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// 눌렀던 키보드에서 손을 뗄 때 발생하는 이벤트
				System.out.println("key released " + e.getWhen());
				
				// getKeyChar() : 이벤트 발생 시 해당 키보드의 문자를 가져온다
				System.out.println("KeyChar: " + e.getKeyChar());
				
				// getKeyCode() : 이벤트 발생 시 해당 키보드의 번호를 가져온다
				System.out.println("keyCode : " + e.getKeyCode());
				
				// e.getkeyLocation()
				// : 왼쪽과 오른쪽에 모두 있는 키를 구분하기 위한 메서드
				// 	 왼쪽에 있으면 2번, 일반 키보드 1번,
				//   오른쪽 shift는 3번.. 넘패드는 4번
				System.out.println(e.getKeyLocation());
//				System.out.println(KeyEvent.KEY_LOCATION_STANDARD);
//				System.out.println(KeyEvent.KEY_LOCATION_LEFT);
//				System.out.println(KeyEvent.KEY_LOCATION_RIGHT);
//				System.out.println(KeyEvent.KEY_LOCATION_NUMPAD);

				// getCompoenet() : 이벤트를 발생시킨 컴포넌트 인스턴스를 반환
				System.out.println(e.getComponent()); 
			}
			
		});
		
		add(ta);
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	
		new S06_JTextArea();
		
	}
	
}
