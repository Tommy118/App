package testy;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



import controll.Buttons;
import controll.Sensors;
import windows.UserPanel;

public class Box2 extends Rectangle{
	
	static int CurrentX, CurrentY, SensorX, SensorY, ValueOfUltrasonic, SensorValue;
	
	static ArrayList<Box> walls = new ArrayList<Box>();
	
	public void addPoint(String port, String line) {
		
		CurrentX = x;
		CurrentY = y;
		SensorValue = (int) Sensors.getDistance_UltrasonicSensor(port);
		
		switch (port) {
			case "portS1":
				switch (line) {
					case "Straight":
						if(SensorValue<45) {
							SensorX = CurrentX;								
							SensorY = CurrentY-SensorValue;
						}						
						break;
						
					case "TurnLeft":
						if(SensorValue<45) {
							SensorX = CurrentX-SensorValue;						
							SensorY = CurrentY;
						}
						break;
						
					case "TurnRight":
						if(SensorValue<45) {
							SensorX = CurrentX+SensorValue;						
							SensorY = CurrentY;
						}
						break;
						
					case "GoDown":
						if(SensorValue<45) {
							SensorX = CurrentX;						
							SensorY = CurrentY+SensorValue;
						}
						break;
				}
				break;
			case "portS2":
				switch (line) {
					case "Straight":
						if(SensorValue<45) {
							SensorX =CurrentX-SensorValue;											
							SensorY = CurrentY;
						}
						break;
						
					case "TurnLeft":
						if(SensorValue<45) {
							SensorX = CurrentX;											
							SensorY = CurrentY+SensorValue;
						}
						break;
						
					case "TurnRight":
						if(SensorValue<45) {
							SensorX = CurrentX;											
							SensorY = CurrentY-SensorValue;	
						}
						break;
						
					case "GoDown":
						if(SensorValue<45) {
							SensorX = CurrentX+SensorValue;											
							SensorY = CurrentY;
						}
						break;
				}
				break;
			case "portS3":
				switch (line) {
					case "Straight":
						if(SensorValue<45) {
							SensorX = CurrentX+SensorValue;												
							SensorY = CurrentY;
						}
						break;
						
					case "TurnLeft":
						if(SensorValue<45) {
							SensorX = CurrentX;												
							SensorY = CurrentY-SensorValue;	
						}
						break;
						
					case "TurnRight":
						if(SensorValue<45) {
							SensorX = CurrentX;											
							SensorY = CurrentY+SensorValue;	
						}
						break;
						
					case "GoDown":
						if(SensorValue<45) {
							SensorX = CurrentX-SensorValue;												
							SensorY = CurrentY;
						}
						break;
				}
				break;
		}

		Box wall = new Box(Box.SensorX, Box.SensorY,10,10,Color.red);
		walls.add(wall);
	}
	
