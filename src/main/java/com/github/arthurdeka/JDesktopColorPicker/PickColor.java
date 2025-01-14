package com.github.arthurdeka.JDesktopColorPicker;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.File;
import java.io.IOException;


public class PickColor extends JFrame implements MouseListener {
	
	JLabel label;
	
	PickColor() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
		this.addMouseListener(this);
		
		
		// creates custom cursor for picking the color
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("src/main/resources/cursor.png").getImage(),
				new Point(0,0),
				"Custom cursor"));

		
		captureScreen("src/main/resources/teste.png");
		ImageIcon image = new ImageIcon("src/main/resources/teste.png");

		label = new JLabel();
		label.setIcon(image);
		
		this.add(label);
		this.setVisible(true);
		
		this.setBounds(0, 00, 500, 500);
	}
	
	/**
	 * This method takes an screenshot of the user's screen
	 * 
	 * @param fileName Name of the file (screenshot) to be saved. 
	 */
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
	
	/** Returns the color of a pixel based on its location on screen
	 * 
	 * @param x The x position of the pixel
	 * @param y The y position of the pixel
	 * @return Color
	 */
	public Color getPixelColor(int x, int y) throws AWTException {
	    Robot robot = new Robot();
	    return robot.getPixelColor(x, y);
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// will retrieve the color of the point of where the mouse was clicked.
		System.out.println("Clicked!");
		
		Color pixelColor = null;
		try {
			pixelColor = getPixelColor(e.getXOnScreen(), e.getYOnScreen());
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("The color is: " + pixelColor);
	    
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
 