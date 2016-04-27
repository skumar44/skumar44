package P5;

import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.Box;

public class GUI implements ActionListener { //using actionlistener class
	private JFrame frame; //frame
	public JMenuItem about;
	
	public static void main(String[] args){
		//GUI g = new GUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI(); //new instance of GUI
				//	window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end of main
	public GUI() {
		frame = new JFrame(); //declares frame
		JMenuBar menuB = myMenu(); //initializes bar to myMenu
		frame.add(menuB); //adds to frame
		frame.setSize(400, 400); //set dimensions of frame
		frame.setVisible(true); //make frame visible
		//myMenu();
	}//end of GUI constructor

	
	public JMenuBar myMenu(){	 
		JMenuBar  menuBar = new JMenuBar();

		  JMenu game = new JMenu("Options");
		    game.setMnemonic('o');
		    menuBar.add(Box.createHorizontalGlue());
		  JMenuItem quit = new JMenuItem("Quit the program");
		    quit.setMnemonic('q'); //Also works by clicking x in the corner
		   // quit.addActionListener(new ExitListener());
		     about = new JMenuItem("About box"); //button declaration
		     about.setEnabled(true); //make menu item clickable
		    about.setMnemonic('a');
		    about.addActionListener( this );
		    //about.addActionListener(new ResetListener());
		    JMenuItem help = new JMenuItem("Help");
		    help.setMnemonic('h');
		   // help.addActionListener(new HowtoListener());
		    //topten.addActionListener(new ScoreListener());
		    JMenuItem restart = new JMenuItem("Start/Restart the game");
		    restart.setMnemonic('r');
		    //restart.addActionListener(new ClearListener());
	    game.add(quit);
		    game.add(about);
		    game.add(help);
		    game.add(restart);
		    menuBar.add(game);
		    return menuBar;

		 }//end of menubar
	 public void actionPerformed(ActionEvent event){
		 if(event.getSource() == about){ //if about box button is clicked
			 JOptionPane.showMessageDialog(null, "Authors: Geraldine Torres, Shruthi Kumar, Josue Alvarez" + "CS 342 Project 5, April 2016", null, JOptionPane.INFORMATION_MESSAGE); 			 							 
		 }
	 }//end of actionperformed

}//end of GUI
