import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.event.*;

public class HelpPanel extends JPanel{

	//properties
	BufferedImage helpscreen = null;
	
	//methods
	public void paintComponent(Graphics g){
		//draws helpscreen
		g.drawImage(helpscreen, 0, 30, null);
	}
	
	//constructor
	public HelpPanel(){
		super();
		try{
			helpscreen = ImageIO.read(new File("helpscreen.png"));
		}catch(IOException e){
			System.out.println("Error accessing image file");
		}
	}
}
