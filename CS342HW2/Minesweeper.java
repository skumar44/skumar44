/**
 * Team: Francisco Gonzalez, Shruthi Kumar
 * NET-ID: fgonza21, skumar44
 * UIN: 679481167, 677034575
 * CS 342 HW2 - MineSweeper
 * The MineSweeper class displays the GUI for the game and implements all of the action listeners.
 *
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * This is the main class to run the Minesweeper program
 * It creates GUI(buttons, text areas, timer and mine counter.
 */
public class Minesweeper extends JFrame implements MouseListener, ActionListener
{
 private int rows = 10;
 private int columns = 10;
 private int mines = 10;
 private JLabel txtMinesLeft;
 private JLabel txtTime;
 private JButton restart;
 private Square [][]buttons = new Square[rows][columns];
 private boolean started = false;
 private boolean finished = false;
 private int minesLeft = mines;
 private int fieldsLeft = rows * columns - minesLeft;
 private int currentTime = 0;
 private javax.swing.Timer timer;
 private JPanel field;
 private Container cp;
 private static ArrayList<String> list = new ArrayList<String>();  

 public final static ImageIcon MINE = new ImageIcon("mine.GIF");
 public final static ImageIcon YELLOWFACE = new ImageIcon("yellowface.GIF");
 public final static ImageIcon DEADFACE = new ImageIcon("deadface.GIF");
 public final static ImageIcon SUNGLASSFACE = new ImageIcon("sunglassface.GIF");
 public final static ImageIcon UNCLICKED = new ImageIcon("unclicked.GIF");
 
 /**
  * Constructor that sets up the game board
  */
 Minesweeper(){
  Container contPane = getContentPane();
  getContentPane().setLayout(new BorderLayout());
  this.setTitle("Minesweeper");
  // Sets up the Grid Layout
  JPanel scoresPane = new JPanel(new GridLayout(2, 3, 5, 3));
  JLabel lblMinesLeft = new JLabel("Mines Left");
  lblMinesLeft.setHorizontalAlignment(JLabel.CENTER);
  scoresPane.add(lblMinesLeft);
  restart = new JButton();
  restart.setIcon(YELLOWFACE);
  restart.setPreferredSize(new Dimension(25, 25));
  restart.addMouseListener(this);
  scoresPane.add(restart);

  JLabel lblTime = new JLabel("Time");
  lblTime.setHorizontalAlignment(JLabel.CENTER);
  scoresPane.add(lblTime, 2);
  
  txtMinesLeft = new JLabel("" + minesLeft);
  txtMinesLeft.setHorizontalAlignment(JLabel.CENTER);
  txtMinesLeft.setForeground(Color.red);
  txtMinesLeft.setFont(new Font("DialogInput", Font.BOLD, 18));
  scoresPane.add(txtMinesLeft);

  scoresPane.add(new JLabel(""));
  txtTime = new JLabel("000");
  txtTime.setHorizontalAlignment(JLabel.CENTER);
  txtTime.setForeground(Color.red);
  txtTime.setFont(new Font("DialogInput", Font.BOLD, 18));
  scoresPane.add(txtTime);
  contPane.add(scoresPane, BorderLayout.NORTH);
  CreateField();

  // create timer object to measure time
  timer = new javax.swing.Timer(1000, this);
 }

 /** 
  * Input: None
  * Output: None
  * Creates the grid of buttons 
  */
 private void CreateField(){
  super.setSize((int)(21 * columns) - 11 , (int)(21.5 * rows) + 83);

  field = new JPanel(new GridLayout(rows, columns, 1, 1));
  int i, j;
  
  // double loop that crates a minefield made of buttons of type Square
  for(i = 0 ; i < rows ; i++)
   for(j = 0 ; j < columns ; j++){
    buttons[i][j] = new Square(i, j);
    buttons[i][j].setIcon(UNCLICKED);
    buttons[i][j].addMouseListener(this);
    field.add(buttons[i][j]);
   }  
  getContentPane().add(field, BorderLayout.CENTER);
 }

