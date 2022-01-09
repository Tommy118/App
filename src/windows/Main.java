package windows;

import java.io.IOException;

import controll.Sensors;
import controll.Setup;
import controll.XboxController;
import testy.MakeCsv;


public class Main{
	
	public static void main(String[] args) throws IOException  {
		
		MakeCsv.createCSV();
		Setup.startConnection();
		Setup.sleep();
		Setup.startSensors();
		Setup.startMotors();
		XboxController.main(args);
		UserPanel.main(args);
		//Sensors.calibration();
		//Sensors.gyro("portS4");
		Sensors.measuring();

		

		

	}
	
}
