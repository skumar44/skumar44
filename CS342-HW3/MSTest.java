/**
 * Team: Francisco Gonzalez, Shruthi Kumar
 * NET-ID: fgonza21, skumar44
 * UIN: 679481167, 677034575
 * CS 342 HW2 - MineSweeper
 * The MineSweeper class displays the GUI for the game and implements all of the action listeners.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class MSTest {
  Minesweeper msw = new Minesweeper();
  Square sq = new Square(2, 2);
  Square sq2 = new Square(3, 3);
  boolean testIsMine = false;

 
  @Test
    public void testIsMine() {
      boolean isMine = sq.isMine();  //variable only used for this test case
      sq.setMine();
        assertEquals("testIsMine(): ", testIsMine, isMine); //This test should fail because we set the square to a mine
        assertEquals("testIsMine(): ", true, isMine); //This test should succeed and not print anything
    }//end of testisMine
  
  @Test
    public void testSetMine() {
      sq2.setMine();
      boolean isMin2 = sq2.isMine();  //variable only used for this test case
        assertEquals("testSetMine(): ", testIsMine, isMin2);  //This test should fail because we set the square to a mine
        assertEquals("testSetMine(): ", true, isMin2);  //This test should succeed and not print anything
    }//end of setMine
  
  @Test
    public void testgetNeighbors() {
    int testgetNeighbors = 18;  //variables only used for this test case
    int neighbors = sq.neighborMines;
        assertEquals("testgetNeighbors(): ", testgetNeighbors, neighbors); //This test should fail because a square cannot neighbor 18 mines
        assertEquals("testgetNeighbors(): ", 1, neighbors);  //This test should succeed because we know the square neighbors a mine
    }//end of testgetNeighbors
  
  @Test
    public void testSquare() {
    int testSquare = 3;  //variables only used for this test case
    int xval = sq.x;
    int yval = sq.y;
        assertEquals("testSquare(2,2): ", testSquare, xval); //This test should fail because the xval should be 3
        assertEquals("testSquare(2,2): ", 2, xval);  //This test should succeed because we know the xval should be 2
        assertEquals("testSquare(2,2): ", 2, yval);  //This test should succeed because we know the yval should be 2
    }//end of testSquare
  
  @Test
    public void testisPressed() {
      boolean isPressed = sq.isPressed();  //Variables used for this test
      boolean testisPressed = false;
        sq.setPressed();
        assertEquals("testisPressed(): ", testisPressed, isPressed);  //This test should fail because pressed should be true
        assertEquals("testisPressed(): ", true, sq.pressed);  //This test should succeed because pressed should be true
    }//end of testisPressed 
    
  @Test
    public void testreset() {
      int fflag = 1; //variable for this test case
        assertEquals("testreset(): ", fflag, sq.flag);  //This test case should fail because the flag starts at 0
        assertEquals("testreset(): ", 0, sq.flag);  //This test should succeed because the flag starts at 0
        assertEquals("testreset(): ", false, sq.mine);  //This test should succeed because a square starts off as not a mine
    }//end of testreset
  
  @Test
    public void testgetFlag() {
      int testgetFlag = 5;  //variable for this test case
      int getFlag = sq.getFlag();
        assertEquals("testgetFlag(): ", testgetFlag, getFlag);  //This test should fail because the flag goes from 0-2.  5 is out of range
        assertEquals("testgetFlag(): ", 0, sq.flag);  //This test should succeed because we set the flag should be 0
    }//end of testgetFlag
   
  @Test
    public void testgetXpos() {
      int testgetXpos = 33;  //variables for this test case
      int getXpos = sq.x;
        assertEquals("testgetXpos(): ", testgetXpos, getXpos);  //This test should fail because 33 is out of range
        assertEquals("testgetXpos(): ", 2, getXpos);  //This test should succeed because we set the position to 2
    }//end of testgetXpos
  
  @Test
    public void testgetYpos() {
      int testgetYpos = 18;  //variable for this test case
      int getYpos = sq.y;
        assertEquals("testgetYpos(): ", testgetYpos, getYpos);  //This test should fail because 18 is out of range
        assertEquals("testgetYpos(): ", 2, getYpos);  //This test should succeed because we set the position to 2
    }//end of testgetYpos 
  
  @Test
    public void testRightClick() {
      sq.rightClick();
        assertEquals("testRightClick(): ", 0, sq.flag);  //This test should fail because 18 is out of range
        assertEquals("testRightClick(): ", 1, sq.flag);  //This test should succeed because we set the position to 2
    }//end of testRightClick 
   
  @Test
    public void testLeftClick() {
      sq.leftClick();
        assertEquals("testLeftClick(): ", false, sq.pressed);  //This test should fail because we just called leftClick
        assertEquals("testLeftClick(): ", true, sq.pressed);  //This test should succeed because we just called leftClick
    }//end of testgetYpos 
  
  @Test
    public void testResetGame() {
      msw.resetField();
        assertEquals("testResetGame(): ", 100, msw.currentTime); //The current time should be 0 so this test case should fail
        assertEquals("testResetGame(): ", 0, msw.currentTime); //The current time should be 0 so this test case should succeed
    }//end of testResetGame
  
  @Test
    public void testCreateField() {
      msw.resetField();
        assertNotNull("testCreateField(): does not exist", msw.field); //This test should fail because the field should exist
        assertNull("testCreateField(): exists", msw.field); //This test should succeed because the field should exist
    }//end of testCreateField()*/
  
  @Test
    public void testGenerateMines() {
      msw.GenerateMines();
        assertEquals("testGenerateMines(): ", 33, msw.mines); //This test should fail because 33 is out of range
        assertEquals("testGenerateMines(): ", 10, msw.mines); //This test should succeed because there should always be 10 mines
    }//end of testGenerateMines()*/
  
  @Test
    public void testmyMenu() {
      msw.myMenu();
        assertNotNull("testmyMenu(): does not exist", msw.menuBar); //This test should fail because the menu should exist
        assertNull("testmyMenu(): exists ", msw.menuBar); //This test should succeed because the menu should exist
    }//end of testmyMenu()*/
}