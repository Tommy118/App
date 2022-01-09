package controll;

import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import windows.UserPanel;

public class Sensors {
	

	private static float realityValue(float value, int range) {
		return value * range;
	}
	
	static EV3GyroSensor chooseGyroSensor(String port) {

		switch (port) {
		case "portS4":
			return Setup.Robot_sensor4;

		}
		return null;
	}
	
	public static int gyro(String port) {
		EV3GyroSensor gyroSensor = chooseGyroSensor(port);
		SampleProvider sp = gyroSensor.getAngleMode();
		int value = 0;
		
		for(int i = 0; i <= 100; i++) {
			float [] sample = new float[sp.sampleSize()];
	        sp.fetchSample(sample, 0);
	        value = (int)sample[0];
	        System.out.println("Iteration: " + i);
	        System.out.println("Gyro angle: " + value);
		}
		return value;
	}
	
	static EV3UltrasonicSensor chooseUltrasonicSensor(String port) {

		switch (port) {
		case "portS1":
			return Setup.Robot_sensor1;
		
		case "portS2":
			return Setup.Robot_sensor2;
			
		//case "portFS3":
			//return Front_sensor3;
		}
		return null;
	}
	
	public static float getDistance_UltrasonicSensor(String port) {
		SampleProvider distance;
		float[] sample;
		distance = chooseUltrasonicSensor(port).getDistanceMode();
		sample = new float[distance.sampleSize()];
		distance.fetchSample(sample, 0);
		return realityValue(sample[0], 100);
	}

	public static void measuring() {
		do{		
			if(!BasicControll.closed) {
				try {
					UserPanel.textField_SensorFront.setValue(getDistance_UltrasonicSensor("portS1") + "cm");
					UserPanel.textField_SensorLeft.setValue(getDistance_UltrasonicSensor("portS2") + "cm");
					UserPanel.textField_SensorFront_1.setValue(getDistance_UltrasonicSensor("portS1") + "cm");
					UserPanel.textField_SensorLeft_1.setValue(getDistance_UltrasonicSensor("portS2") + "cm");
					//textField_SensorRight.setValue(getDistance_IRSensor("portS3") + "cm");
					//textField_SensorGyro.setValue(getAngle_GyroSensor8("portS4") + "°");
					//textField_SensorGyro.setValue(getAngleMode() + "°");
					//UserPanel.textField_SensorGyro.setValue(gyro("portS4") + "°");
					//UserPanel.textField_SensorGyro.setValue(getAngle("portS4") + "°");
					//System.out.println(testgyro("portS4"));
					
					Delay.msDelay(1000);

				}
				catch(Exception e){

				}
				
			}
		}while(!BasicControll.closed);
	}
	
	public static void main(String[] args) {
		
	}
	
}
