package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S11_GridLayout {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		GridLayout grid = new GridLayout(3,5);

		grid.setHgap(5); // horizontal gap
		grid.setVgap(10); // vertical gap
		
		for(int i = 0; i < 15; ++i) {
			f.add(new JButton("button" + i));
		}
		
		f.setLayout(grid);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,300);
		f.setVisible(true);
	}
	
}
