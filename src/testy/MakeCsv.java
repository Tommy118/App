package testy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.opencsv.CSVWriter;



public class MakeCsv {
	public static String nazwaPliku, speedA, speedB, leftSensor, frontSensor, rightSensor;

	
	public static void sleep() {
		
		while(nazwaPliku == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static void addHeader() {
		try {
			
			while(nazwaPliku.isEmpty()) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			FileWriter outputfile = new FileWriter(nazwaPliku + ".csv", true);
			
			// create CSVWriter object filewriter object as parameter
			CSVWriter csvWriter = new CSVWriter(outputfile);
			// adding header to csv
			String[] header = { "\"Motor A\"", "Motor B", "Left Ultrasonic", "Front Ultrasonic", "Right Ultrasonic" };
			csvWriter.writeNext(header);
			csvWriter.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createCSV(){	
		
		JFrame frameCSV = new JFrame("Tworzenie pliku CSV");
		JFrame frame1 = new JFrame("Informacja");
		
		frameCSV.setSize(new Dimension(450, 250));
		JPanel panel2 = new JPanel();
		frameCSV.getContentPane().add(panel2, BorderLayout.CENTER);
		final JTextField CSV_Name = new JTextField(15);
		CSV_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel labelCSV_Name = new JLabel ("Podaj nazwê pliku CSV");
		
		labelCSV_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel2.setSize(new Dimension(450, 250));
		panel2.add(labelCSV_Name);
		panel2.add(CSV_Name);
		labelCSV_Name.setBounds(10, 150, 200, 100);
		
		JButton btn_commit = new JButton("PotwierdŸ");
		btn_commit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel2.add(btn_commit);
		btn_commit.setBounds(200, 250, 250, 150);

		btn_commit.addActionListener(new ActionListener() {	        
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(CSV_Name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame1, "Podaj nazwê pliku.");
				}
				else {
					JOptionPane.showMessageDialog(frame1, "Plik zosta³ utworzony pomyœlnie.");
					frameCSV.setVisible(false);
					nazwaPliku = CSV_Name.getText();

				}
						
			}          
		});
		
		frameCSV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCSV.setLocationRelativeTo(null);
		frameCSV.setVisible(true);
		
		sleep();
		addHeader();	

	}
	
	public static void addData() {
		//String filePath = "D:\\Tommy\\Studia\\Studia Magisterskie\\Mgr\\Robot\\Mgr_Apka\\map_maker_data.csv";
		String filePath = nazwaPliku + ".csv";
		// first create file object for file placed at location
		// specified by filepath
		File file = new File(filePath);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file, true);
			
			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);



			// add data to csv 

			String[] data1 = { "\""+speedA+"\"", speedB, leftSensor, frontSensor, rightSensor };
			writer.writeNext(data1);

			
			// closing writer connection
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		
		createCSV();
	}

	
}