 /**
  * Input: None
  * Output: None
  * Resets the game
  */
 private void resetField(){
  for(int i = 0 ; i < rows ; i++)
   for(int j = 0 ; j < columns ; j++){
    buttons[i][j].reset();
   }  
  // reset all the flags and the timer
  started = false;
  finished = false;
  currentTime = 0;
  minesLeft = mines;
  fieldsLeft = rows * columns - minesLeft;
  txtMinesLeft.setText("" + minesLeft);
  txtTime.setText("00" + currentTime);
  restart.setIcon(YELLOWFACE);
 }
 
 /*private void initArray(){
  for(int i = 0; i < 10; i++){
   tt_list[i] = new Score(); 
  } 
 }*/

 /** 
  * Input: None
  * Output: None
  * randomly sets 10 squares as ones that hide mines
  */
 private void GenerateMines(){
  Random rInt = new Random();
  int rCol, rRow;
  int i, j;

  for(i = 0; i < mines; i++){
   rCol = rInt.nextInt(rows);
   rRow = rInt.nextInt(columns);
   if(!buttons[ rCol ][ rRow ].isMine() && !buttons[ rCol ][ rRow ].isSelected())
     buttons[ rCol ][ rRow ].setMine();
   else
     i--;
  }

  for(i = 0; i < rows; i++)
   for(j = 0; j < columns; j++){
    if(buttons[i][j].mine){
     if(i - 1 >= 0 && j - 1 >= 0) // upper left square
      buttons[i - 1][j - 1].neighborMines++;
     if(i - 1 >= 0 && j >= 0) // upper middle square
      buttons[i - 1][j].neighborMines++;
     if(i - 1 >= 0 && j + 1 < columns) // upper right square
      buttons[i - 1][j + 1].neighborMines++;
     if(i >= 0 && j - 1 >= 0) // middle left square
      buttons[i][j - 1].neighborMines++;
     if(i >= 0 && j + 1 < columns) // middle right square
      buttons[i][j + 1].neighborMines++;
     if(i + 1 < rows && j - 1 >= 0) // lower left square
      buttons[i + 1][j - 1].neighborMines++;
     if(i + 1 < rows && j >= 0) // lower middle square
      buttons[i + 1][j].neighborMines++;
     if(i + 1 < rows && j + 1 < columns) // lower left square
      buttons[i + 1][j + 1].neighborMines++;
    }
   }
  }
 
 /** 
  * Input: Integer time when the game was won, String player name
  * Output: None
  * Appends the winner's information to our score file
  */ 
public static void addHighScore(int timeval, String player_name) {
    try{
      String data;
      if (timeval < 10){
        data = "00" + timeval + "_" + player_name;
      }
      else if (timeval < 100){
        data = "0" + timeval + "_" + player_name;
      }
      else {
        data = timeval + "_" + player_name;
      }
      
      File file =new File("scores.txt");
      if(!file.exists()){
       file.createNewFile();
      }
      //true = append file
      FileWriter fileWritter = new FileWriter(file.getName(),true);
             BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
             bufferWritter.write(data);
             bufferWritter.close();
         
     }catch(IOException e){
      e.printStackTrace();
     }  
  }//end of addhighscore

 /** 
  * Input: None
  * Output: ArrayList
  * Adds score information from score file and adds it to an arraylist
  */ 
public static ArrayList getRawScores() {
    try{
    Scanner s = new Scanner(new File("scores.txt"));
    while (s.hasNext()){
    list.add(s.next());
    }
    s.close();
    }catch(IOException e){
      e.printStackTrace();
    }
    return list; 
  }//end of getrawscores


 /** 
  * Input: None
  * Output: ArrayList
  * Sorts arraylist of winner's information
  */ 
public static ArrayList getScores() {
     Collections.sort(list);
     return list;
  }

/** 
  * Input: None
  * Output: String
  * Generates a string from the data in the arraylist
  */ 
public static String all_one_string() {
  String s = "";
  
  ArrayList arr = getRawScores();
  getScores();
  for(int k = 0; k<10 && k<arr.size(); k++) { //for the first ten
    s = s + arr.get(k) + "\n"; 
  }
  return s;
}
 
