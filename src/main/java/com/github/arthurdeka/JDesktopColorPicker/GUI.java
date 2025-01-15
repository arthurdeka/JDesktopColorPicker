package com.github.arthurdeka.JDesktopColorPicker;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

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
		this.setSize(630, 250);
		this.setLayout(null);
		//this.setResizable(false);
		
		pickColorButton = new JButton("Pick Color");
		pickColorButton.setBounds(450, 150, 150, 40);
		pickColorButton.setFocusable(false);
		pickColorButton.addActionListener(this);

		JColorChooser chooser = new JColorChooser();
		// remove other panels from JColorChooser
		AbstractColorChooserPanel[] panels=chooser.getChooserPanels();
        for(AbstractColorChooserPanel p:panels){
            String displayName=p.getDisplayName();
            switch (displayName) {
                case "RGB":
                	chooser.removeChooserPanel(p);
                    break;
                case "HSL":
                	chooser.removeChooserPanel(p);
                    break;
                case "CMYK":
                	chooser.removeChooserPanel(p);
                    break;
                case "Swatches":
                	chooser.removeChooserPanel(p);
                	break;
            }
        }
		chooser.setBounds(-20,-130,650,550);
		
		
		this.add(pickColorButton);
		this.add(chooser);
		//this.add(pickColorButton);
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
