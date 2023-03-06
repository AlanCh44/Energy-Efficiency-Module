import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.event.*;

public class TechPanel extends JPanel implements ActionListener{
	
	//properties
	//general labels and progressbars(represent efficiency)
	JLabel LEDlabel = new JLabel("LED");
	JLabel incandescentlabel = new JLabel("Incandescent");
	JProgressBar ledefficiency = new JProgressBar();
	JProgressBar incandescentefficiency = new JProgressBar();
	JLabel ledefficiencylabel = new JLabel("90% efficiency");
	JLabel incandescentefficiencylabel = new JLabel("10% efficiency");
	//Input and labels that update after input
	JTextField energyoutput = new JTextField("");
	JLabel energyoutputlabel = new JLabel("Output energy in Joules");
	JLabel incandescentoutput = new JLabel("Output energy in Joules = LED output energy = ");
	JLabel ledinput = new JLabel("Input energy in Joules: ");
	JLabel incandescentinput = new JLabel("Input energy in Joules: ");
	JLabel differencelabel = new JLabel("difference"); //the difference in input energy needed to produce (output) energy: (input difference)
	//image variables
	BufferedImage ledbulb = null;
	BufferedImage incandescentbulb = null;
	BufferedImage energytable = null;
	//calculation variables
	double dblEnergyOutput;
	double dblLEDInput;
	double dblIncandescentInput;
	double dblDifference;

	//methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == energyoutput){
			//calculations
			dblEnergyOutput = Double.parseDouble(energyoutput.getText());
			dblLEDInput = Math.round(dblEnergyOutput/0.90);
			dblIncandescentInput = Math.round(dblEnergyOutput/0.10);
			dblDifference = dblIncandescentInput - dblLEDInput;
			//update labels
			ledinput.setText("Input energy in Joules: "+dblLEDInput);
			incandescentinput.setText("Input energy in Joules: "+dblIncandescentInput);
			incandescentoutput.setText("Output energy in Joules = LED output energy = "+Double.parseDouble(energyoutput.getText()));
			differencelabel.setText("The incandescent lightbulb needs "+dblDifference+" J more of input energy than the LED lightbulb to output "+Math.round(dblEnergyOutput)+" J of useful energy.");
		}
	}
	
	public void paintComponent(Graphics g){
		//draw background
		g.setColor(Color.ORANGE);
		g.fillRect(0, 30, 960, 510);
		//draw images
		g.drawImage(ledbulb, -190, 0, null);
		g.drawImage(incandescentbulb, -50, 260, null);
		g.drawImage(energytable, 570, 40, null);
	}
	
	//constructor
	public TechPanel(){
		super();
		try{
			ledbulb = ImageIO.read(new File("ledbulb.png"));
		}catch(IOException e){
			System.out.println("Error loading image file");
		}
		try{
			incandescentbulb = ImageIO.read(new File("incandescentbulb.png"));
		}catch(IOException e){
			System.out.println("Error loading image file");
		}
		
		try{
			energytable = ImageIO.read(new File("energytable.png"));
		}catch(IOException e){
			System.out.println("Error loading image file");
		}
		//LED light related
		LEDlabel.setSize(100, 30);
		LEDlabel.setLocation(300, 40);
		add(LEDlabel);
		
		ledefficiency.setSize(200, 50);
		ledefficiency.setLocation(200, 70);
		ledefficiency.setValue(90);
		add(ledefficiency);
		
		ledefficiencylabel.setSize(100, 30);
		ledefficiencylabel.setLocation(420, 80);
		add(ledefficiencylabel);
		
		energyoutput.setSize(200, 30);
		energyoutput.setLocation(200, 150);
		energyoutput.addActionListener(this);
		add(energyoutput);
		
		energyoutputlabel.setSize(200, 30);
		energyoutputlabel.setLocation(400, 150);
		add(energyoutputlabel);
		
		ledinput.setSize(200, 30);
		ledinput.setLocation(200, 200);
		add(ledinput);
		
		//incandescent light related
		incandescentlabel.setSize(150, 30);
		incandescentlabel.setLocation(275, 285);
		add(incandescentlabel);
		
		incandescentefficiency.setSize(200, 50);
		incandescentefficiency.setLocation(200, 320);
		incandescentefficiency.setValue(10);
		add(incandescentefficiency);
		
		incandescentefficiencylabel.setSize(100, 30);
		incandescentefficiencylabel.setLocation(420, 325);
		add(incandescentefficiencylabel);
		
		incandescentoutput.setSize(500, 30);
		incandescentoutput.setLocation(200,395);
		add(incandescentoutput);
		
		incandescentinput.setSize(200, 30);
		incandescentinput.setLocation(200, 435);
		add(incandescentinput);
		
		//difference in input energy label
		differencelabel.setSize(800, 30);
		differencelabel.setLocation(200, 475);
		add(differencelabel);
	}
}
