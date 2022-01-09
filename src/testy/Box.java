package testy;

import java.awt.*;
import java.awt.event.*;

import controll.Buttons;
import controll.Sensors;
import windows.UserPanel;

public class Box extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Color color;
	
	boolean Straight = true;
	boolean TurnLeft = false;
	boolean TurnRight = false;
	boolean Turn180 = false;
	boolean operation = true;
	
	Box(int x, int y, int width, int height, Color color){
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
			
			if(Sensors.getDistance_UltrasonicSensor("portS1") <= 20) {
				UserPanel.editor.setText("Robot jest zbyt blisko przeszkody!");
				UserPanel.editor.setBackground(Color.orange);
			}
			else {			
				if(Straight == true) {
					System.out.println("Straight z strza³ki w górê");
					yMinus();
					Buttons.btn_forward();
				}
				if(TurnLeft == true) {
					System.out.println("GoLeft z strza³ki w górê");
					xMinus();
					Buttons.btn_forward();
				}
				if(TurnRight == true) {
					System.out.println("GoRight z strza³ki w górê");
					xPlus();
					Buttons.btn_forward();
				}
				if(Turn180 == true) {
					System.out.println("Go180 z strza³ki w górê");
					yPlus();
					Buttons.btn_forward();
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
			if(Turn180 == true) {
				System.out.println("Go180 z strza³ki w dó³");
				yMinus();
				Buttons.btn_backward();
			}			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					
			if(Straight == true && TurnLeft == false && Turn180 == false && TurnRight == false && operation == true) {
				TurnLeft = true;
				Straight = false;
				operation = false;
				System.out.println("Skrêt w lewo z STRAIGHT true");
				Buttons.btn_left();
			}
			
			if(Straight == false && TurnLeft == true && Turn180 == false && TurnRight == false && operation == true) {
				TurnLeft = false;
				Turn180 = true;
				operation = false;
				System.out.println("Skrêt w lewo z TurnLeft true");
				Buttons.btn_left();
			}
			
			if(Straight == false && TurnLeft == false && Turn180 == true && TurnRight == false && operation == true) {
				Turn180 = false;
				TurnRight = true;
				operation = false;
				System.out.println("Skrêt w lewo z Turn180 true");
				Buttons.btn_left();
			}

			if(Straight == false && TurnLeft == false && Turn180 == false && TurnRight == true && operation == true) {
				TurnRight = false;
				Straight = true;
				operation = false;
				System.out.println("Skrêt w lewo z TurnRight true");
				Buttons.btn_left();		
			}

			operation = true;
			
		}
				
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(Straight == true && TurnLeft == false && Turn180 == false && TurnRight == false && operation == true) {
				TurnRight = true;
				Straight = false;
				operation = false;
				System.out.println("Skrêt w prawo z STRAIGHT true");
				Buttons.btn_right();
			}
			
			if(Straight == false && TurnLeft == false && Turn180 == false && TurnRight == true && operation == true) {
				TurnRight = false;
				Turn180 = true;
				operation = false;
				System.out.println("Skrêt w prawo z TurnRight true");
				Buttons.btn_right();		
			}
			
			if(Straight == false && TurnLeft == false && Turn180 == true && TurnRight == false && operation == true) {
				TurnLeft = true;
				Turn180 = false;
				operation = false;
				System.out.println("Skrêt w prawo z Turn180 true");
				Buttons.btn_right();
			}
			
			if(Straight == false && TurnLeft == true && Turn180 == false && TurnRight == false && operation == true) {
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