import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.Box;
//create a 2d array of squares
 
public class GUI extends JPanel implements ActionListener { //using actionlistener class
	static private JFrame frame; //frame
	static public JMenuItem about;
	static public JMenuItem help;  //menu items to show on menu bar on frame 
	static public JMenuItem quit;
	static public JMenuItem restart;
	static public Container container;
	static public GridLayout board;
	public JPanel panel;
	public JButton[][] grid;
	static int rows = 20;
	static int cols = 10;	
	static int i, j;
	
	public GUI() {
		frame = new JFrame(); //declares frame
		this.setLayout(new GridLayout(20, 10));
		grid = new JButton[rows][cols];
		//panel = new JPanel(new GridLayout(20, 10));
		setButtons();
		JMenuBar menuB = myMenu(); //initializes bar to myMenu
		frame.add(menuB); //adds to frame
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(400, 400); //set dimensions of frame
		frame.setVisible(true); //make frame visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//end of GUI constructor
	
	public void setButtons(){
	int i, j;
		for (i=0; i < rows; i++)
			for (j=0; j < cols; j++){
				grid[i][j].setBackground(Color.BLACK);//make all squares in grid black
				grid[i][j].setOpaque(true);
				this.add(grid[i][j]);
			}
	}
	
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
		 else if(event.getSource() == help) {
			 JOptionPane.showMessageDialog(null, "Options: About box gives standard project info, Quit exits game, help explains all components and keyboard operations and start/restart is self-explanatory. Keyboard controls help you move/rotate pieces left and right.", null, JOptionPane.INFORMATION_MESSAGE);
		 }
		 else if(event.getSource() == quit) {
			 System.exit(0);
		 }
		 else if (event.getSource() == restart) {
			 //call a helper function
			 //set score to zero
			 //clear pieces from grid
			 //reset timer to level zero
		 }
	 }//end of actionperformed

}//end of GUI
