package tetrisGame;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import javax.swing.border.Border;
import java.util.*;
import java.util.Timer;
import java.io.*;

public class TetrisGame extends JFrame implements ActionListener {
	
		private static MyJButton buttons[][];
	   private int totalTime = 0;
	   JLabel onesTimer, tensTimer, hundredTimer;
	   private Boolean firstButtonPush = false;
	   private JLabel timerTest;
	   private static Thread t;
	   private static Thread gameThread;
	   private JLabel userScore;
	   private int countFlag = 10;
	   private JMenuItem QuitItem, AboutItem, HelpItem, RestartItem;
	   private JPanel grid2;
	   
	   private static int Xdim;
	   private static int Ydim;
	   static BoardMechanics bm;
	   
	   private static int BLACK = 0;
	   private static int YELLOW = 1;
	   private static int CYAN = 2;
	   private static int PURPLE = 3;
	   private static int ORANGE = 4;
	   private static int BLUE = 5;
	   private static int GREEN = 6;
	   private static int RED = 7; 
		
	   private static int shape[][];
	   /**
	    * Constructor
	    */
	   public TetrisGame()
	   {
		   //Title of the Game
	      super( "Welcome to tetris!" );

	      System.out.println("Entering Minesweeper");
	      firstButtonPush = false;
		  t = new Thread(new timerThread());
		  gameThread = new Thread(new gameThread());
		  bm = new BoardMechanics();
		  Xdim = bm.boardX;
		  Ydim = bm.boardY;
		  
	      //Dropdown menu is created
	     JMenuBar dropDown = new JMenuBar();
	     dropDown.setLayout(new FlowLayout());
	     JMenu menu1 = new JMenu("Options");
	     menu1.setMnemonic(KeyEvent.VK_O);

	     QuitItem = new JMenuItem("Quit");
	     QuitItem.addActionListener(this);
	     AboutItem = new JMenuItem("About");
	     AboutItem.addActionListener(this);
	     HelpItem = new JMenuItem("Help");
	     HelpItem.addActionListener(this);
	     RestartItem = new JMenuItem("Restart");
	     RestartItem.addActionListener(this);

	     menu1.add(QuitItem);
	     menu1.add(AboutItem);
	     menu1.add(HelpItem);
	     menu1.add(RestartItem);

	     dropDown.add(menu1);
  
	     /*Creating the panel containing the Flag counter, Smiley reset button, and Timer*/
	     JPanel gridAndSmilePanel = new JPanel();
	     gridAndSmilePanel.setLayout(new BoxLayout(gridAndSmilePanel, BoxLayout.Y_AXIS));

	     gridAndSmilePanel.addKeyListener(new TKA());
	     gridAndSmilePanel.setFocusable(true);	     
	     
	     /*Reset button created*/
	      MyJButton smileyButton = new MyJButton(": )");
	      smileyButton.setNumber(100);
	 
	      /*Count up timer for how long user plays for created*/
	      timerTest = new JLabel("Your time: " + totalTime);
	      timerTest.setLayout(new FlowLayout());
	      /*Flag counter created*/
	      userScore = new JLabel("Your score: " + countFlag);
	      userScore.setLayout(new FlowLayout());
	      
	      /*Panel where the Flag counter, Smeiley reset button and Timer go onto*/
	      JPanel smileyPanel = new JPanel();
	      smileyPanel.setLayout(new FlowLayout());
	      smileyPanel.add(userScore,BorderLayout.LINE_START);
	      smileyPanel.add(smileyButton, BorderLayout.EAST);
	      smileyPanel.add(timerTest,BorderLayout.LINE_END);
	      
	      
	      /*Creating the panel for the grid of the buttons. 1D array, all of type MyJButtons*/
	      grid2 = new JPanel();
	      grid2.setLayout(new GridLayout(Xdim, Ydim));
	      /*Creating the board of MyJButtons*/

		  /*Populating board*/
  
	      buttons = new MyJButton[Xdim][Ydim];
	      for(int i = 0; i < Xdim; i++){
	    	  for(int j = 0; j < Ydim; j++){
	    		  buttons[i][j] = new MyJButton("");
	    		  buttons[i][j].setEnabled(false);
	    		  buttons[i][j].setBackground(Color.BLACK);
	    		  grid2.add(buttons[i][j]);

	    	  }
	      }
	      
	      /*Adding the two ecnompassing parts togeher onto the same container*/
	      Container container = getContentPane();
	      container.add(dropDown, BorderLayout.NORTH);
	      gridAndSmilePanel.add(smileyPanel, BorderLayout.SOUTH);
	      gridAndSmilePanel.add(grid2, BorderLayout.CENTER);
	      pack();
	      container.add(gridAndSmilePanel,BorderLayout.CENTER);
	      pack();
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);
	      setSize( 400, 400 );
	      setVisible( true );

	   } // end constructor GridLayoutDemo


	   /*This class implements the functionality of the count up clock for the game
	    * by creating a Thread so the counter can run asynchronous with program*/
	   private class timerThread implements Runnable
	   {
		   public int counter;
		 public timerThread()
		 {
			 System.out.println("Thread was Entered, inside Constructor");
	    	  counter = totalTime;
		 }
		@Override
		public void run() {
			try{
				while(true)
				{
					counter++;
					totalTime = counter;	
					timerTest.setText("Your time: " + totalTime);
					Thread.sleep(1000);

				}
			}catch(Exception e)
			{
			}
		}
	   }//End of timerThread
	   
	   
	   private class gameThread implements Runnable
	   {
		   public int counter;
		 public gameThread()
		 {
			 System.out.println("Thread was Entered, inside Constructor");
		 }
		@Override
		public void run() {
			try{
				   shape = bm.nextPiece();
				   updateGUI(bm);
				   while(true){
					   if(!bm.finishedDropping){
						   bm.movePieceDown(shape);
					   }
					   else{
						   System.out.println("Finished dropping");
						   bm.finishedDropping = false;
						   bm.finishedFirstDrop = false;
						   shape = bm.nextPiece();
					   }
						   updateGUI(bm);		   
				   }//End of operations while
			}catch(Exception e)
			{
			}
		}
	   }//End of timerThread
	   
	   
	   
	   
	   /**
	    * Give functionality of playing a new game by setting all flags and 
	    * conditions to original states.
	    */
		public void restartGame()
		{
			t.stop();
			gameThread.stop();
//			totalTime = 0;
			firstButtonPush = false;
			timerTest.setText("Your time: " + totalTime);
			t = new Thread(new gameThread());
//			MyBoard = new Board(10,10,10);
//			countFlag = 10;
			int i, j;
			for(i = 0; i < Xdim; i++){
				for(j = 0; j < Ydim; j++){
					buttons[i][j].setBackground(Color.BLACK);
					buttons[i][j].setEnabled(true);
					bm.board[i][j] = 0;
				
				}
			}
			return;
		}//End of restartGame
	   

		
	   private static boolean gameThreadFlag = true;
	   private class TKA implements KeyListener{
		   
		   public void keyPressed(KeyEvent event){
			   
			   if(event.getKeyCode() == KeyEvent.VK_UP){
				   System.out.println("Rotating in the GUI!");
				   bm.rotatePiece();;
			   }else if(event.getKeyCode() == KeyEvent.VK_LEFT){
				   bm.movePieceLeft();
			   }else if(event.getKeyCode() == KeyEvent.VK_RIGHT){
				   bm.movePieceRight();
			   }else if(event.getKeyCode() == KeyEvent.VK_DOWN){
				   //SOFT DROP implement later
			   }else if(event.getKeyCode() == KeyEvent.VK_ENTER){
				   if(gameThreadFlag){
				   gameThread.suspend();
				   t.suspend();
				   gameThreadFlag = false;
				   }
				   else{
				   gameThread.resume();
				   t.resume();
				   gameThreadFlag = true;
				   }

			   }
			   System.out.println("Exiting key event!");

		   }

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}		   
	   }

	   
	   
	 	   // handle button events by toggling between layouts
	   /**
	    * Handles hot key usage
	    */
		   public void actionPerformed( ActionEvent event )
		   {
			   //If the hot key is the HelpItem option
			   if(event.getSource() == HelpItem)
			   {
					JOptionPane.showMessageDialog(null, "Options: About box gives standard project info, Quit exits game, help explains all components and keyboard operations and start/restart is self-explanatory. Keyboard controls help you move/rotate pieces left and right.", null, JOptionPane.INFORMATION_MESSAGE);
		    		return;
			   }
			   //If the hot key is the RestartItem option
			   else if(event.getSource() == RestartItem)
			   {
	  		 	restartGame();
	  		 	t.start();
	  		 	gameThread.start();
	  		 	return;
			   }
			   //If the hot key is the QuitItem option
			   else if(event.getSource() == QuitItem)
			   {
				 System.exit(0);
				 return;
				   
			   }
			   //If the hot key is the AboutItem option
			   else if(event.getSource() == AboutItem)
			   {
				   JOptionPane.showMessageDialog(null, "Authors: Geraldine Torres, Shruthi Kumar, Josue Alvarez" + "CS 342 Project 5, April 2016", null, JOptionPane.INFORMATION_MESSAGE);
				   return;
			   }

		   }
	   
		   public static void updateGUI(BoardMechanics bm){
			   System.out.println("Updating GUI");
			   int i, j;
			   for(i = 0; i < Xdim; i++){
				   for(j = 0; j < Ydim; j++){
//					   System.out.println("num at index: " + bm.board[i][j]);
					   if(bm.board[i][j] == YELLOW || bm.board[i][j] == YELLOW + 10){
//						   System.out.println("I am yellow!!");
						   buttons[i][j].setBackground(Color.YELLOW);
					   }
					   else if(bm.board[i][j] == CYAN || bm.board[i][j] == CYAN + 10){
//						   System.out.println("I am cyan!!");
						   buttons[i][j].setBackground(Color.CYAN);
					   }
					   else if(bm.board[i][j] == PURPLE || bm.board[i][j] == PURPLE + 10){
//						   System.out.println("I am purple!!");
						   buttons[i][j].setBackground(Color.MAGENTA);
					   }
					   else if(bm.board[i][j] == ORANGE || bm.board[i][j] == ORANGE + 10){
//						   System.out.println("I am orange!!");
						   buttons[i][j].setBackground(Color.ORANGE);
					   }
					   else if(bm.board[i][j] == BLUE || bm.board[i][j] == BLUE + 10){
//						   System.out.println("I am blue!!");
						   buttons[i][j].setBackground(Color.BLUE);
					   }
					   else if(bm.board[i][j] == GREEN || bm.board[i][j] == GREEN + 10){
//						   System.out.println("I am green!!");
						   buttons[i][j].setBackground(Color.GREEN);
					   }
					   else if(bm.board[i][j] == RED || bm.board[i][j] == RED + 10){
//						   System.out.println("I am rede!!");
						   buttons[i][j].setBackground(Color.RED);
					   }
					   else{
						   buttons[i][j].setBackground(Color.BLACK);
					   }
				   }
			   }
		   }
		   
