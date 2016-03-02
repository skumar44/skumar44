/**
 * Team: Francisco Gonzalez, Shruthi Kumar
 * NET-ID: fgonza21, skumar44
 * UIN: 679481167, 677034575
 * CS 342 HW2 - MineSweeper
 * The MineSweeper class displays the GUI for the game and implements all of the action listeners.
 *
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Tester {

 public static void main(String[] args) {

  Result result = JUnitCore.runClasses( MSTest.class );
  for (Failure fail : result.getFailures()) {
   System.out.println(fail.toString());
  }
  if (result.wasSuccessful()) {
   System.out.println("All tests finished successfully...");
  }
 }
}