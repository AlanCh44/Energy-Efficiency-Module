//Created by Alan Chan
//Version 1.00
//Date: November 3, 2021

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class AlanEnergyEfficieny implements ActionListener{ 
	//properties
	JFrame theframe = new JFrame("Energy Efficiency Module");
	//different panels
	LiftPanel liftpanel = new LiftPanel();
	TechPanel techpanel = new TechPanel();
	AboutPanel about = new AboutPanel();
	TestPanel test = new TestPanel();
	HelpPanel help = new HelpPanel();
	
	//menu
	JMenuBar themenubar = new JMenuBar();
	JMenu themenu = new JMenu("% Efficiency Modules");
	JMenuItem liftmenu = new JMenuItem("Human lift example");
	JMenuItem electronicmenu = new JMenuItem("Electronic example");
	JMenuItem helpmenu = new JMenuItem("Help");
	JMenuItem aboutmenu = new JMenuItem("About");
	JMenuItem testmenu = new JMenuItem("Test");
	Timer thetimer = new Timer(1000/48, this);
	
	//methods
	public void actionPerformed(ActionEvent evt){
		//lift module
		if(evt.getSource() == liftmenu){
			theframe.setContentPane(liftpanel);
			theframe.pack();
			liftpanel.add(themenubar);
		//help menu
		}else if(evt.getSource() == helpmenu){
			theframe.setContentPane(help);
			theframe.pack();
			help.add(themenubar);
		//about menu
		}else if(evt.getSource() == aboutmenu){
			theframe.setContentPane(about);
			theframe.pack();
			about.add(themenubar);
		//testing module
		}else if(evt.getSource() == testmenu){
			theframe.setContentPane(test);
			theframe.pack();
			test.add(themenubar);
		}else if(evt.getSource() == electronicmenu){
			theframe.setContentPane(techpanel);
			theframe.pack();
			techpanel.add(themenubar);
		}
		if(evt.getSource() == thetimer){
			liftpanel.repaint();
		}
	}
	
	//constructor
	public AlanEnergyEfficieny(){
		liftpanel.setLayout(null);
		about.setLayout(null);
		test.setLayout(null);
		help.setLayout(null);
		techpanel.setLayout(null);
		
		//menu setup
		themenubar.setSize(275, 30);
		themenubar.setLocation(0, 0);
		themenubar.add(themenu);
		themenubar.add(helpmenu);
		themenubar.add(aboutmenu);
		themenubar.add(testmenu);
		themenu.add(liftmenu);
		themenu.add(electronicmenu);
		testmenu.addActionListener(this);
		aboutmenu.addActionListener(this);
		helpmenu.addActionListener(this);
		liftmenu.addActionListener(this);
		electronicmenu.addActionListener(this);
		liftpanel.add(themenubar);
		
		thetimer.start();
		
		//basic setup
		liftpanel.setPreferredSize(new Dimension(960, 540));
		about.setPreferredSize(new Dimension(960, 540));
		test.setPreferredSize(new Dimension(960, 540));
		help.setPreferredSize(new Dimension(960, 540));
		techpanel.setPreferredSize(new Dimension(960, 540));
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setContentPane(liftpanel);
		theframe.pack();
		theframe.setResizable(false);
		theframe.setVisible(true);
	}
	
	//main method
	public static void main(String[] args){
		new AlanEnergyEfficieny();
	}
}
