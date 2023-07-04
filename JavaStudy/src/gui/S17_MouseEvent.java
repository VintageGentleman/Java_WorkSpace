package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class S17_MouseEvent {

	// 각 컴포넌트에 MouseListener를 추가할 수 있다
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Mouse");
		
		JLabel image = new JLabel();
		
		try {
			image.setIcon(new ImageIcon(
					ImageIO
						.read(new File("files/images/b1.jpg"))
						.getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 모니터 상의 위치를 알려준다
				System.out.println(e.getLocationOnScreen());
				
				// 컴포넌트 상의 위치를 알려준다
				System.out.println(e.getPoint());
				
				// 어떤 마우스 버튼이 클릭되었는지 알려준다
				// 왼클릭 - 1
				// 우클릭 - 3
				// 휠클릭 - 2
				System.out.println(e.getButton());
			}
		});
		
		f.add(image, BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
	
}