 /** 
  * Input: None
  * Output: Menu
  * Sets all the menu items and its mnemonics
  */
 private JMenuBar myMenu(){
  JMenuBar menuBar = new JMenuBar();

  JMenu game = new JMenu("Game");
    game.setMnemonic('g');
    JMenuItem newGame = new JMenuItem("Reset");
    newGame.setMnemonic('r');
    newGame.addActionListener(new ResetListener());
    JMenuItem topten = new JMenuItem("TopTen");
    topten.setMnemonic('t');
    topten.addActionListener(new ScoreListener());
    JMenuItem clear = new JMenuItem("ClearScores");
    clear.setMnemonic('c');
    clear.addActionListener(new ClearListener());
    JMenuItem exit = new JMenuItem("eXit");
    exit.setMnemonic('x');
    exit.addActionListener(new ExitListener());
    game.add(topten);
    game.add(newGame);
    game.add(exit);
    game.add(clear);
    menuBar.add(game);
    JMenu help = new JMenu("Help");
    help.setMnemonic('h');
    JMenuItem about = new JMenuItem("About");
    about.setMnemonic('a');
    about.addActionListener(new AboutListener());
    JMenuItem howto = new JMenuItem("heLp");
    howto.setMnemonic('l');
    howto.addActionListener(new HowtoListener());
    help.add(howto);
    help.add(about);
    menuBar.add(help);
  return menuBar;
 }
 
