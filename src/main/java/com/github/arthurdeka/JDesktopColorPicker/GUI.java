package com.github.arthurdeka.JDesktopColorPicker;


import javax.swing.JFrame;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUI extends JFrame implements ActionListener {
	
	JButton pickColorButton;
	
	GUI() {
		
		// import FlatLaf look and Feel
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JDesktopColorPicker");
		this.setSize(250, 500);
		this.setLayout(null);
		this.setResizable(false);
		
		pickColorButton = new JButton("Pick Color");
		pickColorButton.setBounds(17, 350, 200, 100);
		pickColorButton.setFocusable(false);
		pickColorButton.addActionListener(this);
		
		
		this.add(pickColorButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==pickColorButton) {
			new PickColor();
			this.dispose();
		}
		
	}
	
	
}
