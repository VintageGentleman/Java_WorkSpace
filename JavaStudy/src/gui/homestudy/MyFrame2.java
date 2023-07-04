package gui.homestudy;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame2 extends JFrame {

	JButton button;
	
	public MyFrame2() {
		
		ImageIcon icon = new ImageIcon("src/gui/home/121.png");
		
		button = new JButton();
		button.setBounds(100, 100, 250, 100);
		button.addActionListener(e -> System.out.println("poo"));
		button.setText("I'm a button!");
		button.setFocusable(false);
		button.setIcon(icon);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic sans", Font.BOLD, 25));
		button.setIconTextGap(-15);
		button.setForeground(Color.cyan);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorder(BorderFactory.createEtchedBorder());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500); 
		this.setVisible(true);
		this.add(button);
		
	}
	
}