 //Help menu item display
 public class HowtoListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0) {
      JOptionPane.showMessageDialog(
              cp,
              "How to play\n"
              + "The rules in Minesweeper are simple:\n"
              + "Uncover a mine, and the game ends.\n"
              + "Uncover an empty square, and you keep playing.\n"
              + "Uncover a number, and it tells you how many mines lay hidden in the eight surrounding squares?\n"
              + "\tinformation you use to deduce which nearby squares are safe to click.\n");
    }
  }
   //About menu item display
  public class AboutListener implements ActionListener {

    public void actionPerformed(ActionEvent arg0) {
      JOptionPane.showMessageDialog(
              cp,
              "CS 342 Homework 2 - Java implementation of Minesweeper game\n"
              + "Development Team:\n"
              + "Francisco Gonzalez - fgonza21, UIN: 679481167\n"
              + "Shruthi Kumar - skumar44, UIN: 677034575\n");
    }
  }
  //Reset menu item action
  public class ResetListener implements ActionListener {

    public void actionPerformed(ActionEvent arg0) {
      timer.stop();
      rows = 10;
      columns = 10;
      resetField();
      return;
    }
  }
  //Exit menu item action
  public class ExitListener implements ActionListener {

    public void actionPerformed(ActionEvent arg0) {
      System.exit(0);
    }
  }
  //Clear score menu item action
  public class ClearListener implements ActionListener {

    public void actionPerformed(ActionEvent arg0) {
      File f = new File("scores.txt");
      if(f.exists()){
        f.delete();
      }
    }
  }
  //Display top scores menu item action
 public class ScoreListener implements ActionListener {
  
    public void actionPerformed(ActionEvent arg0) {
      File f = new File("scores.txt");
      if(f.exists()){
        JOptionPane.showMessageDialog(cp, all_one_string());
      }
      else {
        JOptionPane.showMessageDialog(cp, "There are no top scores");
      }
    }
  }

 /** 
  * Input: Boolean
  * Output: None
  * Checks to see if the game has been ended by loss or win
  */
 private void endGame(boolean lost){
  finished = true;
  timer.stop();
  
  if(lost)
   restart.setIcon(DEADFACE);

  for(int i = 0 ; i < rows ; i++)
   for(int j = 0 ; j < columns ; j++){
    if(lost){
     if(buttons[i][j].getFlag() == 1){
      buttons[i][j].setIcon(MINE);
      buttons[i][j].setDisabledIcon(MINE);
     }

     if(buttons[i][j].isMine()){
      buttons[i][j].setIcon(MINE);
      buttons[i][j].setDisabledIcon(MINE);
     }
    }

    // if the game is won
    else{
     if(buttons[i][j].isMine()){
      buttons[i][j].setIcon(MINE);
     }
    }
   }
 }
 
 /** 
 * Input: Square
 * Output: None
 * Calls the recursive function when the a square with no mines has been clicked
 */
 private void showZeros(Square theSquare){
  int posX = theSquare.getXpos();
  int posY = theSquare.getYpos();
  checkForZeros(posX, posY);
  return;
 }

 /** 
  * Input: Int row of square, Int column of square
  * Output: None
  * Checks for all adjacent squares with no mines
  */
 private void checkForZeros(int x, int y){
  if(x < rows && y < columns && x >= 0 && y >= 0 && !buttons[x][y].isPressed()){
   buttons[x][y].leftClick();
   fieldsLeft--;

   if(buttons[x][y].getNeighors() == 0){
    checkForZeros(x - 1, y - 1);
    checkForZeros(x , y - 1);
    checkForZeros(x + 1, y - 1);
    checkForZeros(x - 1, y );
    checkForZeros(x + 1, y );
    checkForZeros(x - 1, y + 1);
    checkForZeros(x , y + 1);
    checkForZeros(x + 1, y + 1);
   }
  }
 }


 /** 
  * Input: None
  * Output: None
  * Resets the reset buttons icon
  */
 public void mousePressed(MouseEvent e){
  restart.setIcon(YELLOWFACE);
 }

 /** 
  * Input: None
  * Output: None
  * Resets the reset buttons icon
  */
 public void mouseReleased(MouseEvent e){
  restart.setIcon(YELLOWFACE);
 }

 //overrides for extended methods
 public void mouseEntered(MouseEvent e)
 {}

 public void mouseExited(MouseEvent e)
 {}

 /** 
  * Input: None
  * Output: None
  * Resets game 
  */
 public void mouseClicked(MouseEvent e){
  int button = e.getButton();
  if(e.getSource() == (JButton)restart){
   timer.stop();
   rows = 10;
   columns = 10;
   resetField();
   return;
  }

  Square sq = (Square)e.getSource();
  if(button == 1 && !finished){
   if(sq.isMine() && sq.getFlag() != 1 && sq.getFlag() != 2){
    sq.setSelected(false);
    endGame(true);    
    return;
   }

   if(!started){
    GenerateMines();
    started = true;
    timer.start();
   }

   if(!sq.isPressed() && sq.getFlag() != 1){   
    if(sq.getNeighors() == 0)
     showZeros(sq);
    else
     fieldsLeft--;
   }
   sq.leftClick();
   
  }

  else if(button == 3){
   minesLeft += sq.rightClick();
  }
  
  if(fieldsLeft == 0){
   finished = true;
   restart.setIcon(SUNGLASSFACE);
   timer.stop();
   String name = JOptionPane.showInputDialog("Congratulations!  You Won!  What is your name?");
   addHighScore(currentTime, name);
   endGame(false);
  }
  txtMinesLeft.setText("" + minesLeft);
 }

 public void actionPerformed(ActionEvent e){
  Object oSrc = e.getSource();
 
   if(oSrc == timer){
   currentTime++;
   
   if(currentTime < 10)
    txtTime.setText("00" + currentTime);
   else if(currentTime < 100)
    txtTime.setText("0" + currentTime);
   else
    txtTime.setText("" + currentTime);
  }
 }

 /**
  * Main method to start the game
  */
 public static void main(String args[]){
  JFrame.setDefaultLookAndFeelDecorated(true);
  Minesweeper msw = new Minesweeper();
  msw.setJMenuBar(msw.myMenu());
  msw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  msw.setVisible(true);
  msw.setResizable(false);  
 }//end of main
}//end of minesweeper class