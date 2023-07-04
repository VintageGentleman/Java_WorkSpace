package gui.quiz.gugudan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MinusButton extends JButton implements ActionListener {

	GugudanFrame parent;
	
	public MinusButton(GugudanFrame parent) {
		this.parent = parent;
		
		setText("-");
		setSize(80, 80);
		setLocation(320, 300);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(GugudanButton btn : parent.gugudans) {
			btn.setDan(btn.getDan() - 1);
		}
	}
	
}
