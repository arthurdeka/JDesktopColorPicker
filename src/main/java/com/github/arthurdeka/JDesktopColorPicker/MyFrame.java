package com.github.arthurdeka.JDesktopColorPicker;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.File;
import java.io.IOException;


public class MyFrame extends JFrame {
	
	JLabel label;
	
	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("src/main/resources/cursor.png").getImage(),
				new Point(0,0),
				"Custom cursor"));

		
		label = new JLabel();
		
		captureScreen("src/main/resources/teste.png");
		ImageIcon image = new ImageIcon("src/main/resources/teste.png");
		
		label.setIcon(image);
		
		this.add(label);
		this.setVisible(true);
	}
	
	public void captureScreen(String fileName) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		try {
			ImageIO.write(image, "png", new File(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	}
	
}
 