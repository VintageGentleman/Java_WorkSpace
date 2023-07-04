package properties;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import screen.MainFrame;

public class Basic {

	public static MainFrame frame;
	public static CardLayout card;
	
	public Basic(MainFrame frame, CardLayout card) {
		Basic.frame = frame; 
		Basic.card = card;
	}
	
	// 색깔
	public static final Color MAIN_COLOR = new Color(84, 87, 117);
	public static final Color BTN_COLOR = new Color(113, 143, 148);
	
	// 폰트
	public static final Font BTN_FONT = new Font("견고딕", Font.BOLD, 20);
	public static final Font LABEL_FONT = new Font("견고딕", Font.BOLD, 25);
	public static final Font HEAD_FONT = new Font("휴먼모음", Font.BOLD, 35);
	public static final Font HEAD_FONT2 = new Font("휴먼모음", Font.BOLD, 50);
	
	// 위치 정보
	public static final int BLANK = 10;
	public static final int HALF_START_X = 295;
	public static final int LAST_Y = 450;
	
	public static final Point DEFAULT = new Point(BLANK, BLANK); 
	public static final Point LAST = new Point(BLANK, LAST_Y);
	
	// 사이즈, 높이, 너비 정보
	public static final int DEFAULT_WIDTH = 565;
	public static final int DEFAULT_HEIGHT = 100;
	
	public static final int HALF_WIDTH = (DEFAULT_WIDTH - 5)/2;
	
	public static final Dimension FRAME_SIZE = new Dimension(600, 600);
	public static final Dimension GENERAL_COMP_SIZE = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	public static final Dimension HALF_COMP_SIZE = new Dimension(HALF_WIDTH, DEFAULT_HEIGHT);
	
	/** 라벨에 이미지를 넣어주는 메서드 */
	public static void setImage(JLabel label, String fileDirectory, int width, int height) {
		try {
			BufferedImage bufferedImage = 
					ImageIO.read(new File(fileDirectory));
			
			Image scaledImage = bufferedImage.getScaledInstance(
					width, height, Image.SCALE_AREA_AVERAGING);
			
			label.setIcon(new ImageIcon(scaledImage));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
