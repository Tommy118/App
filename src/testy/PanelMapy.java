package testy;
import java.awt.event.*;

import java.awt.*;

public class PanelMapy extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	Graphics graphics;
	Box robot;
	Box wall,wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11;
	FlowLayout flowLayout = (FlowLayout) this.getLayout();
	
	public PanelMapy(){
		robot = new Box(500,800,10,10,Color.green);
		wall = new Box(0,850,10,10,Color.green);
		wall1 = new Box(500,500,10,10,Color.blue);
		wall2 = new Box(1000,500,10,10,Color.yellow);
		wall3 = new Box(1200,500,10,10,Color.red);
		wall4 = new Box(1400,500,10,10,Color.green);
		wall5 = new Box(1450,500,10,10,Color.blue);
		wall6 = new Box(1500,500,10,10,Color.yellow);
		wall7 = new Box(1800,500,10,10,Color.red);
		wall8 = new Box(2000,500,10,10,Color.green);
		wall9 = new Box(2500,500,10,10,Color.blue);
		wall10 = new Box(3000,500,10,10,Color.yellow);
		wall11 = new Box(3500,500,10,10,Color.red);
		
		this.addKeyListener(new AL());
		flowLayout.setVgap(1000);
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(1000);


	}
	
	public void paint(Graphics g) {
		image = createImage(this.getWidth(),this.getHeight());
		graphics = image.getGraphics();
		g.drawImage(image,0,0,this);
		
		robot.draw(g);
		wall.draw(g);
		wall1.draw(g);
		wall2.draw(g);
		wall3.draw(g);
		wall4.draw(g);
		wall5.draw(g);
		wall6.draw(g);
		wall7.draw(g);
		wall8.draw(g);
		wall9.draw(g);
		wall10.draw(g);
		wall11.draw(g);
		

	}
	
	public void checkCollision() {
		if(robot.intersects(wall)) {
			System.out.println("kolizja!");
		}
	}
	
	public class AL extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			robot.keyPressed(e);
			checkCollision();
			repaint();
		}
	}
}