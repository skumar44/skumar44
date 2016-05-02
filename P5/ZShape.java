package tetrisGame;

/**
 * Class used for Factory design pattern.
 * Contains all states for the Z shaped tetro
 * @author Josue
 *
 */
public class ZShape extends Tetromino{

	public int [][] state1;
	public int [][] state2; 
	public int [][] state3; 
	public int [][] state4; 

	public int[][] ZShape1(){
		return state1 = Tetromino.tetroZ1;
	}
	public int[][] ZShape2(){
		return state2 = Tetromino.tetroZ2;
	}
	public int[][] ZShape3(){
		return state3 = Tetromino.tetroZ3;
	}
	public int[][] ZShape4(){
		return state4 = Tetromino.tetroZ4;
	}

}
