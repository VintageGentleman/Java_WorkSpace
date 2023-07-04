package comp.functions;

import java.awt.event.ActionEvent;

import properties.Basic;

public class ToFirstBtnFunc extends BtnFunc {

	@Override
	public void actionPerformed(ActionEvent e) {
		toFirstFunc();
		Basic.card.show(Basic.frame.getContentPane(), "waitScreen");
	}

}
