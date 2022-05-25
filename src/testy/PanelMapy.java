package testy;
import java.awt.event.*;

import windows.UserPanel;

import java.awt.*;

public class PanelMapy extends Panel{

	private static final long serialVersionUID = 1L;
	Image image;
	Graphics graphics;
	Box robot;

	FlowLayout flowLayout = (FlowLayout) this.getLayout();
	
	public PanelMapy(){
		robot = new Box(750,750,10,10,Color.green);

		
		UserPanel.imgRobot.setBounds(750,750,10,10);
		
		for(int i=0; i<Box.walls.size(); i++){
		    Box.walls.get(i);
		    
		}
		//wall = new Box(Box.CurrentX, Box.CurrentY,10,10,Color.red);

		this.addKeyListener(new AL());
		flowLayout.setVgap(1000); //1000
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(2000); //2000


	}
	
	public void paint(Graphics g) {
		image = createImage(this.getWidth(),this.getHeight());
		graphics = image.getGraphics();
		g.drawImage(image,0,0,this);

		
		robot.draw(g);
		

		for(int i=0; i<Box.walls.size(); i++){
		    Box.walls.get(i).draw(g);
		    
		}

		
		//wall.draw(g);

	}
	

	
	public class AL extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			robot.keyPressed(e);
		
			paint(graphics);
			repaint();
		}
	}
}