package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S13_FlowLayout {

	public static void main(String[] args) {
		JFrame f = new JFrame("Flow...");

		FlowLayout flow = new FlowLayout();
		
		for(int i = 0; i < 30; ++i) {
			f.add(new JButton("button" + i));
		}
		
		f.setLayout(flow);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,300);
		f.setVisible(true);
	}
}
