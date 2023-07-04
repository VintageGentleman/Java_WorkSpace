package comp.functions;

import java.awt.event.ActionEvent;

public class RestartBtnFunc extends BtnFunc {

	@Override
	public void actionPerformed(ActionEvent e) {
		toFirstFunc();
		startFunc();
	}

}
