/**
 * Team: Francisco Gonzalez, Shruthi Kumar
 * NET-ID: fgonza21, skumar44
 * UIN: 679481167, 677034575
 * CS 342 HW2 - MineSweeper
 * The Square describes the information for each square in the grid.
 *
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

/**
 * Class Square.
 * Defines a square for a minefield
 */
public class Square extends JButton
{
 public final static ImageIcon BLANK = new ImageIcon("blank.GIF");
 public final static ImageIcon ONE = new ImageIcon("one.GIF");
 public final static ImageIcon TWO = new ImageIcon("two.GIF");
 public final static ImageIcon THREE = new ImageIcon("three.GIF");
 public final static ImageIcon FOUR = new ImageIcon("four.GIF");
 public final static ImageIcon FIVE = new ImageIcon("five.GIF");
 public final static ImageIcon SIX = new ImageIcon("six.GIF");
 public final static ImageIcon SEVEN = new ImageIcon("seven.GIF");
 public final static ImageIcon EIGHT = new ImageIcon("eight.GIF");
 public final static ImageIcon FLAG = new ImageIcon("flag.GIF");
 public final static ImageIcon QUESTIONMARK = new ImageIcon("bombquestion.GIF");
 public final static ImageIcon UNCLICKED = new ImageIcon("unclicked.GIF");
 boolean mine = false;
 int neighborMines = 0;
 boolean pressed = false;
 int flag = 0;
 int x;
 int y;
 
 /**
  * Constructor sets the size, insets and notes the location in the minefield
  */
 public Square(int newX, int newY){
  this.setPreferredSize(new Dimension(20,20));
  x = newX;
  y = newY;
 }

 /**
  * Input: None
  * Output: Integer 
  * Returns the valude of calling sqaures adjacent mines
  */
 public int getNeighors(){
  return neighborMines;
 }

 /**
  * Input: None
  * Output: Boolean 
  * Returns if the calling square is hiding a mine
  */
 public boolean isMine(){
  return mine;
 }

 /**
  * Input: None
  * Output: None  
  * Sets the boolean value of the calling square to true
  */
 public void setMine(){
  mine = true;
 }

 /**
  * Input: None
  * Output: Boolean 
  * Checks to see if the calling button has been clicked
  */
 public boolean isPressed(){
  return pressed;
 }

 /**
  * Input: None
  * Output: Integer
  * Handles the right click of a button by toggling through the flag, question mark, and unclicked
  */
public int rightClick()
 {
  if(!pressed)
  {
   switch( flag )
   {
    // flag a square with a 'flag'
    case 0:
     flag = 1;
     this.setIcon(FLAG);
     return -1;
    // mark a square with a '?'
    case 1:
     flag = 2;
     this.setIcon(QUESTIONMARK);
     return +1;
    // clear '?'
    case 2:
     flag = 0;
     this.setIcon(UNCLICKED);
     return 0;
    default:
     break;
   }
  }
  return 0;
 }

 /**
  * Input: None
  * Output: None
  * resets a square to an initial state if the reset button is pressed
  */
 public void reset(){
  //setText( "" );
  flag = 0;
  mine = false;
  neighborMines = 0;
  pressed = false;
  setEnabled(true);
  this.setSelected(false);
  setIcon(UNCLICKED);
 }

 /**
  * Input: None
  * Output: Int
  * returns the flag value to indicate if it has been flagged or has a question mark
  */
 public int getFlag(){
  return flag;
 }

 /**
  * Input: None
  * Output: Int
  * returns the row position of the square
  */
 public int getXpos(){ 
  return x;
 }

 /**
  * Input: None
  * Output: Int
  * returns the column position of the square
  */
 public int getYpos(){
  return y;
 }

 /**
  * Input: None
  * Output: None
  * Handles the right click of a button by toggling through the flag, question mark, and unclicked
  */
 public void leftClick(){
  if( flag == 1 || flag == 2){ // Only listen for a left click if the square is not flagged
   setSelected(false);
   pressed = false;
   return;
  }
  switch(neighborMines ){
   case 1:
    this.setIcon(ONE); 
    break;
   case 2:
    this.setIcon(TWO);
    break;
   case 3:
    this.setIcon(THREE);
    break;
   case 4:
    this.setIcon(FOUR);
    break;
   case 5:
    this.setIcon(FIVE);
    break;
   case 6:
    this.setIcon(SIX);
    break;
   case 7:
    this.setIcon(SEVEN);
    break;
   case 8:
    this.setIcon(EIGHT);
    break;
  } 
  if(pressed){
   setSelected(true);
   return;
  }
  else{
   setSelected( true );
   pressed = true;
   if( neighborMines == 0 ){
    this.setIcon(BLANK);
   }
  }
 }
}
