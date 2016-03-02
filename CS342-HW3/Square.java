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
  //this.setMargin( new Insets(1, 1, 1, 1 ));
  //this.setFocusPainted(false);
  x = newX;
  y = newY;
 }

 /**
  * Returns number of neighbors 
  * @return: number of neighboring fileds that have mines
  */
 public int getNeighors(){
  return neighborMines;
 }

 /**
  * Sets number of neighboring fileds with mines
  */
 public void setNeighbors( int newNeighbors ){
  neighborMines = newNeighbors;
 }

 /**
  * Returns true if there is mine in this square
  */
 public boolean isMine(){
  return mine;
 }

 /**
  * Sets a mine in this square
  */
 public void setMine(){
  mine = true;
 }

 /**
  * Increase number of neighboring fields with mines
  */
 public void addNeighbors(int number){
  neighborMines += number;
 }

 /**
  * Mark square as clicked
  */
 public void setPressed(){
  this.setEnabled( false );
 }

 /**
  * Check if the square was clicked
  */
 public boolean isPressed(){
  return pressed;
 }

 /**
  * Handle right click on that square
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
     //setIcon( new ImageIcon( "images/flag.gif" ) );
     // setDisabledIcon( new ImageIcon( "images/flag.gif" ) );
     //setEnabled(false);  //button is no longer clickable
     return -1;

    // mark a square with a '?'
    case 1:
     flag = 2;
   //  setEnabled( false );
     this.setIcon(QUESTIONMARK);
    //setIcon( null );
    // setText( "?" );
     //setEnabled(false);
     return +1;

    // clear '?'
    case 2:
     flag = 0;
     // setIcon( new ImageIcon( "images/unclicked.gif" ) );
      //setDisabledIcon( new ImageIcon( "images/unclicked.gif" ) );
      //setText( " " );
     this.setIcon(UNCLICKED);
     //setEnabled(true);
     return 0;

    default:
     break;
   }
  }
  return 0;
 }

 /**
  * resets a square to its initial state
  */
 public void reset(){
  setText( "" );
  flag = 0;
  mine = false;
  neighborMines = 0;
  pressed = false;
  setEnabled( true );
  this.setSelected( false );
  setIcon( null );
 }

 /**
  * Check what flag is set on a square
  */
 public int getFlag(){
  return flag;
 }

 /**
  * Get x position of this square
  */
 public int getXpos(){ 
  return x;
 }

 /**
  * Get y position of this square
  */
 public int getYpos(){
  return y;
 }

 /**
  * Handle left click on this square
  */
 public void leftClick(){
  // set the color of the number of neighbors accordingly 
  // to a number of neighbors
  if( flag == 1 || flag == 2){
   setSelected(false);
   return;
  }
   
   
  switch( neighborMines ){
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
   default:
    break;
  } 
  if( pressed ){
   setSelected(true);
   return;
  }
  // if flag is set cannot click that square
 
  else{
   setSelected( true );
   pressed = true;
   if( neighborMines == 0 ){
    this.setIcon(BLANK);
   }
  }
 }
}