	public static void readList() {
		for(int i=0; i<walls.size(); i++){
		    System.out.println(walls.get(i));
		    
		}
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Color color;
	
	boolean Straight = true;
	boolean TurnLeft = false;
	boolean TurnRight = false;
	boolean GoDown = false;
	boolean operation = true;
	
	
	Box2(int x, int y, int width, int height, Color color){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.color=color;
	}

	/*
	public void yMinus() {
		this.y=y-10;
	}
	
	public void yPlus() {
		this.y=y+10;
	}
	
	public void xMinus() {
		this.x=x-10;
	}
	
	public void xPlus() {
		this.x=x+10;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			yMinus();
			Buttons.btn_forward();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			yPlus();
			Buttons.btn_backward();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xMinus();
			Buttons.btn_left();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xPlus();
			Buttons.btn_right();
		}
	}
	 */
	
	
	public void yMinus() {
		this.y=y-10;
	}
	
	public void yPlus() {
		this.y=y+10;
	}
	
	public void xMinus() {
		this.x=x-10;
	}
	
	public void xPlus() {
		this.x=x+10;
	}
		
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			if(Sensors.getDistance_UltrasonicSensor("portS1") <= 22) {
				UserPanel.editor.setText("Robot jest zbyt blisko przeszkody!");
				UserPanel.editor.setBackground(Color.orange);
			}
			else {			
				if(Straight == true) {
					System.out.println("Straight z strza³ki w górê");
					yMinus();
					Buttons.btn_forward();					
					//Front sensor
					addPoint("portS1", "Straight");					
					//Right sensor
					addPoint("portS2", "Straight");					
					//Left sensor
					addPoint("portS3", "Straight");
				}
				if(TurnLeft == true) {
					System.out.println("GoLeft z strza³ki w górê");
					xMinus();
					Buttons.btn_forward();
					//Front sensor
					addPoint("portS1", "TurnLeft");					
					//Right sensor
					addPoint("portS2", "TurnLeft");					
					//Left sensor
					addPoint("portS3", "TurnLeft");
				}
				if(TurnRight == true) {
					System.out.println("GoRight z strza³ki w górê");
					xPlus();
					Buttons.btn_forward();
					//Front sensor
					addPoint("portS1", "TurnRight");					
					//Right sensor
					addPoint("portS2", "TurnRight");					
					//Left sensor
					addPoint("portS3", "TurnRight");
				}
				if(GoDown == true) {
					System.out.println("GoBack z strza³ki w górê");
					yPlus();
					Buttons.btn_forward();
					//Front sensor
					addPoint("portS1", "GoDown");					
					//Right sensor
					addPoint("portS2", "GoDown");					
					//Left sensor
					addPoint("portS3", "GoDown");
				}
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			if(Straight == true) {
				System.out.println("Straight z strza³ki w dó³");
				yPlus();
				Buttons.btn_backward();
			}
			if(TurnLeft == true) {
				System.out.println("GoLeft z strza³ki w dó³");
				xPlus();
				Buttons.btn_backward();
			}
			if(TurnRight == true) {
				System.out.println("GoRight z strza³ki w dó³");
				xMinus();
				Buttons.btn_backward();
			}
			if(GoDown == true) {
				System.out.println("GoBack z strza³ki w dó³");
				yMinus();
				Buttons.btn_backward();
			}			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					
			if(Straight == true && TurnLeft == false && GoDown == false && TurnRight == false && operation == true) {
				TurnLeft = true;
				Straight = false;
				operation = false;
				System.out.println("Skrêt w lewo z STRAIGHT true");
				Buttons.btn_left();
			}
			
			if(Straight == false && TurnLeft == true && GoDown == false && TurnRight == false && operation == true) {
				TurnLeft = false;
				GoDown = true;
				operation = false;
				System.out.println("Skrêt w lewo z TurnLeft true");
				Buttons.btn_left();
			}
			
			if(Straight == false && TurnLeft == false && GoDown == true && TurnRight == false && operation == true) {
				GoDown = false;
				TurnRight = true;
				operation = false;
				System.out.println("Skrêt w lewo z TurnBack true");
				Buttons.btn_left();
			}

			if(Straight == false && TurnLeft == false && GoDown == false && TurnRight == true && operation == true) {
				TurnRight = false;
				Straight = true;
				operation = false;
				System.out.println("Skrêt w lewo z TurnRight true");
				Buttons.btn_left();		
			}

			operation = true;
			
		}
				
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(Straight == true && TurnLeft == false && GoDown == false && TurnRight == false && operation == true) {
				TurnRight = true;
				Straight = false;
				operation = false;
				System.out.println("Skrêt w prawo z STRAIGHT true");
				Buttons.btn_right();
			}
			
			if(Straight == false && TurnLeft == false && GoDown == false && TurnRight == true && operation == true) {
				TurnRight = false;
				GoDown = true;
				operation = false;
				System.out.println("Skrêt w prawo z TurnRight true");
				Buttons.btn_right();		
			}
			
			if(Straight == false && TurnLeft == false && GoDown == true && TurnRight == false && operation == true) {
				TurnLeft = true;
				GoDown = false;
				operation = false;
				System.out.println("Skrêt w prawo z TurnBack true");
				Buttons.btn_right();
			}
			
			if(Straight == false && TurnLeft == true && GoDown == false && TurnRight == false && operation == true) {
				TurnLeft = false;
				Straight = true;
				operation = false;
				System.out.println("Skrêt w prawo z TurnLeft true");
				Buttons.btn_right();
			}
			
			operation = true;
		}
	}
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

}