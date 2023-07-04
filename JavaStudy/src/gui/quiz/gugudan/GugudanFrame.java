package gui.quiz.gugudan;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GugudanFrame extends JFrame {

	List<GugudanButton> gugudans = new ArrayList<>();
	
	PlusButton plus = new PlusButton(this);
	MinusButton minus = new MinusButton(this);
	
	public GugudanFrame() {
		
		for(int gop = 1; gop <= 9; ++gop) {
			GugudanButton btn = new GugudanButton(gop);
			add(btn);
			gugudans.add(btn);
		}
	
		add(plus);
		add(minus);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Gugudan Frame!!");
		setLayout(null);
		setLocation(550,200);
		setSize(600,700);
		setVisible(true);
	}
	
}
