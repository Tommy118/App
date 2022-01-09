package windows;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import controll.BasicControll;
import controll.Buttons;
//import net.miginfocom.swing.MigLayout;
import testy.PanelMapy;
import javax.swing.ScrollPaneConstants;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class UserPanel {	
	
	public static JButton btn_speedUp, btn_speedDown, btn_stop, btn_close, btn_horn, btn_lights, btn_ForwardWithSensors, btn_BackwardWithSensors;
	public static JFrame frame;
	public static JEditorPane editor = new JEditorPane();
	public static JLabel lbl_speed = new JLabel();
	public static JLabel lbl_time = new JLabel();
    public static JFormattedTextField textField_SensorFront = new JFormattedTextField();
    public static JFormattedTextField textField_SensorLeft  = new JFormattedTextField();
    public static JFormattedTextField textField_SensorRight  = new JFormattedTextField();
    public static JFormattedTextField textField_SensorGyro  = new JFormattedTextField();
    public static JFormattedTextField textField_SensorFront_1 = new JFormattedTextField();
    public static JFormattedTextField textField_SensorLeft_1  = new JFormattedTextField();
    public static JFormattedTextField textField_SensorRight_1  = new JFormattedTextField();
    public static JFormattedTextField textField_SensorGyro_1  = new JFormattedTextField();
	
			public static void main(String[] args) throws IOException {
				
				JFrame frame = new JFrame("Map Maker");
		        JPanel Zak³adkaXbox = new JPanel();
		        JPanel Zak³adkaPrzyciski = new JPanel();
				JPanel Zak³adkaMapa = new JPanel();
				FlowLayout flowLayout = (FlowLayout) Zak³adkaMapa.getLayout();
				flowLayout.setAlignment(FlowLayout.LEADING);
				JPanel Mapa = new JPanel();
				JPanel PrzyciskiLevel1 = new JPanel();
				JPanel PrzyciskiLevel2 = new JPanel();
				JPanel PrzyciskiLevel3 = new JPanel();
				JPanel PrzyciskiLevel4 = new JPanel();
				JPanel PrzyciskiLevel5 = new JPanel();
				JPanel PrzyciskiLevel6 = new JPanel();
				JPanel PrzyciskiLevel7 = new JPanel();
				JPanel PrzyciskiLevel8 = new JPanel();

				lbl_speed.setText("Aktualna prêdkoœæ: " + BasicControll.speed);
				lbl_time.setText("Aktualny czas: " + BasicControll.time + "ms");
				
				
				//frame.setSize(960, 620);
				//frame.setPreferredSize(new Dimension(960, 620));
				frame.setSize(1920, 1040);
				frame.setPreferredSize(new Dimension(1920, 1040));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);	  
				frame.getContentPane().add(editor, BorderLayout.SOUTH);
				Container contentPane = frame.getContentPane();
				
				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.setSize(1900, 1020);
		        contentPane.add(tabbedPane);
		        
		        BufferedImage myPicture = ImageIO.read(new File("src\\icons\\controller1.jpg"));
		        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		        Zak³adkaXbox.add(picLabel);
		        
		        PrzyciskiLevel1.setPreferredSize(new Dimension(1920, 100));
		        PrzyciskiLevel2.setPreferredSize(new Dimension(1920, 100));
		        PrzyciskiLevel3.setPreferredSize(new Dimension(1920, 100));
		        PrzyciskiLevel4.setPreferredSize(new Dimension(1920, 100));
		        PrzyciskiLevel5.setPreferredSize(new Dimension(1920, 100));
		        PrzyciskiLevel6.setPreferredSize(new Dimension(1920, 100));
		        PrzyciskiLevel7.setPreferredSize(new Dimension(1920, 100));
		        PrzyciskiLevel8.setPreferredSize(new Dimension(1920, 100));

				tabbedPane.addTab("Mapa", null, Mapa);
		        tabbedPane.addTab("Sterowanie za pomoc¹ pada od xboxa", null, Zak³adkaXbox);
				tabbedPane.addTab("Zak³adkaMapa", null, Zak³adkaMapa);
		        tabbedPane.addTab("Sterowanie za pomoc¹ przycisków", null, Zak³adkaPrzyciski);
		        

		        
		        //JScrollPane scrollPane = new JScrollPane(new PanelMapy());
		        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        //scrollPane.setBounds(10, 10, 1800, 900);



		        /*

				FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
				flowLayout_1.setVgap(440);
				flowLayout_1.setAlignment(FlowLayout.LEFT);
				flowLayout_1.setHgap(880);

		        */
		        Zak³adkaPrzyciski.add(PrzyciskiLevel1);
		        Zak³adkaPrzyciski.add(PrzyciskiLevel2);
		        
		        JLabel lblSensorLeft = new JLabel("Dystans strona lewa: ");
		        PrzyciskiLevel2.add(lblSensorLeft);        
		        PrzyciskiLevel2.add(textField_SensorLeft);
		        textField_SensorLeft.setColumns(10);
		        
		        JLabel lblSensorFront = new JLabel("Dsystans przód: ");
		        PrzyciskiLevel2.add(lblSensorFront);        
		        PrzyciskiLevel2.add(textField_SensorFront);
		        textField_SensorFront.setColumns(10);
		        
		        JLabel lblSensorRight = new JLabel("Dsystans strona prawa: ");
		        PrzyciskiLevel2.add(lblSensorRight);        
		        PrzyciskiLevel2.add(textField_SensorRight);
		        textField_SensorRight.setColumns(10);
		        
		        JLabel lblSensorGyro = new JLabel("K¹t robota: ");
		        PrzyciskiLevel3.add(lblSensorGyro);        
		        PrzyciskiLevel3.add(textField_SensorGyro);
		        textField_SensorGyro.setColumns(10);
		        
		        Zak³adkaPrzyciski.add(PrzyciskiLevel3);
		        Zak³adkaPrzyciski.add(PrzyciskiLevel4);
		        Zak³adkaPrzyciski.add(PrzyciskiLevel5);
		        Zak³adkaPrzyciski.add(PrzyciskiLevel6);
		        Zak³adkaPrzyciski.add(PrzyciskiLevel7);
		        Zak³adkaPrzyciski.add(PrzyciskiLevel8);

		        
				//Ikony do przycisków
				Icon speedUp = new ImageIcon("src\\icons\\speedUp2.png");
				Icon speedDown = new ImageIcon("src\\icons\\speedDown2.png");
				Icon arrowUp = new ImageIcon("src\\icons\\arrowUp.png");
				Icon arrowDown = new ImageIcon("src\\icons\\arrowDown.png");
				Icon arrowLeft = new ImageIcon("src\\icons\\arrowLeft.png");
				Icon arrowRight = new ImageIcon("src\\icons\\arrowRight.png");
				Icon arrowUpEye = new ImageIcon("src\\icons\\arrowUpEye.png");


				Icon horn = new ImageIcon("src\\icons\\horn.png");
				Icon close = new ImageIcon("src\\icons\\close.png");

				Icon timeUp = new ImageIcon("src\\icons\\timeUp.png");
				Icon timeDown = new ImageIcon("src\\icons\\timeDown.png");
				Icon pause = new ImageIcon("src\\icons\\pause.png");
				Icon scan = new ImageIcon("src\\icons\\scan.png");
				JButton btn_forward = new JButton(arrowUp);
				JButton btn_backward = new JButton(arrowDown);
				JButton btn_left = new JButton(arrowLeft);				
				JButton btn_right = new JButton(arrowRight);
				JButton btn_TimeUp = new JButton(timeUp);
				JButton btn_TimeDown = new JButton(timeDown);
				JButton btn_ForwardWithSensors = new JButton(arrowUpEye);
				JButton btn_speedUp = new JButton(speedUp);
				JButton btn_speedDown = new JButton(speedDown);


				
				
				
				//PrzyciskiLevel1.add(btn_close);
				//PrzyciskiLevel1.add(btn_horn);
				
		        PrzyciskiLevel8.add(btn_ForwardWithSensors);
		        
		        //btn_test
				Icon arrowUpDown = new ImageIcon("src\\icons\\arrowUpDown.png");
				JButton btn_test = new JButton(arrowUpDown);
		        PrzyciskiLevel8.add(btn_test);
		        btn_test.setToolTipText("btn_test btn_test btn_test");
				btn_test.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_test();
					}
				});

		        
				PrzyciskiLevel4.add(btn_forward);
				PrzyciskiLevel6.add(btn_backward);
				PrzyciskiLevel5.add(btn_left);
		        //PrzyciskiLevel5.add(btn_stop);
				PrzyciskiLevel5.add(btn_right);
				PrzyciskiLevel7.add(lbl_speed);
				PrzyciskiLevel7.add(btn_speedUp);
				PrzyciskiLevel7.add(btn_speedDown);
				PrzyciskiLevel7.add(btn_TimeUp);
				PrzyciskiLevel7.add(btn_TimeDown);
				PrzyciskiLevel7.add(lbl_time);
				frame.setFocusable(true);

				btn_ForwardWithSensors.setToolTipText("Jazda do przodu na czujnikach zbli¿eniowych");

				btn_forward.setToolTipText("Jazda do przodu");
				btn_backward.setToolTipText("Jazda do ty³u");
				btn_right.setToolTipText("Obrót w prawo");
				btn_left.setToolTipText("Obrót w lewo");
				btn_speedUp.setToolTipText("Zwiêkszenie prêdkoœci");
				btn_speedDown.setToolTipText("Zamniejszenie prêdkoœci");
				btn_TimeUp.setToolTipText("Zamniejszenie czasu w którym bêdzie jecha³ robot");
				btn_TimeDown.setToolTipText("Zwiêkszenie czasu w którym bêdzie jecha³ robot");

				

				FlowLayout flowLayout_1 = (FlowLayout) Mapa.getLayout();
				flowLayout_1.setAlignment(FlowLayout.LEFT);
				flowLayout_1.setAlignOnBaseline(true);

				
				Panel panel = new Panel();
				panel.setPreferredSize(new Dimension(1890, 940));
				Mapa.add(panel);
				//panel.setLayout(new MigLayout("", "[1450.00px][200.00,grow]", "[20px,grow][900px,grow][900px,grow]"));
				

				
				Panel panel_label1 = new Panel();
				FlowLayout fl_panel_label1 = (FlowLayout) panel_label1.getLayout();
				fl_panel_label1.setAlignment(FlowLayout.LEFT);
				panel_label1.setPreferredSize(new Dimension(1500, 20));
				panel.add(panel_label1, "cell 0 0,grow");
				
				JLabel lblNewLabel1 = new JLabel("Sekcja mapy:");
				lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				panel_label1.add(lblNewLabel1);
				lblNewLabel1.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel1.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel1.setForeground(Color.BLACK);
				lblNewLabel1.setBackground(Color.BLACK);
				
				JPanel panel_label2 = new JPanel();
				panel_label2.setVisible(false);
				panel_label2.setPreferredSize(new Dimension(440, 20));
				panel.add(panel_label2, "cell 1 0,grow");
				
				JLabel lblNewLabel2 = new JLabel("Dane z sensor\u00F3w:");
				lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
				panel_label2.add(lblNewLabel2);
				
				JScrollPane panel_mapy = new JScrollPane();

				
				panel_mapy.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
				panel_mapy.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				panel_mapy.setPreferredSize(new Dimension(1500, 900));
				panel_mapy.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				panel.add(panel_mapy, "cell 0 1 1 2,grow");
				

				panel_mapy.add(new PanelMapy());

				
				JPanel panel_sterowania = new JPanel();
				panel.add(panel_sterowania, "flowx,cell 1 2,grow");
				panel_sterowania.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_sterowania.setPreferredSize(new Dimension(440, 440));
				
				JPanel panel_lvl3 = new JPanel();
				panel_lvl3.setPreferredSize(new Dimension(380, 30));
				panel_sterowania.add(panel_lvl3);
				
				JLabel lblNewLabel3 = new JLabel("Sterowanie:");
				lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 18));
				panel_lvl3.add(lblNewLabel3);
				lblNewLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
				lblNewLabel3.setHorizontalAlignment(SwingConstants.LEFT);
				
				JPanel panel_lvl4 = new JPanel();
				panel_lvl4.setPreferredSize(new Dimension(380, 70));
				panel_sterowania.add(panel_lvl4);
				JButton btn_scan = new JButton(scan);
				btn_scan.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl4.add(btn_scan);
				btn_scan.setToolTipText("Skanuj otoczenie");
				JButton btn_stop_1 = new JButton(pause);
				btn_stop_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl4.add(btn_stop_1);
				btn_stop_1.setToolTipText("Stop");
				
				JPanel panel_lvl5 = new JPanel();
				panel_lvl5.setPreferredSize(new Dimension(380, 70));
				panel_sterowania.add(panel_lvl5);
				JButton btn_horn_1 = new JButton(horn);
				btn_horn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl5.add(btn_horn_1);
				btn_horn_1.setToolTipText("Klakson");
				
				JButton btn_close_1 = new JButton(close);
				btn_close_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl5.add(btn_close_1);
				
				btn_close_1.setToolTipText("Zamkniêcie portów");
				
				btn_close_1.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_close();
					}
				});
				
						        
								btn_horn_1.addActionListener(new ActionListener() {
									public void actionPerformed(java.awt.event.ActionEvent e) {
										Buttons.btn_horn();
									}
								});
				
				JPanel panel_danych = new JPanel();
				panel_danych.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_danych.setPreferredSize(new Dimension(440, 440));
				//panel.add(panel_4, "cell 1 1 1 2,aligny top");
				panel.add(panel_danych, "flowx,cell 1 1,grow");
				
				JPanel panel_lvl1 = new JPanel();
				panel_lvl1.setPreferredSize(new Dimension(440, 120));
				panel_danych.add(panel_lvl1);
				
				JLabel lblSensorLeft_1 = new JLabel("Dystans strona lewa: ");
				panel_lvl1.add(lblSensorLeft_1);
				lblSensorLeft_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				textField_SensorLeft_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl1.add(textField_SensorLeft_1);
				textField_SensorLeft_1.setColumns(15);
				
				JLabel lblSensorFront_1 = new JLabel("Dsystans prz\u00F3d: ");
				panel_lvl1.add(lblSensorFront_1);
				lblSensorFront_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				textField_SensorFront_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl1.add(textField_SensorFront_1);
				textField_SensorFront_1.setColumns(15);
				
				JLabel lblSensorRight_1 = new JLabel("Dsystans strona prawa: ");
				panel_lvl1.add(lblSensorRight_1);
				lblSensorRight_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				textField_SensorRight_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl1.add(textField_SensorRight_1);
				textField_SensorRight_1.setColumns(15);
				
				JPanel panel_lvl2 = new JPanel();
				panel_lvl2.setPreferredSize(new Dimension(440, 100));
				panel_danych.add(panel_lvl2);
				
				JLabel lblSensorGyro_1 = new JLabel("K\u0105t robota: ");
				panel_lvl2.add(lblSensorGyro_1);
				lblSensorGyro_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				textField_SensorGyro_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_lvl2.add(textField_SensorGyro_1);
				textField_SensorGyro_1.setColumns(15);
				
				btn_forward.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_forward();
					}
				});
				
				btn_backward.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_backward();
					}
				});
				
				btn_left.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_left();
					}
				});
				
				btn_right.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_right();
					}
				});
				
				btn_speedUp.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_speedUp();
					}
				});
				
				btn_speedDown.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_speedDown();
					}
				});
				
				
				btn_TimeUp.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_TimeUp();
					}
				});
				
				btn_TimeDown.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_TimeDown();
					}
				});
				
				btn_ForwardWithSensors.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Buttons.btn_ForwardWithSensors();
					}
				});
				
			}	
}


