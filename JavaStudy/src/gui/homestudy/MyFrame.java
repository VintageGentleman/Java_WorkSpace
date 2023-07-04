package gui.homestudy;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 399127235466568376L;
	
	// JFrame = a GUI window to add componenets to
	
	MyFrame(){
		
		setTitle("JFrame title goes here"); // sets title of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		setResizable(false); // prevent frame from being resized
		setSize(420, 420); // sets the x-demension, and y-dimension of frame
		setVisible(true); // make frame visible
		
		ImageIcon image = new ImageIcon("src/gui/home/coffee.png"); // create an ImageIcon
		setIconImage(image.getImage()); // change icon of frame
		getContentPane().setBackground(new Color(123,50,250)); // change color of background
		
	}
}
