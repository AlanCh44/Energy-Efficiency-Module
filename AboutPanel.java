import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class AboutPanel extends JPanel{
	//properties
	JTextArea abouttext = new JTextArea("This program was created by Alan Chan, a grade 12 student in a St.Augustine CHS Computer Science class. \n The program is an interactive demonstration of the grade 11 physics concept, energy efficiency. "); 
	BufferedImage stalogo = null;
	BufferedImage titans = null;
	
	//methods
	public void paintComponent(Graphics g){
		//adding St. Augustine images
		g.drawImage(stalogo, 0, 100, null);
		g.drawImage(titans, 600, 100, null);
	}
	
	//constructor
	public AboutPanel(){
		super();
		try{
			stalogo = ImageIO.read(new File("stalogo.png"));
		}catch(IOException e){
			System.out.println("Unable to load image");
		}
		try{
			titans = ImageIO.read(new File("titans.png"));
		}catch(IOException e){
			System.out.println("Unable to load image");
		}
		setSize(960, 540);
		
		abouttext.setSize(600,40);
		abouttext.setLocation(0,30);
		//prevent textarea edit by user
		abouttext.setEnabled(false);
		add(abouttext);	
	}
}
