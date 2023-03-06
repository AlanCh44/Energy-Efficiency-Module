import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.event.*;
public class LiftPanel extends JPanel implements ActionListener, ChangeListener{ 
	//properties
	//labels
	//2nd versions of labels are in the animation/image
	JLabel thetitle = new JLabel("A Person Lifting an Object");
	JLabel theforce = new JLabel("Force in N");
	JLabel themass = new JLabel("Mass in Kg");
	JLabel theforce2 = new JLabel("Force in N: ");
	JLabel themass2 = new JLabel("Mass in Kg: ");
	JLabel theheight = new JLabel("Height in m");
	JLabel theheight2 = new JLabel("h: ");
	JLabel heightvalue = new JLabel("");
	//user inputs in:
	JTextField massinput = new JTextField("");
	JTextField forceinput = new JTextField("");
	JSlider heightslider = new JSlider(SwingConstants.HORIZONTAL, 1, 100, 1); 
	//equations and explanation
	JLabel efficiency = new JLabel("% efficiency = ");
	JLabel efficiencyequation = new JLabel("% efficiency = (useful output energy/total input energy)*100%");
	JLabel efficiencyequation2 = new JLabel("% efficiency = (mgh/F*D)*100%");
	JTextArea explanation = new JTextArea("The minimum energy required to lift the object is equivalent to the total useful output of the \n person. This can be represented by mgh, where m is mass in Kg, g is gravitational \n acceleration constant (9.8m/s^2), and h is the height in meters. The input energy\n can be represented by the work equation F*D, where F is force in newtons and D is \ndisplacement in meters. The displacement is equal to the height. However, the force applied \n depends on the amount of force exterted by the person. The useful output energy is never \ngreater than total input energy, as energy is converted into multiple forms, not all of which are \nuseful. Another example would be a stove. The electrical energy is not only converted to \nheat(useful), but also light  and sound energy."); 
	//image
	BufferedImage energyimg = null;
	
	//animation variables
	int intYLeft = 280;
	int intYRight = 240;
	int intDef;
	int intObject = 200;
	int intLabel = 220;
	
	
	//methods
	public void actionPerformed(ActionEvent evt){
		double dblefficiency;
		//calculate through mass
		if(evt.getSource() == massinput && forceinput.getText()!=("")){
			double dblMass = (Double.parseDouble(massinput.getText()));
			double dblForce = (Double.parseDouble(forceinput.getText()));
			double dblHeight = heightslider.getValue()/100.0;
			dblefficiency = ((dblMass*9.8*dblHeight)/(dblForce*dblHeight))*100;
			if((dblMass*9.8*dblHeight)<(dblForce*dblHeight)){
				efficiency.setText("% efficiency = "+dblefficiency+"%");
				themass2.setText("Mass in Kg:"+Math.round(dblMass));
				theforce2.setText("Force in N:"+Math.round(dblForce));
			}else if((dblMass*9.8*dblHeight)>(dblForce*dblHeight)){
				//if values impossible, notifies user
				efficiency.setText("impossible values, please input new values");
			}
		//calculate through force
		}else if(evt.getSource() == forceinput && massinput.getText()!=("")){
			double dblMass = (Double.parseDouble(massinput.getText()));
			double dblForce = (Double.parseDouble(forceinput.getText()));
			double dblHeight = heightslider.getValue()/100.0;
			dblefficiency = ((dblMass*9.8*dblHeight)/(dblForce*dblHeight))*100;
			if((dblMass*9.8*dblHeight)<(dblForce*dblHeight)){
				efficiency.setText("% efficiency = "+dblefficiency+"%");
				themass2.setText("Mass in Kg:"+Math.round(dblMass));
				theforce2.setText("Force in N:"+Math.round(dblForce));
			}else if((dblMass*9.8*dblHeight)>(dblForce*dblHeight)){
				//if values impossible, notifies user
				efficiency.setText("impossible values, please input new values");
			}
		}
	}
	
	public void stateChanged(ChangeEvent evt){
		//slider values
		if(evt.getSource() == heightslider){
			int intValue = heightslider.getValue();
			double dblValue = intValue/100.0;
			heightvalue.setText(dblValue+" m");
			theheight2.setText("h: "+dblValue+"m");
		}
	}
	
	//animation and drawings
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 30, 420, 510);
		g.setColor(Color.WHITE);
		g.fillRect(50,130,60,240); //body
		g.fillRect(50,330,20,200); //left leg
		g.fillRect(90,330,20,200); //right leg
		g.fillOval(30,50,125,125); //head
		g.fillRect(50,intYRight,180,15); //right arm 
		g.fillRect(50,intYLeft,180,15); //left arm 
		g.setColor(Color.YELLOW);
		g.fillRect(220, intObject,100,100); //object
		g.setColor(Color.GREEN);
		//contain height label representation
		g.fillRect(335, 175, 60, 60); 
		g.setColor(Color.ORANGE);
		g.fillRect(420, 30, 660, 510);
		//informative image
		g.drawImage(energyimg, 750, 40, null);
		
		//animation movement
		if(intYRight < (238-heightslider.getValue())){
			intDef = 2;
		}else if(intYRight > 238){
			intDef = -2;
		}
		intYLeft = intYLeft + intDef;
		intYRight = intYRight + intDef;
		intObject = intObject + intDef;
		intLabel = intLabel + intDef;	
	}
	
	//constructor
	public LiftPanel(){
		super();
		
		//labels and input areas
		thetitle.setSize(200, 30);
		thetitle.setLocation(460, 30);
		add(thetitle);
		
		massinput.setSize(200, 30);
		massinput.setLocation(430, 100);
		massinput.addActionListener(this);
		add(massinput);
		
		themass.setSize(100, 30);
		themass.setLocation(640, 100);
		add(themass);
		
		themass2.setSize(100, 30);
		themass2.setLocation(225,190);
		add(themass2);
		
		heightslider.setSize(200, 50);
		heightslider.setLocation(430, 150);
		heightslider.addChangeListener(this);
		add(heightslider);
		
		theheight.setSize(100, 30);
		theheight.setLocation(640, 150);
		add(theheight);
		
		heightvalue.setSize(100, 30);
		heightvalue.setLocation(660, 170);
		add(heightvalue);
		
		theheight2.setSize(100, 30);
		theheight2.setLocation(342, 185);
		add(theheight2);
		
		forceinput.setSize(200, 30);
		forceinput.setLocation(430, 220);
		forceinput.addActionListener(this);
		add(forceinput);
		
		theforce.setSize(100, 30);
		theforce.setLocation(640, 220);
		add(theforce);
		
		theforce2.setSize(100, 30);
		theforce2.setLocation(50, 95);
		add(theforce2);
		
		efficiency.setSize(300, 30);
		efficiency.setLocation(440, 270);
		add(efficiency);
		
		//equation display and explanations
		efficiencyequation.setSize(400, 30);
		efficiencyequation.setLocation(440, 310);
		add(efficiencyequation);
		
		efficiencyequation2.setSize(400, 30);
		efficiencyequation2.setLocation(440, 350);
		add(efficiencyequation2);
		
		explanation.setSize(500, 180);
		explanation.setLocation(440, 390);
		explanation.setEnabled(false);
		add(explanation);
		
		try{
			energyimg = ImageIO.read(new File("energy.png"));
		}catch(IOException e){
			System.out.println("Unable to load image");
		}
	}
}
