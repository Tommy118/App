package controll;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import com.exlumina.j360.ButtonListener;

import lejos.hardware.Sound;
import windows.UserPanel;

public class BasicControll {

	static JSplitPane splitPane;
	static JFrame frame = new JFrame("Sterowanie robotem");
	static JPanel Zak³adkaMapa = new JPanel();
	static JPanel Zak³adkaSterowanie = new JPanel();
	static FlowLayout flowLayout = (FlowLayout) Zak³adkaMapa.getLayout();
	static JTabbedPane tabbedPane = new JTabbedPane();
	static Container contentPane = frame.getContentPane();


	public static boolean closed = false;
	public static int speed = 200;
	public static int time = 2000;

	public static class Forward implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {

				try {
					if (!closed) {

						Setup.motorA.setSpeed(speed);
						Setup.motorB.setSpeed(speed);

						Setup.motorA.forward();
						Setup.motorB.forward();

						UserPanel.editor.setText("Robot jedzie do przodu z prêdkoœci¹ " + speed);
						UserPanel.editor.setBackground(Color.green);

					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();
					UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
					UserPanel.editor.setBackground(Color.red);

				}

			} else {
				try {
					if (!closed) {

						Setup.motorA.stop(true);
						Setup.motorB.stop(true);

						UserPanel.editor.setText("Stop");
						UserPanel.editor.setBackground(Color.orange);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();
					UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
					UserPanel.editor.setBackground(Color.red);

				}

			}
		}

	}
	
	public static class Backward implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {

				try {
					if (!closed) {

						Setup.motorA.setSpeed(speed);
						Setup.motorB.setSpeed(speed);

						Setup.motorA.backward();
						Setup.motorB.backward();

						UserPanel.editor.setText("Robot jedzie do ty³u z prêdkoœci¹ " + speed);
						UserPanel.editor.setBackground(Color.green);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();
					UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
					UserPanel.editor.setBackground(Color.red);

				}

			} else {
				try {
					if (!closed) {

						Setup.motorA.stop(true);
						Setup.motorB.stop(true);

						UserPanel.editor.setText("Stop");
						UserPanel.editor.setBackground(Color.orange);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();
					UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
					UserPanel.editor.setBackground(Color.red);

				}

			}
		}
	}

	public static class Left implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {

				try {
					if (!closed) {

						Setup.motorA.setSpeed(200);
						Setup.motorB.setSpeed(200);

						Setup.motorA.backward();
						Setup.motorB.forward();

						UserPanel.editor.setText("Robot skrêca w lewo z prêdkoœci¹ " + 200);
						UserPanel.editor.setBackground(Color.green);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();

				}

			} else {
				try {
					if (!closed) {

						Setup.motorA.stop(true);
						Setup.motorB.stop(true);

						UserPanel.editor.setText("Stop");
						UserPanel.editor.setBackground(Color.orange);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();
					UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
					UserPanel.editor.setBackground(Color.red);

				}

			}
		}
	}

	public static class Right implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {

				try {
					if (!closed) {

						Setup.motorA.setSpeed(200);
						Setup.motorB.setSpeed(200);

						Setup.motorA.forward();
						Setup.motorB.backward();

						UserPanel.editor.setText("Robot skrêca w prawo z prêdkoœci¹ " + 200);
						UserPanel.editor.setBackground(Color.green);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();

				}

			} else {
				try {
					if (!closed) {

						Setup.motorA.stop(true);
						Setup.motorB.stop(true);

						UserPanel.editor.setText("Stop");
						UserPanel.editor.setBackground(Color.orange);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();
					UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
					UserPanel.editor.setBackground(Color.red);

				}

			}
		}
	}
	
	public static class BtnClose implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {
				
				if(Setup.isClosedCorrectly == true) {
				Setup.closePorts();
				
				closed = true;
				UserPanel.editor.setText("Pomyœlnie zamkniêto wszystkie porty!");
				UserPanel.editor.setBackground(Color.green);
	
				}
				
			} else {
				if(Setup.isClosedCorrectly == false) {
				UserPanel.editor.setText("Nie uda³o zamkn¹æ siê wszystkich portów! Zresetuj robota oraz aplikacjê!");
				UserPanel.editor.setBackground(Color.red);
				}
			}
		}
	}
	
	public static class BtnHorn implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {
				
				Sound.beep();
				Sound.beep();
				Sound.beep();
				UserPanel.editor.setText("U¿yto klaksonu!");
				UserPanel.editor.setBackground(Color.green);				
				
			} else {
				UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
				UserPanel.editor.setBackground(Color.red);
			}
		}
	}
		
	public static class BtnSpeedUp implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {

				if (speed < 900) {
					
					if (!closed) {
						speed += 100;
						UserPanel.editor.setText("Prêdkoœæ zwiêkszona. Aktualna prêdkoœæ: " + speed);
						UserPanel.editor.setBackground(Color.green);
						UserPanel.lbl_speed.setText("Aktualna prêdkoœæ: " + speed);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}
		
				} else {
					speed = 900;
					UserPanel.editor.setText("Prêdkoœæ maksymalna zosta³a osi¹gniêta! Aktualna prêdkoœæ: " + speed);
					UserPanel.editor.setBackground(Color.green);
					UserPanel.lbl_speed.setText("Aktualna prêdkoœæ: " + speed);
				}

			}
		}
	}
	
	public static class BtnSpeedDown implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {

				if (speed > 100) {
					
					if (!closed) {
						speed -= 100;
						UserPanel.editor.setText("Prêdkoœæ zmniejszona. Aktualna prêdkoœæ: " + speed);
						UserPanel.editor.setBackground(Color.green);
						UserPanel.lbl_speed.setText("Aktualna prêdkoœæ: " + speed);
					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}
				} else {
					speed = 100;
					UserPanel.editor.setText("Prêdkoœæ minimalna zosta³a osi¹gniêta! Aktualna prêdkoœæ: " + speed);
					UserPanel.editor.setBackground(Color.green);
					UserPanel.lbl_speed.setText("Aktualna prêdkoœæ: " + speed);
				}

			}
		}
	}

	public static class BtnForwardWithSensors implements ButtonListener {
		@Override
		public void button(boolean pressed) {
			if (pressed) {
				
				try {

					if (!closed) {

						do {
							if((Sensors.getDistance_UltrasonicSensor("portFS1") > 25)) {	

							Setup.motorA.setSpeed(speed);
							Setup.motorB.setSpeed(speed);
	
							Setup.motorA.forward();
							Setup.motorB.forward();
	
						}
							
						}while((!(Sensors.getDistance_UltrasonicSensor("portFS1") < 25 )));{
							Setup.motorA.stop(true);
							Setup.motorB.stop(true);

							UserPanel.editor.setText("Robot jecha³ do przodu z prêdkoœci¹ " + speed + " i zatrzyma³ siê po wykryciu przeszkody");
							UserPanel.editor.setBackground(Color.green);
						}

					} else if (closed) {
						UserPanel.editor.setText("Porty zamkniête. Zrestartuj aplikacjê!");
						UserPanel.editor.setBackground(Color.red);
					}

				} catch (RemoteException r) {
					r.printStackTrace();
					UserPanel.editor.setText("Operacja wykonana niepomyœlnie!");
					UserPanel.editor.setBackground(Color.red);

				}
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
