package gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class S14_Image {

	public static void main(String[] args) {
		JFrame f = new JFrame("Image...");

		JLabel image1 = new JLabel();
		JLabel image2 = new JLabel();
		JLabel image3 = new JLabel();
		
		image1.setIcon(new ImageIcon("files/images/b1.jpg"));
		image2.setIcon(new ImageIcon("files/images/b2.png"));
		
		try {
			// 이미지 로딩
			BufferedImage bufferedImage =
					ImageIO.read(new File("files/images/침몰.jpg"));
			
			// getScaledInstance() : 크기 조절된 이미지 인스턴스를 반환
			Image scaledImage =
					bufferedImage.getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING);
			
			@SuppressWarnings("unused")
			// getSubimage() : 원본에서 원하는 일부 이미지를 잘라서 반환
			Image subImage =
					bufferedImage.getSubimage(50, 50, 100, 100);
			
			image3.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		f.add(image1);
		f.add(image2);
		f.add(image3);
		
		f.setLayout(new GridLayout(2, 2));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
	
}
