package tetrisGame;


/**
 * Class used for Factory design pattern.
 * Contains all states for the S shaped tetro
 * @author Josue
 *
 */
public class SShape extends Tetromino{

	public int [][] state1;
	public int [][] state2; 
	public int [][] state3; 
	public int [][] state4; 

	public int[][] SShape1(){
		return state1 = Tetromino.tetroS1;
	}
	public int[][] SShape2(){
		return state2 = Tetromino.tetroS2;
	}
	public int[][] SShape3(){
		return state3 = Tetromino.tetroS3;
	}
	public int[][] SShape4(){
		return state4 = Tetromino.tetroS4;
	}

}
