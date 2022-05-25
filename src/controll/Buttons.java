package controll;

import java.awt.Color;
import java.rmi.RemoteException;

import lejos.hardware.Sound;
import testy.Box;
import testy.MakeCsv;
import windows.UserPanel;

public class Buttons {

	public static int speed1 = 100;
	public static int time1 = 1850;
	public static float distanceFront, distanceLeft, distanceRight;
	
	public static void btn_test() {
		
		try {
			UserPanel.editor.setText("TEST!");
			UserPanel.editor.setBackground(Color.green);			

		} catch (Exception r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);
		}
	}
	
	public static void btn_test2(){
		
		try {
			Box.readList();
			UserPanel.editor.setText("readlist!");
			UserPanel.editor.setBackground(Color.green);			

		} catch (Exception r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);
		}
	} 
	
	public static void btn_backward() {
		
    	try {
			if (!BasicControll.closed) {
				
				Setup.motorA.setSpeed(speed1);
				Setup.motorB.setSpeed(speed1);
				
				Setup.motorA.backward();
				Setup.motorB.backward();
				
				UserPanel.editor.setText("Robot pojecha� do ty�u z pr�dko�ci� " + speed1);
				UserPanel.editor.setBackground(Color.green);
				
				try {
					Thread.sleep(BasicControll.time);
				}
				catch(InterruptedException er){
					er.printStackTrace();
				}						
				
				Setup.motorA.stop(true);
				Setup.motorB.stop(true);
				
				System.out.println("Sensory:");

				System.out.println("Ruch do ty�u");
				System.out.println("Motor A: " + -speed1);
				System.out.println("Motor B: " + -speed1);

			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} catch (RemoteException r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);

		}

	}
	
	public static void btn_forward() {
		
    	try {
			if (!BasicControll.closed) {

				Setup.motorA.setSpeed(speed1);
				Setup.motorB.setSpeed(speed1);

				Setup.motorA.forward();
				Setup.motorB.forward();
				
				UserPanel.editor.setText("Robot pojecha� do przodu z pr�dko�ci� " + speed1);
				UserPanel.editor.setBackground(Color.green);
				
				try {
					Thread.sleep(BasicControll.time);
				}
				catch(InterruptedException er){
					er.printStackTrace();
				}						
				
				Setup.motorA.stop(true);
				Setup.motorB.stop(true);
				
				System.out.println("Sensory:");
				distanceFront = Sensors.getDistance_UltrasonicSensor("portS1");
				distanceLeft = Sensors.getDistance_UltrasonicSensor("portS3");	
				distanceRight = Sensors.getDistance_UltrasonicSensor("portS2");
				System.out.println("Prz�d: "+distanceFront);			
				System.out.println("Prawa: "+distanceLeft);
				System.out.println("Lewa: "+distanceRight);
				MakeCsv.frontSensor=String.valueOf(distanceFront);
				MakeCsv.leftSensor=String.valueOf(distanceLeft);	
				MakeCsv.rightSensor=String.valueOf(distanceRight);	
				System.out.println("Ruch do przodu");
				System.out.println("Motor A: " + speed1);
				MakeCsv.speedA=String.valueOf(speed1);
				System.out.println("Motor B: " + speed1);
				MakeCsv.speedB=String.valueOf(speed1);
				MakeCsv.addData();
				//}

			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} catch (RemoteException r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);

		}

	}
	
	public static void btn_left() {
		
    	try {
			if (!BasicControll.closed) {
				
				Setup.motorA.setSpeed(speed1);
				Setup.motorB.setSpeed(speed1);

				Setup.motorA.backward();
				Setup.motorB.forward();
				
				UserPanel.editor.setText("Robot skr�ci� w lewo z pr�dko�ci� " + speed1);
				UserPanel.editor.setBackground(Color.green);
				
				try {
					Thread.sleep(time1);
				}
				catch(InterruptedException er){
					er.printStackTrace();
				}						
				
				Setup.motorA.stop(true);
				Setup.motorB.stop(true);
				
				System.out.println("Sensory:");
				System.out.println(Sensors.getDistance_UltrasonicSensor("portS1"));				
				System.out.println(Sensors.getDistance_UltrasonicSensor("portS2"));		
				System.out.println("Skr�t w lewo");
				System.out.println("Motor A: " + -speed1);
				System.out.println("Motor B: " + speed1);

			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} catch (RemoteException r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);

		}

	}
	
	public static void btn_right() {
		
    	try {
			if (!BasicControll.closed) {
				
				Setup.motorA.setSpeed(speed1);
				Setup.motorB.setSpeed(speed1);

				Setup.motorA.forward();
				Setup.motorB.backward();
				
				UserPanel.editor.setText("Robot skr�ci� w prawo z pr�dko�ci� " + speed1);
				UserPanel.editor.setBackground(Color.green);
				
				try {
					Thread.sleep(time1);
				}
				catch(InterruptedException er){
					er.printStackTrace();
				}						
				
				Setup.motorA.stop(true);
				Setup.motorB.stop(true);
				
				System.out.println("Sensory:");
				System.out.println(Sensors.getDistance_UltrasonicSensor("portS1"));				
				System.out.println(Sensors.getDistance_UltrasonicSensor("portS2"));		
				System.out.println("Skr�t w prawo");
				System.out.println("Motor A: " + speed1);
				System.out.println("Motor B: " + -speed1);

			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} catch (RemoteException r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);

		}

	}
	
	public static void btn_close() {
		
		if(Setup.isClosedCorrectly == true) {
			Setup.closePorts();
			
			BasicControll.closed = true;
			UserPanel.editor.setText("Pomy�lnie zamkni�to wszystkie porty!");
			UserPanel.editor.setBackground(Color.green);

			}
		else {
			if(Setup.isClosedCorrectly == false) {
				UserPanel.editor.setText("Nie uda�o zamkn�� si� wszystkich port�w! Zresetuj robota oraz aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		}
	}
	
	public static void btn_horn() {
		
		try {
			Sound.beep();
			Sound.beep();
			Sound.beep();
			UserPanel.editor.setText("U�yto klaksonu!");
			UserPanel.editor.setBackground(Color.green);

		} catch (Exception r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);
		}
	}
	
	public static void btn_speedUp() {
		
		if (BasicControll.speed < 900) {

			if (!BasicControll.closed) {
				BasicControll.speed += 100;
				UserPanel.editor.setText("Pr�dko�� zwi�kszona. Aktualna pr�dko��: " + BasicControll.speed);
				UserPanel.editor.setBackground(Color.green);
				UserPanel.lbl_speed.setText("Aktualna pr�dko��: " + BasicControll.speed);
			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} else {
			BasicControll.speed = 900;
			UserPanel.editor.setText("Pr�dko�� maksymalna zosta�a osi�gni�ta! Aktualna pr�dko��: " + BasicControll.speed);
			UserPanel.editor.setBackground(Color.green);
			UserPanel.lbl_speed.setText("Aktualna pr�dko��: " + BasicControll.speed);
		}
	}
	
	public static void btn_speedDown() {
		
		if (BasicControll.speed > 100) {

			if (!BasicControll.closed) {
				BasicControll.speed -= 100;
				UserPanel.editor.setText("Pr�dko�� zmniejszona. Aktualna pr�dko��: " + BasicControll.speed);
				UserPanel.editor.setBackground(Color.green);
				UserPanel.lbl_speed.setText("Aktualna pr�dko��: " + BasicControll.speed);
			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}
		} else {
			BasicControll.speed = 100;
			UserPanel.editor.setText("Pr�dko�� minimalna zosta�a osi�gni�ta! Aktualna pr�dko��: " + BasicControll.speed);
			UserPanel.editor.setBackground(Color.green);
			UserPanel.lbl_speed.setText("Aktualna pr�dko��: " + BasicControll.speed);
		}
	}

	public static void btn_TimeUp() {
		
		if (BasicControll.time < 10000) {

			if (!BasicControll.closed) {
				BasicControll.time += 1000;
				UserPanel.editor.setText("Zwi�kszono czas kt�ry przejedzie robot do: " + BasicControll.time + " ms");
				UserPanel.editor.setBackground(Color.green);
				UserPanel.lbl_time.setText("Aktualny czas: " + BasicControll.time + "ms");
			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} else {
			BasicControll.time = 10000;
			UserPanel.editor.setText("Osi�gni�to maksymalny czas kt�ry przejedzie robot: " + BasicControll.time + " ms");
			UserPanel.editor.setBackground(Color.green);
			UserPanel.lbl_time.setText("Aktualny czas: " + BasicControll.time + "ms");
		}
	}
	
	public static void btn_TimeDown() {
		
		if (BasicControll.time > 1000) {

			if (!BasicControll.closed) {
				BasicControll.time -= 1000;
				UserPanel.editor.setText("Zminiejszono czas kt�ry przejedzie robot do: " + BasicControll.time + " ms");
				UserPanel.editor.setBackground(Color.green);
				UserPanel.lbl_time.setText("Aktualny czas: " + BasicControll.time + "ms");
			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}
		} else {
			BasicControll.time = 1000;
			UserPanel.editor.setText("Osi�gni�to minimalny czas kt�ry przejedzie robot: " + BasicControll.time + " ms");
			UserPanel.editor.setBackground(Color.green);
			UserPanel.lbl_time.setText("Aktualny czas: " + BasicControll.time + "ms");
		}
	}

	public static void btn_ForwardWithSensors() {
		
		try {

			if (!BasicControll.closed) {

				do {
					if((Sensors.getDistance_UltrasonicSensor("portFS1") > 25)) {	

					Setup.motorA.setSpeed(BasicControll.speed);
					Setup.motorB.setSpeed(BasicControll.speed);

					Setup.motorA.forward();
					Setup.motorB.forward();

				}
					
				}while((!(Sensors.getDistance_UltrasonicSensor("portFS1") < 25 )));{
					
					Setup.motorA.stop(true);
					Setup.motorB.stop(true);


					UserPanel.editor.setText("Robot jecha� do przodu z pr�dko�ci� " + BasicControll.speed + " i zatrzyma� si� po wykryciu przeszkody");
					UserPanel.editor.setBackground(Color.green);
				}

			} else if (BasicControll.closed) {
				
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} catch (RemoteException r) {
			
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);

		}

	}
	
	public static void btn_calibration() {
		
    	try {
			if (!BasicControll.closed) {
				
				Setup.motorA.setSpeed(100);
				Setup.motorB.setSpeed(100);

				Setup.motorA.backward();
				Setup.motorB.forward();
				
				UserPanel.editor.setText("Robot pojecha� do przodu z pr�dko�ci� " + BasicControll.speed);
				UserPanel.editor.setBackground(Color.green);
				
				try {
					Thread.sleep(20000);
				}
				catch(InterruptedException er){
					er.printStackTrace();
				}						
				
				Setup.motorA.stop(true);
				Setup.motorB.stop(true);

			} else if (BasicControll.closed) {
				UserPanel.editor.setText("Porty zamkni�te. Zrestartuj aplikacj�!");
				UserPanel.editor.setBackground(Color.red);
			}

		} catch (RemoteException r) {
			r.printStackTrace();
			UserPanel.editor.setText("Operacja wykonana niepomy�lnie!");
			UserPanel.editor.setBackground(Color.red);

		}

	}
	
	public static void main(String[] args) {
			
	}
	
}
