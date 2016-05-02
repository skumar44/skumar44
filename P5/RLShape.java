package tetrisGame;

public class RLShape extends Tetromino{

	public int [][] state1;
	public int [][] state2; 
	public int [][] state3; 
	public int [][] state4; 

	public int[][] RLShape1(){
		return state1 = Tetromino.tetroRL1;
	}
	public int[][] RLShape2(){
		return state2 = Tetromino.tetroRL2;
	}
	public int[][] RLShape3(){
		return state3 = Tetromino.tetroRL3;
	}
	public int[][] RLShape4(){
		return state4 = Tetromino.tetroRL4;
	}

}
