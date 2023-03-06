import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.event.*;

public class TestPanel extends JPanel implements ActionListener{
	//properties
	//title
	JLabel testlabel = new JLabel("True or False Test");
	//questions 1-4
	JLabel q1label = new JLabel("Energy can be destroyed.");
	JLabel q2label = new JLabel("No mechanical energy transfer system can be 100% efficient.");
	JLabel q3label = new JLabel("Energy can be converted to different forms.");
	JLabel q4label = new JLabel("There is a set amount of energy in the universe.");
	JLabel truelabel = new JLabel("TRUE");
	JLabel falselabel = new JLabel("FALSE");
	//checkboxes
	JCheckBox q1true = new JCheckBox();
	JCheckBox q2true = new JCheckBox();
	JCheckBox q3true = new JCheckBox();
	JCheckBox q4true = new JCheckBox();
	JCheckBox q1false = new JCheckBox();
	JCheckBox q2false = new JCheckBox();
	JCheckBox q3false = new JCheckBox();
	JCheckBox q4false = new JCheckBox();
	//checkscores
	JButton checkbutton = new JButton("Check Answers");
	JLabel thescore = new JLabel("Score: ");
	//variables for file recording
	JTextField nameinput = new JTextField("");
	JLabel namelabel = new JLabel("Enter your name: ");
	JLabel scoreprogress = new JLabel("");
	int intScore = 0;
	PrintWriter scores = null;
	
	//methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == checkbutton){
			intScore = 0;
			//checking answers and updating score
			if(q1false.isSelected() == true && q1true.isSelected()== false){
				intScore = intScore+1;
			}
			if(q2true.isSelected() == true && q2false.isSelected() == false){
				intScore = intScore +1;
			}
			if(q3true.isSelected() == true && q3false.isSelected() == false){
				intScore = intScore + 1;
			}
			if(q4true.isSelected() == true && q4false.isSelected() == false){
				intScore = intScore + 1;
			}
			thescore.setText("Score: "+intScore);
		//recording score to file
		}else if(evt.getSource() == nameinput){
			scores.println("Name: "+nameinput.getText()+"  Score: "+intScore);
			scoreprogress.setText("Uploaded name and score to file");
			scores.close();
		}
	}
	
	//constructor
	public TestPanel(){
		super();
		
		//general labels
		setSize(960, 540);
		testlabel.setSize(200, 30);
		testlabel.setLocation(40, 30);
		add(testlabel);
		
		
		truelabel.setSize(100, 30);
		truelabel.setLocation(400, 50);
		add(truelabel);
		
		falselabel.setSize(100, 30);
		falselabel.setLocation(500, 50);
		add(falselabel);
		
		//questions and checkboxes
		q1label.setSize(400, 30);
		q1label.setLocation(10, 70);
		add(q1label);
		
		q1true.setSize(25, 25);
		q1true.setLocation(405, 70);
		add(q1true);
		
		q1false.setSize(25, 25);
		q1false.setLocation(505, 70);
		add(q1false);
		
		q2label.setSize(400, 30);
		q2label.setLocation(10, 100);
		add(q2label);
		
		q2true.setSize(25, 25);
		q2true.setLocation(405, 100);
		add(q2true);
		
		q2false.setSize(25, 25);
		q2false.setLocation(505, 100);
		add(q2false);
		
		q3label.setSize(400, 30);
		q3label.setLocation(10, 130);
		add(q3label);
		
		q3true.setSize(25, 25);
		q3true.setLocation(405, 130);
		add(q3true);
		
		q3false.setSize(25, 25);
		q3false.setLocation(505, 130);
		add(q3false);
		
		q4label.setSize(400, 30);
		q4label.setLocation(10, 160);
		add(q4label);
		
		q4true.setSize(25, 25);
		q4true.setLocation(405, 160);
		add(q4true);
		
		q4false.setSize(25, 25);
		q4false.setLocation(505, 160);
		add(q4false);
		
		//scoring and file
		checkbutton.setSize(200, 60);
		checkbutton.setLocation(105, 220);
		checkbutton.addActionListener(this);
		add(checkbutton);
		
		thescore.setSize(150, 30);
		thescore.setLocation(455, 220);
		add(thescore);
		
		nameinput.setSize(200, 30);
		nameinput.setLocation(180, 300);
		nameinput.addActionListener(this);
		add(nameinput);
		
		namelabel.setSize(125, 30);
		namelabel.setLocation(55, 300);
		add(namelabel);
		
		scoreprogress.setSize(200, 30);
		scoreprogress.setLocation(55, 330);
		add(scoreprogress);
		
		try{
			scores = new PrintWriter(new FileWriter("Scores.txt", true));
		}catch(IOException e){
			System.out.println("File access error");
		}	
	}
}
