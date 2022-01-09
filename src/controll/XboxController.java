package controll;

import com.exlumina.j360.ButtonListener;
import com.exlumina.j360.Controller;

public class XboxController {

	public static void main(String[] args) {
		
		Controller padXbox = Controller.C1;
		
		ButtonListener forward = new BasicControll.Forward();
		ButtonListener backward = new BasicControll.Backward();
		ButtonListener right = new BasicControll.Right();
		ButtonListener left = new BasicControll.Left();
		
		ButtonListener btn_close = new BasicControll.BtnClose();
		ButtonListener btn_horn = new BasicControll.BtnHorn();
		ButtonListener btn_speedUp = new BasicControll.BtnSpeedUp();
		ButtonListener btn_speedDown = new BasicControll.BtnSpeedDown();
		ButtonListener btn_ForwardWithSensors = new BasicControll.BtnForwardWithSensors();
		
		
		// Jazda na strza³kach/padzie
		padXbox.hatUp.addButtonPressedListener(forward);
		padXbox.hatUp.addButtonReleasedListener(forward);
		padXbox.hatDown.addButtonPressedListener(backward);
		padXbox.hatDown.addButtonReleasedListener(backward);
		padXbox.hatRight.addButtonPressedListener(right);
		padXbox.hatRight.addButtonReleasedListener(right);
		padXbox.hatLeft.addButtonPressedListener(left);
		padXbox.hatLeft.addButtonReleasedListener(left);
		
		padXbox.buttonLeftThumb.addButtonPressedListener(btn_close);
		padXbox.buttonRightThumb.addButtonPressedListener(btn_horn); // horn
		padXbox.buttonB.addButtonPressedListener(btn_speedUp);
		padXbox.buttonA.addButtonPressedListener(btn_speedDown);
		padXbox.buttonX.addButtonPressedListener(btn_ForwardWithSensors);
		
	}
	
	
}
