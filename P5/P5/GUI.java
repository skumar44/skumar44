package P5;

import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.Box;
//create a 2d array of squares
 
public class GUI implements ActionListener { //using actionlistener class
	static private JFrame frame; //frame
	static public JMenuItem about;
	static public JMenuItem help;  //menu items to show on menu bar on frame 
	static public JMenuItem quit;
	static public JMenuItem restart;
	static int rows = 20;
	static int cols = 10;
	int x = 3; //what is this?
	
//	square grid = new square(); //grid of squares
	static int i, j;
	/*
	for(i=0; i<20; i++){
		for(j=0; j<10; j++){
//			grid[i][j].;//set squares to black
		}
	}

	*/
	
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
		}    );
	}//end of main
	
	public GUI() {
		frame = new JFrame(); //declares frame
		Image[][] grid = new Image[20][10];
		JMenuBar menuB = myMenu(); //initializes bar to myMenu
		frame.add(menuB); //adds to frame
		frame.setSize(400, 400); //set dimensions of frame
		frame.setVisible(true); //make frame visible
		for(i=0; i<20; i++){
			for(j=0; j<10; j++){
				grid[i][j] = square.black; //make all squares in grid black
	/*error*/			contentPane().add(grid, BorderLayout.PAGE_START);
			}
		}
		
		
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
		    game.add(restart); //add items to menu bar, add menu bar to frame
		    menuBar.add(game);
		    return menuBar;

		 }//end of menubar
	 public void actionPerformed(ActionEvent event){
		 if(event.getSource() == about){ //if about box button is clicked
			 JOptionPane.showMessageDialog(null, "Authors: Geraldine Torres, Shruthi Kumar, Josue Alvarez" + "CS 342 Project 5, April 2016", null, JOptionPane.INFORMATION_MESSAGE); 			 							 
		 }
		 if(event.getSource() == help) {
			 JOptionPane.showMessageDialog(null, "Options: About box gives standard project info, Quit exits game, help explains all components and keyboard operations and start/restart is self-explanatory. Keyboard controls help you move/rotate pieces left and right.", null, JOptionPane.INFORMATION_MESSAGE);
		 }
		 if(event.getSource() == quit) {
			 System.exit(0);
		 }
		 if(event.getSource() == restart) {
			 //call a helper function
			 //set score to zero
			 //clear pieces from grid
			 //reset timer to level zero
		 }
	 }//end of actionperformed

}//end of GUI