/**
* 
* Heart of the oeprations, where the GUI is made and stays in animation.
*/
	   public static void main( String args[] )
	   {
		   TetrisGame application = new TetrisGame();	
//		   BoardMechanics bm = new BoardMechanics();
		   bm.initBoard();
		   application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		   
		   t.start();
		   gameThread.start();
		   
		   /*
		   shape = bm.nextPiece();
		   updateGUI(bm);
		   while(true){
			   if(!bm.finishedDropping){
				   bm.movePieceDown(shape);
			   }
			   else{
				   System.out.println("Finished dropping");
				   bm.finishedDropping = false;
				   bm.finishedFirstDrop = false;
				   shape = bm.nextPiece();
			   }
				   updateGUI(bm);		   
		   }//End of operations while
		   
		   */
	   } 

/**
* MyJButton is an extension of JButton with a couple add fields to make checking simpler.
* Field pushed represents if a buttons was pressed or not. O for no and 1 for yes.
* Field flag represents if a button contains a flag on it
*/
	   
class MyJButton extends JButton
{
private int num;
private int flag = 0;
private int pushed;

public MyJButton (String text )
{
 super (text);
 pushed = 0;
 //setText (text);
}


public MyJButton ( String text , int n)
{
 super (text);
 num = n;
}


public void setNumber (int n)
{
 num = n;
}

public int getNumber ()
{
 return num;
}
}

	
	
	
}
