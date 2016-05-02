package tetrisGame;

/**
 * Class used for Factory design pattern.
 * Contains all states for the O shaped tetro
 * @author Josue
 *
 */
public class SquareShape extends Tetromino {

	public int [][] state1;
	public int [][] state2; 
	public int [][] state3; 
	public int [][] state4; 

	public int[][] squareShape1(){
		return state1 = Tetromino.tetroO1;
	}
	public int[][] squareShape2(){
		return state2 = Tetromino.tetroO2;
	}
	public int[][] squareShape3(){
		return state3 = Tetromino.tetroO3;
	}
	public int[][] squareShape4(){
		return state4 = Tetromino.tetroO4;
	}

}
