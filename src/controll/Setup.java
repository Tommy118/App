package controll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.exlumina.j360.Controller;

import lejos.hardware.*;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

public class Setup {

	static RemoteEV3 ev3_controller;
	static EV3UltrasonicSensor Robot_sensor1, Robot_sensor2;
	static EV3IRSensor Robot_sensor3;
	static EV3GyroSensor Robot_sensor4;
	//static HiTechnicCompass Robot_sensor4;
	public static RMIRegulatedMotor motorA;
	public static RMIRegulatedMotor motorB;
	public static String ip_robot;
	public static boolean isClosedCorrectly = true;
	
	public static void startConnection(){
		
		JFrame frameLaczenie = new JFrame("Po³¹czenie");
		JFrame frame1 = new JFrame("Informacja");
		
		frameLaczenie.setSize(new Dimension(450, 250));
		JPanel panel2 = new JPanel();
		frameLaczenie.getContentPane().add(panel2, BorderLayout.CENTER);
		final JTextField IP_Robot = new JTextField(15);
		IP_Robot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel labelRobotIP = new JLabel ("Podaj IP kontrolera EV3");
		
		labelRobotIP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel2.setSize(new Dimension(450, 250));
		panel2.add(labelRobotIP);
		panel2.add(IP_Robot);
		labelRobotIP.setBounds(10, 150, 200, 100);
		
		JButton btn_commit = new JButton("PotwierdŸ");
		btn_commit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel2.add(btn_commit);
		btn_commit.setBounds(200, 250, 250, 150);
		
		btn_commit.addActionListener(new ActionListener() {	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(IP_Robot.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame1, "Podaj adres IP!");
				}
				else {
					JOptionPane.showMessageDialog(frame1, "Adres IP zosta³ dodany pomyœlnie.");
					frameLaczenie.setVisible(false);
					ip_robot = IP_Robot.getText();
			        try {
			    		ev3_controller = new RemoteEV3(ip_robot);
				        ev3_controller.isLocal();
			        } catch (RemoteException | HeadlessException | MalformedURLException | NotBoundException ex) {
			            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			    		final JFrame frame1 = new JFrame("Informacja");
			            JOptionPane.showMessageDialog(frame1, "Nie uda³o siê po³¹czyæ, zrestartuj aplikacjê!");
			        } 
				}			
				//Sound.beep();
			}          
		});
		
		frameLaczenie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLaczenie.setVisible(true);

	}
	
	public static void sleep() {
		
		while(ev3_controller == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static void startSensors() {

		if (Robot_sensor1 == null) {
			try {
				Robot_sensor1 = new EV3UltrasonicSensor(ev3_controller.getPort("S1"));
			}catch(IllegalArgumentException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 1, zrestartuj aplikacjê oraz robota!");
			}catch(DeviceException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 1, zrestartuj aplikacjê oraz robota!");
			}
			
		}
		if (Robot_sensor2 == null) {
			try {
				Robot_sensor2 = new EV3UltrasonicSensor(ev3_controller.getPort("S2"));
			}catch(IllegalArgumentException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 2, zrestartuj aplikacjê oraz robota!");
			}catch(DeviceException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 2, zrestartuj aplikacjê oraz robota!");
			}
			
		}
		/*
		if (Robot_sensor3 == null) {
			try {
				Robot_sensor3 = new EV3IRSensor(ev3_controller.getPort("S3"));
			}catch(IllegalArgumentException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 3, zrestartuj aplikacjê oraz robota!");
			}catch(DeviceException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 3, zrestartuj aplikacjê oraz robota!");
			}
			
		}
		*/
		/*
		if (Robot_sensor4 == null) {
			try {
				Robot_sensor4 = new HiTechnicCompass(ev3_controller.getPort("S4"));
			}catch(IllegalArgumentException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 4, zrestartuj aplikacjê oraz robota!");
			}catch(DeviceException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 4, zrestartuj aplikacjê oraz robota!");
			}
			
		}
		*/

		if (Robot_sensor4 == null) {
			try {
				Robot_sensor4 = new EV3GyroSensor(ev3_controller.getPort("S4"));
			}catch(IllegalArgumentException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 4, zrestartuj aplikacjê oraz robota!");
			}catch(DeviceException e){
	    		final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d dodania sensora nr 4, zrestartuj aplikacjê oraz robota!");
			}
			
		}
		
		System.out.println("Dodanie sensorów: ok");
	}
	
	public static void startMotors() {

		if (motorA == null) {
			try {
			motorA = ev3_controller.createRegulatedMotor("A", 'L');
			}catch(DeviceException e){
				final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d silnika nr 1, zrestartuj aplikacjê oraz robota!");
			}
		}
		if (motorB == null) {
			try {
			motorB = ev3_controller.createRegulatedMotor("B", 'L');
			}catch(DeviceException e){
				final JFrame frame4 = new JFrame("Informacja");
	            JOptionPane.showMessageDialog(frame4, "Wyst¹pi³ b³¹d silnika nr 2, zrestartuj aplikacjê oraz robota!");
			}
		}
		
		System.out.println("Dodanie motorów: ok");
	}
	
	public static void closePorts() {

		try {
			motorA.close();
			motorB.close();

			Robot_sensor1.close();
			Robot_sensor2.close();
			//Robot_sensor3.close();
			Robot_sensor4.close();

		} catch (RemoteException | NullPointerException r) {
			isClosedCorrectly = false;
			r.printStackTrace();
		}

		System.out.println("Zamkniêcie sensorów i motorów: ok");
	}
	
	public static void main(String[] args) {
		
	}
		
}
